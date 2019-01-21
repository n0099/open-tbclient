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
    private ImageView ant;
    private ImageView anu;
    private Runnable bea;
    public final View biH;
    private int cxb;
    private PbActivity fYK;
    public TextView gkR;
    public View gkS;
    public View gkT;
    private final ImageView gkU;
    private final LinearLayout gkV;
    public FrameLayout gkW;
    public PbNavbarUserConcernView gkX;
    public HeadPendantView gkY;
    public View gkZ;
    private ImageView glc;
    private PopupWindow gle;
    private boolean glf;
    private int glg;
    private int glh;
    public final NavigationBar mNavigationBar;
    private boolean ghP = false;
    private com.baidu.tieba.pb.view.b gla = null;
    private aa glb = null;
    private boolean gld = false;
    private boolean gli = false;
    private Runnable ehE = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.5
        @Override // java.lang.Runnable
        public void run() {
            View view;
            if (!b.this.ghP) {
                view = b.this.glf ? b.this.gkS : b.this.gkT;
            } else {
                view = b.this.gkT;
            }
            if (view != null) {
                if (TbadkCoreApplication.isLogin() || !b.this.glf) {
                    g.showPopupWindowAsDropDown(b.this.gle, view);
                    if (!b.this.glf) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_share", true);
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("call_fan_guide", true);
                    }
                    e.jG().removeCallbacks(b.this.ehF);
                    e.jG().postDelayed(b.this.ehF, 5000L);
                }
            }
        }
    };
    private Runnable ehF = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.6
        @Override // java.lang.Runnable
        public void run() {
            b.this.aIM();
        }
    };
    private View.OnClickListener ehG = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.bnG();
        }
    };

    public b(PbActivity pbActivity) {
        this.cxb = 0;
        this.glg = 0;
        this.glh = 0;
        this.DS4 = 0;
        this.fYK = pbActivity;
        this.cxb = l.h(pbActivity, e.C0210e.ds88);
        this.glg = l.h(this.fYK.getPageContext().getPageActivity(), e.C0210e.ds22);
        this.glh = l.h(this.fYK.getPageContext().getPageActivity(), e.C0210e.ds14);
        this.DS4 = l.h(this.fYK.getPageContext().getPageActivity(), e.C0210e.ds4);
        this.mNavigationBar = (NavigationBar) this.fYK.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.fYK.aCk();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.biH = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.dNs);
        this.gkR = this.mNavigationBar.setCenterTextTitle("");
        this.gkU = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.gkV = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int h = l.h(this.fYK.getPageContext().getPageActivity(), e.C0210e.ds20);
        this.gkV.setPadding(h, 0, h, 0);
        al.a(this.gkU, e.f.icon_pb_play_small, e.f.icon_pb_play_small);
        this.gkU.setVisibility(8);
        this.gkR.setOnClickListener(pbActivity.dNs);
        this.gkU.setOnClickListener(pbActivity.dNs);
        this.glc = (ImageView) this.biH.findViewById(e.g.widget_navi_back_button);
    }

    public void lG(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.ghP = z;
        if (this.gkT == null && this.anu == null) {
            this.gkT = this.mNavigationBar.addCustomView(controlAlign, e.h.nb_item_floor_share, this.fYK.dNs);
            this.anu = (ImageView) this.gkT.findViewById(e.g.navigationBarBtnShare);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.cxb, this.cxb);
            layoutParams.rightMargin = this.DS4;
            this.gkT.setLayoutParams(layoutParams);
            bny();
        }
        if (this.gkS == null && this.ant == null) {
            this.gkS = this.mNavigationBar.addCustomView(controlAlign, e.h.nb_item_floor_more, this.fYK.dNs);
            this.ant = (ImageView) this.gkS.findViewById(e.g.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.cxb, this.cxb);
            layoutParams2.rightMargin = this.glh;
            this.gkS.setLayoutParams(layoutParams2);
            al.a(this.ant, e.f.icon_nav_more_selector, e.f.icon_nav_more_selector);
            this.gkS.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
        if (z) {
            if (this.gkW == null) {
                this.gkW = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.nav_user_concern_layout, (View.OnClickListener) null);
                this.gkX = (PbNavbarUserConcernView) this.gkW.findViewById(e.g.view_add_concern);
                this.gkZ = this.gkW.findViewById(e.g.bg_user_photo);
                this.gkY = (HeadPendantView) this.gkW.findViewById(e.g.view_host_pendant_photo);
                this.gkY.setHasPendantStyle();
                if (this.gkY.getHeadView() != null) {
                    this.gkY.getHeadView().setIsRound(true);
                    this.gkY.getHeadView().setDefaultBgResource(e.d.transparent);
                    this.gkY.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.setMargins(this.glg, 0, 0, 0);
                this.gkW.setLayoutParams(layoutParams3);
                this.gkX.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                al.i(this.gkZ, e.f.shape_photo_nav_bar_bg);
            }
        } else if (this.gkW != null) {
            this.mNavigationBar.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_LEFT).removeView(this.gkW);
        }
    }

    public void lm(boolean z) {
        if (this.gkS != null) {
            this.gkS.setVisibility(z ? 0 : 8);
        }
    }

    public void lH(boolean z) {
        this.gli = z;
        bny();
    }

    private void bny() {
        if (this.anu != null && this.gkT != null) {
            if (this.gli) {
                if (this.gld) {
                    al.a(this.anu, e.f.icon_topbar_share_white_d, e.f.icon_topbar_share_white_d);
                } else {
                    ap.Ed().c(this.anu, e.f.icon_topbar_share_n_svg, e.d.cp_cont_e);
                }
                this.gkT.setClickable(false);
                return;
            }
            if (this.gld) {
                al.a(this.anu, e.f.pb_ala_share, e.f.pb_ala_share);
            } else {
                ap.Ed().c(this.anu, e.f.icon_topbar_share_n_svg, e.d.select_topbar_icon_color_tint);
            }
            this.gkT.setClickable(true);
        }
    }

    public void lI(boolean z) {
        if (this.gkT != null && !z) {
            this.gkT.setVisibility(8);
        }
    }

    public NavigationBar bnz() {
        return this.mNavigationBar;
    }

    public void lJ(boolean z) {
        if (z) {
            this.biH.setVisibility(0);
        } else {
            this.biH.setVisibility(8);
        }
        lL(z);
    }

    public void rn(String str) {
        if (!TextUtils.isEmpty(str) && !this.ghP) {
            this.gkR.setText(this.fYK.getResources().getString(e.j.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            lL(true);
            i.xR().ej(str);
            return;
        }
        lL(false);
    }

    public void a(MetaData metaData, View.OnClickListener onClickListener) {
        if (metaData != null) {
            this.gkY.getHeadView().setImageDrawable(null);
            this.gkY.getPendantView().setImageDrawable(null);
            this.gkY.b(metaData);
            this.gkY.getHeadView().startLoad(metaData.getPortrait(), 28, false);
            this.gkY.getHeadView().setUserId(metaData.getUserId());
            this.gkY.getHeadView().setUserName(metaData.getUserName());
            this.gkY.getHeadView().setOnClickListener(onClickListener);
        }
    }

    public void a(ab abVar) {
        if (!this.fYK.isProgressBarShown()) {
            if (this.gla == null) {
                this.glb = new aa((PbActivity) this.fYK.getPageContext().getOrignalPage(), this.fYK.dNs);
                this.gla = new com.baidu.tieba.pb.view.b(this.fYK.getPageContext().getPageActivity(), this.glb.getView(), al.getDrawable(e.f.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.pb.pb.main.view.b.2
                    @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                    public void xq() {
                        b.this.fYK.bjf();
                    }

                    @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                    public void xr() {
                    }
                });
            }
            this.glb.blD();
            if (this.gld) {
                final Rect rect = new Rect();
                if (this.fYK.fXd) {
                    com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.3
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.fYK.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                            int height = b.this.fYK.getWindow().getDecorView().getHeight();
                            b.this.gla.setClippingEnabled(false);
                            b.this.gla.showAtLocation(b.this.fYK.findViewById(e.g.pb_layout), 81, 0, height - rect.bottom);
                        }
                    }, 500L);
                } else {
                    this.fYK.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    int height = this.fYK.getWindow().getDecorView().getHeight();
                    this.gla.setClippingEnabled(false);
                    this.gla.showAtLocation(this.fYK.findViewById(e.g.pb_layout), 81, 0, height - rect.bottom);
                }
            } else {
                this.gla.showAtLocation(this.fYK.findViewById(e.g.pb_layout), 17, 0, 0);
            }
            this.glb.lc(abVar == null ? false : abVar.gdP);
            this.glb.le(abVar == null ? false : abVar.gdU);
            this.glb.lf(abVar == null ? false : abVar.gdV);
            this.glb.lg(abVar == null ? false : abVar.gdW);
            this.glb.lh(abVar == null ? true : abVar.ged);
            if (abVar == null) {
                this.glb.O(false, false);
                this.glb.P(false, false);
                this.glb.q(false, "");
            } else {
                this.glb.O(abVar.gdS, abVar.gea);
                this.glb.P(abVar.gdT, abVar.gdZ);
                this.glb.q(StringUtils.isNull(abVar.gec) ? false : true, abVar.gec);
            }
            boolean z = abVar == null ? false : abVar.qZ;
            boolean z2 = abVar == null ? false : abVar.fUI;
            boolean z3 = abVar == null ? false : abVar.isHostOnly;
            boolean z4 = abVar == null ? false : abVar.geb;
            boolean z5 = abVar == null ? false : abVar.gdR;
            boolean z6 = abVar == null ? false : abVar.gdX;
            boolean z7 = abVar == null ? false : abVar.gdY;
            this.glb.ld(abVar == null ? false : abVar.gdQ);
            this.glb.N(z4, z3);
            this.glb.Q(z5, z);
            this.glb.R(z7, z6);
            if (abVar != null) {
                this.glb.gdL = abVar.gee;
                if (abVar.gee) {
                    this.glb.blw().setText(e.j.report_text);
                    this.glb.lg(false);
                }
            }
            h(z, z2, z3);
        }
    }

    public void bnA() {
        this.glb.blC().setText(this.fYK.getResources().getString(e.j.haved_fans_call));
    }

    private void h(boolean z, boolean z2, boolean z3) {
        if (this.glb != null) {
            this.glb.setBackGround();
            if (z) {
                this.glb.blj().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_recommend_reversed_down_selector), (Drawable) null, (Drawable) null);
            } else {
                this.glb.blj().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
            }
            if (z2) {
                this.glb.blj().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.glb.blj().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
            if (z3) {
                this.glb.blu().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_host_only_selector), (Drawable) null, (Drawable) null);
            } else {
                this.glb.blu().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void dismissPopMenu() {
        if (this.glb != null) {
            this.glb.blE();
        }
        if (this.bea == null) {
            this.bea = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.4
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.gla != null) {
                        g.a(b.this.gla, b.this.fYK.getPageContext().getPageActivity());
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.jG().postDelayed(this.bea, 100L);
    }

    public void bnB() {
        if (this.glb != null) {
            this.glb.blE();
        }
        if (this.gla != null) {
            g.a(this.gla, this.fYK.getPageContext().getPageActivity());
        }
    }

    public aa bnC() {
        return this.glb;
    }

    public View bnD() {
        return this.gkU;
    }

    public boolean arx() {
        return this.gla != null && this.gla.isShowing();
    }

    public void aYH() {
        if (this.glb != null) {
            this.glb.release();
        }
        this.gla = null;
        this.glb = null;
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bea);
    }

    public void bnE() {
        if (this.gkS != null) {
            this.gkS.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.fYK.getPageContext(), i);
            al.i(this.mNavigationBar.getBarBgView(), e.d.cp_bg_line_d);
        }
        ap.Ed().c(this.glc, e.f.icon_topbar_return_n_svg, e.d.select_topbar_icon_color_tint);
        ap.Ed().c(this.ant, e.f.icon_topbar_more_n_svg, e.d.select_topbar_icon_color_tint);
        bny();
        if (this.gkX != null) {
            this.gkX.onChangeSkinType(i);
        }
        if (this.gkZ != null) {
            al.i(this.gkZ, e.f.shape_photo_nav_bar_bg);
        }
        al.b(this.gkR, e.d.cp_cont_b, e.d.s_navbar_title_color);
    }

    public void sW(int i) {
        this.mNavigationBar.onChangeSkinType(this.fYK.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(e.f.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.fYK.getResources().getColor(e.d.black_alpha85));
        if (this.anu != null) {
            this.anu.setImageResource(e.f.pb_ala_share);
        }
        if (this.ant != null) {
            this.ant.setImageResource(e.f.icon_vnav_more_bg);
        }
        this.gkR.setTextColor(this.fYK.getResources().getColor(e.d.cp_cont_g));
        this.glc.setImageResource(e.f.icon_return_bg);
    }

    public void bnF() {
        this.glc.setVisibility(0);
        lL(false);
        if (this.gkS != null) {
            this.gkS.setVisibility(8);
        }
        if (this.gkT != null) {
            this.gkT.setVisibility(8);
        }
    }

    public void lK(boolean z) {
        this.glc.setVisibility(0);
        lL(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.gkT != null) {
                this.gkT.setVisibility(0);
            }
            if (this.gkS != null) {
                this.gkS.setVisibility(0);
                return;
            }
            return;
        }
        if (this.gkT != null) {
            this.gkT.setVisibility(8);
        }
        if (this.gkS != null) {
            this.gkS.setVisibility(8);
        }
    }

    public void lL(boolean z) {
        if (!this.ghP && z && !"".equals(this.gkR.getText().toString())) {
            this.gkR.setVisibility(0);
        } else {
            this.gkR.setVisibility(8);
        }
    }

    public void lM(boolean z) {
        this.gld = z;
    }

    public void lN(boolean z) {
        if (!this.gld || TbadkCoreApplication.isLogin() || z) {
            if (z) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("call_fan_guide", false)) {
                    lN(false);
                    return;
                }
            } else if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_share", false)) {
                return;
            }
            this.glf = z;
            View inflate = LayoutInflater.from(this.fYK.getPageContext().getContext()).inflate(e.h.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(e.g.arrow_up);
            TextView textView = (TextView) inflate.findViewById(e.g.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            if (!z) {
                layoutParams.gravity = 5;
                if (!TbadkCoreApplication.isLogin()) {
                    layoutParams.rightMargin = l.h(this.fYK, e.C0210e.ds28);
                } else {
                    layoutParams.rightMargin = l.h(this.fYK, e.C0210e.ds128);
                }
                textView.setText(e.j.share_tip);
                textView.setOnClickListener(this.ehG);
                this.gle = new PopupWindow(inflate, -2, -2);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.ehE);
                com.baidu.adp.lib.g.e.jG().postDelayed(this.ehE, 500L);
            }
        }
    }

    public void bnG() {
        if (this.ehE != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.ehE);
        }
        if (this.ehF != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.ehF);
        }
        aIM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIM() {
        g.a(this.gle);
    }

    public void h(int i, int i2, boolean z) {
        if (i2 != 0 && bnz() != null && this.gkW != null) {
            if (!z) {
                if (this.gkW.getAlpha() != 1.0f) {
                    this.gkW.setAlpha(1.0f);
                }
                if (this.gkX.getAlpha() != 1.0f) {
                    this.gkX.setAlpha(1.0f);
                    return;
                }
                return;
            }
            int measuredHeight = (bnz().getMeasuredHeight() + i2) - 1;
            if (i >= measuredHeight) {
                if (this.gkW.getAlpha() != 0.0f) {
                    this.gkW.setAlpha(0.0f);
                }
                if (this.gkX.getAlpha() != 0.0f) {
                    this.gkX.setAlpha(0.0f);
                }
            } else if (i > bnz().getMeasuredHeight() && i < measuredHeight) {
                float measuredHeight2 = ((i - bnz().getMeasuredHeight()) * 1.0f) / (measuredHeight - bnz().getMeasuredHeight());
                this.gkW.setAlpha(1.0f - measuredHeight2);
                this.gkX.setAlpha(1.0f - measuredHeight2);
            } else if (i <= bnz().getMeasuredHeight()) {
                if (this.gkW.getAlpha() != 1.0f) {
                    this.gkW.setAlpha(1.0f);
                }
                if (this.gkX.getAlpha() != 1.0f) {
                    this.gkX.setAlpha(1.0f);
                }
            }
        }
    }
}
