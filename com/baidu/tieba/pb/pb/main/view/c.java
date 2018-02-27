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
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.aa;
import com.baidu.tieba.pb.pb.main.z;
import com.baidu.tieba.pb.view.f;
/* loaded from: classes2.dex */
public class c {
    private int DS4;
    private ImageView aHW;
    private ImageView aHX;
    public final View bCp;
    private Runnable bxt;
    private PbActivity fMQ;
    public View fYA;
    private final ImageView fYB;
    private final LinearLayout fYC;
    public FrameLayout fYD;
    public PbNavbarUserConcernView fYE;
    public HeadPendantView fYF;
    public View fYG;
    private ImageView fYJ;
    private PopupWindow fYL;
    private boolean fYM;
    private int fYN;
    private int fYO;
    private int fYP;
    public TextView fYy;
    public View fYz;
    public final NavigationBar mNavigationBar;
    private boolean fVD = false;
    private f fYH = null;
    private z fYI = null;
    private boolean fYK = false;
    private boolean fYQ = false;
    private Runnable fYR = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.5
        @Override // java.lang.Runnable
        public void run() {
            View view;
            if (!c.this.fVD) {
                view = c.this.fYM ? c.this.fYz : c.this.fYA;
            } else {
                view = c.this.fYA;
            }
            if (view != null) {
                if (TbadkCoreApplication.isLogin() || !c.this.fYM) {
                    g.showPopupWindowAsDropDown(c.this.fYL, view);
                    if (!c.this.fYM) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_share", true);
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("call_fan_guide", true);
                    }
                    e.ns().removeCallbacks(c.this.fYS);
                    e.ns().postDelayed(c.this.fYS, TbConfig.NOTIFY_SOUND_INTERVAL);
                }
            }
        }
    };
    private Runnable fYS = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.6
        @Override // java.lang.Runnable
        public void run() {
            c.this.bgo();
        }
    };
    private View.OnClickListener fYT = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.bgn();
        }
    };

    public c(PbActivity pbActivity) {
        this.fYN = 0;
        this.fYO = 0;
        this.fYP = 0;
        this.DS4 = 0;
        this.fMQ = pbActivity;
        this.fYN = l.t(pbActivity, d.e.ds88);
        this.fYO = l.t(this.fMQ.getPageContext().getPageActivity(), d.e.ds22);
        this.fYP = l.t(this.fMQ.getPageContext().getPageActivity(), d.e.ds14);
        this.DS4 = l.t(this.fMQ.getPageContext().getPageActivity(), d.e.ds4);
        this.mNavigationBar = (NavigationBar) this.fMQ.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.fMQ.avi();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.bCp = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.dFR);
        this.fYy = this.mNavigationBar.setCenterTextTitle("");
        this.fYB = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.fYC = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int t = l.t(this.fMQ.getPageContext().getPageActivity(), d.e.ds20);
        this.fYC.setPadding(t, 0, t, 0);
        aj.a(this.fYB, d.f.icon_pb_play_small, d.f.icon_pb_play_small);
        this.fYB.setVisibility(8);
        this.fYy.setOnClickListener(pbActivity.dFR);
        this.fYB.setOnClickListener(pbActivity.dFR);
        this.fYJ = (ImageView) this.bCp.findViewById(d.g.widget_navi_back_button);
    }

    public void kV(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.fVD = z;
        if (this.fYA == null && this.aHX == null) {
            this.fYA = this.mNavigationBar.addCustomView(controlAlign, d.h.nb_item_floor_share, this.fMQ.dFR);
            this.aHX = (ImageView) this.fYA.findViewById(d.g.navigationBarBtnShare);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.fYN, this.fYN);
            layoutParams.rightMargin = this.DS4;
            this.fYA.setLayoutParams(layoutParams);
            bgf();
        }
        if (this.fYz == null && this.aHW == null) {
            this.fYz = this.mNavigationBar.addCustomView(controlAlign, d.h.nb_item_floor_more, this.fMQ.dFR);
            this.aHW = (ImageView) this.fYz.findViewById(d.g.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.fYN, this.fYN);
            layoutParams2.rightMargin = this.fYP;
            this.fYz.setLayoutParams(layoutParams2);
            aj.a(this.aHW, d.f.icon_nav_more_selector, d.f.icon_nav_more_selector);
            this.fYz.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
        if (z) {
            if (this.fYD == null) {
                this.fYD = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.nav_user_concern_layout, (View.OnClickListener) null);
                this.fYE = (PbNavbarUserConcernView) this.fYD.findViewById(d.g.view_add_concern);
                this.fYG = this.fYD.findViewById(d.g.bg_user_photo);
                this.fYF = (HeadPendantView) this.fYD.findViewById(d.g.view_host_pendant_photo);
                this.fYF.DS();
                if (this.fYF.getHeadView() != null) {
                    this.fYF.getHeadView().setIsRound(true);
                    this.fYF.getHeadView().setDefaultBgResource(d.C0141d.transparent);
                    this.fYF.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.setMargins(this.fYO, 0, 0, 0);
                this.fYD.setLayoutParams(layoutParams3);
                this.fYE.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                aj.s(this.fYG, d.f.shape_photo_nav_bar_bg);
            }
        } else if (this.fYD != null) {
            this.mNavigationBar.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_LEFT).removeView(this.fYD);
        }
    }

    public void kD(boolean z) {
        if (this.fYz != null) {
            this.fYz.setVisibility(z ? 0 : 8);
        }
    }

    public void kW(boolean z) {
        this.fYQ = z;
        bgf();
    }

    private void bgf() {
        if (this.aHX != null && this.fYA != null) {
            if (this.fYQ) {
                if (this.fYK) {
                    aj.a(this.aHX, d.f.icon_topbar_share_white_d, d.f.icon_topbar_share_white_d);
                } else {
                    an.Dc().c(this.aHX, d.f.icon_topbar_share_n_svg, d.C0141d.cp_cont_e);
                }
                this.fYA.setClickable(false);
                return;
            }
            if (this.fYK) {
                aj.a(this.aHX, d.f.pb_ala_share, d.f.pb_ala_share);
            } else {
                an.Dc().c(this.aHX, d.f.icon_topbar_share_n_svg, d.f.select_topbar_icon_color_tint);
            }
            this.fYA.setClickable(true);
        }
    }

    public void kX(boolean z) {
        if (this.fYA != null && !z) {
            this.fYA.setVisibility(8);
        }
    }

    public NavigationBar bgg() {
        return this.mNavigationBar;
    }

    public void kY(boolean z) {
        if (z) {
            this.bCp.setVisibility(0);
        } else {
            this.bCp.setVisibility(8);
        }
        la(z);
    }

    public void ol(String str) {
        if (!TextUtils.isEmpty(str) && !this.fVD) {
            this.fYy.setText(this.fMQ.getResources().getString(d.j.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            la(true);
            i.xo().cK(str);
            return;
        }
        la(false);
    }

    public void a(MetaData metaData, View.OnClickListener onClickListener) {
        if (metaData != null) {
            UtilHelper.showHeadImageViewBigV(this.fYF.getHeadView(), metaData);
            this.fYF.getHeadView().setImageDrawable(null);
            this.fYF.getPendantView().setImageDrawable(null);
            this.fYF.getHeadView().startLoad(metaData.getPortrait(), 28, false);
            this.fYF.getHeadView().setUserId(metaData.getUserId());
            this.fYF.getHeadView().setUserName(metaData.getUserName());
            this.fYF.getHeadView().setOnClickListener(onClickListener);
            if (metaData.getPendantData() != null && !StringUtils.isNull(metaData.getPendantData().ya())) {
                this.fYF.eS(metaData.getPendantData().ya());
            } else {
                this.fYF.eS(null);
            }
        }
    }

    public void a(aa aaVar) {
        if (!this.fMQ.isProgressBarShown()) {
            if (this.fYH == null) {
                this.fYI = new z((PbActivity) this.fMQ.getPageContext().getOrignalPage(), this.fMQ.dFR);
                this.fYH = new f(this.fMQ.getPageContext().getPageActivity(), this.fYI.getView(), aj.getDrawable(d.f.bg_pull_down_right_n), new f.a() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                    @Override // com.baidu.tbadk.core.view.f.a
                    public void wK() {
                        c.this.fMQ.bbY();
                    }

                    @Override // com.baidu.tbadk.core.view.f.a
                    public void wL() {
                    }
                });
            }
            this.fYI.ber();
            if (this.fYK) {
                final Rect rect = new Rect();
                if (this.fMQ.fLi) {
                    e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.fMQ.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                            int height = c.this.fMQ.getWindow().getDecorView().getHeight();
                            c.this.fYH.setClippingEnabled(false);
                            c.this.fYH.showAtLocation(c.this.fMQ.findViewById(d.g.pb_layout), 81, 0, height - rect.bottom);
                        }
                    }, 500L);
                } else {
                    this.fMQ.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    int height = this.fMQ.getWindow().getDecorView().getHeight();
                    this.fYH.setClippingEnabled(false);
                    this.fYH.showAtLocation(this.fMQ.findViewById(d.g.pb_layout), 81, 0, height - rect.bottom);
                }
            } else {
                this.fYH.showAtLocation(this.fMQ.findViewById(d.g.pb_layout), 17, 0, 0);
            }
            this.fYI.ks(aaVar == null ? false : aaVar.fRC);
            this.fYI.ku(aaVar == null ? false : aaVar.fRI);
            this.fYI.kv(aaVar == null ? false : aaVar.fRJ);
            this.fYI.kw(aaVar == null ? false : aaVar.fRK);
            this.fYI.kx(aaVar == null ? true : aaVar.fRR);
            if (aaVar == null) {
                this.fYI.L(false, false);
                this.fYI.M(false, false);
                this.fYI.k(false, "");
            } else {
                this.fYI.L(aaVar.fRG, aaVar.fRO);
                this.fYI.M(aaVar.fRH, aaVar.fRN);
                this.fYI.k(StringUtils.isNull(aaVar.fRQ) ? false : true, aaVar.fRQ);
            }
            boolean z = aaVar == null ? false : aaVar.fRE;
            boolean z2 = aaVar == null ? false : aaVar.fIc;
            boolean z3 = aaVar == null ? false : aaVar.isHostOnly;
            boolean z4 = aaVar == null ? false : aaVar.fRP;
            boolean z5 = aaVar == null ? false : aaVar.fRF;
            boolean z6 = aaVar == null ? false : aaVar.fRL;
            boolean z7 = aaVar == null ? false : aaVar.fRM;
            this.fYI.kt(aaVar == null ? false : aaVar.fRD);
            this.fYI.K(z4, z3);
            this.fYI.N(z5, z);
            this.fYI.O(z7, z6);
            if (aaVar != null) {
                this.fYI.fRy = aaVar.fRS;
                if (aaVar.fRS) {
                    this.fYI.bek().setText(d.j.report_text);
                    this.fYI.kw(false);
                }
            }
            j(z, z2, z3);
        }
    }

    public void bgh() {
        this.fYI.beq().setText(this.fMQ.getResources().getString(d.j.haved_fans_call));
    }

    private void j(boolean z, boolean z2, boolean z3) {
        if (this.fYI != null) {
            this.fYI.amH();
            if (z) {
                this.fYI.bdX().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_recommend_reversed_down_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fYI.bdX().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
            }
            if (z2) {
                this.fYI.bdX().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fYI.bdX().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
            if (z3) {
                this.fYI.bei().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_host_only_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fYI.bei().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void wH() {
        if (this.fYI != null) {
            this.fYI.bes();
        }
        if (this.bxt == null) {
            this.bxt = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.fYH != null) {
                        g.a(c.this.fYH, c.this.fMQ.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.ns().postDelayed(this.bxt, 100L);
    }

    public void bgi() {
        if (this.fYI != null) {
            this.fYI.bes();
        }
        if (this.fYH != null) {
            g.a(this.fYH, this.fMQ.getPageContext().getPageActivity());
        }
    }

    public z bgj() {
        return this.fYI;
    }

    public View bgk() {
        return this.fYB;
    }

    public boolean ame() {
        return this.fYH != null && this.fYH.isShowing();
    }

    public void aPb() {
        if (this.fYI != null) {
            this.fYI.release();
        }
        this.fYH = null;
        this.fYI = null;
        e.ns().removeCallbacks(this.bxt);
    }

    public void bgl() {
        if (this.fYz != null) {
            this.fYz.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.fMQ.getPageContext(), i);
            aj.s(this.mNavigationBar.getBarBgView(), d.C0141d.cp_bg_line_d);
        }
        an.Dc().c(this.fYJ, d.f.icon_topbar_return_n_svg, d.f.select_topbar_icon_color_tint);
        an.Dc().c(this.aHW, d.f.icon_topbar_more_n_svg, d.f.select_topbar_icon_color_tint);
        bgf();
        if (this.fYE != null) {
            this.fYE.onChangeSkinType(i);
        }
        if (this.fYG != null) {
            aj.s(this.fYG, d.f.shape_photo_nav_bar_bg);
        }
        aj.d(this.fYy, d.C0141d.cp_cont_b, d.C0141d.s_navbar_title_color);
    }

    public void tk(int i) {
        this.mNavigationBar.onChangeSkinType(this.fMQ.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(d.f.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.fMQ.getResources().getColor(d.C0141d.black_alpha85));
        if (this.aHX != null) {
            this.aHX.setImageResource(d.f.pb_ala_share);
        }
        if (this.aHW != null) {
            this.aHW.setImageResource(d.f.icon_vnav_more_bg);
        }
        this.fYy.setTextColor(this.fMQ.getResources().getColor(d.C0141d.cp_cont_g));
        this.fYJ.setImageResource(d.f.icon_return_bg);
    }

    public void bgm() {
        this.fYJ.setVisibility(0);
        la(false);
        if (this.fYz != null) {
            this.fYz.setVisibility(8);
        }
        if (this.fYA != null) {
            this.fYA.setVisibility(8);
        }
    }

    public void kZ(boolean z) {
        this.fYJ.setVisibility(0);
        la(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.fYA != null) {
                this.fYA.setVisibility(0);
            }
            if (this.fYz != null) {
                this.fYz.setVisibility(0);
                return;
            }
            return;
        }
        if (this.fYA != null) {
            this.fYA.setVisibility(8);
        }
        if (this.fYz != null) {
            this.fYz.setVisibility(8);
        }
    }

    public void la(boolean z) {
        if (!this.fVD && z && !"".equals(this.fYy.getText().toString())) {
            this.fYy.setVisibility(0);
        } else {
            this.fYy.setVisibility(8);
        }
    }

    public void lb(boolean z) {
        this.fYK = z;
    }

    public void lc(boolean z) {
        if (!this.fYK || TbadkCoreApplication.isLogin() || z) {
            if (z) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("call_fan_guide", false)) {
                    lc(false);
                    return;
                }
            } else if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_share", false)) {
                return;
            }
            this.fYM = z;
            View inflate = LayoutInflater.from(this.fMQ.getPageContext().getContext()).inflate(d.h.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(d.g.arrow_up);
            TextView textView = (TextView) inflate.findViewById(d.g.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            if (!z) {
                layoutParams.gravity = 5;
                if (!TbadkCoreApplication.isLogin()) {
                    layoutParams.rightMargin = l.t(this.fMQ, d.e.ds28);
                } else {
                    layoutParams.rightMargin = l.t(this.fMQ, d.e.ds128);
                }
                textView.setText(d.j.share_tip);
                textView.setOnClickListener(this.fYT);
                this.fYL = new PopupWindow(inflate, -2, -2);
                e.ns().removeCallbacks(this.fYR);
                e.ns().postDelayed(this.fYR, 500L);
            }
        }
    }

    public void bgn() {
        if (this.fYR != null) {
            e.ns().removeCallbacks(this.fYR);
        }
        if (this.fYS != null) {
            e.ns().removeCallbacks(this.fYS);
        }
        bgo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgo() {
        g.b(this.fYL);
    }

    public void j(int i, int i2, boolean z) {
        if (i2 != 0 && bgg() != null && this.fYD != null) {
            if (!z) {
                if (this.fYD.getAlpha() != 1.0f) {
                    this.fYD.setAlpha(1.0f);
                    return;
                }
                return;
            }
            int measuredHeight = (bgg().getMeasuredHeight() + i2) - 1;
            if (i >= measuredHeight) {
                if (this.fYD.getAlpha() != 0.0f) {
                    this.fYD.setAlpha(0.0f);
                }
            } else if (i > bgg().getMeasuredHeight() && i < measuredHeight) {
                this.fYD.setAlpha(1.0f - (((i - bgg().getMeasuredHeight()) * 1.0f) / (measuredHeight - bgg().getMeasuredHeight())));
            } else if (i <= bgg().getMeasuredHeight() && this.fYD.getAlpha() != 1.0f) {
                this.fYD.setAlpha(1.0f);
            }
        }
    }
}
