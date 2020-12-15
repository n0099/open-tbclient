package com.baidu.tieba.pb.pb.main.view;

import android.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.aj;
import com.baidu.tieba.pb.pb.main.ak;
/* loaded from: classes22.dex */
public class c {
    private ImageView ahT;
    public final View fEN;
    public TextView fdq;
    private ImageView gOl;
    public View jjp;
    private final ImageView krE;
    private final LinearLayout krF;
    private PbFragment lDI;
    public TextView lVC;
    public LinearLayout lVD;
    public BarImageView lVE;
    private PopupWindow lVI;
    private int lVJ;
    private int lVK;
    private int lVL;
    private int lVM;
    public String mForumName;
    public final NavigationBar mNavigationBar;
    private Runnable runnable;
    private boolean lQE = false;
    private AlertDialog lVF = null;
    private aj lVG = null;
    private float eOa = 0.33f;
    private boolean lVH = false;
    private boolean lVN = true;
    private Runnable jyG = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.cLx();
        }
    };
    private View.OnClickListener jyH = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.duf();
        }
    };

    public c(PbFragment pbFragment, View view) {
        this.lVJ = 0;
        this.lVK = 0;
        this.lVL = 0;
        this.lVM = 0;
        this.lDI = pbFragment;
        this.lVJ = l.getDimens(pbFragment.getContext(), R.dimen.ds88);
        this.lVK = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds14);
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        this.lVL = ((int) (equipmentWidth * 0.07d)) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds102);
        if (this.lVL - dimens > 0) {
            this.lVL -= dimens;
        }
        this.lVM = (equipmentWidth - (this.lVL * 2)) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds89);
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                c.this.lDI.cCG();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.fEN = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbFragment.iVJ);
        this.lVC = this.mNavigationBar.setCenterTextTitle("");
        this.krE = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.krF = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        this.krF.setPadding(dimens2, 0, dimens2, 0);
        ap.setNavbarIconSrc(this.krE, R.drawable.icon_pb_play_small, R.drawable.icon_pb_play_small);
        this.krE.setVisibility(8);
        this.lVC.setOnClickListener(pbFragment.iVJ);
        this.krE.setOnClickListener(pbFragment.iVJ);
        this.gOl = (ImageView) this.fEN.findViewById(R.id.widget_navi_back_button);
        if (this.lVD == null) {
            this.lVD = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.nav_fourm_title_layout, (View.OnClickListener) null);
            this.lVE = (BarImageView) this.lVD.findViewById(R.id.pb_nav_title_forum_image);
            this.lVE.setShowOval(true);
            this.lVE.setShowOuterBorder(false);
            this.lVE.setShowInnerBorder(true);
            this.lVE.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.lVE.setStrokeColorResId(R.color.CAM_X0401);
            this.lVE.setOnClickListener(pbFragment.iVJ);
            this.fdq = (TextView) this.lVD.findViewById(R.id.pb_nav_title_forum_name);
            this.fdq.setOnClickListener(pbFragment.iVJ);
            if (this.lVD.getLayoutParams() != null && (this.lVD.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.lVL > 0 && this.lVM > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.lVD.getLayoutParams();
                marginLayoutParams.leftMargin = this.lVL;
                marginLayoutParams.rightMargin = this.lVL;
                this.lVD.setLayoutParams(marginLayoutParams);
            }
            if (this.lVD.getVisibility() == 8) {
                this.lVD.setVisibility(0);
            }
            if (this.lVD.getAlpha() != 1.0f) {
                this.lVD.setAlpha(1.0f);
            }
        }
    }

    public void vL(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.lQE = z;
        if (this.jjp == null && this.ahT == null) {
            this.jjp = this.mNavigationBar.addCustomView(controlAlign, R.layout.nb_item_floor_more, this.lDI.iVJ);
            this.ahT = (ImageView) this.jjp.findViewById(R.id.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.lVJ, this.lVJ);
            layoutParams.rightMargin = this.lVK;
            this.jjp.setLayoutParams(layoutParams);
            SvgManager.btW().a(this.ahT, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.jjp.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void vq(boolean z) {
        if (this.jjp != null) {
            this.jjp.setVisibility(z ? 0 : 8);
        }
    }

    public NavigationBar dtW() {
        return this.mNavigationBar;
    }

    public void vM(boolean z) {
        if (z) {
            this.fEN.setVisibility(0);
        } else {
            this.fEN.setVisibility(8);
        }
        vO(z);
    }

    public void Lf(String str) {
        if (!TextUtils.isEmpty(str) && !this.lQE) {
            this.lVC.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            vO(true);
            k.blV().setForumNameForWaterImage(str);
            return;
        }
        vO(false);
    }

    public void a(ak akVar) {
        if (!this.lDI.getBaseFragmentActivity().isProgressBarShown()) {
            this.lVG = new aj(this.lDI, this.lDI.iVJ);
            this.lVF = new AlertDialog.Builder(this.lDI.getContext(), R.style.DialogTheme).create();
            this.lVF.setCanceledOnTouchOutside(true);
            g.showDialog(this.lVF, this.lDI.getFragmentActivity());
            Window window = this.lVF.getWindow();
            window.addFlags(512);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = l.getDimens(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.lVG.getView());
            window.setDimAmount(this.eOa);
            this.lVG.ve(akVar == null ? false : akVar.lNl);
            this.lVG.vf(akVar == null ? false : akVar.lNp);
            this.lVG.vg(akVar == null ? false : akVar.lNt);
            this.lVG.vi(akVar == null ? false : akVar.lNq);
            this.lVG.vj(akVar == null ? true : akVar.lNn);
            if (akVar == null) {
                this.lVG.ao(false, false);
                this.lVG.ap(false, false);
            } else {
                this.lVG.ao(akVar.lNr, akVar.lNx);
                this.lVG.ap(akVar.lNs, akVar.lNw);
            }
            boolean z = akVar == null ? false : akVar.FT;
            boolean z2 = akVar == null ? false : akVar.isHostOnly;
            boolean z3 = akVar == null ? false : akVar.lNo;
            boolean z4 = akVar == null ? false : akVar.lNm;
            boolean z5 = akVar == null ? false : akVar.lNv;
            boolean z6 = akVar == null ? false : akVar.lNu;
            this.lVG.an(z3, z2);
            this.lVG.aq(z4, z);
            this.lVG.ar(z6, z5);
            if (akVar != null) {
                this.lVG.lNi = akVar.lNy;
                if (akVar.lNy) {
                    this.lVG.drz().setText(R.string.report_text);
                    this.lVG.vi(false);
                }
            }
            this.lVG.vh(akVar != null ? akVar.lNz : false);
            if (!TbSingleton.getInstance().mCanCallFans && this.lDI.dol() != null && this.lDI.dol().getPbData() != null && this.lDI.dol().getPbData().getThreadId() != null && this.lDI.dol().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                this.lVG.drC().setText(R.string.have_called_fans_short);
            }
            dtX();
        }
    }

    private void dtX() {
        if (this.lVG != null) {
            this.lVG.drG();
        }
    }

    public void bca() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.lVF != null) {
                        g.dismissDialog(c.this.lVF, c.this.lDI.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.mY().postDelayed(this.runnable, 100L);
    }

    public void dtY() {
        if (this.lVF != null) {
            g.dismissDialog(this.lVF, this.lDI.getPageContext().getPageActivity());
        }
    }

    public aj dtZ() {
        return this.lVG;
    }

    public View dua() {
        return this.krE;
    }

    public boolean dub() {
        return this.lVF != null && this.lVF.isShowing();
    }

    public void releaseResources() {
        if (this.lVG != null) {
            this.lVG.release();
        }
        this.lVF = null;
        this.lVG = null;
        e.mY().removeCallbacks(this.runnable);
    }

    public void duc() {
        if (this.jjp != null) {
            this.jjp.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.lDI.getPageContext(), i);
            ap.setBackgroundResource(this.mNavigationBar.getBarBgView(), R.color.CAM_X0207);
        }
        WebPManager.a(this.gOl, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.a(this.ahT, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
        ap.setNavbarTitleColor(this.lVC, R.color.CAM_X0105, R.color.s_navbar_title_color);
        ap.setViewTextColor(this.fdq, R.color.CAM_X0105);
        dud();
        dtX();
    }

    private void dud() {
        if (this.lVD != null) {
            if (!TextUtils.isEmpty(this.mForumName)) {
                com.baidu.tbadk.core.elementsMaven.c.bm(this.lVD).pA(R.string.J_X07).setBackGroundColor(R.color.CAM_X0209);
            } else {
                this.lVD.setBackgroundResource(0);
            }
        }
    }

    public void Hz(int i) {
        this.mNavigationBar.onChangeSkinType(this.lDI.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha85));
        this.lVC.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0111));
        WebPManager.a(this.ahT, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.a(this.gOl, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
    }

    public void due() {
        this.gOl.setVisibility(0);
        vO(false);
        if (this.jjp != null) {
            this.jjp.setVisibility(8);
        }
    }

    public void vN(boolean z) {
        this.gOl.setVisibility(0);
        vO(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.jjp != null) {
                this.jjp.setVisibility(0);
            }
        } else if (this.jjp != null) {
            this.jjp.setVisibility(8);
        }
    }

    public void vO(boolean z) {
        if (!this.lQE && z && !"".equals(this.lVC.getText().toString())) {
            this.lVC.setVisibility(0);
        } else {
            this.lVC.setVisibility(8);
        }
    }

    public void vP(boolean z) {
        this.lVH = z;
    }

    public void dsF() {
        if ((!this.lVH || TbadkCoreApplication.isLogin()) && !com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.SHOW_SHARE, false)) {
            View inflate = LayoutInflater.from(this.lDI.getContext()).inflate(R.layout.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.arrow_up);
            TextView textView = (TextView) inflate.findViewById(R.id.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.gravity = 5;
            if (!TbadkCoreApplication.isLogin()) {
                layoutParams.rightMargin = l.getDimens(this.lDI.getContext(), R.dimen.ds28);
            } else {
                layoutParams.rightMargin = l.getDimens(this.lDI.getContext(), R.dimen.ds128);
            }
            textView.setText(R.string.share_tip);
            textView.setOnClickListener(this.jyH);
            this.lVI = new PopupWindow(inflate, -2, -2);
        }
    }

    public void duf() {
        if (this.jyG != null) {
            e.mY().removeCallbacks(this.jyG);
        }
        cLx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLx() {
        g.dismissPopupWindow(this.lVI);
    }

    public void dF(View view) {
    }

    public void fZ(String str, String str2) {
        if (this.lDI != null && this.lVD != null) {
            if (StringUtils.isNull(str)) {
                this.lVE.setVisibility(8);
                this.fdq.setText("贴吧动态");
                this.mForumName = null;
            } else {
                this.lVE.setVisibility(0);
                this.mForumName = str;
                az.a(this.fdq, str, R.string.forum, R.dimen.tbds0, 1, this.lVM, false);
                k.blV().setForumNameForWaterImage(str);
                this.lVE.startLoad(str2, 10, false);
            }
            dud();
        }
    }
}
