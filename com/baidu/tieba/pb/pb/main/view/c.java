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
    private ImageView agh;
    public final View eUq;
    public TextView eun;
    private ImageView gae;
    private final ImageView jnw;
    private final LinearLayout jnx;
    public TextView kQY;
    public View kQZ;
    public LinearLayout kRa;
    public BarImageView kRb;
    private PopupWindow kRe;
    private int kRf;
    private int kRg;
    private int kRh;
    private int kRi;
    private PbFragment kzA;
    public String mForumName;
    public final NavigationBar mNavigationBar;
    private Runnable runnable;
    private boolean kMk = false;
    private AlertDialog kRc = null;
    private aj kRd = null;
    private boolean kye = false;
    private boolean kRj = true;
    private Runnable ivL = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.cue();
        }
    };
    private View.OnClickListener ivM = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.dcq();
        }
    };

    public c(PbFragment pbFragment, View view) {
        this.kRf = 0;
        this.kRg = 0;
        this.kRh = 0;
        this.kRi = 0;
        this.kzA = pbFragment;
        this.kRf = l.getDimens(pbFragment.getContext(), R.dimen.ds88);
        this.kRg = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds14);
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        this.kRh = ((int) (equipmentWidth * 0.07d)) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds102);
        if (this.kRh - dimens > 0) {
            this.kRh -= dimens;
        }
        this.kRi = (equipmentWidth - (this.kRh * 2)) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds89);
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                c.this.kzA.cmt();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.eUq = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbFragment.hVH);
        this.kQY = this.mNavigationBar.setCenterTextTitle("");
        this.jnw = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.jnx = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        this.jnx.setPadding(dimens2, 0, dimens2, 0);
        ap.setNavbarIconSrc(this.jnw, R.drawable.icon_pb_play_small, R.drawable.icon_pb_play_small);
        this.jnw.setVisibility(8);
        this.kQY.setOnClickListener(pbFragment.hVH);
        this.jnw.setOnClickListener(pbFragment.hVH);
        this.gae = (ImageView) this.eUq.findViewById(R.id.widget_navi_back_button);
        if (this.kRa == null) {
            this.kRa = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.nav_fourm_title_layout, (View.OnClickListener) null);
            this.kRb = (BarImageView) this.kRa.findViewById(R.id.pb_nav_title_forum_image);
            this.kRb.setShowOval(true);
            this.kRb.setOnClickListener(pbFragment.hVH);
            this.eun = (TextView) this.kRa.findViewById(R.id.pb_nav_title_forum_name);
            this.eun.setOnClickListener(pbFragment.hVH);
            if (this.kRa.getLayoutParams() != null && (this.kRa.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.kRh > 0 && this.kRi > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.kRa.getLayoutParams();
                marginLayoutParams.leftMargin = this.kRh;
                marginLayoutParams.rightMargin = this.kRh;
                this.kRa.setLayoutParams(marginLayoutParams);
            }
            if (this.kRa.getVisibility() == 8) {
                this.kRa.setVisibility(0);
            }
            if (this.kRa.getAlpha() != 1.0f) {
                this.kRa.setAlpha(1.0f);
            }
        }
    }

    public void tR(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.kMk = z;
        if (this.kQZ == null && this.agh == null) {
            this.kQZ = this.mNavigationBar.addCustomView(controlAlign, R.layout.nb_item_floor_more, this.kzA.hVH);
            this.agh = (ImageView) this.kQZ.findViewById(R.id.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.kRf, this.kRf);
            layoutParams.rightMargin = this.kRg;
            this.kQZ.setLayoutParams(layoutParams);
            SvgManager.bjq().a(this.agh, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.kQZ.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void tw(boolean z) {
        if (this.kQZ != null) {
            this.kQZ.setVisibility(z ? 0 : 8);
        }
    }

    public NavigationBar dci() {
        return this.mNavigationBar;
    }

    public void tS(boolean z) {
        if (z) {
            this.eUq.setVisibility(0);
        } else {
            this.eUq.setVisibility(8);
        }
        tU(z);
    }

    public void Lz(String str) {
        if (!TextUtils.isEmpty(str) && !this.kMk) {
            this.kQY.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            tU(true);
            k.bbM().setForumNameForWaterImage(str);
            return;
        }
        tU(false);
    }

    public void a(ak akVar) {
        if (!this.kzA.getBaseFragmentActivity().isProgressBarShown()) {
            this.kRd = new aj(this.kzA, this.kzA.hVH);
            this.kRc = new AlertDialog.Builder(this.kzA.getContext(), R.style.DialogTheme).create();
            this.kRc.setCanceledOnTouchOutside(true);
            g.showDialog(this.kRc, this.kzA.getFragmentActivity());
            Window window = this.kRc.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.kRd.getView());
            this.kRd.tl(akVar == null ? false : akVar.kIR);
            this.kRd.tm(akVar == null ? false : akVar.kIV);
            this.kRd.tn(akVar == null ? false : akVar.kIZ);
            this.kRd.tp(akVar == null ? false : akVar.kIW);
            this.kRd.tq(akVar == null ? true : akVar.kIT);
            if (akVar == null) {
                this.kRd.ak(false, false);
                this.kRd.al(false, false);
            } else {
                this.kRd.ak(akVar.kIX, akVar.kJd);
                this.kRd.al(akVar.kIY, akVar.kJc);
            }
            boolean z = akVar == null ? false : akVar.EK;
            boolean z2 = akVar == null ? false : akVar.isHostOnly;
            boolean z3 = akVar == null ? false : akVar.kIU;
            boolean z4 = akVar == null ? false : akVar.kIS;
            boolean z5 = akVar == null ? false : akVar.kJb;
            boolean z6 = akVar == null ? false : akVar.kJa;
            this.kRd.aj(z3, z2);
            this.kRd.am(z4, z);
            this.kRd.an(z6, z5);
            if (akVar != null) {
                this.kRd.kIO = akVar.kJe;
                if (akVar.kJe) {
                    this.kRd.cZP().setText(R.string.report_text);
                    this.kRd.tp(false);
                }
            }
            this.kRd.to(akVar != null ? akVar.kJf : false);
            if (!TbSingleton.getInstance().mCanCallFans && this.kzA.cWE() != null && this.kzA.cWE().getPbData() != null && this.kzA.cWE().getPbData().getThreadId() != null && this.kzA.cWE().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                this.kRd.cZS().setText(R.string.have_called_fans_short);
            }
            dcj();
        }
    }

    private void dcj() {
        if (this.kRd != null) {
            this.kRd.cZW();
        }
    }

    public void aRN() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.kRc != null) {
                        g.dismissDialog(c.this.kRc, c.this.kzA.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.mS().postDelayed(this.runnable, 100L);
    }

    public void dck() {
        if (this.kRc != null) {
            g.dismissDialog(this.kRc, this.kzA.getPageContext().getPageActivity());
        }
    }

    public aj dcl() {
        return this.kRd;
    }

    public View dcm() {
        return this.jnw;
    }

    public boolean dcn() {
        return this.kRc != null && this.kRc.isShowing();
    }

    public void releaseResources() {
        if (this.kRd != null) {
            this.kRd.release();
        }
        this.kRc = null;
        this.kRd = null;
        e.mS().removeCallbacks(this.runnable);
    }

    public void dco() {
        if (this.kQZ != null) {
            this.kQZ.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.kzA.getPageContext(), i);
            ap.setBackgroundResource(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
        }
        SvgManager.bjq().a(this.gae, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.bjq().a(this.agh, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setNavbarTitleColor(this.kQY, R.color.cp_cont_b, R.color.s_navbar_title_color);
        ap.setViewTextColor(this.eun, R.color.cp_cont_b);
        dcj();
    }

    public void Ey(int i) {
        this.mNavigationBar.onChangeSkinType(this.kzA.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha85));
        if (this.agh != null) {
            SvgManager.bjq().a(this.agh, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.kQY.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_cont_g));
        SvgManager.bjq().a(this.gae, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void dcp() {
        this.gae.setVisibility(0);
        tU(false);
        if (this.kQZ != null) {
            this.kQZ.setVisibility(8);
        }
    }

    public void tT(boolean z) {
        this.gae.setVisibility(0);
        tU(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.kQZ != null) {
                this.kQZ.setVisibility(0);
            }
        } else if (this.kQZ != null) {
            this.kQZ.setVisibility(8);
        }
    }

    public void tU(boolean z) {
        if (!this.kMk && z && !"".equals(this.kQY.getText().toString())) {
            this.kQY.setVisibility(0);
        } else {
            this.kQY.setVisibility(8);
        }
    }

    public void sD(boolean z) {
        this.kye = z;
    }

    public void daS() {
        if ((!this.kye || TbadkCoreApplication.isLogin()) && !com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.SHOW_SHARE, false)) {
            View inflate = LayoutInflater.from(this.kzA.getPageContext().getContext()).inflate(R.layout.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.arrow_up);
            TextView textView = (TextView) inflate.findViewById(R.id.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.gravity = 5;
            if (!TbadkCoreApplication.isLogin()) {
                layoutParams.rightMargin = l.getDimens(this.kzA.getContext(), R.dimen.ds28);
            } else {
                layoutParams.rightMargin = l.getDimens(this.kzA.getContext(), R.dimen.ds128);
            }
            textView.setText(R.string.share_tip);
            textView.setOnClickListener(this.ivM);
            this.kRe = new PopupWindow(inflate, -2, -2);
        }
    }

    public void dcq() {
        if (this.ivL != null) {
            e.mS().removeCallbacks(this.ivL);
        }
        cue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cue() {
        g.dismissPopupWindow(this.kRe);
    }

    public void cW(View view) {
    }

    public void fv(String str, String str2) {
        if (this.kzA != null && this.kRa != null) {
            if (StringUtils.isNull(str)) {
                this.kRb.setVisibility(8);
                this.eun.setText("贴吧动态");
                return;
            }
            this.kRb.setVisibility(0);
            this.mForumName = str;
            ay.a(this.eun, str, R.string.forum, R.dimen.tbds0, 1, this.kRi, false);
            k.bbM().setForumNameForWaterImage(str);
            this.kRb.startLoad(str2, 10, false);
        }
    }
}
