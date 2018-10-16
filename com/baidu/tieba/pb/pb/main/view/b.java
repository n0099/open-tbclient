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
    private PbActivity fME;
    public TextView fYD;
    public View fYE;
    public View fYF;
    private final ImageView fYG;
    private final LinearLayout fYH;
    public FrameLayout fYI;
    public PbNavbarUserConcernView fYJ;
    public HeadPendantView fYK;
    public View fYL;
    private ImageView fYO;
    private PopupWindow fYQ;
    private boolean fYR;
    private int fYS;
    private int fYT;
    public final NavigationBar mNavigationBar;
    private boolean fVC = false;
    private com.baidu.tieba.pb.view.b fYM = null;
    private aa fYN = null;
    private boolean fYP = false;
    private boolean fYU = false;
    private Runnable fYV = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.5
        @Override // java.lang.Runnable
        public void run() {
            View view;
            if (!b.this.fVC) {
                view = b.this.fYR ? b.this.fYE : b.this.fYF;
            } else {
                view = b.this.fYF;
            }
            if (view != null) {
                if (TbadkCoreApplication.isLogin() || !b.this.fYR) {
                    g.showPopupWindowAsDropDown(b.this.fYQ, view);
                    if (!b.this.fYR) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_share", true);
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("call_fan_guide", true);
                    }
                    e.jI().removeCallbacks(b.this.fYW);
                    e.jI().postDelayed(b.this.fYW, 5000L);
                }
            }
        }
    };
    private Runnable fYW = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.6
        @Override // java.lang.Runnable
        public void run() {
            b.this.bkY();
        }
    };
    private View.OnClickListener fYX = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.bkX();
        }
    };

    public b(PbActivity pbActivity) {
        this.cro = 0;
        this.fYS = 0;
        this.fYT = 0;
        this.DS4 = 0;
        this.fME = pbActivity;
        this.cro = l.h(pbActivity, e.C0175e.ds88);
        this.fYS = l.h(this.fME.getPageContext().getPageActivity(), e.C0175e.ds22);
        this.fYT = l.h(this.fME.getPageContext().getPageActivity(), e.C0175e.ds14);
        this.DS4 = l.h(this.fME.getPageContext().getPageActivity(), e.C0175e.ds4);
        this.mNavigationBar = (NavigationBar) this.fME.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.fME.azQ();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.bdE = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.dCe);
        this.fYD = this.mNavigationBar.setCenterTextTitle("");
        this.fYG = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.fYH = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int h = l.h(this.fME.getPageContext().getPageActivity(), e.C0175e.ds20);
        this.fYH.setPadding(h, 0, h, 0);
        al.a(this.fYG, e.f.icon_pb_play_small, e.f.icon_pb_play_small);
        this.fYG.setVisibility(8);
        this.fYD.setOnClickListener(pbActivity.dCe);
        this.fYG.setOnClickListener(pbActivity.dCe);
        this.fYO = (ImageView) this.bdE.findViewById(e.g.widget_navi_back_button);
    }

    public void lp(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.fVC = z;
        if (this.fYF == null && this.aiC == null) {
            this.fYF = this.mNavigationBar.addCustomView(controlAlign, e.h.nb_item_floor_share, this.fME.dCe);
            this.aiC = (ImageView) this.fYF.findViewById(e.g.navigationBarBtnShare);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.cro, this.cro);
            layoutParams.rightMargin = this.DS4;
            this.fYF.setLayoutParams(layoutParams);
            bkP();
        }
        if (this.fYE == null && this.aiB == null) {
            this.fYE = this.mNavigationBar.addCustomView(controlAlign, e.h.nb_item_floor_more, this.fME.dCe);
            this.aiB = (ImageView) this.fYE.findViewById(e.g.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.cro, this.cro);
            layoutParams2.rightMargin = this.fYT;
            this.fYE.setLayoutParams(layoutParams2);
            al.a(this.aiB, e.f.icon_nav_more_selector, e.f.icon_nav_more_selector);
            this.fYE.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
        if (z) {
            if (this.fYI == null) {
                this.fYI = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.nav_user_concern_layout, (View.OnClickListener) null);
                this.fYJ = (PbNavbarUserConcernView) this.fYI.findViewById(e.g.view_add_concern);
                this.fYL = this.fYI.findViewById(e.g.bg_user_photo);
                this.fYK = (HeadPendantView) this.fYI.findViewById(e.g.view_host_pendant_photo);
                this.fYK.setHasPendantStyle();
                if (this.fYK.getHeadView() != null) {
                    this.fYK.getHeadView().setIsRound(true);
                    this.fYK.getHeadView().setDefaultBgResource(e.d.transparent);
                    this.fYK.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.setMargins(this.fYS, 0, 0, 0);
                this.fYI.setLayoutParams(layoutParams3);
                this.fYJ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                al.i(this.fYL, e.f.shape_photo_nav_bar_bg);
            }
        } else if (this.fYI != null) {
            this.mNavigationBar.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_LEFT).removeView(this.fYI);
        }
    }

    public void kV(boolean z) {
        if (this.fYE != null) {
            this.fYE.setVisibility(z ? 0 : 8);
        }
    }

    public void lq(boolean z) {
        this.fYU = z;
        bkP();
    }

    private void bkP() {
        if (this.aiC != null && this.fYF != null) {
            if (this.fYU) {
                if (this.fYP) {
                    al.a(this.aiC, e.f.icon_topbar_share_white_d, e.f.icon_topbar_share_white_d);
                } else {
                    ap.CF().c(this.aiC, e.f.icon_topbar_share_n_svg, e.d.cp_cont_e);
                }
                this.fYF.setClickable(false);
                return;
            }
            if (this.fYP) {
                al.a(this.aiC, e.f.pb_ala_share, e.f.pb_ala_share);
            } else {
                ap.CF().c(this.aiC, e.f.icon_topbar_share_n_svg, e.d.select_topbar_icon_color_tint);
            }
            this.fYF.setClickable(true);
        }
    }

    public void lr(boolean z) {
        if (this.fYF != null && !z) {
            this.fYF.setVisibility(8);
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
        if (!TextUtils.isEmpty(str) && !this.fVC) {
            this.fYD.setText(this.fME.getResources().getString(e.j.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            lu(true);
            i.ws().dI(str);
            return;
        }
        lu(false);
    }

    public void a(MetaData metaData, View.OnClickListener onClickListener) {
        if (metaData != null) {
            UtilHelper.showHeadImageViewBigV(this.fYK.getHeadView(), metaData);
            this.fYK.getHeadView().setImageDrawable(null);
            this.fYK.getPendantView().setImageDrawable(null);
            this.fYK.getHeadView().startLoad(metaData.getPortrait(), 28, false);
            this.fYK.getHeadView().setUserId(metaData.getUserId());
            this.fYK.getHeadView().setUserName(metaData.getUserName());
            this.fYK.getHeadView().setOnClickListener(onClickListener);
            if (metaData.getPendantData() != null && !StringUtils.isNull(metaData.getPendantData().xf())) {
                this.fYK.fT(metaData.getPendantData().xf());
            } else {
                this.fYK.fT(null);
            }
        }
    }

    public void a(ab abVar) {
        if (!this.fME.isProgressBarShown()) {
            if (this.fYM == null) {
                this.fYN = new aa((PbActivity) this.fME.getPageContext().getOrignalPage(), this.fME.dCe);
                this.fYM = new com.baidu.tieba.pb.view.b(this.fME.getPageContext().getPageActivity(), this.fYN.getView(), al.getDrawable(e.f.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.pb.pb.main.view.b.2
                    @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                    public void vR() {
                        b.this.fME.bgC();
                    }

                    @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                    public void vS() {
                    }
                });
            }
            this.fYN.biV();
            if (this.fYP) {
                final Rect rect = new Rect();
                if (this.fME.fKX) {
                    com.baidu.adp.lib.g.e.jI().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.3
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.fME.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                            int height = b.this.fME.getWindow().getDecorView().getHeight();
                            b.this.fYM.setClippingEnabled(false);
                            b.this.fYM.showAtLocation(b.this.fME.findViewById(e.g.pb_layout), 81, 0, height - rect.bottom);
                        }
                    }, 500L);
                } else {
                    this.fME.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    int height = this.fME.getWindow().getDecorView().getHeight();
                    this.fYM.setClippingEnabled(false);
                    this.fYM.showAtLocation(this.fME.findViewById(e.g.pb_layout), 81, 0, height - rect.bottom);
                }
            } else {
                this.fYM.showAtLocation(this.fME.findViewById(e.g.pb_layout), 17, 0, 0);
            }
            this.fYN.kL(abVar == null ? false : abVar.fRI);
            this.fYN.kN(abVar == null ? false : abVar.fRN);
            this.fYN.kO(abVar == null ? false : abVar.fRO);
            this.fYN.kP(abVar == null ? false : abVar.fRP);
            this.fYN.kQ(abVar == null ? true : abVar.fRW);
            if (abVar == null) {
                this.fYN.M(false, false);
                this.fYN.N(false, false);
                this.fYN.r(false, "");
            } else {
                this.fYN.M(abVar.fRL, abVar.fRT);
                this.fYN.N(abVar.fRM, abVar.fRS);
                this.fYN.r(StringUtils.isNull(abVar.fRV) ? false : true, abVar.fRV);
            }
            boolean z = abVar == null ? false : abVar.qY;
            boolean z2 = abVar == null ? false : abVar.fID;
            boolean z3 = abVar == null ? false : abVar.isHostOnly;
            boolean z4 = abVar == null ? false : abVar.fRU;
            boolean z5 = abVar == null ? false : abVar.fRK;
            boolean z6 = abVar == null ? false : abVar.fRQ;
            boolean z7 = abVar == null ? false : abVar.fRR;
            this.fYN.kM(abVar == null ? false : abVar.fRJ);
            this.fYN.L(z4, z3);
            this.fYN.O(z5, z);
            this.fYN.P(z7, z6);
            if (abVar != null) {
                this.fYN.fRE = abVar.fRX;
                if (abVar.fRX) {
                    this.fYN.biO().setText(e.j.report_text);
                    this.fYN.kP(false);
                }
            }
            h(z, z2, z3);
        }
    }

    public void bkR() {
        this.fYN.biU().setText(this.fME.getResources().getString(e.j.haved_fans_call));
    }

    private void h(boolean z, boolean z2, boolean z3) {
        if (this.fYN != null) {
            this.fYN.setBackGround();
            if (z) {
                this.fYN.biB().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_recommend_reversed_down_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fYN.biB().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
            }
            if (z2) {
                this.fYN.biB().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fYN.biB().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
            if (z3) {
                this.fYN.biM().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_host_only_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fYN.biM().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void vO() {
        if (this.fYN != null) {
            this.fYN.biW();
        }
        if (this.aZb == null) {
            this.aZb = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.4
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.fYM != null) {
                        g.a(b.this.fYM, b.this.fME.getPageContext().getPageActivity());
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.jI().postDelayed(this.aZb, 100L);
    }

    public void bkS() {
        if (this.fYN != null) {
            this.fYN.biW();
        }
        if (this.fYM != null) {
            g.a(this.fYM, this.fME.getPageContext().getPageActivity());
        }
    }

    public aa bkT() {
        return this.fYN;
    }

    public View bkU() {
        return this.fYG;
    }

    public boolean aoV() {
        return this.fYM != null && this.fYM.isShowing();
    }

    public void aWf() {
        if (this.fYN != null) {
            this.fYN.release();
        }
        this.fYM = null;
        this.fYN = null;
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.aZb);
    }

    public void bkV() {
        if (this.fYE != null) {
            this.fYE.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.fME.getPageContext(), i);
            al.i(this.mNavigationBar.getBarBgView(), e.d.cp_bg_line_d);
        }
        ap.CF().c(this.fYO, e.f.icon_topbar_return_n_svg, e.d.select_topbar_icon_color_tint);
        ap.CF().c(this.aiB, e.f.icon_topbar_more_n_svg, e.d.select_topbar_icon_color_tint);
        bkP();
        if (this.fYJ != null) {
            this.fYJ.onChangeSkinType(i);
        }
        if (this.fYL != null) {
            al.i(this.fYL, e.f.shape_photo_nav_bar_bg);
        }
        al.b(this.fYD, e.d.cp_cont_b, e.d.s_navbar_title_color);
    }

    public void rS(int i) {
        this.mNavigationBar.onChangeSkinType(this.fME.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(e.f.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.fME.getResources().getColor(e.d.black_alpha85));
        if (this.aiC != null) {
            this.aiC.setImageResource(e.f.pb_ala_share);
        }
        if (this.aiB != null) {
            this.aiB.setImageResource(e.f.icon_vnav_more_bg);
        }
        this.fYD.setTextColor(this.fME.getResources().getColor(e.d.cp_cont_g));
        this.fYO.setImageResource(e.f.icon_return_bg);
    }

    public void bkW() {
        this.fYO.setVisibility(0);
        lu(false);
        if (this.fYE != null) {
            this.fYE.setVisibility(8);
        }
        if (this.fYF != null) {
            this.fYF.setVisibility(8);
        }
    }

    public void lt(boolean z) {
        this.fYO.setVisibility(0);
        lu(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.fYF != null) {
                this.fYF.setVisibility(0);
            }
            if (this.fYE != null) {
                this.fYE.setVisibility(0);
                return;
            }
            return;
        }
        if (this.fYF != null) {
            this.fYF.setVisibility(8);
        }
        if (this.fYE != null) {
            this.fYE.setVisibility(8);
        }
    }

    public void lu(boolean z) {
        if (!this.fVC && z && !"".equals(this.fYD.getText().toString())) {
            this.fYD.setVisibility(0);
        } else {
            this.fYD.setVisibility(8);
        }
    }

    public void lv(boolean z) {
        this.fYP = z;
    }

    public void lw(boolean z) {
        if (!this.fYP || TbadkCoreApplication.isLogin() || z) {
            if (z) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("call_fan_guide", false)) {
                    lw(false);
                    return;
                }
            } else if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_share", false)) {
                return;
            }
            this.fYR = z;
            View inflate = LayoutInflater.from(this.fME.getPageContext().getContext()).inflate(e.h.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(e.g.arrow_up);
            TextView textView = (TextView) inflate.findViewById(e.g.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            if (!z) {
                layoutParams.gravity = 5;
                if (!TbadkCoreApplication.isLogin()) {
                    layoutParams.rightMargin = l.h(this.fME, e.C0175e.ds28);
                } else {
                    layoutParams.rightMargin = l.h(this.fME, e.C0175e.ds128);
                }
                textView.setText(e.j.share_tip);
                textView.setOnClickListener(this.fYX);
                this.fYQ = new PopupWindow(inflate, -2, -2);
                com.baidu.adp.lib.g.e.jI().removeCallbacks(this.fYV);
                com.baidu.adp.lib.g.e.jI().postDelayed(this.fYV, 500L);
            }
        }
    }

    public void bkX() {
        if (this.fYV != null) {
            com.baidu.adp.lib.g.e.jI().removeCallbacks(this.fYV);
        }
        if (this.fYW != null) {
            com.baidu.adp.lib.g.e.jI().removeCallbacks(this.fYW);
        }
        bkY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkY() {
        g.a(this.fYQ);
    }

    public void g(int i, int i2, boolean z) {
        if (i2 != 0 && bkQ() != null && this.fYI != null) {
            if (!z) {
                if (this.fYI.getAlpha() != 1.0f) {
                    this.fYI.setAlpha(1.0f);
                }
                if (this.fYJ.getAlpha() != 1.0f) {
                    this.fYJ.setAlpha(1.0f);
                    return;
                }
                return;
            }
            int measuredHeight = (bkQ().getMeasuredHeight() + i2) - 1;
            if (i >= measuredHeight) {
                if (this.fYI.getAlpha() != 0.0f) {
                    this.fYI.setAlpha(0.0f);
                }
                if (this.fYJ.getAlpha() != 0.0f) {
                    this.fYJ.setAlpha(0.0f);
                }
            } else if (i > bkQ().getMeasuredHeight() && i < measuredHeight) {
                float measuredHeight2 = ((i - bkQ().getMeasuredHeight()) * 1.0f) / (measuredHeight - bkQ().getMeasuredHeight());
                this.fYI.setAlpha(1.0f - measuredHeight2);
                this.fYJ.setAlpha(1.0f - measuredHeight2);
            } else if (i <= bkQ().getMeasuredHeight()) {
                if (this.fYI.getAlpha() != 1.0f) {
                    this.fYI.setAlpha(1.0f);
                }
                if (this.fYJ.getAlpha() != 1.0f) {
                    this.fYJ.setAlpha(1.0f);
                }
            }
        }
    }
}
