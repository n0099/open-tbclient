package com.baidu.tieba.pb.pb.main.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.ac;
import com.baidu.tieba.pb.pb.main.ad;
/* loaded from: classes2.dex */
public class c {
    private ImageView aiG;
    public final View fOs;
    public TextView fmZ;
    private ImageView gZY;
    public View jvO;
    private final ImageView kCt;
    private final LinearLayout kCu;
    private PbFragment lIN;
    public String mForumName;
    public final NavigationBar mNavigationBar;
    public TextView maQ;
    public LinearLayout maR;
    public BarImageView maS;
    private PopupWindow maW;
    private int maX;
    private int maY;
    private int maZ;
    private int mba;
    private Runnable runnable;
    private boolean lVQ = false;
    private AlertDialog maT = null;
    private ac maU = null;
    private float eXX = 0.33f;
    private boolean maV = false;
    private boolean mbb = true;
    private Runnable jLf = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
        @Override // java.lang.Runnable
        public void run() {
            c.this.cOB();
        }
    };
    private View.OnClickListener jLg = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.dtV();
        }
    };

    public c(PbFragment pbFragment, View view) {
        this.maX = 0;
        this.maY = 0;
        this.maZ = 0;
        this.mba = 0;
        this.lIN = pbFragment;
        this.maX = l.getDimens(pbFragment.getContext(), R.dimen.ds88);
        this.maY = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds14);
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        this.maZ = ((int) (equipmentWidth * 0.07d)) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds102);
        if (this.maZ - dimens > 0) {
            this.maZ -= dimens;
        }
        this.mba = (equipmentWidth - (this.maZ * 2)) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds89);
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                c.this.lIN.cFB();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.fOs = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbFragment.jhV);
        this.maQ = this.mNavigationBar.setCenterTextTitle("");
        this.kCt = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.kCu = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        this.kCu.setPadding(dimens2, 0, dimens2, 0);
        ao.setNavbarIconSrc(this.kCt, R.drawable.icon_pb_play_small, R.drawable.icon_pb_play_small);
        this.kCt.setVisibility(8);
        this.maQ.setOnClickListener(pbFragment.jhV);
        this.kCt.setOnClickListener(pbFragment.jhV);
        this.gZY = (ImageView) this.fOs.findViewById(R.id.widget_navi_back_button);
        if (this.maR == null) {
            this.maR = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.nav_fourm_title_layout, (View.OnClickListener) null);
            this.maS = (BarImageView) this.maR.findViewById(R.id.pb_nav_title_forum_image);
            this.maS.setShowOval(true);
            this.maS.setShowOuterBorder(false);
            this.maS.setShowInnerBorder(true);
            this.maS.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.maS.setStrokeColorResId(R.color.CAM_X0401);
            this.maS.setOnClickListener(pbFragment.jhV);
            this.fmZ = (TextView) this.maR.findViewById(R.id.pb_nav_title_forum_name);
            this.fmZ.setOnClickListener(pbFragment.jhV);
            if (this.maR.getLayoutParams() != null && (this.maR.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.maZ > 0 && this.mba > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.maR.getLayoutParams();
                marginLayoutParams.leftMargin = this.maZ;
                marginLayoutParams.rightMargin = this.maZ;
                this.maR.setLayoutParams(marginLayoutParams);
            }
            if (this.maR.getVisibility() == 8) {
                this.maR.setVisibility(0);
            }
            if (this.maR.getAlpha() != 1.0f) {
                this.maR.setAlpha(1.0f);
            }
        }
    }

    public void vM(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.lVQ = z;
        if (this.jvO == null && this.aiG == null) {
            this.jvO = this.mNavigationBar.addCustomView(controlAlign, R.layout.nb_item_floor_more, this.lIN.jhV);
            this.aiG = (ImageView) this.jvO.findViewById(R.id.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.maX, this.maX);
            layoutParams.rightMargin = this.maY;
            this.jvO.setLayoutParams(layoutParams);
            SvgManager.bwr().a(this.aiG, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.jvO.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void vr(boolean z) {
        if (this.jvO != null) {
            this.jvO.setVisibility(z ? 0 : 8);
        }
    }

    public NavigationBar dtM() {
        return this.mNavigationBar;
    }

    public void vN(boolean z) {
        if (z) {
            this.fOs.setVisibility(0);
        } else {
            this.fOs.setVisibility(8);
        }
        vP(z);
    }

    public void Le(String str) {
        if (!TextUtils.isEmpty(str) && !this.lVQ) {
            this.maQ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            vP(true);
            k.bov().setForumNameForWaterImage(str);
            return;
        }
        vP(false);
    }

    public void a(ad adVar) {
        if (!this.lIN.getBaseFragmentActivity().isProgressBarShown()) {
            this.maU = new ac(this.lIN, this.lIN.jhV);
            this.maT = new AlertDialog.Builder(this.lIN.getContext(), R.style.DialogTheme).create();
            this.maT.setCanceledOnTouchOutside(true);
            this.maT.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(false));
                }
            });
            g.showDialog(this.maT, this.lIN.getFragmentActivity());
            Window window = this.maT.getWindow();
            window.addFlags(512);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = l.getDimens(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.maU.getView());
            window.setDimAmount(this.eXX);
            this.maU.vf(adVar == null ? false : adVar.lSx);
            this.maU.vg(adVar == null ? false : adVar.lSB);
            this.maU.vh(adVar == null ? false : adVar.lSF);
            this.maU.vj(adVar == null ? false : adVar.lSC);
            this.maU.vk(adVar == null ? true : adVar.lSz);
            if (adVar == null) {
                this.maU.aq(false, false);
                this.maU.ar(false, false);
            } else {
                this.maU.aq(adVar.lSD, adVar.lSJ);
                this.maU.ar(adVar.lSE, adVar.lSI);
            }
            boolean z = adVar == null ? false : adVar.FF;
            boolean z2 = adVar == null ? false : adVar.isHostOnly;
            boolean z3 = adVar == null ? false : adVar.lSA;
            boolean z4 = adVar == null ? false : adVar.lSy;
            boolean z5 = adVar == null ? false : adVar.lSH;
            boolean z6 = adVar == null ? false : adVar.lSG;
            this.maU.ap(z3, z2);
            this.maU.as(z4, z);
            this.maU.at(z6, z5);
            if (adVar != null) {
                this.maU.lSu = adVar.lSK;
                if (adVar.lSK) {
                    this.maU.drm().setText(R.string.report_text);
                    this.maU.vj(false);
                }
            }
            this.maU.vi(adVar != null ? adVar.lSL : false);
            if (!TbSingleton.getInstance().mCanCallFans && this.lIN.dnW() != null && this.lIN.dnW().getPbData() != null && this.lIN.dnW().getPbData().getThreadId() != null && this.lIN.dnW().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                this.maU.drp().setText(R.string.have_called_fans_short);
            }
            dtN();
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(true));
        }
    }

    private void dtN() {
        if (this.maU != null) {
            this.maU.drt();
        }
    }

    public void bet() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.maT != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.valueOf(!g.dismissDialog(c.this.maT, c.this.lIN.getPageContext().getPageActivity()))));
                    }
                }
            };
        }
        e.mB().postDelayed(this.runnable, 100L);
    }

    public void dtO() {
        if (this.maT != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.valueOf(!g.dismissDialog(this.maT, this.lIN.getPageContext().getPageActivity()))));
        }
    }

    public ac dtP() {
        return this.maU;
    }

    public View dtQ() {
        return this.kCt;
    }

    public boolean dtR() {
        return this.maT != null && this.maT.isShowing();
    }

    public void dcR() {
        if (this.maU != null) {
            this.maU.release();
        }
        this.maT = null;
        this.maU = null;
        e.mB().removeCallbacks(this.runnable);
    }

    public void dtS() {
        if (this.jvO != null) {
            this.jvO.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.lIN.getPageContext(), i);
            ao.setBackgroundResource(this.mNavigationBar.getBarBgView(), R.color.CAM_X0207);
        }
        WebPManager.a(this.gZY, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.a(this.aiG, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
        ao.setNavbarTitleColor(this.maQ, R.color.CAM_X0105, R.color.s_navbar_title_color);
        ao.setViewTextColor(this.fmZ, R.color.CAM_X0105);
        dtT();
        dtN();
    }

    private void dtT() {
        if (this.maR != null) {
            if (!TextUtils.isEmpty(this.mForumName)) {
                com.baidu.tbadk.core.elementsMaven.c.bv(this.maR).pK(R.string.J_X07).setBackGroundColor(R.color.CAM_X0209);
            } else {
                this.maR.setBackgroundResource(0);
            }
        }
    }

    public void Hs(int i) {
        this.mNavigationBar.onChangeSkinType(this.lIN.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha85));
        this.maQ.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0111));
        WebPManager.a(this.aiG, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.a(this.gZY, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
    }

    public void dtU() {
        this.gZY.setVisibility(0);
        vP(false);
        if (this.jvO != null) {
            this.jvO.setVisibility(8);
        }
    }

    public void vO(boolean z) {
        this.gZY.setVisibility(0);
        vP(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.jvO != null) {
                this.jvO.setVisibility(0);
            }
        } else if (this.jvO != null) {
            this.jvO.setVisibility(8);
        }
    }

    public void vP(boolean z) {
        if (!this.lVQ && z && !"".equals(this.maQ.getText().toString())) {
            this.maQ.setVisibility(0);
        } else {
            this.maQ.setVisibility(8);
        }
    }

    public void vQ(boolean z) {
        this.maV = z;
    }

    public void dsu() {
        if ((!this.maV || TbadkCoreApplication.isLogin()) && !com.baidu.tbadk.core.sharedPref.b.bvr().getBoolean(SharedPrefConfig.SHOW_SHARE, false)) {
            View inflate = LayoutInflater.from(this.lIN.getContext()).inflate(R.layout.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.arrow_up);
            TextView textView = (TextView) inflate.findViewById(R.id.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.gravity = 5;
            if (!TbadkCoreApplication.isLogin()) {
                layoutParams.rightMargin = l.getDimens(this.lIN.getContext(), R.dimen.ds28);
            } else {
                layoutParams.rightMargin = l.getDimens(this.lIN.getContext(), R.dimen.ds128);
            }
            textView.setText(R.string.share_tip);
            textView.setOnClickListener(this.jLg);
            this.maW = new PopupWindow(inflate, -2, -2);
        }
    }

    public void dtV() {
        if (this.jLf != null) {
            e.mB().removeCallbacks(this.jLf);
        }
        cOB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOB() {
        g.dismissPopupWindow(this.maW);
    }

    public void dP(View view) {
    }

    public void fW(String str, String str2) {
        if (this.lIN != null && this.maR != null) {
            if (StringUtils.isNull(str)) {
                this.maS.setVisibility(8);
                this.fmZ.setText("贴吧动态");
                this.mForumName = null;
            } else {
                this.maS.setVisibility(0);
                this.mForumName = str;
                ay.a(this.fmZ, str, R.string.forum, R.dimen.tbds0, 1, this.mba, false);
                k.bov().setForumNameForWaterImage(str);
                this.maS.startLoad(str2, 10, false);
            }
            dtT();
        }
    }
}
