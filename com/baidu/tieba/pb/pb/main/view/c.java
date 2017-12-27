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
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.e;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.aa;
import com.baidu.tieba.pb.pb.main.ab;
import com.baidu.tieba.pb.view.f;
/* loaded from: classes2.dex */
public class c {
    private int DS4;
    private ImageView aGN;
    public final View bAh;
    private Runnable bve;
    private PbActivity fHW;
    public TextView fTC;
    public View fTD;
    public View fTE;
    private ImageView fTF;
    private final ImageView fTG;
    private final LinearLayout fTH;
    public FrameLayout fTI;
    public PbNavbarUserConcernView fTJ;
    public HeadPendantView fTK;
    public View fTL;
    private ImageView fTO;
    private PopupWindow fTQ;
    private boolean fTR;
    private int fTS;
    private int fTT;
    private int fTU;
    public final NavigationBar mNavigationBar;
    private boolean fQG = false;
    private f fTM = null;
    private aa fTN = null;
    private boolean fTP = false;
    private boolean fTV = false;
    private Runnable fTW = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.5
        @Override // java.lang.Runnable
        public void run() {
            View view;
            if (!c.this.fQG) {
                view = c.this.fTR ? c.this.fTD : c.this.fTE;
            } else {
                view = c.this.fTE;
            }
            if (view != null) {
                if (TbadkCoreApplication.isLogin() || !c.this.fTR) {
                    g.showPopupWindowAsDropDown(c.this.fTQ, view);
                    if (!c.this.fTR) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_share", true);
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("call_fan_guide", true);
                    }
                    e.nr().removeCallbacks(c.this.fTX);
                    e.nr().postDelayed(c.this.fTX, TbConfig.NOTIFY_SOUND_INTERVAL);
                }
            }
        }
    };
    private Runnable fTX = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.6
        @Override // java.lang.Runnable
        public void run() {
            c.this.beG();
        }
    };
    private View.OnClickListener fTY = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.beF();
        }
    };

    public c(PbActivity pbActivity) {
        this.fTS = 0;
        this.fTT = 0;
        this.fTU = 0;
        this.DS4 = 0;
        this.fHW = pbActivity;
        this.fTS = l.s(pbActivity, d.e.ds88);
        this.fTT = l.s(this.fHW.getPageContext().getPageActivity(), d.e.ds22);
        this.fTU = l.s(this.fHW.getPageContext().getPageActivity(), d.e.ds14);
        this.DS4 = l.s(this.fHW.getPageContext().getPageActivity(), d.e.ds4);
        this.mNavigationBar = (NavigationBar) this.fHW.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.fHW.atl();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.bAh = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.dyk);
        this.fTC = this.mNavigationBar.setCenterTextTitle("");
        this.fTG = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.fTH = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int s = l.s(this.fHW.getPageContext().getPageActivity(), d.e.ds20);
        this.fTH.setPadding(s, 0, s, 0);
        aj.a(this.fTG, d.f.icon_pb_play_small, d.f.icon_pb_play_small);
        this.fTG.setVisibility(8);
        this.fTC.setOnClickListener(pbActivity.dyk);
        this.fTG.setOnClickListener(pbActivity.dyk);
        this.fTO = (ImageView) this.bAh.findViewById(d.g.widget_navi_back_button);
    }

    public void kI(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.fQG = z;
        if (this.fTE == null && this.fTF == null) {
            this.fTE = this.mNavigationBar.addCustomView(controlAlign, d.h.nb_item_floor_share, this.fHW.dyk);
            this.fTF = (ImageView) this.fTE.findViewById(d.g.navigationBarBtnShare);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.fTS, this.fTS);
            layoutParams.rightMargin = this.DS4;
            this.fTE.setLayoutParams(layoutParams);
            bex();
        }
        if (this.fTD == null && this.aGN == null) {
            this.fTD = this.mNavigationBar.addCustomView(controlAlign, d.h.nb_item_floor_more, this.fHW.dyk);
            this.aGN = (ImageView) this.fTD.findViewById(d.g.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.fTS, this.fTS);
            layoutParams2.rightMargin = this.fTU;
            this.fTD.setLayoutParams(layoutParams2);
            aj.a(this.aGN, d.f.icon_nav_more_selector, d.f.icon_nav_more_selector);
            this.fTD.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
        if (z) {
            if (this.fTI == null) {
                this.fTI = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.nav_user_concern_layout, (View.OnClickListener) null);
                this.fTJ = (PbNavbarUserConcernView) this.fTI.findViewById(d.g.view_add_concern);
                this.fTL = this.fTI.findViewById(d.g.bg_user_photo);
                this.fTK = (HeadPendantView) this.fTI.findViewById(d.g.view_host_pendant_photo);
                this.fTK.DG();
                if (this.fTK.getHeadView() != null) {
                    this.fTK.getHeadView().setIsRound(true);
                    this.fTK.getHeadView().setDefaultBgResource(d.C0108d.transparent);
                    this.fTK.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.setMargins(this.fTT, 0, 0, 0);
                this.fTI.setLayoutParams(layoutParams3);
                this.fTJ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                aj.s(this.fTL, d.f.shape_photo_nav_bar_bg);
            }
        } else if (this.fTI != null) {
            this.mNavigationBar.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_LEFT).removeView(this.fTI);
        }
    }

    public void kp(boolean z) {
        if (this.fTD != null) {
            this.fTD.setVisibility(z ? 0 : 8);
        }
    }

    public void kJ(boolean z) {
        this.fTV = z;
        bex();
    }

    private void bex() {
        if (this.fTF != null && this.fTE != null) {
            if (this.fTV) {
                if (this.fTP) {
                    aj.a(this.fTF, d.f.icon_topbar_share_white_d, d.f.icon_topbar_share_white_d);
                } else {
                    aj.a(this.fTF, d.f.icon_topbar_share_d, d.f.icon_topbar_share_d);
                }
                this.fTE.setClickable(false);
                return;
            }
            if (this.fTP) {
                aj.a(this.fTF, d.f.pb_ala_share, d.f.pb_ala_share);
            } else {
                aj.a(this.fTF, d.f.icon_pb_navi_selector, d.f.icon_pb_navi_selector);
            }
            this.fTE.setClickable(true);
        }
    }

    public void kK(boolean z) {
        if (this.fTE != null && !z) {
            this.fTE.setVisibility(8);
        }
    }

    public NavigationBar bey() {
        return this.mNavigationBar;
    }

    public void setTitleVisibility(boolean z) {
        if (z) {
            this.bAh.setVisibility(0);
        } else {
            this.bAh.setVisibility(8);
        }
        kM(z);
    }

    public void nP(String str) {
        if (!TextUtils.isEmpty(str) && !this.fQG) {
            this.fTC.setText(this.fHW.getResources().getString(d.j.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            kM(true);
            i.wB().cz(str);
            return;
        }
        kM(false);
    }

    public void a(MetaData metaData, View.OnClickListener onClickListener) {
        if (metaData != null) {
            UtilHelper.showHeadImageViewBigV(this.fTK.getHeadView(), metaData);
            this.fTK.getHeadView().setImageDrawable(null);
            this.fTK.getPendantView().setImageDrawable(null);
            this.fTK.getHeadView().startLoad(metaData.getPortrait(), 28, false);
            this.fTK.getHeadView().setUserId(metaData.getUserId());
            this.fTK.getHeadView().setUserName(metaData.getUserName());
            this.fTK.getHeadView().setOnClickListener(onClickListener);
            if (metaData.getPendantData() != null && !StringUtils.isNull(metaData.getPendantData().xu())) {
                this.fTK.ez(metaData.getPendantData().xu());
            } else {
                this.fTK.ez(null);
            }
        }
    }

    public void a(ab abVar) {
        if (!this.fHW.isProgressBarShown()) {
            if (this.fTM == null) {
                this.fTN = new aa((PbActivity) this.fHW.getPageContext().getOrignalPage(), this.fHW.dyk);
                this.fTM = new f(this.fHW.getPageContext().getPageActivity(), this.fTN.getView(), aj.getDrawable(d.f.bg_pull_down_right_n), new e.a() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                    @Override // com.baidu.tbadk.core.view.e.a
                    public void vX() {
                        c.this.fHW.bal();
                    }

                    @Override // com.baidu.tbadk.core.view.e.a
                    public void vY() {
                    }
                });
            }
            this.fTN.bcH();
            if (this.fTP) {
                final Rect rect = new Rect();
                if (this.fHW.fGo) {
                    com.baidu.adp.lib.g.e.nr().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.fHW.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                            int height = c.this.fHW.getWindow().getDecorView().getHeight();
                            c.this.fTM.setClippingEnabled(false);
                            c.this.fTM.showAtLocation(c.this.fHW.findViewById(d.g.pb_layout), 81, 0, height - rect.bottom);
                        }
                    }, 500L);
                } else {
                    this.fHW.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    int height = this.fHW.getWindow().getDecorView().getHeight();
                    this.fTM.setClippingEnabled(false);
                    this.fTM.showAtLocation(this.fHW.findViewById(d.g.pb_layout), 81, 0, height - rect.bottom);
                }
            } else {
                this.fTM.showAtLocation(this.fHW.findViewById(d.g.pb_layout), 17, 0, 0);
            }
            this.fTN.ke(abVar == null ? false : abVar.fMK);
            this.fTN.kg(abVar == null ? false : abVar.fMQ);
            this.fTN.kh(abVar == null ? false : abVar.fMR);
            this.fTN.ki(abVar == null ? false : abVar.fMS);
            this.fTN.kj(abVar == null ? true : abVar.fMZ);
            if (abVar == null) {
                this.fTN.K(false, false);
                this.fTN.L(false, false);
                this.fTN.k(false, "");
            } else {
                this.fTN.K(abVar.fMO, abVar.fMW);
                this.fTN.L(abVar.fMP, abVar.fMV);
                this.fTN.k(StringUtils.isNull(abVar.fMY) ? false : true, abVar.fMY);
            }
            boolean z = abVar == null ? false : abVar.fMM;
            boolean z2 = abVar == null ? false : abVar.fCV;
            boolean z3 = abVar == null ? false : abVar.isHostOnly;
            boolean z4 = abVar == null ? false : abVar.fMX;
            boolean z5 = abVar == null ? false : abVar.fMN;
            boolean z6 = abVar == null ? false : abVar.fMT;
            boolean z7 = abVar == null ? false : abVar.fMU;
            this.fTN.kf(abVar == null ? false : abVar.fML);
            this.fTN.J(z4, z3);
            this.fTN.M(z5, z);
            this.fTN.N(z7, z6);
            if (abVar != null) {
                this.fTN.fMG = abVar.fNa;
                if (abVar.fNa) {
                    this.fTN.bcA().setText(d.j.report_text);
                    this.fTN.ki(false);
                }
            }
            j(z, z2, z3);
        }
    }

    public void bez() {
        this.fTN.bcG().setText(this.fHW.getResources().getString(d.j.haved_fans_call));
    }

    private void j(boolean z, boolean z2, boolean z3) {
        if (this.fTN != null) {
            this.fTN.akR();
            if (z) {
                this.fTN.bcn().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_recommend_reversed_down_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fTN.bcn().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
            }
            if (z2) {
                this.fTN.bcn().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fTN.bcn().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
            if (z3) {
                this.fTN.bcy().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_host_only_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fTN.bcy().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void vU() {
        if (this.fTN != null) {
            this.fTN.bcI();
        }
        if (this.bve == null) {
            this.bve = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.fTM != null) {
                        g.a(c.this.fTM, c.this.fHW.getPageContext().getPageActivity());
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.nr().postDelayed(this.bve, 100L);
    }

    public void beA() {
        if (this.fTN != null) {
            this.fTN.bcI();
        }
        if (this.fTM != null) {
            g.a(this.fTM, this.fHW.getPageContext().getPageActivity());
        }
    }

    public aa beB() {
        return this.fTN;
    }

    public View beC() {
        return this.fTG;
    }

    public boolean ako() {
        return this.fTM != null && this.fTM.isShowing();
    }

    public void aNe() {
        if (this.fTN != null) {
            this.fTN.release();
        }
        this.fTM = null;
        this.fTN = null;
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.bve);
    }

    public void beD() {
        if (this.fTD != null) {
            this.fTD.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.fHW.getPageContext(), i);
            aj.s(this.mNavigationBar.getBarBgView(), d.C0108d.cp_bg_line_d);
        }
        if (this.aGN != null) {
            aj.a(this.aGN, d.f.icon_nav_more_selector, d.f.icon_nav_more_selector);
        }
        bex();
        if (this.fTJ != null) {
            this.fTJ.onChangeSkinType(i);
        }
        if (this.fTL != null) {
            aj.s(this.fTL, d.f.shape_photo_nav_bar_bg);
        }
        aj.d(this.fTC, d.C0108d.cp_cont_b, d.C0108d.s_navbar_title_color);
    }

    public void tn(int i) {
        this.mNavigationBar.onChangeSkinType(this.fHW.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(d.f.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.fHW.getResources().getColor(d.C0108d.black_alpha85));
        if (this.fTF != null) {
            this.fTF.setImageResource(d.f.pb_ala_share);
        }
        if (this.aGN != null) {
            this.aGN.setImageResource(d.f.icon_vnav_more_bg);
        }
        this.fTC.setTextColor(this.fHW.getResources().getColor(d.C0108d.cp_cont_g));
        this.fTO.setImageResource(d.f.icon_return_bg);
    }

    public void beE() {
        this.fTO.setVisibility(0);
        kM(false);
        if (this.fTD != null) {
            this.fTD.setVisibility(8);
        }
        if (this.fTE != null) {
            this.fTE.setVisibility(8);
        }
    }

    public void kL(boolean z) {
        this.fTO.setVisibility(0);
        kM(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.fTE != null) {
                this.fTE.setVisibility(0);
            }
            if (this.fTD != null) {
                this.fTD.setVisibility(0);
                return;
            }
            return;
        }
        if (this.fTE != null) {
            this.fTE.setVisibility(8);
        }
        if (this.fTD != null) {
            this.fTD.setVisibility(8);
        }
    }

    public void kM(boolean z) {
        if (!this.fQG && z && !"".equals(this.fTC.getText().toString())) {
            this.fTC.setVisibility(0);
        } else {
            this.fTC.setVisibility(8);
        }
    }

    public void kN(boolean z) {
        this.fTP = z;
    }

    public void kO(boolean z) {
        if (!this.fTP || TbadkCoreApplication.isLogin() || z) {
            if (z) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("call_fan_guide", false)) {
                    kO(false);
                    return;
                }
            } else if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_share", false)) {
                return;
            }
            this.fTR = z;
            View inflate = LayoutInflater.from(this.fHW.getPageContext().getContext()).inflate(d.h.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(d.g.arrow_up);
            TextView textView = (TextView) inflate.findViewById(d.g.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            if (!z) {
                layoutParams.gravity = 5;
                if (!TbadkCoreApplication.isLogin()) {
                    layoutParams.rightMargin = l.s(this.fHW, d.e.ds28);
                } else {
                    layoutParams.rightMargin = l.s(this.fHW, d.e.ds128);
                }
                textView.setText(d.j.share_tip);
                textView.setOnClickListener(this.fTY);
                this.fTQ = new PopupWindow(inflate, -2, -2);
                com.baidu.adp.lib.g.e.nr().removeCallbacks(this.fTW);
                com.baidu.adp.lib.g.e.nr().postDelayed(this.fTW, 500L);
            }
        }
    }

    public void beF() {
        if (this.fTW != null) {
            com.baidu.adp.lib.g.e.nr().removeCallbacks(this.fTW);
        }
        if (this.fTX != null) {
            com.baidu.adp.lib.g.e.nr().removeCallbacks(this.fTX);
        }
        beG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beG() {
        g.b(this.fTQ);
    }

    public void i(int i, int i2, boolean z) {
        if (i2 != 0 && bey() != null && this.fTI != null) {
            if (!z) {
                if (this.fTI.getAlpha() != 1.0f) {
                    this.fTI.setAlpha(1.0f);
                    return;
                }
                return;
            }
            int measuredHeight = (bey().getMeasuredHeight() + i2) - 1;
            if (i >= measuredHeight) {
                if (this.fTI.getAlpha() != 0.0f) {
                    this.fTI.setAlpha(0.0f);
                }
            } else if (i > bey().getMeasuredHeight() && i < measuredHeight) {
                this.fTI.setAlpha(1.0f - (((i - bey().getMeasuredHeight()) * 1.0f) / (measuredHeight - bey().getMeasuredHeight())));
            } else if (i <= bey().getMeasuredHeight() && this.fTI.getAlpha() != 1.0f) {
                this.fTI.setAlpha(1.0f);
            }
        }
    }
}
