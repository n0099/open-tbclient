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
/* loaded from: classes21.dex */
public class c {
    private ImageView agA;
    public final View eXg;
    public TextView ewr;
    private ImageView gds;
    private final ImageView jvZ;
    private final LinearLayout jwa;
    private PbFragment kHX;
    public TextView kZA;
    public View kZB;
    public LinearLayout kZC;
    public BarImageView kZD;
    private PopupWindow kZH;
    private int kZI;
    private int kZJ;
    private int kZK;
    private int kZL;
    public String mForumName;
    public final NavigationBar mNavigationBar;
    private Runnable runnable;
    private boolean kUK = false;
    private AlertDialog kZE = null;
    private aj kZF = null;
    private boolean kZG = false;
    private boolean kZM = true;
    private Runnable iDh = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.cxx();
        }
    };
    private View.OnClickListener iDi = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.dfU();
        }
    };

    public c(PbFragment pbFragment, View view) {
        this.kZI = 0;
        this.kZJ = 0;
        this.kZK = 0;
        this.kZL = 0;
        this.kHX = pbFragment;
        this.kZI = l.getDimens(pbFragment.getContext(), R.dimen.ds88);
        this.kZJ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds14);
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        this.kZK = ((int) (equipmentWidth * 0.07d)) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds102);
        if (this.kZK - dimens > 0) {
            this.kZK -= dimens;
        }
        this.kZL = (equipmentWidth - (this.kZK * 2)) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds89);
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                c.this.kHX.cpF();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.eXg = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbFragment.icH);
        this.kZA = this.mNavigationBar.setCenterTextTitle("");
        this.jvZ = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.jwa = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        this.jwa.setPadding(dimens2, 0, dimens2, 0);
        ap.setNavbarIconSrc(this.jvZ, R.drawable.icon_pb_play_small, R.drawable.icon_pb_play_small);
        this.jvZ.setVisibility(8);
        this.kZA.setOnClickListener(pbFragment.icH);
        this.jvZ.setOnClickListener(pbFragment.icH);
        this.gds = (ImageView) this.eXg.findViewById(R.id.widget_navi_back_button);
        if (this.kZC == null) {
            this.kZC = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.nav_fourm_title_layout, (View.OnClickListener) null);
            this.kZD = (BarImageView) this.kZC.findViewById(R.id.pb_nav_title_forum_image);
            this.kZD.setShowOval(true);
            this.kZD.setOnClickListener(pbFragment.icH);
            this.ewr = (TextView) this.kZC.findViewById(R.id.pb_nav_title_forum_name);
            this.ewr.setOnClickListener(pbFragment.icH);
            if (this.kZC.getLayoutParams() != null && (this.kZC.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.kZK > 0 && this.kZL > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.kZC.getLayoutParams();
                marginLayoutParams.leftMargin = this.kZK;
                marginLayoutParams.rightMargin = this.kZK;
                this.kZC.setLayoutParams(marginLayoutParams);
            }
            if (this.kZC.getVisibility() == 8) {
                this.kZC.setVisibility(0);
            }
            if (this.kZC.getAlpha() != 1.0f) {
                this.kZC.setAlpha(1.0f);
            }
        }
    }

    public void tY(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.kUK = z;
        if (this.kZB == null && this.agA == null) {
            this.kZB = this.mNavigationBar.addCustomView(controlAlign, R.layout.nb_item_floor_more, this.kHX.icH);
            this.agA = (ImageView) this.kZB.findViewById(R.id.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.kZI, this.kZI);
            layoutParams.rightMargin = this.kZJ;
            this.kZB.setLayoutParams(layoutParams);
            SvgManager.bkl().a(this.agA, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.kZB.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void tD(boolean z) {
        if (this.kZB != null) {
            this.kZB.setVisibility(z ? 0 : 8);
        }
    }

    public NavigationBar dfM() {
        return this.mNavigationBar;
    }

    public void tZ(boolean z) {
        if (z) {
            this.eXg.setVisibility(0);
        } else {
            this.eXg.setVisibility(8);
        }
        ub(z);
    }

    public void Mb(String str) {
        if (!TextUtils.isEmpty(str) && !this.kUK) {
            this.kZA.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            ub(true);
            k.bcG().setForumNameForWaterImage(str);
            return;
        }
        ub(false);
    }

    public void a(ak akVar) {
        if (!this.kHX.getBaseFragmentActivity().isProgressBarShown()) {
            this.kZF = new aj(this.kHX, this.kHX.icH);
            this.kZE = new AlertDialog.Builder(this.kHX.getContext(), R.style.DialogTheme).create();
            this.kZE.setCanceledOnTouchOutside(true);
            g.showDialog(this.kZE, this.kHX.getFragmentActivity());
            Window window = this.kZE.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.kZF.getView());
            this.kZF.ts(akVar == null ? false : akVar.kRr);
            this.kZF.tt(akVar == null ? false : akVar.kRv);
            this.kZF.tu(akVar == null ? false : akVar.kRz);
            this.kZF.tw(akVar == null ? false : akVar.kRw);
            this.kZF.tx(akVar == null ? true : akVar.kRt);
            if (akVar == null) {
                this.kZF.am(false, false);
                this.kZF.an(false, false);
            } else {
                this.kZF.am(akVar.kRx, akVar.kRD);
                this.kZF.an(akVar.kRy, akVar.kRC);
            }
            boolean z = akVar == null ? false : akVar.EK;
            boolean z2 = akVar == null ? false : akVar.isHostOnly;
            boolean z3 = akVar == null ? false : akVar.kRu;
            boolean z4 = akVar == null ? false : akVar.kRs;
            boolean z5 = akVar == null ? false : akVar.kRB;
            boolean z6 = akVar == null ? false : akVar.kRA;
            this.kZF.al(z3, z2);
            this.kZF.ao(z4, z);
            this.kZF.ap(z6, z5);
            if (akVar != null) {
                this.kZF.kRo = akVar.kRE;
                if (akVar.kRE) {
                    this.kZF.dds().setText(R.string.report_text);
                    this.kZF.tw(false);
                }
            }
            this.kZF.tv(akVar != null ? akVar.kRF : false);
            if (!TbSingleton.getInstance().mCanCallFans && this.kHX.dah() != null && this.kHX.dah().getPbData() != null && this.kHX.dah().getPbData().getThreadId() != null && this.kHX.dah().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                this.kZF.ddv().setText(R.string.have_called_fans_short);
            }
            dfN();
        }
    }

    private void dfN() {
        if (this.kZF != null) {
            this.kZF.ddz();
        }
    }

    public void aSz() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.kZE != null) {
                        g.dismissDialog(c.this.kZE, c.this.kHX.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.mX().postDelayed(this.runnable, 100L);
    }

    public void dfO() {
        if (this.kZE != null) {
            g.dismissDialog(this.kZE, this.kHX.getPageContext().getPageActivity());
        }
    }

    public aj dfP() {
        return this.kZF;
    }

    public View dfQ() {
        return this.jvZ;
    }

    public boolean dfR() {
        return this.kZE != null && this.kZE.isShowing();
    }

    public void releaseResources() {
        if (this.kZF != null) {
            this.kZF.release();
        }
        this.kZE = null;
        this.kZF = null;
        e.mX().removeCallbacks(this.runnable);
    }

    public void dfS() {
        if (this.kZB != null) {
            this.kZB.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.kHX.getPageContext(), i);
            ap.setBackgroundResource(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
        }
        SvgManager.bkl().a(this.gds, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.bkl().a(this.agA, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setNavbarTitleColor(this.kZA, R.color.cp_cont_b, R.color.s_navbar_title_color);
        ap.setViewTextColor(this.ewr, R.color.cp_cont_b);
        dfN();
    }

    public void EZ(int i) {
        this.mNavigationBar.onChangeSkinType(this.kHX.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha85));
        if (this.agA != null) {
            SvgManager.bkl().a(this.agA, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.kZA.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_cont_g));
        SvgManager.bkl().a(this.gds, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void dfT() {
        this.gds.setVisibility(0);
        ub(false);
        if (this.kZB != null) {
            this.kZB.setVisibility(8);
        }
    }

    public void ua(boolean z) {
        this.gds.setVisibility(0);
        ub(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.kZB != null) {
                this.kZB.setVisibility(0);
            }
        } else if (this.kZB != null) {
            this.kZB.setVisibility(8);
        }
    }

    public void ub(boolean z) {
        if (!this.kUK && z && !"".equals(this.kZA.getText().toString())) {
            this.kZA.setVisibility(0);
        } else {
            this.kZA.setVisibility(8);
        }
    }

    public void uc(boolean z) {
        this.kZG = z;
    }

    public void dev() {
        if ((!this.kZG || TbadkCoreApplication.isLogin()) && !com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean(SharedPrefConfig.SHOW_SHARE, false)) {
            View inflate = LayoutInflater.from(this.kHX.getPageContext().getContext()).inflate(R.layout.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.arrow_up);
            TextView textView = (TextView) inflate.findViewById(R.id.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.gravity = 5;
            if (!TbadkCoreApplication.isLogin()) {
                layoutParams.rightMargin = l.getDimens(this.kHX.getContext(), R.dimen.ds28);
            } else {
                layoutParams.rightMargin = l.getDimens(this.kHX.getContext(), R.dimen.ds128);
            }
            textView.setText(R.string.share_tip);
            textView.setOnClickListener(this.iDi);
            this.kZH = new PopupWindow(inflate, -2, -2);
        }
    }

    public void dfU() {
        if (this.iDh != null) {
            e.mX().removeCallbacks(this.iDh);
        }
        cxx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxx() {
        g.dismissPopupWindow(this.kZH);
    }

    public void de(View view) {
    }

    public void fI(String str, String str2) {
        if (this.kHX != null && this.kZC != null) {
            if (StringUtils.isNull(str)) {
                this.kZD.setVisibility(8);
                this.ewr.setText("贴吧动态");
                return;
            }
            this.kZD.setVisibility(0);
            this.mForumName = str;
            ay.a(this.ewr, str, R.string.forum, R.dimen.tbds0, 1, this.kZL, false);
            k.bcG().setForumNameForWaterImage(str);
            this.kZD.startLoad(str2, 10, false);
        }
    }
}
