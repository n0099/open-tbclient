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
    private ImageView fxw;
    private PbFragment jHL;
    public TextView jYB;
    public View jYC;
    private final ImageView jYD;
    private final LinearLayout jYE;
    public LinearLayout jYF;
    public BarImageView jYG;
    public PbNavbarUserLayout jYH;
    private PopupWindow jYK;
    private int jYL;
    private int jYM;
    private int jYN;
    private int jYO;
    public String mForumName;
    public final NavigationBar mNavigationBar;
    private Runnable runnable;
    private boolean jTJ = false;
    private AlertDialog jYI = null;
    private af jYJ = null;
    private boolean jGn = false;
    private boolean jYP = true;
    private Runnable hOk = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.ccG();
        }
    };
    private View.OnClickListener hOl = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.cJu();
        }
    };

    public c(PbFragment pbFragment, View view) {
        this.jYL = 0;
        this.jYM = 0;
        this.jYN = 0;
        this.jYO = 0;
        this.jHL = pbFragment;
        this.jYL = l.getDimens(pbFragment.getContext(), R.dimen.ds88);
        this.jYM = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds14);
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        this.jYN = ((int) (equipmentWidth * 0.07d)) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds102);
        if (this.jYN - dimens > 0) {
            this.jYN -= dimens;
        }
        this.jYO = (equipmentWidth - (this.jYN * 2)) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds89);
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                c.this.jHL.bVq();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.eun = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbFragment.hpF);
        this.jYB = this.mNavigationBar.setCenterTextTitle("");
        this.jYD = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.jYE = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        this.jYE.setPadding(dimens2, 0, dimens2, 0);
        am.setNavbarIconSrc(this.jYD, R.drawable.icon_pb_play_small, R.drawable.icon_pb_play_small);
        this.jYD.setVisibility(8);
        this.jYB.setOnClickListener(pbFragment.hpF);
        this.jYD.setOnClickListener(pbFragment.hpF);
        this.fxw = (ImageView) this.eun.findViewById(R.id.widget_navi_back_button);
        if (d.aMq()) {
            if (this.jYH == null) {
                this.jYH = new PbNavbarUserLayout(pbFragment.getContext());
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.jYH, (View.OnClickListener) null);
                this.jYH.setPbFragment(pbFragment);
            }
        } else if (this.jYF == null) {
            this.jYF = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.nav_fourm_title_layout, (View.OnClickListener) null);
            this.jYG = (BarImageView) this.jYF.findViewById(R.id.pb_nav_title_forum_image);
            this.jYG.setShowOval(true);
            this.jYG.setOnClickListener(pbFragment.hpF);
            this.dWI = (TextView) this.jYF.findViewById(R.id.pb_nav_title_forum_name);
            this.dWI.setOnClickListener(pbFragment.hpF);
            if (this.jYF.getLayoutParams() != null && (this.jYF.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.jYN > 0 && this.jYO > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jYF.getLayoutParams();
                marginLayoutParams.leftMargin = this.jYN;
                marginLayoutParams.rightMargin = this.jYN;
                this.jYF.setLayoutParams(marginLayoutParams);
            }
            if (this.jYF.getVisibility() == 8) {
                this.jYF.setVisibility(0);
            }
            if (this.jYF.getAlpha() != 1.0f) {
                this.jYF.setAlpha(1.0f);
            }
        }
    }

    public void sm(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.jTJ = z;
        if (this.jYC == null && this.aex == null) {
            this.jYC = this.mNavigationBar.addCustomView(controlAlign, R.layout.nb_item_floor_more, this.jHL.hpF);
            this.aex = (ImageView) this.jYC.findViewById(R.id.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.jYL, this.jYL);
            layoutParams.rightMargin = this.jYM;
            this.jYC.setLayoutParams(layoutParams);
            SvgManager.aUW().a(this.aex, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.jYC.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void rS(boolean z) {
        if (this.jYC != null) {
            this.jYC.setVisibility(z ? 0 : 8);
        }
    }

    public NavigationBar cJm() {
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
        if (!TextUtils.isEmpty(str) && !this.jTJ) {
            this.jYB.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            sp(true);
            k.aNQ().setForumNameForWaterImage(str);
            return;
        }
        sp(false);
    }

    public void a(ag agVar) {
        if (!this.jHL.getBaseFragmentActivity().isProgressBarShown()) {
            this.jYJ = new af(this.jHL, this.jHL.hpF);
            this.jYI = new AlertDialog.Builder(this.jHL.getContext(), R.style.DialogTheme).create();
            this.jYI.setCanceledOnTouchOutside(true);
            g.showDialog(this.jYI, this.jHL.getFragmentActivity());
            Window window = this.jYI.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.jYJ.getView());
            this.jYJ.rI(agVar == null ? false : agVar.jQp);
            this.jYJ.rJ(agVar == null ? false : agVar.jQt);
            this.jYJ.rK(agVar == null ? false : agVar.jQx);
            this.jYJ.rL(agVar == null ? false : agVar.jQu);
            this.jYJ.rM(agVar == null ? true : agVar.jQr);
            if (agVar == null) {
                this.jYJ.ae(false, false);
                this.jYJ.af(false, false);
            } else {
                this.jYJ.ae(agVar.jQv, agVar.jQB);
                this.jYJ.af(agVar.jQw, agVar.jQA);
            }
            boolean z = agVar == null ? false : agVar.DC;
            boolean z2 = agVar == null ? false : agVar.isHostOnly;
            boolean z3 = agVar == null ? false : agVar.jQs;
            boolean z4 = agVar == null ? false : agVar.jQq;
            boolean z5 = agVar == null ? false : agVar.jQz;
            boolean z6 = agVar == null ? false : agVar.jQy;
            this.jYJ.ad(z3, z2);
            this.jYJ.ag(z4, z);
            this.jYJ.ah(z6, z5);
            if (agVar != null) {
                this.jYJ.jQm = agVar.jQC;
                if (agVar.jQC) {
                    this.jYJ.cGV().setText(R.string.report_text);
                    this.jYJ.rL(false);
                }
            }
            cJn();
        }
    }

    private void cJn() {
        if (this.jYJ != null) {
            this.jYJ.cHb();
        }
    }

    public void aEa() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.jYI != null) {
                        g.dismissDialog(c.this.jYI, c.this.jHL.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.ld().postDelayed(this.runnable, 100L);
    }

    public void cJo() {
        if (this.jYI != null) {
            g.dismissDialog(this.jYI, this.jHL.getPageContext().getPageActivity());
        }
    }

    public af cJp() {
        return this.jYJ;
    }

    public View cJq() {
        return this.jYD;
    }

    public boolean cJr() {
        return this.jYI != null && this.jYI.isShowing();
    }

    public void releaseResources() {
        if (this.jYJ != null) {
            this.jYJ.release();
        }
        this.jYI = null;
        this.jYJ = null;
        e.ld().removeCallbacks(this.runnable);
    }

    public void cJs() {
        if (this.jYC != null) {
            this.jYC.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.jHL.getPageContext(), i);
            am.setBackgroundResource(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
        }
        SvgManager.aUW().a(this.fxw, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aUW().a(this.aex, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setNavbarTitleColor(this.jYB, R.color.cp_cont_b, R.color.s_navbar_title_color);
        am.setViewTextColor(this.dWI, (int) R.color.cp_cont_b);
        cJn();
        if (this.jYH != null) {
            this.jYH.onChangeSkinType(i);
        }
    }

    public void AD(int i) {
        this.mNavigationBar.onChangeSkinType(this.jHL.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha85));
        if (this.aex != null) {
            SvgManager.aUW().a(this.aex, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.jYB.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_cont_g));
        SvgManager.aUW().a(this.fxw, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void cJt() {
        this.fxw.setVisibility(0);
        sp(false);
        if (this.jYC != null) {
            this.jYC.setVisibility(8);
        }
    }

    public void so(boolean z) {
        this.fxw.setVisibility(0);
        sp(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.jYC != null) {
                this.jYC.setVisibility(0);
            }
        } else if (this.jYC != null) {
            this.jYC.setVisibility(8);
        }
    }

    public void sp(boolean z) {
        if (!this.jTJ && z && !"".equals(this.jYB.getText().toString())) {
            this.jYB.setVisibility(0);
        } else {
            this.jYB.setVisibility(8);
        }
    }

    public void rc(boolean z) {
        this.jGn = z;
    }

    public void cHX() {
        if ((!this.jGn || TbadkCoreApplication.isLogin()) && !com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.SHOW_SHARE, false)) {
            View inflate = LayoutInflater.from(this.jHL.getPageContext().getContext()).inflate(R.layout.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.arrow_up);
            TextView textView = (TextView) inflate.findViewById(R.id.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.gravity = 5;
            if (!TbadkCoreApplication.isLogin()) {
                layoutParams.rightMargin = l.getDimens(this.jHL.getContext(), R.dimen.ds28);
            } else {
                layoutParams.rightMargin = l.getDimens(this.jHL.getContext(), R.dimen.ds128);
            }
            textView.setText(R.string.share_tip);
            textView.setOnClickListener(this.hOl);
            this.jYK = new PopupWindow(inflate, -2, -2);
        }
    }

    public void cJu() {
        if (this.hOk != null) {
            e.ld().removeCallbacks(this.hOk);
        }
        ccG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccG() {
        g.dismissPopupWindow(this.jYK);
    }

    public void cL(View view) {
        if (view != null && this.jYH != null && !this.jGn) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int height = view.getHeight();
            int height2 = this.mNavigationBar.getHeight();
            if (!view.isShown()) {
                if (this.jYH.getVisibility() == 8) {
                    this.jYH.setVisibility(0);
                }
                this.jYH.am(1.0f);
            } else if (iArr[1] >= height2) {
                if (this.jYH.getAlphaForScroll() != 0.0f) {
                    this.jYH.am(0.0f);
                }
            } else if (iArr[1] > 0) {
                this.jYH.am(1.0f - ((((iArr[1] + height) - height2) * 1.0f) / height));
            } else if (this.jYH.getAlphaForScroll() != 1.0f) {
                this.jYH.am(1.0f);
            }
        }
    }

    public void eU(String str, String str2) {
        if (this.jHL != null && this.jYF != null) {
            if (StringUtils.isNull(str)) {
                this.jYG.setVisibility(8);
                this.dWI.setText("贴吧动态");
                return;
            }
            this.jYG.setVisibility(0);
            this.mForumName = str;
            au.a(this.dWI, str, (int) R.string.forum, (int) R.dimen.tbds0, 1, this.jYO, false);
            k.aNQ().setForumNameForWaterImage(str);
            this.jYG.startLoad(str2, 10, false);
        }
    }

    public void b(com.baidu.tieba.pb.data.e eVar, PostData postData, boolean z) {
        if (this.jYH != null) {
            this.jYH.setData(eVar, postData, z);
        }
    }
}
