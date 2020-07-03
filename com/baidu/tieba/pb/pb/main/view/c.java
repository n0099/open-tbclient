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
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.af;
import com.baidu.tieba.pb.pb.main.ag;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes9.dex */
public class c {
    private ImageView afe;
    public final View eDr;
    public TextView eee;
    private ImageView fIH;
    private PbFragment kbv;
    private PopupWindow ksC;
    private int ksD;
    private int ksE;
    private int ksF;
    private int ksG;
    public TextView kst;
    public View ksu;
    private final ImageView ksv;
    private final LinearLayout ksw;
    public LinearLayout ksx;
    public BarImageView ksy;
    public PbNavbarUserLayout ksz;
    public String mForumName;
    public final NavigationBar mNavigationBar;
    private Runnable runnable;
    private boolean knz = false;
    private AlertDialog ksA = null;
    private af ksB = null;
    private boolean jZX = false;
    private boolean ksH = true;
    private Runnable ibw = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.cfZ();
        }
    };
    private View.OnClickListener ibx = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.cNL();
        }
    };

    public c(PbFragment pbFragment, View view) {
        this.ksD = 0;
        this.ksE = 0;
        this.ksF = 0;
        this.ksG = 0;
        this.kbv = pbFragment;
        this.ksD = l.getDimens(pbFragment.getContext(), R.dimen.ds88);
        this.ksE = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds14);
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        this.ksF = ((int) (equipmentWidth * 0.07d)) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds102);
        if (this.ksF - dimens > 0) {
            this.ksF -= dimens;
        }
        this.ksG = (equipmentWidth - (this.ksF * 2)) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds89);
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                c.this.kbv.bYx();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.eDr = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbFragment.hCn);
        this.kst = this.mNavigationBar.setCenterTextTitle("");
        this.ksv = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.ksw = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        this.ksw.setPadding(dimens2, 0, dimens2, 0);
        an.setNavbarIconSrc(this.ksv, R.drawable.icon_pb_play_small, R.drawable.icon_pb_play_small);
        this.ksv.setVisibility(8);
        this.kst.setOnClickListener(pbFragment.hCn);
        this.ksv.setOnClickListener(pbFragment.hCn);
        this.fIH = (ImageView) this.eDr.findViewById(R.id.widget_navi_back_button);
        if (d.aNT()) {
            if (this.ksz == null) {
                this.ksz = new PbNavbarUserLayout(pbFragment.getContext());
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.ksz, (View.OnClickListener) null);
                this.ksz.setPbFragment(pbFragment);
            }
        } else if (this.ksx == null) {
            this.ksx = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.nav_fourm_title_layout, (View.OnClickListener) null);
            this.ksy = (BarImageView) this.ksx.findViewById(R.id.pb_nav_title_forum_image);
            this.ksy.setShowOval(true);
            this.ksy.setOnClickListener(pbFragment.hCn);
            this.eee = (TextView) this.ksx.findViewById(R.id.pb_nav_title_forum_name);
            this.eee.setOnClickListener(pbFragment.hCn);
            if (this.ksx.getLayoutParams() != null && (this.ksx.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.ksF > 0 && this.ksG > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ksx.getLayoutParams();
                marginLayoutParams.leftMargin = this.ksF;
                marginLayoutParams.rightMargin = this.ksF;
                this.ksx.setLayoutParams(marginLayoutParams);
            }
            if (this.ksx.getVisibility() == 8) {
                this.ksx.setVisibility(0);
            }
            if (this.ksx.getAlpha() != 1.0f) {
                this.ksx.setAlpha(1.0f);
            }
        }
    }

    public void sA(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.knz = z;
        if (this.ksu == null && this.afe == null) {
            this.ksu = this.mNavigationBar.addCustomView(controlAlign, R.layout.nb_item_floor_more, this.kbv.hCn);
            this.afe = (ImageView) this.ksu.findViewById(R.id.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ksD, this.ksD);
            layoutParams.rightMargin = this.ksE;
            this.ksu.setLayoutParams(layoutParams);
            SvgManager.aWQ().a(this.afe, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.ksu.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void sg(boolean z) {
        if (this.ksu != null) {
            this.ksu.setVisibility(z ? 0 : 8);
        }
    }

    public NavigationBar cND() {
        return this.mNavigationBar;
    }

    public void sB(boolean z) {
        if (z) {
            this.eDr.setVisibility(0);
        } else {
            this.eDr.setVisibility(8);
        }
        sD(z);
    }

    public void HR(String str) {
        if (!TextUtils.isEmpty(str) && !this.knz) {
            this.kst.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            sD(true);
            k.aPA().setForumNameForWaterImage(str);
            return;
        }
        sD(false);
    }

    public void a(ag agVar) {
        if (!this.kbv.getBaseFragmentActivity().isProgressBarShown()) {
            this.ksB = new af(this.kbv, this.kbv.hCn);
            this.ksA = new AlertDialog.Builder(this.kbv.getContext(), R.style.DialogTheme).create();
            this.ksA.setCanceledOnTouchOutside(true);
            g.showDialog(this.ksA, this.kbv.getFragmentActivity());
            Window window = this.ksA.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.ksB.getView());
            this.ksB.rV(agVar == null ? false : agVar.kke);
            this.ksB.rW(agVar == null ? false : agVar.kki);
            this.ksB.rX(agVar == null ? false : agVar.kkm);
            this.ksB.rZ(agVar == null ? false : agVar.kkj);
            this.ksB.sa(agVar == null ? true : agVar.kkg);
            if (agVar == null) {
                this.ksB.af(false, false);
                this.ksB.ag(false, false);
            } else {
                this.ksB.af(agVar.kkk, agVar.kkq);
                this.ksB.ag(agVar.kkl, agVar.kkp);
            }
            boolean z = agVar == null ? false : agVar.Ef;
            boolean z2 = agVar == null ? false : agVar.isHostOnly;
            boolean z3 = agVar == null ? false : agVar.kkh;
            boolean z4 = agVar == null ? false : agVar.kkf;
            boolean z5 = agVar == null ? false : agVar.kko;
            boolean z6 = agVar == null ? false : agVar.kkn;
            this.ksB.ae(z3, z2);
            this.ksB.ah(z4, z);
            this.ksB.ai(z6, z5);
            if (agVar != null) {
                this.ksB.kkb = agVar.kkr;
                if (agVar.kkr) {
                    this.ksB.cLl().setText(R.string.report_text);
                    this.ksB.rZ(false);
                }
            }
            this.ksB.rY(agVar != null ? agVar.kks : false);
            if (!TbSingleton.getInstance().mCanCallFans && this.kbv.cIe() != null && this.kbv.cIe().getPbData() != null && this.kbv.cIe().getPbData().getThreadId() != null && this.kbv.cIe().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                this.ksB.cLo().setText(R.string.have_called_fans_short);
            }
            cNE();
        }
    }

    private void cNE() {
        if (this.ksB != null) {
            this.ksB.cLs();
        }
    }

    public void aFg() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.ksA != null) {
                        g.dismissDialog(c.this.ksA, c.this.kbv.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.lt().postDelayed(this.runnable, 100L);
    }

    public void cNF() {
        if (this.ksA != null) {
            g.dismissDialog(this.ksA, this.kbv.getPageContext().getPageActivity());
        }
    }

    public af cNG() {
        return this.ksB;
    }

    public View cNH() {
        return this.ksv;
    }

    public boolean cNI() {
        return this.ksA != null && this.ksA.isShowing();
    }

    public void releaseResources() {
        if (this.ksB != null) {
            this.ksB.release();
        }
        this.ksA = null;
        this.ksB = null;
        e.lt().removeCallbacks(this.runnable);
    }

    public void cNJ() {
        if (this.ksu != null) {
            this.ksu.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.kbv.getPageContext(), i);
            an.setBackgroundResource(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
        }
        SvgManager.aWQ().a(this.fIH, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aWQ().a(this.afe, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        an.setNavbarTitleColor(this.kst, R.color.cp_cont_b, R.color.s_navbar_title_color);
        an.setViewTextColor(this.eee, (int) R.color.cp_cont_b);
        cNE();
        if (this.ksz != null) {
            this.ksz.onChangeSkinType(i);
        }
    }

    public void BF(int i) {
        this.mNavigationBar.onChangeSkinType(this.kbv.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha85));
        if (this.afe != null) {
            SvgManager.aWQ().a(this.afe, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.kst.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.cp_cont_g));
        SvgManager.aWQ().a(this.fIH, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void cNK() {
        this.fIH.setVisibility(0);
        sD(false);
        if (this.ksu != null) {
            this.ksu.setVisibility(8);
        }
    }

    public void sC(boolean z) {
        this.fIH.setVisibility(0);
        sD(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.ksu != null) {
                this.ksu.setVisibility(0);
            }
        } else if (this.ksu != null) {
            this.ksu.setVisibility(8);
        }
    }

    public void sD(boolean z) {
        if (!this.knz && z && !"".equals(this.kst.getText().toString())) {
            this.kst.setVisibility(0);
        } else {
            this.kst.setVisibility(8);
        }
    }

    public void rp(boolean z) {
        this.jZX = z;
    }

    public void cMo() {
        if ((!this.jZX || TbadkCoreApplication.isLogin()) && !com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(SharedPrefConfig.SHOW_SHARE, false)) {
            View inflate = LayoutInflater.from(this.kbv.getPageContext().getContext()).inflate(R.layout.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.arrow_up);
            TextView textView = (TextView) inflate.findViewById(R.id.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.gravity = 5;
            if (!TbadkCoreApplication.isLogin()) {
                layoutParams.rightMargin = l.getDimens(this.kbv.getContext(), R.dimen.ds28);
            } else {
                layoutParams.rightMargin = l.getDimens(this.kbv.getContext(), R.dimen.ds128);
            }
            textView.setText(R.string.share_tip);
            textView.setOnClickListener(this.ibx);
            this.ksC = new PopupWindow(inflate, -2, -2);
        }
    }

    public void cNL() {
        if (this.ibw != null) {
            e.lt().removeCallbacks(this.ibw);
        }
        cfZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfZ() {
        g.dismissPopupWindow(this.ksC);
    }

    public void cM(View view) {
        if (view != null && this.ksz != null && !this.jZX) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int height = view.getHeight();
            int height2 = this.mNavigationBar.getHeight();
            if (!view.isShown()) {
                if (this.ksz.getVisibility() == 8) {
                    this.ksz.setVisibility(0);
                }
                this.ksz.ar(1.0f);
            } else if (iArr[1] >= height2) {
                if (this.ksz.getAlphaForScroll() != 0.0f) {
                    this.ksz.ar(0.0f);
                }
            } else if (iArr[1] > 0) {
                this.ksz.ar(1.0f - ((((iArr[1] + height) - height2) * 1.0f) / height));
            } else if (this.ksz.getAlphaForScroll() != 1.0f) {
                this.ksz.ar(1.0f);
            }
        }
    }

    public void fb(String str, String str2) {
        if (this.kbv != null && this.ksx != null) {
            if (StringUtils.isNull(str)) {
                this.ksy.setVisibility(8);
                this.eee.setText("贴吧动态");
                return;
            }
            this.ksy.setVisibility(0);
            this.mForumName = str;
            aw.a(this.eee, str, (int) R.string.forum, (int) R.dimen.tbds0, 1, this.ksG, false);
            k.aPA().setForumNameForWaterImage(str);
            this.ksy.startLoad(str2, 10, false);
        }
    }

    public void b(com.baidu.tieba.pb.data.e eVar, PostData postData, boolean z) {
        if (this.ksz != null) {
            this.ksz.setData(eVar, postData, z);
        }
    }
}
