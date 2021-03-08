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
    private ImageView aiV;
    public final View fNw;
    public TextView fmg;
    private ImageView gZZ;
    public View jyL;
    private final ImageView kIk;
    private final LinearLayout kIl;
    private PbFragment lPo;
    public String mForumName;
    public final NavigationBar mNavigationBar;
    public TextView mhF;
    public LinearLayout mhG;
    public BarImageView mhH;
    private PopupWindow mhL;
    private int mhM;
    private int mhN;
    private int mhO;
    private int mhP;
    private Runnable runnable;
    private boolean mcC = false;
    private AlertDialog mhI = null;
    private ac mhJ = null;
    private float eXb = 0.33f;
    private boolean mhK = false;
    private boolean mhQ = true;
    private Runnable jOa = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
        @Override // java.lang.Runnable
        public void run() {
            c.this.cMk();
        }
    };
    private View.OnClickListener jOb = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.dsH();
        }
    };

    public c(PbFragment pbFragment, View view) {
        this.mhM = 0;
        this.mhN = 0;
        this.mhO = 0;
        this.mhP = 0;
        this.lPo = pbFragment;
        this.mhM = l.getDimens(pbFragment.getContext(), R.dimen.ds88);
        this.mhN = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds14);
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        this.mhO = ((int) (equipmentWidth * 0.07d)) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds102);
        if (this.mhO - dimens > 0) {
            this.mhO -= dimens;
        }
        this.mhP = (equipmentWidth - (this.mhO * 2)) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds89);
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                c.this.lPo.cDi();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.fNw = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbFragment.jkS);
        this.mhF = this.mNavigationBar.setCenterTextTitle("");
        this.kIk = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.kIl = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        this.kIl.setPadding(dimens2, 0, dimens2, 0);
        ap.setNavbarIconSrc(this.kIk, R.drawable.icon_pb_play_small, R.drawable.icon_pb_play_small);
        this.kIk.setVisibility(8);
        this.mhF.setOnClickListener(pbFragment.jkS);
        this.kIk.setOnClickListener(pbFragment.jkS);
        this.gZZ = (ImageView) this.fNw.findViewById(R.id.widget_navi_back_button);
        if (this.mhG == null) {
            this.mhG = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.nav_fourm_title_layout, (View.OnClickListener) null);
            this.mhH = (BarImageView) this.mhG.findViewById(R.id.pb_nav_title_forum_image);
            this.mhH.setShowOval(true);
            this.mhH.setShowOuterBorder(false);
            this.mhH.setShowInnerBorder(true);
            this.mhH.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.mhH.setStrokeColorResId(R.color.CAM_X0401);
            this.mhH.setOnClickListener(pbFragment.jkS);
            this.fmg = (TextView) this.mhG.findViewById(R.id.pb_nav_title_forum_name);
            this.fmg.setOnClickListener(pbFragment.jkS);
            if (this.mhG.getLayoutParams() != null && (this.mhG.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.mhO > 0 && this.mhP > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mhG.getLayoutParams();
                marginLayoutParams.leftMargin = this.mhO;
                marginLayoutParams.rightMargin = this.mhO;
                this.mhG.setLayoutParams(marginLayoutParams);
            }
            if (this.mhG.getVisibility() == 8) {
                this.mhG.setVisibility(0);
            }
            if (this.mhG.getAlpha() != 1.0f) {
                this.mhG.setAlpha(1.0f);
            }
        }
    }

    public void vY(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.mcC = z;
        if (this.jyL == null && this.aiV == null) {
            this.jyL = this.mNavigationBar.addCustomView(controlAlign, R.layout.nb_item_floor_more, this.lPo.jkS);
            this.aiV = (ImageView) this.jyL.findViewById(R.id.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mhM, this.mhM);
            layoutParams.rightMargin = this.mhN;
            this.jyL.setLayoutParams(layoutParams);
            SvgManager.bsU().a(this.aiV, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.jyL.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void vC(boolean z) {
        if (this.jyL != null) {
            this.jyL.setVisibility(z ? 0 : 8);
        }
    }

    public NavigationBar dsy() {
        return this.mNavigationBar;
    }

    public void vZ(boolean z) {
        if (z) {
            this.fNw.setVisibility(0);
        } else {
            this.fNw.setVisibility(8);
        }
        wb(z);
    }

    public void KP(String str) {
        if (!TextUtils.isEmpty(str) && !this.mcC) {
            this.mhF.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            wb(true);
            k.bkV().setForumNameForWaterImage(str);
            return;
        }
        wb(false);
    }

    public void a(ad adVar) {
        if (!this.lPo.getBaseFragmentActivity().isProgressBarShown()) {
            this.mhJ = new ac(this.lPo, this.lPo.jkS);
            this.mhI = new AlertDialog.Builder(this.lPo.getContext(), R.style.DialogTheme).create();
            this.mhI.setCanceledOnTouchOutside(true);
            this.mhI.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(false));
                }
            });
            g.showDialog(this.mhI, this.lPo.getFragmentActivity());
            Window window = this.mhI.getWindow();
            window.addFlags(512);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = l.getDimens(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.mhJ.getView());
            window.setDimAmount(this.eXb);
            this.mhJ.vq(adVar == null ? false : adVar.lZg);
            this.mhJ.vr(adVar == null ? false : adVar.lZk);
            this.mhJ.vs(adVar == null ? false : adVar.lZo);
            this.mhJ.vu(adVar == null ? false : adVar.lZl);
            this.mhJ.vv(adVar == null ? true : adVar.lZi);
            if (adVar == null) {
                this.mhJ.aq(false, false);
                this.mhJ.ar(false, false);
            } else {
                this.mhJ.aq(adVar.lZm, adVar.lZs);
                this.mhJ.ar(adVar.lZn, adVar.lZr);
            }
            boolean z = adVar == null ? false : adVar.Ha;
            boolean z2 = adVar == null ? false : adVar.isHostOnly;
            boolean z3 = adVar == null ? false : adVar.lZj;
            boolean z4 = adVar == null ? false : adVar.lZh;
            boolean z5 = adVar == null ? false : adVar.lZq;
            boolean z6 = adVar == null ? false : adVar.lZp;
            this.mhJ.ap(z3, z2);
            this.mhJ.as(z4, z);
            this.mhJ.at(z6, z5);
            if (adVar != null) {
                this.mhJ.lZd = adVar.lZt;
                if (adVar.lZt) {
                    this.mhJ.dpY().setText(R.string.report_text);
                    this.mhJ.vu(false);
                }
            }
            this.mhJ.vt(adVar == null ? false : adVar.lZu);
            if (!TbSingleton.getInstance().mCanCallFans && this.lPo.dmG() != null && this.lPo.dmG().getPbData() != null && this.lPo.dmG().getPbData().getThreadId() != null && this.lPo.dmG().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                this.mhJ.dqb().setText(R.string.have_called_fans_short);
            }
            dsz();
            this.mhJ.jJ(adVar != null ? adVar.eWQ : false);
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(true));
        }
    }

    private void dsz() {
        if (this.mhJ != null) {
            this.mhJ.dqf();
        }
    }

    public void baP() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.mhI != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.valueOf(!g.dismissDialog(c.this.mhI, c.this.lPo.getPageContext().getPageActivity()))));
                    }
                }
            };
        }
        e.mA().postDelayed(this.runnable, 100L);
    }

    public void dsA() {
        if (this.mhI != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.valueOf(!g.dismissDialog(this.mhI, this.lPo.getPageContext().getPageActivity()))));
        }
    }

    public ac dsB() {
        return this.mhJ;
    }

    public View dsC() {
        return this.kIk;
    }

    public boolean dsD() {
        return this.mhI != null && this.mhI.isShowing();
    }

    public void dbn() {
        if (this.mhJ != null) {
            this.mhJ.release();
        }
        this.mhI = null;
        this.mhJ = null;
        e.mA().removeCallbacks(this.runnable);
    }

    public void dsE() {
        if (this.jyL != null) {
            this.jyL.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.lPo.getPageContext(), i);
            ap.setBackgroundResource(this.mNavigationBar.getBarBgView(), R.color.CAM_X0207);
        }
        if (this.mhH != null) {
            this.mhH.invalidate();
        }
        WebPManager.a(this.gZZ, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.a(this.aiV, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
        ap.setNavbarTitleColor(this.mhF, R.color.CAM_X0105, R.color.s_navbar_title_color);
        ap.setViewTextColor(this.fmg, R.color.CAM_X0105);
        dsF();
        dsz();
    }

    private void dsF() {
        if (this.mhG != null) {
            if (!TextUtils.isEmpty(this.mForumName)) {
                com.baidu.tbadk.core.elementsMaven.c.br(this.mhG).oh(R.string.J_X07).setBackGroundColor(R.color.CAM_X0209);
            } else {
                this.mhG.setBackgroundResource(0);
            }
        }
    }

    public void Gi(int i) {
        this.mNavigationBar.onChangeSkinType(this.lPo.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha85));
        this.mhF.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0111));
        WebPManager.a(this.aiV, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.a(this.gZZ, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
    }

    public void dsG() {
        this.gZZ.setVisibility(0);
        wb(false);
        if (this.jyL != null) {
            this.jyL.setVisibility(8);
        }
    }

    public void wa(boolean z) {
        this.gZZ.setVisibility(0);
        wb(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.jyL != null) {
                this.jyL.setVisibility(0);
            }
        } else if (this.jyL != null) {
            this.jyL.setVisibility(8);
        }
    }

    public void wb(boolean z) {
        if (!this.mcC && z && !"".equals(this.mhF.getText().toString())) {
            this.mhF.setVisibility(0);
        } else {
            this.mhF.setVisibility(8);
        }
    }

    public void wc(boolean z) {
        this.mhK = z;
    }

    public void drg() {
        if ((!this.mhK || TbadkCoreApplication.isLogin()) && !com.baidu.tbadk.core.sharedPref.b.brR().getBoolean(SharedPrefConfig.SHOW_SHARE, false)) {
            View inflate = LayoutInflater.from(this.lPo.getContext()).inflate(R.layout.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.arrow_up);
            TextView textView = (TextView) inflate.findViewById(R.id.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.gravity = 5;
            if (!TbadkCoreApplication.isLogin()) {
                layoutParams.rightMargin = l.getDimens(this.lPo.getContext(), R.dimen.ds28);
            } else {
                layoutParams.rightMargin = l.getDimens(this.lPo.getContext(), R.dimen.ds128);
            }
            textView.setText(R.string.share_tip);
            textView.setOnClickListener(this.jOb);
            this.mhL = new PopupWindow(inflate, -2, -2);
        }
    }

    public void dsH() {
        if (this.jOa != null) {
            e.mA().removeCallbacks(this.jOa);
        }
        cMk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMk() {
        g.dismissPopupWindow(this.mhL);
    }

    public void dN(View view) {
    }

    public void fV(String str, String str2) {
        if (this.lPo != null && this.mhG != null) {
            if (StringUtils.isNull(str)) {
                this.mhH.setVisibility(8);
                this.fmg.setText("贴吧动态");
                this.mForumName = null;
            } else {
                this.mhH.setVisibility(0);
                this.mForumName = str;
                az.a(this.fmg, str, R.string.forum, R.dimen.tbds0, 1, this.mhP, false);
                k.bkV().setForumNameForWaterImage(str);
                this.mhH.startLoad(str2, 10, false);
            }
            dsF();
        }
    }
}
