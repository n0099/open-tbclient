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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
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
    private Runnable aQr;
    public final View aUR;
    private ImageView abu;
    private ImageView abv;
    private ImageView fFA;
    private PopupWindow fFC;
    private boolean fFD;
    private int fFE;
    private int fFF;
    private int fFG;
    public TextView fFp;
    public View fFq;
    public View fFr;
    private final ImageView fFs;
    private final LinearLayout fFt;
    public FrameLayout fFu;
    public PbNavbarUserConcernView fFv;
    public HeadPendantView fFw;
    public View fFx;
    private PbActivity ftp;
    public final NavigationBar mNavigationBar;
    private boolean fCv = false;
    private c fFy = null;
    private z fFz = null;
    private boolean fFB = false;
    private boolean fFH = false;
    private Runnable fFI = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.5
        @Override // java.lang.Runnable
        public void run() {
            View view;
            if (!b.this.fCv) {
                view = b.this.fFD ? b.this.fFq : b.this.fFr;
            } else {
                view = b.this.fFr;
            }
            if (view != null) {
                if (TbadkCoreApplication.isLogin() || !b.this.fFD) {
                    g.showPopupWindowAsDropDown(b.this.fFC, view);
                    if (!b.this.fFD) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_share", true);
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("call_fan_guide", true);
                    }
                    e.im().removeCallbacks(b.this.fFJ);
                    e.im().postDelayed(b.this.fFJ, TbConfig.NOTIFY_SOUND_INTERVAL);
                }
            }
        }
    };
    private Runnable fFJ = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.6
        @Override // java.lang.Runnable
        public void run() {
            b.this.bgm();
        }
    };
    private View.OnClickListener fFK = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.bgl();
        }
    };

    public b(PbActivity pbActivity) {
        this.fFE = 0;
        this.fFF = 0;
        this.fFG = 0;
        this.DS4 = 0;
        this.ftp = pbActivity;
        this.fFE = l.e(pbActivity, d.e.ds88);
        this.fFF = l.e(this.ftp.getPageContext().getPageActivity(), d.e.ds22);
        this.fFG = l.e(this.ftp.getPageContext().getPageActivity(), d.e.ds14);
        this.DS4 = l.e(this.ftp.getPageContext().getPageActivity(), d.e.ds4);
        this.mNavigationBar = (NavigationBar) this.ftp.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.ftp.atH();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.aUR = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.djp);
        this.fFp = this.mNavigationBar.setCenterTextTitle("");
        this.fFs = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.fFt = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int e = l.e(this.ftp.getPageContext().getPageActivity(), d.e.ds20);
        this.fFt.setPadding(e, 0, e, 0);
        al.a(this.fFs, d.f.icon_pb_play_small, d.f.icon_pb_play_small);
        this.fFs.setVisibility(8);
        this.fFp.setOnClickListener(pbActivity.djp);
        this.fFs.setOnClickListener(pbActivity.djp);
        this.fFA = (ImageView) this.aUR.findViewById(d.g.widget_navi_back_button);
    }

    public void kE(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.fCv = z;
        if (this.fFr == null && this.abv == null) {
            this.fFr = this.mNavigationBar.addCustomView(controlAlign, d.i.nb_item_floor_share, this.ftp.djp);
            this.abv = (ImageView) this.fFr.findViewById(d.g.navigationBarBtnShare);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.fFE, this.fFE);
            layoutParams.rightMargin = this.DS4;
            this.fFr.setLayoutParams(layoutParams);
            bgd();
        }
        if (this.fFq == null && this.abu == null) {
            this.fFq = this.mNavigationBar.addCustomView(controlAlign, d.i.nb_item_floor_more, this.ftp.djp);
            this.abu = (ImageView) this.fFq.findViewById(d.g.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.fFE, this.fFE);
            layoutParams2.rightMargin = this.fFG;
            this.fFq.setLayoutParams(layoutParams2);
            al.a(this.abu, d.f.icon_nav_more_selector, d.f.icon_nav_more_selector);
            this.fFq.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
        if (z) {
            if (this.fFu == null) {
                this.fFu = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.nav_user_concern_layout, (View.OnClickListener) null);
                this.fFv = (PbNavbarUserConcernView) this.fFu.findViewById(d.g.view_add_concern);
                this.fFx = this.fFu.findViewById(d.g.bg_user_photo);
                this.fFw = (HeadPendantView) this.fFu.findViewById(d.g.view_host_pendant_photo);
                this.fFw.setHasPendantStyle();
                if (this.fFw.getHeadView() != null) {
                    this.fFw.getHeadView().setIsRound(true);
                    this.fFw.getHeadView().setDefaultBgResource(d.C0141d.transparent);
                    this.fFw.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.setMargins(this.fFF, 0, 0, 0);
                this.fFu.setLayoutParams(layoutParams3);
                this.fFv.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                al.i(this.fFx, d.f.shape_photo_nav_bar_bg);
            }
        } else if (this.fFu != null) {
            this.mNavigationBar.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_LEFT).removeView(this.fFu);
        }
    }

    public void kl(boolean z) {
        if (this.fFq != null) {
            this.fFq.setVisibility(z ? 0 : 8);
        }
    }

    public void kF(boolean z) {
        this.fFH = z;
        bgd();
    }

    private void bgd() {
        if (this.abv != null && this.fFr != null) {
            if (this.fFH) {
                if (this.fFB) {
                    al.a(this.abv, d.f.icon_topbar_share_white_d, d.f.icon_topbar_share_white_d);
                } else {
                    ap.zp().c(this.abv, d.f.icon_topbar_share_n_svg, d.C0141d.cp_cont_e);
                }
                this.fFr.setClickable(false);
                return;
            }
            if (this.fFB) {
                al.a(this.abv, d.f.pb_ala_share, d.f.pb_ala_share);
            } else {
                ap.zp().c(this.abv, d.f.icon_topbar_share_n_svg, d.C0141d.select_topbar_icon_color_tint);
            }
            this.fFr.setClickable(true);
        }
    }

    public void kG(boolean z) {
        if (this.fFr != null && !z) {
            this.fFr.setVisibility(8);
        }
    }

    public NavigationBar bge() {
        return this.mNavigationBar;
    }

    public void kH(boolean z) {
        if (z) {
            this.aUR.setVisibility(0);
        } else {
            this.aUR.setVisibility(8);
        }
        kJ(z);
    }

    public void pf(String str) {
        if (!TextUtils.isEmpty(str) && !this.fCv) {
            this.fFp.setText(this.ftp.getResources().getString(d.k.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            kJ(true);
            i.tt().da(str);
            return;
        }
        kJ(false);
    }

    public void a(MetaData metaData, View.OnClickListener onClickListener) {
        if (metaData != null) {
            UtilHelper.showHeadImageViewBigV(this.fFw.getHeadView(), metaData);
            this.fFw.getHeadView().setImageDrawable(null);
            this.fFw.getPendantView().setImageDrawable(null);
            this.fFw.getHeadView().startLoad(metaData.getPortrait(), 28, false);
            this.fFw.getHeadView().setUserId(metaData.getUserId());
            this.fFw.getHeadView().setUserName(metaData.getUserName());
            this.fFw.getHeadView().setOnClickListener(onClickListener);
            if (metaData.getPendantData() != null && !StringUtils.isNull(metaData.getPendantData().ub())) {
                this.fFw.fj(metaData.getPendantData().ub());
            } else {
                this.fFw.fj(null);
            }
        }
    }

    public void a(aa aaVar) {
        if (!this.ftp.isProgressBarShown()) {
            if (this.fFy == null) {
                this.fFz = new z((PbActivity) this.ftp.getPageContext().getOrignalPage(), this.ftp.djp);
                this.fFy = new c(this.ftp.getPageContext().getPageActivity(), this.fFz.getView(), al.getDrawable(d.f.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.pb.pb.main.view.b.2
                    @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                    public void sO() {
                        b.this.ftp.bbT();
                    }

                    @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                    public void sP() {
                    }
                });
            }
            this.fFz.ben();
            if (this.fFB) {
                final Rect rect = new Rect();
                if (this.ftp.frH) {
                    e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.3
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.ftp.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                            int height = b.this.ftp.getWindow().getDecorView().getHeight();
                            b.this.fFy.setClippingEnabled(false);
                            b.this.fFy.showAtLocation(b.this.ftp.findViewById(d.g.pb_layout), 81, 0, height - rect.bottom);
                        }
                    }, 500L);
                } else {
                    this.ftp.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    int height = this.ftp.getWindow().getDecorView().getHeight();
                    this.fFy.setClippingEnabled(false);
                    this.fFy.showAtLocation(this.ftp.findViewById(d.g.pb_layout), 81, 0, height - rect.bottom);
                }
            } else {
                this.fFy.showAtLocation(this.ftp.findViewById(d.g.pb_layout), 17, 0, 0);
            }
            this.fFz.ka(aaVar == null ? false : aaVar.fyq);
            this.fFz.kc(aaVar == null ? false : aaVar.fyv);
            this.fFz.kd(aaVar == null ? false : aaVar.fyw);
            this.fFz.ke(aaVar == null ? false : aaVar.fyx);
            this.fFz.kf(aaVar == null ? true : aaVar.fyE);
            if (aaVar == null) {
                this.fFz.G(false, false);
                this.fFz.H(false, false);
                this.fFz.n(false, "");
            } else {
                this.fFz.G(aaVar.fyt, aaVar.fyB);
                this.fFz.H(aaVar.fyu, aaVar.fyA);
                this.fFz.n(StringUtils.isNull(aaVar.fyD) ? false : true, aaVar.fyD);
            }
            boolean z = aaVar == null ? false : aaVar.nU;
            boolean z2 = aaVar == null ? false : aaVar.fpw;
            boolean z3 = aaVar == null ? false : aaVar.isHostOnly;
            boolean z4 = aaVar == null ? false : aaVar.fyC;
            boolean z5 = aaVar == null ? false : aaVar.fys;
            boolean z6 = aaVar == null ? false : aaVar.fyy;
            boolean z7 = aaVar == null ? false : aaVar.fyz;
            this.fFz.kb(aaVar == null ? false : aaVar.fyr);
            this.fFz.F(z4, z3);
            this.fFz.I(z5, z);
            this.fFz.J(z7, z6);
            if (aaVar != null) {
                this.fFz.fym = aaVar.fyF;
                if (aaVar.fyF) {
                    this.fFz.beg().setText(d.k.report_text);
                    this.fFz.ke(false);
                }
            }
            i(z, z2, z3);
        }
    }

    public void bgf() {
        this.fFz.bem().setText(this.ftp.getResources().getString(d.k.haved_fans_call));
    }

    private void i(boolean z, boolean z2, boolean z3) {
        if (this.fFz != null) {
            this.fFz.setBackGround();
            if (z) {
                this.fFz.bdT().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(d.f.icon_recommend_reversed_down_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fFz.bdT().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(d.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
            }
            if (z2) {
                this.fFz.bdT().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(d.f.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fFz.bdT().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(d.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
            if (z3) {
                this.fFz.bee().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(d.f.icon_host_only_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fFz.bee().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(d.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void sL() {
        if (this.fFz != null) {
            this.fFz.beo();
        }
        if (this.aQr == null) {
            this.aQr = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.4
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.fFy != null) {
                        g.a(b.this.fFy, b.this.ftp.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.im().postDelayed(this.aQr, 100L);
    }

    public void bgg() {
        if (this.fFz != null) {
            this.fFz.beo();
        }
        if (this.fFy != null) {
            g.a(this.fFy, this.ftp.getPageContext().getPageActivity());
        }
    }

    public z bgh() {
        return this.fFz;
    }

    public View bgi() {
        return this.fFs;
    }

    public boolean ajN() {
        return this.fFy != null && this.fFy.isShowing();
    }

    public void aOZ() {
        if (this.fFz != null) {
            this.fFz.release();
        }
        this.fFy = null;
        this.fFz = null;
        e.im().removeCallbacks(this.aQr);
    }

    public void bgj() {
        if (this.fFq != null) {
            this.fFq.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.ftp.getPageContext(), i);
            al.i(this.mNavigationBar.getBarBgView(), d.C0141d.cp_bg_line_d);
        }
        ap.zp().c(this.fFA, d.f.icon_topbar_return_n_svg, d.C0141d.select_topbar_icon_color_tint);
        ap.zp().c(this.abu, d.f.icon_topbar_more_n_svg, d.C0141d.select_topbar_icon_color_tint);
        bgd();
        if (this.fFv != null) {
            this.fFv.onChangeSkinType(i);
        }
        if (this.fFx != null) {
            al.i(this.fFx, d.f.shape_photo_nav_bar_bg);
        }
        al.b(this.fFp, d.C0141d.cp_cont_b, d.C0141d.s_navbar_title_color);
    }

    public void qQ(int i) {
        this.mNavigationBar.onChangeSkinType(this.ftp.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(d.f.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.ftp.getResources().getColor(d.C0141d.black_alpha85));
        if (this.abv != null) {
            this.abv.setImageResource(d.f.pb_ala_share);
        }
        if (this.abu != null) {
            this.abu.setImageResource(d.f.icon_vnav_more_bg);
        }
        this.fFp.setTextColor(this.ftp.getResources().getColor(d.C0141d.cp_cont_g));
        this.fFA.setImageResource(d.f.icon_return_bg);
    }

    public void bgk() {
        this.fFA.setVisibility(0);
        kJ(false);
        if (this.fFq != null) {
            this.fFq.setVisibility(8);
        }
        if (this.fFr != null) {
            this.fFr.setVisibility(8);
        }
    }

    public void kI(boolean z) {
        this.fFA.setVisibility(0);
        kJ(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.fFr != null) {
                this.fFr.setVisibility(0);
            }
            if (this.fFq != null) {
                this.fFq.setVisibility(0);
                return;
            }
            return;
        }
        if (this.fFr != null) {
            this.fFr.setVisibility(8);
        }
        if (this.fFq != null) {
            this.fFq.setVisibility(8);
        }
    }

    public void kJ(boolean z) {
        if (!this.fCv && z && !"".equals(this.fFp.getText().toString())) {
            this.fFp.setVisibility(0);
        } else {
            this.fFp.setVisibility(8);
        }
    }

    public void kK(boolean z) {
        this.fFB = z;
    }

    public void kL(boolean z) {
        if (!this.fFB || TbadkCoreApplication.isLogin() || z) {
            if (z) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("call_fan_guide", false)) {
                    kL(false);
                    return;
                }
            } else if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_share", false)) {
                return;
            }
            this.fFD = z;
            View inflate = LayoutInflater.from(this.ftp.getPageContext().getContext()).inflate(d.i.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(d.g.arrow_up);
            TextView textView = (TextView) inflate.findViewById(d.g.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            if (!z) {
                layoutParams.gravity = 5;
                if (!TbadkCoreApplication.isLogin()) {
                    layoutParams.rightMargin = l.e(this.ftp, d.e.ds28);
                } else {
                    layoutParams.rightMargin = l.e(this.ftp, d.e.ds128);
                }
                textView.setText(d.k.share_tip);
                textView.setOnClickListener(this.fFK);
                this.fFC = new PopupWindow(inflate, -2, -2);
                e.im().removeCallbacks(this.fFI);
                e.im().postDelayed(this.fFI, 500L);
            }
        }
    }

    public void bgl() {
        if (this.fFI != null) {
            e.im().removeCallbacks(this.fFI);
        }
        if (this.fFJ != null) {
            e.im().removeCallbacks(this.fFJ);
        }
        bgm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgm() {
        g.a(this.fFC);
    }

    public void g(int i, int i2, boolean z) {
        if (i2 != 0 && bge() != null && this.fFu != null) {
            if (!z) {
                if (this.fFu.getAlpha() != 1.0f) {
                    this.fFu.setAlpha(1.0f);
                }
                if (this.fFv.getAlpha() != 1.0f) {
                    this.fFv.setAlpha(1.0f);
                    return;
                }
                return;
            }
            int measuredHeight = (bge().getMeasuredHeight() + i2) - 1;
            if (i >= measuredHeight) {
                if (this.fFu.getAlpha() != 0.0f) {
                    this.fFu.setAlpha(0.0f);
                }
                if (this.fFv.getAlpha() != 0.0f) {
                    this.fFv.setAlpha(0.0f);
                }
            } else if (i > bge().getMeasuredHeight() && i < measuredHeight) {
                float measuredHeight2 = ((i - bge().getMeasuredHeight()) * 1.0f) / (measuredHeight - bge().getMeasuredHeight());
                this.fFu.setAlpha(1.0f - measuredHeight2);
                this.fFv.setAlpha(1.0f - measuredHeight2);
            } else if (i <= bge().getMeasuredHeight()) {
                if (this.fFu.getAlpha() != 1.0f) {
                    this.fFu.setAlpha(1.0f);
                }
                if (this.fFv.getAlpha() != 1.0f) {
                    this.fFv.setAlpha(1.0f);
                }
            }
        }
    }
}
