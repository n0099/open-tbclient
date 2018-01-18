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
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.aa;
import com.baidu.tieba.pb.pb.main.ab;
import com.baidu.tieba.pb.view.f;
/* loaded from: classes2.dex */
public class c {
    private int DS4;
    private ImageView aGL;
    public final View bAq;
    private Runnable bvn;
    private PbActivity fJw;
    public TextView fVc;
    public View fVd;
    public View fVe;
    private ImageView fVf;
    private final ImageView fVg;
    private final LinearLayout fVh;
    public FrameLayout fVi;
    public PbNavbarUserConcernView fVj;
    public HeadPendantView fVk;
    public View fVl;
    private ImageView fVo;
    private PopupWindow fVq;
    private boolean fVr;
    private int fVs;
    private int fVt;
    private int fVu;
    public final NavigationBar mNavigationBar;
    private boolean fSg = false;
    private f fVm = null;
    private aa fVn = null;
    private boolean fVp = false;
    private boolean fVv = false;
    private Runnable fVw = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.5
        @Override // java.lang.Runnable
        public void run() {
            View view;
            if (!c.this.fSg) {
                view = c.this.fVr ? c.this.fVd : c.this.fVe;
            } else {
                view = c.this.fVe;
            }
            if (view != null) {
                if (TbadkCoreApplication.isLogin() || !c.this.fVr) {
                    g.showPopupWindowAsDropDown(c.this.fVq, view);
                    if (!c.this.fVr) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_share", true);
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("call_fan_guide", true);
                    }
                    e.nr().removeCallbacks(c.this.fVx);
                    e.nr().postDelayed(c.this.fVx, TbConfig.NOTIFY_SOUND_INTERVAL);
                }
            }
        }
    };
    private Runnable fVx = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.6
        @Override // java.lang.Runnable
        public void run() {
            c.this.beK();
        }
    };
    private View.OnClickListener fVy = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.beJ();
        }
    };

    public c(PbActivity pbActivity) {
        this.fVs = 0;
        this.fVt = 0;
        this.fVu = 0;
        this.DS4 = 0;
        this.fJw = pbActivity;
        this.fVs = l.s(pbActivity, d.e.ds88);
        this.fVt = l.s(this.fJw.getPageContext().getPageActivity(), d.e.ds22);
        this.fVu = l.s(this.fJw.getPageContext().getPageActivity(), d.e.ds14);
        this.DS4 = l.s(this.fJw.getPageContext().getPageActivity(), d.e.ds4);
        this.mNavigationBar = (NavigationBar) this.fJw.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.fJw.auo();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.bAq = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.dCL);
        this.fVc = this.mNavigationBar.setCenterTextTitle("");
        this.fVg = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.fVh = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int s = l.s(this.fJw.getPageContext().getPageActivity(), d.e.ds20);
        this.fVh.setPadding(s, 0, s, 0);
        aj.a(this.fVg, d.f.icon_pb_play_small, d.f.icon_pb_play_small);
        this.fVg.setVisibility(8);
        this.fVc.setOnClickListener(pbActivity.dCL);
        this.fVg.setOnClickListener(pbActivity.dCL);
        this.fVo = (ImageView) this.bAq.findViewById(d.g.widget_navi_back_button);
    }

    public void kK(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.fSg = z;
        if (this.fVe == null && this.fVf == null) {
            this.fVe = this.mNavigationBar.addCustomView(controlAlign, d.h.nb_item_floor_share, this.fJw.dCL);
            this.fVf = (ImageView) this.fVe.findViewById(d.g.navigationBarBtnShare);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.fVs, this.fVs);
            layoutParams.rightMargin = this.DS4;
            this.fVe.setLayoutParams(layoutParams);
            beB();
        }
        if (this.fVd == null && this.aGL == null) {
            this.fVd = this.mNavigationBar.addCustomView(controlAlign, d.h.nb_item_floor_more, this.fJw.dCL);
            this.aGL = (ImageView) this.fVd.findViewById(d.g.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.fVs, this.fVs);
            layoutParams2.rightMargin = this.fVu;
            this.fVd.setLayoutParams(layoutParams2);
            aj.a(this.aGL, d.f.icon_nav_more_selector, d.f.icon_nav_more_selector);
            this.fVd.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
        if (z) {
            if (this.fVi == null) {
                this.fVi = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.nav_user_concern_layout, (View.OnClickListener) null);
                this.fVj = (PbNavbarUserConcernView) this.fVi.findViewById(d.g.view_add_concern);
                this.fVl = this.fVi.findViewById(d.g.bg_user_photo);
                this.fVk = (HeadPendantView) this.fVi.findViewById(d.g.view_host_pendant_photo);
                this.fVk.Dx();
                if (this.fVk.getHeadView() != null) {
                    this.fVk.getHeadView().setIsRound(true);
                    this.fVk.getHeadView().setDefaultBgResource(d.C0107d.transparent);
                    this.fVk.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.setMargins(this.fVt, 0, 0, 0);
                this.fVi.setLayoutParams(layoutParams3);
                this.fVj.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                aj.s(this.fVl, d.f.shape_photo_nav_bar_bg);
            }
        } else if (this.fVi != null) {
            this.mNavigationBar.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_LEFT).removeView(this.fVi);
        }
    }

    public void kr(boolean z) {
        if (this.fVd != null) {
            this.fVd.setVisibility(z ? 0 : 8);
        }
    }

    public void kL(boolean z) {
        this.fVv = z;
        beB();
    }

    private void beB() {
        if (this.fVf != null && this.fVe != null) {
            if (this.fVv) {
                if (this.fVp) {
                    aj.a(this.fVf, d.f.icon_topbar_share_white_d, d.f.icon_topbar_share_white_d);
                } else {
                    aj.a(this.fVf, d.f.icon_topbar_share_d, d.f.icon_topbar_share_d);
                }
                this.fVe.setClickable(false);
                return;
            }
            if (this.fVp) {
                aj.a(this.fVf, d.f.pb_ala_share, d.f.pb_ala_share);
            } else {
                aj.a(this.fVf, d.f.icon_pb_navi_selector, d.f.icon_pb_navi_selector);
            }
            this.fVe.setClickable(true);
        }
    }

    public void kM(boolean z) {
        if (this.fVe != null && !z) {
            this.fVe.setVisibility(8);
        }
    }

    public NavigationBar beC() {
        return this.mNavigationBar;
    }

    public void kN(boolean z) {
        if (z) {
            this.bAq.setVisibility(0);
        } else {
            this.bAq.setVisibility(8);
        }
        kP(z);
    }

    public void nS(String str) {
        if (!TextUtils.isEmpty(str) && !this.fSg) {
            this.fVc.setText(this.fJw.getResources().getString(d.j.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            kP(true);
            i.wA().cz(str);
            return;
        }
        kP(false);
    }

    public void a(MetaData metaData, View.OnClickListener onClickListener) {
        if (metaData != null) {
            UtilHelper.showHeadImageViewBigV(this.fVk.getHeadView(), metaData);
            this.fVk.getHeadView().setImageDrawable(null);
            this.fVk.getPendantView().setImageDrawable(null);
            this.fVk.getHeadView().startLoad(metaData.getPortrait(), 28, false);
            this.fVk.getHeadView().setUserId(metaData.getUserId());
            this.fVk.getHeadView().setUserName(metaData.getUserName());
            this.fVk.getHeadView().setOnClickListener(onClickListener);
            if (metaData.getPendantData() != null && !StringUtils.isNull(metaData.getPendantData().xt())) {
                this.fVk.ez(metaData.getPendantData().xt());
            } else {
                this.fVk.ez(null);
            }
        }
    }

    public void a(ab abVar) {
        if (!this.fJw.isProgressBarShown()) {
            if (this.fVm == null) {
                this.fVn = new aa((PbActivity) this.fJw.getPageContext().getOrignalPage(), this.fJw.dCL);
                this.fVm = new f(this.fJw.getPageContext().getPageActivity(), this.fVn.getView(), aj.getDrawable(d.f.bg_pull_down_right_n), new f.a() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                    @Override // com.baidu.tbadk.core.view.f.a
                    public void vW() {
                        c.this.fJw.bap();
                    }

                    @Override // com.baidu.tbadk.core.view.f.a
                    public void vX() {
                    }
                });
            }
            this.fVn.bcL();
            if (this.fVp) {
                final Rect rect = new Rect();
                if (this.fJw.fHO) {
                    e.nr().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.fJw.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                            int height = c.this.fJw.getWindow().getDecorView().getHeight();
                            c.this.fVm.setClippingEnabled(false);
                            c.this.fVm.showAtLocation(c.this.fJw.findViewById(d.g.pb_layout), 81, 0, height - rect.bottom);
                        }
                    }, 500L);
                } else {
                    this.fJw.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    int height = this.fJw.getWindow().getDecorView().getHeight();
                    this.fVm.setClippingEnabled(false);
                    this.fVm.showAtLocation(this.fJw.findViewById(d.g.pb_layout), 81, 0, height - rect.bottom);
                }
            } else {
                this.fVm.showAtLocation(this.fJw.findViewById(d.g.pb_layout), 17, 0, 0);
            }
            this.fVn.kg(abVar == null ? false : abVar.fOk);
            this.fVn.ki(abVar == null ? false : abVar.fOq);
            this.fVn.kj(abVar == null ? false : abVar.fOr);
            this.fVn.kk(abVar == null ? false : abVar.fOs);
            this.fVn.kl(abVar == null ? true : abVar.fOz);
            if (abVar == null) {
                this.fVn.K(false, false);
                this.fVn.L(false, false);
                this.fVn.k(false, "");
            } else {
                this.fVn.K(abVar.fOo, abVar.fOw);
                this.fVn.L(abVar.fOp, abVar.fOv);
                this.fVn.k(StringUtils.isNull(abVar.fOy) ? false : true, abVar.fOy);
            }
            boolean z = abVar == null ? false : abVar.fOm;
            boolean z2 = abVar == null ? false : abVar.fEv;
            boolean z3 = abVar == null ? false : abVar.isHostOnly;
            boolean z4 = abVar == null ? false : abVar.fOx;
            boolean z5 = abVar == null ? false : abVar.fOn;
            boolean z6 = abVar == null ? false : abVar.fOt;
            boolean z7 = abVar == null ? false : abVar.fOu;
            this.fVn.kh(abVar == null ? false : abVar.fOl);
            this.fVn.J(z4, z3);
            this.fVn.M(z5, z);
            this.fVn.N(z7, z6);
            if (abVar != null) {
                this.fVn.fOg = abVar.fOA;
                if (abVar.fOA) {
                    this.fVn.bcE().setText(d.j.report_text);
                    this.fVn.kk(false);
                }
            }
            j(z, z2, z3);
        }
    }

    public void beD() {
        this.fVn.bcK().setText(this.fJw.getResources().getString(d.j.haved_fans_call));
    }

    private void j(boolean z, boolean z2, boolean z3) {
        if (this.fVn != null) {
            this.fVn.alU();
            if (z) {
                this.fVn.bcr().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_recommend_reversed_down_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fVn.bcr().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
            }
            if (z2) {
                this.fVn.bcr().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fVn.bcr().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
            if (z3) {
                this.fVn.bcC().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_host_only_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fVn.bcC().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void vT() {
        if (this.fVn != null) {
            this.fVn.bcM();
        }
        if (this.bvn == null) {
            this.bvn = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.fVm != null) {
                        g.a(c.this.fVm, c.this.fJw.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.nr().postDelayed(this.bvn, 100L);
    }

    public void beE() {
        if (this.fVn != null) {
            this.fVn.bcM();
        }
        if (this.fVm != null) {
            g.a(this.fVm, this.fJw.getPageContext().getPageActivity());
        }
    }

    public aa beF() {
        return this.fVn;
    }

    public View beG() {
        return this.fVg;
    }

    public boolean alr() {
        return this.fVm != null && this.fVm.isShowing();
    }

    public void aNj() {
        if (this.fVn != null) {
            this.fVn.release();
        }
        this.fVm = null;
        this.fVn = null;
        e.nr().removeCallbacks(this.bvn);
    }

    public void beH() {
        if (this.fVd != null) {
            this.fVd.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.fJw.getPageContext(), i);
            aj.s(this.mNavigationBar.getBarBgView(), d.C0107d.cp_bg_line_d);
        }
        if (this.aGL != null) {
            aj.a(this.aGL, d.f.icon_nav_more_selector, d.f.icon_nav_more_selector);
        }
        beB();
        if (this.fVj != null) {
            this.fVj.onChangeSkinType(i);
        }
        if (this.fVl != null) {
            aj.s(this.fVl, d.f.shape_photo_nav_bar_bg);
        }
        aj.d(this.fVc, d.C0107d.cp_cont_b, d.C0107d.s_navbar_title_color);
    }

    public void tf(int i) {
        this.mNavigationBar.onChangeSkinType(this.fJw.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(d.f.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.fJw.getResources().getColor(d.C0107d.black_alpha85));
        if (this.fVf != null) {
            this.fVf.setImageResource(d.f.pb_ala_share);
        }
        if (this.aGL != null) {
            this.aGL.setImageResource(d.f.icon_vnav_more_bg);
        }
        this.fVc.setTextColor(this.fJw.getResources().getColor(d.C0107d.cp_cont_g));
        this.fVo.setImageResource(d.f.icon_return_bg);
    }

    public void beI() {
        this.fVo.setVisibility(0);
        kP(false);
        if (this.fVd != null) {
            this.fVd.setVisibility(8);
        }
        if (this.fVe != null) {
            this.fVe.setVisibility(8);
        }
    }

    public void kO(boolean z) {
        this.fVo.setVisibility(0);
        kP(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.fVe != null) {
                this.fVe.setVisibility(0);
            }
            if (this.fVd != null) {
                this.fVd.setVisibility(0);
                return;
            }
            return;
        }
        if (this.fVe != null) {
            this.fVe.setVisibility(8);
        }
        if (this.fVd != null) {
            this.fVd.setVisibility(8);
        }
    }

    public void kP(boolean z) {
        if (!this.fSg && z && !"".equals(this.fVc.getText().toString())) {
            this.fVc.setVisibility(0);
        } else {
            this.fVc.setVisibility(8);
        }
    }

    public void kQ(boolean z) {
        this.fVp = z;
    }

    public void kR(boolean z) {
        if (!this.fVp || TbadkCoreApplication.isLogin() || z) {
            if (z) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("call_fan_guide", false)) {
                    kR(false);
                    return;
                }
            } else if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_share", false)) {
                return;
            }
            this.fVr = z;
            View inflate = LayoutInflater.from(this.fJw.getPageContext().getContext()).inflate(d.h.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(d.g.arrow_up);
            TextView textView = (TextView) inflate.findViewById(d.g.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            if (!z) {
                layoutParams.gravity = 5;
                if (!TbadkCoreApplication.isLogin()) {
                    layoutParams.rightMargin = l.s(this.fJw, d.e.ds28);
                } else {
                    layoutParams.rightMargin = l.s(this.fJw, d.e.ds128);
                }
                textView.setText(d.j.share_tip);
                textView.setOnClickListener(this.fVy);
                this.fVq = new PopupWindow(inflate, -2, -2);
                e.nr().removeCallbacks(this.fVw);
                e.nr().postDelayed(this.fVw, 500L);
            }
        }
    }

    public void beJ() {
        if (this.fVw != null) {
            e.nr().removeCallbacks(this.fVw);
        }
        if (this.fVx != null) {
            e.nr().removeCallbacks(this.fVx);
        }
        beK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beK() {
        g.b(this.fVq);
    }

    public void i(int i, int i2, boolean z) {
        if (i2 != 0 && beC() != null && this.fVi != null) {
            if (!z) {
                if (this.fVi.getAlpha() != 1.0f) {
                    this.fVi.setAlpha(1.0f);
                    return;
                }
                return;
            }
            int measuredHeight = (beC().getMeasuredHeight() + i2) - 1;
            if (i >= measuredHeight) {
                if (this.fVi.getAlpha() != 0.0f) {
                    this.fVi.setAlpha(0.0f);
                }
            } else if (i > beC().getMeasuredHeight() && i < measuredHeight) {
                this.fVi.setAlpha(1.0f - (((i - beC().getMeasuredHeight()) * 1.0f) / (measuredHeight - beC().getMeasuredHeight())));
            } else if (i <= beC().getMeasuredHeight() && this.fVi.getAlpha() != 1.0f) {
                this.fVi.setAlpha(1.0f);
            }
        }
    }
}
