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
    private Runnable aGF;
    public final View aLI;
    private PbActivity eGQ;
    public final TextView eUO;
    public final ImageView eUP;
    public final ImageView eUQ;
    private final ImageView eUR;
    private final LinearLayout eUS;
    private ImageView eUW;
    private View eUX;
    private PopupWindow eUZ;
    private boolean eVa;
    public final NavigationBar mNavigationBar;
    private boolean eUT = false;
    private f eUU = null;
    private x eUV = null;
    private boolean eUY = false;
    private boolean ePG = false;
    private Runnable eVb = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = c.this.eVa ? c.this.eUP : c.this.eUQ;
            if (imageView != null) {
                g.showPopupWindowAsDropDown(c.this.eUZ, imageView);
                if (!c.this.eVa) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_share", true);
                } else {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("call_fan_guide", true);
                }
                c.this.eUT = true;
                e.fQ().removeCallbacks(c.this.eVc);
                e.fQ().postDelayed(c.this.eVc, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    };
    private Runnable eVc = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.aUy();
        }
    };
    private View.OnClickListener eVd = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.aUx();
        }
    };

    public c(PbActivity pbActivity) {
        this.eGQ = pbActivity;
        this.mNavigationBar = (NavigationBar) this.eGQ.findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.eGQ.ahd();
            }
        });
        this.aLI = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.cqF);
        this.aLI.setPadding(k.g(this.eGQ.getPageContext().getPageActivity(), d.f.ds18), this.aLI.getPaddingTop(), this.aLI.getPaddingRight(), this.aLI.getPaddingBottom());
        this.eUO = this.mNavigationBar.setCenterTextTitle("");
        this.eUR = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.eUS = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int g = k.g(this.eGQ.getPageContext().getPageActivity(), d.f.ds20);
        this.eUS.setPadding(g, 0, g, 0);
        aj.a(this.eUR, d.g.icon_pb_play_small, d.g.icon_pb_play_small);
        this.eUR.setVisibility(8);
        this.eUQ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.nb_item_floor_share, pbActivity.cqF);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, k.g(this.eGQ.getPageContext().getPageActivity(), d.f.ds40), 0);
        this.eUQ.setLayoutParams(layoutParams);
        aj.a(this.eUQ, d.g.icon_pb_navi_selector, d.g.icon_pb_navi_selector);
        this.eUP = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.nb_item_floor_more, pbActivity.cqF);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, 0, k.g(this.eGQ.getPageContext().getPageActivity(), d.f.ds28), 0);
        this.eUP.setLayoutParams(layoutParams2);
        aj.a(this.eUP, d.g.icon_nav_more_selector, d.g.icon_nav_more_selector);
        this.eUO.setOnClickListener(pbActivity.cqF);
        this.eUR.setOnClickListener(pbActivity.cqF);
        this.eUW = (ImageView) this.aLI.findViewById(d.h.widget_navi_back_button);
        this.eUX = this.mNavigationBar.getBottomLine();
        if (this.eUX != null) {
            this.eUX.setVisibility(8);
        }
    }

    public void jE(boolean z) {
        this.eUP.setVisibility(z ? 0 : 8);
    }

    public NavigationBar aUr() {
        return this.mNavigationBar;
    }

    public void setTitleVisibility(boolean z) {
        if (z) {
            this.aLI.setVisibility(0);
        } else {
            this.aLI.setVisibility(8);
        }
        jV(z);
    }

    public void nv(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.eUO.setText(this.eGQ.getResources().getString(d.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, true)));
            jV(true);
            h.oS().cn(str);
            return;
        }
        jV(false);
    }

    public void a(y yVar) {
        if (!this.eGQ.isProgressBarShown()) {
            if (this.eUU == null) {
                this.eUV = new x((PbActivity) this.eGQ.getPageContext().getOrignalPage(), this.eGQ.cqF);
                this.eUU = new f(this.eGQ.getPageContext().getPageActivity(), this.eUV.getView(), aj.getDrawable(d.g.bg_pull_down_right_n), new d.a() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                    @Override // com.baidu.tbadk.core.view.d.a
                    public void oo() {
                        c.this.eGQ.aQk();
                    }

                    @Override // com.baidu.tbadk.core.view.d.a
                    public void op() {
                    }
                });
            }
            this.eUV.WR();
            this.eUU.showAtLocation(this.eGQ.findViewById(d.h.pb_layout), 17, 0, 0);
            this.eUV.js(yVar == null ? false : yVar.eMK);
            this.eUV.jv(yVar == null ? false : yVar.eMQ);
            this.eUV.jw(yVar == null ? false : yVar.eMR);
            this.eUV.jt(yVar == null ? false : yVar.eMJ);
            this.eUV.jx(yVar == null ? false : yVar.eMS);
            this.eUV.jy(yVar == null ? true : yVar.eMX);
            if (yVar == null) {
                this.eUV.G(false, false);
                this.eUV.H(false, false);
                this.eUV.k(false, "");
            } else {
                this.eUV.G(yVar.eMO, yVar.eMU);
                this.eUV.H(yVar.eMP, yVar.eMT);
                this.eUV.k(StringUtils.isNull(yVar.eMW) ? false : true, yVar.eMW);
            }
            this.eUV.jz(yVar == null ? false : yVar.eMN);
            boolean z = yVar == null ? false : yVar.eMM;
            boolean z2 = yVar == null ? false : yVar.eFc;
            boolean z3 = yVar == null ? false : yVar.isHostOnly;
            boolean z4 = yVar == null ? false : yVar.eMV;
            this.eUV.ju(yVar != null ? yVar.eML : false);
            this.eUV.F(z4, z3);
            j(z, z2, z3);
        }
    }

    public void aUs() {
        this.eUV.aSq().setText(this.eGQ.getResources().getString(d.l.haved_fans_call));
    }

    private void j(boolean z, boolean z2, boolean z3) {
        if (this.eUV != null) {
            this.eUV.WV();
            if (z2) {
                this.eUV.aRZ().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.g.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.eUV.aRZ().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.g.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
            if (z3) {
                this.eUV.aSk().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.g.icon_host_only_selector), (Drawable) null, (Drawable) null);
            } else {
                this.eUV.aSk().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.g.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void ol() {
        if (this.eUV != null) {
            this.eUV.WS();
        }
        if (this.aGF == null) {
            this.aGF = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.eUU != null) {
                        g.a(c.this.eUU, c.this.eGQ.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.fQ().postDelayed(this.aGF, 100L);
    }

    public x aUt() {
        return this.eUV;
    }

    public View aUu() {
        return this.eUR;
    }

    public boolean YF() {
        return this.eUU != null && this.eUU.isShowing();
    }

    public void aDS() {
        if (this.eUV != null) {
            this.eUV.release();
        }
        this.eUU = null;
        this.eUV = null;
        e.fQ().removeCallbacks(this.aGF);
    }

    public void aUv() {
        this.eUP.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(aj.cU(d.g.s_navbar_bg)));
            this.mNavigationBar.onChangeSkinType(this.eGQ.getPageContext(), i);
        }
        aj.a(this.eUP, d.g.icon_nav_more_selector, d.g.icon_nav_more_selector);
        aj.b(this.eUO, d.e.cp_cont_b, d.e.s_navbar_title_color);
    }

    public void pK(int i) {
        this.mNavigationBar.onChangeSkinType(this.eGQ.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(d.g.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.eGQ.getResources().getColor(d.e.black_alpha85));
        this.eUX.setVisibility(8);
        this.eUQ.setImageResource(d.g.pb_ala_share);
        this.eUP.setImageResource(d.g.icon_more_bg);
        this.eUO.setTextColor(this.eGQ.getResources().getColor(d.e.cp_cont_g));
        this.eUW.setImageResource(d.g.icon_return_bg);
    }

    public void aUw() {
        this.eUW.setVisibility(0);
        jV(false);
        this.eUP.setVisibility(8);
        this.eUQ.setVisibility(8);
    }

    public void jU(boolean z) {
        this.eUW.setVisibility(0);
        jV(z);
        if (TbadkCoreApplication.isLogin()) {
            this.eUQ.setVisibility(0);
            this.eUP.setVisibility(0);
            return;
        }
        this.eUQ.setVisibility(8);
        this.eUP.setVisibility(8);
    }

    public void jV(boolean z) {
        if (z && !"".equals(this.eUO.getText().toString())) {
            this.eUO.setVisibility(0);
        } else {
            this.eUO.setVisibility(8);
        }
    }

    public void jW(boolean z) {
        this.eUY = z;
    }

    public void jX(boolean z) {
        if (z) {
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("call_fan_guide", false)) {
                jX(false);
                return;
            }
        } else if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_share", false)) {
            return;
        }
        this.eVa = z;
        View inflate = LayoutInflater.from(this.eGQ.getPageContext().getContext()).inflate(d.j.tips_blue_right_up, (ViewGroup) null);
        View findViewById = inflate.findViewById(d.h.arrow_up);
        TextView textView = (TextView) inflate.findViewById(d.h.tips);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.gravity = 5;
        if (!z) {
            if (this.eUP.getVisibility() == 0) {
                layoutParams.rightMargin = k.g(this.eGQ.getPageContext().getContext(), d.f.ds130);
            } else {
                layoutParams.rightMargin = k.g(this.eGQ.getPageContext().getContext(), d.f.ds50);
            }
            textView.setText(d.l.share_tip);
        } else {
            layoutParams.rightMargin = k.g(this.eGQ.getPageContext().getContext(), d.f.ds32);
            textView.setText(d.l.fans_call_tip);
        }
        textView.setOnClickListener(this.eVd);
        this.eUZ = new PopupWindow(inflate, -2, -2);
        e.fQ().removeCallbacks(this.eVb);
        e.fQ().postDelayed(this.eVb, 500L);
    }

    public void aUx() {
        if (this.eVb != null) {
            e.fQ().removeCallbacks(this.eVb);
        }
        if (this.eVc != null) {
            e.fQ().removeCallbacks(this.eVc);
        }
        aUy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUy() {
        g.a(this.eUZ);
    }
}
