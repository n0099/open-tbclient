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
    private ImageView gOj;
    public View jjn;
    private final ImageView krC;
    private final LinearLayout krD;
    private PbFragment lDG;
    public TextView lVA;
    public LinearLayout lVB;
    public BarImageView lVC;
    private PopupWindow lVG;
    private int lVH;
    private int lVI;
    private int lVJ;
    private int lVK;
    public String mForumName;
    public final NavigationBar mNavigationBar;
    private Runnable runnable;
    private boolean lQC = false;
    private AlertDialog lVD = null;
    private aj lVE = null;
    private float eOa = 0.33f;
    private boolean lVF = false;
    private boolean lVL = true;
    private Runnable jyE = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.cLw();
        }
    };
    private View.OnClickListener jyF = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.due();
        }
    };

    public c(PbFragment pbFragment, View view) {
        this.lVH = 0;
        this.lVI = 0;
        this.lVJ = 0;
        this.lVK = 0;
        this.lDG = pbFragment;
        this.lVH = l.getDimens(pbFragment.getContext(), R.dimen.ds88);
        this.lVI = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds14);
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        this.lVJ = ((int) (equipmentWidth * 0.07d)) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds102);
        if (this.lVJ - dimens > 0) {
            this.lVJ -= dimens;
        }
        this.lVK = (equipmentWidth - (this.lVJ * 2)) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds89);
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                c.this.lDG.cCF();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.fEN = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbFragment.iVH);
        this.lVA = this.mNavigationBar.setCenterTextTitle("");
        this.krC = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.krD = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        this.krD.setPadding(dimens2, 0, dimens2, 0);
        ap.setNavbarIconSrc(this.krC, R.drawable.icon_pb_play_small, R.drawable.icon_pb_play_small);
        this.krC.setVisibility(8);
        this.lVA.setOnClickListener(pbFragment.iVH);
        this.krC.setOnClickListener(pbFragment.iVH);
        this.gOj = (ImageView) this.fEN.findViewById(R.id.widget_navi_back_button);
        if (this.lVB == null) {
            this.lVB = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.nav_fourm_title_layout, (View.OnClickListener) null);
            this.lVC = (BarImageView) this.lVB.findViewById(R.id.pb_nav_title_forum_image);
            this.lVC.setShowOval(true);
            this.lVC.setShowOuterBorder(false);
            this.lVC.setShowInnerBorder(true);
            this.lVC.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.lVC.setStrokeColorResId(R.color.CAM_X0401);
            this.lVC.setOnClickListener(pbFragment.iVH);
            this.fdq = (TextView) this.lVB.findViewById(R.id.pb_nav_title_forum_name);
            this.fdq.setOnClickListener(pbFragment.iVH);
            if (this.lVB.getLayoutParams() != null && (this.lVB.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.lVJ > 0 && this.lVK > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.lVB.getLayoutParams();
                marginLayoutParams.leftMargin = this.lVJ;
                marginLayoutParams.rightMargin = this.lVJ;
                this.lVB.setLayoutParams(marginLayoutParams);
            }
            if (this.lVB.getVisibility() == 8) {
                this.lVB.setVisibility(0);
            }
            if (this.lVB.getAlpha() != 1.0f) {
                this.lVB.setAlpha(1.0f);
            }
        }
    }

    public void vL(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.lQC = z;
        if (this.jjn == null && this.ahT == null) {
            this.jjn = this.mNavigationBar.addCustomView(controlAlign, R.layout.nb_item_floor_more, this.lDG.iVH);
            this.ahT = (ImageView) this.jjn.findViewById(R.id.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.lVH, this.lVH);
            layoutParams.rightMargin = this.lVI;
            this.jjn.setLayoutParams(layoutParams);
            SvgManager.btW().a(this.ahT, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.jjn.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void vq(boolean z) {
        if (this.jjn != null) {
            this.jjn.setVisibility(z ? 0 : 8);
        }
    }

    public NavigationBar dtV() {
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
        if (!TextUtils.isEmpty(str) && !this.lQC) {
            this.lVA.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            vO(true);
            k.blV().setForumNameForWaterImage(str);
            return;
        }
        vO(false);
    }

    public void a(ak akVar) {
        if (!this.lDG.getBaseFragmentActivity().isProgressBarShown()) {
            this.lVE = new aj(this.lDG, this.lDG.iVH);
            this.lVD = new AlertDialog.Builder(this.lDG.getContext(), R.style.DialogTheme).create();
            this.lVD.setCanceledOnTouchOutside(true);
            g.showDialog(this.lVD, this.lDG.getFragmentActivity());
            Window window = this.lVD.getWindow();
            window.addFlags(512);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = l.getDimens(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.lVE.getView());
            window.setDimAmount(this.eOa);
            this.lVE.ve(akVar == null ? false : akVar.lNj);
            this.lVE.vf(akVar == null ? false : akVar.lNn);
            this.lVE.vg(akVar == null ? false : akVar.lNr);
            this.lVE.vi(akVar == null ? false : akVar.lNo);
            this.lVE.vj(akVar == null ? true : akVar.lNl);
            if (akVar == null) {
                this.lVE.ao(false, false);
                this.lVE.ap(false, false);
            } else {
                this.lVE.ao(akVar.lNp, akVar.lNv);
                this.lVE.ap(akVar.lNq, akVar.lNu);
            }
            boolean z = akVar == null ? false : akVar.FT;
            boolean z2 = akVar == null ? false : akVar.isHostOnly;
            boolean z3 = akVar == null ? false : akVar.lNm;
            boolean z4 = akVar == null ? false : akVar.lNk;
            boolean z5 = akVar == null ? false : akVar.lNt;
            boolean z6 = akVar == null ? false : akVar.lNs;
            this.lVE.an(z3, z2);
            this.lVE.aq(z4, z);
            this.lVE.ar(z6, z5);
            if (akVar != null) {
                this.lVE.lNg = akVar.lNw;
                if (akVar.lNw) {
                    this.lVE.dry().setText(R.string.report_text);
                    this.lVE.vi(false);
                }
            }
            this.lVE.vh(akVar != null ? akVar.lNx : false);
            if (!TbSingleton.getInstance().mCanCallFans && this.lDG.dok() != null && this.lDG.dok().getPbData() != null && this.lDG.dok().getPbData().getThreadId() != null && this.lDG.dok().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                this.lVE.drB().setText(R.string.have_called_fans_short);
            }
            dtW();
        }
    }

    private void dtW() {
        if (this.lVE != null) {
            this.lVE.drF();
        }
    }

    public void bca() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.lVD != null) {
                        g.dismissDialog(c.this.lVD, c.this.lDG.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.mY().postDelayed(this.runnable, 100L);
    }

    public void dtX() {
        if (this.lVD != null) {
            g.dismissDialog(this.lVD, this.lDG.getPageContext().getPageActivity());
        }
    }

    public aj dtY() {
        return this.lVE;
    }

    public View dtZ() {
        return this.krC;
    }

    public boolean dua() {
        return this.lVD != null && this.lVD.isShowing();
    }

    public void releaseResources() {
        if (this.lVE != null) {
            this.lVE.release();
        }
        this.lVD = null;
        this.lVE = null;
        e.mY().removeCallbacks(this.runnable);
    }

    public void dub() {
        if (this.jjn != null) {
            this.jjn.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.lDG.getPageContext(), i);
            ap.setBackgroundResource(this.mNavigationBar.getBarBgView(), R.color.CAM_X0207);
        }
        WebPManager.a(this.gOj, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.a(this.ahT, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
        ap.setNavbarTitleColor(this.lVA, R.color.CAM_X0105, R.color.s_navbar_title_color);
        ap.setViewTextColor(this.fdq, R.color.CAM_X0105);
        duc();
        dtW();
    }

    private void duc() {
        if (this.lVB != null) {
            if (!TextUtils.isEmpty(this.mForumName)) {
                com.baidu.tbadk.core.elementsMaven.c.bm(this.lVB).pA(R.string.J_X07).setBackGroundColor(R.color.CAM_X0209);
            } else {
                this.lVB.setBackgroundResource(0);
            }
        }
    }

    public void Hz(int i) {
        this.mNavigationBar.onChangeSkinType(this.lDG.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha85));
        this.lVA.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0111));
        WebPManager.a(this.ahT, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.a(this.gOj, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
    }

    public void dud() {
        this.gOj.setVisibility(0);
        vO(false);
        if (this.jjn != null) {
            this.jjn.setVisibility(8);
        }
    }

    public void vN(boolean z) {
        this.gOj.setVisibility(0);
        vO(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.jjn != null) {
                this.jjn.setVisibility(0);
            }
        } else if (this.jjn != null) {
            this.jjn.setVisibility(8);
        }
    }

    public void vO(boolean z) {
        if (!this.lQC && z && !"".equals(this.lVA.getText().toString())) {
            this.lVA.setVisibility(0);
        } else {
            this.lVA.setVisibility(8);
        }
    }

    public void vP(boolean z) {
        this.lVF = z;
    }

    public void dsE() {
        if ((!this.lVF || TbadkCoreApplication.isLogin()) && !com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.SHOW_SHARE, false)) {
            View inflate = LayoutInflater.from(this.lDG.getContext()).inflate(R.layout.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.arrow_up);
            TextView textView = (TextView) inflate.findViewById(R.id.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.gravity = 5;
            if (!TbadkCoreApplication.isLogin()) {
                layoutParams.rightMargin = l.getDimens(this.lDG.getContext(), R.dimen.ds28);
            } else {
                layoutParams.rightMargin = l.getDimens(this.lDG.getContext(), R.dimen.ds128);
            }
            textView.setText(R.string.share_tip);
            textView.setOnClickListener(this.jyF);
            this.lVG = new PopupWindow(inflate, -2, -2);
        }
    }

    public void due() {
        if (this.jyE != null) {
            e.mY().removeCallbacks(this.jyE);
        }
        cLw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLw() {
        g.dismissPopupWindow(this.lVG);
    }

    public void dF(View view) {
    }

    public void fZ(String str, String str2) {
        if (this.lDG != null && this.lVB != null) {
            if (StringUtils.isNull(str)) {
                this.lVC.setVisibility(8);
                this.fdq.setText("贴吧动态");
                this.mForumName = null;
            } else {
                this.lVC.setVisibility(0);
                this.mForumName = str;
                az.a(this.fdq, str, R.string.forum, R.dimen.tbds0, 1, this.lVK, false);
                k.blV().setForumNameForWaterImage(str);
                this.lVC.startLoad(str2, 10, false);
            }
            duc();
        }
    }
}
