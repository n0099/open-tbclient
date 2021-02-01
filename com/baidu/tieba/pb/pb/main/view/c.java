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
    private ImageView gYc;
    public View jwO;
    private final ImageView kFU;
    private final LinearLayout kFV;
    private PbFragment lMX;
    public String mForumName;
    public final NavigationBar mNavigationBar;
    public TextView mfo;
    public LinearLayout mfp;
    public BarImageView mfq;
    private PopupWindow mfu;
    private int mfv;
    private int mfw;
    private int mfx;
    private int mfy;
    private Runnable runnable;
    private boolean maj = false;
    private AlertDialog mfr = null;
    private ac mfs = null;
    private float eVC = 0.33f;
    private boolean mft = false;
    private boolean mfz = true;
    private Runnable jMd = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
        @Override // java.lang.Runnable
        public void run() {
            c.this.cLX();
        }
    };
    private View.OnClickListener jMe = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.dsr();
        }
    };

    public c(PbFragment pbFragment, View view) {
        this.mfv = 0;
        this.mfw = 0;
        this.mfx = 0;
        this.mfy = 0;
        this.lMX = pbFragment;
        this.mfv = l.getDimens(pbFragment.getContext(), R.dimen.ds88);
        this.mfw = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds14);
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        this.mfx = ((int) (equipmentWidth * 0.07d)) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds102);
        if (this.mfx - dimens > 0) {
            this.mfx -= dimens;
        }
        this.mfy = (equipmentWidth - (this.mfx * 2)) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds89);
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                c.this.lMX.cCV();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.fLW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbFragment.jiV);
        this.mfo = this.mNavigationBar.setCenterTextTitle("");
        this.kFU = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.kFV = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        this.kFV.setPadding(dimens2, 0, dimens2, 0);
        ap.setNavbarIconSrc(this.kFU, R.drawable.icon_pb_play_small, R.drawable.icon_pb_play_small);
        this.kFU.setVisibility(8);
        this.mfo.setOnClickListener(pbFragment.jiV);
        this.kFU.setOnClickListener(pbFragment.jiV);
        this.gYc = (ImageView) this.fLW.findViewById(R.id.widget_navi_back_button);
        if (this.mfp == null) {
            this.mfp = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.nav_fourm_title_layout, (View.OnClickListener) null);
            this.mfq = (BarImageView) this.mfp.findViewById(R.id.pb_nav_title_forum_image);
            this.mfq.setShowOval(true);
            this.mfq.setShowOuterBorder(false);
            this.mfq.setShowInnerBorder(true);
            this.mfq.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.mfq.setStrokeColorResId(R.color.CAM_X0401);
            this.mfq.setOnClickListener(pbFragment.jiV);
            this.fkH = (TextView) this.mfp.findViewById(R.id.pb_nav_title_forum_name);
            this.fkH.setOnClickListener(pbFragment.jiV);
            if (this.mfp.getLayoutParams() != null && (this.mfp.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.mfx > 0 && this.mfy > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mfp.getLayoutParams();
                marginLayoutParams.leftMargin = this.mfx;
                marginLayoutParams.rightMargin = this.mfx;
                this.mfp.setLayoutParams(marginLayoutParams);
            }
            if (this.mfp.getVisibility() == 8) {
                this.mfp.setVisibility(0);
            }
            if (this.mfp.getAlpha() != 1.0f) {
                this.mfp.setAlpha(1.0f);
            }
        }
    }

    public void vY(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.maj = z;
        if (this.jwO == null && this.ahC == null) {
            this.jwO = this.mNavigationBar.addCustomView(controlAlign, R.layout.nb_item_floor_more, this.lMX.jiV);
            this.ahC = (ImageView) this.jwO.findViewById(R.id.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mfv, this.mfv);
            layoutParams.rightMargin = this.mfw;
            this.jwO.setLayoutParams(layoutParams);
            SvgManager.bsR().a(this.ahC, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.jwO.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void vC(boolean z) {
        if (this.jwO != null) {
            this.jwO.setVisibility(z ? 0 : 8);
        }
    }

    public NavigationBar dsi() {
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

    public void KF(String str) {
        if (!TextUtils.isEmpty(str) && !this.maj) {
            this.mfo.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            wb(true);
            k.bkT().setForumNameForWaterImage(str);
            return;
        }
        wb(false);
    }

    public void a(ad adVar) {
        if (!this.lMX.getBaseFragmentActivity().isProgressBarShown()) {
            this.mfs = new ac(this.lMX, this.lMX.jiV);
            this.mfr = new AlertDialog.Builder(this.lMX.getContext(), R.style.DialogTheme).create();
            this.mfr.setCanceledOnTouchOutside(true);
            this.mfr.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(false));
                }
            });
            g.showDialog(this.mfr, this.lMX.getFragmentActivity());
            Window window = this.mfr.getWindow();
            window.addFlags(512);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = l.getDimens(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.mfs.getView());
            window.setDimAmount(this.eVC);
            this.mfs.vq(adVar == null ? false : adVar.lWP);
            this.mfs.vr(adVar == null ? false : adVar.lWT);
            this.mfs.vs(adVar == null ? false : adVar.lWX);
            this.mfs.vu(adVar == null ? false : adVar.lWU);
            this.mfs.vv(adVar == null ? true : adVar.lWR);
            if (adVar == null) {
                this.mfs.aq(false, false);
                this.mfs.ar(false, false);
            } else {
                this.mfs.aq(adVar.lWV, adVar.lXb);
                this.mfs.ar(adVar.lWW, adVar.lXa);
            }
            boolean z = adVar == null ? false : adVar.FD;
            boolean z2 = adVar == null ? false : adVar.isHostOnly;
            boolean z3 = adVar == null ? false : adVar.lWS;
            boolean z4 = adVar == null ? false : adVar.lWQ;
            boolean z5 = adVar == null ? false : adVar.lWZ;
            boolean z6 = adVar == null ? false : adVar.lWY;
            this.mfs.ap(z3, z2);
            this.mfs.as(z4, z);
            this.mfs.at(z6, z5);
            if (adVar != null) {
                this.mfs.lWM = adVar.lXc;
                if (adVar.lXc) {
                    this.mfs.dpI().setText(R.string.report_text);
                    this.mfs.vu(false);
                }
            }
            this.mfs.vt(adVar == null ? false : adVar.lXd);
            if (!TbSingleton.getInstance().mCanCallFans && this.lMX.dmq() != null && this.lMX.dmq().getPbData() != null && this.lMX.dmq().getPbData().getThreadId() != null && this.lMX.dmq().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                this.mfs.dpL().setText(R.string.have_called_fans_short);
            }
            dsj();
            this.mfs.jJ(adVar != null ? adVar.eVr : false);
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(true));
        }
    }

    private void dsj() {
        if (this.mfs != null) {
            this.mfs.dpP();
        }
    }

    public void baM() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.mfr != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.valueOf(!g.dismissDialog(c.this.mfr, c.this.lMX.getPageContext().getPageActivity()))));
                    }
                }
            };
        }
        e.mA().postDelayed(this.runnable, 100L);
    }

    public void dsk() {
        if (this.mfr != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.valueOf(!g.dismissDialog(this.mfr, this.lMX.getPageContext().getPageActivity()))));
        }
    }

    public ac dsl() {
        return this.mfs;
    }

    public View dsm() {
        return this.kFU;
    }

    public boolean dsn() {
        return this.mfr != null && this.mfr.isShowing();
    }

    public void daX() {
        if (this.mfs != null) {
            this.mfs.release();
        }
        this.mfr = null;
        this.mfs = null;
        e.mA().removeCallbacks(this.runnable);
    }

    public void dso() {
        if (this.jwO != null) {
            this.jwO.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.lMX.getPageContext(), i);
            ap.setBackgroundResource(this.mNavigationBar.getBarBgView(), R.color.CAM_X0207);
        }
        if (this.mfq != null) {
            this.mfq.invalidate();
        }
        WebPManager.a(this.gYc, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.a(this.ahC, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
        ap.setNavbarTitleColor(this.mfo, R.color.CAM_X0105, R.color.s_navbar_title_color);
        ap.setViewTextColor(this.fkH, R.color.CAM_X0105);
        dsp();
        dsj();
    }

    private void dsp() {
        if (this.mfp != null) {
            if (!TextUtils.isEmpty(this.mForumName)) {
                com.baidu.tbadk.core.elementsMaven.c.br(this.mfp).og(R.string.J_X07).setBackGroundColor(R.color.CAM_X0209);
            } else {
                this.mfp.setBackgroundResource(0);
            }
        }
    }

    public void Gf(int i) {
        this.mNavigationBar.onChangeSkinType(this.lMX.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha85));
        this.mfo.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0111));
        WebPManager.a(this.ahC, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.a(this.gYc, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
    }

    public void dsq() {
        this.gYc.setVisibility(0);
        wb(false);
        if (this.jwO != null) {
            this.jwO.setVisibility(8);
        }
    }

    public void wa(boolean z) {
        this.gYc.setVisibility(0);
        wb(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.jwO != null) {
                this.jwO.setVisibility(0);
            }
        } else if (this.jwO != null) {
            this.jwO.setVisibility(8);
        }
    }

    public void wb(boolean z) {
        if (!this.maj && z && !"".equals(this.mfo.getText().toString())) {
            this.mfo.setVisibility(0);
        } else {
            this.mfo.setVisibility(8);
        }
    }

    public void wc(boolean z) {
        this.mft = z;
    }

    public void dqQ() {
        if ((!this.mft || TbadkCoreApplication.isLogin()) && !com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(SharedPrefConfig.SHOW_SHARE, false)) {
            View inflate = LayoutInflater.from(this.lMX.getContext()).inflate(R.layout.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.arrow_up);
            TextView textView = (TextView) inflate.findViewById(R.id.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.gravity = 5;
            if (!TbadkCoreApplication.isLogin()) {
                layoutParams.rightMargin = l.getDimens(this.lMX.getContext(), R.dimen.ds28);
            } else {
                layoutParams.rightMargin = l.getDimens(this.lMX.getContext(), R.dimen.ds128);
            }
            textView.setText(R.string.share_tip);
            textView.setOnClickListener(this.jMe);
            this.mfu = new PopupWindow(inflate, -2, -2);
        }
    }

    public void dsr() {
        if (this.jMd != null) {
            e.mA().removeCallbacks(this.jMd);
        }
        cLX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLX() {
        g.dismissPopupWindow(this.mfu);
    }

    public void dN(View view) {
    }

    public void fV(String str, String str2) {
        if (this.lMX != null && this.mfp != null) {
            if (StringUtils.isNull(str)) {
                this.mfq.setVisibility(8);
                this.fkH.setText("贴吧动态");
                this.mForumName = null;
            } else {
                this.mfq.setVisibility(0);
                this.mForumName = str;
                az.a(this.fkH, str, R.string.forum, R.dimen.tbds0, 1, this.mfy, false);
                k.bkT().setForumNameForWaterImage(str);
                this.mfq.startLoad(str2, 10, false);
            }
            dsp();
        }
    }
}
