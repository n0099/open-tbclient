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
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.aj;
import com.baidu.tieba.pb.pb.main.ak;
/* loaded from: classes22.dex */
public class c {
    private ImageView agR;
    public TextView eIB;
    public final View fjs;
    private ImageView gpI;
    private final ImageView jKW;
    private final LinearLayout jKX;
    private PbFragment kXi;
    public TextView loS;
    public View loT;
    public LinearLayout loU;
    public BarImageView loV;
    private PopupWindow loZ;
    private int lpa;
    private int lpb;
    private int lpc;
    private int lpd;
    public String mForumName;
    public final NavigationBar mNavigationBar;
    private Runnable runnable;
    private boolean ljX = false;
    private AlertDialog loW = null;
    private aj loX = null;
    private boolean loY = false;
    private boolean lpe = true;
    private Runnable iRX = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.cAU();
        }
    };
    private View.OnClickListener iRY = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.djD();
        }
    };

    public c(PbFragment pbFragment, View view) {
        this.lpa = 0;
        this.lpb = 0;
        this.lpc = 0;
        this.lpd = 0;
        this.kXi = pbFragment;
        this.lpa = l.getDimens(pbFragment.getContext(), R.dimen.ds88);
        this.lpb = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds14);
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        this.lpc = ((int) (equipmentWidth * 0.07d)) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds102);
        if (this.lpc - dimens > 0) {
            this.lpc -= dimens;
        }
        this.lpd = (equipmentWidth - (this.lpc * 2)) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds89);
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                c.this.kXi.ctd();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.fjs = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbFragment.irI);
        this.loS = this.mNavigationBar.setCenterTextTitle("");
        this.jKW = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.jKX = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        this.jKX.setPadding(dimens2, 0, dimens2, 0);
        ap.setNavbarIconSrc(this.jKW, R.drawable.icon_pb_play_small, R.drawable.icon_pb_play_small);
        this.jKW.setVisibility(8);
        this.loS.setOnClickListener(pbFragment.irI);
        this.jKW.setOnClickListener(pbFragment.irI);
        this.gpI = (ImageView) this.fjs.findViewById(R.id.widget_navi_back_button);
        if (this.loU == null) {
            this.loU = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.nav_fourm_title_layout, (View.OnClickListener) null);
            this.loV = (BarImageView) this.loU.findViewById(R.id.pb_nav_title_forum_image);
            this.loV.setShowOval(true);
            this.loV.setOnClickListener(pbFragment.irI);
            this.eIB = (TextView) this.loU.findViewById(R.id.pb_nav_title_forum_name);
            this.eIB.setOnClickListener(pbFragment.irI);
            if (this.loU.getLayoutParams() != null && (this.loU.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.lpc > 0 && this.lpd > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.loU.getLayoutParams();
                marginLayoutParams.leftMargin = this.lpc;
                marginLayoutParams.rightMargin = this.lpc;
                this.loU.setLayoutParams(marginLayoutParams);
            }
            if (this.loU.getVisibility() == 8) {
                this.loU.setVisibility(0);
            }
            if (this.loU.getAlpha() != 1.0f) {
                this.loU.setAlpha(1.0f);
            }
        }
    }

    public void uF(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.ljX = z;
        if (this.loT == null && this.agR == null) {
            this.loT = this.mNavigationBar.addCustomView(controlAlign, R.layout.nb_item_floor_more, this.kXi.irI);
            this.agR = (ImageView) this.loT.findViewById(R.id.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.lpa, this.lpa);
            layoutParams.rightMargin = this.lpb;
            this.loT.setLayoutParams(layoutParams);
            SvgManager.bmU().a(this.agR, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.loT.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void uk(boolean z) {
        if (this.loT != null) {
            this.loT.setVisibility(z ? 0 : 8);
        }
    }

    public NavigationBar djv() {
        return this.mNavigationBar;
    }

    public void uG(boolean z) {
        if (z) {
            this.fjs.setVisibility(0);
        } else {
            this.fjs.setVisibility(8);
        }
        uI(z);
    }

    public void MQ(String str) {
        if (!TextUtils.isEmpty(str) && !this.ljX) {
            this.loS.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            uI(true);
            k.bfo().setForumNameForWaterImage(str);
            return;
        }
        uI(false);
    }

    public void a(ak akVar) {
        if (!this.kXi.getBaseFragmentActivity().isProgressBarShown()) {
            this.loX = new aj(this.kXi, this.kXi.irI);
            this.loW = new AlertDialog.Builder(this.kXi.getContext(), R.style.DialogTheme).create();
            this.loW.setCanceledOnTouchOutside(true);
            g.showDialog(this.loW, this.kXi.getFragmentActivity());
            Window window = this.loW.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.loX.getView());
            this.loX.tZ(akVar == null ? false : akVar.lgE);
            this.loX.ua(akVar == null ? false : akVar.lgI);
            this.loX.ub(akVar == null ? false : akVar.lgM);
            this.loX.ud(akVar == null ? false : akVar.lgJ);
            this.loX.ue(akVar == null ? true : akVar.lgG);
            if (akVar == null) {
                this.loX.al(false, false);
                this.loX.am(false, false);
            } else {
                this.loX.al(akVar.lgK, akVar.lgQ);
                this.loX.am(akVar.lgL, akVar.lgP);
            }
            boolean z = akVar == null ? false : akVar.Fc;
            boolean z2 = akVar == null ? false : akVar.isHostOnly;
            boolean z3 = akVar == null ? false : akVar.lgH;
            boolean z4 = akVar == null ? false : akVar.lgF;
            boolean z5 = akVar == null ? false : akVar.lgO;
            boolean z6 = akVar == null ? false : akVar.lgN;
            this.loX.ak(z3, z2);
            this.loX.an(z4, z);
            this.loX.ao(z6, z5);
            if (akVar != null) {
                this.loX.lgB = akVar.lgR;
                if (akVar.lgR) {
                    this.loX.dhb().setText(R.string.report_text);
                    this.loX.ud(false);
                }
            }
            this.loX.uc(akVar != null ? akVar.lgS : false);
            if (!TbSingleton.getInstance().mCanCallFans && this.kXi.ddQ() != null && this.kXi.ddQ().getPbData() != null && this.kXi.ddQ().getPbData().getThreadId() != null && this.kXi.ddQ().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                this.loX.dhe().setText(R.string.have_called_fans_short);
            }
            djw();
        }
    }

    private void djw() {
        if (this.loX != null) {
            this.loX.dhi();
        }
    }

    public void aVi() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.loW != null) {
                        g.dismissDialog(c.this.loW, c.this.kXi.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.mY().postDelayed(this.runnable, 100L);
    }

    public void djx() {
        if (this.loW != null) {
            g.dismissDialog(this.loW, this.kXi.getPageContext().getPageActivity());
        }
    }

    public aj djy() {
        return this.loX;
    }

    public View djz() {
        return this.jKW;
    }

    public boolean djA() {
        return this.loW != null && this.loW.isShowing();
    }

    public void releaseResources() {
        if (this.loX != null) {
            this.loX.release();
        }
        this.loW = null;
        this.loX = null;
        e.mY().removeCallbacks(this.runnable);
    }

    public void djB() {
        if (this.loT != null) {
            this.loT.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.kXi.getPageContext(), i);
            ap.setBackgroundResource(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
        }
        SvgManager.bmU().a(this.gpI, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.bmU().a(this.agR, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setNavbarTitleColor(this.loS, R.color.cp_cont_b, R.color.s_navbar_title_color);
        ap.setViewTextColor(this.eIB, R.color.cp_cont_b);
        djw();
    }

    public void FF(int i) {
        this.mNavigationBar.onChangeSkinType(this.kXi.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha85));
        if (this.agR != null) {
            SvgManager.bmU().a(this.agR, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.loS.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_cont_g));
        SvgManager.bmU().a(this.gpI, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void djC() {
        this.gpI.setVisibility(0);
        uI(false);
        if (this.loT != null) {
            this.loT.setVisibility(8);
        }
    }

    public void uH(boolean z) {
        this.gpI.setVisibility(0);
        uI(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.loT != null) {
                this.loT.setVisibility(0);
            }
        } else if (this.loT != null) {
            this.loT.setVisibility(8);
        }
    }

    public void uI(boolean z) {
        if (!this.ljX && z && !"".equals(this.loS.getText().toString())) {
            this.loS.setVisibility(0);
        } else {
            this.loS.setVisibility(8);
        }
    }

    public void uJ(boolean z) {
        this.loY = z;
    }

    public void die() {
        if ((!this.loY || TbadkCoreApplication.isLogin()) && !com.baidu.tbadk.core.sharedPref.b.blO().getBoolean(SharedPrefConfig.SHOW_SHARE, false)) {
            View inflate = LayoutInflater.from(this.kXi.getPageContext().getContext()).inflate(R.layout.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.arrow_up);
            TextView textView = (TextView) inflate.findViewById(R.id.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.gravity = 5;
            if (!TbadkCoreApplication.isLogin()) {
                layoutParams.rightMargin = l.getDimens(this.kXi.getContext(), R.dimen.ds28);
            } else {
                layoutParams.rightMargin = l.getDimens(this.kXi.getContext(), R.dimen.ds128);
            }
            textView.setText(R.string.share_tip);
            textView.setOnClickListener(this.iRY);
            this.loZ = new PopupWindow(inflate, -2, -2);
        }
    }

    public void djD() {
        if (this.iRX != null) {
            e.mY().removeCallbacks(this.iRX);
        }
        cAU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAU() {
        g.dismissPopupWindow(this.loZ);
    }

    public void di(View view) {
    }

    public void fP(String str, String str2) {
        if (this.kXi != null && this.loU != null) {
            if (StringUtils.isNull(str)) {
                this.loV.setVisibility(8);
                this.eIB.setText("贴吧动态");
                return;
            }
            this.loV.setVisibility(0);
            this.mForumName = str;
            ay.a(this.eIB, str, R.string.forum, R.dimen.tbds0, 1, this.lpd, false);
            k.bfo().setForumNameForWaterImage(str);
            this.loV.startLoad(str2, 10, false);
        }
    }
}
