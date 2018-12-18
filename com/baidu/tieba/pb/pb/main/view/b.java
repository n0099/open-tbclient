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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.aa;
import com.baidu.tieba.pb.pb.main.ab;
/* loaded from: classes6.dex */
public class b {
    private int DS4;
    private ImageView amQ;
    private ImageView amR;
    private Runnable bdm;
    public final View bhS;
    private int cvk;
    private PbActivity fUU;
    public TextView ggU;
    public View ggV;
    public View ggW;
    private final ImageView ggX;
    private final LinearLayout ggY;
    public FrameLayout ggZ;
    public PbNavbarUserConcernView gha;
    public HeadPendantView ghb;
    public View ghc;
    private ImageView ghf;
    private PopupWindow ghh;
    private boolean ghi;
    private int ghj;
    private int ghk;
    public final NavigationBar mNavigationBar;
    private boolean gdS = false;
    private com.baidu.tieba.pb.view.b ghd = null;
    private aa ghe = null;
    private boolean ghg = false;
    private boolean ghl = false;
    private Runnable eeg = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.5
        @Override // java.lang.Runnable
        public void run() {
            View view;
            if (!b.this.gdS) {
                view = b.this.ghi ? b.this.ggV : b.this.ggW;
            } else {
                view = b.this.ggW;
            }
            if (view != null) {
                if (TbadkCoreApplication.isLogin() || !b.this.ghi) {
                    g.showPopupWindowAsDropDown(b.this.ghh, view);
                    if (!b.this.ghi) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_share", true);
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("call_fan_guide", true);
                    }
                    e.jG().removeCallbacks(b.this.eeh);
                    e.jG().postDelayed(b.this.eeh, 5000L);
                }
            }
        }
    };
    private Runnable eeh = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.6
        @Override // java.lang.Runnable
        public void run() {
            b.this.aHA();
        }
    };
    private View.OnClickListener eei = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.bmm();
        }
    };

    public b(PbActivity pbActivity) {
        this.cvk = 0;
        this.ghj = 0;
        this.ghk = 0;
        this.DS4 = 0;
        this.fUU = pbActivity;
        this.cvk = l.h(pbActivity, e.C0210e.ds88);
        this.ghj = l.h(this.fUU.getPageContext().getPageActivity(), e.C0210e.ds22);
        this.ghk = l.h(this.fUU.getPageContext().getPageActivity(), e.C0210e.ds14);
        this.DS4 = l.h(this.fUU.getPageContext().getPageActivity(), e.C0210e.ds4);
        this.mNavigationBar = (NavigationBar) this.fUU.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.fUU.aAY();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.bhS = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.dJU);
        this.ggU = this.mNavigationBar.setCenterTextTitle("");
        this.ggX = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.ggY = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int h = l.h(this.fUU.getPageContext().getPageActivity(), e.C0210e.ds20);
        this.ggY.setPadding(h, 0, h, 0);
        al.a(this.ggX, e.f.icon_pb_play_small, e.f.icon_pb_play_small);
        this.ggX.setVisibility(8);
        this.ggU.setOnClickListener(pbActivity.dJU);
        this.ggX.setOnClickListener(pbActivity.dJU);
        this.ghf = (ImageView) this.bhS.findViewById(e.g.widget_navi_back_button);
    }

    public void lD(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.gdS = z;
        if (this.ggW == null && this.amR == null) {
            this.ggW = this.mNavigationBar.addCustomView(controlAlign, e.h.nb_item_floor_share, this.fUU.dJU);
            this.amR = (ImageView) this.ggW.findViewById(e.g.navigationBarBtnShare);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.cvk, this.cvk);
            layoutParams.rightMargin = this.DS4;
            this.ggW.setLayoutParams(layoutParams);
            bme();
        }
        if (this.ggV == null && this.amQ == null) {
            this.ggV = this.mNavigationBar.addCustomView(controlAlign, e.h.nb_item_floor_more, this.fUU.dJU);
            this.amQ = (ImageView) this.ggV.findViewById(e.g.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.cvk, this.cvk);
            layoutParams2.rightMargin = this.ghk;
            this.ggV.setLayoutParams(layoutParams2);
            al.a(this.amQ, e.f.icon_nav_more_selector, e.f.icon_nav_more_selector);
            this.ggV.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
        if (z) {
            if (this.ggZ == null) {
                this.ggZ = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.nav_user_concern_layout, (View.OnClickListener) null);
                this.gha = (PbNavbarUserConcernView) this.ggZ.findViewById(e.g.view_add_concern);
                this.ghc = this.ggZ.findViewById(e.g.bg_user_photo);
                this.ghb = (HeadPendantView) this.ggZ.findViewById(e.g.view_host_pendant_photo);
                this.ghb.setHasPendantStyle();
                if (this.ghb.getHeadView() != null) {
                    this.ghb.getHeadView().setIsRound(true);
                    this.ghb.getHeadView().setDefaultBgResource(e.d.transparent);
                    this.ghb.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.setMargins(this.ghj, 0, 0, 0);
                this.ggZ.setLayoutParams(layoutParams3);
                this.gha.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                al.i(this.ghc, e.f.shape_photo_nav_bar_bg);
            }
        } else if (this.ggZ != null) {
            this.mNavigationBar.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_LEFT).removeView(this.ggZ);
        }
    }

    public void lj(boolean z) {
        if (this.ggV != null) {
            this.ggV.setVisibility(z ? 0 : 8);
        }
    }

    public void lE(boolean z) {
        this.ghl = z;
        bme();
    }

    private void bme() {
        if (this.amR != null && this.ggW != null) {
            if (this.ghl) {
                if (this.ghg) {
                    al.a(this.amR, e.f.icon_topbar_share_white_d, e.f.icon_topbar_share_white_d);
                } else {
                    ap.DQ().c(this.amR, e.f.icon_topbar_share_n_svg, e.d.cp_cont_e);
                }
                this.ggW.setClickable(false);
                return;
            }
            if (this.ghg) {
                al.a(this.amR, e.f.pb_ala_share, e.f.pb_ala_share);
            } else {
                ap.DQ().c(this.amR, e.f.icon_topbar_share_n_svg, e.d.select_topbar_icon_color_tint);
            }
            this.ggW.setClickable(true);
        }
    }

    public void lF(boolean z) {
        if (this.ggW != null && !z) {
            this.ggW.setVisibility(8);
        }
    }

    public NavigationBar bmf() {
        return this.mNavigationBar;
    }

    public void lG(boolean z) {
        if (z) {
            this.bhS.setVisibility(0);
        } else {
            this.bhS.setVisibility(8);
        }
        lI(z);
    }

    public void qU(String str) {
        if (!TextUtils.isEmpty(str) && !this.gdS) {
            this.ggU.setText(this.fUU.getResources().getString(e.j.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            lI(true);
            i.xE().ea(str);
            return;
        }
        lI(false);
    }

    public void a(MetaData metaData, View.OnClickListener onClickListener) {
        if (metaData != null) {
            this.ghb.getHeadView().setImageDrawable(null);
            this.ghb.getPendantView().setImageDrawable(null);
            this.ghb.b(metaData);
            this.ghb.getHeadView().startLoad(metaData.getPortrait(), 28, false);
            this.ghb.getHeadView().setUserId(metaData.getUserId());
            this.ghb.getHeadView().setUserName(metaData.getUserName());
            this.ghb.getHeadView().setOnClickListener(onClickListener);
        }
    }

    public void a(ab abVar) {
        if (!this.fUU.isProgressBarShown()) {
            if (this.ghd == null) {
                this.ghe = new aa((PbActivity) this.fUU.getPageContext().getOrignalPage(), this.fUU.dJU);
                this.ghd = new com.baidu.tieba.pb.view.b(this.fUU.getPageContext().getPageActivity(), this.ghe.getView(), al.getDrawable(e.f.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.pb.pb.main.view.b.2
                    @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                    public void xd() {
                        b.this.fUU.bhP();
                    }

                    @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                    public void xe() {
                    }
                });
            }
            this.ghe.bkj();
            if (this.ghg) {
                final Rect rect = new Rect();
                if (this.fUU.fTn) {
                    com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.3
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.fUU.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                            int height = b.this.fUU.getWindow().getDecorView().getHeight();
                            b.this.ghd.setClippingEnabled(false);
                            b.this.ghd.showAtLocation(b.this.fUU.findViewById(e.g.pb_layout), 81, 0, height - rect.bottom);
                        }
                    }, 500L);
                } else {
                    this.fUU.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    int height = this.fUU.getWindow().getDecorView().getHeight();
                    this.ghd.setClippingEnabled(false);
                    this.ghd.showAtLocation(this.fUU.findViewById(e.g.pb_layout), 81, 0, height - rect.bottom);
                }
            } else {
                this.ghd.showAtLocation(this.fUU.findViewById(e.g.pb_layout), 17, 0, 0);
            }
            this.ghe.kZ(abVar == null ? false : abVar.fZY);
            this.ghe.lb(abVar == null ? false : abVar.gad);
            this.ghe.lc(abVar == null ? false : abVar.gae);
            this.ghe.ld(abVar == null ? false : abVar.gaf);
            this.ghe.le(abVar == null ? true : abVar.gam);
            if (abVar == null) {
                this.ghe.O(false, false);
                this.ghe.P(false, false);
                this.ghe.q(false, "");
            } else {
                this.ghe.O(abVar.gab, abVar.gaj);
                this.ghe.P(abVar.gac, abVar.gai);
                this.ghe.q(StringUtils.isNull(abVar.gal) ? false : true, abVar.gal);
            }
            boolean z = abVar == null ? false : abVar.qZ;
            boolean z2 = abVar == null ? false : abVar.fQS;
            boolean z3 = abVar == null ? false : abVar.isHostOnly;
            boolean z4 = abVar == null ? false : abVar.gak;
            boolean z5 = abVar == null ? false : abVar.gaa;
            boolean z6 = abVar == null ? false : abVar.gag;
            boolean z7 = abVar == null ? false : abVar.gah;
            this.ghe.la(abVar == null ? false : abVar.fZZ);
            this.ghe.N(z4, z3);
            this.ghe.Q(z5, z);
            this.ghe.R(z7, z6);
            if (abVar != null) {
                this.ghe.fZU = abVar.gan;
                if (abVar.gan) {
                    this.ghe.bkc().setText(e.j.report_text);
                    this.ghe.ld(false);
                }
            }
            h(z, z2, z3);
        }
    }

    public void bmg() {
        this.ghe.bki().setText(this.fUU.getResources().getString(e.j.haved_fans_call));
    }

    private void h(boolean z, boolean z2, boolean z3) {
        if (this.ghe != null) {
            this.ghe.setBackGround();
            if (z) {
                this.ghe.bjP().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_recommend_reversed_down_selector), (Drawable) null, (Drawable) null);
            } else {
                this.ghe.bjP().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
            }
            if (z2) {
                this.ghe.bjP().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.ghe.bjP().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
            if (z3) {
                this.ghe.bka().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_host_only_selector), (Drawable) null, (Drawable) null);
            } else {
                this.ghe.bka().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void dismissPopMenu() {
        if (this.ghe != null) {
            this.ghe.bkk();
        }
        if (this.bdm == null) {
            this.bdm = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.4
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.ghd != null) {
                        g.a(b.this.ghd, b.this.fUU.getPageContext().getPageActivity());
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.jG().postDelayed(this.bdm, 100L);
    }

    public void bmh() {
        if (this.ghe != null) {
            this.ghe.bkk();
        }
        if (this.ghd != null) {
            g.a(this.ghd, this.fUU.getPageContext().getPageActivity());
        }
    }

    public aa bmi() {
        return this.ghe;
    }

    public View bmj() {
        return this.ggX;
    }

    public boolean aqk() {
        return this.ghd != null && this.ghd.isShowing();
    }

    public void aXt() {
        if (this.ghe != null) {
            this.ghe.release();
        }
        this.ghd = null;
        this.ghe = null;
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bdm);
    }

    public void bmk() {
        if (this.ggV != null) {
            this.ggV.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.fUU.getPageContext(), i);
            al.i(this.mNavigationBar.getBarBgView(), e.d.cp_bg_line_d);
        }
        ap.DQ().c(this.ghf, e.f.icon_topbar_return_n_svg, e.d.select_topbar_icon_color_tint);
        ap.DQ().c(this.amQ, e.f.icon_topbar_more_n_svg, e.d.select_topbar_icon_color_tint);
        bme();
        if (this.gha != null) {
            this.gha.onChangeSkinType(i);
        }
        if (this.ghc != null) {
            al.i(this.ghc, e.f.shape_photo_nav_bar_bg);
        }
        al.b(this.ggU, e.d.cp_cont_b, e.d.s_navbar_title_color);
    }

    public void sF(int i) {
        this.mNavigationBar.onChangeSkinType(this.fUU.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(e.f.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.fUU.getResources().getColor(e.d.black_alpha85));
        if (this.amR != null) {
            this.amR.setImageResource(e.f.pb_ala_share);
        }
        if (this.amQ != null) {
            this.amQ.setImageResource(e.f.icon_vnav_more_bg);
        }
        this.ggU.setTextColor(this.fUU.getResources().getColor(e.d.cp_cont_g));
        this.ghf.setImageResource(e.f.icon_return_bg);
    }

    public void bml() {
        this.ghf.setVisibility(0);
        lI(false);
        if (this.ggV != null) {
            this.ggV.setVisibility(8);
        }
        if (this.ggW != null) {
            this.ggW.setVisibility(8);
        }
    }

    public void lH(boolean z) {
        this.ghf.setVisibility(0);
        lI(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.ggW != null) {
                this.ggW.setVisibility(0);
            }
            if (this.ggV != null) {
                this.ggV.setVisibility(0);
                return;
            }
            return;
        }
        if (this.ggW != null) {
            this.ggW.setVisibility(8);
        }
        if (this.ggV != null) {
            this.ggV.setVisibility(8);
        }
    }

    public void lI(boolean z) {
        if (!this.gdS && z && !"".equals(this.ggU.getText().toString())) {
            this.ggU.setVisibility(0);
        } else {
            this.ggU.setVisibility(8);
        }
    }

    public void lJ(boolean z) {
        this.ghg = z;
    }

    public void lK(boolean z) {
        if (!this.ghg || TbadkCoreApplication.isLogin() || z) {
            if (z) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("call_fan_guide", false)) {
                    lK(false);
                    return;
                }
            } else if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_share", false)) {
                return;
            }
            this.ghi = z;
            View inflate = LayoutInflater.from(this.fUU.getPageContext().getContext()).inflate(e.h.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(e.g.arrow_up);
            TextView textView = (TextView) inflate.findViewById(e.g.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            if (!z) {
                layoutParams.gravity = 5;
                if (!TbadkCoreApplication.isLogin()) {
                    layoutParams.rightMargin = l.h(this.fUU, e.C0210e.ds28);
                } else {
                    layoutParams.rightMargin = l.h(this.fUU, e.C0210e.ds128);
                }
                textView.setText(e.j.share_tip);
                textView.setOnClickListener(this.eei);
                this.ghh = new PopupWindow(inflate, -2, -2);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.eeg);
                com.baidu.adp.lib.g.e.jG().postDelayed(this.eeg, 500L);
            }
        }
    }

    public void bmm() {
        if (this.eeg != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.eeg);
        }
        if (this.eeh != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.eeh);
        }
        aHA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHA() {
        g.a(this.ghh);
    }

    public void h(int i, int i2, boolean z) {
        if (i2 != 0 && bmf() != null && this.ggZ != null) {
            if (!z) {
                if (this.ggZ.getAlpha() != 1.0f) {
                    this.ggZ.setAlpha(1.0f);
                }
                if (this.gha.getAlpha() != 1.0f) {
                    this.gha.setAlpha(1.0f);
                    return;
                }
                return;
            }
            int measuredHeight = (bmf().getMeasuredHeight() + i2) - 1;
            if (i >= measuredHeight) {
                if (this.ggZ.getAlpha() != 0.0f) {
                    this.ggZ.setAlpha(0.0f);
                }
                if (this.gha.getAlpha() != 0.0f) {
                    this.gha.setAlpha(0.0f);
                }
            } else if (i > bmf().getMeasuredHeight() && i < measuredHeight) {
                float measuredHeight2 = ((i - bmf().getMeasuredHeight()) * 1.0f) / (measuredHeight - bmf().getMeasuredHeight());
                this.ggZ.setAlpha(1.0f - measuredHeight2);
                this.gha.setAlpha(1.0f - measuredHeight2);
            } else if (i <= bmf().getMeasuredHeight()) {
                if (this.ggZ.getAlpha() != 1.0f) {
                    this.ggZ.setAlpha(1.0f);
                }
                if (this.gha.getAlpha() != 1.0f) {
                    this.gha.setAlpha(1.0f);
                }
            }
        }
    }
}
