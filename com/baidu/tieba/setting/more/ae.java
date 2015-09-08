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
    private RelativeLayout boe;
    private MsgSettingItemView2 cGA;
    private MsgSettingItemView2 cGB;
    private MsgSettingItemView2 cGC;
    private MsgSettingItemView2 cGD;
    private MsgSettingItemView2 cGE;
    private MsgSettingItemView2 cGF;
    private MsgSettingItemView cGG;
    private MsgSettingItemView cGH;
    private MsgSettingItemView cGI;
    private MsgSettingItemView cGJ;
    private MsgSettingItemView cGK;
    private MsgSettingItemView cGL;
    private LinearLayout cGM;
    private TextView cGN;
    private MsgSettingItemView cGO;
    private MsgSettingItemView cGP;
    private MsgSettingItemView cGQ;
    private LinearLayout cGR;
    private TextView cGS;
    private LinearLayout cGT;
    private LinearLayout cGU;
    private LinearLayout cGV;
    private TextView cGW;
    private LinearLayout cGX;
    private TextView cGY;
    public boolean cGZ;
    private MsgSettingItemView cGy;
    private LinearLayout cGz;
    private MsgRemindActivity cHa;
    private View mBack;
    private NavigationBar mNavigationBar;

    public ae(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.boe = null;
        this.mNavigationBar = null;
        this.LM = null;
        this.cGZ = true;
        this.cHa = msgRemindActivity;
        msgRemindActivity.setContentView(i.g.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        apQ();
        apW();
        apV();
        apU();
        apT();
        apR();
        apX();
        apS();
        d(msgRemindActivity);
        apL();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.boe = (RelativeLayout) msgRemindActivity.findViewById(i.f.parent);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(i.f.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cGT = (LinearLayout) msgRemindActivity.findViewById(i.f.front_container);
        this.cGU = (LinearLayout) msgRemindActivity.findViewById(i.f.back_container);
        this.LM = this.mNavigationBar.setTitleText(msgRemindActivity.getPageContext().getString(i.h.msg_remind));
        this.cGy = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.receive_message_swtich);
        this.cGy.setText(i.h.receive_msg_text);
        this.cGy.setLineVisibility(true);
        this.cGz = (LinearLayout) msgRemindActivity.findViewById(i.f.receive_message_container);
        this.cGA = (MsgSettingItemView2) msgRemindActivity.findViewById(i.f.reply_check_box);
        this.cGA.setText(i.h.frs_item_reply_text);
        this.cGB = (MsgSettingItemView2) msgRemindActivity.findViewById(i.f.zan_check_box);
        this.cGB.setText(i.h.frs_item_praise_text);
        this.cGC = (MsgSettingItemView2) msgRemindActivity.findViewById(i.f.at_me_check_box);
        this.cGC.setText(i.h.mention_atme);
        this.cGD = (MsgSettingItemView2) msgRemindActivity.findViewById(i.f.new_fans_swtich);
        this.cGD.setText(i.h.new_fans);
        this.cGE = (MsgSettingItemView2) msgRemindActivity.findViewById(i.f.chat_msg_swtich);
        this.cGE.setText(i.h.chat_msg_text);
        this.cGF = (MsgSettingItemView2) msgRemindActivity.findViewById(i.f.group_chat_swtich);
        this.cGF.setLineVisibility(false);
        this.cGF.setText(i.h.group_chat_text);
        this.cGG = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.screen_lock_swtich);
        this.cGG.setText(i.h.remind_screen_lock);
        this.cGH = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.chat_float_swtich);
        this.cGH.setLineVisibility(false);
        this.cGH.setText(i.h.chat_float_window);
        this.cGI = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.tone_remind_swtich);
        this.cGI.setText(i.h.remind_tone);
        this.cGJ = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.vibrate_remind_swtich);
        this.cGJ.setText(i.h.remind_vibrate);
        this.cGK = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.light_remind_swtich);
        this.cGK.setLineVisibility(true);
        this.cGK.setText(i.h.remind_light);
        this.cGL = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.sign_remind_swtich);
        this.cGL.setText(i.h.sign_remind_outline);
        this.cGM = (LinearLayout) msgRemindActivity.findViewById(i.f.sign_remind);
        this.cGN = (TextView) msgRemindActivity.findViewById(i.f.sign_remind_time);
        this.cGO = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.promoted_content_swtich);
        this.cGO.setLineVisibility(true);
        this.cGO.setText(i.h.promoted_message_text);
        this.cGQ = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.no_disturb_swtich);
        this.cGQ.setText(i.h.no_disturb_mode);
        this.cGR = (LinearLayout) msgRemindActivity.findViewById(i.f.no_disturb_mode_time_container);
        this.cGS = (TextView) msgRemindActivity.findViewById(i.f.no_disturb_mode_time_value);
        this.cGV = (LinearLayout) msgRemindActivity.findViewById(i.f.no_disturb_start_time);
        this.cGW = (TextView) msgRemindActivity.findViewById(i.f.no_disturb_start_time_value);
        this.cGX = (LinearLayout) msgRemindActivity.findViewById(i.f.no_disturb_end_time);
        this.cGY = (TextView) msgRemindActivity.findViewById(i.f.no_disturb_end_time_value);
        this.cGP = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.remind_recommend_swtich);
        this.cGP.setLineVisibility(false);
        this.cGP.setText(i.h.remind_message_recommend);
    }

    private void apL() {
        apM();
        apN();
        apO();
        apP();
    }

    private void apM() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.cGQ.setVisibility(8);
            this.cGR.setVisibility(8);
            this.cGy.setVisibility(8);
            this.cGz.setVisibility(8);
            this.cGL.setVisibility(8);
            this.cGM.setVisibility(8);
            this.cGI.setVisibility(8);
            this.cGJ.setVisibility(8);
            this.cGK.setVisibility(8);
            this.cGG.setVisibility(8);
            this.cGH.setVisibility(8);
        }
    }

    private void apN() {
        boolean isMIUIRom = TbadkCoreApplication.m411getInst().isMIUIRom();
        if (TbadkCoreApplication.m411getInst().isFloatingWindowOpened() && !isMIUIRom) {
            this.cGH.setVisibility(0);
            this.cGG.setLineVisibility(true);
            return;
        }
        this.cGH.setVisibility(8);
        this.cGG.setLineVisibility(false);
    }

    private void apO() {
        boolean appResponseToIntentClass = TbadkCoreApplication.m411getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.cGE.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.cGF.setVisibility(0);
        } else {
            this.cGF.setVisibility(8);
        }
    }

    private void apP() {
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.cGG.setVisibility(0);
        } else {
            this.cGG.setVisibility(8);
        }
    }

    public View aic() {
        return this.mBack;
    }

    private void apQ() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xw().xy()) {
            this.cGy.my();
            this.cGz.setVisibility(0);
        } else {
            this.cGy.mz();
            this.cGz.setVisibility(8);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xw().xD()) {
            this.cGA.getSwitchView().setChecked(true);
        } else {
            this.cGA.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xw().xM()) {
            this.cGB.getSwitchView().setChecked(true);
        } else {
            this.cGB.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xw().xB()) {
            this.cGC.getSwitchView().setChecked(true);
        } else {
            this.cGC.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xw().xC()) {
            this.cGD.getSwitchView().setChecked(true);
        } else {
            this.cGD.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xw().xE()) {
            this.cGE.getSwitchView().setChecked(true);
        } else {
            this.cGE.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xw().xL()) {
            this.cGF.getSwitchView().setChecked(true);
        } else {
            this.cGF.getSwitchView().setChecked(false);
        }
    }

    private void apR() {
        if (TbadkCoreApplication.m411getInst().isPromotedMessageOn()) {
            this.cGO.my();
        } else {
            this.cGO.mz();
        }
    }

    private void apS() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xw().xQ()) {
            this.cGP.my();
        } else {
            this.cGP.mz();
        }
    }

    private void apT() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xw().isSignAlertOn()) {
            this.cGL.mA();
            this.cGM.setVisibility(0);
            this.cGL.setLineVisibility(true);
            apY();
            return;
        }
        this.cGL.mB();
        this.cGL.setLineVisibility(false);
        this.cGM.setVisibility(8);
    }

    private void apU() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xw().xF()) {
            this.cGI.my();
        } else {
            this.cGI.mz();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xw().xI()) {
            this.cGJ.my();
        } else {
            this.cGJ.mz();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xw().xG()) {
            this.cGK.my();
        } else {
            this.cGK.mz();
        }
    }

    private void apV() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xw().xN()) {
            this.cGH.my();
        } else {
            this.cGH.mz();
        }
    }

    private void apW() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xw().xO()) {
            this.cGG.my();
        } else {
            this.cGG.mz();
        }
    }

    private void apX() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xw().xH()) {
            this.cGQ.my();
            this.cGR.setVisibility(0);
            apZ();
            return;
        }
        this.cGQ.mz();
        this.cGR.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.mBack.setOnClickListener(msgRemindActivity);
        this.cGy.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cGA.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cGC.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cGB.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cGD.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cGE.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cGF.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cGG.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cGH.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cGI.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cGJ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cGK.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cGL.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cGM.setOnClickListener(msgRemindActivity);
        this.cGO.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cGQ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cGR.setOnClickListener(msgRemindActivity);
        this.cGV.setOnClickListener(msgRemindActivity);
        this.cGX.setOnClickListener(msgRemindActivity);
        this.cGP.setOnSwitchStateChangeListener(msgRemindActivity);
    }

    public void fO(boolean z) {
        this.cGQ.setLineVisibility(z);
        if (z) {
            this.cGR.setVisibility(0);
            apZ();
            com.baidu.tbadk.core.util.al.h(this.cGR, i.e.more_all);
            return;
        }
        this.cGR.setVisibility(8);
    }

    public void fP(boolean z) {
        if (z) {
            this.cGM.setVisibility(0);
            this.cGL.setLineVisibility(true);
            com.baidu.tbadk.core.util.al.h(this.cGM, i.e.more_all);
            return;
        }
        this.cGM.setVisibility(8);
        this.cGL.setLineVisibility(false);
    }

    public void fQ(boolean z) {
        if (z) {
            this.cGz.setVisibility(0);
        } else {
            this.cGz.setVisibility(8);
        }
    }

    public void apY() {
        String str;
        String str2;
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xw().isSignAlertOn()) {
            if (com.baidu.tbadk.coreExtra.messageCenter.c.xw().getSignAlertHours() > 9) {
                str = String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.xw().getSignAlertHours());
            } else {
                str = "0" + com.baidu.tbadk.coreExtra.messageCenter.c.xw().getSignAlertHours();
            }
            if (com.baidu.tbadk.coreExtra.messageCenter.c.xw().getSignAlertMins() > 9) {
                str2 = String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.xw().getSignAlertMins());
            } else {
                str2 = "0" + com.baidu.tbadk.coreExtra.messageCenter.c.xw().getSignAlertMins();
            }
            this.cGN.setText(this.cHa.getPageContext().getPageActivity().getString(i.h.sign_remind_time, new Object[]{str, str2}));
            this.cGM.setVisibility(0);
            if (!this.cGL.hw()) {
                this.cGL.my();
                return;
            }
            return;
        }
        this.cGN.setText(i.h.close);
        this.cGM.setVisibility(8);
        if (this.cGL.hw()) {
            this.cGL.mz();
        }
    }

    public void apZ() {
        this.cGS.setText(String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.xw().xJ()) + "-" + com.baidu.tbadk.coreExtra.messageCenter.c.xw().xK());
        this.cGW.setText(com.baidu.tbadk.coreExtra.messageCenter.c.xw().xJ());
        this.cGY.setText(com.baidu.tbadk.coreExtra.messageCenter.c.xw().xK());
    }

    public BdSwitchView aqa() {
        return this.cGP.getSwitchView();
    }

    public BdSwitchView aqb() {
        return this.cGO.getSwitchView();
    }

    public BdSwitchView aqc() {
        return this.cGL.getSwitchView();
    }

    public BdSwitchView aqd() {
        return this.cGy.getSwitchView();
    }

    public View aqe() {
        return this.cGM;
    }

    public BdSwitchView aqf() {
        return this.cGQ.getSwitchView();
    }

    public View aqg() {
        return this.cGR;
    }

    public LinearLayout aqh() {
        return this.cGV;
    }

    public LinearLayout aqi() {
        return this.cGX;
    }

    public BdSwitchView aqj() {
        return this.cGI.getSwitchView();
    }

    public BdSwitchView aqk() {
        return this.cGJ.getSwitchView();
    }

    public BdSwitchView aql() {
        return this.cGK.getSwitchView();
    }

    public BdSwitchView aqm() {
        return this.cGG.getSwitchView();
    }

    public BdSwitchView aqn() {
        return this.cGH.getSwitchView();
    }

    public CheckBox aqo() {
        return this.cGA.getSwitchView();
    }

    public CheckBox aqp() {
        return this.cGB.getSwitchView();
    }

    public CheckBox aqq() {
        return this.cGC.getSwitchView();
    }

    public CheckBox aqr() {
        return this.cGE.getSwitchView();
    }

    public CheckBox aqs() {
        return this.cGF.getSwitchView();
    }

    public CheckBox aqt() {
        return this.cGD.getSwitchView();
    }

    public void aqu() {
        this.cGA.getSwitchView().setOnCheckedChangeListener(null);
        this.cGA.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.xw().xD());
        this.cGA.getSwitchView().setOnCheckedChangeListener(this.cHa);
    }

    public void aqv() {
        this.cGB.getSwitchView().setOnCheckedChangeListener(null);
        this.cGB.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.xw().xM());
        this.cGB.getSwitchView().setOnCheckedChangeListener(this.cHa);
    }

    public void aqw() {
        this.cGC.getSwitchView().setOnCheckedChangeListener(null);
        this.cGC.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.xw().xB());
        this.cGC.getSwitchView().setOnCheckedChangeListener(this.cHa);
    }

    public void aqx() {
        this.cGD.getSwitchView().setOnCheckedChangeListener(null);
        this.cGD.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.xw().xC());
        this.cGD.getSwitchView().setOnCheckedChangeListener(this.cHa);
    }

    public void aqy() {
        this.cGE.getSwitchView().setOnCheckedChangeListener(null);
        this.cGE.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.xw().xE());
        this.cGE.getSwitchView().setOnCheckedChangeListener(this.cHa);
    }

    public void aqz() {
        this.cGF.getSwitchView().setOnCheckedChangeListener(null);
        this.cGF.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.xw().xL());
        this.cGF.getSwitchView().setOnCheckedChangeListener(this.cHa);
    }

    public void fR(boolean z) {
        if (this.cGZ != z) {
            this.cGZ = z;
            if (z) {
                this.LM.setText(i.h.msg_remind);
                this.cGT.setVisibility(0);
                this.cGU.setVisibility(8);
                return;
            }
            this.LM.setText(i.h.no_disturb_mode_time);
            this.cGU.setVisibility(0);
            this.cGT.setVisibility(8);
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
        this.cHa.getLayoutMode().ad(i == 1);
        this.cHa.getLayoutMode().k(this.boe);
        this.mNavigationBar.onChangeSkinType(this.cHa.getPageContext(), i);
        this.cGy.onChangeSkinType(this.cHa.getPageContext(), i);
        this.cGA.onChangeSkinType(this.cHa.getPageContext(), i);
        this.cGB.onChangeSkinType(this.cHa.getPageContext(), i);
        this.cGC.onChangeSkinType(this.cHa.getPageContext(), i);
        this.cGD.onChangeSkinType(this.cHa.getPageContext(), i);
        this.cGE.onChangeSkinType(this.cHa.getPageContext(), i);
        this.cGF.onChangeSkinType(this.cHa.getPageContext(), i);
        this.cGG.onChangeSkinType(this.cHa.getPageContext(), i);
        this.cGH.onChangeSkinType(this.cHa.getPageContext(), i);
        this.cGI.onChangeSkinType(this.cHa.getPageContext(), i);
        this.cGJ.onChangeSkinType(this.cHa.getPageContext(), i);
        this.cGK.onChangeSkinType(this.cHa.getPageContext(), i);
        this.cGL.onChangeSkinType(this.cHa.getPageContext(), i);
        this.cGO.onChangeSkinType(this.cHa.getPageContext(), i);
        this.cGQ.onChangeSkinType(this.cHa.getPageContext(), i);
        if (this.cGP != null) {
            this.cGP.onChangeSkinType(this.cHa.getPageContext(), i);
        }
        com.baidu.tbadk.core.util.al.h(this.cGR, i.e.more_all);
        com.baidu.tbadk.core.util.al.h(this.cGV, i.e.more_all);
        com.baidu.tbadk.core.util.al.h(this.cGX, i.e.more_all);
        com.baidu.tbadk.core.util.al.h(this.cGM, i.e.more_all);
        com.baidu.tbadk.core.util.al.c((ImageView) this.cGR.findViewById(i.f.no_disturb_mode_time_arrow), i.e.icon_arrow_right);
        com.baidu.tbadk.core.util.al.c((ImageView) this.cGM.findViewById(i.f.sign_remind_arrow), i.e.icon_arrow_right);
        com.baidu.tbadk.core.util.al.c((ImageView) this.cGV.findViewById(i.f.no_disturb_start_time_arrow), i.e.icon_arrow_right);
        com.baidu.tbadk.core.util.al.c((ImageView) this.cGX.findViewById(i.f.no_disturb_end_time_arrow), i.e.icon_arrow_right);
    }
}
