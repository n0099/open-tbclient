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
    private Runnable aZO;
    private ImageView ajo;
    private ImageView ajp;
    public final View bes;
    private int crr;
    private PbActivity fOe;
    public TextView gad;
    public View gae;
    public View gaf;
    private final ImageView gag;
    private final LinearLayout gah;
    public FrameLayout gai;
    public PbNavbarUserConcernView gaj;
    public HeadPendantView gak;
    public View gal;
    private ImageView gao;
    private PopupWindow gaq;
    private boolean gar;
    private int gas;
    private int gat;
    public final NavigationBar mNavigationBar;
    private boolean fXc = false;
    private com.baidu.tieba.pb.view.b gam = null;
    private aa gan = null;
    private boolean gap = false;
    private boolean gau = false;
    private Runnable dXC = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.5
        @Override // java.lang.Runnable
        public void run() {
            View view;
            if (!b.this.fXc) {
                view = b.this.gar ? b.this.gae : b.this.gaf;
            } else {
                view = b.this.gaf;
            }
            if (view != null) {
                if (TbadkCoreApplication.isLogin() || !b.this.gar) {
                    g.showPopupWindowAsDropDown(b.this.gaq, view);
                    if (!b.this.gar) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_share", true);
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("call_fan_guide", true);
                    }
                    e.jG().removeCallbacks(b.this.dXD);
                    e.jG().postDelayed(b.this.dXD, 5000L);
                }
            }
        }
    };
    private Runnable dXD = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.6
        @Override // java.lang.Runnable
        public void run() {
            b.this.aFO();
        }
    };
    private View.OnClickListener dXE = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.bku();
        }
    };

    public b(PbActivity pbActivity) {
        this.crr = 0;
        this.gas = 0;
        this.gat = 0;
        this.DS4 = 0;
        this.fOe = pbActivity;
        this.crr = l.h(pbActivity, e.C0200e.ds88);
        this.gas = l.h(this.fOe.getPageContext().getPageActivity(), e.C0200e.ds22);
        this.gat = l.h(this.fOe.getPageContext().getPageActivity(), e.C0200e.ds14);
        this.DS4 = l.h(this.fOe.getPageContext().getPageActivity(), e.C0200e.ds4);
        this.mNavigationBar = (NavigationBar) this.fOe.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.fOe.azo();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.bes = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.dDv);
        this.gad = this.mNavigationBar.setCenterTextTitle("");
        this.gag = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.gah = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int h = l.h(this.fOe.getPageContext().getPageActivity(), e.C0200e.ds20);
        this.gah.setPadding(h, 0, h, 0);
        al.a(this.gag, e.f.icon_pb_play_small, e.f.icon_pb_play_small);
        this.gag.setVisibility(8);
        this.gad.setOnClickListener(pbActivity.dDv);
        this.gag.setOnClickListener(pbActivity.dDv);
        this.gao = (ImageView) this.bes.findViewById(e.g.widget_navi_back_button);
    }

    public void lA(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.fXc = z;
        if (this.gaf == null && this.ajp == null) {
            this.gaf = this.mNavigationBar.addCustomView(controlAlign, e.h.nb_item_floor_share, this.fOe.dDv);
            this.ajp = (ImageView) this.gaf.findViewById(e.g.navigationBarBtnShare);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.crr, this.crr);
            layoutParams.rightMargin = this.DS4;
            this.gaf.setLayoutParams(layoutParams);
            bkm();
        }
        if (this.gae == null && this.ajo == null) {
            this.gae = this.mNavigationBar.addCustomView(controlAlign, e.h.nb_item_floor_more, this.fOe.dDv);
            this.ajo = (ImageView) this.gae.findViewById(e.g.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.crr, this.crr);
            layoutParams2.rightMargin = this.gat;
            this.gae.setLayoutParams(layoutParams2);
            al.a(this.ajo, e.f.icon_nav_more_selector, e.f.icon_nav_more_selector);
            this.gae.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
        if (z) {
            if (this.gai == null) {
                this.gai = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.nav_user_concern_layout, (View.OnClickListener) null);
                this.gaj = (PbNavbarUserConcernView) this.gai.findViewById(e.g.view_add_concern);
                this.gal = this.gai.findViewById(e.g.bg_user_photo);
                this.gak = (HeadPendantView) this.gai.findViewById(e.g.view_host_pendant_photo);
                this.gak.setHasPendantStyle();
                if (this.gak.getHeadView() != null) {
                    this.gak.getHeadView().setIsRound(true);
                    this.gak.getHeadView().setDefaultBgResource(e.d.transparent);
                    this.gak.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.setMargins(this.gas, 0, 0, 0);
                this.gai.setLayoutParams(layoutParams3);
                this.gaj.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                al.i(this.gal, e.f.shape_photo_nav_bar_bg);
            }
        } else if (this.gai != null) {
            this.mNavigationBar.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_LEFT).removeView(this.gai);
        }
    }

    public void lg(boolean z) {
        if (this.gae != null) {
            this.gae.setVisibility(z ? 0 : 8);
        }
    }

    public void lB(boolean z) {
        this.gau = z;
        bkm();
    }

    private void bkm() {
        if (this.ajp != null && this.gaf != null) {
            if (this.gau) {
                if (this.gap) {
                    al.a(this.ajp, e.f.icon_topbar_share_white_d, e.f.icon_topbar_share_white_d);
                } else {
                    ap.CM().c(this.ajp, e.f.icon_topbar_share_n_svg, e.d.cp_cont_e);
                }
                this.gaf.setClickable(false);
                return;
            }
            if (this.gap) {
                al.a(this.ajp, e.f.pb_ala_share, e.f.pb_ala_share);
            } else {
                ap.CM().c(this.ajp, e.f.icon_topbar_share_n_svg, e.d.select_topbar_icon_color_tint);
            }
            this.gaf.setClickable(true);
        }
    }

    public void lC(boolean z) {
        if (this.gaf != null && !z) {
            this.gaf.setVisibility(8);
        }
    }

    public NavigationBar bkn() {
        return this.mNavigationBar;
    }

    public void lD(boolean z) {
        if (z) {
            this.bes.setVisibility(0);
        } else {
            this.bes.setVisibility(8);
        }
        lF(z);
    }

    public void qs(String str) {
        if (!TextUtils.isEmpty(str) && !this.fXc) {
            this.gad.setText(this.fOe.getResources().getString(e.j.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            lF(true);
            i.wA().dI(str);
            return;
        }
        lF(false);
    }

    public void a(MetaData metaData, View.OnClickListener onClickListener) {
        if (metaData != null) {
            this.gak.getHeadView().setImageDrawable(null);
            this.gak.getPendantView().setImageDrawable(null);
            this.gak.b(metaData);
            this.gak.getHeadView().startLoad(metaData.getPortrait(), 28, false);
            this.gak.getHeadView().setUserId(metaData.getUserId());
            this.gak.getHeadView().setUserName(metaData.getUserName());
            this.gak.getHeadView().setOnClickListener(onClickListener);
        }
    }

    public void a(ab abVar) {
        if (!this.fOe.isProgressBarShown()) {
            if (this.gam == null) {
                this.gan = new aa((PbActivity) this.fOe.getPageContext().getOrignalPage(), this.fOe.dDv);
                this.gam = new com.baidu.tieba.pb.view.b(this.fOe.getPageContext().getPageActivity(), this.gan.getView(), al.getDrawable(e.f.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.pb.pb.main.view.b.2
                    @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                    public void vZ() {
                        b.this.fOe.bfZ();
                    }

                    @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                    public void wa() {
                    }
                });
            }
            this.gan.bis();
            if (this.gap) {
                final Rect rect = new Rect();
                if (this.fOe.fMx) {
                    com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.3
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.fOe.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                            int height = b.this.fOe.getWindow().getDecorView().getHeight();
                            b.this.gam.setClippingEnabled(false);
                            b.this.gam.showAtLocation(b.this.fOe.findViewById(e.g.pb_layout), 81, 0, height - rect.bottom);
                        }
                    }, 500L);
                } else {
                    this.fOe.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    int height = this.fOe.getWindow().getDecorView().getHeight();
                    this.gam.setClippingEnabled(false);
                    this.gam.showAtLocation(this.fOe.findViewById(e.g.pb_layout), 81, 0, height - rect.bottom);
                }
            } else {
                this.gam.showAtLocation(this.fOe.findViewById(e.g.pb_layout), 17, 0, 0);
            }
            this.gan.kW(abVar == null ? false : abVar.fTi);
            this.gan.kY(abVar == null ? false : abVar.fTn);
            this.gan.kZ(abVar == null ? false : abVar.fTo);
            this.gan.la(abVar == null ? false : abVar.fTp);
            this.gan.lb(abVar == null ? true : abVar.fTw);
            if (abVar == null) {
                this.gan.O(false, false);
                this.gan.P(false, false);
                this.gan.q(false, "");
            } else {
                this.gan.O(abVar.fTl, abVar.fTt);
                this.gan.P(abVar.fTm, abVar.fTs);
                this.gan.q(StringUtils.isNull(abVar.fTv) ? false : true, abVar.fTv);
            }
            boolean z = abVar == null ? false : abVar.qZ;
            boolean z2 = abVar == null ? false : abVar.fKc;
            boolean z3 = abVar == null ? false : abVar.isHostOnly;
            boolean z4 = abVar == null ? false : abVar.fTu;
            boolean z5 = abVar == null ? false : abVar.fTk;
            boolean z6 = abVar == null ? false : abVar.fTq;
            boolean z7 = abVar == null ? false : abVar.fTr;
            this.gan.kX(abVar == null ? false : abVar.fTj);
            this.gan.N(z4, z3);
            this.gan.Q(z5, z);
            this.gan.R(z7, z6);
            if (abVar != null) {
                this.gan.fTe = abVar.fTx;
                if (abVar.fTx) {
                    this.gan.bil().setText(e.j.report_text);
                    this.gan.la(false);
                }
            }
            h(z, z2, z3);
        }
    }

    public void bko() {
        this.gan.bir().setText(this.fOe.getResources().getString(e.j.haved_fans_call));
    }

    private void h(boolean z, boolean z2, boolean z3) {
        if (this.gan != null) {
            this.gan.setBackGround();
            if (z) {
                this.gan.bhY().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_recommend_reversed_down_selector), (Drawable) null, (Drawable) null);
            } else {
                this.gan.bhY().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
            }
            if (z2) {
                this.gan.bhY().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.gan.bhY().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
            if (z3) {
                this.gan.bij().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_host_only_selector), (Drawable) null, (Drawable) null);
            } else {
                this.gan.bij().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void dismissPopMenu() {
        if (this.gan != null) {
            this.gan.bit();
        }
        if (this.aZO == null) {
            this.aZO = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.4
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.gam != null) {
                        g.a(b.this.gam, b.this.fOe.getPageContext().getPageActivity());
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.jG().postDelayed(this.aZO, 100L);
    }

    public void bkp() {
        if (this.gan != null) {
            this.gan.bit();
        }
        if (this.gam != null) {
            g.a(this.gam, this.fOe.getPageContext().getPageActivity());
        }
    }

    public aa bkq() {
        return this.gan;
    }

    public View bkr() {
        return this.gag;
    }

    public boolean aox() {
        return this.gam != null && this.gam.isShowing();
    }

    public void aVC() {
        if (this.gan != null) {
            this.gan.release();
        }
        this.gam = null;
        this.gan = null;
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.aZO);
    }

    public void bks() {
        if (this.gae != null) {
            this.gae.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.fOe.getPageContext(), i);
            al.i(this.mNavigationBar.getBarBgView(), e.d.cp_bg_line_d);
        }
        ap.CM().c(this.gao, e.f.icon_topbar_return_n_svg, e.d.select_topbar_icon_color_tint);
        ap.CM().c(this.ajo, e.f.icon_topbar_more_n_svg, e.d.select_topbar_icon_color_tint);
        bkm();
        if (this.gaj != null) {
            this.gaj.onChangeSkinType(i);
        }
        if (this.gal != null) {
            al.i(this.gal, e.f.shape_photo_nav_bar_bg);
        }
        al.b(this.gad, e.d.cp_cont_b, e.d.s_navbar_title_color);
    }

    public void sl(int i) {
        this.mNavigationBar.onChangeSkinType(this.fOe.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(e.f.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.fOe.getResources().getColor(e.d.black_alpha85));
        if (this.ajp != null) {
            this.ajp.setImageResource(e.f.pb_ala_share);
        }
        if (this.ajo != null) {
            this.ajo.setImageResource(e.f.icon_vnav_more_bg);
        }
        this.gad.setTextColor(this.fOe.getResources().getColor(e.d.cp_cont_g));
        this.gao.setImageResource(e.f.icon_return_bg);
    }

    public void bkt() {
        this.gao.setVisibility(0);
        lF(false);
        if (this.gae != null) {
            this.gae.setVisibility(8);
        }
        if (this.gaf != null) {
            this.gaf.setVisibility(8);
        }
    }

    public void lE(boolean z) {
        this.gao.setVisibility(0);
        lF(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.gaf != null) {
                this.gaf.setVisibility(0);
            }
            if (this.gae != null) {
                this.gae.setVisibility(0);
                return;
            }
            return;
        }
        if (this.gaf != null) {
            this.gaf.setVisibility(8);
        }
        if (this.gae != null) {
            this.gae.setVisibility(8);
        }
    }

    public void lF(boolean z) {
        if (!this.fXc && z && !"".equals(this.gad.getText().toString())) {
            this.gad.setVisibility(0);
        } else {
            this.gad.setVisibility(8);
        }
    }

    public void lG(boolean z) {
        this.gap = z;
    }

    public void lH(boolean z) {
        if (!this.gap || TbadkCoreApplication.isLogin() || z) {
            if (z) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("call_fan_guide", false)) {
                    lH(false);
                    return;
                }
            } else if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_share", false)) {
                return;
            }
            this.gar = z;
            View inflate = LayoutInflater.from(this.fOe.getPageContext().getContext()).inflate(e.h.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(e.g.arrow_up);
            TextView textView = (TextView) inflate.findViewById(e.g.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            if (!z) {
                layoutParams.gravity = 5;
                if (!TbadkCoreApplication.isLogin()) {
                    layoutParams.rightMargin = l.h(this.fOe, e.C0200e.ds28);
                } else {
                    layoutParams.rightMargin = l.h(this.fOe, e.C0200e.ds128);
                }
                textView.setText(e.j.share_tip);
                textView.setOnClickListener(this.dXE);
                this.gaq = new PopupWindow(inflate, -2, -2);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.dXC);
                com.baidu.adp.lib.g.e.jG().postDelayed(this.dXC, 500L);
            }
        }
    }

    public void bku() {
        if (this.dXC != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.dXC);
        }
        if (this.dXD != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.dXD);
        }
        aFO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFO() {
        g.a(this.gaq);
    }

    public void h(int i, int i2, boolean z) {
        if (i2 != 0 && bkn() != null && this.gai != null) {
            if (!z) {
                if (this.gai.getAlpha() != 1.0f) {
                    this.gai.setAlpha(1.0f);
                }
                if (this.gaj.getAlpha() != 1.0f) {
                    this.gaj.setAlpha(1.0f);
                    return;
                }
                return;
            }
            int measuredHeight = (bkn().getMeasuredHeight() + i2) - 1;
            if (i >= measuredHeight) {
                if (this.gai.getAlpha() != 0.0f) {
                    this.gai.setAlpha(0.0f);
                }
                if (this.gaj.getAlpha() != 0.0f) {
                    this.gaj.setAlpha(0.0f);
                }
            } else if (i > bkn().getMeasuredHeight() && i < measuredHeight) {
                float measuredHeight2 = ((i - bkn().getMeasuredHeight()) * 1.0f) / (measuredHeight - bkn().getMeasuredHeight());
                this.gai.setAlpha(1.0f - measuredHeight2);
                this.gaj.setAlpha(1.0f - measuredHeight2);
            } else if (i <= bkn().getMeasuredHeight()) {
                if (this.gai.getAlpha() != 1.0f) {
                    this.gai.setAlpha(1.0f);
                }
                if (this.gaj.getAlpha() != 1.0f) {
                    this.gaj.setAlpha(1.0f);
                }
            }
        }
    }
}
