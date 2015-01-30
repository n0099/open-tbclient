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
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public class aw extends com.baidu.adp.base.g<MsgRemindActivity> {
    private LinearLayout bwG;
    private TextView bwH;
    private BdSwitchView bwI;
    private LinearLayout bwJ;
    private TextView bwK;
    private TextView bwL;
    private LinearLayout bwM;
    private TextView bwN;
    private BdSwitchView bwO;
    private LinearLayout bwP;
    private CheckBox bwQ;
    private CheckBox bwR;
    private CheckBox bwS;
    private CheckBox bwT;
    private CheckBox bwU;
    private CheckBox bwV;
    private CheckBox bwW;
    private LinearLayout bwX;
    private TextView bwY;
    private BdSwitchView bwZ;
    private LinearLayout bxA;
    private TextView bxB;
    private BdSwitchView bxC;
    public boolean bxD;
    private MsgRemindActivity bxE;
    private LinearLayout bxF;
    private LinearLayout bxG;
    private LinearLayout bxH;
    private LinearLayout bxI;
    private LinearLayout bxJ;
    private LinearLayout bxK;
    private LinearLayout bxL;
    private LinearLayout bxM;
    private LinearLayout bxN;
    private LinearLayout bxO;
    private LinearLayout bxP;
    private LinearLayout bxQ;
    private LinearLayout bxR;
    private LinearLayout bxS;
    private LinearLayout bxT;
    private LinearLayout bxU;
    private LinearLayout bxV;
    private ax bxW;
    private LinearLayout bxa;
    private TextView bxb;
    private TextView bxc;
    private LinearLayout bxd;
    private TextView bxe;
    private BdSwitchView bxf;
    private LinearLayout bxg;
    private LinearLayout bxh;
    private LinearLayout bxi;
    private TextView bxj;
    private TextView bxk;
    private LinearLayout bxl;
    private TextView bxm;
    private TextView bxn;
    private LinearLayout bxo;
    private TextView bxp;
    private BdSwitchView bxq;
    private LinearLayout bxr;
    private TextView bxs;
    private BdSwitchView bxt;
    private LinearLayout bxu;
    private TextView bxv;
    private BdSwitchView bxw;
    private LinearLayout bxx;
    private TextView bxy;
    private BdSwitchView bxz;
    private View mBack;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;
    private TextView mTitleText;

    public aw(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.bwQ = null;
        this.bwR = null;
        this.bwS = null;
        this.bwT = null;
        this.bwU = null;
        this.bwV = null;
        this.bwW = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.mTitleText = null;
        this.bxD = true;
        this.bxF = null;
        this.bxG = null;
        this.bxH = null;
        this.bxI = null;
        this.bxJ = null;
        this.bxK = null;
        this.bxL = null;
        this.bxM = null;
        this.bxN = null;
        this.bxO = null;
        this.bxP = null;
        this.bxQ = null;
        this.bxR = null;
        this.bxS = null;
        this.bxT = null;
        this.bxU = null;
        this.bxV = null;
        this.bxE = msgRemindActivity;
        msgRemindActivity.setContentView(com.baidu.tieba.x.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        a(msgRemindActivity);
        VQ();
        VV();
        VR();
        VS();
        VT();
        VU();
        d(msgRemindActivity);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.bwG.setVisibility(8);
            this.bwJ.setVisibility(8);
            this.bwM.setVisibility(8);
            this.bwP.setVisibility(8);
            this.bwX.setVisibility(8);
            this.bxa.setVisibility(8);
            this.bxo.setVisibility(8);
            this.bxr.setVisibility(8);
            this.bxu.setVisibility(8);
            this.bxx.setVisibility(8);
            this.bxA.setVisibility(8);
            this.bxF.setVisibility(8);
            this.bxG.setVisibility(8);
            this.bxH.setVisibility(8);
            this.bxI.setVisibility(8);
            this.bxJ.setVisibility(8);
            this.bxK.setVisibility(8);
            this.bxL.setVisibility(8);
            this.bxM.setVisibility(8);
            this.bxN.setVisibility(8);
            this.bxO.setVisibility(8);
            this.bxP.setVisibility(8);
            this.bxQ.setVisibility(8);
            this.bxR.setVisibility(8);
            this.bxS.setVisibility(8);
            this.bxT.setVisibility(8);
            this.bxU.setVisibility(8);
        }
        boolean isMIUIRom = TbadkCoreApplication.m255getInst().isMIUIRom();
        if (TbadkCoreApplication.m255getInst().isFloatingWindowOpened() && !isMIUIRom) {
            this.bxA.setVisibility(0);
            this.bxV.setVisibility(0);
            return;
        }
        this.bxA.setVisibility(8);
        this.bxV.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.bxE.getLayoutMode().ab(i == 1);
        this.bxE.getLayoutMode().h(this.mParent);
        com.baidu.tbadk.core.util.bc.j(this.mParent, com.baidu.tieba.t.bg_page_setting);
        this.mNavigationBar.onChangeSkinType(this.bxE.getPageContext(), i);
        boolean z = i == 1;
        int cb = z ? com.baidu.tbadk.core.util.bc.cb(i) : this.bxE.getPageContext().getContext().getResources().getColor(com.baidu.tieba.t.more_color);
        int i2 = z ? -11446171 : -5065030;
        BdSwitchView.SwitchStyle switchStyle = z ? BdSwitchView.SwitchStyle.NIGHT : BdSwitchView.SwitchStyle.DAY;
        com.baidu.tbadk.core.util.bc.i(this.bwG, com.baidu.tieba.v.more_all);
        com.baidu.tbadk.core.util.bc.i(this.bwJ, com.baidu.tieba.v.more_all);
        this.bwI.setSwitchStyle(switchStyle);
        com.baidu.tbadk.core.util.bc.i(this.bxi, com.baidu.tieba.v.more_all);
        com.baidu.tbadk.core.util.bc.i(this.bxl, com.baidu.tieba.v.more_all);
        com.baidu.tbadk.core.util.bc.i(this.bwM, com.baidu.tieba.v.more_all);
        com.baidu.tbadk.core.util.bc.i((View) this.bwQ, com.baidu.tieba.v.more_all);
        com.baidu.tbadk.core.util.bc.i((View) this.bwR, com.baidu.tieba.v.more_all);
        com.baidu.tbadk.core.util.bc.i((View) this.bwS, com.baidu.tieba.v.more_all);
        com.baidu.tbadk.core.util.bc.i((View) this.bwT, com.baidu.tieba.v.more_all);
        com.baidu.tbadk.core.util.bc.i((View) this.bwU, com.baidu.tieba.v.more_all);
        com.baidu.tbadk.core.util.bc.i((View) this.bwW, com.baidu.tieba.v.more_all);
        com.baidu.tbadk.core.util.bc.i((View) this.bwV, com.baidu.tieba.v.more_all);
        this.bwO.setSwitchStyle(switchStyle);
        com.baidu.tbadk.core.util.bc.i(this.bwX, com.baidu.tieba.v.more_all);
        com.baidu.tbadk.core.util.bc.i(this.bxa, com.baidu.tieba.v.more_all);
        this.bwZ.setSwitchStyle(switchStyle);
        com.baidu.tbadk.core.util.bc.c((ImageView) this.bwJ.findViewById(com.baidu.tieba.w.no_disturb_mode_time_arrow), com.baidu.tieba.v.icon_arrow_right);
        com.baidu.tbadk.core.util.bc.c((ImageView) this.bxa.findViewById(com.baidu.tieba.w.sign_remind_arrow), com.baidu.tieba.v.icon_arrow_right);
        com.baidu.tbadk.core.util.bc.c((ImageView) this.bxi.findViewById(com.baidu.tieba.w.no_disturb_start_time_arrow), com.baidu.tieba.v.icon_arrow_right);
        com.baidu.tbadk.core.util.bc.c((ImageView) this.bxl.findViewById(com.baidu.tieba.w.no_disturb_end_time_arrow), com.baidu.tieba.v.icon_arrow_right);
        com.baidu.tbadk.core.util.bc.i(this.bxd, com.baidu.tieba.v.more_all);
        this.bxf.setSwitchStyle(switchStyle);
        com.baidu.tbadk.core.util.bc.i(this.bxo, com.baidu.tieba.v.more_all);
        this.bxq.setSwitchStyle(switchStyle);
        com.baidu.tbadk.core.util.bc.i(this.bxr, com.baidu.tieba.v.more_all);
        this.bxt.setSwitchStyle(switchStyle);
        com.baidu.tbadk.core.util.bc.i(this.bxu, com.baidu.tieba.v.more_all);
        this.bxw.setSwitchStyle(switchStyle);
        com.baidu.tbadk.core.util.bc.i(this.bxx, com.baidu.tieba.v.more_all);
        com.baidu.tbadk.core.util.bc.i(this.bxA, com.baidu.tieba.v.more_all);
        this.bxz.setSwitchStyle(switchStyle);
        this.bxC.setSwitchStyle(switchStyle);
        this.bwH.setTextColor(cb);
        this.bwK.setTextColor(cb);
        this.bwL.setTextColor(i2);
        this.bxj.setTextColor(cb);
        this.bxk.setTextColor(i2);
        this.bxm.setTextColor(cb);
        this.bxn.setTextColor(i2);
        this.bwN.setTextColor(cb);
        this.bwQ.setTextColor(cb);
        this.bwR.setTextColor(cb);
        this.bwS.setTextColor(cb);
        this.bwW.setTextColor(cb);
        this.bwT.setTextColor(cb);
        this.bwU.setTextColor(cb);
        this.bwV.setTextColor(cb);
        this.bwY.setTextColor(cb);
        this.bxb.setTextColor(cb);
        this.bxc.setTextColor(i2);
        this.bxe.setTextColor(cb);
        this.bxp.setTextColor(cb);
        this.bxs.setTextColor(cb);
        this.bxv.setTextColor(cb);
        this.bxy.setTextColor(cb);
        this.bxB.setTextColor(cb);
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.mParent = (RelativeLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.parent);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitleText = this.mNavigationBar.setTitleText(msgRemindActivity.getPageContext().getString(com.baidu.tieba.z.msg_remind));
        this.bwG = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.no_disturb_mode_container);
        this.bwG.setClickable(false);
        this.bwH = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.no_disturb_mode_text);
        this.bwI = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.w.no_disturb_mode_switch);
        this.bwJ = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.no_disturb_mode_time_container);
        this.bwK = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.no_disturb_mode_time_text);
        this.bwL = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.no_disturb_mode_time_value);
        this.bwM = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.message_remind_container);
        this.bwM.setClickable(false);
        this.bwN = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.message_remind_text);
        this.bwO = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.w.message_remind_switch);
        this.bwP = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.message_remind_value);
        this.bwQ = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.w.check_replyme);
        this.bwR = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.w.check_zan);
        this.bwS = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.w.check_atme);
        this.bwW = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.w.check_new_fans);
        this.bwX = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.sign_remind_on);
        this.bwX.setClickable(false);
        this.bwY = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.sign_remind_on_text);
        this.bwZ = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.w.sign_remind_on_switch);
        this.bxa = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.sign_remind);
        this.bxb = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.sign_remind_text);
        this.bxc = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.sign_remind_time);
        this.bxd = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.promoted_message);
        this.bxd.setClickable(false);
        this.bxe = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.promoted_message_text);
        this.bxf = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.w.promoted_message_switch);
        this.bwT = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.w.check_chatmessage);
        this.bwU = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.w.check_strangermessage);
        this.bwV = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.w.check_groupmessage);
        this.bxg = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.front_container);
        this.bxh = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.back_container);
        this.bxi = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.no_disturb_start_time);
        this.bxj = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.no_disturb_start_time_text);
        this.bxk = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.no_disturb_start_time_value);
        this.bxl = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.no_disturb_end_time);
        this.bxm = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.no_disturb_end_time_text);
        this.bxn = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.no_disturb_end_time_value);
        this.bxo = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.remind_tone);
        this.bxo.setClickable(false);
        this.bxp = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.tone_text);
        this.bxq = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.w.remind_tone_switch);
        this.bxr = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.remind_vibrate);
        this.bxr.setClickable(false);
        this.bxs = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.vibrate_text);
        this.bxt = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.w.remind_vibrate_switch);
        this.bxu = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.remid_light);
        this.bxu.setClickable(false);
        this.bxv = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.light_text);
        this.bxw = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.w.remind_light_switch);
        this.bxx = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.remind_screen_lock);
        this.bxy = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.screen_lock_text);
        this.bxz = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.w.remind_screen_lock_switch);
        this.bxx.setClickable(false);
        this.bxA = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.chat_float_windoiw_group);
        this.bxA.setClickable(false);
        this.bxB = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.chat_float_window_text);
        this.bxC = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.w.chat_float_window_switch);
    }

    private void a(BaseActivity baseActivity) {
        this.bxF = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line1_layout);
        this.bxG = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line2_layout);
        this.bxH = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line3_layout);
        this.bxI = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line4_layout);
        this.bxJ = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line5_layout);
        this.bxK = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line6_layout);
        this.bxL = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line7_layout);
        this.bxM = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line8_layout);
        this.bxN = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line9_layout);
        this.bxO = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line10_layout);
        this.bxP = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line11_layout);
        this.bxQ = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line12_layout);
        this.bxR = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line13_layout);
        this.bxS = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line14_layout);
        this.bxT = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line15_layout);
        this.bxU = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line16_layout);
        this.bxV = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line24_layout);
    }

    public View BI() {
        return this.mBack;
    }

    public void dB(boolean z) {
        if (z) {
            this.bxG.setVisibility(0);
        } else {
            this.bxG.setVisibility(8);
        }
    }

    public void dC(boolean z) {
        if (z) {
            this.bxM.setPadding(this.bxE.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds30), 0, this.bxE.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds30), 0);
        } else {
            this.bxM.setPadding(0, 0, 0, 0);
        }
    }

    public void dD(boolean z) {
        if (z) {
            this.bxT.setVisibility(0);
        } else {
            this.bxT.setVisibility(8);
        }
    }

    private void VQ() {
        if (TbadkCoreApplication.m255getInst().isNoDisturbOn()) {
            this.bwI.iL();
            this.bwJ.setVisibility(0);
            VX();
            this.bxG.setVisibility(0);
            return;
        }
        this.bwI.iM();
        this.bwJ.setVisibility(8);
        this.bxG.setVisibility(8);
    }

    private void VR() {
        if (TbadkCoreApplication.m255getInst().isMsgRemindOn()) {
            this.bxM.setPadding(this.bxE.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds30), 0, this.bxE.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds30), 0);
        } else {
            this.bxM.setPadding(0, 0, 0, 0);
        }
        if (TbadkCoreApplication.m255getInst().isMsgReplymeOn()) {
            this.bwQ.setChecked(true);
        }
        if (TbadkCoreApplication.m255getInst().isMsgZanOn()) {
            this.bwR.setChecked(true);
        }
        if (TbadkCoreApplication.m255getInst().isMsgAtmeOn()) {
            this.bwS.setChecked(true);
        }
        this.bwW.setChecked(TbadkCoreApplication.m255getInst().isMsgNewFansOn());
        if (TbadkCoreApplication.m255getInst().isMsgChatOn()) {
            this.bwT.setChecked(true);
        }
        if (TbadkCoreApplication.m255getInst().isGroupMsgOn()) {
            this.bwV.setChecked(true);
        }
        if (TbadkCoreApplication.m255getInst().isStrangerChatOn()) {
            this.bwU.setChecked(true);
        }
    }

    private void VS() {
        if (TbadkCoreApplication.m255getInst().isPromotedMessageOn()) {
            this.bxf.iL();
        } else {
            this.bxf.iM();
        }
    }

    private void VT() {
        if (TbadkCoreApplication.m255getInst().isSignAlertOn()) {
            this.bwZ.iL();
            this.bxa.setVisibility(0);
            VW();
            this.bxT.setVisibility(0);
            return;
        }
        this.bwZ.iM();
        this.bxa.setVisibility(8);
        this.bxT.setVisibility(8);
    }

    private void VU() {
        if (TbadkCoreApplication.m255getInst().isMsgToneOn()) {
            this.bxq.iL();
        } else {
            this.bxq.iM();
        }
        if (TbadkCoreApplication.m255getInst().isMsgVibrateOn()) {
            this.bxt.iL();
        } else {
            this.bxt.iM();
        }
        if (TbadkCoreApplication.m255getInst().isMsgLightOn()) {
            this.bxw.iL();
        } else {
            this.bxw.iM();
        }
        if (TbadkCoreApplication.m255getInst().getScreenLock()) {
            this.bxz.iL();
        } else {
            this.bxz.iM();
        }
        if (TbadkCoreApplication.m255getInst().getChatFloatWindowLocked()) {
            this.bxC.iL();
        } else {
            this.bxC.iM();
        }
    }

    private void VV() {
        if (TbadkCoreApplication.m255getInst().isMsgRemindOn()) {
            this.bwO.iL();
            this.bwP.setVisibility(0);
            return;
        }
        this.bwO.iM();
        this.bwP.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.bwO.setOnSwitchStateChangeListener(msgRemindActivity);
        this.bwZ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.bxf.setOnSwitchStateChangeListener(msgRemindActivity);
        this.bwI.setOnSwitchStateChangeListener(msgRemindActivity);
        this.bwQ.setOnCheckedChangeListener(msgRemindActivity);
        this.bwR.setOnCheckedChangeListener(msgRemindActivity);
        this.bwS.setOnCheckedChangeListener(msgRemindActivity);
        this.bwW.setOnCheckedChangeListener(msgRemindActivity);
        this.bwT.setOnCheckedChangeListener(msgRemindActivity);
        this.bwU.setOnCheckedChangeListener(msgRemindActivity);
        this.bwV.setOnCheckedChangeListener(msgRemindActivity);
        this.bxa.setOnClickListener(msgRemindActivity);
        this.bwJ.setOnClickListener(msgRemindActivity);
        this.bxi.setOnClickListener(msgRemindActivity);
        this.bxl.setOnClickListener(msgRemindActivity);
        this.bxq.setOnSwitchStateChangeListener(msgRemindActivity);
        this.bxt.setOnSwitchStateChangeListener(msgRemindActivity);
        this.bxw.setOnSwitchStateChangeListener(msgRemindActivity);
        this.bxz.setOnSwitchStateChangeListener(msgRemindActivity);
        this.bxC.setOnSwitchStateChangeListener(msgRemindActivity);
    }

    public void dE(boolean z) {
        TbadkCoreApplication.m255getInst().getSkinType();
        if (z) {
            this.bwJ.setVisibility(0);
            VX();
            com.baidu.tbadk.core.util.bc.i(this.bwG, com.baidu.tieba.v.more_all);
            com.baidu.tbadk.core.util.bc.i(this.bwJ, com.baidu.tieba.v.more_all);
            return;
        }
        this.bwJ.setVisibility(8);
        com.baidu.tbadk.core.util.bc.i(this.bwG, com.baidu.tieba.v.more_all);
    }

    public void dF(boolean z) {
        TbadkCoreApplication.m255getInst().getSkinType();
        if (z) {
            this.bxa.setVisibility(0);
            com.baidu.tbadk.core.util.bc.i(this.bwX, com.baidu.tieba.v.more_all);
            com.baidu.tbadk.core.util.bc.i(this.bxa, com.baidu.tieba.v.more_all);
            return;
        }
        this.bxa.setVisibility(8);
        com.baidu.tbadk.core.util.bc.i(this.bwX, com.baidu.tieba.v.more_all);
    }

    public void dG(boolean z) {
        if (this.bxW == null) {
            this.bxW = new ax(this.bwP, 500);
        }
        TbadkCoreApplication.m255getInst().getSkinType();
        if (z) {
            this.bxW.show();
            com.baidu.tbadk.core.util.bc.i(this.bwM, com.baidu.tieba.v.more_all);
            com.baidu.tbadk.core.util.bc.i((View) this.bwQ, com.baidu.tieba.v.more_all);
            com.baidu.tbadk.core.util.bc.i((View) this.bwS, com.baidu.tieba.v.more_all);
            com.baidu.tbadk.core.util.bc.i((View) this.bwW, com.baidu.tieba.v.more_all);
            com.baidu.tbadk.core.util.bc.i((View) this.bwT, com.baidu.tieba.v.more_all);
            com.baidu.tbadk.core.util.bc.i((View) this.bwU, com.baidu.tieba.v.more_all);
            com.baidu.tbadk.core.util.bc.i((View) this.bwV, com.baidu.tieba.v.more_all);
            return;
        }
        this.bxW.hide();
        com.baidu.tbadk.core.util.bc.i(this.bwM, com.baidu.tieba.v.more_all);
    }

    public void VW() {
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
            this.bxc.setText(this.bxE.getPageContext().getContext().getString(com.baidu.tieba.z.sign_remind_time, str, str2));
            this.bxa.setVisibility(0);
            if (!this.bwZ.iN()) {
                this.bwZ.iL();
                return;
            }
            return;
        }
        this.bxc.setText(com.baidu.tieba.z.close);
        this.bxa.setVisibility(8);
        if (this.bwZ.iN()) {
            this.bwZ.iM();
        }
    }

    public void VX() {
        this.bwL.setText(String.valueOf(TbadkCoreApplication.m255getInst().getNoDisturbStartTime()) + "-" + TbadkCoreApplication.m255getInst().getNoDisturbEndTime());
        this.bxk.setText(TbadkCoreApplication.m255getInst().getNoDisturbStartTime());
        this.bxn.setText(TbadkCoreApplication.m255getInst().getNoDisturbEndTime());
    }

    public BdSwitchView VY() {
        return this.bxf;
    }

    public View VZ() {
        return this.bwZ;
    }

    public BdSwitchView Wa() {
        return this.bwO;
    }

    public View Wb() {
        return this.bxa;
    }

    public View Wc() {
        return this.bwI;
    }

    public View Wd() {
        return this.bwJ;
    }

    public LinearLayout We() {
        return this.bxi;
    }

    public LinearLayout Wf() {
        return this.bxl;
    }

    public BdSwitchView Wg() {
        return this.bxq;
    }

    public BdSwitchView Wh() {
        return this.bxt;
    }

    public BdSwitchView Wi() {
        return this.bxw;
    }

    public BdSwitchView Wj() {
        return this.bxz;
    }

    public BdSwitchView Wk() {
        return this.bxC;
    }

    public void Wl() {
        this.bwQ.setOnCheckedChangeListener(null);
        this.bwQ.setChecked(TbadkCoreApplication.m255getInst().isMsgReplymeOn());
        this.bwQ.setOnCheckedChangeListener(this.bxE);
    }

    public void Wm() {
        this.bwR.setOnCheckedChangeListener(null);
        this.bwR.setChecked(TbadkCoreApplication.m255getInst().isMsgZanOn());
        this.bwR.setOnCheckedChangeListener(this.bxE);
    }

    public void Wn() {
        this.bwS.setOnCheckedChangeListener(null);
        this.bwS.setChecked(TbadkCoreApplication.m255getInst().isMsgAtmeOn());
        this.bwS.setOnCheckedChangeListener(this.bxE);
    }

    public void Wo() {
        this.bwW.setOnCheckedChangeListener(null);
        this.bwW.setChecked(TbadkCoreApplication.m255getInst().isMsgNewFansOn());
        this.bwW.setOnCheckedChangeListener(this.bxE);
    }

    public void Wp() {
        this.bwT.setOnCheckedChangeListener(null);
        this.bwT.setChecked(TbadkCoreApplication.m255getInst().isMsgChatOn());
        this.bwT.setOnCheckedChangeListener(this.bxE);
    }

    public void Wq() {
        this.bwV.setOnCheckedChangeListener(null);
        this.bwV.setChecked(TbadkCoreApplication.m255getInst().isGroupMsgOn());
        this.bwV.setOnCheckedChangeListener(this.bxE);
    }

    public void Wr() {
        this.bwU.setOnCheckedChangeListener(null);
        this.bwU.setChecked(TbadkCoreApplication.m255getInst().isStrangerChatOn());
        this.bwU.setOnCheckedChangeListener(this.bxE);
    }

    public void dH(boolean z) {
        if (this.bxD != z) {
            this.bxD = z;
            if (z) {
                this.mTitleText.setText(com.baidu.tieba.z.msg_remind);
                this.bxg.setVisibility(0);
                this.bxh.setVisibility(8);
                return;
            }
            this.mTitleText.setText(com.baidu.tieba.z.no_disturb_mode_time);
            this.bxh.setVisibility(0);
            this.bxg.setVisibility(8);
        }
    }
}
