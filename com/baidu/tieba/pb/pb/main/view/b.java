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
    private ImageView ans;
    private ImageView ant;
    private Runnable bdZ;
    public final View biG;
    private int cxa;
    private PbActivity fYJ;
    public TextView gkQ;
    public View gkR;
    public View gkS;
    private final ImageView gkT;
    private final LinearLayout gkU;
    public FrameLayout gkV;
    public PbNavbarUserConcernView gkW;
    public HeadPendantView gkX;
    public View gkY;
    private ImageView glb;
    private PopupWindow gld;
    private boolean gle;
    private int glf;
    private int glg;
    public final NavigationBar mNavigationBar;
    private boolean ghO = false;
    private com.baidu.tieba.pb.view.b gkZ = null;
    private aa gla = null;
    private boolean glc = false;
    private boolean glh = false;
    private Runnable ehD = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.5
        @Override // java.lang.Runnable
        public void run() {
            View view;
            if (!b.this.ghO) {
                view = b.this.gle ? b.this.gkR : b.this.gkS;
            } else {
                view = b.this.gkS;
            }
            if (view != null) {
                if (TbadkCoreApplication.isLogin() || !b.this.gle) {
                    g.showPopupWindowAsDropDown(b.this.gld, view);
                    if (!b.this.gle) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_share", true);
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("call_fan_guide", true);
                    }
                    e.jG().removeCallbacks(b.this.ehE);
                    e.jG().postDelayed(b.this.ehE, 5000L);
                }
            }
        }
    };
    private Runnable ehE = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.6
        @Override // java.lang.Runnable
        public void run() {
            b.this.aIM();
        }
    };
    private View.OnClickListener ehF = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.bnG();
        }
    };

    public b(PbActivity pbActivity) {
        this.cxa = 0;
        this.glf = 0;
        this.glg = 0;
        this.DS4 = 0;
        this.fYJ = pbActivity;
        this.cxa = l.h(pbActivity, e.C0210e.ds88);
        this.glf = l.h(this.fYJ.getPageContext().getPageActivity(), e.C0210e.ds22);
        this.glg = l.h(this.fYJ.getPageContext().getPageActivity(), e.C0210e.ds14);
        this.DS4 = l.h(this.fYJ.getPageContext().getPageActivity(), e.C0210e.ds4);
        this.mNavigationBar = (NavigationBar) this.fYJ.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.fYJ.aCk();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.biG = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.dNr);
        this.gkQ = this.mNavigationBar.setCenterTextTitle("");
        this.gkT = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.gkU = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int h = l.h(this.fYJ.getPageContext().getPageActivity(), e.C0210e.ds20);
        this.gkU.setPadding(h, 0, h, 0);
        al.a(this.gkT, e.f.icon_pb_play_small, e.f.icon_pb_play_small);
        this.gkT.setVisibility(8);
        this.gkQ.setOnClickListener(pbActivity.dNr);
        this.gkT.setOnClickListener(pbActivity.dNr);
        this.glb = (ImageView) this.biG.findViewById(e.g.widget_navi_back_button);
    }

    public void lG(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.ghO = z;
        if (this.gkS == null && this.ant == null) {
            this.gkS = this.mNavigationBar.addCustomView(controlAlign, e.h.nb_item_floor_share, this.fYJ.dNr);
            this.ant = (ImageView) this.gkS.findViewById(e.g.navigationBarBtnShare);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.cxa, this.cxa);
            layoutParams.rightMargin = this.DS4;
            this.gkS.setLayoutParams(layoutParams);
            bny();
        }
        if (this.gkR == null && this.ans == null) {
            this.gkR = this.mNavigationBar.addCustomView(controlAlign, e.h.nb_item_floor_more, this.fYJ.dNr);
            this.ans = (ImageView) this.gkR.findViewById(e.g.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.cxa, this.cxa);
            layoutParams2.rightMargin = this.glg;
            this.gkR.setLayoutParams(layoutParams2);
            al.a(this.ans, e.f.icon_nav_more_selector, e.f.icon_nav_more_selector);
            this.gkR.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
        if (z) {
            if (this.gkV == null) {
                this.gkV = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.nav_user_concern_layout, (View.OnClickListener) null);
                this.gkW = (PbNavbarUserConcernView) this.gkV.findViewById(e.g.view_add_concern);
                this.gkY = this.gkV.findViewById(e.g.bg_user_photo);
                this.gkX = (HeadPendantView) this.gkV.findViewById(e.g.view_host_pendant_photo);
                this.gkX.setHasPendantStyle();
                if (this.gkX.getHeadView() != null) {
                    this.gkX.getHeadView().setIsRound(true);
                    this.gkX.getHeadView().setDefaultBgResource(e.d.transparent);
                    this.gkX.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.setMargins(this.glf, 0, 0, 0);
                this.gkV.setLayoutParams(layoutParams3);
                this.gkW.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                al.i(this.gkY, e.f.shape_photo_nav_bar_bg);
            }
        } else if (this.gkV != null) {
            this.mNavigationBar.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_LEFT).removeView(this.gkV);
        }
    }

    public void lm(boolean z) {
        if (this.gkR != null) {
            this.gkR.setVisibility(z ? 0 : 8);
        }
    }

    public void lH(boolean z) {
        this.glh = z;
        bny();
    }

    private void bny() {
        if (this.ant != null && this.gkS != null) {
            if (this.glh) {
                if (this.glc) {
                    al.a(this.ant, e.f.icon_topbar_share_white_d, e.f.icon_topbar_share_white_d);
                } else {
                    ap.Ed().c(this.ant, e.f.icon_topbar_share_n_svg, e.d.cp_cont_e);
                }
                this.gkS.setClickable(false);
                return;
            }
            if (this.glc) {
                al.a(this.ant, e.f.pb_ala_share, e.f.pb_ala_share);
            } else {
                ap.Ed().c(this.ant, e.f.icon_topbar_share_n_svg, e.d.select_topbar_icon_color_tint);
            }
            this.gkS.setClickable(true);
        }
    }

    public void lI(boolean z) {
        if (this.gkS != null && !z) {
            this.gkS.setVisibility(8);
        }
    }

    public NavigationBar bnz() {
        return this.mNavigationBar;
    }

    public void lJ(boolean z) {
        if (z) {
            this.biG.setVisibility(0);
        } else {
            this.biG.setVisibility(8);
        }
        lL(z);
    }

    public void rn(String str) {
        if (!TextUtils.isEmpty(str) && !this.ghO) {
            this.gkQ.setText(this.fYJ.getResources().getString(e.j.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            lL(true);
            i.xR().ej(str);
            return;
        }
        lL(false);
    }

    public void a(MetaData metaData, View.OnClickListener onClickListener) {
        if (metaData != null) {
            this.gkX.getHeadView().setImageDrawable(null);
            this.gkX.getPendantView().setImageDrawable(null);
            this.gkX.b(metaData);
            this.gkX.getHeadView().startLoad(metaData.getPortrait(), 28, false);
            this.gkX.getHeadView().setUserId(metaData.getUserId());
            this.gkX.getHeadView().setUserName(metaData.getUserName());
            this.gkX.getHeadView().setOnClickListener(onClickListener);
        }
    }

    public void a(ab abVar) {
        if (!this.fYJ.isProgressBarShown()) {
            if (this.gkZ == null) {
                this.gla = new aa((PbActivity) this.fYJ.getPageContext().getOrignalPage(), this.fYJ.dNr);
                this.gkZ = new com.baidu.tieba.pb.view.b(this.fYJ.getPageContext().getPageActivity(), this.gla.getView(), al.getDrawable(e.f.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.pb.pb.main.view.b.2
                    @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                    public void xq() {
                        b.this.fYJ.bjf();
                    }

                    @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                    public void xr() {
                    }
                });
            }
            this.gla.blD();
            if (this.glc) {
                final Rect rect = new Rect();
                if (this.fYJ.fXc) {
                    com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.3
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.fYJ.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                            int height = b.this.fYJ.getWindow().getDecorView().getHeight();
                            b.this.gkZ.setClippingEnabled(false);
                            b.this.gkZ.showAtLocation(b.this.fYJ.findViewById(e.g.pb_layout), 81, 0, height - rect.bottom);
                        }
                    }, 500L);
                } else {
                    this.fYJ.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    int height = this.fYJ.getWindow().getDecorView().getHeight();
                    this.gkZ.setClippingEnabled(false);
                    this.gkZ.showAtLocation(this.fYJ.findViewById(e.g.pb_layout), 81, 0, height - rect.bottom);
                }
            } else {
                this.gkZ.showAtLocation(this.fYJ.findViewById(e.g.pb_layout), 17, 0, 0);
            }
            this.gla.lc(abVar == null ? false : abVar.gdO);
            this.gla.le(abVar == null ? false : abVar.gdT);
            this.gla.lf(abVar == null ? false : abVar.gdU);
            this.gla.lg(abVar == null ? false : abVar.gdV);
            this.gla.lh(abVar == null ? true : abVar.gec);
            if (abVar == null) {
                this.gla.O(false, false);
                this.gla.P(false, false);
                this.gla.q(false, "");
            } else {
                this.gla.O(abVar.gdR, abVar.gdZ);
                this.gla.P(abVar.gdS, abVar.gdY);
                this.gla.q(StringUtils.isNull(abVar.geb) ? false : true, abVar.geb);
            }
            boolean z = abVar == null ? false : abVar.qZ;
            boolean z2 = abVar == null ? false : abVar.fUH;
            boolean z3 = abVar == null ? false : abVar.isHostOnly;
            boolean z4 = abVar == null ? false : abVar.gea;
            boolean z5 = abVar == null ? false : abVar.gdQ;
            boolean z6 = abVar == null ? false : abVar.gdW;
            boolean z7 = abVar == null ? false : abVar.gdX;
            this.gla.ld(abVar == null ? false : abVar.gdP);
            this.gla.N(z4, z3);
            this.gla.Q(z5, z);
            this.gla.R(z7, z6);
            if (abVar != null) {
                this.gla.gdK = abVar.ged;
                if (abVar.ged) {
                    this.gla.blw().setText(e.j.report_text);
                    this.gla.lg(false);
                }
            }
            h(z, z2, z3);
        }
    }

    public void bnA() {
        this.gla.blC().setText(this.fYJ.getResources().getString(e.j.haved_fans_call));
    }

    private void h(boolean z, boolean z2, boolean z3) {
        if (this.gla != null) {
            this.gla.setBackGround();
            if (z) {
                this.gla.blj().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_recommend_reversed_down_selector), (Drawable) null, (Drawable) null);
            } else {
                this.gla.blj().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
            }
            if (z2) {
                this.gla.blj().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.gla.blj().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
            if (z3) {
                this.gla.blu().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_host_only_selector), (Drawable) null, (Drawable) null);
            } else {
                this.gla.blu().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void dismissPopMenu() {
        if (this.gla != null) {
            this.gla.blE();
        }
        if (this.bdZ == null) {
            this.bdZ = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.4
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.gkZ != null) {
                        g.a(b.this.gkZ, b.this.fYJ.getPageContext().getPageActivity());
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.jG().postDelayed(this.bdZ, 100L);
    }

    public void bnB() {
        if (this.gla != null) {
            this.gla.blE();
        }
        if (this.gkZ != null) {
            g.a(this.gkZ, this.fYJ.getPageContext().getPageActivity());
        }
    }

    public aa bnC() {
        return this.gla;
    }

    public View bnD() {
        return this.gkT;
    }

    public boolean arx() {
        return this.gkZ != null && this.gkZ.isShowing();
    }

    public void aYH() {
        if (this.gla != null) {
            this.gla.release();
        }
        this.gkZ = null;
        this.gla = null;
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bdZ);
    }

    public void bnE() {
        if (this.gkR != null) {
            this.gkR.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.fYJ.getPageContext(), i);
            al.i(this.mNavigationBar.getBarBgView(), e.d.cp_bg_line_d);
        }
        ap.Ed().c(this.glb, e.f.icon_topbar_return_n_svg, e.d.select_topbar_icon_color_tint);
        ap.Ed().c(this.ans, e.f.icon_topbar_more_n_svg, e.d.select_topbar_icon_color_tint);
        bny();
        if (this.gkW != null) {
            this.gkW.onChangeSkinType(i);
        }
        if (this.gkY != null) {
            al.i(this.gkY, e.f.shape_photo_nav_bar_bg);
        }
        al.b(this.gkQ, e.d.cp_cont_b, e.d.s_navbar_title_color);
    }

    public void sW(int i) {
        this.mNavigationBar.onChangeSkinType(this.fYJ.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(e.f.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.fYJ.getResources().getColor(e.d.black_alpha85));
        if (this.ant != null) {
            this.ant.setImageResource(e.f.pb_ala_share);
        }
        if (this.ans != null) {
            this.ans.setImageResource(e.f.icon_vnav_more_bg);
        }
        this.gkQ.setTextColor(this.fYJ.getResources().getColor(e.d.cp_cont_g));
        this.glb.setImageResource(e.f.icon_return_bg);
    }

    public void bnF() {
        this.glb.setVisibility(0);
        lL(false);
        if (this.gkR != null) {
            this.gkR.setVisibility(8);
        }
        if (this.gkS != null) {
            this.gkS.setVisibility(8);
        }
    }

    public void lK(boolean z) {
        this.glb.setVisibility(0);
        lL(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.gkS != null) {
                this.gkS.setVisibility(0);
            }
            if (this.gkR != null) {
                this.gkR.setVisibility(0);
                return;
            }
            return;
        }
        if (this.gkS != null) {
            this.gkS.setVisibility(8);
        }
        if (this.gkR != null) {
            this.gkR.setVisibility(8);
        }
    }

    public void lL(boolean z) {
        if (!this.ghO && z && !"".equals(this.gkQ.getText().toString())) {
            this.gkQ.setVisibility(0);
        } else {
            this.gkQ.setVisibility(8);
        }
    }

    public void lM(boolean z) {
        this.glc = z;
    }

    public void lN(boolean z) {
        if (!this.glc || TbadkCoreApplication.isLogin() || z) {
            if (z) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("call_fan_guide", false)) {
                    lN(false);
                    return;
                }
            } else if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_share", false)) {
                return;
            }
            this.gle = z;
            View inflate = LayoutInflater.from(this.fYJ.getPageContext().getContext()).inflate(e.h.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(e.g.arrow_up);
            TextView textView = (TextView) inflate.findViewById(e.g.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            if (!z) {
                layoutParams.gravity = 5;
                if (!TbadkCoreApplication.isLogin()) {
                    layoutParams.rightMargin = l.h(this.fYJ, e.C0210e.ds28);
                } else {
                    layoutParams.rightMargin = l.h(this.fYJ, e.C0210e.ds128);
                }
                textView.setText(e.j.share_tip);
                textView.setOnClickListener(this.ehF);
                this.gld = new PopupWindow(inflate, -2, -2);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.ehD);
                com.baidu.adp.lib.g.e.jG().postDelayed(this.ehD, 500L);
            }
        }
    }

    public void bnG() {
        if (this.ehD != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.ehD);
        }
        if (this.ehE != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.ehE);
        }
        aIM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIM() {
        g.a(this.gld);
    }

    public void h(int i, int i2, boolean z) {
        if (i2 != 0 && bnz() != null && this.gkV != null) {
            if (!z) {
                if (this.gkV.getAlpha() != 1.0f) {
                    this.gkV.setAlpha(1.0f);
                }
                if (this.gkW.getAlpha() != 1.0f) {
                    this.gkW.setAlpha(1.0f);
                    return;
                }
                return;
            }
            int measuredHeight = (bnz().getMeasuredHeight() + i2) - 1;
            if (i >= measuredHeight) {
                if (this.gkV.getAlpha() != 0.0f) {
                    this.gkV.setAlpha(0.0f);
                }
                if (this.gkW.getAlpha() != 0.0f) {
                    this.gkW.setAlpha(0.0f);
                }
            } else if (i > bnz().getMeasuredHeight() && i < measuredHeight) {
                float measuredHeight2 = ((i - bnz().getMeasuredHeight()) * 1.0f) / (measuredHeight - bnz().getMeasuredHeight());
                this.gkV.setAlpha(1.0f - measuredHeight2);
                this.gkW.setAlpha(1.0f - measuredHeight2);
            } else if (i <= bnz().getMeasuredHeight()) {
                if (this.gkV.getAlpha() != 1.0f) {
                    this.gkV.setAlpha(1.0f);
                }
                if (this.gkW.getAlpha() != 1.0f) {
                    this.gkW.setAlpha(1.0f);
                }
            }
        }
    }
}
