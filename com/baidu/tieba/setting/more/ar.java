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
import com.baidu.tbadk.game.GameInfoData;
/* loaded from: classes.dex */
public class ar extends com.baidu.adp.base.g<MsgRemindActivity> {
    private RelativeLayout aXd;
    private MsgSettingItemView cbD;
    private LinearLayout cbE;
    private MsgSettingItemView2 cbF;
    private MsgSettingItemView2 cbG;
    private MsgSettingItemView2 cbH;
    private MsgSettingItemView2 cbI;
    private MsgSettingItemView2 cbJ;
    private MsgSettingItemView2 cbK;
    private MsgSettingItemView2 cbL;
    private MsgSettingItemView cbM;
    private MsgSettingItemView cbN;
    private MsgSettingItemView cbO;
    private MsgSettingItemView cbP;
    private MsgSettingItemView cbQ;
    private MsgSettingItemView cbR;
    private LinearLayout cbS;
    private TextView cbT;
    private MsgSettingItemView cbU;
    private MsgSettingItemView cbV;
    private LinearLayout cbW;
    private TextView cbX;
    private LinearLayout cbY;
    private LinearLayout cbZ;
    private LinearLayout cca;
    private TextView ccb;
    private LinearLayout ccc;
    private TextView ccd;
    public boolean cce;
    private MsgRemindActivity ccf;
    private View mBack;
    private NavigationBar mNavigationBar;
    private TextView mTitleText;

