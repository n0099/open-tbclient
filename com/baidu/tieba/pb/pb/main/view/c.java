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
    private ImageView aeb;
    public TextView dIt;
    public final View efZ;
    private ImageView fjF;
    public TextView jFO;
    public View jFP;
    private final ImageView jFQ;
    private final LinearLayout jFR;
    public LinearLayout jFS;
    public BarImageView jFT;
    private PopupWindow jFX;
    private int jFY;
    private int jFZ;
    private int jGa;
    private int jGb;
    private PbFragment jpW;
    public String mForumName;
    public final NavigationBar mNavigationBar;
    private Runnable runnable;
    private final int jFN = 6;
    private boolean jBh = false;
    private AlertDialog jFU = null;
    private y jFV = null;
    private boolean jFW = false;
    private boolean jGc = true;
    private Runnable hyK = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.bVZ();
        }
    };
    private View.OnClickListener hyL = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.cCg();
        }
    };

    public c(PbFragment pbFragment, View view) {
        this.jFY = 0;
        this.jFZ = 0;
        this.jGa = 0;
        this.jGb = 0;
        this.jpW = pbFragment;
        this.jFY = l.getDimens(pbFragment.getContext(), R.dimen.ds88);
        this.jFZ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds14);
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        this.jGa = ((int) (equipmentWidth * 0.07d)) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds102);
        if (this.jGa - dimens > 0) {
            this.jGa -= dimens;
        }
        this.jGb = (equipmentWidth - (this.jGa * 2)) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds89);
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                c.this.jpW.bOS();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.efZ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbFragment.haG);
        this.jFO = this.mNavigationBar.setCenterTextTitle("");
        this.jFQ = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.jFR = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        this.jFR.setPadding(dimens2, 0, dimens2, 0);
        am.setNavbarIconSrc(this.jFQ, R.drawable.icon_pb_play_small, R.drawable.icon_pb_play_small);
        this.jFQ.setVisibility(8);
        this.jFO.setOnClickListener(pbFragment.haG);
        this.jFQ.setOnClickListener(pbFragment.haG);
        this.fjF = (ImageView) this.efZ.findViewById(R.id.widget_navi_back_button);
        if (this.jFS == null) {
            this.jFS = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.nav_fourm_title_layout, (View.OnClickListener) null);
            this.jFT = (BarImageView) this.jFS.findViewById(R.id.pb_nav_title_forum_image);
            this.jFT.setShowOval(true);
            this.jFT.setOnClickListener(pbFragment.haG);
            this.dIt = (TextView) this.jFS.findViewById(R.id.pb_nav_title_forum_name);
            this.dIt.setOnClickListener(pbFragment.haG);
            if (this.jFS.getLayoutParams() != null && (this.jFS.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.jGa > 0 && this.jGb > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jFS.getLayoutParams();
                marginLayoutParams.leftMargin = this.jGa;
                marginLayoutParams.rightMargin = this.jGa;
                this.jFS.setLayoutParams(marginLayoutParams);
            }
            if (this.jFS.getVisibility() == 8) {
                this.jFS.setVisibility(0);
            }
            if (this.jFS.getAlpha() != 1.0f) {
                this.jFS.setAlpha(1.0f);
            }
        }
    }

    public void rN(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.jBh = z;
        if (this.jFP == null && this.aeb == null) {
            this.jFP = this.mNavigationBar.addCustomView(controlAlign, R.layout.nb_item_floor_more, this.jpW.haG);
            this.aeb = (ImageView) this.jFP.findViewById(R.id.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.jFY, this.jFY);
            layoutParams.rightMargin = this.jFZ;
            this.jFP.setLayoutParams(layoutParams);
            SvgManager.aOR().a(this.aeb, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.jFP.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void rt(boolean z) {
        if (this.jFP != null) {
            this.jFP.setVisibility(z ? 0 : 8);
        }
    }

    public NavigationBar cBY() {
        return this.mNavigationBar;
    }

    public void rO(boolean z) {
        if (z) {
            this.efZ.setVisibility(0);
        } else {
            this.efZ.setVisibility(8);
        }
        rQ(z);
    }

    public void FF(String str) {
        if (!TextUtils.isEmpty(str) && !this.jBh) {
            this.jFO.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            rQ(true);
            i.aIc().setForumNameForWaterImage(str);
            return;
        }
        rQ(false);
    }

    public void a(z zVar) {
        if (!this.jpW.getBaseFragmentActivity().isProgressBarShown()) {
            this.jFV = new y(this.jpW, this.jpW.haG);
            this.jFU = new AlertDialog.Builder(this.jpW.getContext(), R.style.DialogTheme).create();
            this.jFU.setCanceledOnTouchOutside(true);
            g.showDialog(this.jFU, this.jpW.getFragmentActivity());
            Window window = this.jFU.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.jFV.getView());
            this.jFV.rj(zVar == null ? false : zVar.jxU);
            this.jFV.rk(zVar == null ? false : zVar.jxY);
            this.jFV.rl(zVar == null ? false : zVar.jyc);
            this.jFV.rm(zVar == null ? false : zVar.jxZ);
            this.jFV.rn(zVar == null ? true : zVar.jxW);
            if (zVar == null) {
                this.jFV.ab(false, false);
                this.jFV.ac(false, false);
            } else {
                this.jFV.ab(zVar.jya, zVar.jyg);
                this.jFV.ac(zVar.jyb, zVar.jyf);
            }
            boolean z = zVar == null ? false : zVar.DC;
            boolean z2 = zVar == null ? false : zVar.isHostOnly;
            boolean z3 = zVar == null ? false : zVar.jxX;
            boolean z4 = zVar == null ? false : zVar.jxV;
            boolean z5 = zVar == null ? false : zVar.jye;
            boolean z6 = zVar == null ? false : zVar.jyd;
            this.jFV.aa(z3, z2);
            this.jFV.ad(z4, z);
            this.jFV.ae(z6, z5);
            if (zVar != null) {
                this.jFV.jxR = zVar.jyh;
                if (zVar.jyh) {
                    this.jFV.czI().setText(R.string.report_text);
                    this.jFV.rm(false);
                }
            }
            cBZ();
        }
    }

    private void cBZ() {
        if (this.jFV != null) {
            this.jFV.czO();
        }
    }

    public void aAi() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.jFU != null) {
                        g.dismissDialog(c.this.jFU, c.this.jpW.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.lb().postDelayed(this.runnable, 100L);
    }

    public void cCa() {
        if (this.jFU != null) {
            g.dismissDialog(this.jFU, this.jpW.getPageContext().getPageActivity());
        }
    }

    public y cCb() {
        return this.jFV;
    }

    public View cCc() {
        return this.jFQ;
    }

    public boolean cCd() {
        return this.jFU != null && this.jFU.isShowing();
    }

    public void releaseResources() {
        if (this.jFV != null) {
            this.jFV.release();
        }
        this.jFU = null;
        this.jFV = null;
        e.lb().removeCallbacks(this.runnable);
    }

    public void cCe() {
        if (this.jFP != null) {
            this.jFP.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.jpW.getPageContext(), i);
            am.setBackgroundResource(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
        }
        SvgManager.aOR().a(this.fjF, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aOR().a(this.aeb, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setNavbarTitleColor(this.jFO, R.color.cp_cont_b, R.color.s_navbar_title_color);
        am.setViewTextColor(this.dIt, (int) R.color.cp_cont_b);
        cBZ();
    }

    public void zQ(int i) {
        this.mNavigationBar.onChangeSkinType(this.jpW.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha85));
        if (this.aeb != null) {
            SvgManager.aOR().a(this.aeb, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.jFO.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_cont_g));
        SvgManager.aOR().a(this.fjF, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void cCf() {
        this.fjF.setVisibility(0);
        rQ(false);
        if (this.jFP != null) {
            this.jFP.setVisibility(8);
        }
    }

    public void rP(boolean z) {
        this.fjF.setVisibility(0);
        rQ(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.jFP != null) {
                this.jFP.setVisibility(0);
            }
        } else if (this.jFP != null) {
            this.jFP.setVisibility(8);
        }
    }

    public void rQ(boolean z) {
        if (!this.jBh && z && !"".equals(this.jFO.getText().toString())) {
            this.jFO.setVisibility(0);
        } else {
            this.jFO.setVisibility(8);
        }
    }

    public void rR(boolean z) {
        this.jFW = z;
    }

    public void cAK() {
        if ((!this.jFW || TbadkCoreApplication.isLogin()) && !com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean(SharedPrefConfig.SHOW_SHARE, false)) {
            View inflate = LayoutInflater.from(this.jpW.getPageContext().getContext()).inflate(R.layout.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.arrow_up);
            TextView textView = (TextView) inflate.findViewById(R.id.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.gravity = 5;
            if (!TbadkCoreApplication.isLogin()) {
                layoutParams.rightMargin = l.getDimens(this.jpW.getContext(), R.dimen.ds28);
            } else {
                layoutParams.rightMargin = l.getDimens(this.jpW.getContext(), R.dimen.ds128);
            }
            textView.setText(R.string.share_tip);
            textView.setOnClickListener(this.hyL);
            this.jFX = new PopupWindow(inflate, -2, -2);
        }
    }

    public void cCg() {
        if (this.hyK != null) {
            e.lb().removeCallbacks(this.hyK);
        }
        bVZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVZ() {
        g.dismissPopupWindow(this.jFX);
    }

    public void cK(View view) {
    }

    public void et(String str, String str2) {
        if (this.jpW != null) {
            if (StringUtils.isNull(str)) {
                this.jFT.setVisibility(8);
                this.dIt.setText("贴吧动态");
                return;
            }
            this.jFT.setVisibility(0);
            this.mForumName = str;
            au.a(this.dIt, str, (int) R.string.forum, (int) R.dimen.tbds0, 1, this.jGb, false);
            i.aIc().setForumNameForWaterImage(str);
            this.jFT.startLoad(str2, 10, false);
        }
    }
}
