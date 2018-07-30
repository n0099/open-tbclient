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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.aa;
import com.baidu.tieba.pb.pb.main.ab;
import com.baidu.tieba.pb.view.c;
/* loaded from: classes2.dex */
public class b {
    private int DS4;
    private Runnable aRn;
    public final View aVP;
    private ImageView aaZ;
    private ImageView aba;
    private int ccU;
    public TextView fJF;
    public View fJG;
    public View fJH;
    private final ImageView fJI;
    private final LinearLayout fJJ;
    public FrameLayout fJK;
    public PbNavbarUserConcernView fJL;
    public HeadPendantView fJM;
    public View fJN;
    private ImageView fJQ;
    private PopupWindow fJS;
    private boolean fJT;
    private int fJU;
    private int fJV;
    private PbActivity fxt;
    public final NavigationBar mNavigationBar;
    private boolean fGJ = false;
    private c fJO = null;
    private aa fJP = null;
    private boolean fJR = false;
    private boolean fJW = false;
    private Runnable fJX = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.5
        @Override // java.lang.Runnable
        public void run() {
            View view;
            if (!b.this.fGJ) {
                view = b.this.fJT ? b.this.fJG : b.this.fJH;
            } else {
                view = b.this.fJH;
            }
            if (view != null) {
                if (TbadkCoreApplication.isLogin() || !b.this.fJT) {
                    g.showPopupWindowAsDropDown(b.this.fJS, view);
                    if (!b.this.fJT) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_share", true);
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("call_fan_guide", true);
                    }
                    e.in().removeCallbacks(b.this.fJY);
                    e.in().postDelayed(b.this.fJY, TbConfig.NOTIFY_SOUND_INTERVAL);
                }
            }
        }
    };
    private Runnable fJY = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.6
        @Override // java.lang.Runnable
        public void run() {
            b.this.bfn();
        }
    };
    private View.OnClickListener fJZ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.bfm();
        }
    };

    public b(PbActivity pbActivity) {
        this.ccU = 0;
        this.fJU = 0;
        this.fJV = 0;
        this.DS4 = 0;
        this.fxt = pbActivity;
        this.ccU = l.f(pbActivity, d.e.ds88);
        this.fJU = l.f(this.fxt.getPageContext().getPageActivity(), d.e.ds22);
        this.fJV = l.f(this.fxt.getPageContext().getPageActivity(), d.e.ds14);
        this.DS4 = l.f(this.fxt.getPageContext().getPageActivity(), d.e.ds4);
        this.mNavigationBar = (NavigationBar) this.fxt.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.fxt.auC();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.aVP = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.doi);
        this.fJF = this.mNavigationBar.setCenterTextTitle("");
        this.fJI = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.fJJ = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int f = l.f(this.fxt.getPageContext().getPageActivity(), d.e.ds20);
        this.fJJ.setPadding(f, 0, f, 0);
        am.a(this.fJI, d.f.icon_pb_play_small, d.f.icon_pb_play_small);
        this.fJI.setVisibility(8);
        this.fJF.setOnClickListener(pbActivity.doi);
        this.fJI.setOnClickListener(pbActivity.doi);
        this.fJQ = (ImageView) this.aVP.findViewById(d.g.widget_navi_back_button);
    }

    public void kA(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.fGJ = z;
        if (this.fJH == null && this.aba == null) {
            this.fJH = this.mNavigationBar.addCustomView(controlAlign, d.h.nb_item_floor_share, this.fxt.doi);
            this.aba = (ImageView) this.fJH.findViewById(d.g.navigationBarBtnShare);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ccU, this.ccU);
            layoutParams.rightMargin = this.DS4;
            this.fJH.setLayoutParams(layoutParams);
            bfe();
        }
        if (this.fJG == null && this.aaZ == null) {
            this.fJG = this.mNavigationBar.addCustomView(controlAlign, d.h.nb_item_floor_more, this.fxt.doi);
            this.aaZ = (ImageView) this.fJG.findViewById(d.g.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.ccU, this.ccU);
            layoutParams2.rightMargin = this.fJV;
            this.fJG.setLayoutParams(layoutParams2);
            am.a(this.aaZ, d.f.icon_nav_more_selector, d.f.icon_nav_more_selector);
            this.fJG.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
        if (z) {
            if (this.fJK == null) {
                this.fJK = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.nav_user_concern_layout, (View.OnClickListener) null);
                this.fJL = (PbNavbarUserConcernView) this.fJK.findViewById(d.g.view_add_concern);
                this.fJN = this.fJK.findViewById(d.g.bg_user_photo);
                this.fJM = (HeadPendantView) this.fJK.findViewById(d.g.view_host_pendant_photo);
                this.fJM.setHasPendantStyle();
                if (this.fJM.getHeadView() != null) {
                    this.fJM.getHeadView().setIsRound(true);
                    this.fJM.getHeadView().setDefaultBgResource(d.C0140d.transparent);
                    this.fJM.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.setMargins(this.fJU, 0, 0, 0);
                this.fJK.setLayoutParams(layoutParams3);
                this.fJL.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                am.i(this.fJN, d.f.shape_photo_nav_bar_bg);
            }
        } else if (this.fJK != null) {
            this.mNavigationBar.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_LEFT).removeView(this.fJK);
        }
    }

    public void kh(boolean z) {
        if (this.fJG != null) {
            this.fJG.setVisibility(z ? 0 : 8);
        }
    }

    public void kB(boolean z) {
        this.fJW = z;
        bfe();
    }

    private void bfe() {
        if (this.aba != null && this.fJH != null) {
            if (this.fJW) {
                if (this.fJR) {
                    am.a(this.aba, d.f.icon_topbar_share_white_d, d.f.icon_topbar_share_white_d);
                } else {
                    aq.zv().c(this.aba, d.f.icon_topbar_share_n_svg, d.C0140d.cp_cont_e);
                }
                this.fJH.setClickable(false);
                return;
            }
            if (this.fJR) {
                am.a(this.aba, d.f.pb_ala_share, d.f.pb_ala_share);
            } else {
                aq.zv().c(this.aba, d.f.icon_topbar_share_n_svg, d.C0140d.select_topbar_icon_color_tint);
            }
            this.fJH.setClickable(true);
        }
    }

    public void kC(boolean z) {
        if (this.fJH != null && !z) {
            this.fJH.setVisibility(8);
        }
    }

    public NavigationBar bff() {
        return this.mNavigationBar;
    }

    public void kD(boolean z) {
        if (z) {
            this.aVP.setVisibility(0);
        } else {
            this.aVP.setVisibility(8);
        }
        kF(z);
    }

    public void pi(String str) {
        if (!TextUtils.isEmpty(str) && !this.fGJ) {
            this.fJF.setText(this.fxt.getResources().getString(d.j.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            kF(true);
            i.te().cZ(str);
            return;
        }
        kF(false);
    }

    public void a(MetaData metaData, View.OnClickListener onClickListener) {
        if (metaData != null) {
            UtilHelper.showHeadImageViewBigV(this.fJM.getHeadView(), metaData);
            this.fJM.getHeadView().setImageDrawable(null);
            this.fJM.getPendantView().setImageDrawable(null);
            this.fJM.getHeadView().startLoad(metaData.getPortrait(), 28, false);
            this.fJM.getHeadView().setUserId(metaData.getUserId());
            this.fJM.getHeadView().setUserName(metaData.getUserName());
            this.fJM.getHeadView().setOnClickListener(onClickListener);
            if (metaData.getPendantData() != null && !StringUtils.isNull(metaData.getPendantData().tU())) {
                this.fJM.fl(metaData.getPendantData().tU());
            } else {
                this.fJM.fl(null);
            }
        }
    }

    public void a(ab abVar) {
        if (!this.fxt.isProgressBarShown()) {
            if (this.fJO == null) {
                this.fJP = new aa((PbActivity) this.fxt.getPageContext().getOrignalPage(), this.fxt.doi);
                this.fJO = new c(this.fxt.getPageContext().getPageActivity(), this.fJP.getView(), am.getDrawable(d.f.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.pb.pb.main.view.b.2
                    @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                    public void sC() {
                        b.this.fxt.baT();
                    }

                    @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                    public void sD() {
                    }
                });
            }
            this.fJP.bdo();
            if (this.fJR) {
                final Rect rect = new Rect();
                if (this.fxt.fvL) {
                    e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.3
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.fxt.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                            int height = b.this.fxt.getWindow().getDecorView().getHeight();
                            b.this.fJO.setClippingEnabled(false);
                            b.this.fJO.showAtLocation(b.this.fxt.findViewById(d.g.pb_layout), 81, 0, height - rect.bottom);
                        }
                    }, 500L);
                } else {
                    this.fxt.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    int height = this.fxt.getWindow().getDecorView().getHeight();
                    this.fJO.setClippingEnabled(false);
                    this.fJO.showAtLocation(this.fxt.findViewById(d.g.pb_layout), 81, 0, height - rect.bottom);
                }
            } else {
                this.fJO.showAtLocation(this.fxt.findViewById(d.g.pb_layout), 17, 0, 0);
            }
            this.fJP.jW(abVar == null ? false : abVar.fCE);
            this.fJP.jY(abVar == null ? false : abVar.fCJ);
            this.fJP.jZ(abVar == null ? false : abVar.fCK);
            this.fJP.ka(abVar == null ? false : abVar.fCL);
            this.fJP.kb(abVar == null ? true : abVar.fCS);
            if (abVar == null) {
                this.fJP.J(false, false);
                this.fJP.K(false, false);
                this.fJP.n(false, "");
            } else {
                this.fJP.J(abVar.fCH, abVar.fCP);
                this.fJP.K(abVar.fCI, abVar.fCO);
                this.fJP.n(StringUtils.isNull(abVar.fCR) ? false : true, abVar.fCR);
            }
            boolean z = abVar == null ? false : abVar.nJ;
            boolean z2 = abVar == null ? false : abVar.ftz;
            boolean z3 = abVar == null ? false : abVar.isHostOnly;
            boolean z4 = abVar == null ? false : abVar.fCQ;
            boolean z5 = abVar == null ? false : abVar.fCG;
            boolean z6 = abVar == null ? false : abVar.fCM;
            boolean z7 = abVar == null ? false : abVar.fCN;
            this.fJP.jX(abVar == null ? false : abVar.fCF);
            this.fJP.I(z4, z3);
            this.fJP.L(z5, z);
            this.fJP.M(z7, z6);
            if (abVar != null) {
                this.fJP.fCA = abVar.fCT;
                if (abVar.fCT) {
                    this.fJP.bdh().setText(d.j.report_text);
                    this.fJP.ka(false);
                }
            }
            h(z, z2, z3);
        }
    }

    public void bfg() {
        this.fJP.bdn().setText(this.fxt.getResources().getString(d.j.haved_fans_call));
    }

    private void h(boolean z, boolean z2, boolean z3) {
        if (this.fJP != null) {
            this.fJP.setBackGround();
            if (z) {
                this.fJP.bcU().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(d.f.icon_recommend_reversed_down_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fJP.bcU().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(d.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
            }
            if (z2) {
                this.fJP.bcU().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(d.f.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fJP.bcU().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(d.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
            if (z3) {
                this.fJP.bdf().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(d.f.icon_host_only_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fJP.bdf().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(d.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void sz() {
        if (this.fJP != null) {
            this.fJP.bdp();
        }
        if (this.aRn == null) {
            this.aRn = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.4
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.fJO != null) {
                        g.a(b.this.fJO, b.this.fxt.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.in().postDelayed(this.aRn, 100L);
    }

    public void bfh() {
        if (this.fJP != null) {
            this.fJP.bdp();
        }
        if (this.fJO != null) {
            g.a(this.fJO, this.fxt.getPageContext().getPageActivity());
        }
    }

    public aa bfi() {
        return this.fJP;
    }

    public View bfj() {
        return this.fJI;
    }

    public boolean ajF() {
        return this.fJO != null && this.fJO.isShowing();
    }

    public void aQG() {
        if (this.fJP != null) {
            this.fJP.release();
        }
        this.fJO = null;
        this.fJP = null;
        e.in().removeCallbacks(this.aRn);
    }

    public void bfk() {
        if (this.fJG != null) {
            this.fJG.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.fxt.getPageContext(), i);
            am.i(this.mNavigationBar.getBarBgView(), d.C0140d.cp_bg_line_d);
        }
        aq.zv().c(this.fJQ, d.f.icon_topbar_return_n_svg, d.C0140d.select_topbar_icon_color_tint);
        aq.zv().c(this.aaZ, d.f.icon_topbar_more_n_svg, d.C0140d.select_topbar_icon_color_tint);
        bfe();
        if (this.fJL != null) {
            this.fJL.onChangeSkinType(i);
        }
        if (this.fJN != null) {
            am.i(this.fJN, d.f.shape_photo_nav_bar_bg);
        }
        am.b(this.fJF, d.C0140d.cp_cont_b, d.C0140d.s_navbar_title_color);
    }

    public void qV(int i) {
        this.mNavigationBar.onChangeSkinType(this.fxt.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(d.f.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.fxt.getResources().getColor(d.C0140d.black_alpha85));
        if (this.aba != null) {
            this.aba.setImageResource(d.f.pb_ala_share);
        }
        if (this.aaZ != null) {
            this.aaZ.setImageResource(d.f.icon_vnav_more_bg);
        }
        this.fJF.setTextColor(this.fxt.getResources().getColor(d.C0140d.cp_cont_g));
        this.fJQ.setImageResource(d.f.icon_return_bg);
    }

    public void bfl() {
        this.fJQ.setVisibility(0);
        kF(false);
        if (this.fJG != null) {
            this.fJG.setVisibility(8);
        }
        if (this.fJH != null) {
            this.fJH.setVisibility(8);
        }
    }

    public void kE(boolean z) {
        this.fJQ.setVisibility(0);
        kF(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.fJH != null) {
                this.fJH.setVisibility(0);
            }
            if (this.fJG != null) {
                this.fJG.setVisibility(0);
                return;
            }
            return;
        }
        if (this.fJH != null) {
            this.fJH.setVisibility(8);
        }
        if (this.fJG != null) {
            this.fJG.setVisibility(8);
        }
    }

    public void kF(boolean z) {
        if (!this.fGJ && z && !"".equals(this.fJF.getText().toString())) {
            this.fJF.setVisibility(0);
        } else {
            this.fJF.setVisibility(8);
        }
    }

    public void kG(boolean z) {
        this.fJR = z;
    }

    public void kH(boolean z) {
        if (!this.fJR || TbadkCoreApplication.isLogin() || z) {
            if (z) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("call_fan_guide", false)) {
                    kH(false);
                    return;
                }
            } else if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_share", false)) {
                return;
            }
            this.fJT = z;
            View inflate = LayoutInflater.from(this.fxt.getPageContext().getContext()).inflate(d.h.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(d.g.arrow_up);
            TextView textView = (TextView) inflate.findViewById(d.g.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            if (!z) {
                layoutParams.gravity = 5;
                if (!TbadkCoreApplication.isLogin()) {
                    layoutParams.rightMargin = l.f(this.fxt, d.e.ds28);
                } else {
                    layoutParams.rightMargin = l.f(this.fxt, d.e.ds128);
                }
                textView.setText(d.j.share_tip);
                textView.setOnClickListener(this.fJZ);
                this.fJS = new PopupWindow(inflate, -2, -2);
                e.in().removeCallbacks(this.fJX);
                e.in().postDelayed(this.fJX, 500L);
            }
        }
    }

    public void bfm() {
        if (this.fJX != null) {
            e.in().removeCallbacks(this.fJX);
        }
        if (this.fJY != null) {
            e.in().removeCallbacks(this.fJY);
        }
        bfn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfn() {
        g.a(this.fJS);
    }

    public void g(int i, int i2, boolean z) {
        if (i2 != 0 && bff() != null && this.fJK != null) {
            if (!z) {
                if (this.fJK.getAlpha() != 1.0f) {
                    this.fJK.setAlpha(1.0f);
                }
                if (this.fJL.getAlpha() != 1.0f) {
                    this.fJL.setAlpha(1.0f);
                    return;
                }
                return;
            }
            int measuredHeight = (bff().getMeasuredHeight() + i2) - 1;
            if (i >= measuredHeight) {
                if (this.fJK.getAlpha() != 0.0f) {
                    this.fJK.setAlpha(0.0f);
                }
                if (this.fJL.getAlpha() != 0.0f) {
                    this.fJL.setAlpha(0.0f);
                }
            } else if (i > bff().getMeasuredHeight() && i < measuredHeight) {
                float measuredHeight2 = ((i - bff().getMeasuredHeight()) * 1.0f) / (measuredHeight - bff().getMeasuredHeight());
                this.fJK.setAlpha(1.0f - measuredHeight2);
                this.fJL.setAlpha(1.0f - measuredHeight2);
            } else if (i <= bff().getMeasuredHeight()) {
                if (this.fJK.getAlpha() != 1.0f) {
                    this.fJK.setAlpha(1.0f);
                }
                if (this.fJL.getAlpha() != 1.0f) {
                    this.fJL.setAlpha(1.0f);
                }
            }
        }
    }
}
