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
    private ImageView aGO;
    public final View bAy;
    private Runnable bvw;
    private PbActivity fJR;
    private ImageView fVA;
    private final ImageView fVB;
    private final LinearLayout fVC;
    public FrameLayout fVD;
    public PbNavbarUserConcernView fVE;
    public HeadPendantView fVF;
    public View fVG;
    private ImageView fVJ;
    private PopupWindow fVL;
    private boolean fVM;
    private int fVN;
    private int fVO;
    private int fVP;
    public TextView fVx;
    public View fVy;
    public View fVz;
    public final NavigationBar mNavigationBar;
    private boolean fSB = false;
    private f fVH = null;
    private aa fVI = null;
    private boolean fVK = false;
    private boolean fVQ = false;
    private Runnable fVR = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.5
        @Override // java.lang.Runnable
        public void run() {
            View view;
            if (!c.this.fSB) {
                view = c.this.fVM ? c.this.fVy : c.this.fVz;
            } else {
                view = c.this.fVz;
            }
            if (view != null) {
                if (TbadkCoreApplication.isLogin() || !c.this.fVM) {
                    g.showPopupWindowAsDropDown(c.this.fVL, view);
                    if (!c.this.fVM) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_share", true);
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("call_fan_guide", true);
                    }
                    e.ns().removeCallbacks(c.this.fVS);
                    e.ns().postDelayed(c.this.fVS, TbConfig.NOTIFY_SOUND_INTERVAL);
                }
            }
        }
    };
    private Runnable fVS = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.6
        @Override // java.lang.Runnable
        public void run() {
            c.this.beP();
        }
    };
    private View.OnClickListener fVT = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.beO();
        }
    };

    public c(PbActivity pbActivity) {
        this.fVN = 0;
        this.fVO = 0;
        this.fVP = 0;
        this.DS4 = 0;
        this.fJR = pbActivity;
        this.fVN = l.s(pbActivity, d.e.ds88);
        this.fVO = l.s(this.fJR.getPageContext().getPageActivity(), d.e.ds22);
        this.fVP = l.s(this.fJR.getPageContext().getPageActivity(), d.e.ds14);
        this.DS4 = l.s(this.fJR.getPageContext().getPageActivity(), d.e.ds4);
        this.mNavigationBar = (NavigationBar) this.fJR.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.fJR.aut();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.bAy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.dDg);
        this.fVx = this.mNavigationBar.setCenterTextTitle("");
        this.fVB = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.fVC = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int s = l.s(this.fJR.getPageContext().getPageActivity(), d.e.ds20);
        this.fVC.setPadding(s, 0, s, 0);
        aj.a(this.fVB, d.f.icon_pb_play_small, d.f.icon_pb_play_small);
        this.fVB.setVisibility(8);
        this.fVx.setOnClickListener(pbActivity.dDg);
        this.fVB.setOnClickListener(pbActivity.dDg);
        this.fVJ = (ImageView) this.bAy.findViewById(d.g.widget_navi_back_button);
    }

    public void kM(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.fSB = z;
        if (this.fVz == null && this.fVA == null) {
            this.fVz = this.mNavigationBar.addCustomView(controlAlign, d.h.nb_item_floor_share, this.fJR.dDg);
            this.fVA = (ImageView) this.fVz.findViewById(d.g.navigationBarBtnShare);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.fVN, this.fVN);
            layoutParams.rightMargin = this.DS4;
            this.fVz.setLayoutParams(layoutParams);
            beG();
        }
        if (this.fVy == null && this.aGO == null) {
            this.fVy = this.mNavigationBar.addCustomView(controlAlign, d.h.nb_item_floor_more, this.fJR.dDg);
            this.aGO = (ImageView) this.fVy.findViewById(d.g.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.fVN, this.fVN);
            layoutParams2.rightMargin = this.fVP;
            this.fVy.setLayoutParams(layoutParams2);
            aj.a(this.aGO, d.f.icon_nav_more_selector, d.f.icon_nav_more_selector);
            this.fVy.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
        if (z) {
            if (this.fVD == null) {
                this.fVD = (FrameLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.nav_user_concern_layout, (View.OnClickListener) null);
                this.fVE = (PbNavbarUserConcernView) this.fVD.findViewById(d.g.view_add_concern);
                this.fVG = this.fVD.findViewById(d.g.bg_user_photo);
                this.fVF = (HeadPendantView) this.fVD.findViewById(d.g.view_host_pendant_photo);
                this.fVF.Dz();
                if (this.fVF.getHeadView() != null) {
                    this.fVF.getHeadView().setIsRound(true);
                    this.fVF.getHeadView().setDefaultBgResource(d.C0108d.transparent);
                    this.fVF.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.setMargins(this.fVO, 0, 0, 0);
                this.fVD.setLayoutParams(layoutParams3);
                this.fVE.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                aj.s(this.fVG, d.f.shape_photo_nav_bar_bg);
            }
        } else if (this.fVD != null) {
            this.mNavigationBar.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_LEFT).removeView(this.fVD);
        }
    }

    public void kt(boolean z) {
        if (this.fVy != null) {
            this.fVy.setVisibility(z ? 0 : 8);
        }
    }

    public void kN(boolean z) {
        this.fVQ = z;
        beG();
    }

    private void beG() {
        if (this.fVA != null && this.fVz != null) {
            if (this.fVQ) {
                if (this.fVK) {
                    aj.a(this.fVA, d.f.icon_topbar_share_white_d, d.f.icon_topbar_share_white_d);
                } else {
                    aj.a(this.fVA, d.f.icon_topbar_share_d, d.f.icon_topbar_share_d);
                }
                this.fVz.setClickable(false);
                return;
            }
            if (this.fVK) {
                aj.a(this.fVA, d.f.pb_ala_share, d.f.pb_ala_share);
            } else {
                aj.a(this.fVA, d.f.icon_pb_navi_selector, d.f.icon_pb_navi_selector);
            }
            this.fVz.setClickable(true);
        }
    }

    public void kO(boolean z) {
        if (this.fVz != null && !z) {
            this.fVz.setVisibility(8);
        }
    }

    public NavigationBar beH() {
        return this.mNavigationBar;
    }

    public void kP(boolean z) {
        if (z) {
            this.bAy.setVisibility(0);
        } else {
            this.bAy.setVisibility(8);
        }
        kR(z);
    }

    public void nZ(String str) {
        if (!TextUtils.isEmpty(str) && !this.fSB) {
            this.fVx.setText(this.fJR.getResources().getString(d.j.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            kR(true);
            i.wB().cz(str);
            return;
        }
        kR(false);
    }

    public void a(MetaData metaData, View.OnClickListener onClickListener) {
        if (metaData != null) {
            UtilHelper.showHeadImageViewBigV(this.fVF.getHeadView(), metaData);
            this.fVF.getHeadView().setImageDrawable(null);
            this.fVF.getPendantView().setImageDrawable(null);
            this.fVF.getHeadView().startLoad(metaData.getPortrait(), 28, false);
            this.fVF.getHeadView().setUserId(metaData.getUserId());
            this.fVF.getHeadView().setUserName(metaData.getUserName());
            this.fVF.getHeadView().setOnClickListener(onClickListener);
            if (metaData.getPendantData() != null && !StringUtils.isNull(metaData.getPendantData().xu())) {
                this.fVF.eG(metaData.getPendantData().xu());
            } else {
                this.fVF.eG(null);
            }
        }
    }

    public void a(ab abVar) {
        if (!this.fJR.isProgressBarShown()) {
            if (this.fVH == null) {
                this.fVI = new aa((PbActivity) this.fJR.getPageContext().getOrignalPage(), this.fJR.dDg);
                this.fVH = new f(this.fJR.getPageContext().getPageActivity(), this.fVI.getView(), aj.getDrawable(d.f.bg_pull_down_right_n), new f.a() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                    @Override // com.baidu.tbadk.core.view.f.a
                    public void vX() {
                        c.this.fJR.bau();
                    }

                    @Override // com.baidu.tbadk.core.view.f.a
                    public void vY() {
                    }
                });
            }
            this.fVI.bcQ();
            if (this.fVK) {
                final Rect rect = new Rect();
                if (this.fJR.fIj) {
                    e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.fJR.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                            int height = c.this.fJR.getWindow().getDecorView().getHeight();
                            c.this.fVH.setClippingEnabled(false);
                            c.this.fVH.showAtLocation(c.this.fJR.findViewById(d.g.pb_layout), 81, 0, height - rect.bottom);
                        }
                    }, 500L);
                } else {
                    this.fJR.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    int height = this.fJR.getWindow().getDecorView().getHeight();
                    this.fVH.setClippingEnabled(false);
                    this.fVH.showAtLocation(this.fJR.findViewById(d.g.pb_layout), 81, 0, height - rect.bottom);
                }
            } else {
                this.fVH.showAtLocation(this.fJR.findViewById(d.g.pb_layout), 17, 0, 0);
            }
            this.fVI.ki(abVar == null ? false : abVar.fOF);
            this.fVI.kk(abVar == null ? false : abVar.fOL);
            this.fVI.kl(abVar == null ? false : abVar.fOM);
            this.fVI.km(abVar == null ? false : abVar.fON);
            this.fVI.kn(abVar == null ? true : abVar.fOU);
            if (abVar == null) {
                this.fVI.K(false, false);
                this.fVI.L(false, false);
                this.fVI.k(false, "");
            } else {
                this.fVI.K(abVar.fOJ, abVar.fOR);
                this.fVI.L(abVar.fOK, abVar.fOQ);
                this.fVI.k(StringUtils.isNull(abVar.fOT) ? false : true, abVar.fOT);
            }
            boolean z = abVar == null ? false : abVar.fOH;
            boolean z2 = abVar == null ? false : abVar.fEQ;
            boolean z3 = abVar == null ? false : abVar.isHostOnly;
            boolean z4 = abVar == null ? false : abVar.fOS;
            boolean z5 = abVar == null ? false : abVar.fOI;
            boolean z6 = abVar == null ? false : abVar.fOO;
            boolean z7 = abVar == null ? false : abVar.fOP;
            this.fVI.kj(abVar == null ? false : abVar.fOG);
            this.fVI.J(z4, z3);
            this.fVI.M(z5, z);
            this.fVI.N(z7, z6);
            if (abVar != null) {
                this.fVI.fOB = abVar.fOV;
                if (abVar.fOV) {
                    this.fVI.bcJ().setText(d.j.report_text);
                    this.fVI.km(false);
                }
            }
            j(z, z2, z3);
        }
    }

    public void beI() {
        this.fVI.bcP().setText(this.fJR.getResources().getString(d.j.haved_fans_call));
    }

    private void j(boolean z, boolean z2, boolean z3) {
        if (this.fVI != null) {
            this.fVI.alZ();
            if (z) {
                this.fVI.bcw().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_recommend_reversed_down_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fVI.bcw().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
            }
            if (z2) {
                this.fVI.bcw().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fVI.bcw().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
            if (z3) {
                this.fVI.bcH().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_host_only_selector), (Drawable) null, (Drawable) null);
            } else {
                this.fVI.bcH().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void vU() {
        if (this.fVI != null) {
            this.fVI.bcR();
        }
        if (this.bvw == null) {
            this.bvw = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.fVH != null) {
                        g.a(c.this.fVH, c.this.fJR.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.ns().postDelayed(this.bvw, 100L);
    }

    public void beJ() {
        if (this.fVI != null) {
            this.fVI.bcR();
        }
        if (this.fVH != null) {
            g.a(this.fVH, this.fJR.getPageContext().getPageActivity());
        }
    }

    public aa beK() {
        return this.fVI;
    }

    public View beL() {
        return this.fVB;
    }

    public boolean alw() {
        return this.fVH != null && this.fVH.isShowing();
    }

    public void aNo() {
        if (this.fVI != null) {
            this.fVI.release();
        }
        this.fVH = null;
        this.fVI = null;
        e.ns().removeCallbacks(this.bvw);
    }

    public void beM() {
        if (this.fVy != null) {
            this.fVy.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.fJR.getPageContext(), i);
            aj.s(this.mNavigationBar.getBarBgView(), d.C0108d.cp_bg_line_d);
        }
        if (this.aGO != null) {
            aj.a(this.aGO, d.f.icon_nav_more_selector, d.f.icon_nav_more_selector);
        }
        beG();
        if (this.fVE != null) {
            this.fVE.onChangeSkinType(i);
        }
        if (this.fVG != null) {
            aj.s(this.fVG, d.f.shape_photo_nav_bar_bg);
        }
        aj.d(this.fVx, d.C0108d.cp_cont_b, d.C0108d.s_navbar_title_color);
    }

    public void tf(int i) {
        this.mNavigationBar.onChangeSkinType(this.fJR.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(d.f.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.fJR.getResources().getColor(d.C0108d.black_alpha85));
        if (this.fVA != null) {
            this.fVA.setImageResource(d.f.pb_ala_share);
        }
        if (this.aGO != null) {
            this.aGO.setImageResource(d.f.icon_vnav_more_bg);
        }
        this.fVx.setTextColor(this.fJR.getResources().getColor(d.C0108d.cp_cont_g));
        this.fVJ.setImageResource(d.f.icon_return_bg);
    }

    public void beN() {
        this.fVJ.setVisibility(0);
        kR(false);
        if (this.fVy != null) {
            this.fVy.setVisibility(8);
        }
        if (this.fVz != null) {
            this.fVz.setVisibility(8);
        }
    }

    public void kQ(boolean z) {
        this.fVJ.setVisibility(0);
        kR(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.fVz != null) {
                this.fVz.setVisibility(0);
            }
            if (this.fVy != null) {
                this.fVy.setVisibility(0);
                return;
            }
            return;
        }
        if (this.fVz != null) {
            this.fVz.setVisibility(8);
        }
        if (this.fVy != null) {
            this.fVy.setVisibility(8);
        }
    }

    public void kR(boolean z) {
        if (!this.fSB && z && !"".equals(this.fVx.getText().toString())) {
            this.fVx.setVisibility(0);
        } else {
            this.fVx.setVisibility(8);
        }
    }

    public void kS(boolean z) {
        this.fVK = z;
    }

    public void kT(boolean z) {
        if (!this.fVK || TbadkCoreApplication.isLogin() || z) {
            if (z) {
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("call_fan_guide", false)) {
                    kT(false);
                    return;
                }
            } else if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_share", false)) {
                return;
            }
            this.fVM = z;
            View inflate = LayoutInflater.from(this.fJR.getPageContext().getContext()).inflate(d.h.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(d.g.arrow_up);
            TextView textView = (TextView) inflate.findViewById(d.g.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            if (!z) {
                layoutParams.gravity = 5;
                if (!TbadkCoreApplication.isLogin()) {
                    layoutParams.rightMargin = l.s(this.fJR, d.e.ds28);
                } else {
                    layoutParams.rightMargin = l.s(this.fJR, d.e.ds128);
                }
                textView.setText(d.j.share_tip);
                textView.setOnClickListener(this.fVT);
                this.fVL = new PopupWindow(inflate, -2, -2);
                e.ns().removeCallbacks(this.fVR);
                e.ns().postDelayed(this.fVR, 500L);
            }
        }
    }

    public void beO() {
        if (this.fVR != null) {
            e.ns().removeCallbacks(this.fVR);
        }
        if (this.fVS != null) {
            e.ns().removeCallbacks(this.fVS);
        }
        beP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beP() {
        g.b(this.fVL);
    }

    public void i(int i, int i2, boolean z) {
        if (i2 != 0 && beH() != null && this.fVD != null) {
            if (!z) {
                if (this.fVD.getAlpha() != 1.0f) {
                    this.fVD.setAlpha(1.0f);
                    return;
                }
                return;
            }
            int measuredHeight = (beH().getMeasuredHeight() + i2) - 1;
            if (i >= measuredHeight) {
                if (this.fVD.getAlpha() != 0.0f) {
                    this.fVD.setAlpha(0.0f);
                }
            } else if (i > beH().getMeasuredHeight() && i < measuredHeight) {
                this.fVD.setAlpha(1.0f - (((i - beH().getMeasuredHeight()) * 1.0f) / (measuredHeight - beH().getMeasuredHeight())));
            } else if (i <= beH().getMeasuredHeight() && this.fVD.getAlpha() != 1.0f) {
                this.fVD.setAlpha(1.0f);
            }
        }
    }
}
