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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class aj extends com.baidu.adp.base.f<MsgRemindActivity> {
    private TextView MR;
    private View ajA;
    private RelativeLayout bYK;
    private MsgSettingItemView edE;
    private LinearLayout edF;
    private MsgSettingItemView2 edG;
    private MsgSettingItemView2 edH;
    private MsgSettingItemView2 edI;
    private MsgSettingItemView2 edJ;
    private MsgSettingItemView2 edK;
    private MsgSettingItemView2 edL;
    private MsgSettingItemView edM;
    private MsgSettingItemView edN;
    private MsgSettingItemView edO;
    private MsgSettingItemView edP;
    private MsgSettingItemView edQ;
    private MsgSettingItemView edR;
    private LinearLayout edS;
    private TextView edT;
    private MsgSettingItemView edU;
    private MsgSettingItemView edV;
    private MsgSettingItemView edW;
    private MsgSettingItemView edX;
    private LinearLayout edY;
    private TextView edZ;
    private LinearLayout eea;
    private LinearLayout eeb;
    private LinearLayout eec;
    private TextView eed;
    private LinearLayout eee;
    private TextView eef;
    public boolean eeg;
    private MsgRemindActivity eeh;
    private NavigationBar mNavigationBar;

    public aj(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.bYK = null;
        this.mNavigationBar = null;
        this.MR = null;
        this.eeg = true;
        this.eeh = msgRemindActivity;
        msgRemindActivity.setContentView(t.h.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        aOs();
        aOz();
        aOy();
        aOx();
        aOw();
        aOt();
        aOA();
        aOu();
        aOv();
        d(msgRemindActivity);
        aOn();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.bYK = (RelativeLayout) msgRemindActivity.findViewById(t.g.parent);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(t.g.view_navigation_bar);
        this.ajA = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eea = (LinearLayout) msgRemindActivity.findViewById(t.g.front_container);
        this.eeb = (LinearLayout) msgRemindActivity.findViewById(t.g.back_container);
        this.MR = this.mNavigationBar.setTitleText(msgRemindActivity.getPageContext().getString(t.j.msg_remind));
        this.edE = (MsgSettingItemView) msgRemindActivity.findViewById(t.g.receive_message_swtich);
        this.edE.setText(t.j.receive_msg_text);
        this.edE.setLineVisibility(true);
        this.edF = (LinearLayout) msgRemindActivity.findViewById(t.g.receive_message_container);
        this.edG = (MsgSettingItemView2) msgRemindActivity.findViewById(t.g.reply_check_box);
        this.edG.setText(t.j.frs_item_reply_text);
        this.edH = (MsgSettingItemView2) msgRemindActivity.findViewById(t.g.zan_check_box);
        if (!com.baidu.tieba.graffiti.d.af(this.edH)) {
            this.edH.setVisibility(8);
        } else {
            this.edH.setVisibility(0);
            this.edH.setText(t.j.frs_item_praise_text);
        }
        this.edI = (MsgSettingItemView2) msgRemindActivity.findViewById(t.g.at_me_check_box);
        this.edI.setText(t.j.mention_atme);
        this.edJ = (MsgSettingItemView2) msgRemindActivity.findViewById(t.g.new_fans_swtich);
        this.edJ.setText(t.j.new_fans);
        this.edK = (MsgSettingItemView2) msgRemindActivity.findViewById(t.g.chat_msg_swtich);
        this.edK.setText(t.j.chat_msg_text);
        this.edL = (MsgSettingItemView2) msgRemindActivity.findViewById(t.g.group_chat_swtich);
        this.edL.setLineVisibility(false);
        this.edL.setText(t.j.group_chat_text);
        this.edM = (MsgSettingItemView) msgRemindActivity.findViewById(t.g.screen_lock_swtich);
        this.edM.setText(t.j.remind_screen_lock);
        this.edN = (MsgSettingItemView) msgRemindActivity.findViewById(t.g.chat_float_swtich);
        this.edN.setLineVisibility(false);
        this.edN.setText(t.j.chat_float_window);
        this.edO = (MsgSettingItemView) msgRemindActivity.findViewById(t.g.tone_remind_swtich);
        this.edO.setText(t.j.remind_tone);
        this.edP = (MsgSettingItemView) msgRemindActivity.findViewById(t.g.vibrate_remind_swtich);
        this.edP.setText(t.j.remind_vibrate);
        this.edQ = (MsgSettingItemView) msgRemindActivity.findViewById(t.g.light_remind_swtich);
        this.edQ.setLineVisibility(true);
        this.edQ.setText(t.j.remind_light);
        this.edR = (MsgSettingItemView) msgRemindActivity.findViewById(t.g.sign_remind_swtich);
        this.edR.setText(t.j.sign_remind_outline);
        this.edS = (LinearLayout) msgRemindActivity.findViewById(t.g.sign_remind);
        this.edT = (TextView) msgRemindActivity.findViewById(t.g.sign_remind_time);
        this.edU = (MsgSettingItemView) msgRemindActivity.findViewById(t.g.promoted_content_swtich);
        this.edU.setLineVisibility(true);
        this.edU.setText(t.j.promoted_message_text);
        this.edX = (MsgSettingItemView) msgRemindActivity.findViewById(t.g.no_disturb_swtich);
        this.edX.setText(t.j.no_disturb_mode);
        this.edY = (LinearLayout) msgRemindActivity.findViewById(t.g.no_disturb_mode_time_container);
        this.edZ = (TextView) msgRemindActivity.findViewById(t.g.no_disturb_mode_time_value);
        this.eec = (LinearLayout) msgRemindActivity.findViewById(t.g.no_disturb_start_time);
        this.eed = (TextView) msgRemindActivity.findViewById(t.g.no_disturb_start_time_value);
        this.eee = (LinearLayout) msgRemindActivity.findViewById(t.g.no_disturb_end_time);
        this.eef = (TextView) msgRemindActivity.findViewById(t.g.no_disturb_end_time_value);
        this.edV = (MsgSettingItemView) msgRemindActivity.findViewById(t.g.remind_forum_broadcast_swtich);
        this.edV.setLineVisibility(true);
        this.edV.setText(t.j.forum_broadcast_message);
        this.edW = (MsgSettingItemView) msgRemindActivity.findViewById(t.g.remind_recommend_swtich);
        this.edW.setLineVisibility(false);
        this.edW.setText(t.j.remind_message_recommend);
    }

    private void aOn() {
        aOo();
        aOp();
        aOq();
        aOr();
    }

    private void aOo() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.edX.setVisibility(8);
            this.edY.setVisibility(8);
            this.edE.setVisibility(8);
            this.edF.setVisibility(8);
            this.edR.setVisibility(8);
            this.edS.setVisibility(8);
            this.edO.setVisibility(8);
            this.edP.setVisibility(8);
            this.edQ.setVisibility(8);
            this.edM.setVisibility(8);
            this.edN.setVisibility(8);
        }
    }

    private void aOp() {
        boolean isMIUIRom = TbadkCoreApplication.m411getInst().isMIUIRom();
        if (TbadkCoreApplication.m411getInst().isFloatingWindowOpened() && !isMIUIRom) {
            this.edN.setVisibility(0);
            this.edM.setLineVisibility(true);
            return;
        }
        this.edN.setVisibility(8);
        this.edM.setLineVisibility(false);
    }

    private void aOq() {
        boolean appResponseToIntentClass = TbadkCoreApplication.m411getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.edK.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.edL.setVisibility(0);
        } else {
            this.edL.setVisibility(8);
        }
    }

    private void aOr() {
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.edM.setVisibility(0);
        } else {
            this.edM.setVisibility(8);
        }
    }

    public View aDR() {
        return this.ajA;
    }

    private void aOs() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.zM().zO()) {
            this.edE.mi();
            this.edF.setVisibility(0);
        } else {
            this.edE.mj();
            this.edF.setVisibility(8);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.zM().zT()) {
            this.edG.getSwitchView().setChecked(true);
        } else {
            this.edG.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.zM().Ac()) {
            this.edH.getSwitchView().setChecked(true);
        } else {
            this.edH.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.zM().zR()) {
            this.edI.getSwitchView().setChecked(true);
        } else {
            this.edI.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.zM().zS()) {
            this.edJ.getSwitchView().setChecked(true);
        } else {
            this.edJ.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.zM().zU()) {
            this.edK.getSwitchView().setChecked(true);
        } else {
            this.edK.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.zM().Ab()) {
            this.edL.getSwitchView().setChecked(true);
        } else {
            this.edL.getSwitchView().setChecked(false);
        }
    }

    private void aOt() {
        if (TbadkCoreApplication.m411getInst().isPromotedMessageOn()) {
            this.edU.mi();
        } else {
            this.edU.mj();
        }
    }

    public void aOu() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.zM().Ah()) {
            this.edV.mi();
        } else {
            this.edV.mj();
        }
    }

    private void aOv() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.zM().Ag()) {
            this.edW.mi();
        } else {
            this.edW.mj();
        }
    }

    private void aOw() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.zM().isSignAlertOn()) {
            this.edR.mk();
            this.edS.setVisibility(0);
            this.edR.setLineVisibility(true);
            aOB();
            return;
        }
        this.edR.ml();
        this.edR.setLineVisibility(false);
        this.edS.setVisibility(8);
    }

    private void aOx() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.zM().zV()) {
            this.edO.mi();
        } else {
            this.edO.mj();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.zM().zY()) {
            this.edP.mi();
        } else {
            this.edP.mj();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.zM().zW()) {
            this.edQ.mi();
        } else {
            this.edQ.mj();
        }
    }

    private void aOy() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.zM().Ad()) {
            this.edN.mi();
        } else {
            this.edN.mj();
        }
    }

    private void aOz() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.zM().Ae()) {
            this.edM.mi();
        } else {
            this.edM.mj();
        }
    }

    private void aOA() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.zM().zX()) {
            this.edX.mi();
            this.edY.setVisibility(0);
            aOC();
            return;
        }
        this.edX.mj();
        this.edY.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.ajA.setOnClickListener(msgRemindActivity);
        this.edE.setOnSwitchStateChangeListener(msgRemindActivity);
        this.edG.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.edI.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.edH.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.edJ.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.edK.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.edL.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.edM.setOnSwitchStateChangeListener(msgRemindActivity);
        this.edN.setOnSwitchStateChangeListener(msgRemindActivity);
        this.edO.setOnSwitchStateChangeListener(msgRemindActivity);
        this.edP.setOnSwitchStateChangeListener(msgRemindActivity);
        this.edQ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.edR.setOnSwitchStateChangeListener(msgRemindActivity);
        this.edS.setOnClickListener(msgRemindActivity);
        this.edU.setOnSwitchStateChangeListener(msgRemindActivity);
        this.edX.setOnSwitchStateChangeListener(msgRemindActivity);
        this.edY.setOnClickListener(msgRemindActivity);
        this.eec.setOnClickListener(msgRemindActivity);
        this.eee.setOnClickListener(msgRemindActivity);
        this.edV.setOnSwitchStateChangeListener(msgRemindActivity);
        this.edW.setOnSwitchStateChangeListener(msgRemindActivity);
    }

    public void ip(boolean z) {
        this.edX.setLineVisibility(z);
        if (z) {
            this.edY.setVisibility(0);
            aOC();
            com.baidu.tbadk.core.util.at.k(this.edY, t.f.more_all);
            return;
        }
        this.edY.setVisibility(8);
    }

    public void iq(boolean z) {
        if (z) {
            this.edS.setVisibility(0);
            this.edR.setLineVisibility(true);
            com.baidu.tbadk.core.util.at.k(this.edS, t.f.more_all);
            return;
        }
        this.edS.setVisibility(8);
        this.edR.setLineVisibility(false);
    }

    public void ir(boolean z) {
        if (z) {
            this.edF.setVisibility(0);
        } else {
            this.edF.setVisibility(8);
        }
    }

    public void aOB() {
        String str;
        String str2;
        if (com.baidu.tbadk.coreExtra.messageCenter.c.zM().isSignAlertOn()) {
            if (com.baidu.tbadk.coreExtra.messageCenter.c.zM().getSignAlertHours() > 9) {
                str = String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.zM().getSignAlertHours());
            } else {
                str = "0" + com.baidu.tbadk.coreExtra.messageCenter.c.zM().getSignAlertHours();
            }
            if (com.baidu.tbadk.coreExtra.messageCenter.c.zM().getSignAlertMins() > 9) {
                str2 = String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.zM().getSignAlertMins());
            } else {
                str2 = "0" + com.baidu.tbadk.coreExtra.messageCenter.c.zM().getSignAlertMins();
            }
            this.edT.setText(this.eeh.getPageContext().getPageActivity().getString(t.j.sign_remind_time, new Object[]{str, str2}));
            this.edS.setVisibility(0);
            if (!this.edR.hO()) {
                this.edR.mi();
                return;
            }
            return;
        }
        this.edT.setText(t.j.close);
        this.edS.setVisibility(8);
        if (this.edR.hO()) {
            this.edR.mj();
        }
    }

    public void aOC() {
        this.edZ.setText(String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.zM().zZ()) + "-" + com.baidu.tbadk.coreExtra.messageCenter.c.zM().Aa());
        this.eed.setText(com.baidu.tbadk.coreExtra.messageCenter.c.zM().zZ());
        this.eef.setText(com.baidu.tbadk.coreExtra.messageCenter.c.zM().Aa());
    }

    public BdSwitchView aOD() {
        return this.edW.getSwitchView();
    }

    public BdSwitchView aOE() {
        return this.edU.getSwitchView();
    }

    public BdSwitchView aOF() {
        return this.edV.getSwitchView();
    }

    public BdSwitchView aOG() {
        return this.edR.getSwitchView();
    }

    public BdSwitchView aOH() {
        return this.edE.getSwitchView();
    }

    public View aOI() {
        return this.edS;
    }

    public BdSwitchView aOJ() {
        return this.edX.getSwitchView();
    }

    public View aOK() {
        return this.edY;
    }

    public LinearLayout aOL() {
        return this.eec;
    }

    public LinearLayout aOM() {
        return this.eee;
    }

    public BdSwitchView aON() {
        return this.edO.getSwitchView();
    }

    public BdSwitchView aOO() {
        return this.edP.getSwitchView();
    }

    public BdSwitchView aOP() {
        return this.edQ.getSwitchView();
    }

    public BdSwitchView aOQ() {
        return this.edM.getSwitchView();
    }

    public BdSwitchView aOR() {
        return this.edN.getSwitchView();
    }

    public CheckBox aOS() {
        return this.edG.getSwitchView();
    }

    public CheckBox aOT() {
        return this.edH.getSwitchView();
    }

    public CheckBox aOU() {
        return this.edI.getSwitchView();
    }

    public CheckBox aOV() {
        return this.edK.getSwitchView();
    }

    public CheckBox aOW() {
        return this.edL.getSwitchView();
    }

    public CheckBox aOX() {
        return this.edJ.getSwitchView();
    }

    public void aOY() {
        this.edG.getSwitchView().setOnCheckedChangeListener(null);
        this.edG.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.zM().zT());
        this.edG.getSwitchView().setOnCheckedChangeListener(this.eeh);
    }

    public void aOZ() {
        this.edH.getSwitchView().setOnCheckedChangeListener(null);
        this.edH.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.zM().Ac());
        this.edH.getSwitchView().setOnCheckedChangeListener(this.eeh);
    }

    public void aPa() {
        this.edI.getSwitchView().setOnCheckedChangeListener(null);
        this.edI.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.zM().zR());
        this.edI.getSwitchView().setOnCheckedChangeListener(this.eeh);
    }

    public void aPb() {
        this.edJ.getSwitchView().setOnCheckedChangeListener(null);
        this.edJ.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.zM().zS());
        this.edJ.getSwitchView().setOnCheckedChangeListener(this.eeh);
    }

    public void aPc() {
        this.edK.getSwitchView().setOnCheckedChangeListener(null);
        this.edK.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.zM().zU());
        this.edK.getSwitchView().setOnCheckedChangeListener(this.eeh);
    }

    public void aPd() {
        this.edL.getSwitchView().setOnCheckedChangeListener(null);
        this.edL.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.zM().Ab());
        this.edL.getSwitchView().setOnCheckedChangeListener(this.eeh);
    }

    public void is(boolean z) {
        if (this.eeg != z) {
            this.eeg = z;
            if (z) {
                this.MR.setText(t.j.msg_remind);
                this.eea.setVisibility(0);
                this.eeb.setVisibility(8);
                return;
            }
            this.MR.setText(t.j.no_disturb_mode_time);
            this.eeb.setVisibility(0);
            this.eea.setVisibility(8);
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
        this.eeh.getLayoutMode().ab(i == 1);
        this.eeh.getLayoutMode().x(this.bYK);
        this.mNavigationBar.onChangeSkinType(this.eeh.getPageContext(), i);
        this.edE.d(this.eeh.getPageContext(), i);
        this.edG.d(this.eeh.getPageContext(), i);
        this.edH.d(this.eeh.getPageContext(), i);
        this.edI.d(this.eeh.getPageContext(), i);
        this.edJ.d(this.eeh.getPageContext(), i);
        this.edK.d(this.eeh.getPageContext(), i);
        this.edL.d(this.eeh.getPageContext(), i);
        this.edM.d(this.eeh.getPageContext(), i);
        this.edN.d(this.eeh.getPageContext(), i);
        this.edO.d(this.eeh.getPageContext(), i);
        this.edP.d(this.eeh.getPageContext(), i);
        this.edQ.d(this.eeh.getPageContext(), i);
        this.edR.d(this.eeh.getPageContext(), i);
        this.edU.d(this.eeh.getPageContext(), i);
        this.edX.d(this.eeh.getPageContext(), i);
        if (this.edW != null) {
            this.edW.d(this.eeh.getPageContext(), i);
        }
        com.baidu.tbadk.core.util.at.k(this.edY, t.f.more_all);
        com.baidu.tbadk.core.util.at.k(this.eec, t.f.more_all);
        com.baidu.tbadk.core.util.at.k(this.eee, t.f.more_all);
        com.baidu.tbadk.core.util.at.k(this.edS, t.f.more_all);
        com.baidu.tbadk.core.util.at.c((ImageView) this.edY.findViewById(t.g.no_disturb_mode_time_arrow), t.f.icon_arrow_right);
        com.baidu.tbadk.core.util.at.c((ImageView) this.edS.findViewById(t.g.sign_remind_arrow), t.f.icon_arrow_right);
        com.baidu.tbadk.core.util.at.c((ImageView) this.eec.findViewById(t.g.no_disturb_start_time_arrow), t.f.icon_arrow_right);
        com.baidu.tbadk.core.util.at.c((ImageView) this.eee.findViewById(t.g.no_disturb_end_time_arrow), t.f.icon_arrow_right);
    }
}
