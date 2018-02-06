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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.aa;
import com.baidu.tieba.pb.pb.main.z;
import com.baidu.tieba.pb.view.f;
/* loaded from: classes2.dex */
public class c {
    private int DS4;
    private ImageView aIh;
    private ImageView aIi;
    public final View bCC;
    private Runnable bxG;
    private PbActivity fNb;
    public TextView fYJ;
    public View fYK;
    public View fYL;
    private final ImageView fYM;
    private final LinearLayout fYN;
    public FrameLayout fYO;
    public PbNavbarUserConcernView fYP;
    public HeadPendantView fYQ;
    public View fYR;
    private ImageView fYU;
    private PopupWindow fYW;
    private boolean fYX;
    private int fYY;
    private int fYZ;
    private int fZa;
    public final NavigationBar mNavigationBar;
    private boolean fVO = false;
    private f fYS = null;
    private z fYT = null;
    private boolean fYV = false;
    private boolean fZb = false;
    private Runnable fZc = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.5
        @Override // java.lang.Runnable
        public void run() {
            View view;
            if (!c.this.fVO) {
                view = c.this.fYX ? c.this.fYK : c.this.fYL;
            } else {
                view = c.this.fYL;
            }
            if (view != null) {
                if (TbadkCoreApplication.isLogin() || !c.this.fYX) {
                    g.showPopupWindowAsDropDown(c.this.fYW, view);
                    if (!c.this.fYX) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_share", true);
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("call_fan_guide", true);
                    }
                    e.ns().removeCallbacks(c.this.fZd);
                    e.ns().postDelayed(c.this.fZd, TbConfig.NOTIFY_SOUND_INTERVAL);
                }
            }
        }
    };
    private Runnable fZd = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.6
        @Override // java.lang.Runnable
        public void run() {
            c.this.bgp();
        }
    };
    private View.OnClickListener fZe = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.bgo();
        }
    };

    public c(PbActivity pbActivity) {
        this.fYY = 0;
        this.fYZ = 0;
        this.fZa = 0;
        this.DS4 = 0;
        this.fNb = pbActivity;
        this.fYY = l.t(pbActivity, d.e.ds88);
        this.fYZ = l.t(this.fNb.getPageContext().getPageActivity(), d.e.ds22);
        this.fZa = l.t(this.fNb.getPageContext().getPageActivity(), d.e.ds14);
        this.DS4 = l.t(this.fNb.getPageContext().getPageActivity(), d.e.ds4);
        this.mNavigationBar = (NavigationBar) this.fNb.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.fNb.avj();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.bCC = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.dGd);
        this.fYJ = this.mNavigationBar.setCenterTextTitle("");
        this.fYM = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.fYN = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int t = l.t(this.fNb.getPageContext().getPageActivity(), d.e.ds20);
        this.fYN.setPadding(t, 0, t, 0);
        aj.a(this.fYM, d.f.icon_pb_play_small, d.f.icon_pb_play_small);
        this.fYM.setVisibility(8);
        this.fYJ.setOnClickListener(pbActivity.dGd);
        this.fYM.setOnClickListener(pbActivity.dGd);
        this.fYU = (ImageView) this.bCC.findViewById(d.g.widget_navi_back_button);
    }

    public void kV(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.fVO = z;
        if (this.fYL == null && this.aIi == null) {
            this.fYL = this.mNavigationBar.addCustomView(controlAlign, d.h.nb_item_floor_share, this.fNb.dGd);
            this.aIi = (ImageView) this.fYL.findViewById(d.g.navigationBarBtnShare);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.fYY, this.fYY);
            layoutParams.rightMargin = this.DS4;
            this.fYL.setLayoutParams(layoutParams);
            bgg();
        }
        if (this.fYK == null && this.aIh == null) {
            this.fYK = this.mNavigationBar.addCustomView(controlAlign, d.h.nb_item_floor_more, this.fNb.dGd);
            this.aIh = (ImageView) this.fYK.findViewById(d.g.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.fYY, this.fYY);
            layoutParams2.rightMargin = this.fZa;
            this.fYK.setLayoutParams(layoutParams2);
            aj.a(this.aIh, d.f.icon_nav_more_selector, d.f.icon_nav_more_selector);
            this.fYK.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
        if (z) {
            if (this.fYO == null) {
                this.fYO = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.nav_user_concern_layout, (View.OnClickListener) null);
                this.fYP = (PbNavbarUserConcernView) this.fYO.findViewById(d.g.view_add_concern);
                this.fYR = this.fYO.findViewById(d.g.bg_user_photo);
                this.fYQ = (HeadPendantView) this.fYO.findViewById(d.g.view_host_pendant_photo);
                this.fYQ.DT();
                if (this.fYQ.getHeadView() != null) {
                    this.fYQ.getHeadView().setIsRound(true);
                    this.fYQ.getHeadView().setDefaultBgResource(d.C0140d.transparent);
                    this.fYQ.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.setMargins(this.fYZ, 0, 0, 0);
                this.fYO.setLayoutParams(layoutParams3);
                this.fYP.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                aj.s(this.fYR, d.f.shape_photo_nav_bar_bg);
            }
        } else if (this.fYO != null) {
            this.mNavigationBar.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_LEFT).removeView(this.fYO);
        }
    }

    public void kD(boolean z) {
        if (this.fYK != null) {
            this.fYK.setVisibility(z ? 0 : 8);
        }
    }

    public void kW(boolean z) {
        this.fZb = z;
        bgg();
    }

    private void bgg() {
        if (this.aIi != null && this.fYL != null) {
            if (this.fZb) {
                if (this.fYV) {
                    aj.a(this.aIi, d.f.icon_topbar_share_white_d, d.f.icon_topbar_share_white_d);
                } else {
                    an.Dd().c(this.aIi, d.f.icon_topbar_share_n_svg, d.C0140d.cp_cont_e);
                }
                this.fYL.setClickable(false);
                return;
            }
            if (this.fYV) {
                aj.a(this.aIi, d.f.pb_ala_share, d.f.pb_ala_share);
            } else {
                an.Dd().c(this.aIi, d.f.icon_topbar_share_n_svg, d.f.select_topbar_icon_color_tint);
            }
            this.fYL.setClickable(true);
        }
    }

    public void kX(boolean z) {
        if (this.fYL != null && !z) {
            this.fYL.setVisibility(8);
        }
    }

    public NavigationBar bgh() {
        return this.mNavigationBar;
    }

    public void kY(boolean z) {
        if (z) {
            this.bCC.setVisibility(0);
        } else {
            this.bCC.setVisibility(8);
        }
        la(z);
    }

    public void ol(String str) {
        if (!TextUtils.isEmpty(str) && !this.fVO) {
            this.fYJ.setText(this.fNb.getResources().getString(d.j.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            la(true);
            i.xo().cK(str);
            return;
        }
        la(false);
    }

    public void a(MetaData metaData, View.OnClickListener onClickListener) {
        if (metaData != null) {
            UtilHelper.showHeadImageViewBigV(this.fYQ.getHeadView(), metaData);
            this.fYQ.getHeadView().setImageDrawable(null);
            this.fYQ.getPendantView().setImageDrawable(null);
            this.fYQ.getHeadView().startLoad(metaData.getPortrait(), 28, false);
            this.fYQ.getHeadView().setUserId(metaData.getUserId());
            this.fYQ.getHeadView().setUserName(metaData.getUserName());
            this.fYQ.getHeadView().setOnClickListener(onClickListener);
            if (metaData.getPendantData() != null && !StringUtils.isNull(metaData.getPendantData().ya())) {
                this.fYQ.eS(metaData.getPendantData().ya());
            } else {
                this.fYQ.eS(null);
            }
        }
    }

    public void a(aa aaVar) {
        if (!this.fNb.isProgressBarShown()) {
            if (this.fYS == null) {
                this.fYT = new z((PbActivity) this.fNb.getPageContext().getOrignalPage(), this.fNb.dGd);
                this.fYS = new f(this.fNb.getPageContext().getPageActivity(), this.fYT.getView(), aj.getDrawable(d.f.bg_pull_down_right_n), new f.a() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                    @Override // com.baidu.tbadk.core.view.f.a
                    public void wK() {
                        c.this.fNb.bbZ();
                    }

                    @Override // com.baidu.tbadk.core.view.f.a
                    public void wL() {
                    }
                });
            }
            this.fYT.bes();
            if (this.fYV) {
                final Rect rect = new Rect();
                if (this.fNb.fLt) {
                    e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.fNb.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                            int height = c.this.fNb.getWindow().getDecorView().getHeight();
                            c.this.fYS.setClippingEnabled(false);
                            c.this.fYS.showAtLocation(c.this.fNb.findViewById(d.g.pb_layout), 81, 0, height - rect.bottom);
                        }
                    }, 500L);
                } else {
                    this.fNb.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    int height = this.fNb.getWindow().getDecorView().getHeight();
                    this.fYS.setClippingEnabled(false);
                    this.fYS.showAtLocation(this.fNb.findViewById(d.g.pb_layout), 81, 0, height - rect.bottom);
                }
            } else {
                this.fYS.showAtLocation(this.fNb.findViewById(d.g.pb_layout), 17, 0, 0);
            }
            this.fYT.ks(aaVar == null ? false : aaVar.fRN);
            this.fYT.ku(aaVar == null ? false : aaVar.fRT);
            this.fYT.kv(aaVar == null ? false : aaVar.fRU);
            this.fYT.kw(aaVar == null ? false : aaVar.fRV);
            this.fYT.kx(aaVar == null ? true : aaVar.fSc);
            if (aaVar == null) {
                this.fYT.L(false, false);
                this.fYT.M(false, false);
                this.fYT.k(false, "");
            } else {
                this.fYT.L(aaVar.fRR, aaVar.fRZ);
                this.fYT.M(aaVar.fRS, aaVar.fRY);
                this.fYT.k(StringUtils.isNull(aaVar.fSb) ? false : true, aaVar.fSb);
            }
            boolean z = aaVar == null ? false : aaVar.fRP;
            boolean z2 = aaVar == null ? false : aaVar.fIn;
            boolean z3 = aaVar == null ? false : aaVar.isHostOnly;
            boolean z4 = aaVar == null ? false : aaVar.fSa;
            boolean z5 = aaVar == null ? false : aaVar.fRQ;
            boolean z6 = aaVar == null ? false : aaVar.fRW;
            boolean z7 = aaVar == null ? false : aaVar.fRX;
            this.fYT.kt(aaVar == null ? false : aaVar.fRO);
            this.fYT.K(z4, z3);
            this.fYT.N(z5, z);
            this.fYT.O(z7, z6);
            if (aaVar != null) {
                this.fYT.fRJ = aaVar.fSd;
                if (aaVar.fSd) {
                    this.fYT.bel().setText(d.j.report_text);
                    this.fYT.kw(false);
                }
            }
            j(z, z2, z3);
        }
    }

    public void bgi() {
        this.fYT.ber().setText(this.fNb.getResources().getString(d.j.haved_fans_call));
    }

    private void j(boolean z, boolean z2, boolean z3) {
        if (this.fYT != null) {
            this.fYT.amI();
            if (z) {
                this.fYT.bdY().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_recommend_reversed_down_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fYT.bdY().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
            }
            if (z2) {
                this.fYT.bdY().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fYT.bdY().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
            if (z3) {
                this.fYT.bej().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_host_only_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fYT.bej().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void wH() {
        if (this.fYT != null) {
            this.fYT.bet();
        }
        if (this.bxG == null) {
            this.bxG = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.fYS != null) {
                        g.a(c.this.fYS, c.this.fNb.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.ns().postDelayed(this.bxG, 100L);
    }

    public void bgj() {
        if (this.fYT != null) {
            this.fYT.bet();
        }
        if (this.fYS != null) {
            g.a(this.fYS, this.fNb.getPageContext().getPageActivity());
        }
    }

    public z bgk() {
        return this.fYT;
    }

    public View bgl() {
        return this.fYM;
    }

    public boolean amf() {
        return this.fYS != null && this.fYS.isShowing();
    }

    public void aPc() {
        if (this.fYT != null) {
            this.fYT.release();
        }
        this.fYS = null;
        this.fYT = null;
        e.ns().removeCallbacks(this.bxG);
    }

    public void bgm() {
        if (this.fYK != null) {
            this.fYK.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.fNb.getPageContext(), i);
            aj.s(this.mNavigationBar.getBarBgView(), d.C0140d.cp_bg_line_d);
        }
        an.Dd().c(this.fYU, d.f.icon_topbar_return_n_svg, d.f.select_topbar_icon_color_tint);
        an.Dd().c(this.aIh, d.f.icon_topbar_more_n_svg, d.f.select_topbar_icon_color_tint);
        bgg();
        if (this.fYP != null) {
            this.fYP.onChangeSkinType(i);
        }
        if (this.fYR != null) {
            aj.s(this.fYR, d.f.shape_photo_nav_bar_bg);
        }
        aj.d(this.fYJ, d.C0140d.cp_cont_b, d.C0140d.s_navbar_title_color);
    }

    public void tj(int i) {
        this.mNavigationBar.onChangeSkinType(this.fNb.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(d.f.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.fNb.getResources().getColor(d.C0140d.black_alpha85));
        if (this.aIi != null) {
            this.aIi.setImageResource(d.f.pb_ala_share);
        }
        if (this.aIh != null) {
            this.aIh.setImageResource(d.f.icon_vnav_more_bg);
        }
        this.fYJ.setTextColor(this.fNb.getResources().getColor(d.C0140d.cp_cont_g));
        this.fYU.setImageResource(d.f.icon_return_bg);
    }

    public void bgn() {
        this.fYU.setVisibility(0);
        la(false);
        if (this.fYK != null) {
            this.fYK.setVisibility(8);
        }
        if (this.fYL != null) {
            this.fYL.setVisibility(8);
        }
    }

    public void kZ(boolean z) {
        this.fYU.setVisibility(0);
        la(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.fYL != null) {
                this.fYL.setVisibility(0);
            }
            if (this.fYK != null) {
                this.fYK.setVisibility(0);
                return;
            }
            return;
        }
        if (this.fYL != null) {
            this.fYL.setVisibility(8);
        }
        if (this.fYK != null) {
            this.fYK.setVisibility(8);
        }
    }

    public void la(boolean z) {
        if (!this.fVO && z && !"".equals(this.fYJ.getText().toString())) {
            this.fYJ.setVisibility(0);
        } else {
            this.fYJ.setVisibility(8);
        }
    }

    public void lb(boolean z) {
        this.fYV = z;
    }

    public void lc(boolean z) {
        if (!this.fYV || TbadkCoreApplication.isLogin() || z) {
            if (z) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("call_fan_guide", false)) {
                    lc(false);
                    return;
                }
            } else if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_share", false)) {
                return;
            }
            this.fYX = z;
            View inflate = LayoutInflater.from(this.fNb.getPageContext().getContext()).inflate(d.h.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(d.g.arrow_up);
            TextView textView = (TextView) inflate.findViewById(d.g.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            if (!z) {
                layoutParams.gravity = 5;
                if (!TbadkCoreApplication.isLogin()) {
                    layoutParams.rightMargin = l.t(this.fNb, d.e.ds28);
                } else {
                    layoutParams.rightMargin = l.t(this.fNb, d.e.ds128);
                }
                textView.setText(d.j.share_tip);
                textView.setOnClickListener(this.fZe);
                this.fYW = new PopupWindow(inflate, -2, -2);
                e.ns().removeCallbacks(this.fZc);
                e.ns().postDelayed(this.fZc, 500L);
            }
        }
    }

    public void bgo() {
        if (this.fZc != null) {
            e.ns().removeCallbacks(this.fZc);
        }
        if (this.fZd != null) {
            e.ns().removeCallbacks(this.fZd);
        }
        bgp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgp() {
        g.b(this.fYW);
    }

    public void j(int i, int i2, boolean z) {
        if (i2 != 0 && bgh() != null && this.fYO != null) {
            if (!z) {
                if (this.fYO.getAlpha() != 1.0f) {
                    this.fYO.setAlpha(1.0f);
                    return;
                }
                return;
            }
            int measuredHeight = (bgh().getMeasuredHeight() + i2) - 1;
            if (i >= measuredHeight) {
                if (this.fYO.getAlpha() != 0.0f) {
                    this.fYO.setAlpha(0.0f);
                }
            } else if (i > bgh().getMeasuredHeight() && i < measuredHeight) {
                this.fYO.setAlpha(1.0f - (((i - bgh().getMeasuredHeight()) * 1.0f) / (measuredHeight - bgh().getMeasuredHeight())));
            } else if (i <= bgh().getMeasuredHeight() && this.fYO.getAlpha() != 1.0f) {
                this.fYO.setAlpha(1.0f);
            }
        }
    }
}
