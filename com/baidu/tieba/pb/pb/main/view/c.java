package com.baidu.tieba.pb.pb.main.view;

import android.graphics.Rect;
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
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.h;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.d;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.aa;
import com.baidu.tieba.pb.pb.main.ab;
import com.baidu.tieba.pb.view.f;
/* loaded from: classes.dex */
public class c {
    private int DS4;
    private ImageView Sl;
    private Runnable aHk;
    public final View aMn;
    private int cSq;
    private PbActivity eUm;
    public TextView ffD;
    public View ffE;
    public View ffF;
    private ImageView ffG;
    private final ImageView ffH;
    private final LinearLayout ffI;
    public FrameLayout ffJ;
    public PbNavbarUserConcernView ffK;
    public HeadPendantView ffL;
    private ImageView ffO;
    private PopupWindow ffQ;
    private boolean ffR;
    private int ffS;
    private int ffT;
    public final NavigationBar mNavigationBar;
    private boolean fcJ = false;
    private f ffM = null;
    private aa ffN = null;
    private boolean ffP = false;
    private Runnable ffU = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.5
        @Override // java.lang.Runnable
        public void run() {
            View view;
            if (!c.this.fcJ) {
                view = c.this.ffR ? c.this.ffE : c.this.ffF;
            } else {
                view = c.this.ffF;
            }
            if (view != null) {
                if (TbadkCoreApplication.isLogin() || !c.this.ffR) {
                    g.showPopupWindowAsDropDown(c.this.ffQ, view);
                    if (!c.this.ffR) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_share", true);
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("call_fan_guide", true);
                    }
                    e.fP().removeCallbacks(c.this.ffV);
                    e.fP().postDelayed(c.this.ffV, TbConfig.NOTIFY_SOUND_INTERVAL);
                }
            }
        }
    };
    private Runnable ffV = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.6
        @Override // java.lang.Runnable
        public void run() {
            c.this.aXi();
        }
    };
    private View.OnClickListener ffW = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.aXh();
        }
    };

    public c(PbActivity pbActivity) {
        this.cSq = 0;
        this.ffS = 0;
        this.ffT = 0;
        this.DS4 = 0;
        this.eUm = pbActivity;
        this.cSq = l.f(pbActivity, d.e.ds88);
        this.ffS = l.f(this.eUm.getPageContext().getPageActivity(), d.e.ds22);
        this.ffT = l.f(this.eUm.getPageContext().getPageActivity(), d.e.ds14);
        this.DS4 = l.f(this.eUm.getPageContext().getPageActivity(), d.e.ds4);
        this.mNavigationBar = (NavigationBar) this.eUm.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.eUm.alt();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.aMn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.cIA);
        this.ffD = this.mNavigationBar.setCenterTextTitle("");
        this.ffH = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.ffI = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int f = l.f(this.eUm.getPageContext().getPageActivity(), d.e.ds20);
        this.ffI.setPadding(f, 0, f, 0);
        aj.a(this.ffH, d.f.icon_pb_play_small, d.f.icon_pb_play_small);
        this.ffH.setVisibility(8);
        this.ffD.setOnClickListener(pbActivity.cIA);
        this.ffH.setOnClickListener(pbActivity.cIA);
        this.ffO = (ImageView) this.aMn.findViewById(d.g.widget_navi_back_button);
    }

    public void kf(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.fcJ = z;
        if (this.ffF == null && this.ffG == null) {
            this.ffF = this.mNavigationBar.addCustomView(controlAlign, d.h.nb_item_floor_share, this.eUm.cIA);
            this.ffG = (ImageView) this.ffF.findViewById(d.g.navigationBarBtnShare);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.cSq, this.cSq);
            layoutParams.rightMargin = this.DS4;
            this.ffF.setLayoutParams(layoutParams);
            aj.a(this.ffG, d.f.icon_pb_navi_selector, d.f.icon_pb_navi_selector);
        }
        if (this.ffE == null && this.Sl == null) {
            this.ffE = this.mNavigationBar.addCustomView(controlAlign, d.h.nb_item_floor_more, this.eUm.cIA);
            this.Sl = (ImageView) this.ffE.findViewById(d.g.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.cSq, this.cSq);
            layoutParams2.rightMargin = this.ffT;
            this.ffE.setLayoutParams(layoutParams2);
            aj.a(this.Sl, d.f.icon_nav_more_selector, d.f.icon_nav_more_selector);
            this.ffE.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
        if (z) {
            if (this.ffJ == null) {
                this.ffJ = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.nav_user_concern_layout, (View.OnClickListener) null);
                this.ffK = (PbNavbarUserConcernView) this.ffJ.findViewById(d.g.view_add_concern);
                this.ffL = (HeadPendantView) this.ffJ.findViewById(d.g.view_host_pendant_photo);
                this.ffL.wk();
                if (this.ffL.getHeadView() != null) {
                    this.ffL.getHeadView().setIsRound(true);
                    this.ffL.getHeadView().setDefaultBgResource(d.C0082d.transparent);
                    this.ffL.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.setMargins(this.ffS, 0, 0, 0);
                this.ffJ.setLayoutParams(layoutParams3);
                this.ffK.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        } else if (this.ffJ != null) {
            this.mNavigationBar.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_LEFT).removeView(this.ffJ);
        }
    }

    public void jM(boolean z) {
        if (this.ffE != null) {
            this.ffE.setVisibility(z ? 0 : 8);
        }
    }

    public void kg(boolean z) {
        if (this.ffF != null && !z) {
            this.ffF.setVisibility(8);
        }
    }

    public NavigationBar aXb() {
        return this.mNavigationBar;
    }

    public void setTitleVisibility(boolean z) {
        if (z) {
            this.aMn.setVisibility(0);
        } else {
            this.aMn.setVisibility(8);
        }
        ki(z);
    }

    public void nG(String str) {
        if (!TextUtils.isEmpty(str) && !this.fcJ) {
            this.ffD.setText(this.eUm.getResources().getString(d.j.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            ki(true);
            h.pa().cs(str);
            return;
        }
        ki(false);
    }

    public void a(MetaData metaData, View.OnClickListener onClickListener) {
        if (metaData != null) {
            UtilHelper.showHeadImageViewBigV(this.ffL.getHeadView(), metaData);
            this.ffL.getHeadView().setImageDrawable(null);
            this.ffL.getPendantView().setImageDrawable(null);
            this.ffL.getHeadView().startLoad(metaData.getPortrait(), 28, false);
            this.ffL.getHeadView().setUserId(metaData.getUserId());
            this.ffL.getHeadView().setUserName(metaData.getUserName());
            this.ffL.getHeadView().setOnClickListener(onClickListener);
            if (metaData.getPendantData() != null && !StringUtils.isNull(metaData.getPendantData().pT())) {
                this.ffL.es(metaData.getPendantData().pT());
            } else {
                this.ffL.es(null);
            }
        }
    }

    public void a(ab abVar) {
        if (!this.eUm.isProgressBarShown()) {
            if (this.ffM == null) {
                this.ffN = new aa((PbActivity) this.eUm.getPageContext().getOrignalPage(), this.eUm.cIA);
                this.ffM = new f(this.eUm.getPageContext().getPageActivity(), this.ffN.getView(), aj.getDrawable(d.f.bg_pull_down_right_n), new d.a() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                    @Override // com.baidu.tbadk.core.view.d.a
                    public void ow() {
                        c.this.eUm.aSQ();
                    }

                    @Override // com.baidu.tbadk.core.view.d.a
                    public void ox() {
                    }
                });
            }
            this.ffN.aVl();
            if (this.ffP) {
                final Rect rect = new Rect();
                if (this.eUm.eSF) {
                    e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.eUm.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                            int height = c.this.eUm.getWindow().getDecorView().getHeight();
                            c.this.ffM.setClippingEnabled(false);
                            c.this.ffM.showAtLocation(c.this.eUm.findViewById(d.g.pb_layout), 81, 0, height - rect.bottom);
                        }
                    }, 500L);
                } else {
                    this.eUm.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    int height = this.eUm.getWindow().getDecorView().getHeight();
                    this.ffM.setClippingEnabled(false);
                    this.ffM.showAtLocation(this.eUm.findViewById(d.g.pb_layout), 81, 0, height - rect.bottom);
                }
            } else {
                this.ffM.showAtLocation(this.eUm.findViewById(d.g.pb_layout), 17, 0, 0);
            }
            this.ffN.jB(abVar == null ? false : abVar.eYK);
            this.ffN.jD(abVar == null ? false : abVar.eYQ);
            this.ffN.jE(abVar == null ? false : abVar.eYR);
            this.ffN.jF(abVar == null ? false : abVar.eYS);
            this.ffN.jG(abVar == null ? true : abVar.eYZ);
            if (abVar == null) {
                this.ffN.I(false, false);
                this.ffN.J(false, false);
                this.ffN.l(false, "");
            } else {
                this.ffN.I(abVar.eYO, abVar.eYW);
                this.ffN.J(abVar.eYP, abVar.eYV);
                this.ffN.l(StringUtils.isNull(abVar.eYY) ? false : true, abVar.eYY);
            }
            boolean z = abVar == null ? false : abVar.eYM;
            boolean z2 = abVar == null ? false : abVar.ePm;
            boolean z3 = abVar == null ? false : abVar.isHostOnly;
            boolean z4 = abVar == null ? false : abVar.eYX;
            boolean z5 = abVar == null ? false : abVar.eYN;
            boolean z6 = abVar == null ? false : abVar.eYT;
            boolean z7 = abVar == null ? false : abVar.eYU;
            this.ffN.jC(abVar == null ? false : abVar.eYL);
            this.ffN.H(z4, z3);
            this.ffN.K(z5, z);
            this.ffN.L(z7, z6);
            if (abVar != null) {
                this.ffN.eYG = abVar.eZa;
                if (abVar.eZa) {
                    this.ffN.aVe().setText(d.j.report_text);
                    this.ffN.jF(false);
                }
            }
            i(z, z2, z3);
        }
    }

    public void aXc() {
        this.ffN.aVk().setText(this.eUm.getResources().getString(d.j.haved_fans_call));
    }

    private void i(boolean z, boolean z2, boolean z3) {
        if (this.ffN != null) {
            this.ffN.adc();
            if (z) {
                this.ffN.aUR().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_recommend_reversed_down_selector), (Drawable) null, (Drawable) null);
            } else {
                this.ffN.aUR().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
            }
            if (z2) {
                this.ffN.aUR().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.ffN.aUR().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
            if (z3) {
                this.ffN.aVc().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_host_only_selector), (Drawable) null, (Drawable) null);
            } else {
                this.ffN.aVc().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void ot() {
        if (this.ffN != null) {
            this.ffN.aVm();
        }
        if (this.aHk == null) {
            this.aHk = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.ffM != null) {
                        g.a(c.this.ffM, c.this.eUm.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.fP().postDelayed(this.aHk, 100L);
    }

    public aa aXd() {
        return this.ffN;
    }

    public View aXe() {
        return this.ffH;
    }

    public boolean acz() {
        return this.ffM != null && this.ffM.isShowing();
    }

    public void aFV() {
        if (this.ffN != null) {
            this.ffN.release();
        }
        this.ffM = null;
        this.ffN = null;
        e.fP().removeCallbacks(this.aHk);
    }

    public void aXf() {
        if (this.ffE != null) {
            this.ffE.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.eUm.getPageContext(), i);
            aj.j(this.mNavigationBar.getBarBgView(), d.C0082d.cp_bg_line_d);
        }
        if (this.Sl != null) {
            aj.a(this.Sl, d.f.icon_nav_more_selector, d.f.icon_nav_more_selector);
        }
        if (this.ffG != null) {
            aj.a(this.ffG, d.f.icon_pb_navi_selector, d.f.icon_pb_navi_selector);
        }
        if (this.ffK != null) {
            this.ffK.onChangeSkinType(i);
        }
        aj.b(this.ffD, d.C0082d.cp_cont_b, d.C0082d.s_navbar_title_color);
    }

    public void qm(int i) {
        this.mNavigationBar.onChangeSkinType(this.eUm.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(d.f.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.eUm.getResources().getColor(d.C0082d.black_alpha85));
        if (this.ffG != null) {
            this.ffG.setImageResource(d.f.pb_ala_share);
        }
        if (this.Sl != null) {
            this.Sl.setImageResource(d.f.icon_vnav_more_bg);
        }
        this.ffD.setTextColor(this.eUm.getResources().getColor(d.C0082d.cp_cont_g));
        this.ffO.setImageResource(d.f.icon_return_bg);
    }

    public void aXg() {
        this.ffO.setVisibility(0);
        ki(false);
        if (this.ffE != null) {
            this.ffE.setVisibility(8);
        }
        if (this.ffF != null) {
            this.ffF.setVisibility(8);
        }
    }

    public void kh(boolean z) {
        this.ffO.setVisibility(0);
        ki(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.ffF != null) {
                this.ffF.setVisibility(0);
            }
            if (this.ffE != null) {
                this.ffE.setVisibility(0);
                return;
            }
            return;
        }
        if (this.ffF != null) {
            this.ffF.setVisibility(8);
        }
        if (this.ffE != null) {
            this.ffE.setVisibility(8);
        }
    }

    public void ki(boolean z) {
        if (!this.fcJ && z && !"".equals(this.ffD.getText().toString())) {
            this.ffD.setVisibility(0);
        } else {
            this.ffD.setVisibility(8);
        }
    }

    public void kj(boolean z) {
        this.ffP = z;
    }

    public void kk(boolean z) {
        if (!this.ffP || TbadkCoreApplication.isLogin() || z) {
            if (z) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("call_fan_guide", false)) {
                    kk(false);
                    return;
                }
            } else if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_share", false)) {
                return;
            }
            this.ffR = z;
            View inflate = LayoutInflater.from(this.eUm.getPageContext().getContext()).inflate(d.h.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(d.g.arrow_up);
            TextView textView = (TextView) inflate.findViewById(d.g.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            if (!z) {
                layoutParams.gravity = 5;
                if (!TbadkCoreApplication.isLogin()) {
                    layoutParams.rightMargin = l.f(this.eUm, d.e.ds28);
                } else {
                    layoutParams.rightMargin = l.f(this.eUm, d.e.ds128);
                }
                textView.setText(d.j.share_tip);
                textView.setOnClickListener(this.ffW);
                this.ffQ = new PopupWindow(inflate, -2, -2);
                e.fP().removeCallbacks(this.ffU);
                e.fP().postDelayed(this.ffU, 500L);
            }
        }
    }

    public void aXh() {
        if (this.ffU != null) {
            e.fP().removeCallbacks(this.ffU);
        }
        if (this.ffV != null) {
            e.fP().removeCallbacks(this.ffV);
        }
        aXi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXi() {
        g.a(this.ffQ);
    }

    public void f(int i, int i2, boolean z) {
        if (i2 != 0 && aXb() != null && this.ffJ != null) {
            if (!z) {
                if (this.ffJ.getAlpha() != 1.0f) {
                    this.ffJ.setAlpha(1.0f);
                    return;
                }
                return;
            }
            int measuredHeight = (aXb().getMeasuredHeight() + i2) - 1;
            if (i >= measuredHeight) {
                if (this.ffJ.getAlpha() != 0.0f) {
                    this.ffJ.setAlpha(0.0f);
                }
            } else if (i > aXb().getMeasuredHeight() && i < measuredHeight) {
                this.ffJ.setAlpha(1.0f - (((i - aXb().getMeasuredHeight()) * 1.0f) / (measuredHeight - aXb().getMeasuredHeight())));
            } else if (i <= aXb().getMeasuredHeight() && this.ffJ.getAlpha() != 1.0f) {
                this.ffJ.setAlpha(1.0f);
            }
        }
    }
}
