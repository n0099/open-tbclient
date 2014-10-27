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
    private View Js;
    private TextView atA;
    private TextView brA;
    private BdSwitchView brB;
    private LinearLayout brC;
    private CheckBox brD;
    private CheckBox brE;
    private CheckBox brF;
    private CheckBox brG;
    private CheckBox brH;
    private CheckBox brI;
    private LinearLayout brJ;
    private TextView brK;
    private BdSwitchView brL;
    private LinearLayout brM;
    private TextView brN;
    private TextView brO;
    private LinearLayout brP;
    private TextView brQ;
    private BdSwitchView brR;
    private LinearLayout brS;
    private LinearLayout brT;
    private LinearLayout brU;
    private TextView brV;
    private TextView brW;
    private LinearLayout brX;
    private TextView brY;
    private TextView brZ;
    private LinearLayout brt;
    private TextView bru;
    private BdSwitchView brv;
    private LinearLayout brw;
    private TextView brx;
    private TextView bry;
    private LinearLayout brz;
    private am bsA;
    private LinearLayout bsa;
    private TextView bsb;
    private BdSwitchView bsc;
    private LinearLayout bsd;
    private TextView bse;
    private BdSwitchView bsf;
    private LinearLayout bsg;
    private TextView bsh;
    private BdSwitchView bsi;
    public boolean bsj;
    private LinearLayout bsk;
    private LinearLayout bsl;
    private LinearLayout bsm;
    private LinearLayout bsn;
    private LinearLayout bso;
    private LinearLayout bsp;
    private LinearLayout bsq;
    private LinearLayout bsr;
    private LinearLayout bss;
    private LinearLayout bst;
    private LinearLayout bsu;
    private LinearLayout bsv;
    private LinearLayout bsw;
    private LinearLayout bsx;
    private LinearLayout bsy;
    private LinearLayout bsz;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public al(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity);
        this.brD = null;
        this.brE = null;
        this.brF = null;
        this.brG = null;
        this.brH = null;
        this.brI = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.atA = null;
        this.bsj = true;
        this.bsk = null;
        this.bsl = null;
        this.bsm = null;
        this.bsn = null;
        this.bso = null;
        this.bsp = null;
        this.bsq = null;
        this.bsr = null;
        this.bss = null;
        this.bst = null;
        this.bsu = null;
        this.bsv = null;
        this.bsw = null;
        this.bsx = null;
        this.bsy = null;
        this.bsz = null;
        this.mActivity = msgRemindActivity;
        msgRemindActivity.setContentView(com.baidu.tieba.w.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        c((BaseActivity) msgRemindActivity);
        Va();
        Vf();
        Vb();
        Vc();
        Vd();
        Ve();
        d(msgRemindActivity);
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.brt.setVisibility(8);
            this.brw.setVisibility(8);
            this.brz.setVisibility(8);
            this.brC.setVisibility(8);
            this.brJ.setVisibility(8);
            this.brM.setVisibility(8);
            this.bsa.setVisibility(8);
            this.bsd.setVisibility(8);
            this.bsg.setVisibility(8);
            this.bsk.setVisibility(8);
            this.bsl.setVisibility(8);
            this.bsm.setVisibility(8);
            this.bsn.setVisibility(8);
            this.bso.setVisibility(8);
            this.bsp.setVisibility(8);
            this.bsq.setVisibility(8);
            this.bsr.setVisibility(8);
            this.bss.setVisibility(8);
            this.bst.setVisibility(8);
            this.bsu.setVisibility(8);
            this.bsv.setVisibility(8);
            this.bsw.setVisibility(8);
            this.bsx.setVisibility(8);
            this.bsy.setVisibility(8);
            this.bsz.setVisibility(8);
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
        com.baidu.tbadk.core.util.aw.h(this.brt, com.baidu.tieba.u.more_all);
        com.baidu.tbadk.core.util.aw.h(this.brw, com.baidu.tieba.u.more_all);
        this.brv.setSwitchStyle(switchStyle);
        com.baidu.tbadk.core.util.aw.h(this.brU, com.baidu.tieba.u.more_all);
        com.baidu.tbadk.core.util.aw.h(this.brX, com.baidu.tieba.u.more_all);
        com.baidu.tbadk.core.util.aw.h(this.brz, com.baidu.tieba.u.more_all);
        com.baidu.tbadk.core.util.aw.h((View) this.brD, com.baidu.tieba.u.more_all);
        com.baidu.tbadk.core.util.aw.h((View) this.brE, com.baidu.tieba.u.more_all);
        com.baidu.tbadk.core.util.aw.h((View) this.brF, com.baidu.tieba.u.more_all);
        com.baidu.tbadk.core.util.aw.h((View) this.brG, com.baidu.tieba.u.more_all);
        com.baidu.tbadk.core.util.aw.h((View) this.brI, com.baidu.tieba.u.more_all);
        com.baidu.tbadk.core.util.aw.h((View) this.brH, com.baidu.tieba.u.more_all);
        this.brB.setSwitchStyle(switchStyle);
        com.baidu.tbadk.core.util.aw.h(this.brJ, com.baidu.tieba.u.more_all);
        com.baidu.tbadk.core.util.aw.h(this.brM, com.baidu.tieba.u.more_all);
        this.brL.setSwitchStyle(switchStyle);
        com.baidu.tbadk.core.util.aw.c((ImageView) this.brw.findViewById(com.baidu.tieba.v.no_disturb_mode_time_arrow), com.baidu.tieba.u.icon_arrow_right);
        com.baidu.tbadk.core.util.aw.c((ImageView) this.brM.findViewById(com.baidu.tieba.v.sign_remind_arrow), com.baidu.tieba.u.icon_arrow_right);
        com.baidu.tbadk.core.util.aw.c((ImageView) this.brU.findViewById(com.baidu.tieba.v.no_disturb_start_time_arrow), com.baidu.tieba.u.icon_arrow_right);
        com.baidu.tbadk.core.util.aw.c((ImageView) this.brX.findViewById(com.baidu.tieba.v.no_disturb_end_time_arrow), com.baidu.tieba.u.icon_arrow_right);
        com.baidu.tbadk.core.util.aw.h(this.brP, com.baidu.tieba.u.more_all);
        this.brR.setSwitchStyle(switchStyle);
        com.baidu.tbadk.core.util.aw.h(this.bsa, com.baidu.tieba.u.more_all);
        this.bsc.setSwitchStyle(switchStyle);
        com.baidu.tbadk.core.util.aw.h(this.bsd, com.baidu.tieba.u.more_all);
        this.bsf.setSwitchStyle(switchStyle);
        com.baidu.tbadk.core.util.aw.h(this.bsg, com.baidu.tieba.u.more_all);
        this.bsi.setSwitchStyle(switchStyle);
        this.bru.setTextColor(bx);
        this.brx.setTextColor(bx);
        this.bry.setTextColor(i2);
        this.brV.setTextColor(bx);
        this.brW.setTextColor(i2);
        this.brY.setTextColor(bx);
        this.brZ.setTextColor(i2);
        this.brA.setTextColor(bx);
        this.brD.setTextColor(bx);
        this.brE.setTextColor(bx);
        this.brF.setTextColor(bx);
        this.brI.setTextColor(bx);
        this.brG.setTextColor(bx);
        this.brH.setTextColor(bx);
        this.brK.setTextColor(bx);
        this.brN.setTextColor(bx);
        this.brO.setTextColor(i2);
        this.brQ.setTextColor(bx);
        this.bsb.setTextColor(bx);
        this.bse.setTextColor(bx);
        this.bsh.setTextColor(bx);
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.mParent = (RelativeLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.parent);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.Js = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.atA = this.mNavigationBar.setTitleText(msgRemindActivity.getString(com.baidu.tieba.y.msg_remind));
        this.brt = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_mode_container);
        this.brt.setClickable(false);
        this.bru = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_mode_text);
        this.brv = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_mode_switch);
        this.brw = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_mode_time_container);
        this.brx = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_mode_time_text);
        this.bry = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_mode_time_value);
        this.brz = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.message_remind_container);
        this.brz.setClickable(false);
        this.brA = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.message_remind_text);
        this.brB = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.v.message_remind_switch);
        this.brC = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.message_remind_value);
        this.brD = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.v.check_replyme);
        this.brE = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.v.check_zan);
        this.brF = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.v.check_atme);
        this.brI = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.v.check_new_fans);
        this.brJ = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.sign_remind_on);
        this.brJ.setClickable(false);
        this.brK = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.sign_remind_on_text);
        this.brL = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.v.sign_remind_on_switch);
        this.brM = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.sign_remind);
        this.brN = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.sign_remind_text);
        this.brO = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.sign_remind_time);
        this.brP = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.promoted_message);
        this.brP.setClickable(false);
        this.brQ = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.promoted_message_text);
        this.brR = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.v.promoted_message_switch);
        this.brG = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.v.check_chatmessage);
        this.brH = (CheckBox) msgRemindActivity.findViewById(com.baidu.tieba.v.check_groupmessage);
        this.brS = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.front_container);
        this.brT = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.back_container);
        this.brU = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_start_time);
        this.brV = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_start_time_text);
        this.brW = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_start_time_value);
        this.brX = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_end_time);
        this.brY = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_end_time_text);
        this.brZ = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_end_time_value);
        this.bsa = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.remind_tone);
        this.bsa.setClickable(false);
        this.bsb = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.tone_text);
        this.bsc = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.v.remind_tone_switch);
        this.bsd = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.remind_vibrate);
        this.bsd.setClickable(false);
        this.bse = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.vibrate_text);
        this.bsf = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.v.remind_vibrate_switch);
        this.bsg = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.remid_light);
        this.bsg.setClickable(false);
        this.bsh = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.light_text);
        this.bsi = (BdSwitchView) msgRemindActivity.findViewById(com.baidu.tieba.v.remind_light_switch);
    }

    private void c(BaseActivity baseActivity) {
        this.bsk = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.line1_layout);
        this.bsl = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.line2_layout);
        this.bsm = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.line3_layout);
        this.bsn = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.line4_layout);
        this.bso = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.line5_layout);
        this.bsp = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.line6_layout);
        this.bsq = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.line7_layout);
        this.bsr = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.line8_layout);
        this.bss = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.line9_layout);
        this.bst = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.line10_layout);
        this.bsu = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.line11_layout);
        this.bsv = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.line12_layout);
        this.bsw = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.line13_layout);
        this.bsx = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.line14_layout);
        this.bsy = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.line15_layout);
        this.bsz = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.line16_layout);
    }

    public View xO() {
        return this.Js;
    }

    public void dK(boolean z) {
        if (z) {
            this.bsl.setVisibility(0);
        } else {
            this.bsl.setVisibility(8);
        }
    }

    public void dL(boolean z) {
        if (z) {
            this.bsr.setPadding(this.mActivity.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds30), 0, this.mActivity.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds30), 0);
        } else {
            this.bsr.setPadding(0, 0, 0, 0);
        }
    }

    public void dM(boolean z) {
        if (z) {
            this.bsy.setVisibility(0);
        } else {
            this.bsy.setVisibility(8);
        }
    }

    private void Va() {
        if (TbadkApplication.m251getInst().isNoDisturbOn()) {
            this.brv.gN();
            this.brw.setVisibility(0);
            Vh();
            this.bsl.setVisibility(0);
            return;
        }
        this.brv.gO();
        this.brw.setVisibility(8);
        this.bsl.setVisibility(8);
    }

    private void Vb() {
        if (TbadkApplication.m251getInst().isMsgRemindOn()) {
            this.bsr.setPadding(this.mActivity.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds30), 0, this.mActivity.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds30), 0);
        } else {
            this.bsr.setPadding(0, 0, 0, 0);
        }
        if (TbadkApplication.m251getInst().isMsgReplymeOn()) {
            this.brD.setChecked(true);
        }
        if (TbadkApplication.m251getInst().isMsgZanOn()) {
            this.brE.setChecked(true);
        }
        if (TbadkApplication.m251getInst().isMsgAtmeOn()) {
            this.brF.setChecked(true);
        }
        this.brI.setChecked(TbadkApplication.m251getInst().isMsgNewFansOn());
        if (TbadkApplication.m251getInst().isMsgChatOn()) {
            this.brG.setChecked(true);
        }
        if (TbadkApplication.m251getInst().isGroupMsgOn()) {
            this.brH.setChecked(true);
        }
    }

    private void Vc() {
        if (TbadkApplication.m251getInst().isPromotedMessageOn()) {
            this.brR.gN();
        } else {
            this.brR.gO();
        }
    }

    private void Vd() {
        if (com.baidu.tieba.aj.wk().wz()) {
            this.brL.gN();
            this.brM.setVisibility(0);
            Vg();
            this.bsy.setVisibility(0);
            return;
        }
        this.brL.gO();
        this.brM.setVisibility(8);
        this.bsy.setVisibility(8);
    }

    private void Ve() {
        if (TbadkApplication.m251getInst().isMsgToneOn()) {
            this.bsc.gN();
        } else {
            this.bsc.gO();
        }
        if (TbadkApplication.m251getInst().isMsgVibrateOn()) {
            this.bsf.gN();
        } else {
            this.bsf.gO();
        }
        if (TbadkApplication.m251getInst().isMsgLightOn()) {
            this.bsi.gN();
        } else {
            this.bsi.gO();
        }
    }

    private void Vf() {
        if (TbadkApplication.m251getInst().isMsgRemindOn()) {
            this.brB.gN();
            this.brC.setVisibility(0);
            return;
        }
        this.brB.gO();
        this.brC.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.brB.setOnSwitchStateChangeListener(msgRemindActivity);
        this.brL.setOnSwitchStateChangeListener(msgRemindActivity);
        this.brR.setOnSwitchStateChangeListener(msgRemindActivity);
        this.brv.setOnSwitchStateChangeListener(msgRemindActivity);
        this.brD.setOnCheckedChangeListener(msgRemindActivity);
        this.brE.setOnCheckedChangeListener(msgRemindActivity);
        this.brF.setOnCheckedChangeListener(msgRemindActivity);
        this.brI.setOnCheckedChangeListener(msgRemindActivity);
        this.brG.setOnCheckedChangeListener(msgRemindActivity);
        this.brH.setOnCheckedChangeListener(msgRemindActivity);
        this.brM.setOnClickListener(msgRemindActivity);
        this.brw.setOnClickListener(msgRemindActivity);
        this.brU.setOnClickListener(msgRemindActivity);
        this.brX.setOnClickListener(msgRemindActivity);
        this.bsc.setOnSwitchStateChangeListener(msgRemindActivity);
        this.bsf.setOnSwitchStateChangeListener(msgRemindActivity);
        this.bsi.setOnSwitchStateChangeListener(msgRemindActivity);
    }

    public void dN(boolean z) {
        TbadkApplication.m251getInst().getSkinType();
        if (z) {
            this.brw.setVisibility(0);
            Vh();
            com.baidu.tbadk.core.util.aw.h(this.brt, com.baidu.tieba.u.more_all);
            com.baidu.tbadk.core.util.aw.h(this.brw, com.baidu.tieba.u.more_all);
            return;
        }
        this.brw.setVisibility(8);
        com.baidu.tbadk.core.util.aw.h(this.brt, com.baidu.tieba.u.more_all);
    }

    public void dO(boolean z) {
        TbadkApplication.m251getInst().getSkinType();
        if (z) {
            this.brM.setVisibility(0);
            com.baidu.tbadk.core.util.aw.h(this.brJ, com.baidu.tieba.u.more_all);
            com.baidu.tbadk.core.util.aw.h(this.brM, com.baidu.tieba.u.more_all);
            return;
        }
        this.brM.setVisibility(8);
        com.baidu.tbadk.core.util.aw.h(this.brJ, com.baidu.tieba.u.more_all);
    }

    public void dP(boolean z) {
        if (this.bsA == null) {
            this.bsA = new am(this.brC, 500);
        }
        TbadkApplication.m251getInst().getSkinType();
        if (z) {
            this.bsA.show();
            com.baidu.tbadk.core.util.aw.h(this.brz, com.baidu.tieba.u.more_all);
            com.baidu.tbadk.core.util.aw.h((View) this.brD, com.baidu.tieba.u.more_all);
            com.baidu.tbadk.core.util.aw.h((View) this.brF, com.baidu.tieba.u.more_all);
            com.baidu.tbadk.core.util.aw.h((View) this.brI, com.baidu.tieba.u.more_all);
            com.baidu.tbadk.core.util.aw.h((View) this.brG, com.baidu.tieba.u.more_all);
            com.baidu.tbadk.core.util.aw.h((View) this.brH, com.baidu.tieba.u.more_all);
            return;
        }
        this.bsA.hide();
        com.baidu.tbadk.core.util.aw.h(this.brz, com.baidu.tieba.u.more_all);
    }

    public void Vg() {
        String str;
        String str2;
        com.baidu.tieba.aj wk = com.baidu.tieba.aj.wk();
        if (wk.wz()) {
            if (wk.wA() > 9) {
                str = String.valueOf(wk.wA());
            } else {
                str = "0" + wk.wA();
            }
            if (wk.wC() > 9) {
                str2 = String.valueOf(wk.wC());
            } else {
                str2 = "0" + wk.wC();
            }
            this.brO.setText(getContext().getString(com.baidu.tieba.y.sign_remind_time, str, str2));
            this.brM.setVisibility(0);
            if (!this.brL.gP()) {
                this.brL.gN();
                return;
            }
            return;
        }
        this.brO.setText(com.baidu.tieba.y.close);
        this.brM.setVisibility(8);
        if (this.brL.gP()) {
            this.brL.gO();
        }
    }

    public void Vh() {
        this.bry.setText(String.valueOf(TbadkApplication.m251getInst().getNoDisturbStartTime()) + "-" + TbadkApplication.m251getInst().getNoDisturbEndTime());
        this.brW.setText(TbadkApplication.m251getInst().getNoDisturbStartTime());
        this.brZ.setText(TbadkApplication.m251getInst().getNoDisturbEndTime());
    }

    public View Vi() {
        return this.brR;
    }

    public View Vj() {
        return this.brL;
    }

    public View Vk() {
        return this.brB;
    }

    public View Vl() {
        return this.brM;
    }

    public View Vm() {
        return this.brv;
    }

    public View Vn() {
        return this.brw;
    }

    public LinearLayout Vo() {
        return this.brU;
    }

    public LinearLayout Vp() {
        return this.brX;
    }

    public BdSwitchView Vq() {
        return this.bsc;
    }

    public BdSwitchView Vr() {
        return this.bsf;
    }

    public BdSwitchView Vs() {
        return this.bsi;
    }

    public void dQ(boolean z) {
        if (this.bsj != z) {
            this.bsj = z;
            if (z) {
                this.atA.setText(com.baidu.tieba.y.msg_remind);
                this.brS.setVisibility(0);
                this.brT.setVisibility(8);
                return;
            }
            this.atA.setText(com.baidu.tieba.y.no_disturb_mode_time);
            this.brT.setVisibility(0);
            this.brS.setVisibility(8);
        }
    }
}
