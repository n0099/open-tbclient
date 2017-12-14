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
import com.baidu.tbadk.core.h;
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
/* loaded from: classes.dex */
public class c {
    private int DS4;
    private ImageView Si;
    private Runnable aHo;
    public final View aMr;
    private int cSB;
    private PbActivity eVp;
    public TextView fgB;
    public View fgC;
    public View fgD;
    private ImageView fgE;
    private final ImageView fgF;
    private final LinearLayout fgG;
    public FrameLayout fgH;
    public PbNavbarUserConcernView fgI;
    public HeadPendantView fgJ;
    private ImageView fgM;
    private PopupWindow fgO;
    private boolean fgP;
    private int fgQ;
    private int fgR;
    public final NavigationBar mNavigationBar;
    private boolean fdK = false;
    private f fgK = null;
    private aa fgL = null;
    private boolean fgN = false;
    private Runnable fgS = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.5
        @Override // java.lang.Runnable
        public void run() {
            View view;
            if (!c.this.fdK) {
                view = c.this.fgP ? c.this.fgC : c.this.fgD;
            } else {
                view = c.this.fgD;
            }
            if (view != null) {
                if (TbadkCoreApplication.isLogin() || !c.this.fgP) {
                    g.showPopupWindowAsDropDown(c.this.fgO, view);
                    if (!c.this.fgP) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_share", true);
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("call_fan_guide", true);
                    }
                    e.fP().removeCallbacks(c.this.fgT);
                    e.fP().postDelayed(c.this.fgT, TbConfig.NOTIFY_SOUND_INTERVAL);
                }
            }
        }
    };
    private Runnable fgT = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.6
        @Override // java.lang.Runnable
        public void run() {
            c.this.aXq();
        }
    };
    private View.OnClickListener fgU = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.aXp();
        }
    };

    public c(PbActivity pbActivity) {
        this.cSB = 0;
        this.fgQ = 0;
        this.fgR = 0;
        this.DS4 = 0;
        this.eVp = pbActivity;
        this.cSB = l.f(pbActivity, d.e.ds88);
        this.fgQ = l.f(this.eVp.getPageContext().getPageActivity(), d.e.ds22);
        this.fgR = l.f(this.eVp.getPageContext().getPageActivity(), d.e.ds14);
        this.DS4 = l.f(this.eVp.getPageContext().getPageActivity(), d.e.ds4);
        this.mNavigationBar = (NavigationBar) this.eVp.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.eVp.alD();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.aMr = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.cIJ);
        this.fgB = this.mNavigationBar.setCenterTextTitle("");
        this.fgF = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.fgG = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int f = l.f(this.eVp.getPageContext().getPageActivity(), d.e.ds20);
        this.fgG.setPadding(f, 0, f, 0);
        aj.a(this.fgF, d.f.icon_pb_play_small, d.f.icon_pb_play_small);
        this.fgF.setVisibility(8);
        this.fgB.setOnClickListener(pbActivity.cIJ);
        this.fgF.setOnClickListener(pbActivity.cIJ);
        this.fgM = (ImageView) this.aMr.findViewById(d.g.widget_navi_back_button);
    }

    public void kg(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.fdK = z;
        if (this.fgD == null && this.fgE == null) {
            this.fgD = this.mNavigationBar.addCustomView(controlAlign, d.h.nb_item_floor_share, this.eVp.cIJ);
            this.fgE = (ImageView) this.fgD.findViewById(d.g.navigationBarBtnShare);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.cSB, this.cSB);
            layoutParams.rightMargin = this.DS4;
            this.fgD.setLayoutParams(layoutParams);
            aj.a(this.fgE, d.f.icon_pb_navi_selector, d.f.icon_pb_navi_selector);
        }
        if (this.fgC == null && this.Si == null) {
            this.fgC = this.mNavigationBar.addCustomView(controlAlign, d.h.nb_item_floor_more, this.eVp.cIJ);
            this.Si = (ImageView) this.fgC.findViewById(d.g.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.cSB, this.cSB);
            layoutParams2.rightMargin = this.fgR;
            this.fgC.setLayoutParams(layoutParams2);
            aj.a(this.Si, d.f.icon_nav_more_selector, d.f.icon_nav_more_selector);
            this.fgC.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
        if (z) {
            if (this.fgH == null) {
                this.fgH = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.nav_user_concern_layout, (View.OnClickListener) null);
                this.fgI = (PbNavbarUserConcernView) this.fgH.findViewById(d.g.view_add_concern);
                this.fgJ = (HeadPendantView) this.fgH.findViewById(d.g.view_host_pendant_photo);
                this.fgJ.wi();
                if (this.fgJ.getHeadView() != null) {
                    this.fgJ.getHeadView().setIsRound(true);
                    this.fgJ.getHeadView().setDefaultBgResource(d.C0096d.transparent);
                    this.fgJ.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.setMargins(this.fgQ, 0, 0, 0);
                this.fgH.setLayoutParams(layoutParams3);
                this.fgI.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        } else if (this.fgH != null) {
            this.mNavigationBar.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_LEFT).removeView(this.fgH);
        }
    }

    public void jN(boolean z) {
        if (this.fgC != null) {
            this.fgC.setVisibility(z ? 0 : 8);
        }
    }

    public void kh(boolean z) {
        if (this.fgD != null && !z) {
            this.fgD.setVisibility(8);
        }
    }

    public NavigationBar aXj() {
        return this.mNavigationBar;
    }

    public void setTitleVisibility(boolean z) {
        if (z) {
            this.aMr.setVisibility(0);
        } else {
            this.aMr.setVisibility(8);
        }
        kj(z);
    }

    public void nG(String str) {
        if (!TextUtils.isEmpty(str) && !this.fdK) {
            this.fgB.setText(this.eVp.getResources().getString(d.j.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            kj(true);
            h.oY().cs(str);
            return;
        }
        kj(false);
    }

    public void a(MetaData metaData, View.OnClickListener onClickListener) {
        if (metaData != null) {
            UtilHelper.showHeadImageViewBigV(this.fgJ.getHeadView(), metaData);
            this.fgJ.getHeadView().setImageDrawable(null);
            this.fgJ.getPendantView().setImageDrawable(null);
            this.fgJ.getHeadView().startLoad(metaData.getPortrait(), 28, false);
            this.fgJ.getHeadView().setUserId(metaData.getUserId());
            this.fgJ.getHeadView().setUserName(metaData.getUserName());
            this.fgJ.getHeadView().setOnClickListener(onClickListener);
            if (metaData.getPendantData() != null && !StringUtils.isNull(metaData.getPendantData().pR())) {
                this.fgJ.es(metaData.getPendantData().pR());
            } else {
                this.fgJ.es(null);
            }
        }
    }

    public void a(ab abVar) {
        if (!this.eVp.isProgressBarShown()) {
            if (this.fgK == null) {
                this.fgL = new aa((PbActivity) this.eVp.getPageContext().getOrignalPage(), this.eVp.cIJ);
                this.fgK = new f(this.eVp.getPageContext().getPageActivity(), this.fgL.getView(), aj.getDrawable(d.f.bg_pull_down_right_n), new e.a() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                    @Override // com.baidu.tbadk.core.view.e.a
                    public void ou() {
                        c.this.eVp.aSZ();
                    }

                    @Override // com.baidu.tbadk.core.view.e.a
                    public void ov() {
                    }
                });
            }
            this.fgL.aVu();
            if (this.fgN) {
                final Rect rect = new Rect();
                if (this.eVp.eTI) {
                    com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.eVp.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                            int height = c.this.eVp.getWindow().getDecorView().getHeight();
                            c.this.fgK.setClippingEnabled(false);
                            c.this.fgK.showAtLocation(c.this.eVp.findViewById(d.g.pb_layout), 81, 0, height - rect.bottom);
                        }
                    }, 500L);
                } else {
                    this.eVp.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    int height = this.eVp.getWindow().getDecorView().getHeight();
                    this.fgK.setClippingEnabled(false);
                    this.fgK.showAtLocation(this.eVp.findViewById(d.g.pb_layout), 81, 0, height - rect.bottom);
                }
            } else {
                this.fgK.showAtLocation(this.eVp.findViewById(d.g.pb_layout), 17, 0, 0);
            }
            this.fgL.jC(abVar == null ? false : abVar.eZN);
            this.fgL.jE(abVar == null ? false : abVar.eZT);
            this.fgL.jF(abVar == null ? false : abVar.eZU);
            this.fgL.jG(abVar == null ? false : abVar.eZV);
            this.fgL.jH(abVar == null ? true : abVar.fac);
            if (abVar == null) {
                this.fgL.I(false, false);
                this.fgL.J(false, false);
                this.fgL.l(false, "");
            } else {
                this.fgL.I(abVar.eZR, abVar.eZZ);
                this.fgL.J(abVar.eZS, abVar.eZY);
                this.fgL.l(StringUtils.isNull(abVar.fab) ? false : true, abVar.fab);
            }
            boolean z = abVar == null ? false : abVar.eZP;
            boolean z2 = abVar == null ? false : abVar.eQp;
            boolean z3 = abVar == null ? false : abVar.isHostOnly;
            boolean z4 = abVar == null ? false : abVar.faa;
            boolean z5 = abVar == null ? false : abVar.eZQ;
            boolean z6 = abVar == null ? false : abVar.eZW;
            boolean z7 = abVar == null ? false : abVar.eZX;
            this.fgL.jD(abVar == null ? false : abVar.eZO);
            this.fgL.H(z4, z3);
            this.fgL.K(z5, z);
            this.fgL.L(z7, z6);
            if (abVar != null) {
                this.fgL.eZJ = abVar.fad;
                if (abVar.fad) {
                    this.fgL.aVn().setText(d.j.report_text);
                    this.fgL.jG(false);
                }
            }
            i(z, z2, z3);
        }
    }

    public void aXk() {
        this.fgL.aVt().setText(this.eVp.getResources().getString(d.j.haved_fans_call));
    }

    private void i(boolean z, boolean z2, boolean z3) {
        if (this.fgL != null) {
            this.fgL.adm();
            if (z) {
                this.fgL.aVa().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_recommend_reversed_down_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fgL.aVa().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
            }
            if (z2) {
                this.fgL.aVa().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fgL.aVa().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
            if (z3) {
                this.fgL.aVl().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_host_only_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fgL.aVl().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void or() {
        if (this.fgL != null) {
            this.fgL.aVv();
        }
        if (this.aHo == null) {
            this.aHo = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.fgK != null) {
                        g.a(c.this.fgK, c.this.eVp.getPageContext().getPageActivity());
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.fP().postDelayed(this.aHo, 100L);
    }

    public aa aXl() {
        return this.fgL;
    }

    public View aXm() {
        return this.fgF;
    }

    public boolean acJ() {
        return this.fgK != null && this.fgK.isShowing();
    }

    public void aGe() {
        if (this.fgL != null) {
            this.fgL.release();
        }
        this.fgK = null;
        this.fgL = null;
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.aHo);
    }

    public void aXn() {
        if (this.fgC != null) {
            this.fgC.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.eVp.getPageContext(), i);
            aj.j(this.mNavigationBar.getBarBgView(), d.C0096d.cp_bg_line_d);
        }
        if (this.Si != null) {
            aj.a(this.Si, d.f.icon_nav_more_selector, d.f.icon_nav_more_selector);
        }
        if (this.fgE != null) {
            aj.a(this.fgE, d.f.icon_pb_navi_selector, d.f.icon_pb_navi_selector);
        }
        if (this.fgI != null) {
            this.fgI.onChangeSkinType(i);
        }
        aj.b(this.fgB, d.C0096d.cp_cont_b, d.C0096d.s_navbar_title_color);
    }

    public void qt(int i) {
        this.mNavigationBar.onChangeSkinType(this.eVp.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(d.f.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.eVp.getResources().getColor(d.C0096d.black_alpha85));
        if (this.fgE != null) {
            this.fgE.setImageResource(d.f.pb_ala_share);
        }
        if (this.Si != null) {
            this.Si.setImageResource(d.f.icon_vnav_more_bg);
        }
        this.fgB.setTextColor(this.eVp.getResources().getColor(d.C0096d.cp_cont_g));
        this.fgM.setImageResource(d.f.icon_return_bg);
    }

    public void aXo() {
        this.fgM.setVisibility(0);
        kj(false);
        if (this.fgC != null) {
            this.fgC.setVisibility(8);
        }
        if (this.fgD != null) {
            this.fgD.setVisibility(8);
        }
    }

    public void ki(boolean z) {
        this.fgM.setVisibility(0);
        kj(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.fgD != null) {
                this.fgD.setVisibility(0);
            }
            if (this.fgC != null) {
                this.fgC.setVisibility(0);
                return;
            }
            return;
        }
        if (this.fgD != null) {
            this.fgD.setVisibility(8);
        }
        if (this.fgC != null) {
            this.fgC.setVisibility(8);
        }
    }

    public void kj(boolean z) {
        if (!this.fdK && z && !"".equals(this.fgB.getText().toString())) {
            this.fgB.setVisibility(0);
        } else {
            this.fgB.setVisibility(8);
        }
    }

    public void kk(boolean z) {
        this.fgN = z;
    }

    public void kl(boolean z) {
        if (!this.fgN || TbadkCoreApplication.isLogin() || z) {
            if (z) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("call_fan_guide", false)) {
                    kl(false);
                    return;
                }
            } else if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_share", false)) {
                return;
            }
            this.fgP = z;
            View inflate = LayoutInflater.from(this.eVp.getPageContext().getContext()).inflate(d.h.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(d.g.arrow_up);
            TextView textView = (TextView) inflate.findViewById(d.g.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            if (!z) {
                layoutParams.gravity = 5;
                if (!TbadkCoreApplication.isLogin()) {
                    layoutParams.rightMargin = l.f(this.eVp, d.e.ds28);
                } else {
                    layoutParams.rightMargin = l.f(this.eVp, d.e.ds128);
                }
                textView.setText(d.j.share_tip);
                textView.setOnClickListener(this.fgU);
                this.fgO = new PopupWindow(inflate, -2, -2);
                com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fgS);
                com.baidu.adp.lib.g.e.fP().postDelayed(this.fgS, 500L);
            }
        }
    }

    public void aXp() {
        if (this.fgS != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fgS);
        }
        if (this.fgT != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fgT);
        }
        aXq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXq() {
        g.a(this.fgO);
    }

    public void f(int i, int i2, boolean z) {
        if (i2 != 0 && aXj() != null && this.fgH != null) {
            if (!z) {
                if (this.fgH.getAlpha() != 1.0f) {
                    this.fgH.setAlpha(1.0f);
                    return;
                }
                return;
            }
            int measuredHeight = (aXj().getMeasuredHeight() + i2) - 1;
            if (i >= measuredHeight) {
                if (this.fgH.getAlpha() != 0.0f) {
                    this.fgH.setAlpha(0.0f);
                }
            } else if (i > aXj().getMeasuredHeight() && i < measuredHeight) {
                this.fgH.setAlpha(1.0f - (((i - aXj().getMeasuredHeight()) * 1.0f) / (measuredHeight - aXj().getMeasuredHeight())));
            } else if (i <= aXj().getMeasuredHeight() && this.fgH.getAlpha() != 1.0f) {
                this.fgH.setAlpha(1.0f);
            }
        }
    }
}
