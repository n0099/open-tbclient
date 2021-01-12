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
    private ImageView ahO;
    public final View fJL;
    public TextView fio;
    private ImageView gVs;
    public View jri;
    private final ImageView kxO;
    private final LinearLayout kxP;
    private PbFragment lEi;
    public TextView lWj;
    public LinearLayout lWk;
    public BarImageView lWl;
    private PopupWindow lWp;
    private int lWq;
    private int lWr;
    private int lWs;
    private int lWt;
    public String mForumName;
    public final NavigationBar mNavigationBar;
    private Runnable runnable;
    private boolean lRm = false;
    private AlertDialog lWm = null;
    private ac lWn = null;
    private float eTm = 0.33f;
    private boolean lWo = false;
    private boolean lWu = true;
    private Runnable jGz = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.4
        @Override // java.lang.Runnable
        public void run() {
            c.this.cKJ();
        }
    };
    private View.OnClickListener jGA = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.dqd();
        }
    };

    public c(PbFragment pbFragment, View view) {
        this.lWq = 0;
        this.lWr = 0;
        this.lWs = 0;
        this.lWt = 0;
        this.lEi = pbFragment;
        this.lWq = l.getDimens(pbFragment.getContext(), R.dimen.ds88);
        this.lWr = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds14);
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        this.lWs = ((int) (equipmentWidth * 0.07d)) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds102);
        if (this.lWs - dimens > 0) {
            this.lWs -= dimens;
        }
        this.lWt = (equipmentWidth - (this.lWs * 2)) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds89);
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                c.this.lEi.cBJ();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.fJL = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbFragment.jdo);
        this.lWj = this.mNavigationBar.setCenterTextTitle("");
        this.kxO = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.kxP = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        this.kxP.setPadding(dimens2, 0, dimens2, 0);
        ao.setNavbarIconSrc(this.kxO, R.drawable.icon_pb_play_small, R.drawable.icon_pb_play_small);
        this.kxO.setVisibility(8);
        this.lWj.setOnClickListener(pbFragment.jdo);
        this.kxO.setOnClickListener(pbFragment.jdo);
        this.gVs = (ImageView) this.fJL.findViewById(R.id.widget_navi_back_button);
        if (this.lWk == null) {
            this.lWk = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.nav_fourm_title_layout, (View.OnClickListener) null);
            this.lWl = (BarImageView) this.lWk.findViewById(R.id.pb_nav_title_forum_image);
            this.lWl.setShowOval(true);
            this.lWl.setShowOuterBorder(false);
            this.lWl.setShowInnerBorder(true);
            this.lWl.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.lWl.setStrokeColorResId(R.color.CAM_X0401);
            this.lWl.setOnClickListener(pbFragment.jdo);
            this.fio = (TextView) this.lWk.findViewById(R.id.pb_nav_title_forum_name);
            this.fio.setOnClickListener(pbFragment.jdo);
            if (this.lWk.getLayoutParams() != null && (this.lWk.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.lWs > 0 && this.lWt > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.lWk.getLayoutParams();
                marginLayoutParams.leftMargin = this.lWs;
                marginLayoutParams.rightMargin = this.lWs;
                this.lWk.setLayoutParams(marginLayoutParams);
            }
            if (this.lWk.getVisibility() == 8) {
                this.lWk.setVisibility(0);
            }
            if (this.lWk.getAlpha() != 1.0f) {
                this.lWk.setAlpha(1.0f);
            }
        }
    }

    public void vI(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.lRm = z;
        if (this.jri == null && this.ahO == null) {
            this.jri = this.mNavigationBar.addCustomView(controlAlign, R.layout.nb_item_floor_more, this.lEi.jdo);
            this.ahO = (ImageView) this.jri.findViewById(R.id.navigationBarBtnMore);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.lWq, this.lWq);
            layoutParams.rightMargin = this.lWr;
            this.jri.setLayoutParams(layoutParams);
            SvgManager.bsx().a(this.ahO, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.jri.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void vn(boolean z) {
        if (this.jri != null) {
            this.jri.setVisibility(z ? 0 : 8);
        }
    }

    public NavigationBar dpU() {
        return this.mNavigationBar;
    }

    public void vJ(boolean z) {
        if (z) {
            this.fJL.setVisibility(0);
        } else {
            this.fJL.setVisibility(8);
        }
        vL(z);
    }

    public void JU(String str) {
        if (!TextUtils.isEmpty(str) && !this.lRm) {
            this.lWj.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            vL(true);
            k.bkB().setForumNameForWaterImage(str);
            return;
        }
        vL(false);
    }

    public void a(ad adVar) {
        if (!this.lEi.getBaseFragmentActivity().isProgressBarShown()) {
            this.lWn = new ac(this.lEi, this.lEi.jdo);
            this.lWm = new AlertDialog.Builder(this.lEi.getContext(), R.style.DialogTheme).create();
            this.lWm.setCanceledOnTouchOutside(true);
            this.lWm.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.view.c.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(false));
                }
            });
            g.showDialog(this.lWm, this.lEi.getFragmentActivity());
            Window window = this.lWm.getWindow();
            window.addFlags(512);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = l.getDimens(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.lWn.getView());
            window.setDimAmount(this.eTm);
            this.lWn.vb(adVar == null ? false : adVar.lNT);
            this.lWn.vc(adVar == null ? false : adVar.lNX);
            this.lWn.vd(adVar == null ? false : adVar.lOb);
            this.lWn.vf(adVar == null ? false : adVar.lNY);
            this.lWn.vg(adVar == null ? true : adVar.lNV);
            if (adVar == null) {
                this.lWn.aq(false, false);
                this.lWn.ar(false, false);
            } else {
                this.lWn.aq(adVar.lNZ, adVar.lOf);
                this.lWn.ar(adVar.lOa, adVar.lOe);
            }
            boolean z = adVar == null ? false : adVar.FD;
            boolean z2 = adVar == null ? false : adVar.isHostOnly;
            boolean z3 = adVar == null ? false : adVar.lNW;
            boolean z4 = adVar == null ? false : adVar.lNU;
            boolean z5 = adVar == null ? false : adVar.lOd;
            boolean z6 = adVar == null ? false : adVar.lOc;
            this.lWn.ap(z3, z2);
            this.lWn.as(z4, z);
            this.lWn.at(z6, z5);
            if (adVar != null) {
                this.lWn.lNQ = adVar.lOg;
                if (adVar.lOg) {
                    this.lWn.dnu().setText(R.string.report_text);
                    this.lWn.vf(false);
                }
            }
            this.lWn.ve(adVar != null ? adVar.lOh : false);
            if (!TbSingleton.getInstance().mCanCallFans && this.lEi.dkd() != null && this.lEi.dkd().getPbData() != null && this.lEi.dkd().getPbData().getThreadId() != null && this.lEi.dkd().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                this.lWn.dnx().setText(R.string.have_called_fans_short);
            }
            dpV();
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(true));
        }
    }

    private void dpV() {
        if (this.lWn != null) {
            this.lWn.dnB();
        }
    }

    public void baz() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.c.3
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.lWm != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.valueOf(!g.dismissDialog(c.this.lWm, c.this.lEi.getPageContext().getPageActivity()))));
                    }
                }
            };
        }
        e.mB().postDelayed(this.runnable, 100L);
    }

    public void dpW() {
        if (this.lWm != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.valueOf(!g.dismissDialog(this.lWm, this.lEi.getPageContext().getPageActivity()))));
        }
    }

    public ac dpX() {
        return this.lWn;
    }

    public View dpY() {
        return this.kxO;
    }

    public boolean dpZ() {
        return this.lWm != null && this.lWm.isShowing();
    }

    public void cYZ() {
        if (this.lWn != null) {
            this.lWn.release();
        }
        this.lWm = null;
        this.lWn = null;
        e.mB().removeCallbacks(this.runnable);
    }

    public void dqa() {
        if (this.jri != null) {
            this.jri.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.lEi.getPageContext(), i);
            ao.setBackgroundResource(this.mNavigationBar.getBarBgView(), R.color.CAM_X0207);
        }
        WebPManager.a(this.gVs, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.a(this.ahO, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
        ao.setNavbarTitleColor(this.lWj, R.color.CAM_X0105, R.color.s_navbar_title_color);
        ao.setViewTextColor(this.fio, R.color.CAM_X0105);
        dqb();
        dpV();
    }

    private void dqb() {
        if (this.lWk != null) {
            if (!TextUtils.isEmpty(this.mForumName)) {
                com.baidu.tbadk.core.elementsMaven.c.bv(this.lWk).od(R.string.J_X07).setBackGroundColor(R.color.CAM_X0209);
            } else {
                this.lWk.setBackgroundResource(0);
            }
        }
    }

    public void FM(int i) {
        this.mNavigationBar.onChangeSkinType(this.lEi.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha85));
        this.lWj.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0111));
        WebPManager.a(this.ahO, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.a(this.gVs, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
    }

    public void dqc() {
        this.gVs.setVisibility(0);
        vL(false);
        if (this.jri != null) {
            this.jri.setVisibility(8);
        }
    }

    public void vK(boolean z) {
        this.gVs.setVisibility(0);
        vL(z);
        if (TbadkCoreApplication.isLogin()) {
            if (this.jri != null) {
                this.jri.setVisibility(0);
            }
        } else if (this.jri != null) {
            this.jri.setVisibility(8);
        }
    }

    public void vL(boolean z) {
        if (!this.lRm && z && !"".equals(this.lWj.getText().toString())) {
            this.lWj.setVisibility(0);
        } else {
            this.lWj.setVisibility(8);
        }
    }

    public void vM(boolean z) {
        this.lWo = z;
    }

    public void doC() {
        if ((!this.lWo || TbadkCoreApplication.isLogin()) && !com.baidu.tbadk.core.sharedPref.b.brx().getBoolean(SharedPrefConfig.SHOW_SHARE, false)) {
            View inflate = LayoutInflater.from(this.lEi.getContext()).inflate(R.layout.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.arrow_up);
            TextView textView = (TextView) inflate.findViewById(R.id.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.gravity = 5;
            if (!TbadkCoreApplication.isLogin()) {
                layoutParams.rightMargin = l.getDimens(this.lEi.getContext(), R.dimen.ds28);
            } else {
                layoutParams.rightMargin = l.getDimens(this.lEi.getContext(), R.dimen.ds128);
            }
            textView.setText(R.string.share_tip);
            textView.setOnClickListener(this.jGA);
            this.lWp = new PopupWindow(inflate, -2, -2);
        }
    }

    public void dqd() {
        if (this.jGz != null) {
            e.mB().removeCallbacks(this.jGz);
        }
        cKJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKJ() {
        g.dismissPopupWindow(this.lWp);
    }

    public void dP(View view) {
    }

    public void fV(String str, String str2) {
        if (this.lEi != null && this.lWk != null) {
            if (StringUtils.isNull(str)) {
                this.lWl.setVisibility(8);
                this.fio.setText("贴吧动态");
                this.mForumName = null;
            } else {
                this.lWl.setVisibility(0);
                this.mForumName = str;
                ay.a(this.fio, str, R.string.forum, R.dimen.tbds0, 1, this.lWt, false);
                k.bkB().setForumNameForWaterImage(str);
                this.lWl.startLoad(str2, 10, false);
            }
            dqb();
        }
    }
}
