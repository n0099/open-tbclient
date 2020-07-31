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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.aj;
import com.baidu.tieba.pb.pb.main.ak;
/* loaded from: classes16.dex */
public class c {
    private ImageView aeV;
    public final View eJG;
    public TextView eko;
    private ImageView fOc;
    private final ImageView iYo;
    private final LinearLayout iYp;
    public TextView kBk;
    public View kBl;
    public LinearLayout kBm;
    public BarImageView kBn;
    private PopupWindow kBq;
    private int kBr;
    private int kBs;
    private int kBt;
    private int kBu;
    private PbFragment kjZ;
    public String mForumName;
    public final NavigationBar mNavigationBar;
    private Runnable runnable;
    private boolean kww = false;
    private AlertDialog kBo = null;
    private aj kBp = null;
    private boolean kiD = false;
    private boolean kBv = true;
    private Runnable ihy = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.cjz();
        }
    };
    private View.OnClickListener ihz = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.cRz();
        }
    };

    public c(PbFragment pbFragment, View view) {
        this.kBr = 0;
        this.kBs = 0;
        this.kBt = 0;
        this.kBu = 0;
        this.kjZ = pbFragment;
        this.kBr = l.getDimens(pbFragment.getContext(), R.dimen.ds88);
        this.kBs = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds14);
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        this.kBt = ((int) (equipmentWidth * 0.07d)) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds102);
        if (this.kBt - dimens > 0) {
            this.kBt -= dimens;
        }
        this.kBu = (equipmentWidth - (this.kBt * 2)) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds89);
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                c.this.kjZ.cbV();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.eJG = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbFragment.hIl);
        this.kBk = this.mNavigationBar.setCenterTextTitle("");
        this.iYo = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.iYp = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        this.iYp.setPadding(dimens2, 0, dimens2, 0);
        ao.setNavbarIconSrc(this.iYo, R.drawable.icon_pb_play_small, R.drawable.icon_pb_play_small);
        this.iYo.setVisibility(8);
        this.kBk.setOnClickListener(pbFragment.hIl);
        this.iYo.setOnClickListener(pbFragment.hIl);
        this.fOc = (ImageView) this.eJG.findViewById(R.id.widget_navi_back_button);
        if (this.kBm == null) {
            this.kBm = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.nav_fourm_title_layout, (View.OnClickListener) null);
            this.kBn = (BarImageView) this.kBm.findViewById(R.id.pb_nav_title_forum_image);
            this.kBn.setShowOval(true);
            this.kBn.setOnClickListener(pbFragment.hIl);
            this.eko = (TextView) this.kBm.findViewById(R.id.pb_nav_title_forum_name);
            this.eko.setOnClickListener(pbFragment.hIl);
            if (this.kBm.getLayoutParams() != null && (this.kBm.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.kBt > 0 && this.kBu > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.kBm.getLayoutParams();
                marginLayoutParams.leftMargin = this.kBt;
                marginLayoutParams.rightMargin = this.kBt;
                this.kBm.setLayoutParams(marginLayoutParams);
            }
            if (this.kBm.getVisibility() == 8) {
                this.kBm.setVisibility(0);
            }
            if (this.kBm.getAlpha() != 1.0f) {
                this.kBm.setAlpha(1.0f);
            }
        }
    }

    public void tg(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.kww = z;
        if (this.kBl == null && this.aeV == null) {
            this.kBl = this.mNavigationBar.addCustomView(controlAlign, R.layout.nb_item_floor_more, this.kjZ.hIl);
            this.aeV = (ImageView) this.kBl.findViewById(R.id.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.kBr, this.kBr);
            layoutParams.rightMargin = this.kBs;
            this.kBl.setLayoutParams(layoutParams);
            SvgManager.baR().a(this.aeV, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.kBl.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void sL(boolean z) {
        if (this.kBl != null) {
            this.kBl.setVisibility(z ? 0 : 8);
        }
    }

    public NavigationBar cRr() {
        return this.mNavigationBar;
    }

    public void th(boolean z) {
        if (z) {
            this.eJG.setVisibility(0);
        } else {
            this.eJG.setVisibility(8);
        }
        tj(z);
    }

    public void IG(String str) {
        if (!TextUtils.isEmpty(str) && !this.kww) {
            this.kBk.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            tj(true);
            k.aTv().setForumNameForWaterImage(str);
            return;
        }
        tj(false);
    }

    public void a(ak akVar) {
        if (!this.kjZ.getBaseFragmentActivity().isProgressBarShown()) {
            this.kBp = new aj(this.kjZ, this.kjZ.hIl);
            this.kBo = new AlertDialog.Builder(this.kjZ.getContext(), R.style.DialogTheme).create();
            this.kBo.setCanceledOnTouchOutside(true);
            g.showDialog(this.kBo, this.kjZ.getFragmentActivity());
            Window window = this.kBo.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.kBp.getView());
            this.kBp.sA(akVar == null ? false : akVar.ktd);
            this.kBp.sB(akVar == null ? false : akVar.kth);
            this.kBp.sC(akVar == null ? false : akVar.ktl);
            this.kBp.sE(akVar == null ? false : akVar.kti);
            this.kBp.sF(akVar == null ? true : akVar.ktf);
            if (akVar == null) {
                this.kBp.ag(false, false);
                this.kBp.ah(false, false);
            } else {
                this.kBp.ag(akVar.ktj, akVar.ktp);
                this.kBp.ah(akVar.ktk, akVar.kto);
            }
            boolean z = akVar == null ? false : akVar.Ef;
            boolean z2 = akVar == null ? false : akVar.isHostOnly;
            boolean z3 = akVar == null ? false : akVar.ktg;
            boolean z4 = akVar == null ? false : akVar.kte;
            boolean z5 = akVar == null ? false : akVar.ktn;
            boolean z6 = akVar == null ? false : akVar.ktm;
            this.kBp.af(z3, z2);
            this.kBp.ai(z4, z);
            this.kBp.aj(z6, z5);
            if (akVar != null) {
                this.kBp.kta = akVar.ktq;
                if (akVar.ktq) {
                    this.kBp.cOY().setText(R.string.report_text);
                    this.kBp.sE(false);
                }
            }
            this.kBp.sD(akVar != null ? akVar.ktr : false);
            if (!TbSingleton.getInstance().mCanCallFans && this.kjZ.cLP() != null && this.kjZ.cLP().getPbData() != null && this.kjZ.cLP().getPbData().getThreadId() != null && this.kjZ.cLP().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                this.kBp.cPb().setText(R.string.have_called_fans_short);
            }
            cRs();
        }
    }

    private void cRs() {
        if (this.kBp != null) {
            this.kBp.cPf();
        }
    }

    public void aIX() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.kBo != null) {
                        g.dismissDialog(c.this.kBo, c.this.kjZ.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.lt().postDelayed(this.runnable, 100L);
    }

    public void cRt() {
        if (this.kBo != null) {
            g.dismissDialog(this.kBo, this.kjZ.getPageContext().getPageActivity());
        }
    }

    public aj cRu() {
        return this.kBp;
    }

    public View cRv() {
        return this.iYo;
    }

    public boolean cRw() {
        return this.kBo != null && this.kBo.isShowing();
    }

    public void releaseResources() {
        if (this.kBp != null) {
            this.kBp.release();
        }
        this.kBo = null;
        this.kBp = null;
        e.lt().removeCallbacks(this.runnable);
    }

    public void cRx() {
        if (this.kBl != null) {
            this.kBl.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.kjZ.getPageContext(), i);
            ao.setBackgroundResource(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
        }
        SvgManager.baR().a(this.fOc, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.baR().a(this.aeV, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ao.setNavbarTitleColor(this.kBk, R.color.cp_cont_b, R.color.s_navbar_title_color);
        ao.setViewTextColor(this.eko, R.color.cp_cont_b);
        cRs();
    }

    public void Ce(int i) {
        this.mNavigationBar.onChangeSkinType(this.kjZ.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha85));
        if (this.aeV != null) {
            SvgManager.baR().a(this.aeV, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.kBk.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_cont_g));
        SvgManager.baR().a(this.fOc, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void cRy() {
        this.fOc.setVisibility(0);
        tj(false);
        if (this.kBl != null) {
            this.kBl.setVisibility(8);
        }
    }

    public void ti(boolean z) {
        this.fOc.setVisibility(0);
        tj(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.kBl != null) {
                this.kBl.setVisibility(0);
            }
        } else if (this.kBl != null) {
            this.kBl.setVisibility(8);
        }
    }

    public void tj(boolean z) {
        if (!this.kww && z && !"".equals(this.kBk.getText().toString())) {
            this.kBk.setVisibility(0);
        } else {
            this.kBk.setVisibility(8);
        }
    }

    public void rU(boolean z) {
        this.kiD = z;
    }

    public void cQb() {
        if ((!this.kiD || TbadkCoreApplication.isLogin()) && !com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(SharedPrefConfig.SHOW_SHARE, false)) {
            View inflate = LayoutInflater.from(this.kjZ.getPageContext().getContext()).inflate(R.layout.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.arrow_up);
            TextView textView = (TextView) inflate.findViewById(R.id.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.gravity = 5;
            if (!TbadkCoreApplication.isLogin()) {
                layoutParams.rightMargin = l.getDimens(this.kjZ.getContext(), R.dimen.ds28);
            } else {
                layoutParams.rightMargin = l.getDimens(this.kjZ.getContext(), R.dimen.ds128);
            }
            textView.setText(R.string.share_tip);
            textView.setOnClickListener(this.ihz);
            this.kBq = new PopupWindow(inflate, -2, -2);
        }
    }

    public void cRz() {
        if (this.ihy != null) {
            e.lt().removeCallbacks(this.ihy);
        }
        cjz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjz() {
        g.dismissPopupWindow(this.kBq);
    }

    public void cS(View view) {
    }

    public void fd(String str, String str2) {
        if (this.kjZ != null && this.kBm != null) {
            if (StringUtils.isNull(str)) {
                this.kBn.setVisibility(8);
                this.eko.setText("贴吧动态");
                return;
            }
            this.kBn.setVisibility(0);
            this.mForumName = str;
            ax.a(this.eko, str, R.string.forum, R.dimen.tbds0, 1, this.kBu, false);
            k.aTv().setForumNameForWaterImage(str);
            this.kBn.startLoad(str2, 10, false);
        }
    }
}
