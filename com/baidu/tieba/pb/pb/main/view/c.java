package com.baidu.tieba.pb.pb.main.view;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.h;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.d;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.x;
import com.baidu.tieba.pb.pb.main.y;
import com.baidu.tieba.pb.view.f;
/* loaded from: classes.dex */
public class c {
    private Runnable aGC;
    public final View aLF;
    private PbActivity eHK;
    public final TextView eVI;
    public final ImageView eVJ;
    public final ImageView eVK;
    private final ImageView eVL;
    private final LinearLayout eVM;
    private ImageView eVQ;
    private View eVR;
    private PopupWindow eVT;
    private boolean eVU;
    public final NavigationBar mNavigationBar;
    private boolean eVN = false;
    private f eVO = null;
    private x eVP = null;
    private boolean eVS = false;
    private boolean eQA = false;
    private Runnable eVV = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = c.this.eVU ? c.this.eVJ : c.this.eVK;
            if (imageView != null) {
                g.showPopupWindowAsDropDown(c.this.eVT, imageView);
                if (!c.this.eVU) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_share", true);
                } else {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("call_fan_guide", true);
                }
                c.this.eVN = true;
                e.fQ().removeCallbacks(c.this.eVW);
                e.fQ().postDelayed(c.this.eVW, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    };
    private Runnable eVW = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.aUJ();
        }
    };
    private View.OnClickListener eVX = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.aUI();
        }
    };

    public c(PbActivity pbActivity) {
        this.eHK = pbActivity;
        this.mNavigationBar = (NavigationBar) this.eHK.findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.eHK.aho();
            }
        });
        this.aLF = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.cry);
        this.aLF.setPadding(k.f(this.eHK.getPageContext().getPageActivity(), d.f.ds18), this.aLF.getPaddingTop(), this.aLF.getPaddingRight(), this.aLF.getPaddingBottom());
        this.eVI = this.mNavigationBar.setCenterTextTitle("");
        this.eVL = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.eVM = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int f = k.f(this.eHK.getPageContext().getPageActivity(), d.f.ds20);
        this.eVM.setPadding(f, 0, f, 0);
        aj.a(this.eVL, d.g.icon_pb_play_small, d.g.icon_pb_play_small);
        this.eVL.setVisibility(8);
        this.eVK = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.nb_item_floor_share, pbActivity.cry);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, k.f(this.eHK.getPageContext().getPageActivity(), d.f.ds40), 0);
        this.eVK.setLayoutParams(layoutParams);
        aj.a(this.eVK, d.g.icon_pb_navi_selector, d.g.icon_pb_navi_selector);
        this.eVJ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.nb_item_floor_more, pbActivity.cry);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, 0, k.f(this.eHK.getPageContext().getPageActivity(), d.f.ds28), 0);
        this.eVJ.setLayoutParams(layoutParams2);
        aj.a(this.eVJ, d.g.icon_nav_more_selector, d.g.icon_nav_more_selector);
        this.eVI.setOnClickListener(pbActivity.cry);
        this.eVL.setOnClickListener(pbActivity.cry);
        this.eVQ = (ImageView) this.aLF.findViewById(d.h.widget_navi_back_button);
        this.eVR = this.mNavigationBar.getBottomLine();
        if (this.eVR != null) {
            this.eVR.setVisibility(8);
        }
    }

    public void jF(boolean z) {
        this.eVJ.setVisibility(z ? 0 : 8);
    }

    public NavigationBar aUC() {
        return this.mNavigationBar;
    }

    public void setTitleVisibility(boolean z) {
        if (z) {
            this.aLF.setVisibility(0);
        } else {
            this.aLF.setVisibility(8);
        }
        jW(z);
    }

    public void nx(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.eVI.setText(this.eHK.getResources().getString(d.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, true)));
            jW(true);
            h.oS().cn(str);
            return;
        }
        jW(false);
    }

    public void a(y yVar) {
        if (!this.eHK.isProgressBarShown()) {
            if (this.eVO == null) {
                this.eVP = new x((PbActivity) this.eHK.getPageContext().getOrignalPage(), this.eHK.cry);
                this.eVO = new f(this.eHK.getPageContext().getPageActivity(), this.eVP.getView(), aj.getDrawable(d.g.bg_pull_down_right_n), new d.a() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                    @Override // com.baidu.tbadk.core.view.d.a
                    public void oo() {
                        c.this.eHK.aQv();
                    }

                    @Override // com.baidu.tbadk.core.view.d.a
                    public void op() {
                    }
                });
            }
            this.eVP.Xc();
            this.eVO.showAtLocation(this.eHK.findViewById(d.h.pb_layout), 17, 0, 0);
            this.eVP.jt(yVar == null ? false : yVar.eNE);
            this.eVP.jw(yVar == null ? false : yVar.eNK);
            this.eVP.jx(yVar == null ? false : yVar.eNL);
            this.eVP.ju(yVar == null ? false : yVar.eND);
            this.eVP.jy(yVar == null ? false : yVar.eNM);
            this.eVP.jz(yVar == null ? true : yVar.eNR);
            if (yVar == null) {
                this.eVP.G(false, false);
                this.eVP.H(false, false);
                this.eVP.k(false, "");
            } else {
                this.eVP.G(yVar.eNI, yVar.eNO);
                this.eVP.H(yVar.eNJ, yVar.eNN);
                this.eVP.k(StringUtils.isNull(yVar.eNQ) ? false : true, yVar.eNQ);
            }
            this.eVP.jA(yVar == null ? false : yVar.eNH);
            boolean z = yVar == null ? false : yVar.eNG;
            boolean z2 = yVar == null ? false : yVar.eFW;
            boolean z3 = yVar == null ? false : yVar.isHostOnly;
            boolean z4 = yVar == null ? false : yVar.eNP;
            this.eVP.jv(yVar != null ? yVar.eNF : false);
            this.eVP.F(z4, z3);
            j(z, z2, z3);
        }
    }

    public void aUD() {
        this.eVP.aSB().setText(this.eHK.getResources().getString(d.l.haved_fans_call));
    }

    private void j(boolean z, boolean z2, boolean z3) {
        if (this.eVP != null) {
            this.eVP.Xg();
            if (z2) {
                this.eVP.aSk().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.g.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.eVP.aSk().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.g.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
            if (z3) {
                this.eVP.aSv().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.g.icon_host_only_selector), (Drawable) null, (Drawable) null);
            } else {
                this.eVP.aSv().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.g.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void ol() {
        if (this.eVP != null) {
            this.eVP.Xd();
        }
        if (this.aGC == null) {
            this.aGC = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.eVO != null) {
                        g.a(c.this.eVO, c.this.eHK.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.fQ().postDelayed(this.aGC, 100L);
    }

    public x aUE() {
        return this.eVP;
    }

    public View aUF() {
        return this.eVL;
    }

    public boolean YQ() {
        return this.eVO != null && this.eVO.isShowing();
    }

    public void aEd() {
        if (this.eVP != null) {
            this.eVP.release();
        }
        this.eVO = null;
        this.eVP = null;
        e.fQ().removeCallbacks(this.aGC);
    }

    public void aUG() {
        this.eVJ.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(aj.cU(d.g.s_navbar_bg)));
            this.mNavigationBar.onChangeSkinType(this.eHK.getPageContext(), i);
        }
        aj.a(this.eVJ, d.g.icon_nav_more_selector, d.g.icon_nav_more_selector);
        aj.b(this.eVI, d.e.cp_cont_b, d.e.s_navbar_title_color);
    }

    public void pM(int i) {
        this.mNavigationBar.onChangeSkinType(this.eHK.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(d.g.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.eHK.getResources().getColor(d.e.black_alpha85));
        this.eVR.setVisibility(8);
        this.eVK.setImageResource(d.g.pb_ala_share);
        this.eVJ.setImageResource(d.g.icon_more_bg);
        this.eVI.setTextColor(this.eHK.getResources().getColor(d.e.cp_cont_g));
        this.eVQ.setImageResource(d.g.icon_return_bg);
    }

    public void aUH() {
        this.eVQ.setVisibility(0);
        jW(false);
        this.eVJ.setVisibility(8);
        this.eVK.setVisibility(8);
    }

    public void jV(boolean z) {
        this.eVQ.setVisibility(0);
        jW(z);
        if (TbadkCoreApplication.isLogin()) {
            this.eVK.setVisibility(0);
            this.eVJ.setVisibility(0);
            return;
        }
        this.eVK.setVisibility(8);
        this.eVJ.setVisibility(8);
    }

    public void jW(boolean z) {
        if (z && !"".equals(this.eVI.getText().toString())) {
            this.eVI.setVisibility(0);
        } else {
            this.eVI.setVisibility(8);
        }
    }

    public void jX(boolean z) {
        this.eVS = z;
    }

    public void jY(boolean z) {
        if (z) {
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("call_fan_guide", false)) {
                jY(false);
                return;
            }
        } else if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_share", false)) {
            return;
        }
        this.eVU = z;
        View inflate = LayoutInflater.from(this.eHK.getPageContext().getContext()).inflate(d.j.tips_blue_right_up, (ViewGroup) null);
        View findViewById = inflate.findViewById(d.h.arrow_up);
        TextView textView = (TextView) inflate.findViewById(d.h.tips);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.gravity = 5;
        if (!z) {
            if (this.eVJ.getVisibility() == 0) {
                layoutParams.rightMargin = k.f(this.eHK.getPageContext().getContext(), d.f.ds130);
            } else {
                layoutParams.rightMargin = k.f(this.eHK.getPageContext().getContext(), d.f.ds50);
            }
            textView.setText(d.l.share_tip);
        } else {
            layoutParams.rightMargin = k.f(this.eHK.getPageContext().getContext(), d.f.ds32);
            textView.setText(d.l.fans_call_tip);
        }
        textView.setOnClickListener(this.eVX);
        this.eVT = new PopupWindow(inflate, -2, -2);
        e.fQ().removeCallbacks(this.eVV);
        e.fQ().postDelayed(this.eVV, 500L);
    }

    public void aUI() {
        if (this.eVV != null) {
            e.fQ().removeCallbacks(this.eVV);
        }
        if (this.eVW != null) {
            e.fQ().removeCallbacks(this.eVW);
        }
        aUJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUJ() {
        g.a(this.eVT);
    }
}
