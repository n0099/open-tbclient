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
    public final View aVN;
    private ImageView abx;
    private ImageView aby;
    private ImageView fJB;
    private PopupWindow fJD;
    private boolean fJE;
    private int fJF;
    private int fJG;
    private int fJH;
    public TextView fJq;
    public View fJr;
    public View fJs;
    private final ImageView fJt;
    private final LinearLayout fJu;
    public FrameLayout fJv;
    public PbNavbarUserConcernView fJw;
    public HeadPendantView fJx;
    public View fJy;
    private PbActivity fxh;
    public final NavigationBar mNavigationBar;
    private boolean fGw = false;
    private c fJz = null;
    private aa fJA = null;
    private boolean fJC = false;
    private boolean fJI = false;
    private Runnable fJJ = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.5
        @Override // java.lang.Runnable
        public void run() {
            View view;
            if (!b.this.fGw) {
                view = b.this.fJE ? b.this.fJr : b.this.fJs;
            } else {
                view = b.this.fJs;
            }
            if (view != null) {
                if (TbadkCoreApplication.isLogin() || !b.this.fJE) {
                    g.showPopupWindowAsDropDown(b.this.fJD, view);
                    if (!b.this.fJE) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_share", true);
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("call_fan_guide", true);
                    }
                    e.im().removeCallbacks(b.this.fJK);
                    e.im().postDelayed(b.this.fJK, TbConfig.NOTIFY_SOUND_INTERVAL);
                }
            }
        }
    };
    private Runnable fJK = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.6
        @Override // java.lang.Runnable
        public void run() {
            b.this.bgU();
        }
    };
    private View.OnClickListener fJL = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.bgT();
        }
    };

    public b(PbActivity pbActivity) {
        this.fJF = 0;
        this.fJG = 0;
        this.fJH = 0;
        this.DS4 = 0;
        this.fxh = pbActivity;
        this.fJF = l.e(pbActivity, d.e.ds88);
        this.fJG = l.e(this.fxh.getPageContext().getPageActivity(), d.e.ds22);
        this.fJH = l.e(this.fxh.getPageContext().getPageActivity(), d.e.ds14);
        this.DS4 = l.e(this.fxh.getPageContext().getPageActivity(), d.e.ds4);
        this.mNavigationBar = (NavigationBar) this.fxh.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.fxh.atY();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.aVN = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.dlq);
        this.fJq = this.mNavigationBar.setCenterTextTitle("");
        this.fJt = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.fJu = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int e = l.e(this.fxh.getPageContext().getPageActivity(), d.e.ds20);
        this.fJu.setPadding(e, 0, e, 0);
        am.a(this.fJt, d.f.icon_pb_play_small, d.f.icon_pb_play_small);
        this.fJt.setVisibility(8);
        this.fJq.setOnClickListener(pbActivity.dlq);
        this.fJt.setOnClickListener(pbActivity.dlq);
        this.fJB = (ImageView) this.aVN.findViewById(d.g.widget_navi_back_button);
    }

    public void kO(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.fGw = z;
        if (this.fJs == null && this.aby == null) {
            this.fJs = this.mNavigationBar.addCustomView(controlAlign, d.i.nb_item_floor_share, this.fxh.dlq);
            this.aby = (ImageView) this.fJs.findViewById(d.g.navigationBarBtnShare);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.fJF, this.fJF);
            layoutParams.rightMargin = this.DS4;
            this.fJs.setLayoutParams(layoutParams);
            bgL();
        }
        if (this.fJr == null && this.abx == null) {
            this.fJr = this.mNavigationBar.addCustomView(controlAlign, d.i.nb_item_floor_more, this.fxh.dlq);
            this.abx = (ImageView) this.fJr.findViewById(d.g.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.fJF, this.fJF);
            layoutParams2.rightMargin = this.fJH;
            this.fJr.setLayoutParams(layoutParams2);
            am.a(this.abx, d.f.icon_nav_more_selector, d.f.icon_nav_more_selector);
            this.fJr.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
        if (z) {
            if (this.fJv == null) {
                this.fJv = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.nav_user_concern_layout, (View.OnClickListener) null);
                this.fJw = (PbNavbarUserConcernView) this.fJv.findViewById(d.g.view_add_concern);
                this.fJy = this.fJv.findViewById(d.g.bg_user_photo);
                this.fJx = (HeadPendantView) this.fJv.findViewById(d.g.view_host_pendant_photo);
                this.fJx.setHasPendantStyle();
                if (this.fJx.getHeadView() != null) {
                    this.fJx.getHeadView().setIsRound(true);
                    this.fJx.getHeadView().setDefaultBgResource(d.C0142d.transparent);
                    this.fJx.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.setMargins(this.fJG, 0, 0, 0);
                this.fJv.setLayoutParams(layoutParams3);
                this.fJw.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                am.i(this.fJy, d.f.shape_photo_nav_bar_bg);
            }
        } else if (this.fJv != null) {
            this.mNavigationBar.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_LEFT).removeView(this.fJv);
        }
    }

    public void kv(boolean z) {
        if (this.fJr != null) {
            this.fJr.setVisibility(z ? 0 : 8);
        }
    }

    public void kP(boolean z) {
        this.fJI = z;
        bgL();
    }

    private void bgL() {
        if (this.aby != null && this.fJs != null) {
            if (this.fJI) {
                if (this.fJC) {
                    am.a(this.aby, d.f.icon_topbar_share_white_d, d.f.icon_topbar_share_white_d);
                } else {
                    aq.zE().c(this.aby, d.f.icon_topbar_share_n_svg, d.C0142d.cp_cont_e);
                }
                this.fJs.setClickable(false);
                return;
            }
            if (this.fJC) {
                am.a(this.aby, d.f.pb_ala_share, d.f.pb_ala_share);
            } else {
                aq.zE().c(this.aby, d.f.icon_topbar_share_n_svg, d.C0142d.select_topbar_icon_color_tint);
            }
            this.fJs.setClickable(true);
        }
    }

    public void kQ(boolean z) {
        if (this.fJs != null && !z) {
            this.fJs.setVisibility(8);
        }
    }

    public NavigationBar bgM() {
        return this.mNavigationBar;
    }

    public void kR(boolean z) {
        if (z) {
            this.aVN.setVisibility(0);
        } else {
            this.aVN.setVisibility(8);
        }
        kT(z);
    }

    public void pg(String str) {
        if (!TextUtils.isEmpty(str) && !this.fGw) {
            this.fJq.setText(this.fxh.getResources().getString(d.k.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            kT(true);
            i.tt().dc(str);
            return;
        }
        kT(false);
    }

    public void a(MetaData metaData, View.OnClickListener onClickListener) {
        if (metaData != null) {
            UtilHelper.showHeadImageViewBigV(this.fJx.getHeadView(), metaData);
            this.fJx.getHeadView().setImageDrawable(null);
            this.fJx.getPendantView().setImageDrawable(null);
            this.fJx.getHeadView().startLoad(metaData.getPortrait(), 28, false);
            this.fJx.getHeadView().setUserId(metaData.getUserId());
            this.fJx.getHeadView().setUserName(metaData.getUserName());
            this.fJx.getHeadView().setOnClickListener(onClickListener);
            if (metaData.getPendantData() != null && !StringUtils.isNull(metaData.getPendantData().uh())) {
                this.fJx.fn(metaData.getPendantData().uh());
            } else {
                this.fJx.fn(null);
            }
        }
    }

    public void a(ab abVar) {
        if (!this.fxh.isProgressBarShown()) {
            if (this.fJz == null) {
                this.fJA = new aa((PbActivity) this.fxh.getPageContext().getOrignalPage(), this.fxh.dlq);
                this.fJz = new c(this.fxh.getPageContext().getPageActivity(), this.fJA.getView(), am.getDrawable(d.f.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.pb.pb.main.view.b.2
                    @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                    public void sQ() {
                        b.this.fxh.bcA();
                    }

                    @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                    public void sR() {
                    }
                });
            }
            this.fJA.beV();
            if (this.fJC) {
                final Rect rect = new Rect();
                if (this.fxh.fvz) {
                    e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.3
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.fxh.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                            int height = b.this.fxh.getWindow().getDecorView().getHeight();
                            b.this.fJz.setClippingEnabled(false);
                            b.this.fJz.showAtLocation(b.this.fxh.findViewById(d.g.pb_layout), 81, 0, height - rect.bottom);
                        }
                    }, 500L);
                } else {
                    this.fxh.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    int height = this.fxh.getWindow().getDecorView().getHeight();
                    this.fJz.setClippingEnabled(false);
                    this.fJz.showAtLocation(this.fxh.findViewById(d.g.pb_layout), 81, 0, height - rect.bottom);
                }
            } else {
                this.fJz.showAtLocation(this.fxh.findViewById(d.g.pb_layout), 17, 0, 0);
            }
            this.fJA.kk(abVar == null ? false : abVar.fCr);
            this.fJA.km(abVar == null ? false : abVar.fCw);
            this.fJA.kn(abVar == null ? false : abVar.fCx);
            this.fJA.ko(abVar == null ? false : abVar.fCy);
            this.fJA.kp(abVar == null ? true : abVar.fCF);
            if (abVar == null) {
                this.fJA.J(false, false);
                this.fJA.K(false, false);
                this.fJA.n(false, "");
            } else {
                this.fJA.J(abVar.fCu, abVar.fCC);
                this.fJA.K(abVar.fCv, abVar.fCB);
                this.fJA.n(StringUtils.isNull(abVar.fCE) ? false : true, abVar.fCE);
            }
            boolean z = abVar == null ? false : abVar.nT;
            boolean z2 = abVar == null ? false : abVar.fto;
            boolean z3 = abVar == null ? false : abVar.isHostOnly;
            boolean z4 = abVar == null ? false : abVar.fCD;
            boolean z5 = abVar == null ? false : abVar.fCt;
            boolean z6 = abVar == null ? false : abVar.fCz;
            boolean z7 = abVar == null ? false : abVar.fCA;
            this.fJA.kl(abVar == null ? false : abVar.fCs);
            this.fJA.I(z4, z3);
            this.fJA.L(z5, z);
            this.fJA.M(z7, z6);
            if (abVar != null) {
                this.fJA.fCn = abVar.fCG;
                if (abVar.fCG) {
                    this.fJA.beO().setText(d.k.report_text);
                    this.fJA.ko(false);
                }
            }
            i(z, z2, z3);
        }
    }

    public void bgN() {
        this.fJA.beU().setText(this.fxh.getResources().getString(d.k.haved_fans_call));
    }

    private void i(boolean z, boolean z2, boolean z3) {
        if (this.fJA != null) {
            this.fJA.setBackGround();
            if (z) {
                this.fJA.beB().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(d.f.icon_recommend_reversed_down_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fJA.beB().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(d.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
            }
            if (z2) {
                this.fJA.beB().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(d.f.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fJA.beB().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(d.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
            if (z3) {
                this.fJA.beM().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(d.f.icon_host_only_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fJA.beM().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(d.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void sN() {
        if (this.fJA != null) {
            this.fJA.beW();
        }
        if (this.aRn == null) {
            this.aRn = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.b.4
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.fJz != null) {
                        g.a(b.this.fJz, b.this.fxh.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.im().postDelayed(this.aRn, 100L);
    }

    public void bgO() {
        if (this.fJA != null) {
            this.fJA.beW();
        }
        if (this.fJz != null) {
            g.a(this.fJz, this.fxh.getPageContext().getPageActivity());
        }
    }

    public aa bgP() {
        return this.fJA;
    }

    public View bgQ() {
        return this.fJt;
    }

    public boolean ajh() {
        return this.fJz != null && this.fJz.isShowing();
    }

    public void aPF() {
        if (this.fJA != null) {
            this.fJA.release();
        }
        this.fJz = null;
        this.fJA = null;
        e.im().removeCallbacks(this.aRn);
    }

    public void bgR() {
        if (this.fJr != null) {
            this.fJr.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.fxh.getPageContext(), i);
            am.i(this.mNavigationBar.getBarBgView(), d.C0142d.cp_bg_line_d);
        }
        aq.zE().c(this.fJB, d.f.icon_topbar_return_n_svg, d.C0142d.select_topbar_icon_color_tint);
        aq.zE().c(this.abx, d.f.icon_topbar_more_n_svg, d.C0142d.select_topbar_icon_color_tint);
        bgL();
        if (this.fJw != null) {
            this.fJw.onChangeSkinType(i);
        }
        if (this.fJy != null) {
            am.i(this.fJy, d.f.shape_photo_nav_bar_bg);
        }
        am.b(this.fJq, d.C0142d.cp_cont_b, d.C0142d.s_navbar_title_color);
    }

    public void qY(int i) {
        this.mNavigationBar.onChangeSkinType(this.fxh.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(d.f.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.fxh.getResources().getColor(d.C0142d.black_alpha85));
        if (this.aby != null) {
            this.aby.setImageResource(d.f.pb_ala_share);
        }
        if (this.abx != null) {
            this.abx.setImageResource(d.f.icon_vnav_more_bg);
        }
        this.fJq.setTextColor(this.fxh.getResources().getColor(d.C0142d.cp_cont_g));
        this.fJB.setImageResource(d.f.icon_return_bg);
    }

    public void bgS() {
        this.fJB.setVisibility(0);
        kT(false);
        if (this.fJr != null) {
            this.fJr.setVisibility(8);
        }
        if (this.fJs != null) {
            this.fJs.setVisibility(8);
        }
    }

    public void kS(boolean z) {
        this.fJB.setVisibility(0);
        kT(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.fJs != null) {
                this.fJs.setVisibility(0);
            }
            if (this.fJr != null) {
                this.fJr.setVisibility(0);
                return;
            }
            return;
        }
        if (this.fJs != null) {
            this.fJs.setVisibility(8);
        }
        if (this.fJr != null) {
            this.fJr.setVisibility(8);
        }
    }

    public void kT(boolean z) {
        if (!this.fGw && z && !"".equals(this.fJq.getText().toString())) {
            this.fJq.setVisibility(0);
        } else {
            this.fJq.setVisibility(8);
        }
    }

    public void kU(boolean z) {
        this.fJC = z;
    }

    public void kV(boolean z) {
        if (!this.fJC || TbadkCoreApplication.isLogin() || z) {
            if (z) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("call_fan_guide", false)) {
                    kV(false);
                    return;
                }
            } else if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_share", false)) {
                return;
            }
            this.fJE = z;
            View inflate = LayoutInflater.from(this.fxh.getPageContext().getContext()).inflate(d.i.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(d.g.arrow_up);
            TextView textView = (TextView) inflate.findViewById(d.g.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            if (!z) {
                layoutParams.gravity = 5;
                if (!TbadkCoreApplication.isLogin()) {
                    layoutParams.rightMargin = l.e(this.fxh, d.e.ds28);
                } else {
                    layoutParams.rightMargin = l.e(this.fxh, d.e.ds128);
                }
                textView.setText(d.k.share_tip);
                textView.setOnClickListener(this.fJL);
                this.fJD = new PopupWindow(inflate, -2, -2);
                e.im().removeCallbacks(this.fJJ);
                e.im().postDelayed(this.fJJ, 500L);
            }
        }
    }

    public void bgT() {
        if (this.fJJ != null) {
            e.im().removeCallbacks(this.fJJ);
        }
        if (this.fJK != null) {
            e.im().removeCallbacks(this.fJK);
        }
        bgU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgU() {
        g.a(this.fJD);
    }

    public void g(int i, int i2, boolean z) {
        if (i2 != 0 && bgM() != null && this.fJv != null) {
            if (!z) {
                if (this.fJv.getAlpha() != 1.0f) {
                    this.fJv.setAlpha(1.0f);
                }
                if (this.fJw.getAlpha() != 1.0f) {
                    this.fJw.setAlpha(1.0f);
                    return;
                }
                return;
            }
            int measuredHeight = (bgM().getMeasuredHeight() + i2) - 1;
            if (i >= measuredHeight) {
                if (this.fJv.getAlpha() != 0.0f) {
                    this.fJv.setAlpha(0.0f);
                }
                if (this.fJw.getAlpha() != 0.0f) {
                    this.fJw.setAlpha(0.0f);
                }
            } else if (i > bgM().getMeasuredHeight() && i < measuredHeight) {
                float measuredHeight2 = ((i - bgM().getMeasuredHeight()) * 1.0f) / (measuredHeight - bgM().getMeasuredHeight());
                this.fJv.setAlpha(1.0f - measuredHeight2);
                this.fJw.setAlpha(1.0f - measuredHeight2);
            } else if (i <= bgM().getMeasuredHeight()) {
                if (this.fJv.getAlpha() != 1.0f) {
                    this.fJv.setAlpha(1.0f);
                }
                if (this.fJw.getAlpha() != 1.0f) {
                    this.fJw.setAlpha(1.0f);
                }
            }
        }
    }
}
