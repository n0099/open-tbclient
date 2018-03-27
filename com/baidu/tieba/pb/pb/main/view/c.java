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
    private ImageView aHX;
    private ImageView aHY;
    public final View bCs;
    private Runnable bxw;
    private PbActivity fNg;
    public TextView fYO;
    public View fYP;
    public View fYQ;
    private final ImageView fYR;
    private final LinearLayout fYS;
    public FrameLayout fYT;
    public PbNavbarUserConcernView fYU;
    public HeadPendantView fYV;
    public View fYW;
    private ImageView fYZ;
    private PopupWindow fZb;
    private boolean fZc;
    private int fZd;
    private int fZe;
    private int fZf;
    public final NavigationBar mNavigationBar;
    private boolean fVT = false;
    private f fYX = null;
    private z fYY = null;
    private boolean fZa = false;
    private boolean fZg = false;
    private Runnable fZh = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.5
        @Override // java.lang.Runnable
        public void run() {
            View view;
            if (!c.this.fVT) {
                view = c.this.fZc ? c.this.fYP : c.this.fYQ;
            } else {
                view = c.this.fYQ;
            }
            if (view != null) {
                if (TbadkCoreApplication.isLogin() || !c.this.fZc) {
                    g.showPopupWindowAsDropDown(c.this.fZb, view);
                    if (!c.this.fZc) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_share", true);
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("call_fan_guide", true);
                    }
                    e.ns().removeCallbacks(c.this.fZi);
                    e.ns().postDelayed(c.this.fZi, TbConfig.NOTIFY_SOUND_INTERVAL);
                }
            }
        }
    };
    private Runnable fZi = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.6
        @Override // java.lang.Runnable
        public void run() {
            c.this.bgp();
        }
    };
    private View.OnClickListener fZj = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.bgo();
        }
    };

    public c(PbActivity pbActivity) {
        this.fZd = 0;
        this.fZe = 0;
        this.fZf = 0;
        this.DS4 = 0;
        this.fNg = pbActivity;
        this.fZd = l.t(pbActivity, d.e.ds88);
        this.fZe = l.t(this.fNg.getPageContext().getPageActivity(), d.e.ds22);
        this.fZf = l.t(this.fNg.getPageContext().getPageActivity(), d.e.ds14);
        this.DS4 = l.t(this.fNg.getPageContext().getPageActivity(), d.e.ds4);
        this.mNavigationBar = (NavigationBar) this.fNg.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.fNg.avj();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.bCs = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.dFV);
        this.fYO = this.mNavigationBar.setCenterTextTitle("");
        this.fYR = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.fYS = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int t = l.t(this.fNg.getPageContext().getPageActivity(), d.e.ds20);
        this.fYS.setPadding(t, 0, t, 0);
        aj.a(this.fYR, d.f.icon_pb_play_small, d.f.icon_pb_play_small);
        this.fYR.setVisibility(8);
        this.fYO.setOnClickListener(pbActivity.dFV);
        this.fYR.setOnClickListener(pbActivity.dFV);
        this.fYZ = (ImageView) this.bCs.findViewById(d.g.widget_navi_back_button);
    }

    public void la(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.fVT = z;
        if (this.fYQ == null && this.aHY == null) {
            this.fYQ = this.mNavigationBar.addCustomView(controlAlign, d.h.nb_item_floor_share, this.fNg.dFV);
            this.aHY = (ImageView) this.fYQ.findViewById(d.g.navigationBarBtnShare);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.fZd, this.fZd);
            layoutParams.rightMargin = this.DS4;
            this.fYQ.setLayoutParams(layoutParams);
            bgg();
        }
        if (this.fYP == null && this.aHX == null) {
            this.fYP = this.mNavigationBar.addCustomView(controlAlign, d.h.nb_item_floor_more, this.fNg.dFV);
            this.aHX = (ImageView) this.fYP.findViewById(d.g.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.fZd, this.fZd);
            layoutParams2.rightMargin = this.fZf;
            this.fYP.setLayoutParams(layoutParams2);
            aj.a(this.aHX, d.f.icon_nav_more_selector, d.f.icon_nav_more_selector);
            this.fYP.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
        if (z) {
            if (this.fYT == null) {
                this.fYT = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.nav_user_concern_layout, (View.OnClickListener) null);
                this.fYU = (PbNavbarUserConcernView) this.fYT.findViewById(d.g.view_add_concern);
                this.fYW = this.fYT.findViewById(d.g.bg_user_photo);
                this.fYV = (HeadPendantView) this.fYT.findViewById(d.g.view_host_pendant_photo);
                this.fYV.DT();
                if (this.fYV.getHeadView() != null) {
                    this.fYV.getHeadView().setIsRound(true);
                    this.fYV.getHeadView().setDefaultBgResource(d.C0141d.transparent);
                    this.fYV.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.setMargins(this.fZe, 0, 0, 0);
                this.fYT.setLayoutParams(layoutParams3);
                this.fYU.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                aj.s(this.fYW, d.f.shape_photo_nav_bar_bg);
            }
        } else if (this.fYT != null) {
            this.mNavigationBar.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_LEFT).removeView(this.fYT);
        }
    }

    public void kI(boolean z) {
        if (this.fYP != null) {
            this.fYP.setVisibility(z ? 0 : 8);
        }
    }

    public void lb(boolean z) {
        this.fZg = z;
        bgg();
    }

    private void bgg() {
        if (this.aHY != null && this.fYQ != null) {
            if (this.fZg) {
                if (this.fZa) {
                    aj.a(this.aHY, d.f.icon_topbar_share_white_d, d.f.icon_topbar_share_white_d);
                } else {
                    an.Dd().c(this.aHY, d.f.icon_topbar_share_n_svg, d.C0141d.cp_cont_e);
                }
                this.fYQ.setClickable(false);
                return;
            }
            if (this.fZa) {
                aj.a(this.aHY, d.f.pb_ala_share, d.f.pb_ala_share);
            } else {
                an.Dd().c(this.aHY, d.f.icon_topbar_share_n_svg, d.f.select_topbar_icon_color_tint);
            }
            this.fYQ.setClickable(true);
        }
    }

    public void lc(boolean z) {
        if (this.fYQ != null && !z) {
            this.fYQ.setVisibility(8);
        }
    }

    public NavigationBar bgh() {
        return this.mNavigationBar;
    }

    public void ld(boolean z) {
        if (z) {
            this.bCs.setVisibility(0);
        } else {
            this.bCs.setVisibility(8);
        }
        lf(z);
    }

    public void ol(String str) {
        if (!TextUtils.isEmpty(str) && !this.fVT) {
            this.fYO.setText(this.fNg.getResources().getString(d.j.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            lf(true);
            i.xo().cK(str);
            return;
        }
        lf(false);
    }

    public void a(MetaData metaData, View.OnClickListener onClickListener) {
        if (metaData != null) {
            UtilHelper.showHeadImageViewBigV(this.fYV.getHeadView(), metaData);
            this.fYV.getHeadView().setImageDrawable(null);
            this.fYV.getPendantView().setImageDrawable(null);
            this.fYV.getHeadView().startLoad(metaData.getPortrait(), 28, false);
            this.fYV.getHeadView().setUserId(metaData.getUserId());
            this.fYV.getHeadView().setUserName(metaData.getUserName());
            this.fYV.getHeadView().setOnClickListener(onClickListener);
            if (metaData.getPendantData() != null && !StringUtils.isNull(metaData.getPendantData().ya())) {
                this.fYV.eS(metaData.getPendantData().ya());
            } else {
                this.fYV.eS(null);
            }
        }
    }

    public void a(aa aaVar) {
        if (!this.fNg.isProgressBarShown()) {
            if (this.fYX == null) {
                this.fYY = new z((PbActivity) this.fNg.getPageContext().getOrignalPage(), this.fNg.dFV);
                this.fYX = new f(this.fNg.getPageContext().getPageActivity(), this.fYY.getView(), aj.getDrawable(d.f.bg_pull_down_right_n), new f.a() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                    @Override // com.baidu.tbadk.core.view.f.a
                    public void wK() {
                        c.this.fNg.bbZ();
                    }

                    @Override // com.baidu.tbadk.core.view.f.a
                    public void wL() {
                    }
                });
            }
            this.fYY.bes();
            if (this.fZa) {
                final Rect rect = new Rect();
                if (this.fNg.fLy) {
                    e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.fNg.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                            int height = c.this.fNg.getWindow().getDecorView().getHeight();
                            c.this.fYX.setClippingEnabled(false);
                            c.this.fYX.showAtLocation(c.this.fNg.findViewById(d.g.pb_layout), 81, 0, height - rect.bottom);
                        }
                    }, 500L);
                } else {
                    this.fNg.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    int height = this.fNg.getWindow().getDecorView().getHeight();
                    this.fYX.setClippingEnabled(false);
                    this.fYX.showAtLocation(this.fNg.findViewById(d.g.pb_layout), 81, 0, height - rect.bottom);
                }
            } else {
                this.fYX.showAtLocation(this.fNg.findViewById(d.g.pb_layout), 17, 0, 0);
            }
            this.fYY.kx(aaVar == null ? false : aaVar.fRS);
            this.fYY.kz(aaVar == null ? false : aaVar.fRY);
            this.fYY.kA(aaVar == null ? false : aaVar.fRZ);
            this.fYY.kB(aaVar == null ? false : aaVar.fSa);
            this.fYY.kC(aaVar == null ? true : aaVar.fSh);
            if (aaVar == null) {
                this.fYY.L(false, false);
                this.fYY.M(false, false);
                this.fYY.k(false, "");
            } else {
                this.fYY.L(aaVar.fRW, aaVar.fSe);
                this.fYY.M(aaVar.fRX, aaVar.fSd);
                this.fYY.k(StringUtils.isNull(aaVar.fSg) ? false : true, aaVar.fSg);
            }
            boolean z = aaVar == null ? false : aaVar.fRU;
            boolean z2 = aaVar == null ? false : aaVar.fIs;
            boolean z3 = aaVar == null ? false : aaVar.isHostOnly;
            boolean z4 = aaVar == null ? false : aaVar.fSf;
            boolean z5 = aaVar == null ? false : aaVar.fRV;
            boolean z6 = aaVar == null ? false : aaVar.fSb;
            boolean z7 = aaVar == null ? false : aaVar.fSc;
            this.fYY.ky(aaVar == null ? false : aaVar.fRT);
            this.fYY.K(z4, z3);
            this.fYY.N(z5, z);
            this.fYY.O(z7, z6);
            if (aaVar != null) {
                this.fYY.fRO = aaVar.fSi;
                if (aaVar.fSi) {
                    this.fYY.bel().setText(d.j.report_text);
                    this.fYY.kB(false);
                }
            }
            j(z, z2, z3);
        }
    }

    public void bgi() {
        this.fYY.ber().setText(this.fNg.getResources().getString(d.j.haved_fans_call));
    }

    private void j(boolean z, boolean z2, boolean z3) {
        if (this.fYY != null) {
            this.fYY.amI();
            if (z) {
                this.fYY.bdY().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_recommend_reversed_down_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fYY.bdY().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
            }
            if (z2) {
                this.fYY.bdY().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fYY.bdY().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
            if (z3) {
                this.fYY.bej().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_host_only_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fYY.bej().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void wH() {
        if (this.fYY != null) {
            this.fYY.bet();
        }
        if (this.bxw == null) {
            this.bxw = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.fYX != null) {
                        g.a(c.this.fYX, c.this.fNg.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.ns().postDelayed(this.bxw, 100L);
    }

    public void bgj() {
        if (this.fYY != null) {
            this.fYY.bet();
        }
        if (this.fYX != null) {
            g.a(this.fYX, this.fNg.getPageContext().getPageActivity());
        }
    }

    public z bgk() {
        return this.fYY;
    }

    public View bgl() {
        return this.fYR;
    }

    public boolean amf() {
        return this.fYX != null && this.fYX.isShowing();
    }

    public void aPc() {
        if (this.fYY != null) {
            this.fYY.release();
        }
        this.fYX = null;
        this.fYY = null;
        e.ns().removeCallbacks(this.bxw);
    }

    public void bgm() {
        if (this.fYP != null) {
            this.fYP.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.fNg.getPageContext(), i);
            aj.s(this.mNavigationBar.getBarBgView(), d.C0141d.cp_bg_line_d);
        }
        an.Dd().c(this.fYZ, d.f.icon_topbar_return_n_svg, d.f.select_topbar_icon_color_tint);
        an.Dd().c(this.aHX, d.f.icon_topbar_more_n_svg, d.f.select_topbar_icon_color_tint);
        bgg();
        if (this.fYU != null) {
            this.fYU.onChangeSkinType(i);
        }
        if (this.fYW != null) {
            aj.s(this.fYW, d.f.shape_photo_nav_bar_bg);
        }
        aj.d(this.fYO, d.C0141d.cp_cont_b, d.C0141d.s_navbar_title_color);
    }

    public void tk(int i) {
        this.mNavigationBar.onChangeSkinType(this.fNg.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(d.f.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.fNg.getResources().getColor(d.C0141d.black_alpha85));
        if (this.aHY != null) {
            this.aHY.setImageResource(d.f.pb_ala_share);
        }
        if (this.aHX != null) {
            this.aHX.setImageResource(d.f.icon_vnav_more_bg);
        }
        this.fYO.setTextColor(this.fNg.getResources().getColor(d.C0141d.cp_cont_g));
        this.fYZ.setImageResource(d.f.icon_return_bg);
    }

    public void bgn() {
        this.fYZ.setVisibility(0);
        lf(false);
        if (this.fYP != null) {
            this.fYP.setVisibility(8);
        }
        if (this.fYQ != null) {
            this.fYQ.setVisibility(8);
        }
    }

    public void le(boolean z) {
        this.fYZ.setVisibility(0);
        lf(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.fYQ != null) {
                this.fYQ.setVisibility(0);
            }
            if (this.fYP != null) {
                this.fYP.setVisibility(0);
                return;
            }
            return;
        }
        if (this.fYQ != null) {
            this.fYQ.setVisibility(8);
        }
        if (this.fYP != null) {
            this.fYP.setVisibility(8);
        }
    }

    public void lf(boolean z) {
        if (!this.fVT && z && !"".equals(this.fYO.getText().toString())) {
            this.fYO.setVisibility(0);
        } else {
            this.fYO.setVisibility(8);
        }
    }

    public void lg(boolean z) {
        this.fZa = z;
    }

    public void lh(boolean z) {
        if (!this.fZa || TbadkCoreApplication.isLogin() || z) {
            if (z) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("call_fan_guide", false)) {
                    lh(false);
                    return;
                }
            } else if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_share", false)) {
                return;
            }
            this.fZc = z;
            View inflate = LayoutInflater.from(this.fNg.getPageContext().getContext()).inflate(d.h.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(d.g.arrow_up);
            TextView textView = (TextView) inflate.findViewById(d.g.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            if (!z) {
                layoutParams.gravity = 5;
                if (!TbadkCoreApplication.isLogin()) {
                    layoutParams.rightMargin = l.t(this.fNg, d.e.ds28);
                } else {
                    layoutParams.rightMargin = l.t(this.fNg, d.e.ds128);
                }
                textView.setText(d.j.share_tip);
                textView.setOnClickListener(this.fZj);
                this.fZb = new PopupWindow(inflate, -2, -2);
                e.ns().removeCallbacks(this.fZh);
                e.ns().postDelayed(this.fZh, 500L);
            }
        }
    }

    public void bgo() {
        if (this.fZh != null) {
            e.ns().removeCallbacks(this.fZh);
        }
        if (this.fZi != null) {
            e.ns().removeCallbacks(this.fZi);
        }
        bgp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgp() {
        g.b(this.fZb);
    }

    public void j(int i, int i2, boolean z) {
        if (i2 != 0 && bgh() != null && this.fYT != null) {
            if (!z) {
                if (this.fYT.getAlpha() != 1.0f) {
                    this.fYT.setAlpha(1.0f);
                    return;
                }
                return;
            }
            int measuredHeight = (bgh().getMeasuredHeight() + i2) - 1;
            if (i >= measuredHeight) {
                if (this.fYT.getAlpha() != 0.0f) {
                    this.fYT.setAlpha(0.0f);
                }
            } else if (i > bgh().getMeasuredHeight() && i < measuredHeight) {
                this.fYT.setAlpha(1.0f - (((i - bgh().getMeasuredHeight()) * 1.0f) / (measuredHeight - bgh().getMeasuredHeight())));
            } else if (i <= bgh().getMeasuredHeight() && this.fYT.getAlpha() != 1.0f) {
                this.fYT.setAlpha(1.0f);
            }
        }
    }
}
