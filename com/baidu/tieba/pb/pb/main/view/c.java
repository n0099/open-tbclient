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
    private ImageView adY;
    public TextView dIp;
    public final View efU;
    private ImageView fjA;
    public TextView jFK;
    public View jFL;
    private final ImageView jFM;
    private final LinearLayout jFN;
    public LinearLayout jFO;
    public BarImageView jFP;
    private PopupWindow jFT;
    private int jFU;
    private int jFV;
    private int jFW;
    private int jFX;
    private PbFragment jpS;
    public String mForumName;
    public final NavigationBar mNavigationBar;
    private Runnable runnable;
    private final int jFJ = 6;
    private boolean jBd = false;
    private AlertDialog jFQ = null;
    private y jFR = null;
    private boolean jFS = false;
    private boolean jFY = true;
    private Runnable hyE = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.bWb();
        }
    };
    private View.OnClickListener hyF = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.cCj();
        }
    };

    public c(PbFragment pbFragment, View view) {
        this.jFU = 0;
        this.jFV = 0;
        this.jFW = 0;
        this.jFX = 0;
        this.jpS = pbFragment;
        this.jFU = l.getDimens(pbFragment.getContext(), R.dimen.ds88);
        this.jFV = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds14);
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        this.jFW = ((int) (equipmentWidth * 0.07d)) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds102);
        if (this.jFW - dimens > 0) {
            this.jFW -= dimens;
        }
        this.jFX = (equipmentWidth - (this.jFW * 2)) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds89);
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                c.this.jpS.bOU();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.efU = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbFragment.haA);
        this.jFK = this.mNavigationBar.setCenterTextTitle("");
        this.jFM = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.jFN = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        this.jFN.setPadding(dimens2, 0, dimens2, 0);
        am.setNavbarIconSrc(this.jFM, R.drawable.icon_pb_play_small, R.drawable.icon_pb_play_small);
        this.jFM.setVisibility(8);
        this.jFK.setOnClickListener(pbFragment.haA);
        this.jFM.setOnClickListener(pbFragment.haA);
        this.fjA = (ImageView) this.efU.findViewById(R.id.widget_navi_back_button);
        if (this.jFO == null) {
            this.jFO = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.nav_fourm_title_layout, (View.OnClickListener) null);
            this.jFP = (BarImageView) this.jFO.findViewById(R.id.pb_nav_title_forum_image);
            this.jFP.setShowOval(true);
            this.jFP.setOnClickListener(pbFragment.haA);
            this.dIp = (TextView) this.jFO.findViewById(R.id.pb_nav_title_forum_name);
            this.dIp.setOnClickListener(pbFragment.haA);
            if (this.jFO.getLayoutParams() != null && (this.jFO.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.jFW > 0 && this.jFX > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jFO.getLayoutParams();
                marginLayoutParams.leftMargin = this.jFW;
                marginLayoutParams.rightMargin = this.jFW;
                this.jFO.setLayoutParams(marginLayoutParams);
            }
            if (this.jFO.getVisibility() == 8) {
                this.jFO.setVisibility(0);
            }
            if (this.jFO.getAlpha() != 1.0f) {
                this.jFO.setAlpha(1.0f);
            }
        }
    }

    public void rN(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.jBd = z;
        if (this.jFL == null && this.adY == null) {
            this.jFL = this.mNavigationBar.addCustomView(controlAlign, R.layout.nb_item_floor_more, this.jpS.haA);
            this.adY = (ImageView) this.jFL.findViewById(R.id.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.jFU, this.jFU);
            layoutParams.rightMargin = this.jFV;
            this.jFL.setLayoutParams(layoutParams);
            SvgManager.aOU().a(this.adY, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.jFL.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void rt(boolean z) {
        if (this.jFL != null) {
            this.jFL.setVisibility(z ? 0 : 8);
        }
    }

    public NavigationBar cCb() {
        return this.mNavigationBar;
    }

    public void rO(boolean z) {
        if (z) {
            this.efU.setVisibility(0);
        } else {
            this.efU.setVisibility(8);
        }
        rQ(z);
    }

    public void FC(String str) {
        if (!TextUtils.isEmpty(str) && !this.jBd) {
            this.jFK.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            rQ(true);
            i.aIe().setForumNameForWaterImage(str);
            return;
        }
        rQ(false);
    }

    public void a(z zVar) {
        if (!this.jpS.getBaseFragmentActivity().isProgressBarShown()) {
            this.jFR = new y(this.jpS, this.jpS.haA);
            this.jFQ = new AlertDialog.Builder(this.jpS.getContext(), R.style.DialogTheme).create();
            this.jFQ.setCanceledOnTouchOutside(true);
            g.showDialog(this.jFQ, this.jpS.getFragmentActivity());
            Window window = this.jFQ.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.jFR.getView());
            this.jFR.rj(zVar == null ? false : zVar.jxQ);
            this.jFR.rk(zVar == null ? false : zVar.jxU);
            this.jFR.rl(zVar == null ? false : zVar.jxY);
            this.jFR.rm(zVar == null ? false : zVar.jxV);
            this.jFR.rn(zVar == null ? true : zVar.jxS);
            if (zVar == null) {
                this.jFR.ab(false, false);
                this.jFR.ac(false, false);
            } else {
                this.jFR.ab(zVar.jxW, zVar.jyc);
                this.jFR.ac(zVar.jxX, zVar.jyb);
            }
            boolean z = zVar == null ? false : zVar.Dy;
            boolean z2 = zVar == null ? false : zVar.isHostOnly;
            boolean z3 = zVar == null ? false : zVar.jxT;
            boolean z4 = zVar == null ? false : zVar.jxR;
            boolean z5 = zVar == null ? false : zVar.jya;
            boolean z6 = zVar == null ? false : zVar.jxZ;
            this.jFR.aa(z3, z2);
            this.jFR.ad(z4, z);
            this.jFR.ae(z6, z5);
            if (zVar != null) {
                this.jFR.jxN = zVar.jyd;
                if (zVar.jyd) {
                    this.jFR.czL().setText(R.string.report_text);
                    this.jFR.rm(false);
                }
            }
            cCc();
        }
    }

    private void cCc() {
        if (this.jFR != null) {
            this.jFR.czR();
        }
    }

    public void aAi() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.jFQ != null) {
                        g.dismissDialog(c.this.jFQ, c.this.jpS.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.lb().postDelayed(this.runnable, 100L);
    }

    public void cCd() {
        if (this.jFQ != null) {
            g.dismissDialog(this.jFQ, this.jpS.getPageContext().getPageActivity());
        }
    }

    public y cCe() {
        return this.jFR;
    }

    public View cCf() {
        return this.jFM;
    }

    public boolean cCg() {
        return this.jFQ != null && this.jFQ.isShowing();
    }

    public void releaseResources() {
        if (this.jFR != null) {
            this.jFR.release();
        }
        this.jFQ = null;
        this.jFR = null;
        e.lb().removeCallbacks(this.runnable);
    }

    public void cCh() {
        if (this.jFL != null) {
            this.jFL.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.jpS.getPageContext(), i);
            am.setBackgroundResource(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
        }
        SvgManager.aOU().a(this.fjA, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aOU().a(this.adY, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setNavbarTitleColor(this.jFK, R.color.cp_cont_b, R.color.s_navbar_title_color);
        am.setViewTextColor(this.dIp, (int) R.color.cp_cont_b);
        cCc();
    }

    public void zQ(int i) {
        this.mNavigationBar.onChangeSkinType(this.jpS.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha85));
        if (this.adY != null) {
            SvgManager.aOU().a(this.adY, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.jFK.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_cont_g));
        SvgManager.aOU().a(this.fjA, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void cCi() {
        this.fjA.setVisibility(0);
        rQ(false);
        if (this.jFL != null) {
            this.jFL.setVisibility(8);
        }
    }

    public void rP(boolean z) {
        this.fjA.setVisibility(0);
        rQ(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.jFL != null) {
                this.jFL.setVisibility(0);
            }
        } else if (this.jFL != null) {
            this.jFL.setVisibility(8);
        }
    }

    public void rQ(boolean z) {
        if (!this.jBd && z && !"".equals(this.jFK.getText().toString())) {
            this.jFK.setVisibility(0);
        } else {
            this.jFK.setVisibility(8);
        }
    }

    public void rR(boolean z) {
        this.jFS = z;
    }

    public void cAN() {
        if ((!this.jFS || TbadkCoreApplication.isLogin()) && !com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean(SharedPrefConfig.SHOW_SHARE, false)) {
            View inflate = LayoutInflater.from(this.jpS.getPageContext().getContext()).inflate(R.layout.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.arrow_up);
            TextView textView = (TextView) inflate.findViewById(R.id.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.gravity = 5;
            if (!TbadkCoreApplication.isLogin()) {
                layoutParams.rightMargin = l.getDimens(this.jpS.getContext(), R.dimen.ds28);
            } else {
                layoutParams.rightMargin = l.getDimens(this.jpS.getContext(), R.dimen.ds128);
            }
            textView.setText(R.string.share_tip);
            textView.setOnClickListener(this.hyF);
            this.jFT = new PopupWindow(inflate, -2, -2);
        }
    }

    public void cCj() {
        if (this.hyE != null) {
            e.lb().removeCallbacks(this.hyE);
        }
        bWb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWb() {
        g.dismissPopupWindow(this.jFT);
    }

    public void cK(View view) {
    }

    public void et(String str, String str2) {
        if (this.jpS != null) {
            if (StringUtils.isNull(str)) {
                this.jFP.setVisibility(8);
                this.dIp.setText("贴吧动态");
                return;
            }
            this.jFP.setVisibility(0);
            this.mForumName = str;
            au.a(this.dIp, str, (int) R.string.forum, (int) R.dimen.tbds0, 1, this.jFX, false);
            i.aIe().setForumNameForWaterImage(str);
            this.jFP.startLoad(str2, 10, false);
        }
    }
}
