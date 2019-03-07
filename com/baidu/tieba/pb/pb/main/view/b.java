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
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.ThreadForumEnterButtonContainer;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.aa;
import com.baidu.tieba.pb.pb.main.ab;
/* loaded from: classes4.dex */
public class b {
    public TextView bSP;
    private ImageView bua;
    private Runnable cnI;
    public final View csE;
    private int dLV;
    public TextView hAS;
    public View hAT;
    private final ImageView hAU;
    private final LinearLayout hAV;
    public LinearLayout hAW;
    public BarImageView hAX;
    private ImageView hBa;
    private PopupWindow hBc;
    private boolean hBd;
    private int hBe;
    private int hBg;
    private int hBh;
    private int hBi;
    private PbActivity hpc;
    private ThreadForumEnterButtonContainer hra;
    public String mForumName;
    public final NavigationBar mNavigationBar;
    private final int hAR = 6;
    private boolean hxR = false;
    private AlertDialog hAY = null;
    private aa hAZ = null;
    private boolean hBb = false;
    private int[] hBf = new int[2];
    private boolean hBj = true;
    private Runnable fwM = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.3
        @Override // java.lang.Runnable
        public void run() {
            View view = b.this.hBd ? b.this.hAT : null;
            if (view != null) {
                if (TbadkCoreApplication.isLogin() || !b.this.hBd) {
                    g.showPopupWindowAsDropDown(b.this.hBc, view);
                    if (!b.this.hBd) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_share", true);
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("call_fan_guide", true);
                    }
                    e.jH().removeCallbacks(b.this.fwN);
                    e.jH().postDelayed(b.this.fwN, TbConfig.NOTIFY_SOUND_INTERVAL);
                }
            }
        }
    };
    private Runnable fwN = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.4
        @Override // java.lang.Runnable
        public void run() {
            b.this.bjC();
        }
    };
    private View.OnClickListener fwO = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.bNZ();
        }
    };

    public b(PbActivity pbActivity) {
        this.dLV = 0;
        this.hBe = 0;
        this.hpc = pbActivity;
        this.dLV = l.h(pbActivity, d.e.ds88);
        this.hBe = l.h(this.hpc.getPageContext().getPageActivity(), d.e.ds14);
        this.mNavigationBar = (NavigationBar) this.hpc.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hpc.bcN();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.csE = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.faZ);
        this.hAS = this.mNavigationBar.setCenterTextTitle("");
        this.hAU = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.hAV = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int h = l.h(this.hpc.getPageContext().getPageActivity(), d.e.ds20);
        this.hAV.setPadding(h, 0, h, 0);
        al.a(this.hAU, d.f.icon_pb_play_small, d.f.icon_pb_play_small);
        this.hAU.setVisibility(8);
        this.hAS.setOnClickListener(pbActivity.faZ);
        this.hAU.setOnClickListener(pbActivity.faZ);
        this.hBa = (ImageView) this.csE.findViewById(d.g.widget_navi_back_button);
        if (this.hAW == null) {
            this.hAW = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, d.h.nav_fourm_title_layout, (View.OnClickListener) null);
            this.hAX = (BarImageView) this.hAW.findViewById(d.g.pb_nav_title_forum_image);
            this.hAX.setShowOval(true);
            this.hAX.setOnClickListener(pbActivity.faZ);
            this.bSP = (TextView) this.hAW.findViewById(d.g.pb_nav_title_forum_name);
            this.bSP.setOnClickListener(pbActivity.faZ);
        }
    }

    public void of(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.hxR = z;
        if (this.hAT == null && this.bua == null) {
            this.hAT = this.mNavigationBar.addCustomView(controlAlign, d.h.nb_item_floor_more, this.hpc.faZ);
            this.bua = (ImageView) this.hAT.findViewById(d.g.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.dLV, this.dLV);
            layoutParams.rightMargin = this.hBe;
            this.hAT.setLayoutParams(layoutParams);
            al.a(this.bua, d.f.icon_nav_more_selector, d.f.icon_nav_more_selector);
            this.hAT.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void nM(boolean z) {
        if (this.hAT != null) {
            this.hAT.setVisibility(z ? 0 : 8);
        }
    }

    public NavigationBar bNS() {
        return this.mNavigationBar;
    }

    public void og(boolean z) {
        if (z) {
            this.csE.setVisibility(0);
        } else {
            this.csE.setVisibility(8);
        }
        oi(z);
    }

    public void xR(String str) {
        if (!TextUtils.isEmpty(str) && !this.hxR) {
            this.hAS.setText(this.hpc.getResources().getString(d.j.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            oi(true);
            i.Wy().kT(str);
            return;
        }
        oi(false);
    }

    public void a(ab abVar) {
        if (!this.hpc.isProgressBarShown()) {
            this.hAZ = new aa((PbActivity) this.hpc.getPageContext().getOrignalPage(), this.hpc.faZ);
            this.hAY = new AlertDialog.Builder(this.hpc, d.k.DialogTheme).create();
            this.hAY.setCanceledOnTouchOutside(true);
            g.a(this.hAY, this.hpc);
            Window window = this.hAY.getWindow();
            window.setWindowAnimations(d.k.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.hAZ.getView());
            this.hAZ.nD(abVar == null ? false : abVar.htZ);
            this.hAZ.nE(abVar == null ? false : abVar.hud);
            this.hAZ.nF(abVar == null ? false : abVar.hue);
            this.hAZ.nG(abVar == null ? false : abVar.huf);
            this.hAZ.nH(abVar == null ? true : abVar.hum);
            if (abVar == null) {
                this.hAZ.W(false, false);
                this.hAZ.X(false, false);
                this.hAZ.v(false, "");
            } else {
                this.hAZ.W(abVar.hub, abVar.huj);
                this.hAZ.X(abVar.huc, abVar.hui);
                this.hAZ.v(StringUtils.isNull(abVar.hul) ? false : true, abVar.hul);
            }
            boolean z = abVar == null ? false : abVar.qV;
            boolean z2 = abVar == null ? false : abVar.isHostOnly;
            boolean z3 = abVar == null ? false : abVar.huk;
            boolean z4 = abVar == null ? false : abVar.hua;
            boolean z5 = abVar == null ? false : abVar.hug;
            boolean z6 = abVar == null ? false : abVar.huh;
            this.hAZ.V(z3, z2);
            this.hAZ.Y(z4, z);
            this.hAZ.Z(z6, z5);
            if (abVar != null) {
                this.hAZ.htW = abVar.hun;
                if (abVar.hun) {
                    this.hAZ.bLT().setText(d.j.report_text);
                    this.hAZ.nG(false);
                }
            }
            ad(z, z2);
        }
    }

    public void bNT() {
        this.hAZ.bLZ().setText(this.hpc.getResources().getString(d.j.haved_fans_call));
    }

    private void ad(boolean z, boolean z2) {
        if (this.hAZ != null) {
            this.hAZ.setBackGround();
        }
    }

    public void Qk() {
        if (this.cnI == null) {
            this.cnI = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.hAY != null) {
                        g.b(b.this.hAY, b.this.hpc.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.jH().postDelayed(this.cnI, 100L);
    }

    public void bNU() {
        if (this.hAY != null) {
            g.b(this.hAY, this.hpc.getPageContext().getPageActivity());
        }
    }

    public aa bNV() {
        return this.hAZ;
    }

    public View bNW() {
        return this.hAU;
    }

    public boolean aRo() {
        return this.hAY != null && this.hAY.isShowing();
    }

    public void bzn() {
        if (this.hAZ != null) {
            this.hAZ.release();
        }
        this.hAY = null;
        this.hAZ = null;
        e.jH().removeCallbacks(this.cnI);
    }

    public void bNX() {
        if (this.hAT != null) {
            this.hAT.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.hpc.getPageContext(), i);
            al.k(this.mNavigationBar.getBarBgView(), d.C0236d.cp_bg_line_d);
        }
        aq.ado().d(this.hBa, d.f.icon_topbar_return_n_svg, d.C0236d.select_topbar_icon_color_tint);
        aq.ado().d(this.bua, d.f.icon_topbar_more_n_svg, d.C0236d.select_topbar_icon_color_tint);
        al.c(this.hAS, d.C0236d.cp_cont_b, d.C0236d.s_navbar_title_color);
        al.j(this.bSP, d.C0236d.cp_cont_b);
    }

    public void wG(int i) {
        this.mNavigationBar.onChangeSkinType(this.hpc.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(d.f.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.hpc.getResources().getColor(d.C0236d.black_alpha85));
        if (this.bua != null) {
            this.bua.setImageResource(d.f.icon_vnav_more_bg);
        }
        this.hAS.setTextColor(this.hpc.getResources().getColor(d.C0236d.cp_cont_g));
        this.hBa.setImageResource(d.f.icon_return_bg);
    }

    public void bNY() {
        this.hBa.setVisibility(0);
        oi(false);
        if (this.hAT != null) {
            this.hAT.setVisibility(8);
        }
    }

    public void oh(boolean z) {
        this.hBa.setVisibility(0);
        oi(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.hAT != null) {
                this.hAT.setVisibility(0);
            }
        } else if (this.hAT != null) {
            this.hAT.setVisibility(8);
        }
    }

    public void oi(boolean z) {
        if (!this.hxR && z && !"".equals(this.hAS.getText().toString())) {
            this.hAS.setVisibility(0);
        } else {
            this.hAS.setVisibility(8);
        }
    }

    public void oj(boolean z) {
        this.hBb = z;
    }

    public void ok(boolean z) {
        if (!this.hBb || TbadkCoreApplication.isLogin() || z) {
            if (z) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("call_fan_guide", false)) {
                    ok(false);
                    return;
                }
            } else if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_share", false)) {
                return;
            }
            this.hBd = z;
            View inflate = LayoutInflater.from(this.hpc.getPageContext().getContext()).inflate(d.h.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(d.g.arrow_up);
            TextView textView = (TextView) inflate.findViewById(d.g.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            if (!z) {
                layoutParams.gravity = 5;
                if (!TbadkCoreApplication.isLogin()) {
                    layoutParams.rightMargin = l.h(this.hpc, d.e.ds28);
                } else {
                    layoutParams.rightMargin = l.h(this.hpc, d.e.ds128);
                }
                textView.setText(d.j.share_tip);
                textView.setOnClickListener(this.fwO);
                this.hBc = new PopupWindow(inflate, -2, -2);
                e.jH().removeCallbacks(this.fwM);
                e.jH().postDelayed(this.fwM, 500L);
            }
        }
    }

    public void bNZ() {
        if (this.fwM != null) {
            e.jH().removeCallbacks(this.fwM);
        }
        if (this.fwN != null) {
            e.jH().removeCallbacks(this.fwN);
        }
        bjC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjC() {
        g.a(this.hBc);
    }

    public void a(ThreadForumEnterButtonContainer threadForumEnterButtonContainer) {
        if (threadForumEnterButtonContainer != null && !ap.isEmpty(this.mForumName) && !this.hBb) {
            this.hra = threadForumEnterButtonContainer;
            this.hra.getLocationOnScreen(this.hBf);
            this.hBg = this.hBf[1];
            this.hBh = this.hra.getHeight();
            this.hBi = this.mNavigationBar.getHeight();
            if (!this.hra.isShown()) {
                if (this.hAW.getVisibility() == 8) {
                    this.hAW.setVisibility(0);
                }
                if (this.hAW.getAlpha() != 1.0f) {
                    this.hAW.setAlpha(1.0f);
                }
            } else if (this.hBg >= this.hBi) {
                if (this.hAW.getVisibility() == 0) {
                    this.hAW.setVisibility(8);
                    this.hBj = true;
                }
                if (this.hAW.getAlpha() != 0.0f) {
                    this.hAW.setAlpha(0.0f);
                }
            } else if (this.hBg < this.hBi && this.hBg > 0) {
                if (this.hAW.getVisibility() == 8) {
                    this.hAW.setVisibility(0);
                    bOa();
                }
                this.hAW.setAlpha(1.0f - ((((this.hBg + this.hBh) - this.hBi) * 1.0f) / this.hBh));
            } else if (this.hBg <= 0) {
                if (this.hAW.getVisibility() == 8) {
                    this.hAW.setVisibility(0);
                    bOa();
                }
                if (this.hAW.getAlpha() != 1.0f) {
                    this.hAW.setAlpha(1.0f);
                }
            }
        }
    }

    public void dA(String str, String str2) {
        if (this.hpc != null) {
            this.mForumName = str;
            if (str.length() > 6) {
                str = str.substring(0, 6) + "...";
            }
            this.bSP.setText(str + this.hpc.getResources().getString(d.j.forum));
            this.hAX.startLoad(str2, 10, false);
        }
    }

    private void bOa() {
        if (this.hpc != null && this.hpc.bJa() != null && this.hBj) {
            this.hBj = false;
            am amVar = new am("c13400");
            amVar.bJ("tid", this.hpc.bJa().bKR());
            amVar.bJ(ImageViewerConfig.FORUM_ID, this.hpc.bJa().getForumId());
            amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(amVar);
        }
    }
}
