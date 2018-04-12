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
    private PbActivity fgM;
    public TextView fsU;
    public View fsV;
    public View fsW;
    private final ImageView fsX;
    private final LinearLayout fsY;
    public FrameLayout fsZ;
    public PbNavbarUserConcernView fta;
    public HeadPendantView ftb;
    public View ftc;
    private ImageView ftf;
    private PopupWindow fth;
    private boolean fti;
    private int ftj;
    private int ftk;
    private int ftl;
    public final NavigationBar mNavigationBar;
    private boolean fpZ = false;
    private c ftd = null;
    private z fte = null;
    private boolean ftg = false;
    private boolean ftm = false;
    private Runnable ftn = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.5
        @Override // java.lang.Runnable
        public void run() {
            View view2;
            if (!b.this.fpZ) {
                view2 = b.this.fti ? b.this.fsV : b.this.fsW;
            } else {
                view2 = b.this.fsW;
            }
            if (view2 != null) {
                if (TbadkCoreApplication.isLogin() || !b.this.fti) {
                    g.showPopupWindowAsDropDown(b.this.fth, view2);
                    if (!b.this.fti) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_share", true);
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("call_fan_guide", true);
                    }
                    e.fw().removeCallbacks(b.this.fto);
                    e.fw().postDelayed(b.this.fto, TbConfig.NOTIFY_SOUND_INTERVAL);
                }
            }
        }
    };
    private Runnable fto = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.6
        @Override // java.lang.Runnable
        public void run() {
            b.this.bbn();
        }
    };
    private View.OnClickListener ftp = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            b.this.bbm();
        }
    };

    public b(PbActivity pbActivity) {
        this.ftj = 0;
        this.ftk = 0;
        this.ftl = 0;
        this.DS4 = 0;
        this.fgM = pbActivity;
        this.ftj = l.e(pbActivity, d.e.ds88);
        this.ftk = l.e(this.fgM.getPageContext().getPageActivity(), d.e.ds22);
        this.ftl = l.e(this.fgM.getPageContext().getPageActivity(), d.e.ds14);
        this.DS4 = l.e(this.fgM.getPageContext().getPageActivity(), d.e.ds4);
        this.mNavigationBar = (NavigationBar) this.fgM.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.fgM.apD();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.aMS = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.cYT);
        this.fsU = this.mNavigationBar.setCenterTextTitle("");
        this.fsX = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.fsY = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int e = l.e(this.fgM.getPageContext().getPageActivity(), d.e.ds20);
        this.fsY.setPadding(e, 0, e, 0);
        ak.a(this.fsX, d.f.icon_pb_play_small, d.f.icon_pb_play_small);
        this.fsX.setVisibility(8);
        this.fsU.setOnClickListener(pbActivity.cYT);
        this.fsX.setOnClickListener(pbActivity.cYT);
        this.ftf = (ImageView) this.aMS.findViewById(d.g.widget_navi_back_button);
    }

    public void kx(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.fpZ = z;
        if (this.fsW == null && this.Tq == null) {
            this.fsW = this.mNavigationBar.addCustomView(controlAlign, d.i.nb_item_floor_share, this.fgM.cYT);
            this.Tq = (ImageView) this.fsW.findViewById(d.g.navigationBarBtnShare);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ftj, this.ftj);
            layoutParams.rightMargin = this.DS4;
            this.fsW.setLayoutParams(layoutParams);
            bbe();
        }
        if (this.fsV == null && this.Tp == null) {
            this.fsV = this.mNavigationBar.addCustomView(controlAlign, d.i.nb_item_floor_more, this.fgM.cYT);
            this.Tp = (ImageView) this.fsV.findViewById(d.g.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.ftj, this.ftj);
            layoutParams2.rightMargin = this.ftl;
            this.fsV.setLayoutParams(layoutParams2);
            ak.a(this.Tp, d.f.icon_nav_more_selector, d.f.icon_nav_more_selector);
            this.fsV.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
        if (z) {
            if (this.fsZ == null) {
                this.fsZ = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.nav_user_concern_layout, (View.OnClickListener) null);
                this.fta = (PbNavbarUserConcernView) this.fsZ.findViewById(d.g.view_add_concern);
                this.ftc = this.fsZ.findViewById(d.g.bg_user_photo);
                this.ftb = (HeadPendantView) this.fsZ.findViewById(d.g.view_host_pendant_photo);
                this.ftb.setHasPendantStyle();
                if (this.ftb.getHeadView() != null) {
                    this.ftb.getHeadView().setIsRound(true);
                    this.ftb.getHeadView().setDefaultBgResource(d.C0126d.transparent);
                    this.ftb.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.setMargins(this.ftk, 0, 0, 0);
                this.fsZ.setLayoutParams(layoutParams3);
                this.fta.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                ak.i(this.ftc, d.f.shape_photo_nav_bar_bg);
            }
        } else if (this.fsZ != null) {
            this.mNavigationBar.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_LEFT).removeView(this.fsZ);
        }
    }

    public void ke(boolean z) {
        if (this.fsV != null) {
            this.fsV.setVisibility(z ? 0 : 8);
        }
    }

    public void ky(boolean z) {
        this.ftm = z;
        bbe();
    }

    private void bbe() {
        if (this.Tq != null && this.fsW != null) {
            if (this.ftm) {
                if (this.ftg) {
                    ak.a(this.Tq, d.f.icon_topbar_share_white_d, d.f.icon_topbar_share_white_d);
                } else {
                    ao.vP().c(this.Tq, d.f.icon_topbar_share_n_svg, d.C0126d.cp_cont_e);
                }
                this.fsW.setClickable(false);
                return;
            }
            if (this.ftg) {
                ak.a(this.Tq, d.f.pb_ala_share, d.f.pb_ala_share);
            } else {
                ao.vP().c(this.Tq, d.f.icon_topbar_share_n_svg, d.f.select_topbar_icon_color_tint);
            }
            this.fsW.setClickable(true);
        }
    }

    public void kz(boolean z) {
        if (this.fsW != null && !z) {
            this.fsW.setVisibility(8);
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
        if (!TextUtils.isEmpty(str) && !this.fpZ) {
            this.fsU.setText(this.fgM.getResources().getString(d.k.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            kC(true);
            i.pY().cC(str);
            return;
        }
        kC(false);
    }

    public void a(MetaData metaData, View.OnClickListener onClickListener) {
        if (metaData != null) {
            UtilHelper.showHeadImageViewBigV(this.ftb.getHeadView(), metaData);
            this.ftb.getHeadView().setImageDrawable(null);
            this.ftb.getPendantView().setImageDrawable(null);
            this.ftb.getHeadView().startLoad(metaData.getPortrait(), 28, false);
            this.ftb.getHeadView().setUserId(metaData.getUserId());
            this.ftb.getHeadView().setUserName(metaData.getUserName());
            this.ftb.getHeadView().setOnClickListener(onClickListener);
            if (metaData.getPendantData() != null && !StringUtils.isNull(metaData.getPendantData().qG())) {
                this.ftb.eK(metaData.getPendantData().qG());
            } else {
                this.ftb.eK(null);
            }
        }
    }

    public void a(aa aaVar) {
        if (!this.fgM.isProgressBarShown()) {
            if (this.ftd == null) {
                this.fte = new z((PbActivity) this.fgM.getPageContext().getOrignalPage(), this.fgM.cYT);
                this.ftd = new c(this.fgM.getPageContext().getPageActivity(), this.fte.getView(), ak.getDrawable(d.f.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.pb.pb.main.view.b.2
                    @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                    public void pu() {
                        b.this.fgM.aWX();
                    }

                    @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                    public void pv() {
                    }
                });
            }
            this.fte.aZp();
            if (this.ftg) {
                final Rect rect = new Rect();
                if (this.fgM.ffe) {
                    e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.3
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.fgM.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                            int height = b.this.fgM.getWindow().getDecorView().getHeight();
                            b.this.ftd.setClippingEnabled(false);
                            b.this.ftd.showAtLocation(b.this.fgM.findViewById(d.g.pb_layout), 81, 0, height - rect.bottom);
                        }
                    }, 500L);
                } else {
                    this.fgM.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    int height = this.fgM.getWindow().getDecorView().getHeight();
                    this.ftd.setClippingEnabled(false);
                    this.ftd.showAtLocation(this.fgM.findViewById(d.g.pb_layout), 81, 0, height - rect.bottom);
                }
            } else {
                this.ftd.showAtLocation(this.fgM.findViewById(d.g.pb_layout), 17, 0, 0);
            }
            this.fte.jT(aaVar == null ? false : aaVar.flR);
            this.fte.jV(aaVar == null ? false : aaVar.flX);
            this.fte.jW(aaVar == null ? false : aaVar.flY);
            this.fte.jX(aaVar == null ? false : aaVar.flZ);
            this.fte.jY(aaVar == null ? true : aaVar.fmg);
            if (aaVar == null) {
                this.fte.G(false, false);
                this.fte.H(false, false);
                this.fte.m(false, "");
            } else {
                this.fte.G(aaVar.flV, aaVar.fmd);
                this.fte.H(aaVar.flW, aaVar.fmc);
                this.fte.m(StringUtils.isNull(aaVar.fmf) ? false : true, aaVar.fmf);
            }
            boolean z = aaVar == null ? false : aaVar.flT;
            boolean z2 = aaVar == null ? false : aaVar.fcV;
            boolean z3 = aaVar == null ? false : aaVar.isHostOnly;
            boolean z4 = aaVar == null ? false : aaVar.fme;
            boolean z5 = aaVar == null ? false : aaVar.flU;
            boolean z6 = aaVar == null ? false : aaVar.fma;
            boolean z7 = aaVar == null ? false : aaVar.fmb;
            this.fte.jU(aaVar == null ? false : aaVar.flS);
            this.fte.F(z4, z3);
            this.fte.I(z5, z);
            this.fte.J(z7, z6);
            if (aaVar != null) {
                this.fte.flN = aaVar.fmh;
                if (aaVar.fmh) {
                    this.fte.aZi().setText(d.k.report_text);
                    this.fte.jX(false);
                }
            }
            i(z, z2, z3);
        }
    }

    public void bbg() {
        this.fte.aZo().setText(this.fgM.getResources().getString(d.k.haved_fans_call));
    }

    private void i(boolean z, boolean z2, boolean z3) {
        if (this.fte != null) {
            this.fte.setBackGround();
            if (z) {
                this.fte.aYV().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ak.getDrawable(d.f.icon_recommend_reversed_down_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fte.aYV().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ak.getDrawable(d.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
            }
            if (z2) {
                this.fte.aYV().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ak.getDrawable(d.f.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fte.aYV().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ak.getDrawable(d.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
            if (z3) {
                this.fte.aZg().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ak.getDrawable(d.f.icon_host_only_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fte.aZg().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ak.getDrawable(d.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void pr() {
        if (this.fte != null) {
            this.fte.aZq();
        }
        if (this.aHT == null) {
            this.aHT = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.4
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.ftd != null) {
                        g.a(b.this.ftd, b.this.fgM.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.fw().postDelayed(this.aHT, 100L);
    }

    public void bbh() {
        if (this.fte != null) {
            this.fte.aZq();
        }
        if (this.ftd != null) {
            g.a(this.ftd, this.fgM.getPageContext().getPageActivity());
        }
    }

    public z bbi() {
        return this.fte;
    }

    public View bbj() {
        return this.fsX;
    }

    public boolean agf() {
        return this.ftd != null && this.ftd.isShowing();
    }

    public void aKe() {
        if (this.fte != null) {
            this.fte.release();
        }
        this.ftd = null;
        this.fte = null;
        e.fw().removeCallbacks(this.aHT);
    }

    public void bbk() {
        if (this.fsV != null) {
            this.fsV.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.fgM.getPageContext(), i);
            ak.i(this.mNavigationBar.getBarBgView(), d.C0126d.cp_bg_line_d);
        }
        ao.vP().c(this.ftf, d.f.icon_topbar_return_n_svg, d.f.select_topbar_icon_color_tint);
        ao.vP().c(this.Tp, d.f.icon_topbar_more_n_svg, d.f.select_topbar_icon_color_tint);
        bbe();
        if (this.fta != null) {
            this.fta.onChangeSkinType(i);
        }
        if (this.ftc != null) {
            ak.i(this.ftc, d.f.shape_photo_nav_bar_bg);
        }
        ak.b(this.fsU, d.C0126d.cp_cont_b, d.C0126d.s_navbar_title_color);
    }

    public void qG(int i) {
        this.mNavigationBar.onChangeSkinType(this.fgM.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(d.f.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.fgM.getResources().getColor(d.C0126d.black_alpha85));
        if (this.Tq != null) {
            this.Tq.setImageResource(d.f.pb_ala_share);
        }
        if (this.Tp != null) {
            this.Tp.setImageResource(d.f.icon_vnav_more_bg);
        }
        this.fsU.setTextColor(this.fgM.getResources().getColor(d.C0126d.cp_cont_g));
        this.ftf.setImageResource(d.f.icon_return_bg);
    }

    public void bbl() {
        this.ftf.setVisibility(0);
        kC(false);
        if (this.fsV != null) {
            this.fsV.setVisibility(8);
        }
        if (this.fsW != null) {
            this.fsW.setVisibility(8);
        }
    }

    public void kB(boolean z) {
        this.ftf.setVisibility(0);
        kC(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.fsW != null) {
                this.fsW.setVisibility(0);
            }
            if (this.fsV != null) {
                this.fsV.setVisibility(0);
                return;
            }
            return;
        }
        if (this.fsW != null) {
            this.fsW.setVisibility(8);
        }
        if (this.fsV != null) {
            this.fsV.setVisibility(8);
        }
    }

    public void kC(boolean z) {
        if (!this.fpZ && z && !"".equals(this.fsU.getText().toString())) {
            this.fsU.setVisibility(0);
        } else {
            this.fsU.setVisibility(8);
        }
    }

    public void kD(boolean z) {
        this.ftg = z;
    }

    public void kE(boolean z) {
        if (!this.ftg || TbadkCoreApplication.isLogin() || z) {
            if (z) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("call_fan_guide", false)) {
                    kE(false);
                    return;
                }
            } else if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_share", false)) {
                return;
            }
            this.fti = z;
            View inflate = LayoutInflater.from(this.fgM.getPageContext().getContext()).inflate(d.i.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(d.g.arrow_up);
            TextView textView = (TextView) inflate.findViewById(d.g.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            if (!z) {
                layoutParams.gravity = 5;
                if (!TbadkCoreApplication.isLogin()) {
                    layoutParams.rightMargin = l.e(this.fgM, d.e.ds28);
                } else {
                    layoutParams.rightMargin = l.e(this.fgM, d.e.ds128);
                }
                textView.setText(d.k.share_tip);
                textView.setOnClickListener(this.ftp);
                this.fth = new PopupWindow(inflate, -2, -2);
                e.fw().removeCallbacks(this.ftn);
                e.fw().postDelayed(this.ftn, 500L);
            }
        }
    }

    public void bbm() {
        if (this.ftn != null) {
            e.fw().removeCallbacks(this.ftn);
        }
        if (this.fto != null) {
            e.fw().removeCallbacks(this.fto);
        }
        bbn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbn() {
        g.a(this.fth);
    }

    public void g(int i, int i2, boolean z) {
        if (i2 != 0 && bbf() != null && this.fsZ != null) {
            if (!z) {
                if (this.fsZ.getAlpha() != 1.0f) {
                    this.fsZ.setAlpha(1.0f);
                }
                if (this.fta.getAlpha() != 1.0f) {
                    this.fta.setAlpha(1.0f);
                    return;
                }
                return;
            }
            int measuredHeight = (bbf().getMeasuredHeight() + i2) - 1;
            if (i >= measuredHeight) {
                if (this.fsZ.getAlpha() != 0.0f) {
                    this.fsZ.setAlpha(0.0f);
                }
                if (this.fta.getAlpha() != 0.0f) {
                    this.fta.setAlpha(0.0f);
                }
            } else if (i > bbf().getMeasuredHeight() && i < measuredHeight) {
                float measuredHeight2 = ((i - bbf().getMeasuredHeight()) * 1.0f) / (measuredHeight - bbf().getMeasuredHeight());
                this.fsZ.setAlpha(1.0f - measuredHeight2);
                this.fta.setAlpha(1.0f - measuredHeight2);
            } else if (i <= bbf().getMeasuredHeight()) {
                if (this.fsZ.getAlpha() != 1.0f) {
                    this.fsZ.setAlpha(1.0f);
                }
                if (this.fta.getAlpha() != 1.0f) {
                    this.fta.setAlpha(1.0f);
                }
            }
        }
    }
}
