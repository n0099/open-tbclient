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
    private ImageView Sj;
    private Runnable aHr;
    public final View aMu;
    private int cSF;
    private PbActivity eVu;
    public TextView fgG;
    public View fgH;
    public View fgI;
    private ImageView fgJ;
    private final ImageView fgK;
    private final LinearLayout fgL;
    public FrameLayout fgM;
    public PbNavbarUserConcernView fgN;
    public HeadPendantView fgO;
    private ImageView fgR;
    private PopupWindow fgT;
    private boolean fgU;
    private int fgV;
    private int fgW;
    public final NavigationBar mNavigationBar;
    private boolean fdP = false;
    private f fgP = null;
    private aa fgQ = null;
    private boolean fgS = false;
    private Runnable fgX = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.5
        @Override // java.lang.Runnable
        public void run() {
            View view;
            if (!c.this.fdP) {
                view = c.this.fgU ? c.this.fgH : c.this.fgI;
            } else {
                view = c.this.fgI;
            }
            if (view != null) {
                if (TbadkCoreApplication.isLogin() || !c.this.fgU) {
                    g.showPopupWindowAsDropDown(c.this.fgT, view);
                    if (!c.this.fgU) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_share", true);
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("call_fan_guide", true);
                    }
                    e.fP().removeCallbacks(c.this.fgY);
                    e.fP().postDelayed(c.this.fgY, TbConfig.NOTIFY_SOUND_INTERVAL);
                }
            }
        }
    };
    private Runnable fgY = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.6
        @Override // java.lang.Runnable
        public void run() {
            c.this.aXq();
        }
    };
    private View.OnClickListener fgZ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.aXp();
        }
    };

    public c(PbActivity pbActivity) {
        this.cSF = 0;
        this.fgV = 0;
        this.fgW = 0;
        this.DS4 = 0;
        this.eVu = pbActivity;
        this.cSF = l.f(pbActivity, d.e.ds88);
        this.fgV = l.f(this.eVu.getPageContext().getPageActivity(), d.e.ds22);
        this.fgW = l.f(this.eVu.getPageContext().getPageActivity(), d.e.ds14);
        this.DS4 = l.f(this.eVu.getPageContext().getPageActivity(), d.e.ds4);
        this.mNavigationBar = (NavigationBar) this.eVu.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.eVu.alC();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.aMu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.cIN);
        this.fgG = this.mNavigationBar.setCenterTextTitle("");
        this.fgK = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.fgL = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int f = l.f(this.eVu.getPageContext().getPageActivity(), d.e.ds20);
        this.fgL.setPadding(f, 0, f, 0);
        aj.a(this.fgK, d.f.icon_pb_play_small, d.f.icon_pb_play_small);
        this.fgK.setVisibility(8);
        this.fgG.setOnClickListener(pbActivity.cIN);
        this.fgK.setOnClickListener(pbActivity.cIN);
        this.fgR = (ImageView) this.aMu.findViewById(d.g.widget_navi_back_button);
    }

    public void kg(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.fdP = z;
        if (this.fgI == null && this.fgJ == null) {
            this.fgI = this.mNavigationBar.addCustomView(controlAlign, d.h.nb_item_floor_share, this.eVu.cIN);
            this.fgJ = (ImageView) this.fgI.findViewById(d.g.navigationBarBtnShare);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.cSF, this.cSF);
            layoutParams.rightMargin = this.DS4;
            this.fgI.setLayoutParams(layoutParams);
            aj.a(this.fgJ, d.f.icon_pb_navi_selector, d.f.icon_pb_navi_selector);
        }
        if (this.fgH == null && this.Sj == null) {
            this.fgH = this.mNavigationBar.addCustomView(controlAlign, d.h.nb_item_floor_more, this.eVu.cIN);
            this.Sj = (ImageView) this.fgH.findViewById(d.g.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.cSF, this.cSF);
            layoutParams2.rightMargin = this.fgW;
            this.fgH.setLayoutParams(layoutParams2);
            aj.a(this.Sj, d.f.icon_nav_more_selector, d.f.icon_nav_more_selector);
            this.fgH.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
        if (z) {
            if (this.fgM == null) {
                this.fgM = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.nav_user_concern_layout, (View.OnClickListener) null);
                this.fgN = (PbNavbarUserConcernView) this.fgM.findViewById(d.g.view_add_concern);
                this.fgO = (HeadPendantView) this.fgM.findViewById(d.g.view_host_pendant_photo);
                this.fgO.wi();
                if (this.fgO.getHeadView() != null) {
                    this.fgO.getHeadView().setIsRound(true);
                    this.fgO.getHeadView().setDefaultBgResource(d.C0095d.transparent);
                    this.fgO.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.setMargins(this.fgV, 0, 0, 0);
                this.fgM.setLayoutParams(layoutParams3);
                this.fgN.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        } else if (this.fgM != null) {
            this.mNavigationBar.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_LEFT).removeView(this.fgM);
        }
    }

    public void jN(boolean z) {
        if (this.fgH != null) {
            this.fgH.setVisibility(z ? 0 : 8);
        }
    }

    public void kh(boolean z) {
        if (this.fgI != null && !z) {
            this.fgI.setVisibility(8);
        }
    }

    public NavigationBar aXj() {
        return this.mNavigationBar;
    }

    public void setTitleVisibility(boolean z) {
        if (z) {
            this.aMu.setVisibility(0);
        } else {
            this.aMu.setVisibility(8);
        }
        kj(z);
    }

    public void nG(String str) {
        if (!TextUtils.isEmpty(str) && !this.fdP) {
            this.fgG.setText(this.eVu.getResources().getString(d.j.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            kj(true);
            h.oY().cs(str);
            return;
        }
        kj(false);
    }

    public void a(MetaData metaData, View.OnClickListener onClickListener) {
        if (metaData != null) {
            UtilHelper.showHeadImageViewBigV(this.fgO.getHeadView(), metaData);
            this.fgO.getHeadView().setImageDrawable(null);
            this.fgO.getPendantView().setImageDrawable(null);
            this.fgO.getHeadView().startLoad(metaData.getPortrait(), 28, false);
            this.fgO.getHeadView().setUserId(metaData.getUserId());
            this.fgO.getHeadView().setUserName(metaData.getUserName());
            this.fgO.getHeadView().setOnClickListener(onClickListener);
            if (metaData.getPendantData() != null && !StringUtils.isNull(metaData.getPendantData().pR())) {
                this.fgO.es(metaData.getPendantData().pR());
            } else {
                this.fgO.es(null);
            }
        }
    }

    public void a(ab abVar) {
        if (!this.eVu.isProgressBarShown()) {
            if (this.fgP == null) {
                this.fgQ = new aa((PbActivity) this.eVu.getPageContext().getOrignalPage(), this.eVu.cIN);
                this.fgP = new f(this.eVu.getPageContext().getPageActivity(), this.fgQ.getView(), aj.getDrawable(d.f.bg_pull_down_right_n), new e.a() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                    @Override // com.baidu.tbadk.core.view.e.a
                    public void ou() {
                        c.this.eVu.aSZ();
                    }

                    @Override // com.baidu.tbadk.core.view.e.a
                    public void ov() {
                    }
                });
            }
            this.fgQ.aVu();
            if (this.fgS) {
                final Rect rect = new Rect();
                if (this.eVu.eTN) {
                    com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.eVu.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                            int height = c.this.eVu.getWindow().getDecorView().getHeight();
                            c.this.fgP.setClippingEnabled(false);
                            c.this.fgP.showAtLocation(c.this.eVu.findViewById(d.g.pb_layout), 81, 0, height - rect.bottom);
                        }
                    }, 500L);
                } else {
                    this.eVu.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    int height = this.eVu.getWindow().getDecorView().getHeight();
                    this.fgP.setClippingEnabled(false);
                    this.fgP.showAtLocation(this.eVu.findViewById(d.g.pb_layout), 81, 0, height - rect.bottom);
                }
            } else {
                this.fgP.showAtLocation(this.eVu.findViewById(d.g.pb_layout), 17, 0, 0);
            }
            this.fgQ.jC(abVar == null ? false : abVar.eZS);
            this.fgQ.jE(abVar == null ? false : abVar.eZY);
            this.fgQ.jF(abVar == null ? false : abVar.eZZ);
            this.fgQ.jG(abVar == null ? false : abVar.faa);
            this.fgQ.jH(abVar == null ? true : abVar.fah);
            if (abVar == null) {
                this.fgQ.I(false, false);
                this.fgQ.J(false, false);
                this.fgQ.l(false, "");
            } else {
                this.fgQ.I(abVar.eZW, abVar.fae);
                this.fgQ.J(abVar.eZX, abVar.fad);
                this.fgQ.l(StringUtils.isNull(abVar.fag) ? false : true, abVar.fag);
            }
            boolean z = abVar == null ? false : abVar.eZU;
            boolean z2 = abVar == null ? false : abVar.eQu;
            boolean z3 = abVar == null ? false : abVar.isHostOnly;
            boolean z4 = abVar == null ? false : abVar.faf;
            boolean z5 = abVar == null ? false : abVar.eZV;
            boolean z6 = abVar == null ? false : abVar.fab;
            boolean z7 = abVar == null ? false : abVar.fac;
            this.fgQ.jD(abVar == null ? false : abVar.eZT);
            this.fgQ.H(z4, z3);
            this.fgQ.K(z5, z);
            this.fgQ.L(z7, z6);
            if (abVar != null) {
                this.fgQ.eZO = abVar.fai;
                if (abVar.fai) {
                    this.fgQ.aVn().setText(d.j.report_text);
                    this.fgQ.jG(false);
                }
            }
            i(z, z2, z3);
        }
    }

    public void aXk() {
        this.fgQ.aVt().setText(this.eVu.getResources().getString(d.j.haved_fans_call));
    }

    private void i(boolean z, boolean z2, boolean z3) {
        if (this.fgQ != null) {
            this.fgQ.adl();
            if (z) {
                this.fgQ.aVa().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_recommend_reversed_down_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fgQ.aVa().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
            }
            if (z2) {
                this.fgQ.aVa().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fgQ.aVa().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
            if (z3) {
                this.fgQ.aVl().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_host_only_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fgQ.aVl().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void or() {
        if (this.fgQ != null) {
            this.fgQ.aVv();
        }
        if (this.aHr == null) {
            this.aHr = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.fgP != null) {
                        g.a(c.this.fgP, c.this.eVu.getPageContext().getPageActivity());
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.fP().postDelayed(this.aHr, 100L);
    }

    public aa aXl() {
        return this.fgQ;
    }

    public View aXm() {
        return this.fgK;
    }

    public boolean acI() {
        return this.fgP != null && this.fgP.isShowing();
    }

    public void aGe() {
        if (this.fgQ != null) {
            this.fgQ.release();
        }
        this.fgP = null;
        this.fgQ = null;
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.aHr);
    }

    public void aXn() {
        if (this.fgH != null) {
            this.fgH.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.eVu.getPageContext(), i);
            aj.j(this.mNavigationBar.getBarBgView(), d.C0095d.cp_bg_line_d);
        }
        if (this.Sj != null) {
            aj.a(this.Sj, d.f.icon_nav_more_selector, d.f.icon_nav_more_selector);
        }
        if (this.fgJ != null) {
            aj.a(this.fgJ, d.f.icon_pb_navi_selector, d.f.icon_pb_navi_selector);
        }
        if (this.fgN != null) {
            this.fgN.onChangeSkinType(i);
        }
        aj.b(this.fgG, d.C0095d.cp_cont_b, d.C0095d.s_navbar_title_color);
    }

    public void qt(int i) {
        this.mNavigationBar.onChangeSkinType(this.eVu.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(d.f.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.eVu.getResources().getColor(d.C0095d.black_alpha85));
        if (this.fgJ != null) {
            this.fgJ.setImageResource(d.f.pb_ala_share);
        }
        if (this.Sj != null) {
            this.Sj.setImageResource(d.f.icon_vnav_more_bg);
        }
        this.fgG.setTextColor(this.eVu.getResources().getColor(d.C0095d.cp_cont_g));
        this.fgR.setImageResource(d.f.icon_return_bg);
    }

    public void aXo() {
        this.fgR.setVisibility(0);
        kj(false);
        if (this.fgH != null) {
            this.fgH.setVisibility(8);
        }
        if (this.fgI != null) {
            this.fgI.setVisibility(8);
        }
    }

    public void ki(boolean z) {
        this.fgR.setVisibility(0);
        kj(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.fgI != null) {
                this.fgI.setVisibility(0);
            }
            if (this.fgH != null) {
                this.fgH.setVisibility(0);
                return;
            }
            return;
        }
        if (this.fgI != null) {
            this.fgI.setVisibility(8);
        }
        if (this.fgH != null) {
            this.fgH.setVisibility(8);
        }
    }

    public void kj(boolean z) {
        if (!this.fdP && z && !"".equals(this.fgG.getText().toString())) {
            this.fgG.setVisibility(0);
        } else {
            this.fgG.setVisibility(8);
        }
    }

    public void kk(boolean z) {
        this.fgS = z;
    }

    public void kl(boolean z) {
        if (!this.fgS || TbadkCoreApplication.isLogin() || z) {
            if (z) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("call_fan_guide", false)) {
                    kl(false);
                    return;
                }
            } else if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_share", false)) {
                return;
            }
            this.fgU = z;
            View inflate = LayoutInflater.from(this.eVu.getPageContext().getContext()).inflate(d.h.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(d.g.arrow_up);
            TextView textView = (TextView) inflate.findViewById(d.g.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            if (!z) {
                layoutParams.gravity = 5;
                if (!TbadkCoreApplication.isLogin()) {
                    layoutParams.rightMargin = l.f(this.eVu, d.e.ds28);
                } else {
                    layoutParams.rightMargin = l.f(this.eVu, d.e.ds128);
                }
                textView.setText(d.j.share_tip);
                textView.setOnClickListener(this.fgZ);
                this.fgT = new PopupWindow(inflate, -2, -2);
                com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fgX);
                com.baidu.adp.lib.g.e.fP().postDelayed(this.fgX, 500L);
            }
        }
    }

    public void aXp() {
        if (this.fgX != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fgX);
        }
        if (this.fgY != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fgY);
        }
        aXq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXq() {
        g.a(this.fgT);
    }

    public void f(int i, int i2, boolean z) {
        if (i2 != 0 && aXj() != null && this.fgM != null) {
            if (!z) {
                if (this.fgM.getAlpha() != 1.0f) {
                    this.fgM.setAlpha(1.0f);
                    return;
                }
                return;
            }
            int measuredHeight = (aXj().getMeasuredHeight() + i2) - 1;
            if (i >= measuredHeight) {
                if (this.fgM.getAlpha() != 0.0f) {
                    this.fgM.setAlpha(0.0f);
                }
            } else if (i > aXj().getMeasuredHeight() && i < measuredHeight) {
                this.fgM.setAlpha(1.0f - (((i - aXj().getMeasuredHeight()) * 1.0f) / (measuredHeight - aXj().getMeasuredHeight())));
            } else if (i <= aXj().getMeasuredHeight() && this.fgM.getAlpha() != 1.0f) {
                this.fgM.setAlpha(1.0f);
            }
        }
    }
}
