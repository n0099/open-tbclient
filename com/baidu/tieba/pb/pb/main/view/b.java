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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.aa;
import com.baidu.tieba.pb.pb.main.z;
import com.baidu.tieba.pb.view.c;
/* loaded from: classes2.dex */
public class b {
    private int DS4;
    private ImageView Tp;
    private ImageView Tq;
    private Runnable aHT;
    public final View aMS;
    private PbActivity fgJ;
    public TextView fsR;
    public View fsS;
    public View fsT;
    private final ImageView fsU;
    private final LinearLayout fsV;
    public FrameLayout fsW;
    public PbNavbarUserConcernView fsX;
    public HeadPendantView fsY;
    public View fsZ;
    private ImageView ftc;
    private PopupWindow fte;
    private boolean ftf;
    private int ftg;
    private int fth;
    private int fti;
    public final NavigationBar mNavigationBar;
    private boolean fpW = false;
    private c fta = null;
    private z ftb = null;
    private boolean ftd = false;
    private boolean ftj = false;
    private Runnable ftk = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.5
        @Override // java.lang.Runnable
        public void run() {
            View view2;
            if (!b.this.fpW) {
                view2 = b.this.ftf ? b.this.fsS : b.this.fsT;
            } else {
                view2 = b.this.fsT;
            }
            if (view2 != null) {
                if (TbadkCoreApplication.isLogin() || !b.this.ftf) {
                    g.showPopupWindowAsDropDown(b.this.fte, view2);
                    if (!b.this.ftf) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_share", true);
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("call_fan_guide", true);
                    }
                    e.fw().removeCallbacks(b.this.ftl);
                    e.fw().postDelayed(b.this.ftl, TbConfig.NOTIFY_SOUND_INTERVAL);
                }
            }
        }
    };
    private Runnable ftl = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.6
        @Override // java.lang.Runnable
        public void run() {
            b.this.bbn();
        }
    };
    private View.OnClickListener ftm = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            b.this.bbm();
        }
    };

    public b(PbActivity pbActivity) {
        this.ftg = 0;
        this.fth = 0;
        this.fti = 0;
        this.DS4 = 0;
        this.fgJ = pbActivity;
        this.ftg = l.e(pbActivity, d.e.ds88);
        this.fth = l.e(this.fgJ.getPageContext().getPageActivity(), d.e.ds22);
        this.fti = l.e(this.fgJ.getPageContext().getPageActivity(), d.e.ds14);
        this.DS4 = l.e(this.fgJ.getPageContext().getPageActivity(), d.e.ds4);
        this.mNavigationBar = (NavigationBar) this.fgJ.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.fgJ.apD();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.aMS = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.cYQ);
        this.fsR = this.mNavigationBar.setCenterTextTitle("");
        this.fsU = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.fsV = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int e = l.e(this.fgJ.getPageContext().getPageActivity(), d.e.ds20);
        this.fsV.setPadding(e, 0, e, 0);
        ak.a(this.fsU, d.f.icon_pb_play_small, d.f.icon_pb_play_small);
        this.fsU.setVisibility(8);
        this.fsR.setOnClickListener(pbActivity.cYQ);
        this.fsU.setOnClickListener(pbActivity.cYQ);
        this.ftc = (ImageView) this.aMS.findViewById(d.g.widget_navi_back_button);
    }

    public void kx(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.fpW = z;
        if (this.fsT == null && this.Tq == null) {
            this.fsT = this.mNavigationBar.addCustomView(controlAlign, d.i.nb_item_floor_share, this.fgJ.cYQ);
            this.Tq = (ImageView) this.fsT.findViewById(d.g.navigationBarBtnShare);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ftg, this.ftg);
            layoutParams.rightMargin = this.DS4;
            this.fsT.setLayoutParams(layoutParams);
            bbe();
        }
        if (this.fsS == null && this.Tp == null) {
            this.fsS = this.mNavigationBar.addCustomView(controlAlign, d.i.nb_item_floor_more, this.fgJ.cYQ);
            this.Tp = (ImageView) this.fsS.findViewById(d.g.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.ftg, this.ftg);
            layoutParams2.rightMargin = this.fti;
            this.fsS.setLayoutParams(layoutParams2);
            ak.a(this.Tp, d.f.icon_nav_more_selector, d.f.icon_nav_more_selector);
            this.fsS.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
        if (z) {
            if (this.fsW == null) {
                this.fsW = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.nav_user_concern_layout, (View.OnClickListener) null);
                this.fsX = (PbNavbarUserConcernView) this.fsW.findViewById(d.g.view_add_concern);
                this.fsZ = this.fsW.findViewById(d.g.bg_user_photo);
                this.fsY = (HeadPendantView) this.fsW.findViewById(d.g.view_host_pendant_photo);
                this.fsY.setHasPendantStyle();
                if (this.fsY.getHeadView() != null) {
                    this.fsY.getHeadView().setIsRound(true);
                    this.fsY.getHeadView().setDefaultBgResource(d.C0126d.transparent);
                    this.fsY.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.setMargins(this.fth, 0, 0, 0);
                this.fsW.setLayoutParams(layoutParams3);
                this.fsX.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                ak.i(this.fsZ, d.f.shape_photo_nav_bar_bg);
            }
        } else if (this.fsW != null) {
            this.mNavigationBar.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_LEFT).removeView(this.fsW);
        }
    }

    public void ke(boolean z) {
        if (this.fsS != null) {
            this.fsS.setVisibility(z ? 0 : 8);
        }
    }

    public void ky(boolean z) {
        this.ftj = z;
        bbe();
    }

    private void bbe() {
        if (this.Tq != null && this.fsT != null) {
            if (this.ftj) {
                if (this.ftd) {
                    ak.a(this.Tq, d.f.icon_topbar_share_white_d, d.f.icon_topbar_share_white_d);
                } else {
                    ao.vP().c(this.Tq, d.f.icon_topbar_share_n_svg, d.C0126d.cp_cont_e);
                }
                this.fsT.setClickable(false);
                return;
            }
            if (this.ftd) {
                ak.a(this.Tq, d.f.pb_ala_share, d.f.pb_ala_share);
            } else {
                ao.vP().c(this.Tq, d.f.icon_topbar_share_n_svg, d.f.select_topbar_icon_color_tint);
            }
            this.fsT.setClickable(true);
        }
    }

    public void kz(boolean z) {
        if (this.fsT != null && !z) {
            this.fsT.setVisibility(8);
        }
    }

    public NavigationBar bbf() {
        return this.mNavigationBar;
    }

    public void kA(boolean z) {
        if (z) {
            this.aMS.setVisibility(0);
        } else {
            this.aMS.setVisibility(8);
        }
        kC(z);
    }

    public void oq(String str) {
        if (!TextUtils.isEmpty(str) && !this.fpW) {
            this.fsR.setText(this.fgJ.getResources().getString(d.k.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            kC(true);
            i.pY().cC(str);
            return;
        }
        kC(false);
    }

    public void a(MetaData metaData, View.OnClickListener onClickListener) {
        if (metaData != null) {
            UtilHelper.showHeadImageViewBigV(this.fsY.getHeadView(), metaData);
            this.fsY.getHeadView().setImageDrawable(null);
            this.fsY.getPendantView().setImageDrawable(null);
            this.fsY.getHeadView().startLoad(metaData.getPortrait(), 28, false);
            this.fsY.getHeadView().setUserId(metaData.getUserId());
            this.fsY.getHeadView().setUserName(metaData.getUserName());
            this.fsY.getHeadView().setOnClickListener(onClickListener);
            if (metaData.getPendantData() != null && !StringUtils.isNull(metaData.getPendantData().qG())) {
                this.fsY.eK(metaData.getPendantData().qG());
            } else {
                this.fsY.eK(null);
            }
        }
    }

    public void a(aa aaVar) {
        if (!this.fgJ.isProgressBarShown()) {
            if (this.fta == null) {
                this.ftb = new z((PbActivity) this.fgJ.getPageContext().getOrignalPage(), this.fgJ.cYQ);
                this.fta = new c(this.fgJ.getPageContext().getPageActivity(), this.ftb.getView(), ak.getDrawable(d.f.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.pb.pb.main.view.b.2
                    @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                    public void pu() {
                        b.this.fgJ.aWX();
                    }

                    @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                    public void pv() {
                    }
                });
            }
            this.ftb.aZp();
            if (this.ftd) {
                final Rect rect = new Rect();
                if (this.fgJ.ffb) {
                    e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.3
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.fgJ.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                            int height = b.this.fgJ.getWindow().getDecorView().getHeight();
                            b.this.fta.setClippingEnabled(false);
                            b.this.fta.showAtLocation(b.this.fgJ.findViewById(d.g.pb_layout), 81, 0, height - rect.bottom);
                        }
                    }, 500L);
                } else {
                    this.fgJ.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    int height = this.fgJ.getWindow().getDecorView().getHeight();
                    this.fta.setClippingEnabled(false);
                    this.fta.showAtLocation(this.fgJ.findViewById(d.g.pb_layout), 81, 0, height - rect.bottom);
                }
            } else {
                this.fta.showAtLocation(this.fgJ.findViewById(d.g.pb_layout), 17, 0, 0);
            }
            this.ftb.jT(aaVar == null ? false : aaVar.flO);
            this.ftb.jV(aaVar == null ? false : aaVar.flU);
            this.ftb.jW(aaVar == null ? false : aaVar.flV);
            this.ftb.jX(aaVar == null ? false : aaVar.flW);
            this.ftb.jY(aaVar == null ? true : aaVar.fmd);
            if (aaVar == null) {
                this.ftb.G(false, false);
                this.ftb.H(false, false);
                this.ftb.m(false, "");
            } else {
                this.ftb.G(aaVar.flS, aaVar.fma);
                this.ftb.H(aaVar.flT, aaVar.flZ);
                this.ftb.m(StringUtils.isNull(aaVar.fmc) ? false : true, aaVar.fmc);
            }
            boolean z = aaVar == null ? false : aaVar.flQ;
            boolean z2 = aaVar == null ? false : aaVar.fcS;
            boolean z3 = aaVar == null ? false : aaVar.isHostOnly;
            boolean z4 = aaVar == null ? false : aaVar.fmb;
            boolean z5 = aaVar == null ? false : aaVar.flR;
            boolean z6 = aaVar == null ? false : aaVar.flX;
            boolean z7 = aaVar == null ? false : aaVar.flY;
            this.ftb.jU(aaVar == null ? false : aaVar.flP);
            this.ftb.F(z4, z3);
            this.ftb.I(z5, z);
            this.ftb.J(z7, z6);
            if (aaVar != null) {
                this.ftb.flK = aaVar.fme;
                if (aaVar.fme) {
                    this.ftb.aZi().setText(d.k.report_text);
                    this.ftb.jX(false);
                }
            }
            i(z, z2, z3);
        }
    }

    public void bbg() {
        this.ftb.aZo().setText(this.fgJ.getResources().getString(d.k.haved_fans_call));
    }

    private void i(boolean z, boolean z2, boolean z3) {
        if (this.ftb != null) {
            this.ftb.setBackGround();
            if (z) {
                this.ftb.aYV().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ak.getDrawable(d.f.icon_recommend_reversed_down_selector), (Drawable) null, (Drawable) null);
            } else {
                this.ftb.aYV().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ak.getDrawable(d.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
            }
            if (z2) {
                this.ftb.aYV().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ak.getDrawable(d.f.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.ftb.aYV().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ak.getDrawable(d.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
            if (z3) {
                this.ftb.aZg().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ak.getDrawable(d.f.icon_host_only_selector), (Drawable) null, (Drawable) null);
            } else {
                this.ftb.aZg().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ak.getDrawable(d.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void pr() {
        if (this.ftb != null) {
            this.ftb.aZq();
        }
        if (this.aHT == null) {
            this.aHT = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.4
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.fta != null) {
                        g.a(b.this.fta, b.this.fgJ.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.fw().postDelayed(this.aHT, 100L);
    }

    public void bbh() {
        if (this.ftb != null) {
            this.ftb.aZq();
        }
        if (this.fta != null) {
            g.a(this.fta, this.fgJ.getPageContext().getPageActivity());
        }
    }

    public z bbi() {
        return this.ftb;
    }

    public View bbj() {
        return this.fsU;
    }

    public boolean agf() {
        return this.fta != null && this.fta.isShowing();
    }

    public void aKe() {
        if (this.ftb != null) {
            this.ftb.release();
        }
        this.fta = null;
        this.ftb = null;
        e.fw().removeCallbacks(this.aHT);
    }

    public void bbk() {
        if (this.fsS != null) {
            this.fsS.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.fgJ.getPageContext(), i);
            ak.i(this.mNavigationBar.getBarBgView(), d.C0126d.cp_bg_line_d);
        }
        ao.vP().c(this.ftc, d.f.icon_topbar_return_n_svg, d.f.select_topbar_icon_color_tint);
        ao.vP().c(this.Tp, d.f.icon_topbar_more_n_svg, d.f.select_topbar_icon_color_tint);
        bbe();
        if (this.fsX != null) {
            this.fsX.onChangeSkinType(i);
        }
        if (this.fsZ != null) {
            ak.i(this.fsZ, d.f.shape_photo_nav_bar_bg);
        }
        ak.b(this.fsR, d.C0126d.cp_cont_b, d.C0126d.s_navbar_title_color);
    }

    public void qF(int i) {
        this.mNavigationBar.onChangeSkinType(this.fgJ.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(d.f.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.fgJ.getResources().getColor(d.C0126d.black_alpha85));
        if (this.Tq != null) {
            this.Tq.setImageResource(d.f.pb_ala_share);
        }
        if (this.Tp != null) {
            this.Tp.setImageResource(d.f.icon_vnav_more_bg);
        }
        this.fsR.setTextColor(this.fgJ.getResources().getColor(d.C0126d.cp_cont_g));
        this.ftc.setImageResource(d.f.icon_return_bg);
    }

    public void bbl() {
        this.ftc.setVisibility(0);
        kC(false);
        if (this.fsS != null) {
            this.fsS.setVisibility(8);
        }
        if (this.fsT != null) {
            this.fsT.setVisibility(8);
        }
    }

    public void kB(boolean z) {
        this.ftc.setVisibility(0);
        kC(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.fsT != null) {
                this.fsT.setVisibility(0);
            }
            if (this.fsS != null) {
                this.fsS.setVisibility(0);
                return;
            }
            return;
        }
        if (this.fsT != null) {
            this.fsT.setVisibility(8);
        }
        if (this.fsS != null) {
            this.fsS.setVisibility(8);
        }
    }

    public void kC(boolean z) {
        if (!this.fpW && z && !"".equals(this.fsR.getText().toString())) {
            this.fsR.setVisibility(0);
        } else {
            this.fsR.setVisibility(8);
        }
    }

    public void kD(boolean z) {
        this.ftd = z;
    }

    public void kE(boolean z) {
        if (!this.ftd || TbadkCoreApplication.isLogin() || z) {
            if (z) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("call_fan_guide", false)) {
                    kE(false);
                    return;
                }
            } else if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_share", false)) {
                return;
            }
            this.ftf = z;
            View inflate = LayoutInflater.from(this.fgJ.getPageContext().getContext()).inflate(d.i.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(d.g.arrow_up);
            TextView textView = (TextView) inflate.findViewById(d.g.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            if (!z) {
                layoutParams.gravity = 5;
                if (!TbadkCoreApplication.isLogin()) {
                    layoutParams.rightMargin = l.e(this.fgJ, d.e.ds28);
                } else {
                    layoutParams.rightMargin = l.e(this.fgJ, d.e.ds128);
                }
                textView.setText(d.k.share_tip);
                textView.setOnClickListener(this.ftm);
                this.fte = new PopupWindow(inflate, -2, -2);
                e.fw().removeCallbacks(this.ftk);
                e.fw().postDelayed(this.ftk, 500L);
            }
        }
    }

    public void bbm() {
        if (this.ftk != null) {
            e.fw().removeCallbacks(this.ftk);
        }
        if (this.ftl != null) {
            e.fw().removeCallbacks(this.ftl);
        }
        bbn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbn() {
        g.a(this.fte);
    }

    public void g(int i, int i2, boolean z) {
        if (i2 != 0 && bbf() != null && this.fsW != null) {
            if (!z) {
                if (this.fsW.getAlpha() != 1.0f) {
                    this.fsW.setAlpha(1.0f);
                }
                if (this.fsX.getAlpha() != 1.0f) {
                    this.fsX.setAlpha(1.0f);
                    return;
                }
                return;
            }
            int measuredHeight = (bbf().getMeasuredHeight() + i2) - 1;
            if (i >= measuredHeight) {
                if (this.fsW.getAlpha() != 0.0f) {
                    this.fsW.setAlpha(0.0f);
                }
                if (this.fsX.getAlpha() != 0.0f) {
                    this.fsX.setAlpha(0.0f);
                }
            } else if (i > bbf().getMeasuredHeight() && i < measuredHeight) {
                float measuredHeight2 = ((i - bbf().getMeasuredHeight()) * 1.0f) / (measuredHeight - bbf().getMeasuredHeight());
                this.fsW.setAlpha(1.0f - measuredHeight2);
                this.fsX.setAlpha(1.0f - measuredHeight2);
            } else if (i <= bbf().getMeasuredHeight()) {
                if (this.fsW.getAlpha() != 1.0f) {
                    this.fsW.setAlpha(1.0f);
                }
                if (this.fsX.getAlpha() != 1.0f) {
                    this.fsX.setAlpha(1.0f);
                }
            }
        }
    }
}
