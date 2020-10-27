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
    private ImageView agS;
    public TextView eQX;
    public final View frR;
    private ImageView gzN;
    private final ImageView jXu;
    private final LinearLayout jXv;
    private int lBA;
    private int lBB;
    private int lBC;
    public TextView lBr;
    public View lBs;
    public LinearLayout lBt;
    public BarImageView lBu;
    private PopupWindow lBy;
    private int lBz;
    private PbFragment ljH;
    public String mForumName;
    public final NavigationBar mNavigationBar;
    private Runnable runnable;
    private boolean lwA = false;
    private AlertDialog lBv = null;
    private aj lBw = null;
    private boolean lBx = false;
    private boolean lBD = true;
    private Runnable jet = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.cEb();
        }
    };
    private View.OnClickListener jeu = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.dmK();
        }
    };

    public c(PbFragment pbFragment, View view) {
        this.lBz = 0;
        this.lBA = 0;
        this.lBB = 0;
        this.lBC = 0;
        this.ljH = pbFragment;
        this.lBz = l.getDimens(pbFragment.getContext(), R.dimen.ds88);
        this.lBA = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds14);
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        this.lBB = ((int) (equipmentWidth * 0.07d)) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds102);
        if (this.lBB - dimens > 0) {
            this.lBB -= dimens;
        }
        this.lBC = (equipmentWidth - (this.lBB * 2)) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds89);
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                c.this.ljH.cwk();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.frR = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbFragment.iEe);
        this.lBr = this.mNavigationBar.setCenterTextTitle("");
        this.jXu = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.jXv = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        this.jXv.setPadding(dimens2, 0, dimens2, 0);
        ap.setNavbarIconSrc(this.jXu, R.drawable.icon_pb_play_small, R.drawable.icon_pb_play_small);
        this.jXu.setVisibility(8);
        this.lBr.setOnClickListener(pbFragment.iEe);
        this.jXu.setOnClickListener(pbFragment.iEe);
        this.gzN = (ImageView) this.frR.findViewById(R.id.widget_navi_back_button);
        if (this.lBt == null) {
            this.lBt = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.nav_fourm_title_layout, (View.OnClickListener) null);
            this.lBu = (BarImageView) this.lBt.findViewById(R.id.pb_nav_title_forum_image);
            this.lBu.setShowOval(true);
            this.lBu.setOnClickListener(pbFragment.iEe);
            this.eQX = (TextView) this.lBt.findViewById(R.id.pb_nav_title_forum_name);
            this.eQX.setOnClickListener(pbFragment.iEe);
            if (this.lBt.getLayoutParams() != null && (this.lBt.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.lBB > 0 && this.lBC > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.lBt.getLayoutParams();
                marginLayoutParams.leftMargin = this.lBB;
                marginLayoutParams.rightMargin = this.lBB;
                this.lBt.setLayoutParams(marginLayoutParams);
            }
            if (this.lBt.getVisibility() == 8) {
                this.lBt.setVisibility(0);
            }
            if (this.lBt.getAlpha() != 1.0f) {
                this.lBt.setAlpha(1.0f);
            }
        }
    }

    public void uW(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.lwA = z;
        if (this.lBs == null && this.agS == null) {
            this.lBs = this.mNavigationBar.addCustomView(controlAlign, R.layout.nb_item_floor_more, this.ljH.iEe);
            this.agS = (ImageView) this.lBs.findViewById(R.id.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.lBz, this.lBz);
            layoutParams.rightMargin = this.lBA;
            this.lBs.setLayoutParams(layoutParams);
            SvgManager.boN().a(this.agS, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.lBs.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void uB(boolean z) {
        if (this.lBs != null) {
            this.lBs.setVisibility(z ? 0 : 8);
        }
    }

    public NavigationBar dmC() {
        return this.mNavigationBar;
    }

    public void uX(boolean z) {
        if (z) {
            this.frR.setVisibility(0);
        } else {
            this.frR.setVisibility(8);
        }
        uZ(z);
    }

    public void No(String str) {
        if (!TextUtils.isEmpty(str) && !this.lwA) {
            this.lBr.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            uZ(true);
            k.bhh().setForumNameForWaterImage(str);
            return;
        }
        uZ(false);
    }

    public void a(ak akVar) {
        if (!this.ljH.getBaseFragmentActivity().isProgressBarShown()) {
            this.lBw = new aj(this.ljH, this.ljH.iEe);
            this.lBv = new AlertDialog.Builder(this.ljH.getContext(), R.style.DialogTheme).create();
            this.lBv.setCanceledOnTouchOutside(true);
            g.showDialog(this.lBv, this.ljH.getFragmentActivity());
            Window window = this.lBv.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.lBw.getView());
            this.lBw.uq(akVar == null ? false : akVar.ltg);
            this.lBw.ur(akVar == null ? false : akVar.ltk);
            this.lBw.us(akVar == null ? false : akVar.lto);
            this.lBw.uu(akVar == null ? false : akVar.ltl);
            this.lBw.uv(akVar == null ? true : akVar.lti);
            if (akVar == null) {
                this.lBw.ao(false, false);
                this.lBw.ap(false, false);
            } else {
                this.lBw.ao(akVar.ltm, akVar.ltt);
                this.lBw.ap(akVar.ltn, akVar.lts);
            }
            boolean z = akVar == null ? false : akVar.Fc;
            boolean z2 = akVar == null ? false : akVar.isHostOnly;
            boolean z3 = akVar == null ? false : akVar.ltj;
            boolean z4 = akVar == null ? false : akVar.lth;
            boolean z5 = akVar == null ? false : akVar.ltq;
            boolean z6 = akVar == null ? false : akVar.ltp;
            this.lBw.an(z3, z2);
            this.lBw.aq(z4, z);
            this.lBw.ar(z6, z5);
            if (akVar != null) {
                this.lBw.ltd = akVar.ltu;
                if (akVar.ltu) {
                    this.lBw.dki().setText(R.string.report_text);
                    this.lBw.uu(false);
                }
            }
            this.lBw.ut(akVar != null ? akVar.ltv : false);
            if (!TbSingleton.getInstance().mCanCallFans && this.ljH.dgX() != null && this.ljH.dgX().getPbData() != null && this.ljH.dgX().getPbData().getThreadId() != null && this.ljH.dgX().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                this.lBw.dkl().setText(R.string.have_called_fans_short);
            }
            dmD();
        }
    }

    private void dmD() {
        if (this.lBw != null) {
            this.lBw.dkp();
        }
    }

    public void aXc() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.lBv != null) {
                        g.dismissDialog(c.this.lBv, c.this.ljH.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.mY().postDelayed(this.runnable, 100L);
    }

    public void dmE() {
        if (this.lBv != null) {
            g.dismissDialog(this.lBv, this.ljH.getPageContext().getPageActivity());
        }
    }

    public aj dmF() {
        return this.lBw;
    }

    public View dmG() {
        return this.jXu;
    }

    public boolean dmH() {
        return this.lBv != null && this.lBv.isShowing();
    }

    public void releaseResources() {
        if (this.lBw != null) {
            this.lBw.release();
        }
        this.lBv = null;
        this.lBw = null;
        e.mY().removeCallbacks(this.runnable);
    }

    public void dmI() {
        if (this.lBs != null) {
            this.lBs.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.ljH.getPageContext(), i);
            ap.setBackgroundResource(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
        }
        SvgManager.boN().a(this.gzN, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.boN().a(this.agS, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setNavbarTitleColor(this.lBr, R.color.cp_cont_b, R.color.s_navbar_title_color);
        ap.setViewTextColor(this.eQX, R.color.cp_cont_b);
        dmD();
    }

    public void FY(int i) {
        this.mNavigationBar.onChangeSkinType(this.ljH.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha85));
        if (this.agS != null) {
            SvgManager.boN().a(this.agS, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.lBr.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_cont_g));
        SvgManager.boN().a(this.gzN, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void dmJ() {
        this.gzN.setVisibility(0);
        uZ(false);
        if (this.lBs != null) {
            this.lBs.setVisibility(8);
        }
    }

    public void uY(boolean z) {
        this.gzN.setVisibility(0);
        uZ(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.lBs != null) {
                this.lBs.setVisibility(0);
            }
        } else if (this.lBs != null) {
            this.lBs.setVisibility(8);
        }
    }

    public void uZ(boolean z) {
        if (!this.lwA && z && !"".equals(this.lBr.getText().toString())) {
            this.lBr.setVisibility(0);
        } else {
            this.lBr.setVisibility(8);
        }
    }

    public void va(boolean z) {
        this.lBx = z;
    }

    public void dll() {
        if ((!this.lBx || TbadkCoreApplication.isLogin()) && !com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean(SharedPrefConfig.SHOW_SHARE, false)) {
            View inflate = LayoutInflater.from(this.ljH.getPageContext().getContext()).inflate(R.layout.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.arrow_up);
            TextView textView = (TextView) inflate.findViewById(R.id.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.gravity = 5;
            if (!TbadkCoreApplication.isLogin()) {
                layoutParams.rightMargin = l.getDimens(this.ljH.getContext(), R.dimen.ds28);
            } else {
                layoutParams.rightMargin = l.getDimens(this.ljH.getContext(), R.dimen.ds128);
            }
            textView.setText(R.string.share_tip);
            textView.setOnClickListener(this.jeu);
            this.lBy = new PopupWindow(inflate, -2, -2);
        }
    }

    public void dmK() {
        if (this.jet != null) {
            e.mY().removeCallbacks(this.jet);
        }
        cEb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEb() {
        g.dismissPopupWindow(this.lBy);
    }

    public void dm(View view) {
    }

    public void fU(String str, String str2) {
        if (this.ljH != null && this.lBt != null) {
            if (StringUtils.isNull(str)) {
                this.lBu.setVisibility(8);
                this.eQX.setText("贴吧动态");
                return;
            }
            this.lBu.setVisibility(0);
            this.mForumName = str;
            ay.a(this.eQX, str, R.string.forum, R.dimen.tbds0, 1, this.lBC, false);
            k.bhh().setForumNameForWaterImage(str);
            this.lBu.startLoad(str2, 10, false);
        }
    }
}
