package com.baidu.tieba.pb.pb.main.view;

import android.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.af;
import com.baidu.tieba.pb.pb.main.ag;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes9.dex */
public class c {
    private ImageView aex;
    public TextView dWI;
    public final View eun;
    private ImageView fxl;
    private PbFragment jGF;
    public BarImageView jXA;
    public PbNavbarUserLayout jXB;
    private PopupWindow jXE;
    private int jXF;
    private int jXG;
    private int jXH;
    private int jXI;
    public TextView jXv;
    public View jXw;
    private final ImageView jXx;
    private final LinearLayout jXy;
    public LinearLayout jXz;
    public String mForumName;
    public final NavigationBar mNavigationBar;
    private Runnable runnable;
    private boolean jSD = false;
    private AlertDialog jXC = null;
    private af jXD = null;
    private boolean jFh = false;
    private boolean jXJ = true;
    private Runnable hNx = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.ccy();
        }
    };
    private View.OnClickListener hNy = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.cJe();
        }
    };

    public c(PbFragment pbFragment, View view) {
        this.jXF = 0;
        this.jXG = 0;
        this.jXH = 0;
        this.jXI = 0;
        this.jGF = pbFragment;
        this.jXF = l.getDimens(pbFragment.getContext(), R.dimen.ds88);
        this.jXG = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds14);
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        this.jXH = ((int) (equipmentWidth * 0.07d)) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds102);
        if (this.jXH - dimens > 0) {
            this.jXH -= dimens;
        }
        this.jXI = (equipmentWidth - (this.jXH * 2)) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds89);
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                c.this.jGF.bVo();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.eun = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbFragment.hpu);
        this.jXv = this.mNavigationBar.setCenterTextTitle("");
        this.jXx = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.jXy = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        this.jXy.setPadding(dimens2, 0, dimens2, 0);
        am.setNavbarIconSrc(this.jXx, R.drawable.icon_pb_play_small, R.drawable.icon_pb_play_small);
        this.jXx.setVisibility(8);
        this.jXv.setOnClickListener(pbFragment.hpu);
        this.jXx.setOnClickListener(pbFragment.hpu);
        this.fxl = (ImageView) this.eun.findViewById(R.id.widget_navi_back_button);
        if (d.aMq()) {
            if (this.jXB == null) {
                this.jXB = new PbNavbarUserLayout(pbFragment.getContext());
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.jXB, (View.OnClickListener) null);
                this.jXB.setPbFragment(pbFragment);
            }
        } else if (this.jXz == null) {
            this.jXz = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.nav_fourm_title_layout, (View.OnClickListener) null);
            this.jXA = (BarImageView) this.jXz.findViewById(R.id.pb_nav_title_forum_image);
            this.jXA.setShowOval(true);
            this.jXA.setOnClickListener(pbFragment.hpu);
            this.dWI = (TextView) this.jXz.findViewById(R.id.pb_nav_title_forum_name);
            this.dWI.setOnClickListener(pbFragment.hpu);
            if (this.jXz.getLayoutParams() != null && (this.jXz.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.jXH > 0 && this.jXI > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jXz.getLayoutParams();
                marginLayoutParams.leftMargin = this.jXH;
                marginLayoutParams.rightMargin = this.jXH;
                this.jXz.setLayoutParams(marginLayoutParams);
            }
            if (this.jXz.getVisibility() == 8) {
                this.jXz.setVisibility(0);
            }
            if (this.jXz.getAlpha() != 1.0f) {
                this.jXz.setAlpha(1.0f);
            }
        }
    }

    public void sm(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.jSD = z;
        if (this.jXw == null && this.aex == null) {
            this.jXw = this.mNavigationBar.addCustomView(controlAlign, R.layout.nb_item_floor_more, this.jGF.hpu);
            this.aex = (ImageView) this.jXw.findViewById(R.id.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.jXF, this.jXF);
            layoutParams.rightMargin = this.jXG;
            this.jXw.setLayoutParams(layoutParams);
            SvgManager.aUV().a(this.aex, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.jXw.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void rS(boolean z) {
        if (this.jXw != null) {
            this.jXw.setVisibility(z ? 0 : 8);
        }
    }

    public NavigationBar cIW() {
        return this.mNavigationBar;
    }

    public void sn(boolean z) {
        if (z) {
            this.eun.setVisibility(0);
        } else {
            this.eun.setVisibility(8);
        }
        sp(z);
    }

    public void Hp(String str) {
        if (!TextUtils.isEmpty(str) && !this.jSD) {
            this.jXv.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            sp(true);
            k.aNQ().setForumNameForWaterImage(str);
            return;
        }
        sp(false);
    }

    public void a(ag agVar) {
        if (!this.jGF.getBaseFragmentActivity().isProgressBarShown()) {
            this.jXD = new af(this.jGF, this.jGF.hpu);
            this.jXC = new AlertDialog.Builder(this.jGF.getContext(), R.style.DialogTheme).create();
            this.jXC.setCanceledOnTouchOutside(true);
            g.showDialog(this.jXC, this.jGF.getFragmentActivity());
            Window window = this.jXC.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.jXD.getView());
            this.jXD.rI(agVar == null ? false : agVar.jPj);
            this.jXD.rJ(agVar == null ? false : agVar.jPn);
            this.jXD.rK(agVar == null ? false : agVar.jPr);
            this.jXD.rL(agVar == null ? false : agVar.jPo);
            this.jXD.rM(agVar == null ? true : agVar.jPl);
            if (agVar == null) {
                this.jXD.ae(false, false);
                this.jXD.af(false, false);
            } else {
                this.jXD.ae(agVar.jPp, agVar.jPv);
                this.jXD.af(agVar.jPq, agVar.jPu);
            }
            boolean z = agVar == null ? false : agVar.DC;
            boolean z2 = agVar == null ? false : agVar.isHostOnly;
            boolean z3 = agVar == null ? false : agVar.jPm;
            boolean z4 = agVar == null ? false : agVar.jPk;
            boolean z5 = agVar == null ? false : agVar.jPt;
            boolean z6 = agVar == null ? false : agVar.jPs;
            this.jXD.ad(z3, z2);
            this.jXD.ag(z4, z);
            this.jXD.ah(z6, z5);
            if (agVar != null) {
                this.jXD.jPg = agVar.jPw;
                if (agVar.jPw) {
                    this.jXD.cGF().setText(R.string.report_text);
                    this.jXD.rL(false);
                }
            }
            cIX();
        }
    }

    private void cIX() {
        if (this.jXD != null) {
            this.jXD.cGL();
        }
    }

    public void aEa() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.jXC != null) {
                        g.dismissDialog(c.this.jXC, c.this.jGF.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.ld().postDelayed(this.runnable, 100L);
    }

    public void cIY() {
        if (this.jXC != null) {
            g.dismissDialog(this.jXC, this.jGF.getPageContext().getPageActivity());
        }
    }

    public af cIZ() {
        return this.jXD;
    }

    public View cJa() {
        return this.jXx;
    }

    public boolean cJb() {
        return this.jXC != null && this.jXC.isShowing();
    }

    public void releaseResources() {
        if (this.jXD != null) {
            this.jXD.release();
        }
        this.jXC = null;
        this.jXD = null;
        e.ld().removeCallbacks(this.runnable);
    }

    public void cJc() {
        if (this.jXw != null) {
            this.jXw.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.jGF.getPageContext(), i);
            am.setBackgroundResource(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
        }
        SvgManager.aUV().a(this.fxl, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aUV().a(this.aex, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setNavbarTitleColor(this.jXv, R.color.cp_cont_b, R.color.s_navbar_title_color);
        am.setViewTextColor(this.dWI, (int) R.color.cp_cont_b);
        cIX();
        if (this.jXB != null) {
            this.jXB.onChangeSkinType(i);
        }
    }

    public void AB(int i) {
        this.mNavigationBar.onChangeSkinType(this.jGF.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha85));
        if (this.aex != null) {
            SvgManager.aUV().a(this.aex, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.jXv.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_cont_g));
        SvgManager.aUV().a(this.fxl, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void cJd() {
        this.fxl.setVisibility(0);
        sp(false);
        if (this.jXw != null) {
            this.jXw.setVisibility(8);
        }
    }

    public void so(boolean z) {
        this.fxl.setVisibility(0);
        sp(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.jXw != null) {
                this.jXw.setVisibility(0);
            }
        } else if (this.jXw != null) {
            this.jXw.setVisibility(8);
        }
    }

    public void sp(boolean z) {
        if (!this.jSD && z && !"".equals(this.jXv.getText().toString())) {
            this.jXv.setVisibility(0);
        } else {
            this.jXv.setVisibility(8);
        }
    }

    public void rc(boolean z) {
        this.jFh = z;
    }

    public void cHH() {
        if ((!this.jFh || TbadkCoreApplication.isLogin()) && !com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.SHOW_SHARE, false)) {
            View inflate = LayoutInflater.from(this.jGF.getPageContext().getContext()).inflate(R.layout.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.arrow_up);
            TextView textView = (TextView) inflate.findViewById(R.id.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.gravity = 5;
            if (!TbadkCoreApplication.isLogin()) {
                layoutParams.rightMargin = l.getDimens(this.jGF.getContext(), R.dimen.ds28);
            } else {
                layoutParams.rightMargin = l.getDimens(this.jGF.getContext(), R.dimen.ds128);
            }
            textView.setText(R.string.share_tip);
            textView.setOnClickListener(this.hNy);
            this.jXE = new PopupWindow(inflate, -2, -2);
        }
    }

    public void cJe() {
        if (this.hNx != null) {
            e.ld().removeCallbacks(this.hNx);
        }
        ccy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccy() {
        g.dismissPopupWindow(this.jXE);
    }

    public void cL(View view) {
        if (view != null && this.jXB != null && !this.jFh) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int height = view.getHeight();
            int height2 = this.mNavigationBar.getHeight();
            if (!view.isShown()) {
                if (this.jXB.getVisibility() == 8) {
                    this.jXB.setVisibility(0);
                }
                this.jXB.am(1.0f);
            } else if (iArr[1] >= height2) {
                if (this.jXB.getAlphaForScroll() != 0.0f) {
                    this.jXB.am(0.0f);
                }
            } else if (iArr[1] > 0) {
                this.jXB.am(1.0f - ((((iArr[1] + height) - height2) * 1.0f) / height));
            } else if (this.jXB.getAlphaForScroll() != 1.0f) {
                this.jXB.am(1.0f);
            }
        }
    }

    public void eU(String str, String str2) {
        if (this.jGF != null && this.jXz != null) {
            if (StringUtils.isNull(str)) {
                this.jXA.setVisibility(8);
                this.dWI.setText("贴吧动态");
                return;
            }
            this.jXA.setVisibility(0);
            this.mForumName = str;
            au.a(this.dWI, str, (int) R.string.forum, (int) R.dimen.tbds0, 1, this.jXI, false);
            k.aNQ().setForumNameForWaterImage(str);
            this.jXA.startLoad(str2, 10, false);
        }
    }

    public void b(com.baidu.tieba.pb.data.e eVar, PostData postData, boolean z) {
        if (this.jXB != null) {
            this.jXB.setData(eVar, postData, z);
        }
    }
}
