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
/* loaded from: classes21.dex */
public class c {
    private ImageView agU;
    public TextView eVT;
    public final View fwY;
    private ImageView gFi;
    private final ImageView keb;
    private final LinearLayout kec;
    public TextView lHF;
    public View lHG;
    public LinearLayout lHH;
    public BarImageView lHI;
    private PopupWindow lHM;
    private int lHN;
    private int lHO;
    private int lHP;
    private int lHQ;
    private PbFragment lpX;
    public String mForumName;
    public final NavigationBar mNavigationBar;
    private Runnable runnable;
    private boolean lCP = false;
    private AlertDialog lHJ = null;
    private aj lHK = null;
    private float eGU = 0.33f;
    private boolean lHL = false;
    private boolean lHR = true;
    private Runnable jlb = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.cGh();
        }
    };
    private View.OnClickListener jlc = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.doN();
        }
    };

    public c(PbFragment pbFragment, View view) {
        this.lHN = 0;
        this.lHO = 0;
        this.lHP = 0;
        this.lHQ = 0;
        this.lpX = pbFragment;
        this.lHN = l.getDimens(pbFragment.getContext(), R.dimen.ds88);
        this.lHO = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds14);
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        this.lHP = ((int) (equipmentWidth * 0.07d)) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds102);
        if (this.lHP - dimens > 0) {
            this.lHP -= dimens;
        }
        this.lHQ = (equipmentWidth - (this.lHP * 2)) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds89);
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                c.this.lpX.cyo();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.fwY = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbFragment.iKO);
        this.lHF = this.mNavigationBar.setCenterTextTitle("");
        this.keb = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.kec = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        this.kec.setPadding(dimens2, 0, dimens2, 0);
        ap.setNavbarIconSrc(this.keb, R.drawable.icon_pb_play_small, R.drawable.icon_pb_play_small);
        this.keb.setVisibility(8);
        this.lHF.setOnClickListener(pbFragment.iKO);
        this.keb.setOnClickListener(pbFragment.iKO);
        this.gFi = (ImageView) this.fwY.findViewById(R.id.widget_navi_back_button);
        if (this.lHH == null) {
            this.lHH = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.nav_fourm_title_layout, (View.OnClickListener) null);
            this.lHI = (BarImageView) this.lHH.findViewById(R.id.pb_nav_title_forum_image);
            this.lHI.setShowOval(true);
            this.lHI.setShowOuterBorder(false);
            this.lHI.setShowInnerBorder(true);
            this.lHI.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.lHI.setStrokeColorResId(R.color.CAM_X0401);
            this.lHI.setOnClickListener(pbFragment.iKO);
            this.eVT = (TextView) this.lHH.findViewById(R.id.pb_nav_title_forum_name);
            this.eVT.setOnClickListener(pbFragment.iKO);
            if (this.lHH.getLayoutParams() != null && (this.lHH.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.lHP > 0 && this.lHQ > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.lHH.getLayoutParams();
                marginLayoutParams.leftMargin = this.lHP;
                marginLayoutParams.rightMargin = this.lHP;
                this.lHH.setLayoutParams(marginLayoutParams);
            }
            if (this.lHH.getVisibility() == 8) {
                this.lHH.setVisibility(0);
            }
            if (this.lHH.getAlpha() != 1.0f) {
                this.lHH.setAlpha(1.0f);
            }
        }
    }

    public void vi(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.lCP = z;
        if (this.lHG == null && this.agU == null) {
            this.lHG = this.mNavigationBar.addCustomView(controlAlign, R.layout.nb_item_floor_more, this.lpX.iKO);
            this.agU = (ImageView) this.lHG.findViewById(R.id.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.lHN, this.lHN);
            layoutParams.rightMargin = this.lHO;
            this.lHG.setLayoutParams(layoutParams);
            SvgManager.bqB().a(this.agU, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.lHG.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void uN(boolean z) {
        if (this.lHG != null) {
            this.lHG.setVisibility(z ? 0 : 8);
        }
    }

    public NavigationBar doE() {
        return this.mNavigationBar;
    }

    public void vj(boolean z) {
        if (z) {
            this.fwY.setVisibility(0);
        } else {
            this.fwY.setVisibility(8);
        }
        vl(z);
    }

    public void Nd(String str) {
        if (!TextUtils.isEmpty(str) && !this.lCP) {
            this.lHF.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            vl(true);
            k.biL().setForumNameForWaterImage(str);
            return;
        }
        vl(false);
    }

    public void a(ak akVar) {
        if (!this.lpX.getBaseFragmentActivity().isProgressBarShown()) {
            this.lHK = new aj(this.lpX, this.lpX.iKO);
            this.lHJ = new AlertDialog.Builder(this.lpX.getContext(), R.style.DialogTheme).create();
            this.lHJ.setCanceledOnTouchOutside(true);
            g.showDialog(this.lHJ, this.lpX.getFragmentActivity());
            Window window = this.lHJ.getWindow();
            window.addFlags(512);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = l.getDimens(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.lHK.getView());
            window.setDimAmount(this.eGU);
            this.lHK.uC(akVar == null ? false : akVar.lzw);
            this.lHK.uD(akVar == null ? false : akVar.lzA);
            this.lHK.uE(akVar == null ? false : akVar.lzE);
            this.lHK.uG(akVar == null ? false : akVar.lzB);
            this.lHK.uH(akVar == null ? true : akVar.lzy);
            if (akVar == null) {
                this.lHK.ao(false, false);
                this.lHK.ap(false, false);
            } else {
                this.lHK.ao(akVar.lzC, akVar.lzI);
                this.lHK.ap(akVar.lzD, akVar.lzH);
            }
            boolean z = akVar == null ? false : akVar.Fc;
            boolean z2 = akVar == null ? false : akVar.isHostOnly;
            boolean z3 = akVar == null ? false : akVar.lzz;
            boolean z4 = akVar == null ? false : akVar.lzx;
            boolean z5 = akVar == null ? false : akVar.lzG;
            boolean z6 = akVar == null ? false : akVar.lzF;
            this.lHK.an(z3, z2);
            this.lHK.aq(z4, z);
            this.lHK.ar(z6, z5);
            if (akVar != null) {
                this.lHK.lzt = akVar.lzJ;
                if (akVar.lzJ) {
                    this.lHK.dmh().setText(R.string.report_text);
                    this.lHK.uG(false);
                }
            }
            this.lHK.uF(akVar != null ? akVar.lzK : false);
            if (!TbSingleton.getInstance().mCanCallFans && this.lpX.diV() != null && this.lpX.diV().getPbData() != null && this.lpX.diV().getPbData().getThreadId() != null && this.lpX.diV().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                this.lHK.dmk().setText(R.string.have_called_fans_short);
            }
            doF();
        }
    }

    private void doF() {
        if (this.lHK != null) {
            this.lHK.dmo();
        }
    }

    public void aYV() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.lHJ != null) {
                        g.dismissDialog(c.this.lHJ, c.this.lpX.getPageContext().getPageActivity());
                    }
                }
            };
        }
        e.mY().postDelayed(this.runnable, 100L);
    }

    public void doG() {
        if (this.lHJ != null) {
            g.dismissDialog(this.lHJ, this.lpX.getPageContext().getPageActivity());
        }
    }

    public aj doH() {
        return this.lHK;
    }

    public View doI() {
        return this.keb;
    }

    public boolean doJ() {
        return this.lHJ != null && this.lHJ.isShowing();
    }

    public void releaseResources() {
        if (this.lHK != null) {
            this.lHK.release();
        }
        this.lHJ = null;
        this.lHK = null;
        e.mY().removeCallbacks(this.runnable);
    }

    public void doK() {
        if (this.lHG != null) {
            this.lHG.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.lpX.getPageContext(), i);
            ap.setBackgroundResource(this.mNavigationBar.getBarBgView(), R.color.CAM_X0207);
        }
        WebPManager.a(this.gFi, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.a(this.agU, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
        ap.setNavbarTitleColor(this.lHF, R.color.CAM_X0105, R.color.s_navbar_title_color);
        ap.setViewTextColor(this.eVT, R.color.CAM_X0105);
        doL();
        doF();
    }

    private void doL() {
        if (this.lHH != null) {
            if (!TextUtils.isEmpty(this.mForumName)) {
                com.baidu.tbadk.core.elementsMaven.c.bj(this.lHH).pb(R.string.J_X07).setBackGroundColor(R.color.CAM_X0209);
            } else {
                this.lHH.setBackgroundResource(0);
            }
        }
    }

    public void GJ(int i) {
        this.mNavigationBar.onChangeSkinType(this.lpX.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha85));
        this.lHF.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0111));
        WebPManager.a(this.agU, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.a(this.gFi, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
    }

    public void doM() {
        this.gFi.setVisibility(0);
        vl(false);
        if (this.lHG != null) {
            this.lHG.setVisibility(8);
        }
    }

    public void vk(boolean z) {
        this.gFi.setVisibility(0);
        vl(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.lHG != null) {
                this.lHG.setVisibility(0);
            }
        } else if (this.lHG != null) {
            this.lHG.setVisibility(8);
        }
    }

    public void vl(boolean z) {
        if (!this.lCP && z && !"".equals(this.lHF.getText().toString())) {
            this.lHF.setVisibility(0);
        } else {
            this.lHF.setVisibility(8);
        }
    }

    public void vm(boolean z) {
        this.lHL = z;
    }

    public void dnm() {
        if ((!this.lHL || TbadkCoreApplication.isLogin()) && !com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean(SharedPrefConfig.SHOW_SHARE, false)) {
            View inflate = LayoutInflater.from(this.lpX.getContext()).inflate(R.layout.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.arrow_up);
            TextView textView = (TextView) inflate.findViewById(R.id.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.gravity = 5;
            if (!TbadkCoreApplication.isLogin()) {
                layoutParams.rightMargin = l.getDimens(this.lpX.getContext(), R.dimen.ds28);
            } else {
                layoutParams.rightMargin = l.getDimens(this.lpX.getContext(), R.dimen.ds128);
            }
            textView.setText(R.string.share_tip);
            textView.setOnClickListener(this.jlc);
            this.lHM = new PopupWindow(inflate, -2, -2);
        }
    }

    public void doN() {
        if (this.jlb != null) {
            e.mY().removeCallbacks(this.jlb);
        }
        cGh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGh() {
        g.dismissPopupWindow(this.lHM);
    }

    public void dv(View view) {
    }

    public void fU(String str, String str2) {
        if (this.lpX != null && this.lHH != null) {
            if (StringUtils.isNull(str)) {
                this.lHI.setVisibility(8);
                this.eVT.setText("贴吧动态");
                this.mForumName = null;
            } else {
                this.lHI.setVisibility(0);
                this.mForumName = str;
                az.a(this.eVT, str, R.string.forum, R.dimen.tbds0, 1, this.lHQ, false);
                k.biL().setForumNameForWaterImage(str);
                this.lHI.startLoad(str2, 10, false);
            }
            doL();
        }
    }
}
