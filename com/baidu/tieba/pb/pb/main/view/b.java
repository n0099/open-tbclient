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
    private Runnable bdp;
    public final View bhV;
    private int cwp;
    private PbActivity fXM;
    public TextView gjN;
    public View gjO;
    public View gjP;
    private final ImageView gjQ;
    private final LinearLayout gjR;
    public FrameLayout gjS;
    public PbNavbarUserConcernView gjT;
    public HeadPendantView gjU;
    public View gjV;
    private ImageView gjY;
    private PopupWindow gka;
    private boolean gkb;
    private int gkc;
    private int gkd;
    public final NavigationBar mNavigationBar;
    private boolean ggL = false;
    private com.baidu.tieba.pb.view.b gjW = null;
    private aa gjX = null;
    private boolean gjZ = false;
    private boolean gke = false;
    private Runnable egX = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.5
        @Override // java.lang.Runnable
        public void run() {
            View view;
            if (!b.this.ggL) {
                view = b.this.gkb ? b.this.gjO : b.this.gjP;
            } else {
                view = b.this.gjP;
            }
            if (view != null) {
                if (TbadkCoreApplication.isLogin() || !b.this.gkb) {
                    g.showPopupWindowAsDropDown(b.this.gka, view);
                    if (!b.this.gkb) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_share", true);
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("call_fan_guide", true);
                    }
                    e.jG().removeCallbacks(b.this.egY);
                    e.jG().postDelayed(b.this.egY, 5000L);
                }
            }
        }
    };
    private Runnable egY = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.6
        @Override // java.lang.Runnable
        public void run() {
            b.this.aIp();
        }
    };
    private View.OnClickListener egZ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.bmY();
        }
    };

    public b(PbActivity pbActivity) {
        this.cwp = 0;
        this.gkc = 0;
        this.gkd = 0;
        this.DS4 = 0;
        this.fXM = pbActivity;
        this.cwp = l.h(pbActivity, e.C0210e.ds88);
        this.gkc = l.h(this.fXM.getPageContext().getPageActivity(), e.C0210e.ds22);
        this.gkd = l.h(this.fXM.getPageContext().getPageActivity(), e.C0210e.ds14);
        this.DS4 = l.h(this.fXM.getPageContext().getPageActivity(), e.C0210e.ds4);
        this.mNavigationBar = (NavigationBar) this.fXM.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.fXM.aBN();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.bhV = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.dMI);
        this.gjN = this.mNavigationBar.setCenterTextTitle("");
        this.gjQ = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.gjR = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int h = l.h(this.fXM.getPageContext().getPageActivity(), e.C0210e.ds20);
        this.gjR.setPadding(h, 0, h, 0);
        al.a(this.gjQ, e.f.icon_pb_play_small, e.f.icon_pb_play_small);
        this.gjQ.setVisibility(8);
        this.gjN.setOnClickListener(pbActivity.dMI);
        this.gjQ.setOnClickListener(pbActivity.dMI);
        this.gjY = (ImageView) this.bhV.findViewById(e.g.widget_navi_back_button);
    }

    public void lG(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.ggL = z;
        if (this.gjP == null && this.amR == null) {
            this.gjP = this.mNavigationBar.addCustomView(controlAlign, e.h.nb_item_floor_share, this.fXM.dMI);
            this.amR = (ImageView) this.gjP.findViewById(e.g.navigationBarBtnShare);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.cwp, this.cwp);
            layoutParams.rightMargin = this.DS4;
            this.gjP.setLayoutParams(layoutParams);
            bmQ();
        }
        if (this.gjO == null && this.amQ == null) {
            this.gjO = this.mNavigationBar.addCustomView(controlAlign, e.h.nb_item_floor_more, this.fXM.dMI);
            this.amQ = (ImageView) this.gjO.findViewById(e.g.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.cwp, this.cwp);
            layoutParams2.rightMargin = this.gkd;
            this.gjO.setLayoutParams(layoutParams2);
            al.a(this.amQ, e.f.icon_nav_more_selector, e.f.icon_nav_more_selector);
            this.gjO.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
        if (z) {
            if (this.gjS == null) {
                this.gjS = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.nav_user_concern_layout, (View.OnClickListener) null);
                this.gjT = (PbNavbarUserConcernView) this.gjS.findViewById(e.g.view_add_concern);
                this.gjV = this.gjS.findViewById(e.g.bg_user_photo);
                this.gjU = (HeadPendantView) this.gjS.findViewById(e.g.view_host_pendant_photo);
                this.gjU.setHasPendantStyle();
                if (this.gjU.getHeadView() != null) {
                    this.gjU.getHeadView().setIsRound(true);
                    this.gjU.getHeadView().setDefaultBgResource(e.d.transparent);
                    this.gjU.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.setMargins(this.gkc, 0, 0, 0);
                this.gjS.setLayoutParams(layoutParams3);
                this.gjT.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                al.i(this.gjV, e.f.shape_photo_nav_bar_bg);
            }
        } else if (this.gjS != null) {
            this.mNavigationBar.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_LEFT).removeView(this.gjS);
        }
    }

    public void lm(boolean z) {
        if (this.gjO != null) {
            this.gjO.setVisibility(z ? 0 : 8);
        }
    }

    public void lH(boolean z) {
        this.gke = z;
        bmQ();
    }

    private void bmQ() {
        if (this.amR != null && this.gjP != null) {
            if (this.gke) {
                if (this.gjZ) {
                    al.a(this.amR, e.f.icon_topbar_share_white_d, e.f.icon_topbar_share_white_d);
                } else {
                    ap.DQ().c(this.amR, e.f.icon_topbar_share_n_svg, e.d.cp_cont_e);
                }
                this.gjP.setClickable(false);
                return;
            }
            if (this.gjZ) {
                al.a(this.amR, e.f.pb_ala_share, e.f.pb_ala_share);
            } else {
                ap.DQ().c(this.amR, e.f.icon_topbar_share_n_svg, e.d.select_topbar_icon_color_tint);
            }
            this.gjP.setClickable(true);
        }
    }

    public void lI(boolean z) {
        if (this.gjP != null && !z) {
            this.gjP.setVisibility(8);
        }
    }

    public NavigationBar bmR() {
        return this.mNavigationBar;
    }

    public void lJ(boolean z) {
        if (z) {
            this.bhV.setVisibility(0);
        } else {
            this.bhV.setVisibility(8);
        }
        lL(z);
    }

    public void qX(String str) {
        if (!TextUtils.isEmpty(str) && !this.ggL) {
            this.gjN.setText(this.fXM.getResources().getString(e.j.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            lL(true);
            i.xE().ea(str);
            return;
        }
        lL(false);
    }

    public void a(MetaData metaData, View.OnClickListener onClickListener) {
        if (metaData != null) {
            this.gjU.getHeadView().setImageDrawable(null);
            this.gjU.getPendantView().setImageDrawable(null);
            this.gjU.b(metaData);
            this.gjU.getHeadView().startLoad(metaData.getPortrait(), 28, false);
            this.gjU.getHeadView().setUserId(metaData.getUserId());
            this.gjU.getHeadView().setUserName(metaData.getUserName());
            this.gjU.getHeadView().setOnClickListener(onClickListener);
        }
    }

    public void a(ab abVar) {
        if (!this.fXM.isProgressBarShown()) {
            if (this.gjW == null) {
                this.gjX = new aa((PbActivity) this.fXM.getPageContext().getOrignalPage(), this.fXM.dMI);
                this.gjW = new com.baidu.tieba.pb.view.b(this.fXM.getPageContext().getPageActivity(), this.gjX.getView(), al.getDrawable(e.f.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.pb.pb.main.view.b.2
                    @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                    public void xd() {
                        b.this.fXM.biB();
                    }

                    @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                    public void xe() {
                    }
                });
            }
            this.gjX.bkV();
            if (this.gjZ) {
                final Rect rect = new Rect();
                if (this.fXM.fWf) {
                    com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.3
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.fXM.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                            int height = b.this.fXM.getWindow().getDecorView().getHeight();
                            b.this.gjW.setClippingEnabled(false);
                            b.this.gjW.showAtLocation(b.this.fXM.findViewById(e.g.pb_layout), 81, 0, height - rect.bottom);
                        }
                    }, 500L);
                } else {
                    this.fXM.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    int height = this.fXM.getWindow().getDecorView().getHeight();
                    this.gjW.setClippingEnabled(false);
                    this.gjW.showAtLocation(this.fXM.findViewById(e.g.pb_layout), 81, 0, height - rect.bottom);
                }
            } else {
                this.gjW.showAtLocation(this.fXM.findViewById(e.g.pb_layout), 17, 0, 0);
            }
            this.gjX.lc(abVar == null ? false : abVar.gcQ);
            this.gjX.le(abVar == null ? false : abVar.gcV);
            this.gjX.lf(abVar == null ? false : abVar.gcW);
            this.gjX.lg(abVar == null ? false : abVar.gcX);
            this.gjX.lh(abVar == null ? true : abVar.gde);
            if (abVar == null) {
                this.gjX.O(false, false);
                this.gjX.P(false, false);
                this.gjX.r(false, "");
            } else {
                this.gjX.O(abVar.gcT, abVar.gdb);
                this.gjX.P(abVar.gcU, abVar.gda);
                this.gjX.r(StringUtils.isNull(abVar.gdd) ? false : true, abVar.gdd);
            }
            boolean z = abVar == null ? false : abVar.qZ;
            boolean z2 = abVar == null ? false : abVar.fTK;
            boolean z3 = abVar == null ? false : abVar.isHostOnly;
            boolean z4 = abVar == null ? false : abVar.gdc;
            boolean z5 = abVar == null ? false : abVar.gcS;
            boolean z6 = abVar == null ? false : abVar.gcY;
            boolean z7 = abVar == null ? false : abVar.gcZ;
            this.gjX.ld(abVar == null ? false : abVar.gcR);
            this.gjX.N(z4, z3);
            this.gjX.Q(z5, z);
            this.gjX.R(z7, z6);
            if (abVar != null) {
                this.gjX.gcM = abVar.gdf;
                if (abVar.gdf) {
                    this.gjX.bkO().setText(e.j.report_text);
                    this.gjX.lg(false);
                }
            }
            h(z, z2, z3);
        }
    }

    public void bmS() {
        this.gjX.bkU().setText(this.fXM.getResources().getString(e.j.haved_fans_call));
    }

    private void h(boolean z, boolean z2, boolean z3) {
        if (this.gjX != null) {
            this.gjX.setBackGround();
            if (z) {
                this.gjX.bkB().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_recommend_reversed_down_selector), (Drawable) null, (Drawable) null);
            } else {
                this.gjX.bkB().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
            }
            if (z2) {
                this.gjX.bkB().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.gjX.bkB().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
            if (z3) {
                this.gjX.bkM().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_host_only_selector), (Drawable) null, (Drawable) null);
            } else {
                this.gjX.bkM().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void dismissPopMenu() {
        if (this.gjX != null) {
            this.gjX.bkW();
        }
        if (this.bdp == null) {
            this.bdp = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.4
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.gjW != null) {
                        g.a(b.this.gjW, b.this.fXM.getPageContext().getPageActivity());
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.jG().postDelayed(this.bdp, 100L);
    }

    public void bmT() {
        if (this.gjX != null) {
            this.gjX.bkW();
        }
        if (this.gjW != null) {
            g.a(this.gjW, this.fXM.getPageContext().getPageActivity());
        }
    }

    public aa bmU() {
        return this.gjX;
    }

    public View bmV() {
        return this.gjQ;
    }

    public boolean aqZ() {
        return this.gjW != null && this.gjW.isShowing();
    }

    public void aYh() {
        if (this.gjX != null) {
            this.gjX.release();
        }
        this.gjW = null;
        this.gjX = null;
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bdp);
    }

    public void bmW() {
        if (this.gjO != null) {
            this.gjO.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.fXM.getPageContext(), i);
            al.i(this.mNavigationBar.getBarBgView(), e.d.cp_bg_line_d);
        }
        ap.DQ().c(this.gjY, e.f.icon_topbar_return_n_svg, e.d.select_topbar_icon_color_tint);
        ap.DQ().c(this.amQ, e.f.icon_topbar_more_n_svg, e.d.select_topbar_icon_color_tint);
        bmQ();
        if (this.gjT != null) {
            this.gjT.onChangeSkinType(i);
        }
        if (this.gjV != null) {
            al.i(this.gjV, e.f.shape_photo_nav_bar_bg);
        }
        al.b(this.gjN, e.d.cp_cont_b, e.d.s_navbar_title_color);
    }

    public void sS(int i) {
        this.mNavigationBar.onChangeSkinType(this.fXM.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(e.f.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.fXM.getResources().getColor(e.d.black_alpha85));
        if (this.amR != null) {
            this.amR.setImageResource(e.f.pb_ala_share);
        }
        if (this.amQ != null) {
            this.amQ.setImageResource(e.f.icon_vnav_more_bg);
        }
        this.gjN.setTextColor(this.fXM.getResources().getColor(e.d.cp_cont_g));
        this.gjY.setImageResource(e.f.icon_return_bg);
    }

    public void bmX() {
        this.gjY.setVisibility(0);
        lL(false);
        if (this.gjO != null) {
            this.gjO.setVisibility(8);
        }
        if (this.gjP != null) {
            this.gjP.setVisibility(8);
        }
    }

    public void lK(boolean z) {
        this.gjY.setVisibility(0);
        lL(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.gjP != null) {
                this.gjP.setVisibility(0);
            }
            if (this.gjO != null) {
                this.gjO.setVisibility(0);
                return;
            }
            return;
        }
        if (this.gjP != null) {
            this.gjP.setVisibility(8);
        }
        if (this.gjO != null) {
            this.gjO.setVisibility(8);
        }
    }

    public void lL(boolean z) {
        if (!this.ggL && z && !"".equals(this.gjN.getText().toString())) {
            this.gjN.setVisibility(0);
        } else {
            this.gjN.setVisibility(8);
        }
    }

    public void lM(boolean z) {
        this.gjZ = z;
    }

    public void lN(boolean z) {
        if (!this.gjZ || TbadkCoreApplication.isLogin() || z) {
            if (z) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("call_fan_guide", false)) {
                    lN(false);
                    return;
                }
            } else if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_share", false)) {
                return;
            }
            this.gkb = z;
            View inflate = LayoutInflater.from(this.fXM.getPageContext().getContext()).inflate(e.h.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(e.g.arrow_up);
            TextView textView = (TextView) inflate.findViewById(e.g.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            if (!z) {
                layoutParams.gravity = 5;
                if (!TbadkCoreApplication.isLogin()) {
                    layoutParams.rightMargin = l.h(this.fXM, e.C0210e.ds28);
                } else {
                    layoutParams.rightMargin = l.h(this.fXM, e.C0210e.ds128);
                }
                textView.setText(e.j.share_tip);
                textView.setOnClickListener(this.egZ);
                this.gka = new PopupWindow(inflate, -2, -2);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.egX);
                com.baidu.adp.lib.g.e.jG().postDelayed(this.egX, 500L);
            }
        }
    }

    public void bmY() {
        if (this.egX != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.egX);
        }
        if (this.egY != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.egY);
        }
        aIp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIp() {
        g.a(this.gka);
    }

    public void h(int i, int i2, boolean z) {
        if (i2 != 0 && bmR() != null && this.gjS != null) {
            if (!z) {
                if (this.gjS.getAlpha() != 1.0f) {
                    this.gjS.setAlpha(1.0f);
                }
                if (this.gjT.getAlpha() != 1.0f) {
                    this.gjT.setAlpha(1.0f);
                    return;
                }
                return;
            }
            int measuredHeight = (bmR().getMeasuredHeight() + i2) - 1;
            if (i >= measuredHeight) {
                if (this.gjS.getAlpha() != 0.0f) {
                    this.gjS.setAlpha(0.0f);
                }
                if (this.gjT.getAlpha() != 0.0f) {
                    this.gjT.setAlpha(0.0f);
                }
            } else if (i > bmR().getMeasuredHeight() && i < measuredHeight) {
                float measuredHeight2 = ((i - bmR().getMeasuredHeight()) * 1.0f) / (measuredHeight - bmR().getMeasuredHeight());
                this.gjS.setAlpha(1.0f - measuredHeight2);
                this.gjT.setAlpha(1.0f - measuredHeight2);
            } else if (i <= bmR().getMeasuredHeight()) {
                if (this.gjS.getAlpha() != 1.0f) {
                    this.gjS.setAlpha(1.0f);
                }
                if (this.gjT.getAlpha() != 1.0f) {
                    this.gjT.setAlpha(1.0f);
                }
            }
        }
    }
}
