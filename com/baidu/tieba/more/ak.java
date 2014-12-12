package com.baidu.tieba.more;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public class ak extends com.baidu.adp.base.g<MsgRemindActivity> {
    private LinearLayout buW;
    private TextView buX;
    private BdSwitchView buY;
    private LinearLayout buZ;
    private TextView bvA;
    private LinearLayout bvB;
    private TextView bvC;
    private TextView bvD;
    private LinearLayout bvE;
    private TextView bvF;
    private BdSwitchView bvG;
    private LinearLayout bvH;
    private TextView bvI;
    private BdSwitchView bvJ;
    private LinearLayout bvK;
    private TextView bvL;
    private BdSwitchView bvM;
    private LinearLayout bvN;
    private TextView bvO;
    private BdSwitchView bvP;
    private LinearLayout bvQ;
    private TextView bvR;
    private BdSwitchView bvS;
    public boolean bvT;
    private LinearLayout bvU;
    private LinearLayout bvV;
    private LinearLayout bvW;
    private LinearLayout bvX;
    private LinearLayout bvY;
    private LinearLayout bvZ;
    private TextView bva;
    private TextView bvb;
    private LinearLayout bvc;
    private TextView bvd;
    private BdSwitchView bve;
    private LinearLayout bvf;
    private CheckBox bvg;
    private CheckBox bvh;
    private CheckBox bvi;
    private CheckBox bvj;
    private CheckBox bvk;
    private CheckBox bvl;
    private CheckBox bvm;
    private LinearLayout bvn;
    private TextView bvo;
    private BdSwitchView bvp;
    private LinearLayout bvq;
    private TextView bvr;
    private TextView bvs;
    private LinearLayout bvt;
    private TextView bvu;
    private BdSwitchView bvv;
    private LinearLayout bvw;
    private LinearLayout bvx;
    private LinearLayout bvy;
    private TextView bvz;
    private LinearLayout bwa;
    private LinearLayout bwb;
    private LinearLayout bwc;
    private LinearLayout bwd;
    private LinearLayout bwe;
    private LinearLayout bwf;
    private LinearLayout bwg;
    private LinearLayout bwh;
    private LinearLayout bwi;
    private LinearLayout bwj;
    private LinearLayout bwk;
    private al bwl;
    private BaseActivity mActivity;
    private View mBack;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;
    private TextView mTitleText;

    public ak(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.bvg = null;
        this.bvh = null;
        this.bvi = null;
        this.bvj = null;
        this.bvk = null;
        this.bvl = null;
        this.bvm = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.mTitleText = null;
        this.bvT = true;
        this.bvU = null;
        this.bvV = null;
        this.bvW = null;
        this.bvX = null;
        this.bvY = null;
        this.bvZ = null;
        this.bwa = null;
        this.bwb = null;
        this.bwc = null;
        this.bwd = null;
        this.bwe = null;
        this.bwf = null;
        this.bwg = null;
        this.bwh = null;
        this.bwi = null;
        this.bwj = null;
        this.bwk = null;
        this.mActivity = msgRemindActivity;
        msgRemindActivity.setContentView(com.baidu.tieba.x.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        a(msgRemindActivity);
        Vq();
        Vv();
        Vr();
        Vs();
        Vt();
        Vu();
        d(msgRemindActivity);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.buW.setVisibility(8);
            this.buZ.setVisibility(8);
            this.bvc.setVisibility(8);
            this.bvf.setVisibility(8);
            this.bvn.setVisibility(8);
            this.bvq.setVisibility(8);
            this.bvE.setVisibility(8);
            this.bvH.setVisibility(8);
            this.bvK.setVisibility(8);
            this.bvN.setVisibility(8);
            this.bvQ.setVisibility(8);
            this.bvU.setVisibility(8);
            this.bvV.setVisibility(8);
            this.bvW.setVisibility(8);
            this.bvX.setVisibility(8);
            this.bvY.setVisibility(8);
            this.bvZ.setVisibility(8);
            this.bwa.setVisibility(8);
            this.bwb.setVisibility(8);
            this.bwc.setVisibility(8);
            this.bwd.setVisibility(8);
            this.bwe.setVisibility(8);
            this.bwf.setVisibility(8);
            this.bwg.setVisibility(8);
            this.bwh.setVisibility(8);
            this.bwi.setVisibility(8);
            this.bwj.setVisibility(8);
        }
        boolean isMIUIRom = TbadkCoreApplication.m255getInst().isMIUIRom();
        if (TbadkCoreApplication.m255getInst().isFloatingWindowOpened() && !isMIUIRom) {
            this.bvQ.setVisibility(0);
            this.bwk.setVisibility(0);
            return;
        }
        this.bvQ.setVisibility(8);
        this.bwk.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.mActivity.getLayoutMode().ab(i == 1);
        this.mActivity.getLayoutMode().h(this.mParent);
        ax.j(this.mParent, com.baidu.tieba.t.bg_page_setting);
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        boolean z = i == 1;
        int bU = z ? ax.bU(i) : this.mActivity.getPageContext().getContext().getResources().getColor(com.baidu.tieba.t.more_color);
        int i2 = z ? -11446171 : -5065030;
        BdSwitchView.SwitchStyle switchStyle = z ? BdSwitchView.SwitchStyle.NIGHT : BdSwitchView.SwitchStyle.DAY;
        ax.i(this.buW, com.baidu.tieba.v.more_all);
        ax.i(this.buZ, com.baidu.tieba.v.more_all);
        this.buY.setSwitchStyle(switchStyle);
        ax.i(this.bvy, com.baidu.tieba.v.more_all);
        ax.i(this.bvB, com.baidu.tieba.v.more_all);
        ax.i(this.bvc, com.baidu.tieba.v.more_all);
        ax.i((View) this.bvg, com.baidu.tieba.v.more_all);
        ax.i((View) this.bvh, com.baidu.tieba.v.more_all);
        ax.i((View) this.bvi, com.baidu.tieba.v.more_all);
        ax.i((View) this.bvj, com.baidu.tieba.v.more_all);
        ax.i((View) this.bvk, com.baidu.tieba.v.more_all);
        ax.i((View) this.bvm, com.baidu.tieba.v.more_all);
        ax.i((View) this.bvl, com.baidu.tieba.v.more_all);
        this.bve.setSwitchStyle(switchStyle);
        ax.i(this.bvn, com.baidu.tieba.v.more_all);
        ax.i(this.bvq, com.baidu.tieba.v.more_all);
        this.bvp.setSwitchStyle(switchStyle);
        ax.c((ImageView) this.buZ.findViewById(com.baidu.tieba.w.no_disturb_mode_time_arrow), com.baidu.tieba.v.icon_arrow_right);
        ax.c((ImageView) this.bvq.findViewById(com.baidu.tieba.w.sign_remind_arrow), com.baidu.tieba.v.icon_arrow_right);
        ax.c((ImageView) this.bvy.findViewById(com.baidu.tieba.w.no_disturb_start_time_arrow), com.baidu.tieba.v.icon_arrow_right);
        ax.c((ImageView) this.bvB.findViewById(com.baidu.tieba.w.no_disturb_end_time_arrow), com.baidu.tieba.v.icon_arrow_right);
        ax.i(this.bvt, com.baidu.tieba.v.more_all);
        this.bvv.setSwitchStyle(switchStyle);
        ax.i(this.bvE, com.baidu.tieba.v.more_all);
        this.bvG.setSwitchStyle(switchStyle);
        ax.i(this.bvH, com.baidu.tieba.v.more_all);
        this.bvJ.setSwitchStyle(switchStyle);
        ax.i(this.bvK, com.baidu.tieba.v.more_all);
        this.bvM.setSwitchStyle(switchStyle);
        ax.i(this.bvN, com.baidu.tieba.v.more_all);
        ax.i(this.bvQ, com.baidu.tieba.v.more_all);
        this.bvP.setSwitchStyle(switchStyle);
        this.bvS.setSwitchStyle(switchStyle);
        this.buX.setTextColor(bU);
        this.bva.setTextColor(bU);
        this.bvb.setTextColor(i2);
        this.bvz.setTextColor(bU);
        this.bvA.setTextColor(i2);
        this.bvC.setTextColor(bU);
        this.bvD.setTextColor(i2);
        this.bvd.setTextColor(bU);
        this.bvg.setTextColor(bU);
        this.bvh.setTextColor(bU);
        this.bvi.setTextColor(bU);
        this.bvm.setTextColor(bU);
        this.bvj.setTextColor(bU);
        this.bvk.setTextColor(bU);
        this.bvl.setTextColor(bU);
        this.bvo.setTextColor(bU);
        this.bvr.setTextColor(bU);
        this.bvs.setTextColor(i2);
        this.bvu.setTextColor(bU);
        this.bvF.setTextColor(bU);
        this.bvI.setTextColor(bU);
        this.bvL.setTextColor(bU);
        this.bvO.setTextColor(bU);
        this.bvR.setTextColor(bU);
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.mParent = (RelativeLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.parent);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitleText = this.mNavigationBar.setTitleText(msgRemindActivity.getPageContext().getString(com.baidu.tieba.z.msg_remind));
        this.buW = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.no_disturb_mode_container);
        this.buW.setClickable(false);
        this.buX = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.no_disturb_mode_text);
        this.buY = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.w.no_disturb_mode_switch);
        this.buZ = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.no_disturb_mode_time_container);
        this.bva = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.no_disturb_mode_time_text);
        this.bvb = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.no_disturb_mode_time_value);
        this.bvc = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.message_remind_container);
        this.bvc.setClickable(false);
        this.bvd = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.message_remind_text);
        this.bve = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.w.message_remind_switch);
        this.bvf = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.message_remind_value);
        this.bvg = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.w.check_replyme);
        this.bvh = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.w.check_zan);
        this.bvi = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.w.check_atme);
        this.bvm = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.w.check_new_fans);
        this.bvn = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.sign_remind_on);
        this.bvn.setClickable(false);
        this.bvo = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.sign_remind_on_text);
        this.bvp = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.w.sign_remind_on_switch);
        this.bvq = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.sign_remind);
        this.bvr = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.sign_remind_text);
        this.bvs = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.sign_remind_time);
        this.bvt = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.promoted_message);
        this.bvt.setClickable(false);
        this.bvu = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.promoted_message_text);
        this.bvv = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.w.promoted_message_switch);
        this.bvj = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.w.check_chatmessage);
        this.bvk = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.w.check_strangermessage);
        this.bvl = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.w.check_groupmessage);
        this.bvw = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.front_container);
        this.bvx = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.back_container);
        this.bvy = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.no_disturb_start_time);
        this.bvz = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.no_disturb_start_time_text);
        this.bvA = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.no_disturb_start_time_value);
        this.bvB = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.no_disturb_end_time);
        this.bvC = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.no_disturb_end_time_text);
        this.bvD = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.no_disturb_end_time_value);
        this.bvE = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.remind_tone);
        this.bvE.setClickable(false);
        this.bvF = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.tone_text);
        this.bvG = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.w.remind_tone_switch);
        this.bvH = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.remind_vibrate);
        this.bvH.setClickable(false);
        this.bvI = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.vibrate_text);
        this.bvJ = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.w.remind_vibrate_switch);
        this.bvK = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.remid_light);
        this.bvK.setClickable(false);
        this.bvL = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.light_text);
        this.bvM = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.w.remind_light_switch);
        this.bvN = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.remind_screen_lock);
        this.bvO = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.screen_lock_text);
        this.bvP = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.w.remind_screen_lock_switch);
        this.bvN.setClickable(false);
        this.bvQ = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.chat_float_windoiw_group);
        this.bvQ.setClickable(false);
        this.bvR = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.chat_float_window_text);
        this.bvS = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.w.chat_float_window_switch);
    }

    private void a(BaseActivity baseActivity) {
        this.bvU = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line1_layout);
        this.bvV = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line2_layout);
        this.bvW = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line3_layout);
        this.bvX = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line4_layout);
        this.bvY = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line5_layout);
        this.bvZ = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line6_layout);
        this.bwa = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line7_layout);
        this.bwb = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line8_layout);
        this.bwc = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line9_layout);
        this.bwd = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line10_layout);
        this.bwe = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line11_layout);
        this.bwf = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line12_layout);
        this.bwg = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line13_layout);
        this.bwh = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line14_layout);
        this.bwi = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line15_layout);
        this.bwj = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line16_layout);
        this.bwk = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line24_layout);
    }

    public View Bj() {
        return this.mBack;
    }

    public void dv(boolean z) {
        if (z) {
            this.bvV.setVisibility(0);
        } else {
            this.bvV.setVisibility(8);
        }
    }

    public void dw(boolean z) {
        if (z) {
            this.bwb.setPadding(this.mActivity.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds30), 0, this.mActivity.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds30), 0);
        } else {
            this.bwb.setPadding(0, 0, 0, 0);
        }
    }

    public void dx(boolean z) {
        if (z) {
            this.bwi.setVisibility(0);
        } else {
            this.bwi.setVisibility(8);
        }
    }

    private void Vq() {
        if (TbadkCoreApplication.m255getInst().isNoDisturbOn()) {
            this.buY.iK();
            this.buZ.setVisibility(0);
            Vx();
            this.bvV.setVisibility(0);
            return;
        }
        this.buY.iL();
        this.buZ.setVisibility(8);
        this.bvV.setVisibility(8);
    }

    private void Vr() {
        if (TbadkCoreApplication.m255getInst().isMsgRemindOn()) {
            this.bwb.setPadding(this.mActivity.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds30), 0, this.mActivity.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds30), 0);
        } else {
            this.bwb.setPadding(0, 0, 0, 0);
        }
        if (TbadkCoreApplication.m255getInst().isMsgReplymeOn()) {
            this.bvg.setChecked(true);
        }
        if (TbadkCoreApplication.m255getInst().isMsgZanOn()) {
            this.bvh.setChecked(true);
        }
        if (TbadkCoreApplication.m255getInst().isMsgAtmeOn()) {
            this.bvi.setChecked(true);
        }
        this.bvm.setChecked(TbadkCoreApplication.m255getInst().isMsgNewFansOn());
        if (TbadkCoreApplication.m255getInst().isMsgChatOn()) {
            this.bvj.setChecked(true);
        }
        if (TbadkCoreApplication.m255getInst().isGroupMsgOn()) {
            this.bvl.setChecked(true);
        }
        if (TbadkCoreApplication.m255getInst().isStrangerChatOn()) {
            this.bvk.setChecked(true);
        }
    }

    private void Vs() {
        if (TbadkCoreApplication.m255getInst().isPromotedMessageOn()) {
            this.bvv.iK();
        } else {
            this.bvv.iL();
        }
    }

    private void Vt() {
        if (TbadkCoreApplication.m255getInst().isSignAlertOn()) {
            this.bvp.iK();
            this.bvq.setVisibility(0);
            Vw();
            this.bwi.setVisibility(0);
            return;
        }
        this.bvp.iL();
        this.bvq.setVisibility(8);
        this.bwi.setVisibility(8);
    }

    private void Vu() {
        if (TbadkCoreApplication.m255getInst().isMsgToneOn()) {
            this.bvG.iK();
        } else {
            this.bvG.iL();
        }
        if (TbadkCoreApplication.m255getInst().isMsgVibrateOn()) {
            this.bvJ.iK();
        } else {
            this.bvJ.iL();
        }
        if (TbadkCoreApplication.m255getInst().isMsgLightOn()) {
            this.bvM.iK();
        } else {
            this.bvM.iL();
        }
        if (TbadkCoreApplication.m255getInst().getScreenLock()) {
            this.bvP.iK();
        } else {
            this.bvP.iL();
        }
        if (TbadkCoreApplication.m255getInst().getChatFloatWindowLocked()) {
            this.bvS.iK();
        } else {
            this.bvS.iL();
        }
    }

    private void Vv() {
        if (TbadkCoreApplication.m255getInst().isMsgRemindOn()) {
            this.bve.iK();
            this.bvf.setVisibility(0);
            return;
        }
        this.bve.iL();
        this.bvf.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.bve.setOnSwitchStateChangeListener(msgRemindActivity);
        this.bvp.setOnSwitchStateChangeListener(msgRemindActivity);
        this.bvv.setOnSwitchStateChangeListener(msgRemindActivity);
        this.buY.setOnSwitchStateChangeListener(msgRemindActivity);
        this.bvg.setOnCheckedChangeListener(msgRemindActivity);
        this.bvh.setOnCheckedChangeListener(msgRemindActivity);
        this.bvi.setOnCheckedChangeListener(msgRemindActivity);
        this.bvm.setOnCheckedChangeListener(msgRemindActivity);
        this.bvj.setOnCheckedChangeListener(msgRemindActivity);
        this.bvk.setOnCheckedChangeListener(msgRemindActivity);
        this.bvl.setOnCheckedChangeListener(msgRemindActivity);
        this.bvq.setOnClickListener(msgRemindActivity);
        this.buZ.setOnClickListener(msgRemindActivity);
        this.bvy.setOnClickListener(msgRemindActivity);
        this.bvB.setOnClickListener(msgRemindActivity);
        this.bvG.setOnSwitchStateChangeListener(msgRemindActivity);
        this.bvJ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.bvM.setOnSwitchStateChangeListener(msgRemindActivity);
        this.bvP.setOnSwitchStateChangeListener(msgRemindActivity);
        this.bvS.setOnSwitchStateChangeListener(msgRemindActivity);
    }

    public void dy(boolean z) {
        TbadkCoreApplication.m255getInst().getSkinType();
        if (z) {
            this.buZ.setVisibility(0);
            Vx();
            ax.i(this.buW, com.baidu.tieba.v.more_all);
            ax.i(this.buZ, com.baidu.tieba.v.more_all);
            return;
        }
        this.buZ.setVisibility(8);
        ax.i(this.buW, com.baidu.tieba.v.more_all);
    }

    public void dz(boolean z) {
        TbadkCoreApplication.m255getInst().getSkinType();
        if (z) {
            this.bvq.setVisibility(0);
            ax.i(this.bvn, com.baidu.tieba.v.more_all);
            ax.i(this.bvq, com.baidu.tieba.v.more_all);
            return;
        }
        this.bvq.setVisibility(8);
        ax.i(this.bvn, com.baidu.tieba.v.more_all);
    }

    public void dA(boolean z) {
        if (this.bwl == null) {
            this.bwl = new al(this.bvf, 500);
        }
        TbadkCoreApplication.m255getInst().getSkinType();
        if (z) {
            this.bwl.show();
            ax.i(this.bvc, com.baidu.tieba.v.more_all);
            ax.i((View) this.bvg, com.baidu.tieba.v.more_all);
            ax.i((View) this.bvi, com.baidu.tieba.v.more_all);
            ax.i((View) this.bvm, com.baidu.tieba.v.more_all);
            ax.i((View) this.bvj, com.baidu.tieba.v.more_all);
            ax.i((View) this.bvk, com.baidu.tieba.v.more_all);
            ax.i((View) this.bvl, com.baidu.tieba.v.more_all);
            return;
        }
        this.bwl.hide();
        ax.i(this.bvc, com.baidu.tieba.v.more_all);
    }

    public void Vw() {
        String str;
        String str2;
        TbadkCoreApplication m255getInst = TbadkCoreApplication.m255getInst();
        if (m255getInst.isSignAlertOn()) {
            if (m255getInst.getSignAlertHours() > 9) {
                str = String.valueOf(m255getInst.getSignAlertHours());
            } else {
                str = "0" + m255getInst.getSignAlertHours();
            }
            if (m255getInst.getSignAlertMins() > 9) {
                str2 = String.valueOf(m255getInst.getSignAlertMins());
            } else {
                str2 = "0" + m255getInst.getSignAlertMins();
            }
            this.bvs.setText(this.mActivity.getPageContext().getContext().getString(com.baidu.tieba.z.sign_remind_time, str, str2));
            this.bvq.setVisibility(0);
            if (!this.bvp.iM()) {
                this.bvp.iK();
                return;
            }
            return;
        }
        this.bvs.setText(com.baidu.tieba.z.close);
        this.bvq.setVisibility(8);
        if (this.bvp.iM()) {
            this.bvp.iL();
        }
    }

    public void Vx() {
        this.bvb.setText(String.valueOf(TbadkCoreApplication.m255getInst().getNoDisturbStartTime()) + "-" + TbadkCoreApplication.m255getInst().getNoDisturbEndTime());
        this.bvA.setText(TbadkCoreApplication.m255getInst().getNoDisturbStartTime());
        this.bvD.setText(TbadkCoreApplication.m255getInst().getNoDisturbEndTime());
    }

    public View Vy() {
        return this.bvv;
    }

    public View Vz() {
        return this.bvp;
    }

    public View VA() {
        return this.bve;
    }

    public View VB() {
        return this.bvq;
    }

    public View VC() {
        return this.buY;
    }

    public View VD() {
        return this.buZ;
    }

    public LinearLayout VE() {
        return this.bvy;
    }

    public LinearLayout VF() {
        return this.bvB;
    }

    public BdSwitchView VG() {
        return this.bvG;
    }

    public BdSwitchView VH() {
        return this.bvJ;
    }

    public BdSwitchView VI() {
        return this.bvM;
    }

    public BdSwitchView VJ() {
        return this.bvP;
    }

    public BdSwitchView VK() {
        return this.bvS;
    }

    public void dB(boolean z) {
        if (this.bvT != z) {
            this.bvT = z;
            if (z) {
                this.mTitleText.setText(com.baidu.tieba.z.msg_remind);
                this.bvw.setVisibility(0);
                this.bvx.setVisibility(8);
                return;
            }
            this.mTitleText.setText(com.baidu.tieba.z.no_disturb_mode_time);
            this.bvx.setVisibility(0);
            this.bvw.setVisibility(8);
        }
    }
}
