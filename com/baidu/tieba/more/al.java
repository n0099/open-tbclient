package com.baidu.tieba.more;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public class al extends com.baidu.adp.base.f {
    private View Jt;
    private TextView atJ;
    private LinearLayout brH;
    private TextView brI;
    private BdSwitchView brJ;
    private LinearLayout brK;
    private TextView brL;
    private TextView brM;
    private LinearLayout brN;
    private TextView brO;
    private BdSwitchView brP;
    private LinearLayout brQ;
    private CheckBox brR;
    private CheckBox brS;
    private CheckBox brT;
    private CheckBox brU;
    private CheckBox brV;
    private CheckBox brW;
    private LinearLayout brX;
    private TextView brY;
    private BdSwitchView brZ;
    private LinearLayout bsA;
    private LinearLayout bsB;
    private LinearLayout bsC;
    private LinearLayout bsD;
    private LinearLayout bsE;
    private LinearLayout bsF;
    private LinearLayout bsG;
    private LinearLayout bsH;
    private LinearLayout bsI;
    private LinearLayout bsJ;
    private LinearLayout bsK;
    private LinearLayout bsL;
    private LinearLayout bsM;
    private LinearLayout bsN;
    private am bsO;
    private LinearLayout bsa;
    private TextView bsb;
    private TextView bsc;
    private LinearLayout bsd;
    private TextView bse;
    private BdSwitchView bsf;
    private LinearLayout bsg;
    private LinearLayout bsh;
    private LinearLayout bsi;
    private TextView bsj;
    private TextView bsk;
    private LinearLayout bsl;
    private TextView bsm;
    private TextView bsn;
    private LinearLayout bso;
    private TextView bsp;
    private BdSwitchView bsq;
    private LinearLayout bsr;
    private TextView bss;
    private BdSwitchView bst;
    private LinearLayout bsu;
    private TextView bsv;
    private BdSwitchView bsw;
    public boolean bsx;
    private LinearLayout bsy;
    private LinearLayout bsz;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public al(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity);
        this.brR = null;
        this.brS = null;
        this.brT = null;
        this.brU = null;
        this.brV = null;
        this.brW = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.atJ = null;
        this.bsx = true;
        this.bsy = null;
        this.bsz = null;
        this.bsA = null;
        this.bsB = null;
        this.bsC = null;
        this.bsD = null;
        this.bsE = null;
        this.bsF = null;
        this.bsG = null;
        this.bsH = null;
        this.bsI = null;
        this.bsJ = null;
        this.bsK = null;
        this.bsL = null;
        this.bsM = null;
        this.bsN = null;
        this.mActivity = msgRemindActivity;
        msgRemindActivity.setContentView(com.baidu.tieba.w.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        c((BaseActivity) msgRemindActivity);
        Vd();
        Vi();
        Ve();
        Vf();
        Vg();
        Vh();
        d(msgRemindActivity);
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.brH.setVisibility(8);
            this.brK.setVisibility(8);
            this.brN.setVisibility(8);
            this.brQ.setVisibility(8);
            this.brX.setVisibility(8);
            this.bsa.setVisibility(8);
            this.bso.setVisibility(8);
            this.bsr.setVisibility(8);
            this.bsu.setVisibility(8);
            this.bsy.setVisibility(8);
            this.bsz.setVisibility(8);
            this.bsA.setVisibility(8);
            this.bsB.setVisibility(8);
            this.bsC.setVisibility(8);
            this.bsD.setVisibility(8);
            this.bsE.setVisibility(8);
            this.bsF.setVisibility(8);
            this.bsG.setVisibility(8);
            this.bsH.setVisibility(8);
            this.bsI.setVisibility(8);
            this.bsJ.setVisibility(8);
            this.bsK.setVisibility(8);
            this.bsL.setVisibility(8);
            this.bsM.setVisibility(8);
            this.bsN.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        this.mActivity.getLayoutMode().L(i == 1);
        this.mActivity.getLayoutMode().h(this.mParent);
        com.baidu.tbadk.core.util.aw.i(this.mParent, com.baidu.tieba.s.bg_page_setting);
        this.mNavigationBar.onChangeSkinType(i);
        boolean z = i == 1;
        int bx = z ? com.baidu.tbadk.core.util.aw.bx(i) : getContext().getResources().getColor(com.baidu.tieba.s.more_color);
        int i2 = z ? -11446171 : -5065030;
        BdSwitchView.SwitchStyle switchStyle = z ? BdSwitchView.SwitchStyle.NIGHT : BdSwitchView.SwitchStyle.DAY;
        com.baidu.tbadk.core.util.aw.h(this.brH, com.baidu.tieba.u.more_all);
        com.baidu.tbadk.core.util.aw.h(this.brK, com.baidu.tieba.u.more_all);
        this.brJ.setSwitchStyle(switchStyle);
        com.baidu.tbadk.core.util.aw.h(this.bsi, com.baidu.tieba.u.more_all);
        com.baidu.tbadk.core.util.aw.h(this.bsl, com.baidu.tieba.u.more_all);
        com.baidu.tbadk.core.util.aw.h(this.brN, com.baidu.tieba.u.more_all);
        com.baidu.tbadk.core.util.aw.h((View) this.brR, com.baidu.tieba.u.more_all);
        com.baidu.tbadk.core.util.aw.h((View) this.brS, com.baidu.tieba.u.more_all);
        com.baidu.tbadk.core.util.aw.h((View) this.brT, com.baidu.tieba.u.more_all);
        com.baidu.tbadk.core.util.aw.h((View) this.brU, com.baidu.tieba.u.more_all);
        com.baidu.tbadk.core.util.aw.h((View) this.brW, com.baidu.tieba.u.more_all);
        com.baidu.tbadk.core.util.aw.h((View) this.brV, com.baidu.tieba.u.more_all);
        this.brP.setSwitchStyle(switchStyle);
        com.baidu.tbadk.core.util.aw.h(this.brX, com.baidu.tieba.u.more_all);
        com.baidu.tbadk.core.util.aw.h(this.bsa, com.baidu.tieba.u.more_all);
        this.brZ.setSwitchStyle(switchStyle);
        com.baidu.tbadk.core.util.aw.c((ImageView) this.brK.findViewById(com.baidu.tieba.v.no_disturb_mode_time_arrow), com.baidu.tieba.u.icon_arrow_right);
        com.baidu.tbadk.core.util.aw.c((ImageView) this.bsa.findViewById(com.baidu.tieba.v.sign_remind_arrow), com.baidu.tieba.u.icon_arrow_right);
        com.baidu.tbadk.core.util.aw.c((ImageView) this.bsi.findViewById(com.baidu.tieba.v.no_disturb_start_time_arrow), com.baidu.tieba.u.icon_arrow_right);
        com.baidu.tbadk.core.util.aw.c((ImageView) this.bsl.findViewById(com.baidu.tieba.v.no_disturb_end_time_arrow), com.baidu.tieba.u.icon_arrow_right);
        com.baidu.tbadk.core.util.aw.h(this.bsd, com.baidu.tieba.u.more_all);
        this.bsf.setSwitchStyle(switchStyle);
        com.baidu.tbadk.core.util.aw.h(this.bso, com.baidu.tieba.u.more_all);
        this.bsq.setSwitchStyle(switchStyle);
        com.baidu.tbadk.core.util.aw.h(this.bsr, com.baidu.tieba.u.more_all);
        this.bst.setSwitchStyle(switchStyle);
        com.baidu.tbadk.core.util.aw.h(this.bsu, com.baidu.tieba.u.more_all);
        this.bsw.setSwitchStyle(switchStyle);
        this.brI.setTextColor(bx);
        this.brL.setTextColor(bx);
        this.brM.setTextColor(i2);
        this.bsj.setTextColor(bx);
        this.bsk.setTextColor(i2);
        this.bsm.setTextColor(bx);
        this.bsn.setTextColor(i2);
        this.brO.setTextColor(bx);
        this.brR.setTextColor(bx);
        this.brS.setTextColor(bx);
        this.brT.setTextColor(bx);
        this.brW.setTextColor(bx);
        this.brU.setTextColor(bx);
        this.brV.setTextColor(bx);
        this.brY.setTextColor(bx);
        this.bsb.setTextColor(bx);
        this.bsc.setTextColor(i2);
        this.bse.setTextColor(bx);
        this.bsp.setTextColor(bx);
        this.bss.setTextColor(bx);
        this.bsv.setTextColor(bx);
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.mParent = (RelativeLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.parent);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.Jt = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.atJ = this.mNavigationBar.setTitleText(msgRemindActivity.getString(com.baidu.tieba.y.msg_remind));
        this.brH = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_mode_container);
        this.brH.setClickable(false);
        this.brI = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_mode_text);
        this.brJ = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_mode_switch);
        this.brK = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_mode_time_container);
        this.brL = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_mode_time_text);
        this.brM = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_mode_time_value);
        this.brN = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.message_remind_container);
        this.brN.setClickable(false);
        this.brO = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.message_remind_text);
        this.brP = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.v.message_remind_switch);
        this.brQ = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.message_remind_value);
        this.brR = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.v.check_replyme);
        this.brS = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.v.check_zan);
        this.brT = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.v.check_atme);
        this.brW = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.v.check_new_fans);
        this.brX = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.sign_remind_on);
        this.brX.setClickable(false);
        this.brY = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.sign_remind_on_text);
        this.brZ = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.v.sign_remind_on_switch);
        this.bsa = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.sign_remind);
        this.bsb = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.sign_remind_text);
        this.bsc = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.sign_remind_time);
        this.bsd = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.promoted_message);
        this.bsd.setClickable(false);
        this.bse = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.promoted_message_text);
        this.bsf = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.v.promoted_message_switch);
        this.brU = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.v.check_chatmessage);
        this.brV = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.v.check_groupmessage);
        this.bsg = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.front_container);
        this.bsh = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.back_container);
        this.bsi = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_start_time);
        this.bsj = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_start_time_text);
        this.bsk = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_start_time_value);
        this.bsl = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_end_time);
        this.bsm = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_end_time_text);
        this.bsn = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_end_time_value);
        this.bso = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.remind_tone);
        this.bso.setClickable(false);
        this.bsp = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.tone_text);
        this.bsq = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.v.remind_tone_switch);
        this.bsr = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.remind_vibrate);
        this.bsr.setClickable(false);
        this.bss = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.vibrate_text);
        this.bst = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.v.remind_vibrate_switch);
        this.bsu = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.remid_light);
        this.bsu.setClickable(false);
        this.bsv = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.light_text);
        this.bsw = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.v.remind_light_switch);
    }

    private void c(BaseActivity baseActivity) {
        this.bsy = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.line1_layout);
        this.bsz = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.line2_layout);
        this.bsA = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.line3_layout);
        this.bsB = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.line4_layout);
        this.bsC = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.line5_layout);
        this.bsD = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.line6_layout);
        this.bsE = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.line7_layout);
        this.bsF = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.line8_layout);
        this.bsG = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.line9_layout);
        this.bsH = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.line10_layout);
        this.bsI = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.line11_layout);
        this.bsJ = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.line12_layout);
        this.bsK = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.line13_layout);
        this.bsL = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.line14_layout);
        this.bsM = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.line15_layout);
        this.bsN = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.line16_layout);
    }

    public View xQ() {
        return this.Jt;
    }

    public void dK(boolean z) {
        if (z) {
            this.bsz.setVisibility(0);
        } else {
            this.bsz.setVisibility(8);
        }
    }

    public void dL(boolean z) {
        if (z) {
            this.bsF.setPadding(this.mActivity.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds30), 0, this.mActivity.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds30), 0);
        } else {
            this.bsF.setPadding(0, 0, 0, 0);
        }
    }

    public void dM(boolean z) {
        if (z) {
            this.bsM.setVisibility(0);
        } else {
            this.bsM.setVisibility(8);
        }
    }

    private void Vd() {
        if (TbadkApplication.m251getInst().isNoDisturbOn()) {
            this.brJ.gN();
            this.brK.setVisibility(0);
            Vk();
            this.bsz.setVisibility(0);
            return;
        }
        this.brJ.gO();
        this.brK.setVisibility(8);
        this.bsz.setVisibility(8);
    }

    private void Ve() {
        if (TbadkApplication.m251getInst().isMsgRemindOn()) {
            this.bsF.setPadding(this.mActivity.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds30), 0, this.mActivity.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds30), 0);
        } else {
            this.bsF.setPadding(0, 0, 0, 0);
        }
        if (TbadkApplication.m251getInst().isMsgReplymeOn()) {
            this.brR.setChecked(true);
        }
        if (TbadkApplication.m251getInst().isMsgZanOn()) {
            this.brS.setChecked(true);
        }
        if (TbadkApplication.m251getInst().isMsgAtmeOn()) {
            this.brT.setChecked(true);
        }
        this.brW.setChecked(TbadkApplication.m251getInst().isMsgNewFansOn());
        if (TbadkApplication.m251getInst().isMsgChatOn()) {
            this.brU.setChecked(true);
        }
        if (TbadkApplication.m251getInst().isGroupMsgOn()) {
            this.brV.setChecked(true);
        }
    }

    private void Vf() {
        if (TbadkApplication.m251getInst().isPromotedMessageOn()) {
            this.bsf.gN();
        } else {
            this.bsf.gO();
        }
    }

    private void Vg() {
        if (com.baidu.tieba.aj.wm().wB()) {
            this.brZ.gN();
            this.bsa.setVisibility(0);
            Vj();
            this.bsM.setVisibility(0);
            return;
        }
        this.brZ.gO();
        this.bsa.setVisibility(8);
        this.bsM.setVisibility(8);
    }

    private void Vh() {
        if (TbadkApplication.m251getInst().isMsgToneOn()) {
            this.bsq.gN();
        } else {
            this.bsq.gO();
        }
        if (TbadkApplication.m251getInst().isMsgVibrateOn()) {
            this.bst.gN();
        } else {
            this.bst.gO();
        }
        if (TbadkApplication.m251getInst().isMsgLightOn()) {
            this.bsw.gN();
        } else {
            this.bsw.gO();
        }
    }

    private void Vi() {
        if (TbadkApplication.m251getInst().isMsgRemindOn()) {
            this.brP.gN();
            this.brQ.setVisibility(0);
            return;
        }
        this.brP.gO();
        this.brQ.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.brP.setOnSwitchStateChangeListener(msgRemindActivity);
        this.brZ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.bsf.setOnSwitchStateChangeListener(msgRemindActivity);
        this.brJ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.brR.setOnCheckedChangeListener(msgRemindActivity);
        this.brS.setOnCheckedChangeListener(msgRemindActivity);
        this.brT.setOnCheckedChangeListener(msgRemindActivity);
        this.brW.setOnCheckedChangeListener(msgRemindActivity);
        this.brU.setOnCheckedChangeListener(msgRemindActivity);
        this.brV.setOnCheckedChangeListener(msgRemindActivity);
        this.bsa.setOnClickListener(msgRemindActivity);
        this.brK.setOnClickListener(msgRemindActivity);
        this.bsi.setOnClickListener(msgRemindActivity);
        this.bsl.setOnClickListener(msgRemindActivity);
        this.bsq.setOnSwitchStateChangeListener(msgRemindActivity);
        this.bst.setOnSwitchStateChangeListener(msgRemindActivity);
        this.bsw.setOnSwitchStateChangeListener(msgRemindActivity);
    }

    public void dN(boolean z) {
        TbadkApplication.m251getInst().getSkinType();
        if (z) {
            this.brK.setVisibility(0);
            Vk();
            com.baidu.tbadk.core.util.aw.h(this.brH, com.baidu.tieba.u.more_all);
            com.baidu.tbadk.core.util.aw.h(this.brK, com.baidu.tieba.u.more_all);
            return;
        }
        this.brK.setVisibility(8);
        com.baidu.tbadk.core.util.aw.h(this.brH, com.baidu.tieba.u.more_all);
    }

    public void dO(boolean z) {
        TbadkApplication.m251getInst().getSkinType();
        if (z) {
            this.bsa.setVisibility(0);
            com.baidu.tbadk.core.util.aw.h(this.brX, com.baidu.tieba.u.more_all);
            com.baidu.tbadk.core.util.aw.h(this.bsa, com.baidu.tieba.u.more_all);
            return;
        }
        this.bsa.setVisibility(8);
        com.baidu.tbadk.core.util.aw.h(this.brX, com.baidu.tieba.u.more_all);
    }

    public void dP(boolean z) {
        if (this.bsO == null) {
            this.bsO = new am(this.brQ, 500);
        }
        TbadkApplication.m251getInst().getSkinType();
        if (z) {
            this.bsO.show();
            com.baidu.tbadk.core.util.aw.h(this.brN, com.baidu.tieba.u.more_all);
            com.baidu.tbadk.core.util.aw.h((View) this.brR, com.baidu.tieba.u.more_all);
            com.baidu.tbadk.core.util.aw.h((View) this.brT, com.baidu.tieba.u.more_all);
            com.baidu.tbadk.core.util.aw.h((View) this.brW, com.baidu.tieba.u.more_all);
            com.baidu.tbadk.core.util.aw.h((View) this.brU, com.baidu.tieba.u.more_all);
            com.baidu.tbadk.core.util.aw.h((View) this.brV, com.baidu.tieba.u.more_all);
            return;
        }
        this.bsO.hide();
        com.baidu.tbadk.core.util.aw.h(this.brN, com.baidu.tieba.u.more_all);
    }

    public void Vj() {
        String str;
        String str2;
        com.baidu.tieba.aj wm = com.baidu.tieba.aj.wm();
        if (wm.wB()) {
            if (wm.wC() > 9) {
                str = String.valueOf(wm.wC());
            } else {
                str = "0" + wm.wC();
            }
            if (wm.wE() > 9) {
                str2 = String.valueOf(wm.wE());
            } else {
                str2 = "0" + wm.wE();
            }
            this.bsc.setText(getContext().getString(com.baidu.tieba.y.sign_remind_time, str, str2));
            this.bsa.setVisibility(0);
            if (!this.brZ.gP()) {
                this.brZ.gN();
                return;
            }
            return;
        }
        this.bsc.setText(com.baidu.tieba.y.close);
        this.bsa.setVisibility(8);
        if (this.brZ.gP()) {
            this.brZ.gO();
        }
    }

    public void Vk() {
        this.brM.setText(String.valueOf(TbadkApplication.m251getInst().getNoDisturbStartTime()) + "-" + TbadkApplication.m251getInst().getNoDisturbEndTime());
        this.bsk.setText(TbadkApplication.m251getInst().getNoDisturbStartTime());
        this.bsn.setText(TbadkApplication.m251getInst().getNoDisturbEndTime());
    }

    public View Vl() {
        return this.bsf;
    }

    public View Vm() {
        return this.brZ;
    }

    public View Vn() {
        return this.brP;
    }

    public View Vo() {
        return this.bsa;
    }

    public View Vp() {
        return this.brJ;
    }

    public View Vq() {
        return this.brK;
    }

    public LinearLayout Vr() {
        return this.bsi;
    }

    public LinearLayout Vs() {
        return this.bsl;
    }

    public BdSwitchView Vt() {
        return this.bsq;
    }

    public BdSwitchView Vu() {
        return this.bst;
    }

    public BdSwitchView Vv() {
        return this.bsw;
    }

    public void dQ(boolean z) {
        if (this.bsx != z) {
            this.bsx = z;
            if (z) {
                this.atJ.setText(com.baidu.tieba.y.msg_remind);
                this.bsg.setVisibility(0);
                this.bsh.setVisibility(8);
                return;
            }
            this.atJ.setText(com.baidu.tieba.y.no_disturb_mode_time);
            this.bsh.setVisibility(0);
            this.bsg.setVisibility(8);
        }
    }
}
