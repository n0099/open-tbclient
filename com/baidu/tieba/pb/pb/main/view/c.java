package com.baidu.tieba.pb.pb.main.view;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
import com.baidu.tbadk.core.h;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.d;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.w;
import com.baidu.tieba.pb.pb.main.x;
import com.baidu.tieba.pb.view.f;
/* loaded from: classes.dex */
public class c {
    private ImageView Rl;
    private Runnable aFQ;
    public final View aKU;
    private int cGN;
    private PbActivity eDo;
    private int eEi;
    public View ePA;
    public View ePB;
    public View ePC;
    private ImageView ePD;
    private final ImageView ePE;
    private final LinearLayout ePF;
    public FrameLayout ePH;
    public PbNavbarUserConcernView ePI;
    public HeadImageView ePJ;
    private ImageView ePM;
    public View ePN;
    private PopupWindow ePP;
    private boolean ePQ;
    private int ePR;
    public TextView ePz;
    public final NavigationBar mNavigationBar;
    private boolean eKP = false;
    private boolean ePG = false;
    private f ePK = null;
    private w ePL = null;
    private boolean ePO = false;
    private boolean eJX = false;
    private Runnable ePS = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
        @Override // java.lang.Runnable
        public void run() {
            View view;
            if (!c.this.eKP) {
                view = c.this.ePQ ? c.this.ePA : c.this.ePB;
            } else {
                view = c.this.ePB;
            }
            if (view != null) {
                if (TbadkCoreApplication.isLogin() || !c.this.ePQ) {
                    g.showPopupWindowAsDropDown(c.this.ePP, view);
                    if (!c.this.ePQ) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_share", true);
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("call_fan_guide", true);
                    }
                    c.this.ePG = true;
                    e.fP().removeCallbacks(c.this.ePT);
                    e.fP().postDelayed(c.this.ePT, TbConfig.NOTIFY_SOUND_INTERVAL);
                }
            }
        }
    };
    private Runnable ePT = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.aSN();
        }
    };
    private View.OnClickListener ePU = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.aSM();
        }
    };

    public c(PbActivity pbActivity) {
        this.cGN = 0;
        this.eEi = 0;
        this.ePR = 0;
        this.eDo = pbActivity;
        this.cGN = l.f(pbActivity, d.f.ds88);
        this.eEi = l.f(this.eDo.getPageContext().getPageActivity(), d.f.ds34);
        this.ePR = l.f(this.eDo.getPageContext().getPageActivity(), d.f.ds14);
        this.mNavigationBar = (NavigationBar) this.eDo.findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.eDo.ahd();
            }
        });
        this.aKU = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.crI);
        this.aKU.setPadding(l.f(this.eDo.getPageContext().getPageActivity(), d.f.ds18), this.aKU.getPaddingTop(), this.aKU.getPaddingRight(), this.aKU.getPaddingBottom());
        this.ePz = this.mNavigationBar.setCenterTextTitle("");
        this.ePE = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.ePF = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int f = l.f(this.eDo.getPageContext().getPageActivity(), d.f.ds20);
        this.ePF.setPadding(f, 0, f, 0);
        aj.a(this.ePE, d.g.icon_pb_play_small, d.g.icon_pb_play_small);
        this.ePE.setVisibility(8);
        this.ePz.setOnClickListener(pbActivity.crI);
        this.ePE.setOnClickListener(pbActivity.crI);
        this.ePM = (ImageView) this.aKU.findViewById(d.h.widget_navi_back_button);
        this.ePN = this.mNavigationBar.getBottomLine();
        if (this.ePN != null) {
            this.ePN.setVisibility(8);
        }
    }

    public void jH(boolean z) {
        NavigationBar.ControlAlign controlAlign = z ? NavigationBar.ControlAlign.HORIZONTAL_LEFT : NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.eKP = z;
        if (this.ePB == null && this.ePD == null) {
            this.ePB = this.mNavigationBar.addCustomView(controlAlign, d.j.nb_item_floor_share, this.eDo.crI);
            this.ePD = (ImageView) this.ePB.findViewById(d.h.navigationBarBtnShare);
            this.ePB.setLayoutParams(new LinearLayout.LayoutParams(this.cGN, this.cGN));
            aj.a(this.ePD, d.g.icon_pb_navi_selector, d.g.icon_pb_navi_selector);
        }
        if (this.ePA == null && this.Rl == null) {
            this.ePA = this.mNavigationBar.addCustomView(controlAlign, d.j.nb_item_floor_more, this.eDo.crI);
            this.Rl = (ImageView) this.ePA.findViewById(d.h.navigationBarBtnMore);
            this.ePA.setLayoutParams(new LinearLayout.LayoutParams(this.cGN, this.cGN));
            aj.a(this.Rl, d.g.icon_nav_more_selector, d.g.icon_nav_more_selector);
            this.ePA.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
        if (this.ePC == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ePR, this.ePR);
            this.ePC = this.mNavigationBar.addCustomView(controlAlign, d.j.nb_space, (View.OnClickListener) null);
            this.ePC.setLayoutParams(layoutParams);
            this.ePC.setVisibility(4);
        }
        if (z && this.ePH == null) {
            this.ePH = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.nav_user_concern_layout, (View.OnClickListener) null);
            this.ePI = (PbNavbarUserConcernView) this.ePH.findViewById(d.h.view_add_concern);
            this.ePJ = (HeadImageView) this.ePH.findViewById(d.h.view_host_photo);
            this.ePJ.setIsRound(true);
            this.ePJ.setDefaultResource(d.g.icon_default_avatar100);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, this.eEi, 0);
            this.ePH.setLayoutParams(layoutParams2);
            this.ePI.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void jq(boolean z) {
        if (this.ePA != null) {
            this.ePA.setVisibility(z ? 0 : 8);
        }
    }

    public void jI(boolean z) {
        if (this.ePB != null && !z) {
            this.ePB.setVisibility(8);
        }
    }

    public NavigationBar aSG() {
        return this.mNavigationBar;
    }

    public void setTitleVisibility(boolean z) {
        if (z) {
            this.aKU.setVisibility(0);
        } else {
            this.aKU.setVisibility(8);
        }
        jK(z);
    }

    public void na(String str) {
        if (!TextUtils.isEmpty(str) && !this.eKP) {
            this.ePz.setText(this.eDo.getResources().getString(d.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, true)));
            jK(true);
            h.oM().cm(str);
            return;
        }
        jK(false);
    }

    public void a(x xVar) {
        if (!this.eDo.isProgressBarShown()) {
            if (this.ePK == null) {
                this.ePL = new w((PbActivity) this.eDo.getPageContext().getOrignalPage(), this.eDo.crI);
                this.ePK = new f(this.eDo.getPageContext().getPageActivity(), this.ePL.getView(), aj.getDrawable(d.g.bg_pull_down_right_n), new d.a() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                    @Override // com.baidu.tbadk.core.view.d.a
                    public void oi() {
                        c.this.eDo.aOl();
                    }

                    @Override // com.baidu.tbadk.core.view.d.a
                    public void oj() {
                    }
                });
            }
            this.ePL.aQv();
            this.ePK.showAtLocation(this.eDo.findViewById(d.h.pb_layout), 17, 0, 0);
            this.ePL.je(xVar == null ? false : xVar.eHc);
            this.ePL.jh(xVar == null ? false : xVar.eHi);
            this.ePL.ji(xVar == null ? false : xVar.eHj);
            this.ePL.jf(xVar == null ? false : xVar.eHb);
            this.ePL.jj(xVar == null ? false : xVar.eHk);
            this.ePL.jk(xVar == null ? true : xVar.eHp);
            if (xVar == null) {
                this.ePL.H(false, false);
                this.ePL.I(false, false);
                this.ePL.k(false, "");
            } else {
                this.ePL.H(xVar.eHg, xVar.eHm);
                this.ePL.I(xVar.eHh, xVar.eHl);
                this.ePL.k(StringUtils.isNull(xVar.eHo) ? false : true, xVar.eHo);
            }
            this.ePL.jl(xVar == null ? false : xVar.eHf);
            boolean z = xVar == null ? false : xVar.eHe;
            boolean z2 = xVar == null ? false : xVar.eze;
            boolean z3 = xVar == null ? false : xVar.isHostOnly;
            boolean z4 = xVar == null ? false : xVar.eHn;
            this.ePL.jg(xVar == null ? false : xVar.eHd);
            this.ePL.G(z4, z3);
            if (xVar != null) {
                this.ePL.eGY = xVar.eHq;
                if (xVar.eHq) {
                    this.ePL.aQq().setText(d.l.report_text);
                    this.ePL.jj(false);
                }
            }
            i(z, z2, z3);
        }
    }

    public void aSH() {
        this.ePL.aQu().setText(this.eDo.getResources().getString(d.l.haved_fans_call));
    }

    private void i(boolean z, boolean z2, boolean z3) {
        if (this.ePL != null) {
            this.ePL.YX();
            if (z2) {
                this.ePL.aQc().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.g.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.ePL.aQc().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.g.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
            if (z3) {
                this.ePL.aQo().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.g.icon_host_only_selector), (Drawable) null, (Drawable) null);
            } else {
                this.ePL.aQo().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.g.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void of() {
        if (this.ePL != null) {
            this.ePL.aQw();
        }
        if (this.aFQ == null) {
            this.aFQ = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.ePK != null) {
                        g.a(c.this.ePK, c.this.eDo.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.fP().postDelayed(this.aFQ, 100L);
    }

    public w aSI() {
        return this.ePL;
    }

    public View aSJ() {
        return this.ePE;
    }

    public boolean Yu() {
        return this.ePK != null && this.ePK.isShowing();
    }

    public void aCO() {
        if (this.ePL != null) {
            this.ePL.release();
        }
        this.ePK = null;
        this.ePL = null;
        e.fP().removeCallbacks(this.aFQ);
    }

    public void aSK() {
        if (this.ePA != null) {
            this.ePA.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.eDo.getPageContext(), i);
            aj.j(this.mNavigationBar.getBarBgView(), d.e.cp_bg_line_d);
        }
        if (this.Rl != null) {
            aj.a(this.Rl, d.g.icon_nav_more_selector, d.g.icon_nav_more_selector);
        }
        if (this.ePD != null) {
            aj.a(this.ePD, d.g.icon_pb_navi_selector, d.g.icon_pb_navi_selector);
        }
        if (this.ePI != null) {
            this.ePI.onChangeSkinType(i);
        }
        aj.b(this.ePz, d.e.cp_cont_b, d.e.s_navbar_title_color);
    }

    public void pG(int i) {
        this.mNavigationBar.onChangeSkinType(this.eDo.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(d.g.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.eDo.getResources().getColor(d.e.black_alpha85));
        if (this.ePD != null) {
            this.ePD.setImageResource(d.g.pb_ala_share);
        }
        if (this.Rl != null) {
            this.Rl.setImageResource(d.g.icon_more_bg);
        }
        this.ePz.setTextColor(this.eDo.getResources().getColor(d.e.cp_cont_g));
        this.ePM.setImageResource(d.g.icon_return_bg);
    }

    public void aSL() {
        this.ePM.setVisibility(0);
        jK(false);
        if (this.ePA != null) {
            this.ePA.setVisibility(8);
        }
        if (this.ePB != null) {
            this.ePB.setVisibility(8);
        }
    }

    public void jJ(boolean z) {
        this.ePM.setVisibility(0);
        jK(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.ePB != null) {
                this.ePB.setVisibility(0);
            }
            if (this.ePA != null) {
                this.ePA.setVisibility(0);
                return;
            }
            return;
        }
        if (this.ePB != null) {
            this.ePB.setVisibility(8);
        }
        if (this.ePA != null) {
            this.ePA.setVisibility(8);
        }
    }

    public void jK(boolean z) {
        if (!this.eKP && z && !"".equals(this.ePz.getText().toString())) {
            this.ePz.setVisibility(0);
        } else {
            this.ePz.setVisibility(8);
        }
    }

    public void jL(boolean z) {
        this.ePO = z;
    }

    public void jM(boolean z) {
        if (!this.ePO || TbadkCoreApplication.isLogin() || z) {
            if (z) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("call_fan_guide", false)) {
                    jM(false);
                    return;
                }
            } else if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_share", false)) {
                return;
            }
            this.ePQ = z;
            View inflate = LayoutInflater.from(this.eDo.getPageContext().getContext()).inflate(d.j.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(d.h.arrow_up);
            TextView textView = (TextView) inflate.findViewById(d.h.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            if (!z) {
                if (this.eKP) {
                    layoutParams.gravity = 3;
                    layoutParams.leftMargin = l.f(this.eDo, d.f.ds24);
                } else if (TbadkCoreApplication.isLogin()) {
                    layoutParams.gravity = 17;
                    layoutParams.leftMargin = l.f(this.eDo, d.f.ds18);
                } else {
                    layoutParams.gravity = 5;
                    layoutParams.rightMargin = l.f(this.eDo, d.f.ds38);
                }
                textView.setText(d.l.share_tip);
            } else {
                if (this.eKP) {
                    layoutParams.gravity = 3;
                    layoutParams.leftMargin = l.f(this.eDo.getPageContext().getContext(), d.f.ds114);
                } else if (TbadkCoreApplication.isLogin()) {
                    layoutParams.gravity = 5;
                    layoutParams.rightMargin = l.f(this.eDo.getPageContext().getContext(), d.f.ds56);
                }
                textView.setText(d.l.fans_call_tip);
            }
            textView.setOnClickListener(this.ePU);
            this.ePP = new PopupWindow(inflate, -2, -2);
            e.fP().removeCallbacks(this.ePS);
            e.fP().postDelayed(this.ePS, 500L);
        }
    }

    public void aSM() {
        if (this.ePS != null) {
            e.fP().removeCallbacks(this.ePS);
        }
        if (this.ePT != null) {
            e.fP().removeCallbacks(this.ePT);
        }
        aSN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSN() {
        g.a(this.ePP);
    }
}
