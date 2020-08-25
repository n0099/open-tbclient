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
/* loaded from: classes16.dex */
public class c {
    private ImageView agf;
    public final View eUm;
    public TextView euj;
    private ImageView gaa;
    private final ImageView jnq;
    private final LinearLayout jnr;
    public TextView kQR;
    public View kQS;
    public LinearLayout kQT;
    public BarImageView kQU;
    private PopupWindow kQX;
    private int kQY;
    private int kQZ;
    private int kRa;
    private int kRb;
    private PbFragment kzt;
    public String mForumName;
    public final NavigationBar mNavigationBar;
    private Runnable runnable;
    private boolean kMd = false;
    private AlertDialog kQV = null;
    private aj kQW = null;
    private boolean kxX = false;
    private boolean kRc = true;
    private Runnable ivF = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.cud();
        }
    };
    private View.OnClickListener ivG = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.dcp();
        }
    };

    public c(PbFragment pbFragment, View view) {
        this.kQY = 0;
        this.kQZ = 0;
        this.kRa = 0;
        this.kRb = 0;
        this.kzt = pbFragment;
        this.kQY = l.getDimens(pbFragment.getContext(), R.dimen.ds88);
        this.kQZ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds14);
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        this.kRa = ((int) (equipmentWidth * 0.07d)) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds102);
        if (this.kRa - dimens > 0) {
            this.kRa -= dimens;
        }
        this.kRb = (equipmentWidth - (this.kRa * 2)) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds89);
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                c.this.kzt.cms();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.eUm = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbFragment.hVB);
        this.kQR = this.mNavigationBar.setCenterTextTitle("");
        this.jnq = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.jnr = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        this.jnr.setPadding(dimens2, 0, dimens2, 0);
        ap.setNavbarIconSrc(this.jnq, R.drawable.icon_pb_play_small, R.drawable.icon_pb_play_small);
        this.jnq.setVisibility(8);
        this.kQR.setOnClickListener(pbFragment.hVB);
        this.jnq.setOnClickListener(pbFragment.hVB);
        this.gaa = (ImageView) this.eUm.findViewById(R.id.widget_navi_back_button);
        if (this.kQT == null) {
            this.kQT = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.nav_fourm_title_layout, (View.OnClickListener) null);
            this.kQU = (BarImageView) this.kQT.findViewById(R.id.pb_nav_title_forum_image);
            this.kQU.setShowOval(true);
            this.kQU.setOnClickListener(pbFragment.hVB);
            this.euj = (TextView) this.kQT.findViewById(R.id.pb_nav_title_forum_name);
            this.euj.setOnClickListener(pbFragment.hVB);
            if (this.kQT.getLayoutParams() != null && (this.kQT.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.kRa > 0 && this.kRb > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.kQT.getLayoutParams();
                marginLayoutParams.leftMargin = this.kRa;
                marginLayoutParams.rightMargin = this.kRa;
                this.kQT.setLayoutParams(marginLayoutParams);
            }
            if (this.kQT.getVisibility() == 8) {
                this.kQT.setVisibility(0);
            }
            if (this.kQT.getAlpha() != 1.0f) {
                this.kQT.setAlpha(1.0f);
            }
        }
    }

    public void tP(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.kMd = z;
        if (this.kQS == null && this.agf == null) {
            this.kQS = this.mNavigationBar.addCustomView(controlAlign, R.layout.nb_item_floor_more, this.kzt.hVB);
            this.agf = (ImageView) this.kQS.findViewById(R.id.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.kQY, this.kQY);
            layoutParams.rightMargin = this.kQZ;
            this.kQS.setLayoutParams(layoutParams);
            SvgManager.bjq().a(this.agf, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.kQS.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void tu(boolean z) {
        if (this.kQS != null) {
            this.kQS.setVisibility(z ? 0 : 8);
        }
    }

    public NavigationBar dch() {
        return this.mNavigationBar;
    }

    public void tQ(boolean z) {
        if (z) {
            this.eUm.setVisibility(0);
        } else {
            this.eUm.setVisibility(8);
        }
        tS(z);
    }

    public void Ly(String str) {
        if (!TextUtils.isEmpty(str) && !this.kMd) {
            this.kQR.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            tS(true);
            k.bbM().setForumNameForWaterImage(str);
            return;
        }
        tS(false);
    }

    public void a(ak akVar) {
        if (!this.kzt.getBaseFragmentActivity().isProgressBarShown()) {
            this.kQW = new aj(this.kzt, this.kzt.hVB);
            this.kQV = new AlertDialog.Builder(this.kzt.getContext(), R.style.DialogTheme).create();
            this.kQV.setCanceledOnTouchOutside(true);
            g.showDialog(this.kQV, this.kzt.getFragmentActivity());
            Window window = this.kQV.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.kQW.getView());
            this.kQW.tj(akVar == null ? false : akVar.kIK);
            this.kQW.tk(akVar == null ? false : akVar.kIO);
            this.kQW.tl(akVar == null ? false : akVar.kIS);
            this.kQW.tn(akVar == null ? false : akVar.kIP);
            this.kQW.to(akVar == null ? true : akVar.kIM);
            if (akVar == null) {
                this.kQW.ak(false, false);
                this.kQW.al(false, false);
            } else {
                this.kQW.ak(akVar.kIQ, akVar.kIW);
                this.kQW.al(akVar.kIR, akVar.kIV);
            }
            boolean z = akVar == null ? false : akVar.EK;
            boolean z2 = akVar == null ? false : akVar.isHostOnly;
            boolean z3 = akVar == null ? false : akVar.kIN;
            boolean z4 = akVar == null ? false : akVar.kIL;
            boolean z5 = akVar == null ? false : akVar.kIU;
            boolean z6 = akVar == null ? false : akVar.kIT;
            this.kQW.aj(z3, z2);
            this.kQW.am(z4, z);
            this.kQW.an(z6, z5);
            if (akVar != null) {
                this.kQW.kIH = akVar.kIX;
                if (akVar.kIX) {
                    this.kQW.cZO().setText(R.string.report_text);
                    this.kQW.tn(false);
                }
            }
            this.kQW.tm(akVar != null ? akVar.kIY : false);
            if (!TbSingleton.getInstance().mCanCallFans && this.kzt.cWD() != null && this.kzt.cWD().getPbData() != null && this.kzt.cWD().getPbData().getThreadId() != null && this.kzt.cWD().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                this.kQW.cZR().setText(R.string.have_called_fans_short);
            }
            dci();
        }
    }

    private void dci() {
        if (this.kQW != null) {
            this.kQW.cZV();
        }
    }

    public void aRN() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.kQV != null) {
                        g.dismissDialog(c.this.kQV, c.this.kzt.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.mS().postDelayed(this.runnable, 100L);
    }

    public void dcj() {
        if (this.kQV != null) {
            g.dismissDialog(this.kQV, this.kzt.getPageContext().getPageActivity());
        }
    }

    public aj dck() {
        return this.kQW;
    }

    public View dcl() {
        return this.jnq;
    }

    public boolean dcm() {
        return this.kQV != null && this.kQV.isShowing();
    }

    public void releaseResources() {
        if (this.kQW != null) {
            this.kQW.release();
        }
        this.kQV = null;
        this.kQW = null;
        e.mS().removeCallbacks(this.runnable);
    }

    public void dcn() {
        if (this.kQS != null) {
            this.kQS.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.kzt.getPageContext(), i);
            ap.setBackgroundResource(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
        }
        SvgManager.bjq().a(this.gaa, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.bjq().a(this.agf, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setNavbarTitleColor(this.kQR, R.color.cp_cont_b, R.color.s_navbar_title_color);
        ap.setViewTextColor(this.euj, R.color.cp_cont_b);
        dci();
    }

    public void Ey(int i) {
        this.mNavigationBar.onChangeSkinType(this.kzt.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha85));
        if (this.agf != null) {
            SvgManager.bjq().a(this.agf, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.kQR.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_cont_g));
        SvgManager.bjq().a(this.gaa, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void dco() {
        this.gaa.setVisibility(0);
        tS(false);
        if (this.kQS != null) {
            this.kQS.setVisibility(8);
        }
    }

    public void tR(boolean z) {
        this.gaa.setVisibility(0);
        tS(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.kQS != null) {
                this.kQS.setVisibility(0);
            }
        } else if (this.kQS != null) {
            this.kQS.setVisibility(8);
        }
    }

    public void tS(boolean z) {
        if (!this.kMd && z && !"".equals(this.kQR.getText().toString())) {
            this.kQR.setVisibility(0);
        } else {
            this.kQR.setVisibility(8);
        }
    }

    public void sB(boolean z) {
        this.kxX = z;
    }

    public void daR() {
        if ((!this.kxX || TbadkCoreApplication.isLogin()) && !com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.SHOW_SHARE, false)) {
            View inflate = LayoutInflater.from(this.kzt.getPageContext().getContext()).inflate(R.layout.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.arrow_up);
            TextView textView = (TextView) inflate.findViewById(R.id.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.gravity = 5;
            if (!TbadkCoreApplication.isLogin()) {
                layoutParams.rightMargin = l.getDimens(this.kzt.getContext(), R.dimen.ds28);
            } else {
                layoutParams.rightMargin = l.getDimens(this.kzt.getContext(), R.dimen.ds128);
            }
            textView.setText(R.string.share_tip);
            textView.setOnClickListener(this.ivG);
            this.kQX = new PopupWindow(inflate, -2, -2);
        }
    }

    public void dcp() {
        if (this.ivF != null) {
            e.mS().removeCallbacks(this.ivF);
        }
        cud();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cud() {
        g.dismissPopupWindow(this.kQX);
    }

    public void cW(View view) {
    }

    public void fu(String str, String str2) {
        if (this.kzt != null && this.kQT != null) {
            if (StringUtils.isNull(str)) {
                this.kQU.setVisibility(8);
                this.euj.setText("贴吧动态");
                return;
            }
            this.kQU.setVisibility(0);
            this.mForumName = str;
            ay.a(this.euj, str, R.string.forum, R.dimen.tbds0, 1, this.kRb, false);
            k.bbM().setForumNameForWaterImage(str);
            this.kQU.startLoad(str2, 10, false);
        }
    }
}
