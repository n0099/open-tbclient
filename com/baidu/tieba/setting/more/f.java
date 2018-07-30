package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.ScreenLockActivityConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class f extends com.baidu.adp.base.c<MsgRemindActivity> {
    private View aAZ;
    private MsgSettingItemView gAA;
    private LinearLayout gAB;
    private MsgSettingItemView gAC;
    private MsgSettingItemView gAD;
    private MsgSettingItemView gAE;
    private MsgSettingItemView gAF;
    private MsgSettingItemView gAG;
    private MsgSettingItemView gAH;
    private MsgSettingItemView gAI;
    private MsgSettingItemView gAJ;
    private MsgSettingItemView gAK;
    private MsgSettingItemView gAL;
    private MsgSettingItemView gAM;
    private LinearLayout gAN;
    private TextView gAO;
    private MsgSettingItemView gAP;
    private LinearLayout gAQ;
    private TextView gAR;
    private LinearLayout gAS;
    private LinearLayout gAT;
    private LinearLayout gAU;
    private TextView gAV;
    private LinearLayout gAW;
    private TextView gAX;
    public boolean gAY;
    private MsgRemindActivity gAZ;
    private TbSettingTextTipView gBa;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public f(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.mParent = null;
        this.mNavigationBar = null;
        this.gAY = true;
        this.gAZ = msgRemindActivity;
        msgRemindActivity.setContentView(d.h.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        bqy();
        bqB();
        bqA();
        bqz();
        bqC();
        d(msgRemindActivity);
        bqs();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.mParent = (RelativeLayout) msgRemindActivity.findViewById(d.g.parent);
        msgRemindActivity.findViewById(d.g.top_head_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(d.j.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.aAZ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gAS = (LinearLayout) msgRemindActivity.findViewById(d.g.front_container);
        this.gAT = (LinearLayout) msgRemindActivity.findViewById(d.g.back_container);
        this.gAA = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.receive_message_swtich);
        this.gAA.setText(d.j.receive_msg_text);
        this.gAA.setLineVisibility(false);
        this.gAB = (LinearLayout) msgRemindActivity.findViewById(d.g.receive_message_container);
        this.gAC = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.reply_check_box);
        this.gAC.setText(d.j.reply);
        this.gAD = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.zan_check_box);
        this.gAD.setVisibility(0);
        this.gAD.setText(d.j.action_praise_default);
        this.gAE = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.at_me_check_box);
        this.gAE.setText(d.j.mention_atme);
        this.gAF = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.new_fans_swtich);
        this.gAF.setText(d.j.new_fans);
        this.gAG = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.chat_msg_swtich);
        this.gAG.setText(d.j.chat_msg_text);
        this.gAH = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.group_chat_swtich);
        this.gAH.setLineVisibility(false);
        this.gAH.setText(d.j.group_chat_text);
        this.gAI = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.screen_lock_swtich);
        this.gAI.setText(d.j.remind_screen_lock);
        this.gAI.setLineVisibility(false);
        this.gAJ = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.tone_remind_swtich);
        this.gAJ.setText(d.j.remind_tone);
        this.gAK = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.vibrate_remind_swtich);
        this.gAK.setText(d.j.remind_vibrate);
        this.gAL = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.light_remind_swtich);
        this.gAL.setLineVisibility(true);
        this.gAL.setText(d.j.remind_light);
        this.gAM = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.sign_remind_swtich);
        this.gAM.setText(d.j.sign_remind_outline);
        this.gAN = (LinearLayout) msgRemindActivity.findViewById(d.g.sign_remind);
        this.gAO = (TextView) msgRemindActivity.findViewById(d.g.sign_remind_time);
        this.gAP = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.no_disturb_swtich);
        this.gAP.setText(d.j.no_disturb_mode);
        this.gAP.setLineVisibility(false);
        this.gAQ = (LinearLayout) msgRemindActivity.findViewById(d.g.no_disturb_mode_time_container);
        this.gAR = (TextView) msgRemindActivity.findViewById(d.g.no_disturb_mode_time_value);
        this.gAU = (LinearLayout) msgRemindActivity.findViewById(d.g.no_disturb_start_time);
        this.gAV = (TextView) msgRemindActivity.findViewById(d.g.no_disturb_start_time_value);
        this.gAW = (LinearLayout) msgRemindActivity.findViewById(d.g.no_disturb_end_time);
        this.gAX = (TextView) msgRemindActivity.findViewById(d.g.no_disturb_end_time_value);
        this.gBa = (TbSettingTextTipView) msgRemindActivity.findViewById(d.g.msg_receive_item_view);
    }

    private void bqs() {
        bqt();
        bqu();
        bqv();
        bqw();
    }

    private void bqt() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.gAP.setVisibility(8);
            this.gAQ.setVisibility(8);
            this.gAA.setVisibility(8);
            this.gAB.setVisibility(8);
            this.gAM.setVisibility(8);
            this.gAN.setVisibility(8);
            this.gAJ.setVisibility(8);
            this.gAK.setVisibility(8);
            this.gAL.setVisibility(8);
            this.gAI.setVisibility(8);
        }
    }

    private void bqu() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.gAI.setLineVisibility(true);
        } else {
            this.gAI.setLineVisibility(false);
        }
    }

    private void bqv() {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.gAG.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.gAH.setVisibility(0);
        } else {
            this.gAH.setVisibility(8);
        }
    }

    private void bqw() {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.gAI.setVisibility(0);
        } else {
            this.gAI.setVisibility(8);
        }
    }

    public View bqx() {
        return this.aAZ;
    }

    private void bqy() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.DS().DU()) {
            this.gAA.mC();
            this.gAB.setVisibility(0);
        } else {
            this.gAA.mD();
            this.gAB.setVisibility(8);
        }
        this.gAC.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DS().DZ());
        this.gAD.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DS().Ei());
        this.gAE.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DS().DX());
        this.gAF.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DS().DY());
        this.gAG.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DS().Ea());
        this.gAH.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DS().Eh());
    }

    private void bqz() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.DS().isSignAlertOn()) {
            this.gAM.mE();
            this.gAN.setVisibility(0);
            this.gAM.setLineVisibility(true);
            bqD();
            return;
        }
        this.gAM.mF();
        this.gAM.setLineVisibility(false);
        this.gAN.setVisibility(8);
    }

    private void bqA() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.DS().Eb()) {
            this.gAJ.mC();
        } else {
            this.gAJ.mD();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.DS().Ee()) {
            this.gAK.mC();
        } else {
            this.gAK.mD();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.DS().Ec()) {
            this.gAL.mC();
        } else {
            this.gAL.mD();
        }
    }

    private void bqB() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.DS().Ej()) {
            this.gAI.mC();
        } else {
            this.gAI.mD();
        }
    }

    private void bqC() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.DS().Ed()) {
            this.gAP.mC();
            this.gAQ.setVisibility(0);
            bqE();
            return;
        }
        this.gAP.mD();
        this.gAQ.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.aAZ.setOnClickListener(msgRemindActivity);
        this.gAA.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gAC.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gAE.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gAD.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gAF.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gAG.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gAH.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gAI.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gAJ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gAK.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gAL.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gAM.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gAN.setOnClickListener(msgRemindActivity);
        this.gAP.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gAQ.setOnClickListener(msgRemindActivity);
        this.gAU.setOnClickListener(msgRemindActivity);
        this.gAW.setOnClickListener(msgRemindActivity);
        this.gBa.setOnClickListener(msgRemindActivity);
    }

    public void lU(boolean z) {
        this.gAP.setLineVisibility(z);
        if (z) {
            this.gAQ.setVisibility(0);
            bqE();
            am.i(this.gAQ, d.f.more_all);
            return;
        }
        this.gAQ.setVisibility(8);
    }

    public void lV(boolean z) {
        if (z) {
            this.gAN.setVisibility(0);
            this.gAM.setLineVisibility(true);
            am.i(this.gAN, d.f.more_all);
            return;
        }
        this.gAN.setVisibility(8);
        this.gAM.setLineVisibility(false);
    }

    public void lW(boolean z) {
        if (z) {
            this.gAB.setVisibility(0);
        } else {
            this.gAB.setVisibility(8);
        }
    }

    public void bqD() {
        String str;
        String str2;
        if (com.baidu.tbadk.coreExtra.messageCenter.c.DS().isSignAlertOn()) {
            if (com.baidu.tbadk.coreExtra.messageCenter.c.DS().getSignAlertHours() > 9) {
                str = String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.DS().getSignAlertHours());
            } else {
                str = "0" + com.baidu.tbadk.coreExtra.messageCenter.c.DS().getSignAlertHours();
            }
            if (com.baidu.tbadk.coreExtra.messageCenter.c.DS().getSignAlertMins() > 9) {
                str2 = String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.DS().getSignAlertMins());
            } else {
                str2 = "0" + com.baidu.tbadk.coreExtra.messageCenter.c.DS().getSignAlertMins();
            }
            this.gAO.setText(this.gAZ.getPageContext().getPageActivity().getString(d.j.sign_remind_time, new Object[]{str, str2}));
            this.gAN.setVisibility(0);
            if (!this.gAM.iq()) {
                this.gAM.mC();
                return;
            }
            return;
        }
        this.gAO.setText(d.j.close);
        this.gAN.setVisibility(8);
        if (this.gAM.iq()) {
            this.gAM.mD();
        }
    }

    public void bqE() {
        this.gAR.setText(com.baidu.tbadk.coreExtra.messageCenter.c.DS().Ef() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + com.baidu.tbadk.coreExtra.messageCenter.c.DS().Eg());
        this.gAV.setText(com.baidu.tbadk.coreExtra.messageCenter.c.DS().Ef());
        this.gAX.setText(com.baidu.tbadk.coreExtra.messageCenter.c.DS().Eg());
    }

    public BdSwitchView bqF() {
        return this.gAM.getSwitchView();
    }

    public BdSwitchView bqG() {
        return this.gAA.getSwitchView();
    }

    public View bqH() {
        return this.gAN;
    }

    public BdSwitchView bqI() {
        return this.gAP.getSwitchView();
    }

    public View bqJ() {
        return this.gAQ;
    }

    public LinearLayout bqK() {
        return this.gAU;
    }

    public LinearLayout bqL() {
        return this.gAW;
    }

    public BdSwitchView bqM() {
        return this.gAJ.getSwitchView();
    }

    public BdSwitchView bqN() {
        return this.gAK.getSwitchView();
    }

    public BdSwitchView bqO() {
        return this.gAL.getSwitchView();
    }

    public BdSwitchView bqP() {
        return this.gAI.getSwitchView();
    }

    public BdSwitchView bqQ() {
        return this.gAC.getSwitchView();
    }

    public BdSwitchView bqR() {
        return this.gAD.getSwitchView();
    }

    public BdSwitchView bqS() {
        return this.gAE.getSwitchView();
    }

    public BdSwitchView bqT() {
        return this.gAG.getSwitchView();
    }

    public BdSwitchView bqU() {
        return this.gAH.getSwitchView();
    }

    public BdSwitchView bqV() {
        return this.gAF.getSwitchView();
    }

    public TbSettingTextTipView bqW() {
        return this.gBa;
    }

    public void bqX() {
        this.gAC.setOnSwitchStateChangeListener(null);
        this.gAC.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DS().DZ());
        this.gAC.setOnSwitchStateChangeListener(this.gAZ);
    }

    public void bqY() {
        this.gAD.setOnSwitchStateChangeListener(null);
        this.gAD.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DS().Ei());
        this.gAD.setOnSwitchStateChangeListener(this.gAZ);
    }

    public void bqZ() {
        this.gAE.setOnSwitchStateChangeListener(null);
        this.gAE.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DS().DX());
        this.gAE.setOnSwitchStateChangeListener(this.gAZ);
    }

    public void bra() {
        this.gAF.setOnSwitchStateChangeListener(null);
        this.gAF.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DS().DY());
        this.gAF.setOnSwitchStateChangeListener(this.gAZ);
    }

    public void brb() {
        this.gAG.setOnSwitchStateChangeListener(null);
        this.gAG.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DS().Ea());
        this.gAG.setOnSwitchStateChangeListener(this.gAZ);
    }

    public void brc() {
        this.gAH.setOnSwitchStateChangeListener(null);
        this.gAH.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DS().Eh());
        this.gAH.setOnSwitchStateChangeListener(this.gAZ);
    }

    public void lX(boolean z) {
        if (this.gAY != z) {
            this.gAY = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.gAZ.getPageContext().getString(d.j.msg_remind));
                this.gAS.setVisibility(0);
                this.gAT.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.gAZ.getPageContext().getString(d.j.no_disturb_mode_time));
            this.gAT.setVisibility(0);
            this.gAS.setVisibility(8);
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
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.gAZ.getLayoutMode().setNightMode(i == 1);
        this.gAZ.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gAZ.getPageContext(), i);
        this.gAA.d(this.gAZ.getPageContext(), i);
        this.gAC.d(this.gAZ.getPageContext(), i);
        this.gAD.d(this.gAZ.getPageContext(), i);
        this.gAE.d(this.gAZ.getPageContext(), i);
        this.gAF.d(this.gAZ.getPageContext(), i);
        this.gAG.d(this.gAZ.getPageContext(), i);
        this.gAH.d(this.gAZ.getPageContext(), i);
        this.gAI.d(this.gAZ.getPageContext(), i);
        this.gAJ.d(this.gAZ.getPageContext(), i);
        this.gAK.d(this.gAZ.getPageContext(), i);
        this.gAL.d(this.gAZ.getPageContext(), i);
        this.gAM.d(this.gAZ.getPageContext(), i);
        this.gAP.d(this.gAZ.getPageContext(), i);
        am.i(this.gAQ, d.f.more_all);
        am.i(this.gAU, d.f.more_all);
        am.i(this.gAW, d.f.more_all);
        am.i(this.gAN, d.f.more_all);
        am.c((ImageView) this.gAQ.findViewById(d.g.no_disturb_mode_time_arrow), d.f.icon_arrow_gray_right_n);
        am.c((ImageView) this.gAN.findViewById(d.g.sign_remind_arrow), d.f.icon_arrow_gray_right_n);
        am.c((ImageView) this.gAU.findViewById(d.g.no_disturb_start_time_arrow), d.f.icon_arrow_gray_right_n);
        am.c((ImageView) this.gAW.findViewById(d.g.no_disturb_end_time_arrow), d.f.icon_arrow_gray_right_n);
    }
}