    public ar(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.aXd = null;
        this.mNavigationBar = null;
        this.mTitleText = null;
        this.cce = true;
        this.ccf = msgRemindActivity;
        msgRemindActivity.setContentView(com.baidu.tieba.w.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        ahq();
        ahv();
        ahu();
        aht();
        ahs();
        ahr();
        ahw();
        d(msgRemindActivity);
        ahl();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.aXd = (RelativeLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.parent);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cbY = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.front_container);
        this.cbZ = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.back_container);
        this.mTitleText = this.mNavigationBar.setTitleText(msgRemindActivity.getPageContext().getString(com.baidu.tieba.y.msg_remind));
        this.cbD = (MsgSettingItemView) msgRemindActivity.findViewById(com.baidu.tieba.v.receive_message_swtich);
        this.cbD.setText(com.baidu.tieba.y.receive_msg_text);
        this.cbD.setLineVisibility(true);
        this.cbE = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.receive_message_container);
        this.cbF = (MsgSettingItemView2) msgRemindActivity.findViewById(com.baidu.tieba.v.reply_check_box);
        this.cbF.setText(com.baidu.tieba.y.frs_item_reply_text);
        this.cbG = (MsgSettingItemView2) msgRemindActivity.findViewById(com.baidu.tieba.v.zan_check_box);
        this.cbG.setText(com.baidu.tieba.y.frs_item_praise_text);
        this.cbH = (MsgSettingItemView2) msgRemindActivity.findViewById(com.baidu.tieba.v.at_me_check_box);
        this.cbH.setText(com.baidu.tieba.y.mention_atme);
        this.cbI = (MsgSettingItemView2) msgRemindActivity.findViewById(com.baidu.tieba.v.new_fans_swtich);
        this.cbI.setText(com.baidu.tieba.y.new_fans);
        this.cbL = (MsgSettingItemView2) msgRemindActivity.findViewById(com.baidu.tieba.v.stranger_msg_swtich);
        this.cbL.setText(com.baidu.tieba.y.stranger_chatmessage);
        this.cbJ = (MsgSettingItemView2) msgRemindActivity.findViewById(com.baidu.tieba.v.chat_msg_swtich);
        this.cbJ.setText(com.baidu.tieba.y.chat_msg_text);
        this.cbK = (MsgSettingItemView2) msgRemindActivity.findViewById(com.baidu.tieba.v.group_chat_swtich);
        this.cbK.setLineVisibility(false);
        this.cbK.setText(com.baidu.tieba.y.group_chat_text);
        this.cbM = (MsgSettingItemView) msgRemindActivity.findViewById(com.baidu.tieba.v.screen_lock_swtich);
        this.cbM.setText(com.baidu.tieba.y.remind_screen_lock);
        this.cbN = (MsgSettingItemView) msgRemindActivity.findViewById(com.baidu.tieba.v.chat_float_swtich);
        this.cbN.setLineVisibility(false);
        this.cbN.setText(com.baidu.tieba.y.chat_float_window);
        this.cbO = (MsgSettingItemView) msgRemindActivity.findViewById(com.baidu.tieba.v.tone_remind_swtich);
        this.cbO.setText(com.baidu.tieba.y.remind_tone);
        this.cbP = (MsgSettingItemView) msgRemindActivity.findViewById(com.baidu.tieba.v.vibrate_remind_swtich);
        this.cbP.setText(com.baidu.tieba.y.remind_vibrate);
        this.cbQ = (MsgSettingItemView) msgRemindActivity.findViewById(com.baidu.tieba.v.light_remind_swtich);
        this.cbQ.setLineVisibility(true);
        this.cbQ.setText(com.baidu.tieba.y.remind_light);
        this.cbR = (MsgSettingItemView) msgRemindActivity.findViewById(com.baidu.tieba.v.sign_remind_swtich);
        this.cbR.setText(com.baidu.tieba.y.sign_remind_outline);
        this.cbS = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.sign_remind);
        this.cbT = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.sign_remind_time);
        this.cbU = (MsgSettingItemView) msgRemindActivity.findViewById(com.baidu.tieba.v.promoted_content_swtich);
        this.cbU.setLineVisibility(false);
        this.cbU.setText(com.baidu.tieba.y.promoted_message_text);
        this.cbV = (MsgSettingItemView) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_swtich);
        this.cbV.setText(com.baidu.tieba.y.no_disturb_mode);
        this.cbW = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_mode_time_container);
        this.cbX = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_mode_time_value);
        this.cca = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_start_time);
        this.ccb = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_start_time_value);
        this.ccc = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_end_time);
        this.ccd = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_end_time_value);
    }

    private void ahl() {
        ahm();
        ahn();
        aho();
        ahp();
    }

    private void ahm() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.cbV.setVisibility(8);
            this.cbW.setVisibility(8);
            this.cbD.setVisibility(8);
            this.cbE.setVisibility(8);
            this.cbR.setVisibility(8);
            this.cbS.setVisibility(8);
            this.cbO.setVisibility(8);
            this.cbP.setVisibility(8);
            this.cbQ.setVisibility(8);
            this.cbM.setVisibility(8);
            this.cbN.setVisibility(8);
        }
    }

    private void ahn() {
        boolean isMIUIRom = TbadkCoreApplication.m411getInst().isMIUIRom();
        if (TbadkCoreApplication.m411getInst().isFloatingWindowOpened() && !isMIUIRom) {
            this.cbN.setVisibility(0);
            this.cbM.setLineVisibility(true);
            return;
        }
        this.cbN.setVisibility(8);
        this.cbM.setLineVisibility(false);
    }

    private void aho() {
        boolean appResponseToIntentClass = TbadkCoreApplication.m411getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.cbJ.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.cbK.setVisibility(0);
        } else {
            this.cbK.setVisibility(8);
        }
    }

    private void ahp() {
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.cbM.setVisibility(0);
        } else {
            this.cbM.setVisibility(8);
        }
    }

    public View aeH() {
        return this.mBack;
    }

    private void ahq() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.vw().vy()) {
            this.cbD.lY();
            this.cbE.setVisibility(0);
        } else {
            this.cbD.lZ();
            this.cbE.setVisibility(8);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.vw().vD()) {
            this.cbF.getSwitchView().setChecked(true);
        } else {
            this.cbF.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.vw().vM()) {
            this.cbG.getSwitchView().setChecked(true);
        } else {
            this.cbG.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.vw().vB()) {
            this.cbH.getSwitchView().setChecked(true);
        } else {
            this.cbH.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.vw().vC()) {
            this.cbI.getSwitchView().setChecked(true);
        } else {
            this.cbI.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.vw().vA()) {
            this.cbL.getSwitchView().setChecked(true);
        } else {
            this.cbL.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.vw().vE()) {
            this.cbJ.getSwitchView().setChecked(true);
        } else {
            this.cbJ.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.vw().vL()) {
            this.cbK.getSwitchView().setChecked(true);
        } else {
            this.cbK.getSwitchView().setChecked(false);
        }
    }

    private void ahr() {
        if (TbadkCoreApplication.m411getInst().isPromotedMessageOn()) {
            this.cbU.lY();
        } else {
            this.cbU.lZ();
        }
    }

    private void ahs() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.vw().isSignAlertOn()) {
            this.cbR.ma();
            this.cbS.setVisibility(0);
            this.cbR.setLineVisibility(true);
            ahx();
            return;
        }
        this.cbR.mb();
        this.cbR.setLineVisibility(false);
        this.cbS.setVisibility(8);
    }

    private void aht() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.vw().vF()) {
            this.cbO.lY();
        } else {
            this.cbO.lZ();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.vw().vI()) {
            this.cbP.lY();
        } else {
            this.cbP.lZ();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.vw().vG()) {
            this.cbQ.lY();
        } else {
            this.cbQ.lZ();
        }
    }

    private void ahu() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.vw().vN()) {
            this.cbN.lY();
        } else {
            this.cbN.lZ();
        }
    }

    private void ahv() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.vw().vO()) {
            this.cbM.lY();
        } else {
            this.cbM.lZ();
        }
    }

    private void ahw() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.vw().vH()) {
            this.cbV.lY();
            this.cbW.setVisibility(0);
            this.cbV.setLineVisibility(true);
            ahy();
            return;
        }
        this.cbV.lZ();
        this.cbV.setLineVisibility(false);
        this.cbW.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.mBack.setOnClickListener(msgRemindActivity);
        this.cbD.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cbF.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cbH.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cbG.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cbI.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cbL.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cbJ.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cbK.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cbM.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cbN.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cbO.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cbP.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cbQ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cbR.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cbS.setOnClickListener(msgRemindActivity);
        this.cbU.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cbV.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cbW.setOnClickListener(msgRemindActivity);
        this.cca.setOnClickListener(msgRemindActivity);
        this.ccc.setOnClickListener(msgRemindActivity);
    }

    public void es(boolean z) {
        this.cbV.setLineVisibility(z);
        if (z) {
            this.cbW.setVisibility(0);
            ahy();
            com.baidu.tbadk.core.util.ba.i(this.cbW, com.baidu.tieba.u.more_all);
            return;
        }
        this.cbW.setVisibility(8);
    }

    public void et(boolean z) {
        if (z) {
            this.cbS.setVisibility(0);
            this.cbR.setLineVisibility(true);
            com.baidu.tbadk.core.util.ba.i(this.cbS, com.baidu.tieba.u.more_all);
            return;
        }
        this.cbS.setVisibility(8);
        this.cbR.setLineVisibility(false);
    }

    public void eu(boolean z) {
        if (z) {
            this.cbE.setVisibility(0);
        } else {
            this.cbE.setVisibility(8);
        }
    }

    public void ahx() {
        String str;
        String str2;
        if (com.baidu.tbadk.coreExtra.messageCenter.c.vw().isSignAlertOn()) {
            if (com.baidu.tbadk.coreExtra.messageCenter.c.vw().getSignAlertHours() > 9) {
                str = String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.vw().getSignAlertHours());
            } else {
                str = GameInfoData.NOT_FROM_DETAIL + com.baidu.tbadk.coreExtra.messageCenter.c.vw().getSignAlertHours();
            }
            if (com.baidu.tbadk.coreExtra.messageCenter.c.vw().getSignAlertMins() > 9) {
                str2 = String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.vw().getSignAlertMins());
            } else {
                str2 = GameInfoData.NOT_FROM_DETAIL + com.baidu.tbadk.coreExtra.messageCenter.c.vw().getSignAlertMins();
            }
            this.cbT.setText(this.ccf.getPageContext().getPageActivity().getString(com.baidu.tieba.y.sign_remind_time, new Object[]{str, str2}));
            this.cbS.setVisibility(0);
            if (!this.cbR.hZ()) {
                this.cbR.lY();
                return;
            }
            return;
        }
        this.cbT.setText(com.baidu.tieba.y.close);
        this.cbS.setVisibility(8);
        if (this.cbR.hZ()) {
            this.cbR.lZ();
        }
    }

    public void ahy() {
        this.cbX.setText(String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.vw().vJ()) + "-" + com.baidu.tbadk.coreExtra.messageCenter.c.vw().vK());
        this.ccb.setText(com.baidu.tbadk.coreExtra.messageCenter.c.vw().vJ());
        this.ccd.setText(com.baidu.tbadk.coreExtra.messageCenter.c.vw().vK());
    }

    public BdSwitchView ahz() {
        return this.cbU.getSwitchView();
    }

    public BdSwitchView ahA() {
        return this.cbR.getSwitchView();
    }

    public BdSwitchView ahB() {
        return this.cbD.getSwitchView();
    }

    public View ahC() {
        return this.cbS;
    }

    public BdSwitchView ahD() {
        return this.cbV.getSwitchView();
    }

    public View ahE() {
        return this.cbW;
    }

    public LinearLayout ahF() {
        return this.cca;
    }

    public LinearLayout ahG() {
        return this.ccc;
    }

    public BdSwitchView ahH() {
        return this.cbO.getSwitchView();
    }

    public BdSwitchView ahI() {
        return this.cbP.getSwitchView();
    }

    public BdSwitchView ahJ() {
        return this.cbQ.getSwitchView();
    }

    public BdSwitchView ahK() {
        return this.cbM.getSwitchView();
    }

    public BdSwitchView ahL() {
        return this.cbN.getSwitchView();
    }

    public CheckBox ahM() {
        return this.cbF.getSwitchView();
    }

    public CheckBox ahN() {
        return this.cbG.getSwitchView();
    }

    public CheckBox ahO() {
        return this.cbH.getSwitchView();
    }

    public CheckBox ahP() {
        return this.cbJ.getSwitchView();
    }

    public CheckBox ahQ() {
        return this.cbK.getSwitchView();
    }

    public CheckBox ahR() {
        return this.cbI.getSwitchView();
    }

    public CheckBox ahS() {
        return this.cbL.getSwitchView();
    }

    public void ahT() {
        this.cbF.getSwitchView().setOnCheckedChangeListener(null);
        this.cbF.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.vw().vD());
        this.cbF.getSwitchView().setOnCheckedChangeListener(this.ccf);
    }

    public void ahU() {
        this.cbG.getSwitchView().setOnCheckedChangeListener(null);
        this.cbG.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.vw().vM());
        this.cbG.getSwitchView().setOnCheckedChangeListener(this.ccf);
    }

    public void ahV() {
        this.cbH.getSwitchView().setOnCheckedChangeListener(null);
        this.cbH.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.vw().vB());
        this.cbH.getSwitchView().setOnCheckedChangeListener(this.ccf);
    }

    public void ahW() {
        this.cbI.getSwitchView().setOnCheckedChangeListener(null);
        this.cbI.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.vw().vC());
        this.cbI.getSwitchView().setOnCheckedChangeListener(this.ccf);
    }

    public void ahX() {
        this.cbJ.getSwitchView().setOnCheckedChangeListener(null);
        this.cbJ.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.vw().vE());
        this.cbJ.getSwitchView().setOnCheckedChangeListener(this.ccf);
    }

    public void ahY() {
        this.cbK.getSwitchView().setOnCheckedChangeListener(null);
        this.cbK.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.vw().vL());
        this.cbK.getSwitchView().setOnCheckedChangeListener(this.ccf);
    }

    public void ahZ() {
        this.cbL.getSwitchView().setOnCheckedChangeListener(null);
        this.cbL.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.vw().vA());
        this.cbL.getSwitchView().setOnCheckedChangeListener(this.ccf);
    }

    public void ev(boolean z) {
        if (this.cce != z) {
            this.cce = z;
            if (z) {
                this.mTitleText.setText(com.baidu.tieba.y.msg_remind);
                this.cbY.setVisibility(0);
                this.cbZ.setVisibility(8);
                return;
            }
            this.mTitleText.setText(com.baidu.tieba.y.no_disturb_mode_time);
            this.cbZ.setVisibility(0);
            this.cbY.setVisibility(8);
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
    /* JADX DEBUG: Multi-variable search result rejected for r1v35, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.ccf.getLayoutMode().X(i == 1);
        this.ccf.getLayoutMode().h(this.aXd);
        this.mNavigationBar.onChangeSkinType(this.ccf.getPageContext(), i);
        this.cbD.onChangeSkinType(this.ccf.getPageContext(), i);
        this.cbF.onChangeSkinType(this.ccf.getPageContext(), i);
        this.cbG.onChangeSkinType(this.ccf.getPageContext(), i);
        this.cbH.onChangeSkinType(this.ccf.getPageContext(), i);
        this.cbL.onChangeSkinType(this.ccf.getPageContext(), i);
        this.cbI.onChangeSkinType(this.ccf.getPageContext(), i);
        this.cbJ.onChangeSkinType(this.ccf.getPageContext(), i);
        this.cbK.onChangeSkinType(this.ccf.getPageContext(), i);
        this.cbM.onChangeSkinType(this.ccf.getPageContext(), i);
        this.cbN.onChangeSkinType(this.ccf.getPageContext(), i);
        this.cbO.onChangeSkinType(this.ccf.getPageContext(), i);
        this.cbP.onChangeSkinType(this.ccf.getPageContext(), i);
        this.cbQ.onChangeSkinType(this.ccf.getPageContext(), i);
        this.cbR.onChangeSkinType(this.ccf.getPageContext(), i);
        this.cbU.onChangeSkinType(this.ccf.getPageContext(), i);
        this.cbV.onChangeSkinType(this.ccf.getPageContext(), i);
        com.baidu.tbadk.core.util.ba.i(this.cbW, com.baidu.tieba.u.more_all);
        com.baidu.tbadk.core.util.ba.i(this.cca, com.baidu.tieba.u.more_all);
        com.baidu.tbadk.core.util.ba.i(this.ccc, com.baidu.tieba.u.more_all);
        com.baidu.tbadk.core.util.ba.i(this.cbS, com.baidu.tieba.u.more_all);
        com.baidu.tbadk.core.util.ba.c((ImageView) this.cbW.findViewById(com.baidu.tieba.v.no_disturb_mode_time_arrow), com.baidu.tieba.u.icon_arrow_right);
        com.baidu.tbadk.core.util.ba.c((ImageView) this.cbS.findViewById(com.baidu.tieba.v.sign_remind_arrow), com.baidu.tieba.u.icon_arrow_right);
        com.baidu.tbadk.core.util.ba.c((ImageView) this.cca.findViewById(com.baidu.tieba.v.no_disturb_start_time_arrow), com.baidu.tieba.u.icon_arrow_right);
        com.baidu.tbadk.core.util.ba.c((ImageView) this.ccc.findViewById(com.baidu.tieba.v.no_disturb_end_time_arrow), com.baidu.tieba.u.icon_arrow_right);
    }
}
