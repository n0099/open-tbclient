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
    private Runnable aZb;
    private ImageView aiB;
    private ImageView aiC;
    public final View bdE;
    private int cro;
    private PbActivity fMF;
    public TextView fYE;
    public View fYF;
    public View fYG;
    private final ImageView fYH;
    private final LinearLayout fYI;
    public FrameLayout fYJ;
    public PbNavbarUserConcernView fYK;
    public HeadPendantView fYL;
    public View fYM;
    private ImageView fYP;
    private PopupWindow fYR;
    private boolean fYS;
    private int fYT;
    private int fYU;
    public final NavigationBar mNavigationBar;
    private boolean fVD = false;
    private com.baidu.tieba.pb.view.b fYN = null;
    private aa fYO = null;
    private boolean fYQ = false;
    private boolean fYV = false;
    private Runnable fYW = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.5
        @Override // java.lang.Runnable
        public void run() {
            View view;
            if (!b.this.fVD) {
                view = b.this.fYS ? b.this.fYF : b.this.fYG;
            } else {
                view = b.this.fYG;
            }
            if (view != null) {
                if (TbadkCoreApplication.isLogin() || !b.this.fYS) {
                    g.showPopupWindowAsDropDown(b.this.fYR, view);
                    if (!b.this.fYS) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_share", true);
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("call_fan_guide", true);
                    }
                    e.jI().removeCallbacks(b.this.fYX);
                    e.jI().postDelayed(b.this.fYX, 5000L);
                }
            }
        }
    };
    private Runnable fYX = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.6
        @Override // java.lang.Runnable
        public void run() {
            b.this.bkY();
        }
    };
    private View.OnClickListener fYY = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.bkX();
        }
    };

    public b(PbActivity pbActivity) {
        this.cro = 0;
        this.fYT = 0;
        this.fYU = 0;
        this.DS4 = 0;
        this.fMF = pbActivity;
        this.cro = l.h(pbActivity, e.C0175e.ds88);
        this.fYT = l.h(this.fMF.getPageContext().getPageActivity(), e.C0175e.ds22);
        this.fYU = l.h(this.fMF.getPageContext().getPageActivity(), e.C0175e.ds14);
        this.DS4 = l.h(this.fMF.getPageContext().getPageActivity(), e.C0175e.ds4);
        this.mNavigationBar = (NavigationBar) this.fMF.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.fMF.azR();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.bdE = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.dCe);
        this.fYE = this.mNavigationBar.setCenterTextTitle("");
        this.fYH = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.fYI = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int h = l.h(this.fMF.getPageContext().getPageActivity(), e.C0175e.ds20);
        this.fYI.setPadding(h, 0, h, 0);
        al.a(this.fYH, e.f.icon_pb_play_small, e.f.icon_pb_play_small);
        this.fYH.setVisibility(8);
        this.fYE.setOnClickListener(pbActivity.dCe);
        this.fYH.setOnClickListener(pbActivity.dCe);
        this.fYP = (ImageView) this.bdE.findViewById(e.g.widget_navi_back_button);
    }

    public void lp(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.fVD = z;
        if (this.fYG == null && this.aiC == null) {
            this.fYG = this.mNavigationBar.addCustomView(controlAlign, e.h.nb_item_floor_share, this.fMF.dCe);
            this.aiC = (ImageView) this.fYG.findViewById(e.g.navigationBarBtnShare);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.cro, this.cro);
            layoutParams.rightMargin = this.DS4;
            this.fYG.setLayoutParams(layoutParams);
            bkP();
        }
        if (this.fYF == null && this.aiB == null) {
            this.fYF = this.mNavigationBar.addCustomView(controlAlign, e.h.nb_item_floor_more, this.fMF.dCe);
            this.aiB = (ImageView) this.fYF.findViewById(e.g.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.cro, this.cro);
            layoutParams2.rightMargin = this.fYU;
            this.fYF.setLayoutParams(layoutParams2);
            al.a(this.aiB, e.f.icon_nav_more_selector, e.f.icon_nav_more_selector);
            this.fYF.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
        if (z) {
            if (this.fYJ == null) {
                this.fYJ = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.nav_user_concern_layout, (View.OnClickListener) null);
                this.fYK = (PbNavbarUserConcernView) this.fYJ.findViewById(e.g.view_add_concern);
                this.fYM = this.fYJ.findViewById(e.g.bg_user_photo);
                this.fYL = (HeadPendantView) this.fYJ.findViewById(e.g.view_host_pendant_photo);
                this.fYL.setHasPendantStyle();
                if (this.fYL.getHeadView() != null) {
                    this.fYL.getHeadView().setIsRound(true);
                    this.fYL.getHeadView().setDefaultBgResource(e.d.transparent);
                    this.fYL.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.setMargins(this.fYT, 0, 0, 0);
                this.fYJ.setLayoutParams(layoutParams3);
                this.fYK.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                al.i(this.fYM, e.f.shape_photo_nav_bar_bg);
            }
        } else if (this.fYJ != null) {
            this.mNavigationBar.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_LEFT).removeView(this.fYJ);
        }
    }

    public void kV(boolean z) {
        if (this.fYF != null) {
            this.fYF.setVisibility(z ? 0 : 8);
        }
    }

    public void lq(boolean z) {
        this.fYV = z;
        bkP();
    }

    private void bkP() {
        if (this.aiC != null && this.fYG != null) {
            if (this.fYV) {
                if (this.fYQ) {
                    al.a(this.aiC, e.f.icon_topbar_share_white_d, e.f.icon_topbar_share_white_d);
                } else {
                    ap.CF().c(this.aiC, e.f.icon_topbar_share_n_svg, e.d.cp_cont_e);
                }
                this.fYG.setClickable(false);
                return;
            }
            if (this.fYQ) {
                al.a(this.aiC, e.f.pb_ala_share, e.f.pb_ala_share);
            } else {
                ap.CF().c(this.aiC, e.f.icon_topbar_share_n_svg, e.d.select_topbar_icon_color_tint);
            }
            this.fYG.setClickable(true);
        }
    }

    public void lr(boolean z) {
        if (this.fYG != null && !z) {
            this.fYG.setVisibility(8);
        }
    }

    public NavigationBar bkQ() {
        return this.mNavigationBar;
    }

    public void ls(boolean z) {
        if (z) {
            this.bdE.setVisibility(0);
        } else {
            this.bdE.setVisibility(8);
        }
        lu(z);
    }

    public void qr(String str) {
        if (!TextUtils.isEmpty(str) && !this.fVD) {
            this.fYE.setText(this.fMF.getResources().getString(e.j.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            lu(true);
            i.ws().dI(str);
            return;
        }
        lu(false);
    }

    public void a(MetaData metaData, View.OnClickListener onClickListener) {
        if (metaData != null) {
            UtilHelper.showHeadImageViewBigV(this.fYL.getHeadView(), metaData);
            this.fYL.getHeadView().setImageDrawable(null);
            this.fYL.getPendantView().setImageDrawable(null);
            this.fYL.getHeadView().startLoad(metaData.getPortrait(), 28, false);
            this.fYL.getHeadView().setUserId(metaData.getUserId());
            this.fYL.getHeadView().setUserName(metaData.getUserName());
            this.fYL.getHeadView().setOnClickListener(onClickListener);
            if (metaData.getPendantData() != null && !StringUtils.isNull(metaData.getPendantData().xf())) {
                this.fYL.fT(metaData.getPendantData().xf());
            } else {
                this.fYL.fT(null);
            }
        }
    }

    public void a(ab abVar) {
        if (!this.fMF.isProgressBarShown()) {
            if (this.fYN == null) {
                this.fYO = new aa((PbActivity) this.fMF.getPageContext().getOrignalPage(), this.fMF.dCe);
                this.fYN = new com.baidu.tieba.pb.view.b(this.fMF.getPageContext().getPageActivity(), this.fYO.getView(), al.getDrawable(e.f.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.pb.pb.main.view.b.2
                    @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                    public void vR() {
                        b.this.fMF.bgC();
                    }

                    @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                    public void vS() {
                    }
                });
            }
            this.fYO.biV();
            if (this.fYQ) {
                final Rect rect = new Rect();
                if (this.fMF.fKY) {
                    com.baidu.adp.lib.g.e.jI().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.3
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.fMF.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                            int height = b.this.fMF.getWindow().getDecorView().getHeight();
                            b.this.fYN.setClippingEnabled(false);
                            b.this.fYN.showAtLocation(b.this.fMF.findViewById(e.g.pb_layout), 81, 0, height - rect.bottom);
                        }
                    }, 500L);
                } else {
                    this.fMF.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    int height = this.fMF.getWindow().getDecorView().getHeight();
                    this.fYN.setClippingEnabled(false);
                    this.fYN.showAtLocation(this.fMF.findViewById(e.g.pb_layout), 81, 0, height - rect.bottom);
                }
            } else {
                this.fYN.showAtLocation(this.fMF.findViewById(e.g.pb_layout), 17, 0, 0);
            }
            this.fYO.kL(abVar == null ? false : abVar.fRJ);
            this.fYO.kN(abVar == null ? false : abVar.fRO);
            this.fYO.kO(abVar == null ? false : abVar.fRP);
            this.fYO.kP(abVar == null ? false : abVar.fRQ);
            this.fYO.kQ(abVar == null ? true : abVar.fRX);
            if (abVar == null) {
                this.fYO.M(false, false);
                this.fYO.N(false, false);
                this.fYO.r(false, "");
            } else {
                this.fYO.M(abVar.fRM, abVar.fRU);
                this.fYO.N(abVar.fRN, abVar.fRT);
                this.fYO.r(StringUtils.isNull(abVar.fRW) ? false : true, abVar.fRW);
            }
            boolean z = abVar == null ? false : abVar.qY;
            boolean z2 = abVar == null ? false : abVar.fIE;
            boolean z3 = abVar == null ? false : abVar.isHostOnly;
            boolean z4 = abVar == null ? false : abVar.fRV;
            boolean z5 = abVar == null ? false : abVar.fRL;
            boolean z6 = abVar == null ? false : abVar.fRR;
            boolean z7 = abVar == null ? false : abVar.fRS;
            this.fYO.kM(abVar == null ? false : abVar.fRK);
            this.fYO.L(z4, z3);
            this.fYO.O(z5, z);
            this.fYO.P(z7, z6);
            if (abVar != null) {
                this.fYO.fRF = abVar.fRY;
                if (abVar.fRY) {
                    this.fYO.biO().setText(e.j.report_text);
                    this.fYO.kP(false);
                }
            }
            h(z, z2, z3);
        }
    }

    public void bkR() {
        this.fYO.biU().setText(this.fMF.getResources().getString(e.j.haved_fans_call));
    }

    private void h(boolean z, boolean z2, boolean z3) {
        if (this.fYO != null) {
            this.fYO.setBackGround();
            if (z) {
                this.fYO.biB().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_recommend_reversed_down_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fYO.biB().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
            }
            if (z2) {
                this.fYO.biB().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fYO.biB().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
            if (z3) {
                this.fYO.biM().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_host_only_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fYO.biM().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void vO() {
        if (this.fYO != null) {
            this.fYO.biW();
        }
        if (this.aZb == null) {
            this.aZb = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.4
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.fYN != null) {
                        g.a(b.this.fYN, b.this.fMF.getPageContext().getPageActivity());
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.jI().postDelayed(this.aZb, 100L);
    }

    public void bkS() {
        if (this.fYO != null) {
            this.fYO.biW();
        }
        if (this.fYN != null) {
            g.a(this.fYN, this.fMF.getPageContext().getPageActivity());
        }
    }

    public aa bkT() {
        return this.fYO;
    }

    public View bkU() {
        return this.fYH;
    }

    public boolean aoW() {
        return this.fYN != null && this.fYN.isShowing();
    }

    public void aWf() {
        if (this.fYO != null) {
            this.fYO.release();
        }
        this.fYN = null;
        this.fYO = null;
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.aZb);
    }

    public void bkV() {
        if (this.fYF != null) {
            this.fYF.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.fMF.getPageContext(), i);
            al.i(this.mNavigationBar.getBarBgView(), e.d.cp_bg_line_d);
        }
        ap.CF().c(this.fYP, e.f.icon_topbar_return_n_svg, e.d.select_topbar_icon_color_tint);
        ap.CF().c(this.aiB, e.f.icon_topbar_more_n_svg, e.d.select_topbar_icon_color_tint);
        bkP();
        if (this.fYK != null) {
            this.fYK.onChangeSkinType(i);
        }
        if (this.fYM != null) {
            al.i(this.fYM, e.f.shape_photo_nav_bar_bg);
        }
        al.b(this.fYE, e.d.cp_cont_b, e.d.s_navbar_title_color);
    }

    public void rS(int i) {
        this.mNavigationBar.onChangeSkinType(this.fMF.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(e.f.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.fMF.getResources().getColor(e.d.black_alpha85));
        if (this.aiC != null) {
            this.aiC.setImageResource(e.f.pb_ala_share);
        }
        if (this.aiB != null) {
            this.aiB.setImageResource(e.f.icon_vnav_more_bg);
        }
        this.fYE.setTextColor(this.fMF.getResources().getColor(e.d.cp_cont_g));
        this.fYP.setImageResource(e.f.icon_return_bg);
    }

    public void bkW() {
        this.fYP.setVisibility(0);
        lu(false);
        if (this.fYF != null) {
            this.fYF.setVisibility(8);
        }
        if (this.fYG != null) {
            this.fYG.setVisibility(8);
        }
    }

    public void lt(boolean z) {
        this.fYP.setVisibility(0);
        lu(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.fYG != null) {
                this.fYG.setVisibility(0);
            }
            if (this.fYF != null) {
                this.fYF.setVisibility(0);
                return;
            }
            return;
        }
        if (this.fYG != null) {
            this.fYG.setVisibility(8);
        }
        if (this.fYF != null) {
            this.fYF.setVisibility(8);
        }
    }

    public void lu(boolean z) {
        if (!this.fVD && z && !"".equals(this.fYE.getText().toString())) {
            this.fYE.setVisibility(0);
        } else {
            this.fYE.setVisibility(8);
        }
    }

    public void lv(boolean z) {
        this.fYQ = z;
    }

    public void lw(boolean z) {
        if (!this.fYQ || TbadkCoreApplication.isLogin() || z) {
            if (z) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("call_fan_guide", false)) {
                    lw(false);
                    return;
                }
            } else if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_share", false)) {
                return;
            }
            this.fYS = z;
            View inflate = LayoutInflater.from(this.fMF.getPageContext().getContext()).inflate(e.h.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(e.g.arrow_up);
            TextView textView = (TextView) inflate.findViewById(e.g.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            if (!z) {
                layoutParams.gravity = 5;
                if (!TbadkCoreApplication.isLogin()) {
                    layoutParams.rightMargin = l.h(this.fMF, e.C0175e.ds28);
                } else {
                    layoutParams.rightMargin = l.h(this.fMF, e.C0175e.ds128);
                }
                textView.setText(e.j.share_tip);
                textView.setOnClickListener(this.fYY);
                this.fYR = new PopupWindow(inflate, -2, -2);
                com.baidu.adp.lib.g.e.jI().removeCallbacks(this.fYW);
                com.baidu.adp.lib.g.e.jI().postDelayed(this.fYW, 500L);
            }
        }
    }

    public void bkX() {
        if (this.fYW != null) {
            com.baidu.adp.lib.g.e.jI().removeCallbacks(this.fYW);
        }
        if (this.fYX != null) {
            com.baidu.adp.lib.g.e.jI().removeCallbacks(this.fYX);
        }
        bkY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkY() {
        g.a(this.fYR);
    }

    public void g(int i, int i2, boolean z) {
        if (i2 != 0 && bkQ() != null && this.fYJ != null) {
            if (!z) {
                if (this.fYJ.getAlpha() != 1.0f) {
                    this.fYJ.setAlpha(1.0f);
                }
                if (this.fYK.getAlpha() != 1.0f) {
                    this.fYK.setAlpha(1.0f);
                    return;
                }
                return;
            }
            int measuredHeight = (bkQ().getMeasuredHeight() + i2) - 1;
            if (i >= measuredHeight) {
                if (this.fYJ.getAlpha() != 0.0f) {
                    this.fYJ.setAlpha(0.0f);
                }
                if (this.fYK.getAlpha() != 0.0f) {
                    this.fYK.setAlpha(0.0f);
                }
            } else if (i > bkQ().getMeasuredHeight() && i < measuredHeight) {
                float measuredHeight2 = ((i - bkQ().getMeasuredHeight()) * 1.0f) / (measuredHeight - bkQ().getMeasuredHeight());
                this.fYJ.setAlpha(1.0f - measuredHeight2);
                this.fYK.setAlpha(1.0f - measuredHeight2);
            } else if (i <= bkQ().getMeasuredHeight()) {
                if (this.fYJ.getAlpha() != 1.0f) {
                    this.fYJ.setAlpha(1.0f);
                }
                if (this.fYK.getAlpha() != 1.0f) {
                    this.fYK.setAlpha(1.0f);
                }
            }
        }
    }
}
