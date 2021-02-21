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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.ac;
import com.baidu.tieba.pb.pb.main.ad;
/* loaded from: classes2.dex */
public class c {
    private ImageView ahC;
    public final View fLW;
    public TextView fkH;
    private ImageView gYq;
    public View jxc;
    private final ImageView kGi;
    private final LinearLayout kGj;
    private PbFragment lNm;
    public String mForumName;
    public final NavigationBar mNavigationBar;
    public TextView mfD;
    public LinearLayout mfE;
    public BarImageView mfF;
    private PopupWindow mfJ;
    private int mfK;
    private int mfL;
    private int mfM;
    private int mfN;
    private Runnable runnable;
    private boolean maA = false;
    private AlertDialog mfG = null;
    private ac mfH = null;
    private float eVC = 0.33f;
    private boolean mfI = false;
    private boolean mfO = true;
    private Runnable jMr = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
        @Override // java.lang.Runnable
        public void run() {
            c.this.cMe();
        }
    };
    private View.OnClickListener jMs = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.dsy();
        }
    };

    public c(PbFragment pbFragment, View view) {
        this.mfK = 0;
        this.mfL = 0;
        this.mfM = 0;
        this.mfN = 0;
        this.lNm = pbFragment;
        this.mfK = l.getDimens(pbFragment.getContext(), R.dimen.ds88);
        this.mfL = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds14);
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        this.mfM = ((int) (equipmentWidth * 0.07d)) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds102);
        if (this.mfM - dimens > 0) {
            this.mfM -= dimens;
        }
        this.mfN = (equipmentWidth - (this.mfM * 2)) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds89);
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                c.this.lNm.cDc();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.fLW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbFragment.jjj);
        this.mfD = this.mNavigationBar.setCenterTextTitle("");
        this.kGi = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.kGj = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        this.kGj.setPadding(dimens2, 0, dimens2, 0);
        ap.setNavbarIconSrc(this.kGi, R.drawable.icon_pb_play_small, R.drawable.icon_pb_play_small);
        this.kGi.setVisibility(8);
        this.mfD.setOnClickListener(pbFragment.jjj);
        this.kGi.setOnClickListener(pbFragment.jjj);
        this.gYq = (ImageView) this.fLW.findViewById(R.id.widget_navi_back_button);
        if (this.mfE == null) {
            this.mfE = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.nav_fourm_title_layout, (View.OnClickListener) null);
            this.mfF = (BarImageView) this.mfE.findViewById(R.id.pb_nav_title_forum_image);
            this.mfF.setShowOval(true);
            this.mfF.setShowOuterBorder(false);
            this.mfF.setShowInnerBorder(true);
            this.mfF.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.mfF.setStrokeColorResId(R.color.CAM_X0401);
            this.mfF.setOnClickListener(pbFragment.jjj);
            this.fkH = (TextView) this.mfE.findViewById(R.id.pb_nav_title_forum_name);
            this.fkH.setOnClickListener(pbFragment.jjj);
            if (this.mfE.getLayoutParams() != null && (this.mfE.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.mfM > 0 && this.mfN > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mfE.getLayoutParams();
                marginLayoutParams.leftMargin = this.mfM;
                marginLayoutParams.rightMargin = this.mfM;
                this.mfE.setLayoutParams(marginLayoutParams);
            }
            if (this.mfE.getVisibility() == 8) {
                this.mfE.setVisibility(0);
            }
            if (this.mfE.getAlpha() != 1.0f) {
                this.mfE.setAlpha(1.0f);
            }
        }
    }

    public void vY(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.maA = z;
        if (this.jxc == null && this.ahC == null) {
            this.jxc = this.mNavigationBar.addCustomView(controlAlign, R.layout.nb_item_floor_more, this.lNm.jjj);
            this.ahC = (ImageView) this.jxc.findViewById(R.id.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mfK, this.mfK);
            layoutParams.rightMargin = this.mfL;
            this.jxc.setLayoutParams(layoutParams);
            SvgManager.bsR().a(this.ahC, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.jxc.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void vC(boolean z) {
        if (this.jxc != null) {
            this.jxc.setVisibility(z ? 0 : 8);
        }
    }

    public NavigationBar dsp() {
        return this.mNavigationBar;
    }

    public void vZ(boolean z) {
        if (z) {
            this.fLW.setVisibility(0);
        } else {
            this.fLW.setVisibility(8);
        }
        wb(z);
    }

    public void KG(String str) {
        if (!TextUtils.isEmpty(str) && !this.maA) {
            this.mfD.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            wb(true);
            k.bkT().setForumNameForWaterImage(str);
            return;
        }
        wb(false);
    }

    public void a(ad adVar) {
        if (!this.lNm.getBaseFragmentActivity().isProgressBarShown()) {
            this.mfH = new ac(this.lNm, this.lNm.jjj);
            this.mfG = new AlertDialog.Builder(this.lNm.getContext(), R.style.DialogTheme).create();
            this.mfG.setCanceledOnTouchOutside(true);
            this.mfG.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(false));
                }
            });
            g.showDialog(this.mfG, this.lNm.getFragmentActivity());
            Window window = this.mfG.getWindow();
            window.addFlags(512);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = l.getDimens(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.mfH.getView());
            window.setDimAmount(this.eVC);
            this.mfH.vq(adVar == null ? false : adVar.lXe);
            this.mfH.vr(adVar == null ? false : adVar.lXi);
            this.mfH.vs(adVar == null ? false : adVar.lXm);
            this.mfH.vu(adVar == null ? false : adVar.lXj);
            this.mfH.vv(adVar == null ? true : adVar.lXg);
            if (adVar == null) {
                this.mfH.aq(false, false);
                this.mfH.ar(false, false);
            } else {
                this.mfH.aq(adVar.lXk, adVar.lXq);
                this.mfH.ar(adVar.lXl, adVar.lXp);
            }
            boolean z = adVar == null ? false : adVar.FD;
            boolean z2 = adVar == null ? false : adVar.isHostOnly;
            boolean z3 = adVar == null ? false : adVar.lXh;
            boolean z4 = adVar == null ? false : adVar.lXf;
            boolean z5 = adVar == null ? false : adVar.lXo;
            boolean z6 = adVar == null ? false : adVar.lXn;
            this.mfH.ap(z3, z2);
            this.mfH.as(z4, z);
            this.mfH.at(z6, z5);
            if (adVar != null) {
                this.mfH.lXb = adVar.lXr;
                if (adVar.lXr) {
                    this.mfH.dpP().setText(R.string.report_text);
                    this.mfH.vu(false);
                }
            }
            this.mfH.vt(adVar == null ? false : adVar.lXs);
            if (!TbSingleton.getInstance().mCanCallFans && this.lNm.dmx() != null && this.lNm.dmx().getPbData() != null && this.lNm.dmx().getPbData().getThreadId() != null && this.lNm.dmx().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                this.mfH.dpS().setText(R.string.have_called_fans_short);
            }
            dsq();
            this.mfH.jJ(adVar != null ? adVar.eVr : false);
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(true));
        }
    }

    private void dsq() {
        if (this.mfH != null) {
            this.mfH.dpW();
        }
    }

    public void baM() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.mfG != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.valueOf(!g.dismissDialog(c.this.mfG, c.this.lNm.getPageContext().getPageActivity()))));
                    }
                }
            };
        }
        e.mA().postDelayed(this.runnable, 100L);
    }

    public void dsr() {
        if (this.mfG != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.valueOf(!g.dismissDialog(this.mfG, this.lNm.getPageContext().getPageActivity()))));
        }
    }

    public ac dss() {
        return this.mfH;
    }

    public View dst() {
        return this.kGi;
    }

    public boolean dsu() {
        return this.mfG != null && this.mfG.isShowing();
    }

    public void dbe() {
        if (this.mfH != null) {
            this.mfH.release();
        }
        this.mfG = null;
        this.mfH = null;
        e.mA().removeCallbacks(this.runnable);
    }

    public void dsv() {
        if (this.jxc != null) {
            this.jxc.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.lNm.getPageContext(), i);
            ap.setBackgroundResource(this.mNavigationBar.getBarBgView(), R.color.CAM_X0207);
        }
        if (this.mfF != null) {
            this.mfF.invalidate();
        }
        WebPManager.a(this.gYq, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.a(this.ahC, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
        ap.setNavbarTitleColor(this.mfD, R.color.CAM_X0105, R.color.s_navbar_title_color);
        ap.setViewTextColor(this.fkH, R.color.CAM_X0105);
        dsw();
        dsq();
    }

    private void dsw() {
        if (this.mfE != null) {
            if (!TextUtils.isEmpty(this.mForumName)) {
                com.baidu.tbadk.core.elementsMaven.c.br(this.mfE).og(R.string.J_X07).setBackGroundColor(R.color.CAM_X0209);
            } else {
                this.mfE.setBackgroundResource(0);
            }
        }
    }

    public void Gf(int i) {
        this.mNavigationBar.onChangeSkinType(this.lNm.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha85));
        this.mfD.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0111));
        WebPManager.a(this.ahC, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.a(this.gYq, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
    }

    public void dsx() {
        this.gYq.setVisibility(0);
        wb(false);
        if (this.jxc != null) {
            this.jxc.setVisibility(8);
        }
    }

    public void wa(boolean z) {
        this.gYq.setVisibility(0);
        wb(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.jxc != null) {
                this.jxc.setVisibility(0);
            }
        } else if (this.jxc != null) {
            this.jxc.setVisibility(8);
        }
    }

    public void wb(boolean z) {
        if (!this.maA && z && !"".equals(this.mfD.getText().toString())) {
            this.mfD.setVisibility(0);
        } else {
            this.mfD.setVisibility(8);
        }
    }

    public void wc(boolean z) {
        this.mfI = z;
    }

    public void dqX() {
        if ((!this.mfI || TbadkCoreApplication.isLogin()) && !com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(SharedPrefConfig.SHOW_SHARE, false)) {
            View inflate = LayoutInflater.from(this.lNm.getContext()).inflate(R.layout.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.arrow_up);
            TextView textView = (TextView) inflate.findViewById(R.id.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.gravity = 5;
            if (!TbadkCoreApplication.isLogin()) {
                layoutParams.rightMargin = l.getDimens(this.lNm.getContext(), R.dimen.ds28);
            } else {
                layoutParams.rightMargin = l.getDimens(this.lNm.getContext(), R.dimen.ds128);
            }
            textView.setText(R.string.share_tip);
            textView.setOnClickListener(this.jMs);
            this.mfJ = new PopupWindow(inflate, -2, -2);
        }
    }

    public void dsy() {
        if (this.jMr != null) {
            e.mA().removeCallbacks(this.jMr);
        }
        cMe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMe() {
        g.dismissPopupWindow(this.mfJ);
    }

    public void dN(View view) {
    }

    public void fV(String str, String str2) {
        if (this.lNm != null && this.mfE != null) {
            if (StringUtils.isNull(str)) {
                this.mfF.setVisibility(8);
                this.fkH.setText("贴吧动态");
                this.mForumName = null;
            } else {
                this.mfF.setVisibility(0);
                this.mForumName = str;
                az.a(this.fkH, str, R.string.forum, R.dimen.tbds0, 1, this.mfN, false);
                k.bkT().setForumNameForWaterImage(str);
                this.mfF.startLoad(str2, 10, false);
            }
            dsw();
        }
    }
}
