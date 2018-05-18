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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.aa;
import com.baidu.tieba.pb.pb.main.z;
import com.baidu.tieba.pb.view.c;
/* loaded from: classes2.dex */
public class b {
    private int DS4;
    private ImageView Tl;
    private ImageView Tm;
    private Runnable aHU;
    public final View aMT;
    private PbActivity fhQ;
    public TextView ftY;
    public View ftZ;
    public View fua;
    private final ImageView fub;
    private final LinearLayout fuc;
    public FrameLayout fud;
    public PbNavbarUserConcernView fue;
    public HeadPendantView fuf;
    public View fug;
    private ImageView fuj;
    private PopupWindow ful;
    private boolean fum;
    private int fun;
    private int fuo;
    private int fup;
    public final NavigationBar mNavigationBar;
    private boolean frd = false;
    private c fuh = null;
    private z fui = null;
    private boolean fuk = false;
    private boolean fuq = false;
    private Runnable fur = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.5
        @Override // java.lang.Runnable
        public void run() {
            View view2;
            if (!b.this.frd) {
                view2 = b.this.fum ? b.this.ftZ : b.this.fua;
            } else {
                view2 = b.this.fua;
            }
            if (view2 != null) {
                if (TbadkCoreApplication.isLogin() || !b.this.fum) {
                    g.showPopupWindowAsDropDown(b.this.ful, view2);
                    if (!b.this.fum) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_share", true);
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("call_fan_guide", true);
                    }
                    e.fw().removeCallbacks(b.this.fus);
                    e.fw().postDelayed(b.this.fus, TbConfig.NOTIFY_SOUND_INTERVAL);
                }
            }
        }
    };
    private Runnable fus = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.6
        @Override // java.lang.Runnable
        public void run() {
            b.this.bbn();
        }
    };
    private View.OnClickListener fut = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            b.this.bbm();
        }
    };

    public b(PbActivity pbActivity) {
        this.fun = 0;
        this.fuo = 0;
        this.fup = 0;
        this.DS4 = 0;
        this.fhQ = pbActivity;
        this.fun = l.e(pbActivity, d.e.ds88);
        this.fuo = l.e(this.fhQ.getPageContext().getPageActivity(), d.e.ds22);
        this.fup = l.e(this.fhQ.getPageContext().getPageActivity(), d.e.ds14);
        this.DS4 = l.e(this.fhQ.getPageContext().getPageActivity(), d.e.ds4);
        this.mNavigationBar = (NavigationBar) this.fhQ.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.fhQ.apC();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.aMT = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.cZX);
        this.ftY = this.mNavigationBar.setCenterTextTitle("");
        this.fub = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.fuc = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int e = l.e(this.fhQ.getPageContext().getPageActivity(), d.e.ds20);
        this.fuc.setPadding(e, 0, e, 0);
        ak.a(this.fub, d.f.icon_pb_play_small, d.f.icon_pb_play_small);
        this.fub.setVisibility(8);
        this.ftY.setOnClickListener(pbActivity.cZX);
        this.fub.setOnClickListener(pbActivity.cZX);
        this.fuj = (ImageView) this.aMT.findViewById(d.g.widget_navi_back_button);
    }

    public void ky(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.frd = z;
        if (this.fua == null && this.Tm == null) {
            this.fua = this.mNavigationBar.addCustomView(controlAlign, d.i.nb_item_floor_share, this.fhQ.cZX);
            this.Tm = (ImageView) this.fua.findViewById(d.g.navigationBarBtnShare);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.fun, this.fun);
            layoutParams.rightMargin = this.DS4;
            this.fua.setLayoutParams(layoutParams);
            bbe();
        }
        if (this.ftZ == null && this.Tl == null) {
            this.ftZ = this.mNavigationBar.addCustomView(controlAlign, d.i.nb_item_floor_more, this.fhQ.cZX);
            this.Tl = (ImageView) this.ftZ.findViewById(d.g.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.fun, this.fun);
            layoutParams2.rightMargin = this.fup;
            this.ftZ.setLayoutParams(layoutParams2);
            ak.a(this.Tl, d.f.icon_nav_more_selector, d.f.icon_nav_more_selector);
            this.ftZ.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
        if (z) {
            if (this.fud == null) {
                this.fud = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.nav_user_concern_layout, (View.OnClickListener) null);
                this.fue = (PbNavbarUserConcernView) this.fud.findViewById(d.g.view_add_concern);
                this.fug = this.fud.findViewById(d.g.bg_user_photo);
                this.fuf = (HeadPendantView) this.fud.findViewById(d.g.view_host_pendant_photo);
                this.fuf.setHasPendantStyle();
                if (this.fuf.getHeadView() != null) {
                    this.fuf.getHeadView().setIsRound(true);
                    this.fuf.getHeadView().setDefaultBgResource(d.C0126d.transparent);
                    this.fuf.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.setMargins(this.fuo, 0, 0, 0);
                this.fud.setLayoutParams(layoutParams3);
                this.fue.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                ak.i(this.fug, d.f.shape_photo_nav_bar_bg);
            }
        } else if (this.fud != null) {
            this.mNavigationBar.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_LEFT).removeView(this.fud);
        }
    }

    public void kf(boolean z) {
        if (this.ftZ != null) {
            this.ftZ.setVisibility(z ? 0 : 8);
        }
    }

    public void kz(boolean z) {
        this.fuq = z;
        bbe();
    }

    private void bbe() {
        if (this.Tm != null && this.fua != null) {
            if (this.fuq) {
                if (this.fuk) {
                    ak.a(this.Tm, d.f.icon_topbar_share_white_d, d.f.icon_topbar_share_white_d);
                } else {
                    ao.vO().c(this.Tm, d.f.icon_topbar_share_n_svg, d.C0126d.cp_cont_e);
                }
                this.fua.setClickable(false);
                return;
            }
            if (this.fuk) {
                ak.a(this.Tm, d.f.pb_ala_share, d.f.pb_ala_share);
            } else {
                ao.vO().c(this.Tm, d.f.icon_topbar_share_n_svg, d.f.select_topbar_icon_color_tint);
            }
            this.fua.setClickable(true);
        }
    }

    public void kA(boolean z) {
        if (this.fua != null && !z) {
            this.fua.setVisibility(8);
        }
    }

    public NavigationBar bbf() {
        return this.mNavigationBar;
    }

    public void kB(boolean z) {
        if (z) {
            this.aMT.setVisibility(0);
        } else {
            this.aMT.setVisibility(8);
        }
        kD(z);
    }

    public void ot(String str) {
        if (!TextUtils.isEmpty(str) && !this.frd) {
            this.ftY.setText(this.fhQ.getResources().getString(d.k.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            kD(true);
            i.pX().cC(str);
            return;
        }
        kD(false);
    }

    public void a(MetaData metaData, View.OnClickListener onClickListener) {
        if (metaData != null) {
            UtilHelper.showHeadImageViewBigV(this.fuf.getHeadView(), metaData);
            this.fuf.getHeadView().setImageDrawable(null);
            this.fuf.getPendantView().setImageDrawable(null);
            this.fuf.getHeadView().startLoad(metaData.getPortrait(), 28, false);
            this.fuf.getHeadView().setUserId(metaData.getUserId());
            this.fuf.getHeadView().setUserName(metaData.getUserName());
            this.fuf.getHeadView().setOnClickListener(onClickListener);
            if (metaData.getPendantData() != null && !StringUtils.isNull(metaData.getPendantData().qF())) {
                this.fuf.eK(metaData.getPendantData().qF());
            } else {
                this.fuf.eK(null);
            }
        }
    }

    public void a(aa aaVar) {
        if (!this.fhQ.isProgressBarShown()) {
            if (this.fuh == null) {
                this.fui = new z((PbActivity) this.fhQ.getPageContext().getOrignalPage(), this.fhQ.cZX);
                this.fuh = new c(this.fhQ.getPageContext().getPageActivity(), this.fui.getView(), ak.getDrawable(d.f.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.pb.pb.main.view.b.2
                    @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                    public void pt() {
                        b.this.fhQ.aWX();
                    }

                    @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                    public void pu() {
                    }
                });
            }
            this.fui.aZp();
            if (this.fuk) {
                final Rect rect = new Rect();
                if (this.fhQ.fgi) {
                    e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.3
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.fhQ.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                            int height = b.this.fhQ.getWindow().getDecorView().getHeight();
                            b.this.fuh.setClippingEnabled(false);
                            b.this.fuh.showAtLocation(b.this.fhQ.findViewById(d.g.pb_layout), 81, 0, height - rect.bottom);
                        }
                    }, 500L);
                } else {
                    this.fhQ.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    int height = this.fhQ.getWindow().getDecorView().getHeight();
                    this.fuh.setClippingEnabled(false);
                    this.fuh.showAtLocation(this.fhQ.findViewById(d.g.pb_layout), 81, 0, height - rect.bottom);
                }
            } else {
                this.fuh.showAtLocation(this.fhQ.findViewById(d.g.pb_layout), 17, 0, 0);
            }
            this.fui.jU(aaVar == null ? false : aaVar.fmV);
            this.fui.jW(aaVar == null ? false : aaVar.fnb);
            this.fui.jX(aaVar == null ? false : aaVar.fnc);
            this.fui.jY(aaVar == null ? false : aaVar.fnd);
            this.fui.jZ(aaVar == null ? true : aaVar.fnk);
            if (aaVar == null) {
                this.fui.G(false, false);
                this.fui.H(false, false);
                this.fui.m(false, "");
            } else {
                this.fui.G(aaVar.fmZ, aaVar.fnh);
                this.fui.H(aaVar.fna, aaVar.fng);
                this.fui.m(StringUtils.isNull(aaVar.fnj) ? false : true, aaVar.fnj);
            }
            boolean z = aaVar == null ? false : aaVar.fmX;
            boolean z2 = aaVar == null ? false : aaVar.fdZ;
            boolean z3 = aaVar == null ? false : aaVar.isHostOnly;
            boolean z4 = aaVar == null ? false : aaVar.fni;
            boolean z5 = aaVar == null ? false : aaVar.fmY;
            boolean z6 = aaVar == null ? false : aaVar.fne;
            boolean z7 = aaVar == null ? false : aaVar.fnf;
            this.fui.jV(aaVar == null ? false : aaVar.fmW);
            this.fui.F(z4, z3);
            this.fui.I(z5, z);
            this.fui.J(z7, z6);
            if (aaVar != null) {
                this.fui.fmR = aaVar.fnl;
                if (aaVar.fnl) {
                    this.fui.aZi().setText(d.k.report_text);
                    this.fui.jY(false);
                }
            }
            i(z, z2, z3);
        }
    }

    public void bbg() {
        this.fui.aZo().setText(this.fhQ.getResources().getString(d.k.haved_fans_call));
    }

    private void i(boolean z, boolean z2, boolean z3) {
        if (this.fui != null) {
            this.fui.setBackGround();
            if (z) {
                this.fui.aYV().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ak.getDrawable(d.f.icon_recommend_reversed_down_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fui.aYV().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ak.getDrawable(d.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
            }
            if (z2) {
                this.fui.aYV().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ak.getDrawable(d.f.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fui.aYV().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ak.getDrawable(d.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
            if (z3) {
                this.fui.aZg().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ak.getDrawable(d.f.icon_host_only_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fui.aZg().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ak.getDrawable(d.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void pq() {
        if (this.fui != null) {
            this.fui.aZq();
        }
        if (this.aHU == null) {
            this.aHU = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.4
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.fuh != null) {
                        g.a(b.this.fuh, b.this.fhQ.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.fw().postDelayed(this.aHU, 100L);
    }

    public void bbh() {
        if (this.fui != null) {
            this.fui.aZq();
        }
        if (this.fuh != null) {
            g.a(this.fuh, this.fhQ.getPageContext().getPageActivity());
        }
    }

    public z bbi() {
        return this.fui;
    }

    public View bbj() {
        return this.fub;
    }

    public boolean agf() {
        return this.fuh != null && this.fuh.isShowing();
    }

    public void aKd() {
        if (this.fui != null) {
            this.fui.release();
        }
        this.fuh = null;
        this.fui = null;
        e.fw().removeCallbacks(this.aHU);
    }

    public void bbk() {
        if (this.ftZ != null) {
            this.ftZ.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.fhQ.getPageContext(), i);
            ak.i(this.mNavigationBar.getBarBgView(), d.C0126d.cp_bg_line_d);
        }
        ao.vO().c(this.fuj, d.f.icon_topbar_return_n_svg, d.f.select_topbar_icon_color_tint);
        ao.vO().c(this.Tl, d.f.icon_topbar_more_n_svg, d.f.select_topbar_icon_color_tint);
        bbe();
        if (this.fue != null) {
            this.fue.onChangeSkinType(i);
        }
        if (this.fug != null) {
            ak.i(this.fug, d.f.shape_photo_nav_bar_bg);
        }
        ak.b(this.ftY, d.C0126d.cp_cont_b, d.C0126d.s_navbar_title_color);
    }

    public void qE(int i) {
        this.mNavigationBar.onChangeSkinType(this.fhQ.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(d.f.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.fhQ.getResources().getColor(d.C0126d.black_alpha85));
        if (this.Tm != null) {
            this.Tm.setImageResource(d.f.pb_ala_share);
        }
        if (this.Tl != null) {
            this.Tl.setImageResource(d.f.icon_vnav_more_bg);
        }
        this.ftY.setTextColor(this.fhQ.getResources().getColor(d.C0126d.cp_cont_g));
        this.fuj.setImageResource(d.f.icon_return_bg);
    }

    public void bbl() {
        this.fuj.setVisibility(0);
        kD(false);
        if (this.ftZ != null) {
            this.ftZ.setVisibility(8);
        }
        if (this.fua != null) {
            this.fua.setVisibility(8);
        }
    }

    public void kC(boolean z) {
        this.fuj.setVisibility(0);
        kD(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.fua != null) {
                this.fua.setVisibility(0);
            }
            if (this.ftZ != null) {
                this.ftZ.setVisibility(0);
                return;
            }
            return;
        }
        if (this.fua != null) {
            this.fua.setVisibility(8);
        }
        if (this.ftZ != null) {
            this.ftZ.setVisibility(8);
        }
    }

    public void kD(boolean z) {
        if (!this.frd && z && !"".equals(this.ftY.getText().toString())) {
            this.ftY.setVisibility(0);
        } else {
            this.ftY.setVisibility(8);
        }
    }

    public void kE(boolean z) {
        this.fuk = z;
    }

    public void kF(boolean z) {
        if (!this.fuk || TbadkCoreApplication.isLogin() || z) {
            if (z) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("call_fan_guide", false)) {
                    kF(false);
                    return;
                }
            } else if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_share", false)) {
                return;
            }
            this.fum = z;
            View inflate = LayoutInflater.from(this.fhQ.getPageContext().getContext()).inflate(d.i.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(d.g.arrow_up);
            TextView textView = (TextView) inflate.findViewById(d.g.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            if (!z) {
                layoutParams.gravity = 5;
                if (!TbadkCoreApplication.isLogin()) {
                    layoutParams.rightMargin = l.e(this.fhQ, d.e.ds28);
                } else {
                    layoutParams.rightMargin = l.e(this.fhQ, d.e.ds128);
                }
                textView.setText(d.k.share_tip);
                textView.setOnClickListener(this.fut);
                this.ful = new PopupWindow(inflate, -2, -2);
                e.fw().removeCallbacks(this.fur);
                e.fw().postDelayed(this.fur, 500L);
            }
        }
    }

    public void bbm() {
        if (this.fur != null) {
            e.fw().removeCallbacks(this.fur);
        }
        if (this.fus != null) {
            e.fw().removeCallbacks(this.fus);
        }
        bbn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbn() {
        g.a(this.ful);
    }

    public void g(int i, int i2, boolean z) {
        if (i2 != 0 && bbf() != null && this.fud != null) {
            if (!z) {
                if (this.fud.getAlpha() != 1.0f) {
                    this.fud.setAlpha(1.0f);
                }
                if (this.fue.getAlpha() != 1.0f) {
                    this.fue.setAlpha(1.0f);
                    return;
                }
                return;
            }
            int measuredHeight = (bbf().getMeasuredHeight() + i2) - 1;
            if (i >= measuredHeight) {
                if (this.fud.getAlpha() != 0.0f) {
                    this.fud.setAlpha(0.0f);
                }
                if (this.fue.getAlpha() != 0.0f) {
                    this.fue.setAlpha(0.0f);
                }
            } else if (i > bbf().getMeasuredHeight() && i < measuredHeight) {
                float measuredHeight2 = ((i - bbf().getMeasuredHeight()) * 1.0f) / (measuredHeight - bbf().getMeasuredHeight());
                this.fud.setAlpha(1.0f - measuredHeight2);
                this.fue.setAlpha(1.0f - measuredHeight2);
            } else if (i <= bbf().getMeasuredHeight()) {
                if (this.fud.getAlpha() != 1.0f) {
                    this.fud.setAlpha(1.0f);
                }
                if (this.fue.getAlpha() != 1.0f) {
                    this.fue.setAlpha(1.0f);
                }
            }
        }
    }
}
