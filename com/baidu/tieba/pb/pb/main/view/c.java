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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.aa;
import com.baidu.tieba.pb.pb.main.ab;
/* loaded from: classes4.dex */
public class c {
    private ImageView bCi;
    public final View cCm;
    public TextView cbV;
    private Runnable cxp;
    private int dZI;
    private PbActivity hNx;
    public TextView hZL;
    public View hZM;
    private final ImageView hZN;
    private final LinearLayout hZO;
    public LinearLayout hZP;
    public BarImageView hZQ;
    private ImageView hZT;
    private PopupWindow hZV;
    private boolean hZW;
    private int hZX;
    private View hZY;
    private int iaa;
    private int iab;
    private int iac;
    public String mForumName;
    public final NavigationBar mNavigationBar;
    private final int hZK = 6;
    private boolean hWu = false;
    private AlertDialog hZR = null;
    private aa hZS = null;
    private boolean hZU = false;
    private int[] hZZ = new int[2];
    private boolean iad = true;
    private Runnable fTe = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
        @Override // java.lang.Runnable
        public void run() {
            View view = c.this.hZW ? c.this.hZM : null;
            if (view != null) {
                if (TbadkCoreApplication.isLogin() || !c.this.hZW) {
                    g.showPopupWindowAsDropDown(c.this.hZV, view);
                    if (!c.this.hZW) {
                        com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("show_share", true);
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("call_fan_guide", true);
                    }
                    e.iK().removeCallbacks(c.this.fTf);
                    e.iK().postDelayed(c.this.fTf, 5000L);
                }
            }
        }
    };
    private Runnable fTf = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
        @Override // java.lang.Runnable
        public void run() {
            c.this.btl();
        }
    };
    private View.OnClickListener fTg = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.bYZ();
        }
    };

    public c(PbActivity pbActivity) {
        this.dZI = 0;
        this.hZX = 0;
        this.hNx = pbActivity;
        this.dZI = l.g(pbActivity, R.dimen.ds88);
        this.hZX = l.g(this.hNx.getPageContext().getPageActivity(), R.dimen.ds14);
        this.mNavigationBar = (NavigationBar) this.hNx.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.hNx.bmu();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.cCm = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.fwx);
        this.hZL = this.mNavigationBar.setCenterTextTitle("");
        this.hZN = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.hZO = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int g = l.g(this.hNx.getPageContext().getPageActivity(), R.dimen.ds20);
        this.hZO.setPadding(g, 0, g, 0);
        am.a(this.hZN, (int) R.drawable.icon_pb_play_small, (int) R.drawable.icon_pb_play_small);
        this.hZN.setVisibility(8);
        this.hZL.setOnClickListener(pbActivity.fwx);
        this.hZN.setOnClickListener(pbActivity.fwx);
        this.hZT = (ImageView) this.cCm.findViewById(R.id.widget_navi_back_button);
        if (this.hZP == null) {
            this.hZP = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.nav_fourm_title_layout, (View.OnClickListener) null);
            this.hZQ = (BarImageView) this.hZP.findViewById(R.id.pb_nav_title_forum_image);
            this.hZQ.setShowOval(true);
            this.hZQ.setOnClickListener(pbActivity.fwx);
            this.cbV = (TextView) this.hZP.findViewById(R.id.pb_nav_title_forum_name);
            this.cbV.setOnClickListener(pbActivity.fwx);
        }
    }

    public void pj(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.hWu = z;
        if (this.hZM == null && this.bCi == null) {
            this.hZM = this.mNavigationBar.addCustomView(controlAlign, R.layout.nb_item_floor_more, this.hNx.fwx);
            this.bCi = (ImageView) this.hZM.findViewById(R.id.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.dZI, this.dZI);
            layoutParams.rightMargin = this.hZX;
            this.hZM.setLayoutParams(layoutParams);
            am.a(this.bCi, (int) R.drawable.icon_nav_more_selector, (int) R.drawable.icon_nav_more_selector);
            this.hZM.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void oQ(boolean z) {
        if (this.hZM != null) {
            this.hZM.setVisibility(z ? 0 : 8);
        }
    }

    public NavigationBar bYS() {
        return this.mNavigationBar;
    }

    public void pk(boolean z) {
        if (z) {
            this.cCm.setVisibility(0);
        } else {
            this.cCm.setVisibility(8);
        }
        pm(z);
    }

    public void zT(String str) {
        if (!TextUtils.isEmpty(str) && !this.hWu) {
            this.hZL.setText(this.hNx.getResources().getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            pm(true);
            i.aca().mi(str);
            return;
        }
        pm(false);
    }

    public void a(ab abVar) {
        if (!this.hNx.isProgressBarShown()) {
            this.hZS = new aa((PbActivity) this.hNx.getPageContext().getOrignalPage(), this.hNx.fwx);
            this.hZR = new AlertDialog.Builder(this.hNx, R.style.DialogTheme).create();
            this.hZR.setCanceledOnTouchOutside(true);
            g.a(this.hZR, this.hNx);
            Window window = this.hZR.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.hZS.getView());
            this.hZS.oH(abVar == null ? false : abVar.hSx);
            this.hZS.oI(abVar == null ? false : abVar.hSB);
            this.hZS.oJ(abVar == null ? false : abVar.hSC);
            this.hZS.oK(abVar == null ? false : abVar.hSD);
            this.hZS.oL(abVar == null ? true : abVar.hSK);
            if (abVar == null) {
                this.hZS.Y(false, false);
                this.hZS.Z(false, false);
                this.hZS.v(false, "");
            } else {
                this.hZS.Y(abVar.hSz, abVar.hSH);
                this.hZS.Z(abVar.hSA, abVar.hSG);
                this.hZS.v(StringUtils.isNull(abVar.hSJ) ? false : true, abVar.hSJ);
            }
            boolean z = abVar == null ? false : abVar.oy;
            boolean z2 = abVar == null ? false : abVar.isHostOnly;
            boolean z3 = abVar == null ? false : abVar.hSI;
            boolean z4 = abVar == null ? false : abVar.hSy;
            boolean z5 = abVar == null ? false : abVar.hSE;
            boolean z6 = abVar == null ? false : abVar.hSF;
            this.hZS.X(z3, z2);
            this.hZS.aa(z4, z);
            this.hZS.ab(z6, z5);
            if (abVar != null) {
                this.hZS.hSu = abVar.hSL;
                if (abVar.hSL) {
                    this.hZS.bWO().setText(R.string.report_text);
                    this.hZS.oK(false);
                }
            }
            af(z, z2);
        }
    }

    public void bYT() {
        this.hZS.bWU().setText(this.hNx.getResources().getString(R.string.haved_fans_call));
    }

    private void af(boolean z, boolean z2) {
        if (this.hZS != null) {
            this.hZS.setBackGround();
        }
    }

    public void UM() {
        if (this.cxp == null) {
            this.cxp = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.hZR != null) {
                        g.b(c.this.hZR, c.this.hNx.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.iK().postDelayed(this.cxp, 100L);
    }

    public void bYU() {
        if (this.hZR != null) {
            g.b(this.hZR, this.hNx.getPageContext().getPageActivity());
        }
    }

    public aa bYV() {
        return this.hZS;
    }

    public View bYW() {
        return this.hZN;
    }

    public boolean baz() {
        return this.hZR != null && this.hZR.isShowing();
    }

    public void bJT() {
        if (this.hZS != null) {
            this.hZS.release();
        }
        this.hZR = null;
        this.hZS = null;
        e.iK().removeCallbacks(this.cxp);
    }

    public void bYX() {
        if (this.hZM != null) {
            this.hZM.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.hNx.getPageContext(), i);
            am.k(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_d);
        }
        ar.ajp().d(this.hZT, R.drawable.icon_topbar_return_n_svg, R.color.select_topbar_icon_color_tint);
        ar.ajp().d(this.bCi, R.drawable.icon_topbar_more_n_svg, R.color.select_topbar_icon_color_tint);
        am.e(this.hZL, R.color.cp_cont_b, R.color.s_navbar_title_color);
        am.j(this.cbV, R.color.cp_cont_b);
    }

    public void yo(int i) {
        this.mNavigationBar.onChangeSkinType(this.hNx.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.hNx.getResources().getColor(R.color.black_alpha85));
        if (this.bCi != null) {
            this.bCi.setImageResource(R.drawable.icon_vnav_more_bg);
        }
        this.hZL.setTextColor(this.hNx.getResources().getColor(R.color.cp_cont_g));
        this.hZT.setImageResource(R.drawable.icon_return_bg);
    }

    public void bYY() {
        this.hZT.setVisibility(0);
        pm(false);
        if (this.hZM != null) {
            this.hZM.setVisibility(8);
        }
    }

    public void pl(boolean z) {
        this.hZT.setVisibility(0);
        pm(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.hZM != null) {
                this.hZM.setVisibility(0);
            }
        } else if (this.hZM != null) {
            this.hZM.setVisibility(8);
        }
    }

    public void pm(boolean z) {
        if (!this.hWu && z && !"".equals(this.hZL.getText().toString())) {
            this.hZL.setVisibility(0);
        } else {
            this.hZL.setVisibility(8);
        }
    }

    public void pn(boolean z) {
        this.hZU = z;
    }

    public void po(boolean z) {
        if (!this.hZU || TbadkCoreApplication.isLogin() || z) {
            if (z) {
                if (com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("call_fan_guide", false)) {
                    po(false);
                    return;
                }
            } else if (com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("show_share", false)) {
                return;
            }
            this.hZW = z;
            View inflate = LayoutInflater.from(this.hNx.getPageContext().getContext()).inflate(R.layout.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.arrow_up);
            TextView textView = (TextView) inflate.findViewById(R.id.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            if (!z) {
                layoutParams.gravity = 5;
                if (!TbadkCoreApplication.isLogin()) {
                    layoutParams.rightMargin = l.g(this.hNx, R.dimen.ds28);
                } else {
                    layoutParams.rightMargin = l.g(this.hNx, R.dimen.ds128);
                }
                textView.setText(R.string.share_tip);
                textView.setOnClickListener(this.fTg);
                this.hZV = new PopupWindow(inflate, -2, -2);
                e.iK().removeCallbacks(this.fTe);
                e.iK().postDelayed(this.fTe, 500L);
            }
        }
    }

    public void bYZ() {
        if (this.fTe != null) {
            e.iK().removeCallbacks(this.fTe);
        }
        if (this.fTf != null) {
            e.iK().removeCallbacks(this.fTf);
        }
        btl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btl() {
        g.a(this.hZV);
    }

    public void cG(View view) {
        if (view != null && !aq.isEmpty(this.mForumName) && !this.hZU) {
            this.hZY = view;
            this.hZY.getLocationOnScreen(this.hZZ);
            this.iaa = this.hZZ[1];
            this.iab = this.hZY.getHeight();
            this.iac = this.mNavigationBar.getHeight();
            if (!this.hZY.isShown()) {
                if (this.hZP.getVisibility() == 8) {
                    this.hZP.setVisibility(0);
                }
                if (this.hZP.getAlpha() != 1.0f) {
                    this.hZP.setAlpha(1.0f);
                }
            } else if (this.iaa >= this.iac) {
                if (this.hZP.getVisibility() == 0) {
                    this.hZP.setVisibility(8);
                    this.iad = true;
                }
                if (this.hZP.getAlpha() != 0.0f) {
                    this.hZP.setAlpha(0.0f);
                }
            } else if (this.iaa < this.iac && this.iaa > 0) {
                if (this.hZP.getVisibility() == 8) {
                    this.hZP.setVisibility(0);
                    bZa();
                }
                this.hZP.setAlpha(1.0f - ((((this.iaa + this.iab) - this.iac) * 1.0f) / this.iab));
            } else if (this.iaa <= 0) {
                if (this.hZP.getVisibility() == 8) {
                    this.hZP.setVisibility(0);
                    bZa();
                }
                if (this.hZP.getAlpha() != 1.0f) {
                    this.hZP.setAlpha(1.0f);
                }
            }
        }
    }

    public void dO(String str, String str2) {
        if (this.hNx != null) {
            this.mForumName = str;
            if (str.length() > 6) {
                str = str.substring(0, 6) + "...";
            }
            this.cbV.setText(str + this.hNx.getResources().getString(R.string.forum));
            this.hZQ.startLoad(str2, 10, false);
        }
    }

    private void bZa() {
        if (this.hNx != null && this.hNx.bTR() != null && this.iad) {
            this.iad = false;
            an anVar = new an("c13400");
            anVar.bT("tid", this.hNx.bTR().bVL());
            anVar.bT("fid", this.hNx.bTR().getForumId());
            anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(anVar);
        }
    }
}
