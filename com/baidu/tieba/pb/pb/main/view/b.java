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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.f;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.aa;
import com.baidu.tieba.pb.pb.main.ab;
import com.baidu.tieba.pb.view.c;
/* loaded from: classes2.dex */
public class b {
    private int DS4;
    private Runnable aRk;
    public final View aVP;
    private ImageView aba;
    private ImageView abb;
    private int ccS;
    public View fJA;
    private final ImageView fJB;
    private final LinearLayout fJC;
    public FrameLayout fJD;
    public PbNavbarUserConcernView fJE;
    public HeadPendantView fJF;
    public View fJG;
    private ImageView fJJ;
    private PopupWindow fJL;
    private boolean fJM;
    private int fJN;
    private int fJO;
    public TextView fJy;
    public View fJz;
    private PbActivity fxm;
    public final NavigationBar mNavigationBar;
    private boolean fGC = false;
    private c fJH = null;
    private aa fJI = null;
    private boolean fJK = false;
    private boolean fJP = false;
    private Runnable fJQ = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.5
        @Override // java.lang.Runnable
        public void run() {
            View view;
            if (!b.this.fGC) {
                view = b.this.fJM ? b.this.fJz : b.this.fJA;
            } else {
                view = b.this.fJA;
            }
            if (view != null) {
                if (TbadkCoreApplication.isLogin() || !b.this.fJM) {
                    g.showPopupWindowAsDropDown(b.this.fJL, view);
                    if (!b.this.fJM) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_share", true);
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("call_fan_guide", true);
                    }
                    e.in().removeCallbacks(b.this.fJR);
                    e.in().postDelayed(b.this.fJR, TbConfig.NOTIFY_SOUND_INTERVAL);
                }
            }
        }
    };
    private Runnable fJR = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.6
        @Override // java.lang.Runnable
        public void run() {
            b.this.bfi();
        }
    };
    private View.OnClickListener fJS = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.bfh();
        }
    };

    public b(PbActivity pbActivity) {
        this.ccS = 0;
        this.fJN = 0;
        this.fJO = 0;
        this.DS4 = 0;
        this.fxm = pbActivity;
        this.ccS = l.f(pbActivity, f.e.ds88);
        this.fJN = l.f(this.fxm.getPageContext().getPageActivity(), f.e.ds22);
        this.fJO = l.f(this.fxm.getPageContext().getPageActivity(), f.e.ds14);
        this.DS4 = l.f(this.fxm.getPageContext().getPageActivity(), f.e.ds4);
        this.mNavigationBar = (NavigationBar) this.fxm.findViewById(f.g.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.fxm.auB();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.aVP = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.dog);
        this.fJy = this.mNavigationBar.setCenterTextTitle("");
        this.fJB = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.fJC = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int f = l.f(this.fxm.getPageContext().getPageActivity(), f.e.ds20);
        this.fJC.setPadding(f, 0, f, 0);
        am.a(this.fJB, f.C0146f.icon_pb_play_small, f.C0146f.icon_pb_play_small);
        this.fJB.setVisibility(8);
        this.fJy.setOnClickListener(pbActivity.dog);
        this.fJB.setOnClickListener(pbActivity.dog);
        this.fJJ = (ImageView) this.aVP.findViewById(f.g.widget_navi_back_button);
    }

    public void kA(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.fGC = z;
        if (this.fJA == null && this.abb == null) {
            this.fJA = this.mNavigationBar.addCustomView(controlAlign, f.h.nb_item_floor_share, this.fxm.dog);
            this.abb = (ImageView) this.fJA.findViewById(f.g.navigationBarBtnShare);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ccS, this.ccS);
            layoutParams.rightMargin = this.DS4;
            this.fJA.setLayoutParams(layoutParams);
            beZ();
        }
        if (this.fJz == null && this.aba == null) {
            this.fJz = this.mNavigationBar.addCustomView(controlAlign, f.h.nb_item_floor_more, this.fxm.dog);
            this.aba = (ImageView) this.fJz.findViewById(f.g.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.ccS, this.ccS);
            layoutParams2.rightMargin = this.fJO;
            this.fJz.setLayoutParams(layoutParams2);
            am.a(this.aba, f.C0146f.icon_nav_more_selector, f.C0146f.icon_nav_more_selector);
            this.fJz.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
        if (z) {
            if (this.fJD == null) {
                this.fJD = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, f.h.nav_user_concern_layout, (View.OnClickListener) null);
                this.fJE = (PbNavbarUserConcernView) this.fJD.findViewById(f.g.view_add_concern);
                this.fJG = this.fJD.findViewById(f.g.bg_user_photo);
                this.fJF = (HeadPendantView) this.fJD.findViewById(f.g.view_host_pendant_photo);
                this.fJF.setHasPendantStyle();
                if (this.fJF.getHeadView() != null) {
                    this.fJF.getHeadView().setIsRound(true);
                    this.fJF.getHeadView().setDefaultBgResource(f.d.transparent);
                    this.fJF.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.setMargins(this.fJN, 0, 0, 0);
                this.fJD.setLayoutParams(layoutParams3);
                this.fJE.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                am.i(this.fJG, f.C0146f.shape_photo_nav_bar_bg);
            }
        } else if (this.fJD != null) {
            this.mNavigationBar.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_LEFT).removeView(this.fJD);
        }
    }

    public void kh(boolean z) {
        if (this.fJz != null) {
            this.fJz.setVisibility(z ? 0 : 8);
        }
    }

    public void kB(boolean z) {
        this.fJP = z;
        beZ();
    }

    private void beZ() {
        if (this.abb != null && this.fJA != null) {
            if (this.fJP) {
                if (this.fJK) {
                    am.a(this.abb, f.C0146f.icon_topbar_share_white_d, f.C0146f.icon_topbar_share_white_d);
                } else {
                    aq.zt().c(this.abb, f.C0146f.icon_topbar_share_n_svg, f.d.cp_cont_e);
                }
                this.fJA.setClickable(false);
                return;
            }
            if (this.fJK) {
                am.a(this.abb, f.C0146f.pb_ala_share, f.C0146f.pb_ala_share);
            } else {
                aq.zt().c(this.abb, f.C0146f.icon_topbar_share_n_svg, f.d.select_topbar_icon_color_tint);
            }
            this.fJA.setClickable(true);
        }
    }

    public void kC(boolean z) {
        if (this.fJA != null && !z) {
            this.fJA.setVisibility(8);
        }
    }

    public NavigationBar bfa() {
        return this.mNavigationBar;
    }

    public void kD(boolean z) {
        if (z) {
            this.aVP.setVisibility(0);
        } else {
            this.aVP.setVisibility(8);
        }
        kF(z);
    }

    public void pk(String str) {
        if (!TextUtils.isEmpty(str) && !this.fGC) {
            this.fJy.setText(this.fxm.getResources().getString(f.j.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            kF(true);
            i.td().da(str);
            return;
        }
        kF(false);
    }

    public void a(MetaData metaData, View.OnClickListener onClickListener) {
        if (metaData != null) {
            UtilHelper.showHeadImageViewBigV(this.fJF.getHeadView(), metaData);
            this.fJF.getHeadView().setImageDrawable(null);
            this.fJF.getPendantView().setImageDrawable(null);
            this.fJF.getHeadView().startLoad(metaData.getPortrait(), 28, false);
            this.fJF.getHeadView().setUserId(metaData.getUserId());
            this.fJF.getHeadView().setUserName(metaData.getUserName());
            this.fJF.getHeadView().setOnClickListener(onClickListener);
            if (metaData.getPendantData() != null && !StringUtils.isNull(metaData.getPendantData().tT())) {
                this.fJF.fl(metaData.getPendantData().tT());
            } else {
                this.fJF.fl(null);
            }
        }
    }

    public void a(ab abVar) {
        if (!this.fxm.isProgressBarShown()) {
            if (this.fJH == null) {
                this.fJI = new aa((PbActivity) this.fxm.getPageContext().getOrignalPage(), this.fxm.dog);
                this.fJH = new c(this.fxm.getPageContext().getPageActivity(), this.fJI.getView(), am.getDrawable(f.C0146f.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.pb.pb.main.view.b.2
                    @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                    public void sB() {
                        b.this.fxm.baO();
                    }

                    @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                    public void sC() {
                    }
                });
            }
            this.fJI.bdj();
            if (this.fJK) {
                final Rect rect = new Rect();
                if (this.fxm.fvE) {
                    e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.3
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.fxm.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                            int height = b.this.fxm.getWindow().getDecorView().getHeight();
                            b.this.fJH.setClippingEnabled(false);
                            b.this.fJH.showAtLocation(b.this.fxm.findViewById(f.g.pb_layout), 81, 0, height - rect.bottom);
                        }
                    }, 500L);
                } else {
                    this.fxm.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    int height = this.fxm.getWindow().getDecorView().getHeight();
                    this.fJH.setClippingEnabled(false);
                    this.fJH.showAtLocation(this.fxm.findViewById(f.g.pb_layout), 81, 0, height - rect.bottom);
                }
            } else {
                this.fJH.showAtLocation(this.fxm.findViewById(f.g.pb_layout), 17, 0, 0);
            }
            this.fJI.jW(abVar == null ? false : abVar.fCx);
            this.fJI.jY(abVar == null ? false : abVar.fCC);
            this.fJI.jZ(abVar == null ? false : abVar.fCD);
            this.fJI.ka(abVar == null ? false : abVar.fCE);
            this.fJI.kb(abVar == null ? true : abVar.fCL);
            if (abVar == null) {
                this.fJI.J(false, false);
                this.fJI.K(false, false);
                this.fJI.m(false, "");
            } else {
                this.fJI.J(abVar.fCA, abVar.fCI);
                this.fJI.K(abVar.fCB, abVar.fCH);
                this.fJI.m(StringUtils.isNull(abVar.fCK) ? false : true, abVar.fCK);
            }
            boolean z = abVar == null ? false : abVar.nK;
            boolean z2 = abVar == null ? false : abVar.fts;
            boolean z3 = abVar == null ? false : abVar.isHostOnly;
            boolean z4 = abVar == null ? false : abVar.fCJ;
            boolean z5 = abVar == null ? false : abVar.fCz;
            boolean z6 = abVar == null ? false : abVar.fCF;
            boolean z7 = abVar == null ? false : abVar.fCG;
            this.fJI.jX(abVar == null ? false : abVar.fCy);
            this.fJI.I(z4, z3);
            this.fJI.L(z5, z);
            this.fJI.M(z7, z6);
            if (abVar != null) {
                this.fJI.fCt = abVar.fCM;
                if (abVar.fCM) {
                    this.fJI.bdc().setText(f.j.report_text);
                    this.fJI.ka(false);
                }
            }
            h(z, z2, z3);
        }
    }

    public void bfb() {
        this.fJI.bdi().setText(this.fxm.getResources().getString(f.j.haved_fans_call));
    }

    private void h(boolean z, boolean z2, boolean z3) {
        if (this.fJI != null) {
            this.fJI.setBackGround();
            if (z) {
                this.fJI.bcP().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(f.C0146f.icon_recommend_reversed_down_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fJI.bcP().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(f.C0146f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
            }
            if (z2) {
                this.fJI.bcP().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(f.C0146f.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fJI.bcP().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(f.C0146f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
            if (z3) {
                this.fJI.bda().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(f.C0146f.icon_host_only_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fJI.bda().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(f.C0146f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void sy() {
        if (this.fJI != null) {
            this.fJI.bdk();
        }
        if (this.aRk == null) {
            this.aRk = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.4
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.fJH != null) {
                        g.a(b.this.fJH, b.this.fxm.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.in().postDelayed(this.aRk, 100L);
    }

    public void bfc() {
        if (this.fJI != null) {
            this.fJI.bdk();
        }
        if (this.fJH != null) {
            g.a(this.fJH, this.fxm.getPageContext().getPageActivity());
        }
    }

    public aa bfd() {
        return this.fJI;
    }

    public View bfe() {
        return this.fJB;
    }

    public boolean ajI() {
        return this.fJH != null && this.fJH.isShowing();
    }

    public void aQD() {
        if (this.fJI != null) {
            this.fJI.release();
        }
        this.fJH = null;
        this.fJI = null;
        e.in().removeCallbacks(this.aRk);
    }

    public void bff() {
        if (this.fJz != null) {
            this.fJz.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.fxm.getPageContext(), i);
            am.i(this.mNavigationBar.getBarBgView(), f.d.cp_bg_line_d);
        }
        aq.zt().c(this.fJJ, f.C0146f.icon_topbar_return_n_svg, f.d.select_topbar_icon_color_tint);
        aq.zt().c(this.aba, f.C0146f.icon_topbar_more_n_svg, f.d.select_topbar_icon_color_tint);
        beZ();
        if (this.fJE != null) {
            this.fJE.onChangeSkinType(i);
        }
        if (this.fJG != null) {
            am.i(this.fJG, f.C0146f.shape_photo_nav_bar_bg);
        }
        am.b(this.fJy, f.d.cp_cont_b, f.d.s_navbar_title_color);
    }

    public void qV(int i) {
        this.mNavigationBar.onChangeSkinType(this.fxm.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(f.C0146f.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.fxm.getResources().getColor(f.d.black_alpha85));
        if (this.abb != null) {
            this.abb.setImageResource(f.C0146f.pb_ala_share);
        }
        if (this.aba != null) {
            this.aba.setImageResource(f.C0146f.icon_vnav_more_bg);
        }
        this.fJy.setTextColor(this.fxm.getResources().getColor(f.d.cp_cont_g));
        this.fJJ.setImageResource(f.C0146f.icon_return_bg);
    }

    public void bfg() {
        this.fJJ.setVisibility(0);
        kF(false);
        if (this.fJz != null) {
            this.fJz.setVisibility(8);
        }
        if (this.fJA != null) {
            this.fJA.setVisibility(8);
        }
    }

    public void kE(boolean z) {
        this.fJJ.setVisibility(0);
        kF(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.fJA != null) {
                this.fJA.setVisibility(0);
            }
            if (this.fJz != null) {
                this.fJz.setVisibility(0);
                return;
            }
            return;
        }
        if (this.fJA != null) {
            this.fJA.setVisibility(8);
        }
        if (this.fJz != null) {
            this.fJz.setVisibility(8);
        }
    }

    public void kF(boolean z) {
        if (!this.fGC && z && !"".equals(this.fJy.getText().toString())) {
            this.fJy.setVisibility(0);
        } else {
            this.fJy.setVisibility(8);
        }
    }

    public void kG(boolean z) {
        this.fJK = z;
    }

    public void kH(boolean z) {
        if (!this.fJK || TbadkCoreApplication.isLogin() || z) {
            if (z) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("call_fan_guide", false)) {
                    kH(false);
                    return;
                }
            } else if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_share", false)) {
                return;
            }
            this.fJM = z;
            View inflate = LayoutInflater.from(this.fxm.getPageContext().getContext()).inflate(f.h.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(f.g.arrow_up);
            TextView textView = (TextView) inflate.findViewById(f.g.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            if (!z) {
                layoutParams.gravity = 5;
                if (!TbadkCoreApplication.isLogin()) {
                    layoutParams.rightMargin = l.f(this.fxm, f.e.ds28);
                } else {
                    layoutParams.rightMargin = l.f(this.fxm, f.e.ds128);
                }
                textView.setText(f.j.share_tip);
                textView.setOnClickListener(this.fJS);
                this.fJL = new PopupWindow(inflate, -2, -2);
                e.in().removeCallbacks(this.fJQ);
                e.in().postDelayed(this.fJQ, 500L);
            }
        }
    }

    public void bfh() {
        if (this.fJQ != null) {
            e.in().removeCallbacks(this.fJQ);
        }
        if (this.fJR != null) {
            e.in().removeCallbacks(this.fJR);
        }
        bfi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfi() {
        g.a(this.fJL);
    }

    public void g(int i, int i2, boolean z) {
        if (i2 != 0 && bfa() != null && this.fJD != null) {
            if (!z) {
                if (this.fJD.getAlpha() != 1.0f) {
                    this.fJD.setAlpha(1.0f);
                }
                if (this.fJE.getAlpha() != 1.0f) {
                    this.fJE.setAlpha(1.0f);
                    return;
                }
                return;
            }
            int measuredHeight = (bfa().getMeasuredHeight() + i2) - 1;
            if (i >= measuredHeight) {
                if (this.fJD.getAlpha() != 0.0f) {
                    this.fJD.setAlpha(0.0f);
                }
                if (this.fJE.getAlpha() != 0.0f) {
                    this.fJE.setAlpha(0.0f);
                }
            } else if (i > bfa().getMeasuredHeight() && i < measuredHeight) {
                float measuredHeight2 = ((i - bfa().getMeasuredHeight()) * 1.0f) / (measuredHeight - bfa().getMeasuredHeight());
                this.fJD.setAlpha(1.0f - measuredHeight2);
                this.fJE.setAlpha(1.0f - measuredHeight2);
            } else if (i <= bfa().getMeasuredHeight()) {
                if (this.fJD.getAlpha() != 1.0f) {
                    this.fJD.setAlpha(1.0f);
                }
                if (this.fJE.getAlpha() != 1.0f) {
                    this.fJE.setAlpha(1.0f);
                }
            }
        }
    }
}
