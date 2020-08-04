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
    private final ImageView iYq;
    private final LinearLayout iYr;
    public TextView kBm;
    public View kBn;
    public LinearLayout kBo;
    public BarImageView kBp;
    private PopupWindow kBs;
    private int kBt;
    private int kBu;
    private int kBv;
    private int kBw;
    private PbFragment kkb;
    public String mForumName;
    public final NavigationBar mNavigationBar;
    private Runnable runnable;
    private boolean kwy = false;
    private AlertDialog kBq = null;
    private aj kBr = null;
    private boolean kiF = false;
    private boolean kBx = true;
    private Runnable ihA = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.cjz();
        }
    };
    private View.OnClickListener ihB = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.cRz();
        }
    };

    public c(PbFragment pbFragment, View view) {
        this.kBt = 0;
        this.kBu = 0;
        this.kBv = 0;
        this.kBw = 0;
        this.kkb = pbFragment;
        this.kBt = l.getDimens(pbFragment.getContext(), R.dimen.ds88);
        this.kBu = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds14);
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        this.kBv = ((int) (equipmentWidth * 0.07d)) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds102);
        if (this.kBv - dimens > 0) {
            this.kBv -= dimens;
        }
        this.kBw = (equipmentWidth - (this.kBv * 2)) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds89);
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                c.this.kkb.cbV();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.eJG = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbFragment.hIl);
        this.kBm = this.mNavigationBar.setCenterTextTitle("");
        this.iYq = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.iYr = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        this.iYr.setPadding(dimens2, 0, dimens2, 0);
        ao.setNavbarIconSrc(this.iYq, R.drawable.icon_pb_play_small, R.drawable.icon_pb_play_small);
        this.iYq.setVisibility(8);
        this.kBm.setOnClickListener(pbFragment.hIl);
        this.iYq.setOnClickListener(pbFragment.hIl);
        this.fOc = (ImageView) this.eJG.findViewById(R.id.widget_navi_back_button);
        if (this.kBo == null) {
            this.kBo = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.nav_fourm_title_layout, (View.OnClickListener) null);
            this.kBp = (BarImageView) this.kBo.findViewById(R.id.pb_nav_title_forum_image);
            this.kBp.setShowOval(true);
            this.kBp.setOnClickListener(pbFragment.hIl);
            this.eko = (TextView) this.kBo.findViewById(R.id.pb_nav_title_forum_name);
            this.eko.setOnClickListener(pbFragment.hIl);
            if (this.kBo.getLayoutParams() != null && (this.kBo.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.kBv > 0 && this.kBw > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.kBo.getLayoutParams();
                marginLayoutParams.leftMargin = this.kBv;
                marginLayoutParams.rightMargin = this.kBv;
                this.kBo.setLayoutParams(marginLayoutParams);
            }
            if (this.kBo.getVisibility() == 8) {
                this.kBo.setVisibility(0);
            }
            if (this.kBo.getAlpha() != 1.0f) {
                this.kBo.setAlpha(1.0f);
            }
        }
    }

    public void tg(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.kwy = z;
        if (this.kBn == null && this.aeV == null) {
            this.kBn = this.mNavigationBar.addCustomView(controlAlign, R.layout.nb_item_floor_more, this.kkb.hIl);
            this.aeV = (ImageView) this.kBn.findViewById(R.id.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.kBt, this.kBt);
            layoutParams.rightMargin = this.kBu;
            this.kBn.setLayoutParams(layoutParams);
            SvgManager.baR().a(this.aeV, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.kBn.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void sL(boolean z) {
        if (this.kBn != null) {
            this.kBn.setVisibility(z ? 0 : 8);
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
        if (!TextUtils.isEmpty(str) && !this.kwy) {
            this.kBm.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            tj(true);
            k.aTv().setForumNameForWaterImage(str);
            return;
        }
        tj(false);
    }

    public void a(ak akVar) {
        if (!this.kkb.getBaseFragmentActivity().isProgressBarShown()) {
            this.kBr = new aj(this.kkb, this.kkb.hIl);
            this.kBq = new AlertDialog.Builder(this.kkb.getContext(), R.style.DialogTheme).create();
            this.kBq.setCanceledOnTouchOutside(true);
            g.showDialog(this.kBq, this.kkb.getFragmentActivity());
            Window window = this.kBq.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.kBr.getView());
            this.kBr.sA(akVar == null ? false : akVar.ktf);
            this.kBr.sB(akVar == null ? false : akVar.ktj);
            this.kBr.sC(akVar == null ? false : akVar.ktn);
            this.kBr.sE(akVar == null ? false : akVar.ktk);
            this.kBr.sF(akVar == null ? true : akVar.kth);
            if (akVar == null) {
                this.kBr.ag(false, false);
                this.kBr.ah(false, false);
            } else {
                this.kBr.ag(akVar.ktl, akVar.ktr);
                this.kBr.ah(akVar.ktm, akVar.ktq);
            }
            boolean z = akVar == null ? false : akVar.Ef;
            boolean z2 = akVar == null ? false : akVar.isHostOnly;
            boolean z3 = akVar == null ? false : akVar.kti;
            boolean z4 = akVar == null ? false : akVar.ktg;
            boolean z5 = akVar == null ? false : akVar.ktp;
            boolean z6 = akVar == null ? false : akVar.kto;
            this.kBr.af(z3, z2);
            this.kBr.ai(z4, z);
            this.kBr.aj(z6, z5);
            if (akVar != null) {
                this.kBr.ktc = akVar.kts;
                if (akVar.kts) {
                    this.kBr.cOY().setText(R.string.report_text);
                    this.kBr.sE(false);
                }
            }
            this.kBr.sD(akVar != null ? akVar.ktt : false);
            if (!TbSingleton.getInstance().mCanCallFans && this.kkb.cLP() != null && this.kkb.cLP().getPbData() != null && this.kkb.cLP().getPbData().getThreadId() != null && this.kkb.cLP().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                this.kBr.cPb().setText(R.string.have_called_fans_short);
            }
            cRs();
        }
    }

    private void cRs() {
        if (this.kBr != null) {
            this.kBr.cPf();
        }
    }

    public void aIX() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.kBq != null) {
                        g.dismissDialog(c.this.kBq, c.this.kkb.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.lt().postDelayed(this.runnable, 100L);
    }

    public void cRt() {
        if (this.kBq != null) {
            g.dismissDialog(this.kBq, this.kkb.getPageContext().getPageActivity());
        }
    }

    public aj cRu() {
        return this.kBr;
    }

    public View cRv() {
        return this.iYq;
    }

    public boolean cRw() {
        return this.kBq != null && this.kBq.isShowing();
    }

    public void releaseResources() {
        if (this.kBr != null) {
            this.kBr.release();
        }
        this.kBq = null;
        this.kBr = null;
        e.lt().removeCallbacks(this.runnable);
    }

    public void cRx() {
        if (this.kBn != null) {
            this.kBn.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.kkb.getPageContext(), i);
            ao.setBackgroundResource(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
        }
        SvgManager.baR().a(this.fOc, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.baR().a(this.aeV, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ao.setNavbarTitleColor(this.kBm, R.color.cp_cont_b, R.color.s_navbar_title_color);
        ao.setViewTextColor(this.eko, R.color.cp_cont_b);
        cRs();
    }

    public void Ce(int i) {
        this.mNavigationBar.onChangeSkinType(this.kkb.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha85));
        if (this.aeV != null) {
            SvgManager.baR().a(this.aeV, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.kBm.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_cont_g));
        SvgManager.baR().a(this.fOc, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void cRy() {
        this.fOc.setVisibility(0);
        tj(false);
        if (this.kBn != null) {
            this.kBn.setVisibility(8);
        }
    }

    public void ti(boolean z) {
        this.fOc.setVisibility(0);
        tj(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.kBn != null) {
                this.kBn.setVisibility(0);
            }
        } else if (this.kBn != null) {
            this.kBn.setVisibility(8);
        }
    }

    public void tj(boolean z) {
        if (!this.kwy && z && !"".equals(this.kBm.getText().toString())) {
            this.kBm.setVisibility(0);
        } else {
            this.kBm.setVisibility(8);
        }
    }

    public void rU(boolean z) {
        this.kiF = z;
    }

    public void cQb() {
        if ((!this.kiF || TbadkCoreApplication.isLogin()) && !com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(SharedPrefConfig.SHOW_SHARE, false)) {
            View inflate = LayoutInflater.from(this.kkb.getPageContext().getContext()).inflate(R.layout.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.arrow_up);
            TextView textView = (TextView) inflate.findViewById(R.id.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.gravity = 5;
            if (!TbadkCoreApplication.isLogin()) {
                layoutParams.rightMargin = l.getDimens(this.kkb.getContext(), R.dimen.ds28);
            } else {
                layoutParams.rightMargin = l.getDimens(this.kkb.getContext(), R.dimen.ds128);
            }
            textView.setText(R.string.share_tip);
            textView.setOnClickListener(this.ihB);
            this.kBs = new PopupWindow(inflate, -2, -2);
        }
    }

    public void cRz() {
        if (this.ihA != null) {
            e.lt().removeCallbacks(this.ihA);
        }
        cjz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjz() {
        g.dismissPopupWindow(this.kBs);
    }

    public void cS(View view) {
    }

    public void fd(String str, String str2) {
        if (this.kkb != null && this.kBo != null) {
            if (StringUtils.isNull(str)) {
                this.kBp.setVisibility(8);
                this.eko.setText("贴吧动态");
                return;
            }
            this.kBp.setVisibility(0);
            this.mForumName = str;
            ax.a(this.eko, str, R.string.forum, R.dimen.tbds0, 1, this.kBw, false);
            k.aTv().setForumNameForWaterImage(str);
            this.kBp.startLoad(str2, 10, false);
        }
    }
}
