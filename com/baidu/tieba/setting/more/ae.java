package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.ScreenLockActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class ae extends com.baidu.adp.base.f<MsgRemindActivity> {
    private TextView LM;
    private RelativeLayout brd;
    private LinearLayout cNA;
    private MsgSettingItemView2 cNB;
    private MsgSettingItemView2 cNC;
    private MsgSettingItemView2 cND;
    private MsgSettingItemView2 cNE;
    private MsgSettingItemView2 cNF;
    private MsgSettingItemView2 cNG;
    private MsgSettingItemView cNH;
    private MsgSettingItemView cNI;
    private MsgSettingItemView cNJ;
    private MsgSettingItemView cNK;
    private MsgSettingItemView cNL;
    private MsgSettingItemView cNM;
    private LinearLayout cNN;
    private TextView cNO;
    private MsgSettingItemView cNP;
    private MsgSettingItemView cNQ;
    private MsgSettingItemView cNR;
    private LinearLayout cNS;
    private TextView cNT;
    private LinearLayout cNU;
    private LinearLayout cNV;
    private LinearLayout cNW;
    private TextView cNX;
    private LinearLayout cNY;
    private TextView cNZ;
    private MsgSettingItemView cNz;
    public boolean cOa;
    private MsgRemindActivity cOb;
    private View mBack;
    private NavigationBar mNavigationBar;

    public ae(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.brd = null;
        this.mNavigationBar = null;
        this.LM = null;
        this.cOa = true;
        this.cOb = msgRemindActivity;
        msgRemindActivity.setContentView(i.g.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        asi();
        aso();
        asn();
        asm();
        asl();
        asj();
        asp();
        ask();
        d(msgRemindActivity);
        asd();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.brd = (RelativeLayout) msgRemindActivity.findViewById(i.f.parent);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(i.f.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cNU = (LinearLayout) msgRemindActivity.findViewById(i.f.front_container);
        this.cNV = (LinearLayout) msgRemindActivity.findViewById(i.f.back_container);
        this.LM = this.mNavigationBar.setTitleText(msgRemindActivity.getPageContext().getString(i.h.msg_remind));
        this.cNz = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.receive_message_swtich);
        this.cNz.setText(i.h.receive_msg_text);
        this.cNz.setLineVisibility(true);
        this.cNA = (LinearLayout) msgRemindActivity.findViewById(i.f.receive_message_container);
        this.cNB = (MsgSettingItemView2) msgRemindActivity.findViewById(i.f.reply_check_box);
        this.cNB.setText(i.h.frs_item_reply_text);
        this.cNC = (MsgSettingItemView2) msgRemindActivity.findViewById(i.f.zan_check_box);
        this.cNC.setText(i.h.frs_item_praise_text);
        this.cND = (MsgSettingItemView2) msgRemindActivity.findViewById(i.f.at_me_check_box);
        this.cND.setText(i.h.mention_atme);
        this.cNE = (MsgSettingItemView2) msgRemindActivity.findViewById(i.f.new_fans_swtich);
        this.cNE.setText(i.h.new_fans);
        this.cNF = (MsgSettingItemView2) msgRemindActivity.findViewById(i.f.chat_msg_swtich);
        this.cNF.setText(i.h.chat_msg_text);
        this.cNG = (MsgSettingItemView2) msgRemindActivity.findViewById(i.f.group_chat_swtich);
        this.cNG.setLineVisibility(false);
        this.cNG.setText(i.h.group_chat_text);
        this.cNH = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.screen_lock_swtich);
        this.cNH.setText(i.h.remind_screen_lock);
        this.cNI = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.chat_float_swtich);
        this.cNI.setLineVisibility(false);
        this.cNI.setText(i.h.chat_float_window);
        this.cNJ = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.tone_remind_swtich);
        this.cNJ.setText(i.h.remind_tone);
        this.cNK = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.vibrate_remind_swtich);
        this.cNK.setText(i.h.remind_vibrate);
        this.cNL = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.light_remind_swtich);
        this.cNL.setLineVisibility(true);
        this.cNL.setText(i.h.remind_light);
        this.cNM = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.sign_remind_swtich);
        this.cNM.setText(i.h.sign_remind_outline);
        this.cNN = (LinearLayout) msgRemindActivity.findViewById(i.f.sign_remind);
        this.cNO = (TextView) msgRemindActivity.findViewById(i.f.sign_remind_time);
        this.cNP = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.promoted_content_swtich);
        this.cNP.setLineVisibility(true);
        this.cNP.setText(i.h.promoted_message_text);
        this.cNR = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.no_disturb_swtich);
        this.cNR.setText(i.h.no_disturb_mode);
        this.cNS = (LinearLayout) msgRemindActivity.findViewById(i.f.no_disturb_mode_time_container);
        this.cNT = (TextView) msgRemindActivity.findViewById(i.f.no_disturb_mode_time_value);
        this.cNW = (LinearLayout) msgRemindActivity.findViewById(i.f.no_disturb_start_time);
        this.cNX = (TextView) msgRemindActivity.findViewById(i.f.no_disturb_start_time_value);
        this.cNY = (LinearLayout) msgRemindActivity.findViewById(i.f.no_disturb_end_time);
        this.cNZ = (TextView) msgRemindActivity.findViewById(i.f.no_disturb_end_time_value);
        this.cNQ = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.remind_recommend_swtich);
        this.cNQ.setLineVisibility(false);
        this.cNQ.setText(i.h.remind_message_recommend);
    }

    private void asd() {
        ase();
        asf();
        asg();
        ash();
    }

    private void ase() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.cNR.setVisibility(8);
            this.cNS.setVisibility(8);
            this.cNz.setVisibility(8);
            this.cNA.setVisibility(8);
            this.cNM.setVisibility(8);
            this.cNN.setVisibility(8);
            this.cNJ.setVisibility(8);
            this.cNK.setVisibility(8);
            this.cNL.setVisibility(8);
            this.cNH.setVisibility(8);
            this.cNI.setVisibility(8);
        }
    }

    private void asf() {
        boolean isMIUIRom = TbadkCoreApplication.m411getInst().isMIUIRom();
        if (TbadkCoreApplication.m411getInst().isFloatingWindowOpened() && !isMIUIRom) {
            this.cNI.setVisibility(0);
            this.cNH.setLineVisibility(true);
            return;
        }
        this.cNI.setVisibility(8);
        this.cNH.setLineVisibility(false);
    }

    private void asg() {
        boolean appResponseToIntentClass = TbadkCoreApplication.m411getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.cNF.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.cNG.setVisibility(0);
        } else {
            this.cNG.setVisibility(8);
        }
    }

    private void ash() {
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.cNH.setVisibility(0);
        } else {
            this.cNH.setVisibility(8);
        }
    }

    public View akd() {
        return this.mBack;
    }

    private void asi() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xh().xj()) {
            this.cNz.mz();
            this.cNA.setVisibility(0);
        } else {
            this.cNz.mA();
            this.cNA.setVisibility(8);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xh().xo()) {
            this.cNB.getSwitchView().setChecked(true);
        } else {
            this.cNB.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xh().xx()) {
            this.cNC.getSwitchView().setChecked(true);
        } else {
            this.cNC.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xh().xm()) {
            this.cND.getSwitchView().setChecked(true);
        } else {
            this.cND.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xh().xn()) {
            this.cNE.getSwitchView().setChecked(true);
        } else {
            this.cNE.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xh().xp()) {
            this.cNF.getSwitchView().setChecked(true);
        } else {
            this.cNF.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xh().xw()) {
            this.cNG.getSwitchView().setChecked(true);
        } else {
            this.cNG.getSwitchView().setChecked(false);
        }
    }

    private void asj() {
        if (TbadkCoreApplication.m411getInst().isPromotedMessageOn()) {
            this.cNP.mz();
        } else {
            this.cNP.mA();
        }
    }

    private void ask() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xh().xB()) {
            this.cNQ.mz();
        } else {
            this.cNQ.mA();
        }
    }

    private void asl() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xh().isSignAlertOn()) {
            this.cNM.mB();
            this.cNN.setVisibility(0);
            this.cNM.setLineVisibility(true);
            asq();
            return;
        }
        this.cNM.mC();
        this.cNM.setLineVisibility(false);
        this.cNN.setVisibility(8);
    }

    private void asm() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xh().xq()) {
            this.cNJ.mz();
        } else {
            this.cNJ.mA();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xh().xt()) {
            this.cNK.mz();
        } else {
            this.cNK.mA();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xh().xr()) {
            this.cNL.mz();
        } else {
            this.cNL.mA();
        }
    }

    private void asn() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xh().xy()) {
            this.cNI.mz();
        } else {
            this.cNI.mA();
        }
    }

    private void aso() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xh().xz()) {
            this.cNH.mz();
        } else {
            this.cNH.mA();
        }
    }

    private void asp() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xh().xs()) {
            this.cNR.mz();
            this.cNS.setVisibility(0);
            asr();
            return;
        }
        this.cNR.mA();
        this.cNS.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.mBack.setOnClickListener(msgRemindActivity);
        this.cNz.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cNB.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cND.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cNC.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cNE.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cNF.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cNG.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cNH.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cNI.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cNJ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cNK.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cNL.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cNM.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cNN.setOnClickListener(msgRemindActivity);
        this.cNP.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cNR.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cNS.setOnClickListener(msgRemindActivity);
        this.cNW.setOnClickListener(msgRemindActivity);
        this.cNY.setOnClickListener(msgRemindActivity);
        this.cNQ.setOnSwitchStateChangeListener(msgRemindActivity);
    }

    public void fZ(boolean z) {
        this.cNR.setLineVisibility(z);
        if (z) {
            this.cNS.setVisibility(0);
            asr();
            com.baidu.tbadk.core.util.am.i(this.cNS, i.e.more_all);
            return;
        }
        this.cNS.setVisibility(8);
    }

    public void ga(boolean z) {
        if (z) {
            this.cNN.setVisibility(0);
            this.cNM.setLineVisibility(true);
            com.baidu.tbadk.core.util.am.i(this.cNN, i.e.more_all);
            return;
        }
        this.cNN.setVisibility(8);
        this.cNM.setLineVisibility(false);
    }

    public void gb(boolean z) {
        if (z) {
            this.cNA.setVisibility(0);
        } else {
            this.cNA.setVisibility(8);
        }
    }

    public void asq() {
        String str;
        String str2;
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xh().isSignAlertOn()) {
            if (com.baidu.tbadk.coreExtra.messageCenter.c.xh().getSignAlertHours() > 9) {
                str = String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.xh().getSignAlertHours());
            } else {
                str = "0" + com.baidu.tbadk.coreExtra.messageCenter.c.xh().getSignAlertHours();
            }
            if (com.baidu.tbadk.coreExtra.messageCenter.c.xh().getSignAlertMins() > 9) {
                str2 = String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.xh().getSignAlertMins());
            } else {
                str2 = "0" + com.baidu.tbadk.coreExtra.messageCenter.c.xh().getSignAlertMins();
            }
            this.cNO.setText(this.cOb.getPageContext().getPageActivity().getString(i.h.sign_remind_time, new Object[]{str, str2}));
            this.cNN.setVisibility(0);
            if (!this.cNM.hx()) {
                this.cNM.mz();
                return;
            }
            return;
        }
        this.cNO.setText(i.h.close);
        this.cNN.setVisibility(8);
        if (this.cNM.hx()) {
            this.cNM.mA();
        }
    }

    public void asr() {
        this.cNT.setText(String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.xh().xu()) + "-" + com.baidu.tbadk.coreExtra.messageCenter.c.xh().xv());
        this.cNX.setText(com.baidu.tbadk.coreExtra.messageCenter.c.xh().xu());
        this.cNZ.setText(com.baidu.tbadk.coreExtra.messageCenter.c.xh().xv());
    }

    public BdSwitchView ass() {
        return this.cNQ.getSwitchView();
    }

    public BdSwitchView ast() {
        return this.cNP.getSwitchView();
    }

    public BdSwitchView asu() {
        return this.cNM.getSwitchView();
    }

    public BdSwitchView asv() {
        return this.cNz.getSwitchView();
    }

    public View asw() {
        return this.cNN;
    }

    public BdSwitchView asx() {
        return this.cNR.getSwitchView();
    }

    public View asy() {
        return this.cNS;
    }

    public LinearLayout asz() {
        return this.cNW;
    }

    public LinearLayout asA() {
        return this.cNY;
    }

    public BdSwitchView asB() {
        return this.cNJ.getSwitchView();
    }

    public BdSwitchView asC() {
        return this.cNK.getSwitchView();
    }

    public BdSwitchView asD() {
        return this.cNL.getSwitchView();
    }

    public BdSwitchView asE() {
        return this.cNH.getSwitchView();
    }

    public BdSwitchView asF() {
        return this.cNI.getSwitchView();
    }

    public CheckBox asG() {
        return this.cNB.getSwitchView();
    }

    public CheckBox asH() {
        return this.cNC.getSwitchView();
    }

    public CheckBox asI() {
        return this.cND.getSwitchView();
    }

    public CheckBox asJ() {
        return this.cNF.getSwitchView();
    }

    public CheckBox asK() {
        return this.cNG.getSwitchView();
    }

    public CheckBox asL() {
        return this.cNE.getSwitchView();
    }

    public void asM() {
        this.cNB.getSwitchView().setOnCheckedChangeListener(null);
        this.cNB.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.xh().xo());
        this.cNB.getSwitchView().setOnCheckedChangeListener(this.cOb);
    }

    public void asN() {
        this.cNC.getSwitchView().setOnCheckedChangeListener(null);
        this.cNC.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.xh().xx());
        this.cNC.getSwitchView().setOnCheckedChangeListener(this.cOb);
    }

    public void asO() {
        this.cND.getSwitchView().setOnCheckedChangeListener(null);
        this.cND.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.xh().xm());
        this.cND.getSwitchView().setOnCheckedChangeListener(this.cOb);
    }

    public void asP() {
        this.cNE.getSwitchView().setOnCheckedChangeListener(null);
        this.cNE.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.xh().xn());
        this.cNE.getSwitchView().setOnCheckedChangeListener(this.cOb);
    }

    public void asQ() {
        this.cNF.getSwitchView().setOnCheckedChangeListener(null);
        this.cNF.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.xh().xp());
        this.cNF.getSwitchView().setOnCheckedChangeListener(this.cOb);
    }

    public void asR() {
        this.cNG.getSwitchView().setOnCheckedChangeListener(null);
        this.cNG.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.xh().xw());
        this.cNG.getSwitchView().setOnCheckedChangeListener(this.cOb);
    }

    public void gc(boolean z) {
        if (this.cOa != z) {
            this.cOa = z;
            if (z) {
                this.LM.setText(i.h.msg_remind);
                this.cNU.setVisibility(0);
                this.cNV.setVisibility(8);
                return;
            }
            this.LM.setText(i.h.no_disturb_mode_time);
            this.cNV.setVisibility(0);
            this.cNU.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v11, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v13, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v15, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v17, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v19, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v21, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v25, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v27, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v29, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v31, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v33, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v47, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.cOb.getLayoutMode().ad(i == 1);
        this.cOb.getLayoutMode().k(this.brd);
        this.mNavigationBar.onChangeSkinType(this.cOb.getPageContext(), i);
        this.cNz.onChangeSkinType(this.cOb.getPageContext(), i);
        this.cNB.onChangeSkinType(this.cOb.getPageContext(), i);
        this.cNC.onChangeSkinType(this.cOb.getPageContext(), i);
        this.cND.onChangeSkinType(this.cOb.getPageContext(), i);
        this.cNE.onChangeSkinType(this.cOb.getPageContext(), i);
        this.cNF.onChangeSkinType(this.cOb.getPageContext(), i);
        this.cNG.onChangeSkinType(this.cOb.getPageContext(), i);
        this.cNH.onChangeSkinType(this.cOb.getPageContext(), i);
        this.cNI.onChangeSkinType(this.cOb.getPageContext(), i);
        this.cNJ.onChangeSkinType(this.cOb.getPageContext(), i);
        this.cNK.onChangeSkinType(this.cOb.getPageContext(), i);
        this.cNL.onChangeSkinType(this.cOb.getPageContext(), i);
        this.cNM.onChangeSkinType(this.cOb.getPageContext(), i);
        this.cNP.onChangeSkinType(this.cOb.getPageContext(), i);
        this.cNR.onChangeSkinType(this.cOb.getPageContext(), i);
        if (this.cNQ != null) {
            this.cNQ.onChangeSkinType(this.cOb.getPageContext(), i);
        }
        com.baidu.tbadk.core.util.am.i(this.cNS, i.e.more_all);
        com.baidu.tbadk.core.util.am.i(this.cNW, i.e.more_all);
        com.baidu.tbadk.core.util.am.i(this.cNY, i.e.more_all);
        com.baidu.tbadk.core.util.am.i(this.cNN, i.e.more_all);
        com.baidu.tbadk.core.util.am.c((ImageView) this.cNS.findViewById(i.f.no_disturb_mode_time_arrow), i.e.icon_arrow_right);
        com.baidu.tbadk.core.util.am.c((ImageView) this.cNN.findViewById(i.f.sign_remind_arrow), i.e.icon_arrow_right);
        com.baidu.tbadk.core.util.am.c((ImageView) this.cNW.findViewById(i.f.no_disturb_start_time_arrow), i.e.icon_arrow_right);
        com.baidu.tbadk.core.util.am.c((ImageView) this.cNY.findViewById(i.f.no_disturb_end_time_arrow), i.e.icon_arrow_right);
    }
}
