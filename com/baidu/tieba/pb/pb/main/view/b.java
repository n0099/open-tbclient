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
    public TextView hAT;
    public View hAU;
    private final ImageView hAV;
    private final LinearLayout hAW;
    public LinearLayout hAX;
    public BarImageView hAY;
    private ImageView hBb;
    private PopupWindow hBd;
    private boolean hBe;
    private int hBf;
    private int hBh;
    private int hBi;
    private int hBj;
    private PbActivity hpd;
    private ThreadForumEnterButtonContainer hrb;
    public String mForumName;
    public final NavigationBar mNavigationBar;
    private final int hAS = 6;
    private boolean hxS = false;
    private AlertDialog hAZ = null;
    private aa hBa = null;
    private boolean hBc = false;
    private int[] hBg = new int[2];
    private boolean hBk = true;
    private Runnable fwM = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.3
        @Override // java.lang.Runnable
        public void run() {
            View view = b.this.hBe ? b.this.hAU : null;
            if (view != null) {
                if (TbadkCoreApplication.isLogin() || !b.this.hBe) {
                    g.showPopupWindowAsDropDown(b.this.hBd, view);
                    if (!b.this.hBe) {
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
            b.this.bjD();
        }
    };
    private View.OnClickListener fwO = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.bOa();
        }
    };

    public b(PbActivity pbActivity) {
        this.dLV = 0;
        this.hBf = 0;
        this.hpd = pbActivity;
        this.dLV = l.h(pbActivity, d.e.ds88);
        this.hBf = l.h(this.hpd.getPageContext().getPageActivity(), d.e.ds14);
        this.mNavigationBar = (NavigationBar) this.hpd.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hpd.bcO();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.csE = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.faZ);
        this.hAT = this.mNavigationBar.setCenterTextTitle("");
        this.hAV = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.hAW = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int h = l.h(this.hpd.getPageContext().getPageActivity(), d.e.ds20);
        this.hAW.setPadding(h, 0, h, 0);
        al.a(this.hAV, d.f.icon_pb_play_small, d.f.icon_pb_play_small);
        this.hAV.setVisibility(8);
        this.hAT.setOnClickListener(pbActivity.faZ);
        this.hAV.setOnClickListener(pbActivity.faZ);
        this.hBb = (ImageView) this.csE.findViewById(d.g.widget_navi_back_button);
        if (this.hAX == null) {
            this.hAX = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, d.h.nav_fourm_title_layout, (View.OnClickListener) null);
            this.hAY = (BarImageView) this.hAX.findViewById(d.g.pb_nav_title_forum_image);
            this.hAY.setShowOval(true);
            this.hAY.setOnClickListener(pbActivity.faZ);
            this.bSP = (TextView) this.hAX.findViewById(d.g.pb_nav_title_forum_name);
            this.bSP.setOnClickListener(pbActivity.faZ);
        }
    }

    public void of(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.hxS = z;
        if (this.hAU == null && this.bua == null) {
            this.hAU = this.mNavigationBar.addCustomView(controlAlign, d.h.nb_item_floor_more, this.hpd.faZ);
            this.bua = (ImageView) this.hAU.findViewById(d.g.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.dLV, this.dLV);
            layoutParams.rightMargin = this.hBf;
            this.hAU.setLayoutParams(layoutParams);
            al.a(this.bua, d.f.icon_nav_more_selector, d.f.icon_nav_more_selector);
            this.hAU.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void nM(boolean z) {
        if (this.hAU != null) {
            this.hAU.setVisibility(z ? 0 : 8);
        }
    }

    public NavigationBar bNT() {
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

    public void xS(String str) {
        if (!TextUtils.isEmpty(str) && !this.hxS) {
            this.hAT.setText(this.hpd.getResources().getString(d.j.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            oi(true);
            i.Wy().kT(str);
            return;
        }
        oi(false);
    }

    public void a(ab abVar) {
        if (!this.hpd.isProgressBarShown()) {
            this.hBa = new aa((PbActivity) this.hpd.getPageContext().getOrignalPage(), this.hpd.faZ);
            this.hAZ = new AlertDialog.Builder(this.hpd, d.k.DialogTheme).create();
            this.hAZ.setCanceledOnTouchOutside(true);
            g.a(this.hAZ, this.hpd);
            Window window = this.hAZ.getWindow();
            window.setWindowAnimations(d.k.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.hBa.getView());
            this.hBa.nD(abVar == null ? false : abVar.hua);
            this.hBa.nE(abVar == null ? false : abVar.hue);
            this.hBa.nF(abVar == null ? false : abVar.huf);
            this.hBa.nG(abVar == null ? false : abVar.hug);
            this.hBa.nH(abVar == null ? true : abVar.hun);
            if (abVar == null) {
                this.hBa.W(false, false);
                this.hBa.X(false, false);
                this.hBa.v(false, "");
            } else {
                this.hBa.W(abVar.huc, abVar.huk);
                this.hBa.X(abVar.hud, abVar.huj);
                this.hBa.v(StringUtils.isNull(abVar.hum) ? false : true, abVar.hum);
            }
            boolean z = abVar == null ? false : abVar.qV;
            boolean z2 = abVar == null ? false : abVar.isHostOnly;
            boolean z3 = abVar == null ? false : abVar.hul;
            boolean z4 = abVar == null ? false : abVar.hub;
            boolean z5 = abVar == null ? false : abVar.huh;
            boolean z6 = abVar == null ? false : abVar.hui;
            this.hBa.V(z3, z2);
            this.hBa.Y(z4, z);
            this.hBa.Z(z6, z5);
            if (abVar != null) {
                this.hBa.htX = abVar.huo;
                if (abVar.huo) {
                    this.hBa.bLU().setText(d.j.report_text);
                    this.hBa.nG(false);
                }
            }
            ad(z, z2);
        }
    }

    public void bNU() {
        this.hBa.bMa().setText(this.hpd.getResources().getString(d.j.haved_fans_call));
    }

    private void ad(boolean z, boolean z2) {
        if (this.hBa != null) {
            this.hBa.setBackGround();
        }
    }

    public void Qk() {
        if (this.cnI == null) {
            this.cnI = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.hAZ != null) {
                        g.b(b.this.hAZ, b.this.hpd.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.jH().postDelayed(this.cnI, 100L);
    }

    public void bNV() {
        if (this.hAZ != null) {
            g.b(this.hAZ, this.hpd.getPageContext().getPageActivity());
        }
    }

    public aa bNW() {
        return this.hBa;
    }

    public View bNX() {
        return this.hAV;
    }

    public boolean aRp() {
        return this.hAZ != null && this.hAZ.isShowing();
    }

    public void bzo() {
        if (this.hBa != null) {
            this.hBa.release();
        }
        this.hAZ = null;
        this.hBa = null;
        e.jH().removeCallbacks(this.cnI);
    }

    public void bNY() {
        if (this.hAU != null) {
            this.hAU.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.hpd.getPageContext(), i);
            al.k(this.mNavigationBar.getBarBgView(), d.C0236d.cp_bg_line_d);
        }
        aq.ado().d(this.hBb, d.f.icon_topbar_return_n_svg, d.C0236d.select_topbar_icon_color_tint);
        aq.ado().d(this.bua, d.f.icon_topbar_more_n_svg, d.C0236d.select_topbar_icon_color_tint);
        al.c(this.hAT, d.C0236d.cp_cont_b, d.C0236d.s_navbar_title_color);
        al.j(this.bSP, d.C0236d.cp_cont_b);
    }

    public void wG(int i) {
        this.mNavigationBar.onChangeSkinType(this.hpd.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(d.f.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.hpd.getResources().getColor(d.C0236d.black_alpha85));
        if (this.bua != null) {
            this.bua.setImageResource(d.f.icon_vnav_more_bg);
        }
        this.hAT.setTextColor(this.hpd.getResources().getColor(d.C0236d.cp_cont_g));
        this.hBb.setImageResource(d.f.icon_return_bg);
    }

    public void bNZ() {
        this.hBb.setVisibility(0);
        oi(false);
        if (this.hAU != null) {
            this.hAU.setVisibility(8);
        }
    }

    public void oh(boolean z) {
        this.hBb.setVisibility(0);
        oi(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.hAU != null) {
                this.hAU.setVisibility(0);
            }
        } else if (this.hAU != null) {
            this.hAU.setVisibility(8);
        }
    }

    public void oi(boolean z) {
        if (!this.hxS && z && !"".equals(this.hAT.getText().toString())) {
            this.hAT.setVisibility(0);
        } else {
            this.hAT.setVisibility(8);
        }
    }

    public void oj(boolean z) {
        this.hBc = z;
    }

    public void ok(boolean z) {
        if (!this.hBc || TbadkCoreApplication.isLogin() || z) {
            if (z) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("call_fan_guide", false)) {
                    ok(false);
                    return;
                }
            } else if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_share", false)) {
                return;
            }
            this.hBe = z;
            View inflate = LayoutInflater.from(this.hpd.getPageContext().getContext()).inflate(d.h.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(d.g.arrow_up);
            TextView textView = (TextView) inflate.findViewById(d.g.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            if (!z) {
                layoutParams.gravity = 5;
                if (!TbadkCoreApplication.isLogin()) {
                    layoutParams.rightMargin = l.h(this.hpd, d.e.ds28);
                } else {
                    layoutParams.rightMargin = l.h(this.hpd, d.e.ds128);
                }
                textView.setText(d.j.share_tip);
                textView.setOnClickListener(this.fwO);
                this.hBd = new PopupWindow(inflate, -2, -2);
                e.jH().removeCallbacks(this.fwM);
                e.jH().postDelayed(this.fwM, 500L);
            }
        }
    }

    public void bOa() {
        if (this.fwM != null) {
            e.jH().removeCallbacks(this.fwM);
        }
        if (this.fwN != null) {
            e.jH().removeCallbacks(this.fwN);
        }
        bjD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjD() {
        g.a(this.hBd);
    }

    public void a(ThreadForumEnterButtonContainer threadForumEnterButtonContainer) {
        if (threadForumEnterButtonContainer != null && !ap.isEmpty(this.mForumName) && !this.hBc) {
            this.hrb = threadForumEnterButtonContainer;
            this.hrb.getLocationOnScreen(this.hBg);
            this.hBh = this.hBg[1];
            this.hBi = this.hrb.getHeight();
            this.hBj = this.mNavigationBar.getHeight();
            if (!this.hrb.isShown()) {
                if (this.hAX.getVisibility() == 8) {
                    this.hAX.setVisibility(0);
                }
                if (this.hAX.getAlpha() != 1.0f) {
                    this.hAX.setAlpha(1.0f);
                }
            } else if (this.hBh >= this.hBj) {
                if (this.hAX.getVisibility() == 0) {
                    this.hAX.setVisibility(8);
                    this.hBk = true;
                }
                if (this.hAX.getAlpha() != 0.0f) {
                    this.hAX.setAlpha(0.0f);
                }
            } else if (this.hBh < this.hBj && this.hBh > 0) {
                if (this.hAX.getVisibility() == 8) {
                    this.hAX.setVisibility(0);
                    bOb();
                }
                this.hAX.setAlpha(1.0f - ((((this.hBh + this.hBi) - this.hBj) * 1.0f) / this.hBi));
            } else if (this.hBh <= 0) {
                if (this.hAX.getVisibility() == 8) {
                    this.hAX.setVisibility(0);
                    bOb();
                }
                if (this.hAX.getAlpha() != 1.0f) {
                    this.hAX.setAlpha(1.0f);
                }
            }
        }
    }

    public void dA(String str, String str2) {
        if (this.hpd != null) {
            this.mForumName = str;
            if (str.length() > 6) {
                str = str.substring(0, 6) + "...";
            }
            this.bSP.setText(str + this.hpd.getResources().getString(d.j.forum));
            this.hAY.startLoad(str2, 10, false);
        }
    }

    private void bOb() {
        if (this.hpd != null && this.hpd.bJb() != null && this.hBk) {
            this.hBk = false;
            am amVar = new am("c13400");
            amVar.bJ("tid", this.hpd.bJb().bKS());
            amVar.bJ(ImageViewerConfig.FORUM_ID, this.hpd.bJb().getForumId());
            amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(amVar);
        }
    }
}
