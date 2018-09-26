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
/* loaded from: classes2.dex */
public class b {
    private int DS4;
    private Runnable aUC;
    public final View aZe;
    private ImageView adE;
    private ImageView adF;
    private int ciI;
    private PbActivity fFd;
    public TextView fRd;
    public View fRe;
    public View fRf;
    private final ImageView fRg;
    private final LinearLayout fRh;
    public FrameLayout fRi;
    public PbNavbarUserConcernView fRj;
    public HeadPendantView fRk;
    public View fRl;
    private ImageView fRo;
    private PopupWindow fRq;
    private boolean fRr;
    private int fRs;
    private int fRt;
    public final NavigationBar mNavigationBar;
    private boolean fOb = false;
    private com.baidu.tieba.pb.view.b fRm = null;
    private aa fRn = null;
    private boolean fRp = false;
    private boolean fRu = false;
    private Runnable fRv = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.5
        @Override // java.lang.Runnable
        public void run() {
            View view;
            if (!b.this.fOb) {
                view = b.this.fRr ? b.this.fRe : b.this.fRf;
            } else {
                view = b.this.fRf;
            }
            if (view != null) {
                if (TbadkCoreApplication.isLogin() || !b.this.fRr) {
                    g.showPopupWindowAsDropDown(b.this.fRq, view);
                    if (!b.this.fRr) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_share", true);
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("call_fan_guide", true);
                    }
                    e.jt().removeCallbacks(b.this.fRw);
                    e.jt().postDelayed(b.this.fRw, 5000L);
                }
            }
        }
    };
    private Runnable fRw = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.6
        @Override // java.lang.Runnable
        public void run() {
            b.this.bhM();
        }
    };
    private View.OnClickListener fRx = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.bhL();
        }
    };

    public b(PbActivity pbActivity) {
        this.ciI = 0;
        this.fRs = 0;
        this.fRt = 0;
        this.DS4 = 0;
        this.fFd = pbActivity;
        this.ciI = l.h(pbActivity, e.C0141e.ds88);
        this.fRs = l.h(this.fFd.getPageContext().getPageActivity(), e.C0141e.ds22);
        this.fRt = l.h(this.fFd.getPageContext().getPageActivity(), e.C0141e.ds14);
        this.DS4 = l.h(this.fFd.getPageContext().getPageActivity(), e.C0141e.ds4);
        this.mNavigationBar = (NavigationBar) this.fFd.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.fFd.awu();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.aZe = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.dud);
        this.fRd = this.mNavigationBar.setCenterTextTitle("");
        this.fRg = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.fRh = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int h = l.h(this.fFd.getPageContext().getPageActivity(), e.C0141e.ds20);
        this.fRh.setPadding(h, 0, h, 0);
        al.a(this.fRg, e.f.icon_pb_play_small, e.f.icon_pb_play_small);
        this.fRg.setVisibility(8);
        this.fRd.setOnClickListener(pbActivity.dud);
        this.fRg.setOnClickListener(pbActivity.dud);
        this.fRo = (ImageView) this.aZe.findViewById(e.g.widget_navi_back_button);
    }

    public void kY(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.fOb = z;
        if (this.fRf == null && this.adF == null) {
            this.fRf = this.mNavigationBar.addCustomView(controlAlign, e.h.nb_item_floor_share, this.fFd.dud);
            this.adF = (ImageView) this.fRf.findViewById(e.g.navigationBarBtnShare);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ciI, this.ciI);
            layoutParams.rightMargin = this.DS4;
            this.fRf.setLayoutParams(layoutParams);
            bhD();
        }
        if (this.fRe == null && this.adE == null) {
            this.fRe = this.mNavigationBar.addCustomView(controlAlign, e.h.nb_item_floor_more, this.fFd.dud);
            this.adE = (ImageView) this.fRe.findViewById(e.g.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.ciI, this.ciI);
            layoutParams2.rightMargin = this.fRt;
            this.fRe.setLayoutParams(layoutParams2);
            al.a(this.adE, e.f.icon_nav_more_selector, e.f.icon_nav_more_selector);
            this.fRe.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
        if (z) {
            if (this.fRi == null) {
                this.fRi = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.nav_user_concern_layout, (View.OnClickListener) null);
                this.fRj = (PbNavbarUserConcernView) this.fRi.findViewById(e.g.view_add_concern);
                this.fRl = this.fRi.findViewById(e.g.bg_user_photo);
                this.fRk = (HeadPendantView) this.fRi.findViewById(e.g.view_host_pendant_photo);
                this.fRk.setHasPendantStyle();
                if (this.fRk.getHeadView() != null) {
                    this.fRk.getHeadView().setIsRound(true);
                    this.fRk.getHeadView().setDefaultBgResource(e.d.transparent);
                    this.fRk.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.setMargins(this.fRs, 0, 0, 0);
                this.fRi.setLayoutParams(layoutParams3);
                this.fRj.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                al.i(this.fRl, e.f.shape_photo_nav_bar_bg);
            }
        } else if (this.fRi != null) {
            this.mNavigationBar.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_LEFT).removeView(this.fRi);
        }
    }

    public void kE(boolean z) {
        if (this.fRe != null) {
            this.fRe.setVisibility(z ? 0 : 8);
        }
    }

    public void kZ(boolean z) {
        this.fRu = z;
        bhD();
    }

    private void bhD() {
        if (this.adF != null && this.fRf != null) {
            if (this.fRu) {
                if (this.fRp) {
                    al.a(this.adF, e.f.icon_topbar_share_white_d, e.f.icon_topbar_share_white_d);
                } else {
                    ap.Ay().c(this.adF, e.f.icon_topbar_share_n_svg, e.d.cp_cont_e);
                }
                this.fRf.setClickable(false);
                return;
            }
            if (this.fRp) {
                al.a(this.adF, e.f.pb_ala_share, e.f.pb_ala_share);
            } else {
                ap.Ay().c(this.adF, e.f.icon_topbar_share_n_svg, e.d.select_topbar_icon_color_tint);
            }
            this.fRf.setClickable(true);
        }
    }

    public void la(boolean z) {
        if (this.fRf != null && !z) {
            this.fRf.setVisibility(8);
        }
    }

    public NavigationBar bhE() {
        return this.mNavigationBar;
    }

    public void lb(boolean z) {
        if (z) {
            this.aZe.setVisibility(0);
        } else {
            this.aZe.setVisibility(8);
        }
        ld(z);
    }

    public void pP(String str) {
        if (!TextUtils.isEmpty(str) && !this.fOb) {
            this.fRd.setText(this.fFd.getResources().getString(e.j.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            ld(true);
            i.uj().ds(str);
            return;
        }
        ld(false);
    }

    public void a(MetaData metaData, View.OnClickListener onClickListener) {
        if (metaData != null) {
            UtilHelper.showHeadImageViewBigV(this.fRk.getHeadView(), metaData);
            this.fRk.getHeadView().setImageDrawable(null);
            this.fRk.getPendantView().setImageDrawable(null);
            this.fRk.getHeadView().startLoad(metaData.getPortrait(), 28, false);
            this.fRk.getHeadView().setUserId(metaData.getUserId());
            this.fRk.getHeadView().setUserName(metaData.getUserName());
            this.fRk.getHeadView().setOnClickListener(onClickListener);
            if (metaData.getPendantData() != null && !StringUtils.isNull(metaData.getPendantData().uW())) {
                this.fRk.fF(metaData.getPendantData().uW());
            } else {
                this.fRk.fF(null);
            }
        }
    }

    public void a(ab abVar) {
        if (!this.fFd.isProgressBarShown()) {
            if (this.fRm == null) {
                this.fRn = new aa((PbActivity) this.fFd.getPageContext().getOrignalPage(), this.fFd.dud);
                this.fRm = new com.baidu.tieba.pb.view.b(this.fFd.getPageContext().getPageActivity(), this.fRn.getView(), al.getDrawable(e.f.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.pb.pb.main.view.b.2
                    @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                    public void tI() {
                        b.this.fFd.bdq();
                    }

                    @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                    public void tJ() {
                    }
                });
            }
            this.fRn.bfJ();
            if (this.fRp) {
                final Rect rect = new Rect();
                if (this.fFd.fDw) {
                    com.baidu.adp.lib.g.e.jt().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.3
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.fFd.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                            int height = b.this.fFd.getWindow().getDecorView().getHeight();
                            b.this.fRm.setClippingEnabled(false);
                            b.this.fRm.showAtLocation(b.this.fFd.findViewById(e.g.pb_layout), 81, 0, height - rect.bottom);
                        }
                    }, 500L);
                } else {
                    this.fFd.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    int height = this.fFd.getWindow().getDecorView().getHeight();
                    this.fRm.setClippingEnabled(false);
                    this.fRm.showAtLocation(this.fFd.findViewById(e.g.pb_layout), 81, 0, height - rect.bottom);
                }
            } else {
                this.fRm.showAtLocation(this.fFd.findViewById(e.g.pb_layout), 17, 0, 0);
            }
            this.fRn.ku(abVar == null ? false : abVar.fKh);
            this.fRn.kw(abVar == null ? false : abVar.fKm);
            this.fRn.kx(abVar == null ? false : abVar.fKn);
            this.fRn.ky(abVar == null ? false : abVar.fKo);
            this.fRn.kz(abVar == null ? true : abVar.fKv);
            if (abVar == null) {
                this.fRn.L(false, false);
                this.fRn.M(false, false);
                this.fRn.r(false, "");
            } else {
                this.fRn.L(abVar.fKk, abVar.fKs);
                this.fRn.M(abVar.fKl, abVar.fKr);
                this.fRn.r(StringUtils.isNull(abVar.fKu) ? false : true, abVar.fKu);
            }
            boolean z = abVar == null ? false : abVar.qm;
            boolean z2 = abVar == null ? false : abVar.fBb;
            boolean z3 = abVar == null ? false : abVar.isHostOnly;
            boolean z4 = abVar == null ? false : abVar.fKt;
            boolean z5 = abVar == null ? false : abVar.fKj;
            boolean z6 = abVar == null ? false : abVar.fKp;
            boolean z7 = abVar == null ? false : abVar.fKq;
            this.fRn.kv(abVar == null ? false : abVar.fKi);
            this.fRn.K(z4, z3);
            this.fRn.N(z5, z);
            this.fRn.O(z7, z6);
            if (abVar != null) {
                this.fRn.fKd = abVar.fKw;
                if (abVar.fKw) {
                    this.fRn.bfC().setText(e.j.report_text);
                    this.fRn.ky(false);
                }
            }
            h(z, z2, z3);
        }
    }

    public void bhF() {
        this.fRn.bfI().setText(this.fFd.getResources().getString(e.j.haved_fans_call));
    }

    private void h(boolean z, boolean z2, boolean z3) {
        if (this.fRn != null) {
            this.fRn.setBackGround();
            if (z) {
                this.fRn.bfp().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_recommend_reversed_down_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fRn.bfp().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
            }
            if (z2) {
                this.fRn.bfp().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fRn.bfp().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
            if (z3) {
                this.fRn.bfA().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_host_only_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fRn.bfA().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void tF() {
        if (this.fRn != null) {
            this.fRn.bfK();
        }
        if (this.aUC == null) {
            this.aUC = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.4
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.fRm != null) {
                        g.a(b.this.fRm, b.this.fFd.getPageContext().getPageActivity());
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.jt().postDelayed(this.aUC, 100L);
    }

    public void bhG() {
        if (this.fRn != null) {
            this.fRn.bfK();
        }
        if (this.fRm != null) {
            g.a(this.fRm, this.fFd.getPageContext().getPageActivity());
        }
    }

    public aa bhH() {
        return this.fRn;
    }

    public View bhI() {
        return this.fRg;
    }

    public boolean alt() {
        return this.fRm != null && this.fRm.isShowing();
    }

    public void aSR() {
        if (this.fRn != null) {
            this.fRn.release();
        }
        this.fRm = null;
        this.fRn = null;
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.aUC);
    }

    public void bhJ() {
        if (this.fRe != null) {
            this.fRe.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.fFd.getPageContext(), i);
            al.i(this.mNavigationBar.getBarBgView(), e.d.cp_bg_line_d);
        }
        ap.Ay().c(this.fRo, e.f.icon_topbar_return_n_svg, e.d.select_topbar_icon_color_tint);
        ap.Ay().c(this.adE, e.f.icon_topbar_more_n_svg, e.d.select_topbar_icon_color_tint);
        bhD();
        if (this.fRj != null) {
            this.fRj.onChangeSkinType(i);
        }
        if (this.fRl != null) {
            al.i(this.fRl, e.f.shape_photo_nav_bar_bg);
        }
        al.b(this.fRd, e.d.cp_cont_b, e.d.s_navbar_title_color);
    }

    public void rv(int i) {
        this.mNavigationBar.onChangeSkinType(this.fFd.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(e.f.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.fFd.getResources().getColor(e.d.black_alpha85));
        if (this.adF != null) {
            this.adF.setImageResource(e.f.pb_ala_share);
        }
        if (this.adE != null) {
            this.adE.setImageResource(e.f.icon_vnav_more_bg);
        }
        this.fRd.setTextColor(this.fFd.getResources().getColor(e.d.cp_cont_g));
        this.fRo.setImageResource(e.f.icon_return_bg);
    }

    public void bhK() {
        this.fRo.setVisibility(0);
        ld(false);
        if (this.fRe != null) {
            this.fRe.setVisibility(8);
        }
        if (this.fRf != null) {
            this.fRf.setVisibility(8);
        }
    }

    public void lc(boolean z) {
        this.fRo.setVisibility(0);
        ld(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.fRf != null) {
                this.fRf.setVisibility(0);
            }
            if (this.fRe != null) {
                this.fRe.setVisibility(0);
                return;
            }
            return;
        }
        if (this.fRf != null) {
            this.fRf.setVisibility(8);
        }
        if (this.fRe != null) {
            this.fRe.setVisibility(8);
        }
    }

    public void ld(boolean z) {
        if (!this.fOb && z && !"".equals(this.fRd.getText().toString())) {
            this.fRd.setVisibility(0);
        } else {
            this.fRd.setVisibility(8);
        }
    }

    public void le(boolean z) {
        this.fRp = z;
    }

    public void lf(boolean z) {
        if (!this.fRp || TbadkCoreApplication.isLogin() || z) {
            if (z) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("call_fan_guide", false)) {
                    lf(false);
                    return;
                }
            } else if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_share", false)) {
                return;
            }
            this.fRr = z;
            View inflate = LayoutInflater.from(this.fFd.getPageContext().getContext()).inflate(e.h.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(e.g.arrow_up);
            TextView textView = (TextView) inflate.findViewById(e.g.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            if (!z) {
                layoutParams.gravity = 5;
                if (!TbadkCoreApplication.isLogin()) {
                    layoutParams.rightMargin = l.h(this.fFd, e.C0141e.ds28);
                } else {
                    layoutParams.rightMargin = l.h(this.fFd, e.C0141e.ds128);
                }
                textView.setText(e.j.share_tip);
                textView.setOnClickListener(this.fRx);
                this.fRq = new PopupWindow(inflate, -2, -2);
                com.baidu.adp.lib.g.e.jt().removeCallbacks(this.fRv);
                com.baidu.adp.lib.g.e.jt().postDelayed(this.fRv, 500L);
            }
        }
    }

    public void bhL() {
        if (this.fRv != null) {
            com.baidu.adp.lib.g.e.jt().removeCallbacks(this.fRv);
        }
        if (this.fRw != null) {
            com.baidu.adp.lib.g.e.jt().removeCallbacks(this.fRw);
        }
        bhM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhM() {
        g.a(this.fRq);
    }

    public void g(int i, int i2, boolean z) {
        if (i2 != 0 && bhE() != null && this.fRi != null) {
            if (!z) {
                if (this.fRi.getAlpha() != 1.0f) {
                    this.fRi.setAlpha(1.0f);
                }
                if (this.fRj.getAlpha() != 1.0f) {
                    this.fRj.setAlpha(1.0f);
                    return;
                }
                return;
            }
            int measuredHeight = (bhE().getMeasuredHeight() + i2) - 1;
            if (i >= measuredHeight) {
                if (this.fRi.getAlpha() != 0.0f) {
                    this.fRi.setAlpha(0.0f);
                }
                if (this.fRj.getAlpha() != 0.0f) {
                    this.fRj.setAlpha(0.0f);
                }
            } else if (i > bhE().getMeasuredHeight() && i < measuredHeight) {
                float measuredHeight2 = ((i - bhE().getMeasuredHeight()) * 1.0f) / (measuredHeight - bhE().getMeasuredHeight());
                this.fRi.setAlpha(1.0f - measuredHeight2);
                this.fRj.setAlpha(1.0f - measuredHeight2);
            } else if (i <= bhE().getMeasuredHeight()) {
                if (this.fRi.getAlpha() != 1.0f) {
                    this.fRi.setAlpha(1.0f);
                }
                if (this.fRj.getAlpha() != 1.0f) {
                    this.fRj.setAlpha(1.0f);
                }
            }
        }
    }
}
