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
    private LinearLayout bwF;
    private TextView bwG;
    private BdSwitchView bwH;
    private LinearLayout bwI;
    private TextView bwJ;
    private TextView bwK;
    private LinearLayout bwL;
    private TextView bwM;
    private BdSwitchView bwN;
    private LinearLayout bwO;
    private CheckBox bwP;
    private CheckBox bwQ;
    private CheckBox bwR;
    private CheckBox bwS;
    private CheckBox bwT;
    private CheckBox bwU;
    private CheckBox bwV;
    private LinearLayout bwW;
    private TextView bwX;
    private BdSwitchView bwY;
    private LinearLayout bwZ;
    private TextView bxA;
    private BdSwitchView bxB;
    public boolean bxC;
    private MsgRemindActivity bxD;
    private LinearLayout bxE;
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
    private ax bxV;
    private TextView bxa;
    private TextView bxb;
    private LinearLayout bxc;
    private TextView bxd;
    private BdSwitchView bxe;
    private LinearLayout bxf;
    private LinearLayout bxg;
    private LinearLayout bxh;
    private TextView bxi;
    private TextView bxj;
    private LinearLayout bxk;
    private TextView bxl;
    private TextView bxm;
    private LinearLayout bxn;
    private TextView bxo;
    private BdSwitchView bxp;
    private LinearLayout bxq;
    private TextView bxr;
    private BdSwitchView bxs;
    private LinearLayout bxt;
    private TextView bxu;
    private BdSwitchView bxv;
    private LinearLayout bxw;
    private TextView bxx;
    private BdSwitchView bxy;
    private LinearLayout bxz;
    private View mBack;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;
    private TextView mTitleText;

    public aw(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.bwP = null;
        this.bwQ = null;
        this.bwR = null;
        this.bwS = null;
        this.bwT = null;
        this.bwU = null;
        this.bwV = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.mTitleText = null;
        this.bxC = true;
        this.bxE = null;
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
        this.bxD = msgRemindActivity;
        msgRemindActivity.setContentView(com.baidu.tieba.x.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        a(msgRemindActivity);
        VL();
        VQ();
        VM();
        VN();
        VO();
        VP();
        d(msgRemindActivity);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.bwF.setVisibility(8);
            this.bwI.setVisibility(8);
            this.bwL.setVisibility(8);
            this.bwO.setVisibility(8);
            this.bwW.setVisibility(8);
            this.bwZ.setVisibility(8);
            this.bxn.setVisibility(8);
            this.bxq.setVisibility(8);
            this.bxt.setVisibility(8);
            this.bxw.setVisibility(8);
            this.bxz.setVisibility(8);
            this.bxE.setVisibility(8);
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
        }
        boolean isMIUIRom = TbadkCoreApplication.m255getInst().isMIUIRom();
        if (TbadkCoreApplication.m255getInst().isFloatingWindowOpened() && !isMIUIRom) {
            this.bxz.setVisibility(0);
            this.bxU.setVisibility(0);
            return;
        }
        this.bxz.setVisibility(8);
        this.bxU.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.bxD.getLayoutMode().ab(i == 1);
        this.bxD.getLayoutMode().h(this.mParent);
        com.baidu.tbadk.core.util.bc.j(this.mParent, com.baidu.tieba.t.bg_page_setting);
        this.mNavigationBar.onChangeSkinType(this.bxD.getPageContext(), i);
        boolean z = i == 1;
        int cb = z ? com.baidu.tbadk.core.util.bc.cb(i) : this.bxD.getPageContext().getContext().getResources().getColor(com.baidu.tieba.t.more_color);
        int i2 = z ? -11446171 : -5065030;
        BdSwitchView.SwitchStyle switchStyle = z ? BdSwitchView.SwitchStyle.NIGHT : BdSwitchView.SwitchStyle.DAY;
        com.baidu.tbadk.core.util.bc.i(this.bwF, com.baidu.tieba.v.more_all);
        com.baidu.tbadk.core.util.bc.i(this.bwI, com.baidu.tieba.v.more_all);
        this.bwH.setSwitchStyle(switchStyle);
        com.baidu.tbadk.core.util.bc.i(this.bxh, com.baidu.tieba.v.more_all);
        com.baidu.tbadk.core.util.bc.i(this.bxk, com.baidu.tieba.v.more_all);
        com.baidu.tbadk.core.util.bc.i(this.bwL, com.baidu.tieba.v.more_all);
        com.baidu.tbadk.core.util.bc.i((View) this.bwP, com.baidu.tieba.v.more_all);
        com.baidu.tbadk.core.util.bc.i((View) this.bwQ, com.baidu.tieba.v.more_all);
        com.baidu.tbadk.core.util.bc.i((View) this.bwR, com.baidu.tieba.v.more_all);
        com.baidu.tbadk.core.util.bc.i((View) this.bwS, com.baidu.tieba.v.more_all);
        com.baidu.tbadk.core.util.bc.i((View) this.bwT, com.baidu.tieba.v.more_all);
        com.baidu.tbadk.core.util.bc.i((View) this.bwV, com.baidu.tieba.v.more_all);
        com.baidu.tbadk.core.util.bc.i((View) this.bwU, com.baidu.tieba.v.more_all);
        this.bwN.setSwitchStyle(switchStyle);
        com.baidu.tbadk.core.util.bc.i(this.bwW, com.baidu.tieba.v.more_all);
        com.baidu.tbadk.core.util.bc.i(this.bwZ, com.baidu.tieba.v.more_all);
        this.bwY.setSwitchStyle(switchStyle);
        com.baidu.tbadk.core.util.bc.c((ImageView) this.bwI.findViewById(com.baidu.tieba.w.no_disturb_mode_time_arrow), com.baidu.tieba.v.icon_arrow_right);
        com.baidu.tbadk.core.util.bc.c((ImageView) this.bwZ.findViewById(com.baidu.tieba.w.sign_remind_arrow), com.baidu.tieba.v.icon_arrow_right);
        com.baidu.tbadk.core.util.bc.c((ImageView) this.bxh.findViewById(com.baidu.tieba.w.no_disturb_start_time_arrow), com.baidu.tieba.v.icon_arrow_right);
        com.baidu.tbadk.core.util.bc.c((ImageView) this.bxk.findViewById(com.baidu.tieba.w.no_disturb_end_time_arrow), com.baidu.tieba.v.icon_arrow_right);
        com.baidu.tbadk.core.util.bc.i(this.bxc, com.baidu.tieba.v.more_all);
        this.bxe.setSwitchStyle(switchStyle);
        com.baidu.tbadk.core.util.bc.i(this.bxn, com.baidu.tieba.v.more_all);
        this.bxp.setSwitchStyle(switchStyle);
        com.baidu.tbadk.core.util.bc.i(this.bxq, com.baidu.tieba.v.more_all);
        this.bxs.setSwitchStyle(switchStyle);
        com.baidu.tbadk.core.util.bc.i(this.bxt, com.baidu.tieba.v.more_all);
        this.bxv.setSwitchStyle(switchStyle);
        com.baidu.tbadk.core.util.bc.i(this.bxw, com.baidu.tieba.v.more_all);
        com.baidu.tbadk.core.util.bc.i(this.bxz, com.baidu.tieba.v.more_all);
        this.bxy.setSwitchStyle(switchStyle);
        this.bxB.setSwitchStyle(switchStyle);
        this.bwG.setTextColor(cb);
        this.bwJ.setTextColor(cb);
        this.bwK.setTextColor(i2);
        this.bxi.setTextColor(cb);
        this.bxj.setTextColor(i2);
        this.bxl.setTextColor(cb);
        this.bxm.setTextColor(i2);
        this.bwM.setTextColor(cb);
        this.bwP.setTextColor(cb);
        this.bwQ.setTextColor(cb);
        this.bwR.setTextColor(cb);
        this.bwV.setTextColor(cb);
        this.bwS.setTextColor(cb);
        this.bwT.setTextColor(cb);
        this.bwU.setTextColor(cb);
        this.bwX.setTextColor(cb);
        this.bxa.setTextColor(cb);
        this.bxb.setTextColor(i2);
        this.bxd.setTextColor(cb);
        this.bxo.setTextColor(cb);
        this.bxr.setTextColor(cb);
        this.bxu.setTextColor(cb);
        this.bxx.setTextColor(cb);
        this.bxA.setTextColor(cb);
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.mParent = (RelativeLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.parent);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitleText = this.mNavigationBar.setTitleText(msgRemindActivity.getPageContext().getString(com.baidu.tieba.z.msg_remind));
        this.bwF = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.no_disturb_mode_container);
        this.bwF.setClickable(false);
        this.bwG = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.no_disturb_mode_text);
        this.bwH = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.w.no_disturb_mode_switch);
        this.bwI = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.no_disturb_mode_time_container);
        this.bwJ = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.no_disturb_mode_time_text);
        this.bwK = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.no_disturb_mode_time_value);
        this.bwL = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.message_remind_container);
        this.bwL.setClickable(false);
        this.bwM = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.message_remind_text);
        this.bwN = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.w.message_remind_switch);
        this.bwO = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.message_remind_value);
        this.bwP = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.w.check_replyme);
        this.bwQ = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.w.check_zan);
        this.bwR = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.w.check_atme);
        this.bwV = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.w.check_new_fans);
        this.bwW = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.sign_remind_on);
        this.bwW.setClickable(false);
        this.bwX = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.sign_remind_on_text);
        this.bwY = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.w.sign_remind_on_switch);
        this.bwZ = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.sign_remind);
        this.bxa = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.sign_remind_text);
        this.bxb = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.sign_remind_time);
        this.bxc = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.promoted_message);
        this.bxc.setClickable(false);
        this.bxd = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.promoted_message_text);
        this.bxe = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.w.promoted_message_switch);
        this.bwS = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.w.check_chatmessage);
        this.bwT = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.w.check_strangermessage);
        this.bwU = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.w.check_groupmessage);
        this.bxf = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.front_container);
        this.bxg = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.back_container);
        this.bxh = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.no_disturb_start_time);
        this.bxi = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.no_disturb_start_time_text);
        this.bxj = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.no_disturb_start_time_value);
        this.bxk = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.no_disturb_end_time);
        this.bxl = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.no_disturb_end_time_text);
        this.bxm = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.no_disturb_end_time_value);
        this.bxn = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.remind_tone);
        this.bxn.setClickable(false);
        this.bxo = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.tone_text);
        this.bxp = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.w.remind_tone_switch);
        this.bxq = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.remind_vibrate);
        this.bxq.setClickable(false);
        this.bxr = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.vibrate_text);
        this.bxs = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.w.remind_vibrate_switch);
        this.bxt = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.remid_light);
        this.bxt.setClickable(false);
        this.bxu = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.light_text);
        this.bxv = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.w.remind_light_switch);
        this.bxw = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.remind_screen_lock);
        this.bxx = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.screen_lock_text);
        this.bxy = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.w.remind_screen_lock_switch);
        this.bxw.setClickable(false);
        this.bxz = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.w.chat_float_windoiw_group);
        this.bxz.setClickable(false);
        this.bxA = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.w.chat_float_window_text);
        this.bxB = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.w.chat_float_window_switch);
    }

    private void a(BaseActivity baseActivity) {
        this.bxE = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line1_layout);
        this.bxF = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line2_layout);
        this.bxG = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line3_layout);
        this.bxH = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line4_layout);
        this.bxI = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line5_layout);
        this.bxJ = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line6_layout);
        this.bxK = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line7_layout);
        this.bxL = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line8_layout);
        this.bxM = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line9_layout);
        this.bxN = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line10_layout);
        this.bxO = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line11_layout);
        this.bxP = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line12_layout);
        this.bxQ = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line13_layout);
        this.bxR = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line14_layout);
        this.bxS = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line15_layout);
        this.bxT = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line16_layout);
        this.bxU = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.w.line24_layout);
    }

    public View BC() {
        return this.mBack;
    }

    public void dB(boolean z) {
        if (z) {
            this.bxF.setVisibility(0);
        } else {
            this.bxF.setVisibility(8);
        }
    }

    public void dC(boolean z) {
        if (z) {
            this.bxL.setPadding(this.bxD.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds30), 0, this.bxD.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds30), 0);
        } else {
            this.bxL.setPadding(0, 0, 0, 0);
        }
    }

    public void dD(boolean z) {
        if (z) {
            this.bxS.setVisibility(0);
        } else {
            this.bxS.setVisibility(8);
        }
    }

    private void VL() {
        if (TbadkCoreApplication.m255getInst().isNoDisturbOn()) {
            this.bwH.iE();
            this.bwI.setVisibility(0);
            VS();
            this.bxF.setVisibility(0);
            return;
        }
        this.bwH.iF();
        this.bwI.setVisibility(8);
        this.bxF.setVisibility(8);
    }

    private void VM() {
        if (TbadkCoreApplication.m255getInst().isMsgRemindOn()) {
            this.bxL.setPadding(this.bxD.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds30), 0, this.bxD.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds30), 0);
        } else {
            this.bxL.setPadding(0, 0, 0, 0);
        }
        if (TbadkCoreApplication.m255getInst().isMsgReplymeOn()) {
            this.bwP.setChecked(true);
        }
        if (TbadkCoreApplication.m255getInst().isMsgZanOn()) {
            this.bwQ.setChecked(true);
        }
        if (TbadkCoreApplication.m255getInst().isMsgAtmeOn()) {
            this.bwR.setChecked(true);
        }
        this.bwV.setChecked(TbadkCoreApplication.m255getInst().isMsgNewFansOn());
        if (TbadkCoreApplication.m255getInst().isMsgChatOn()) {
            this.bwS.setChecked(true);
        }
        if (TbadkCoreApplication.m255getInst().isGroupMsgOn()) {
            this.bwU.setChecked(true);
        }
        if (TbadkCoreApplication.m255getInst().isStrangerChatOn()) {
            this.bwT.setChecked(true);
        }
    }

    private void VN() {
        if (TbadkCoreApplication.m255getInst().isPromotedMessageOn()) {
            this.bxe.iE();
        } else {
            this.bxe.iF();
        }
    }

    private void VO() {
        if (TbadkCoreApplication.m255getInst().isSignAlertOn()) {
            this.bwY.iE();
            this.bwZ.setVisibility(0);
            VR();
            this.bxS.setVisibility(0);
            return;
        }
        this.bwY.iF();
        this.bwZ.setVisibility(8);
        this.bxS.setVisibility(8);
    }

    private void VP() {
        if (TbadkCoreApplication.m255getInst().isMsgToneOn()) {
            this.bxp.iE();
        } else {
            this.bxp.iF();
        }
        if (TbadkCoreApplication.m255getInst().isMsgVibrateOn()) {
            this.bxs.iE();
        } else {
            this.bxs.iF();
        }
        if (TbadkCoreApplication.m255getInst().isMsgLightOn()) {
            this.bxv.iE();
        } else {
            this.bxv.iF();
        }
        if (TbadkCoreApplication.m255getInst().getScreenLock()) {
            this.bxy.iE();
        } else {
            this.bxy.iF();
        }
        if (TbadkCoreApplication.m255getInst().getChatFloatWindowLocked()) {
            this.bxB.iE();
        } else {
            this.bxB.iF();
        }
    }

    private void VQ() {
        if (TbadkCoreApplication.m255getInst().isMsgRemindOn()) {
            this.bwN.iE();
            this.bwO.setVisibility(0);
            return;
        }
        this.bwN.iF();
        this.bwO.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.bwN.setOnSwitchStateChangeListener(msgRemindActivity);
        this.bwY.setOnSwitchStateChangeListener(msgRemindActivity);
        this.bxe.setOnSwitchStateChangeListener(msgRemindActivity);
        this.bwH.setOnSwitchStateChangeListener(msgRemindActivity);
        this.bwP.setOnCheckedChangeListener(msgRemindActivity);
        this.bwQ.setOnCheckedChangeListener(msgRemindActivity);
        this.bwR.setOnCheckedChangeListener(msgRemindActivity);
        this.bwV.setOnCheckedChangeListener(msgRemindActivity);
        this.bwS.setOnCheckedChangeListener(msgRemindActivity);
        this.bwT.setOnCheckedChangeListener(msgRemindActivity);
        this.bwU.setOnCheckedChangeListener(msgRemindActivity);
        this.bwZ.setOnClickListener(msgRemindActivity);
        this.bwI.setOnClickListener(msgRemindActivity);
        this.bxh.setOnClickListener(msgRemindActivity);
        this.bxk.setOnClickListener(msgRemindActivity);
        this.bxp.setOnSwitchStateChangeListener(msgRemindActivity);
        this.bxs.setOnSwitchStateChangeListener(msgRemindActivity);
        this.bxv.setOnSwitchStateChangeListener(msgRemindActivity);
        this.bxy.setOnSwitchStateChangeListener(msgRemindActivity);
        this.bxB.setOnSwitchStateChangeListener(msgRemindActivity);
    }

    public void dE(boolean z) {
        TbadkCoreApplication.m255getInst().getSkinType();
        if (z) {
            this.bwI.setVisibility(0);
            VS();
            com.baidu.tbadk.core.util.bc.i(this.bwF, com.baidu.tieba.v.more_all);
            com.baidu.tbadk.core.util.bc.i(this.bwI, com.baidu.tieba.v.more_all);
            return;
        }
        this.bwI.setVisibility(8);
        com.baidu.tbadk.core.util.bc.i(this.bwF, com.baidu.tieba.v.more_all);
    }

    public void dF(boolean z) {
        TbadkCoreApplication.m255getInst().getSkinType();
        if (z) {
            this.bwZ.setVisibility(0);
            com.baidu.tbadk.core.util.bc.i(this.bwW, com.baidu.tieba.v.more_all);
            com.baidu.tbadk.core.util.bc.i(this.bwZ, com.baidu.tieba.v.more_all);
            return;
        }
        this.bwZ.setVisibility(8);
        com.baidu.tbadk.core.util.bc.i(this.bwW, com.baidu.tieba.v.more_all);
    }

    public void dG(boolean z) {
        if (this.bxV == null) {
            this.bxV = new ax(this.bwO, 500);
        }
        TbadkCoreApplication.m255getInst().getSkinType();
        if (z) {
            this.bxV.show();
            com.baidu.tbadk.core.util.bc.i(this.bwL, com.baidu.tieba.v.more_all);
            com.baidu.tbadk.core.util.bc.i((View) this.bwP, com.baidu.tieba.v.more_all);
            com.baidu.tbadk.core.util.bc.i((View) this.bwR, com.baidu.tieba.v.more_all);
            com.baidu.tbadk.core.util.bc.i((View) this.bwV, com.baidu.tieba.v.more_all);
            com.baidu.tbadk.core.util.bc.i((View) this.bwS, com.baidu.tieba.v.more_all);
            com.baidu.tbadk.core.util.bc.i((View) this.bwT, com.baidu.tieba.v.more_all);
            com.baidu.tbadk.core.util.bc.i((View) this.bwU, com.baidu.tieba.v.more_all);
            return;
        }
        this.bxV.hide();
        com.baidu.tbadk.core.util.bc.i(this.bwL, com.baidu.tieba.v.more_all);
    }

    public void VR() {
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
            this.bxb.setText(this.bxD.getPageContext().getContext().getString(com.baidu.tieba.z.sign_remind_time, str, str2));
            this.bwZ.setVisibility(0);
            if (!this.bwY.iG()) {
                this.bwY.iE();
                return;
            }
            return;
        }
        this.bxb.setText(com.baidu.tieba.z.close);
        this.bwZ.setVisibility(8);
        if (this.bwY.iG()) {
            this.bwY.iF();
        }
    }

    public void VS() {
        this.bwK.setText(String.valueOf(TbadkCoreApplication.m255getInst().getNoDisturbStartTime()) + "-" + TbadkCoreApplication.m255getInst().getNoDisturbEndTime());
        this.bxj.setText(TbadkCoreApplication.m255getInst().getNoDisturbStartTime());
        this.bxm.setText(TbadkCoreApplication.m255getInst().getNoDisturbEndTime());
    }

    public BdSwitchView VT() {
        return this.bxe;
    }

    public View VU() {
        return this.bwY;
    }

    public BdSwitchView VV() {
        return this.bwN;
    }

    public View VW() {
        return this.bwZ;
    }

    public View VX() {
        return this.bwH;
    }

    public View VY() {
        return this.bwI;
    }

    public LinearLayout VZ() {
        return this.bxh;
    }

    public LinearLayout Wa() {
        return this.bxk;
    }

    public BdSwitchView Wb() {
        return this.bxp;
    }

    public BdSwitchView Wc() {
        return this.bxs;
    }

    public BdSwitchView Wd() {
        return this.bxv;
    }

    public BdSwitchView We() {
        return this.bxy;
    }

    public BdSwitchView Wf() {
        return this.bxB;
    }

    public void Wg() {
        this.bwP.setOnCheckedChangeListener(null);
        this.bwP.setChecked(TbadkCoreApplication.m255getInst().isMsgReplymeOn());
        this.bwP.setOnCheckedChangeListener(this.bxD);
    }

    public void Wh() {
        this.bwQ.setOnCheckedChangeListener(null);
        this.bwQ.setChecked(TbadkCoreApplication.m255getInst().isMsgZanOn());
        this.bwQ.setOnCheckedChangeListener(this.bxD);
    }

    public void Wi() {
        this.bwR.setOnCheckedChangeListener(null);
        this.bwR.setChecked(TbadkCoreApplication.m255getInst().isMsgAtmeOn());
        this.bwR.setOnCheckedChangeListener(this.bxD);
    }

    public void Wj() {
        this.bwV.setOnCheckedChangeListener(null);
        this.bwV.setChecked(TbadkCoreApplication.m255getInst().isMsgNewFansOn());
        this.bwV.setOnCheckedChangeListener(this.bxD);
    }

    public void Wk() {
        this.bwS.setOnCheckedChangeListener(null);
        this.bwS.setChecked(TbadkCoreApplication.m255getInst().isMsgChatOn());
        this.bwS.setOnCheckedChangeListener(this.bxD);
    }

    public void Wl() {
        this.bwU.setOnCheckedChangeListener(null);
        this.bwU.setChecked(TbadkCoreApplication.m255getInst().isGroupMsgOn());
        this.bwU.setOnCheckedChangeListener(this.bxD);
    }

    public void Wm() {
        this.bwT.setOnCheckedChangeListener(null);
        this.bwT.setChecked(TbadkCoreApplication.m255getInst().isStrangerChatOn());
        this.bwT.setOnCheckedChangeListener(this.bxD);
    }

    public void dH(boolean z) {
        if (this.bxC != z) {
            this.bxC = z;
            if (z) {
                this.mTitleText.setText(com.baidu.tieba.z.msg_remind);
                this.bxf.setVisibility(0);
                this.bxg.setVisibility(8);
                return;
            }
            this.mTitleText.setText(com.baidu.tieba.z.no_disturb_mode_time);
            this.bxg.setVisibility(0);
            this.bxf.setVisibility(8);
        }
    }
}
