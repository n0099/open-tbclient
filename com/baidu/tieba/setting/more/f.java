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
import com.baidu.tieba.f;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class f extends com.baidu.adp.base.c<MsgRemindActivity> {
    private View aAW;
    private MsgSettingItemView gAD;
    private LinearLayout gAE;
    private MsgSettingItemView gAF;
    private MsgSettingItemView gAG;
    private MsgSettingItemView gAH;
    private MsgSettingItemView gAI;
    private MsgSettingItemView gAJ;
    private MsgSettingItemView gAK;
    private MsgSettingItemView gAL;
    private MsgSettingItemView gAM;
    private MsgSettingItemView gAN;
    private MsgSettingItemView gAO;
    private MsgSettingItemView gAP;
    private LinearLayout gAQ;
    private TextView gAR;
    private MsgSettingItemView gAS;
    private LinearLayout gAT;
    private TextView gAU;
    private LinearLayout gAV;
    private LinearLayout gAW;
    private LinearLayout gAX;
    private TextView gAY;
    private LinearLayout gAZ;
    private TextView gBa;
    public boolean gBb;
    private MsgRemindActivity gBc;
    private TbSettingTextTipView gBd;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public f(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.mParent = null;
        this.mNavigationBar = null;
        this.gBb = true;
        this.gBc = msgRemindActivity;
        msgRemindActivity.setContentView(f.h.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        bqz();
        bqC();
        bqB();
        bqA();
        bqD();
        d(msgRemindActivity);
        bqt();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.mParent = (RelativeLayout) msgRemindActivity.findViewById(f.g.parent);
        msgRemindActivity.findViewById(f.g.top_head_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(f.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(f.j.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.aAW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gAV = (LinearLayout) msgRemindActivity.findViewById(f.g.front_container);
        this.gAW = (LinearLayout) msgRemindActivity.findViewById(f.g.back_container);
        this.gAD = (MsgSettingItemView) msgRemindActivity.findViewById(f.g.receive_message_swtich);
        this.gAD.setText(f.j.receive_msg_text);
        this.gAD.setLineVisibility(false);
        this.gAE = (LinearLayout) msgRemindActivity.findViewById(f.g.receive_message_container);
        this.gAF = (MsgSettingItemView) msgRemindActivity.findViewById(f.g.reply_check_box);
        this.gAF.setText(f.j.reply);
        this.gAG = (MsgSettingItemView) msgRemindActivity.findViewById(f.g.zan_check_box);
        this.gAG.setVisibility(0);
        this.gAG.setText(f.j.action_praise_default);
        this.gAH = (MsgSettingItemView) msgRemindActivity.findViewById(f.g.at_me_check_box);
        this.gAH.setText(f.j.mention_atme);
        this.gAI = (MsgSettingItemView) msgRemindActivity.findViewById(f.g.new_fans_swtich);
        this.gAI.setText(f.j.new_fans);
        this.gAJ = (MsgSettingItemView) msgRemindActivity.findViewById(f.g.chat_msg_swtich);
        this.gAJ.setText(f.j.chat_msg_text);
        this.gAK = (MsgSettingItemView) msgRemindActivity.findViewById(f.g.group_chat_swtich);
        this.gAK.setLineVisibility(false);
        this.gAK.setText(f.j.group_chat_text);
        this.gAL = (MsgSettingItemView) msgRemindActivity.findViewById(f.g.screen_lock_swtich);
        this.gAL.setText(f.j.remind_screen_lock);
        this.gAL.setLineVisibility(false);
        this.gAM = (MsgSettingItemView) msgRemindActivity.findViewById(f.g.tone_remind_swtich);
        this.gAM.setText(f.j.remind_tone);
        this.gAN = (MsgSettingItemView) msgRemindActivity.findViewById(f.g.vibrate_remind_swtich);
        this.gAN.setText(f.j.remind_vibrate);
        this.gAO = (MsgSettingItemView) msgRemindActivity.findViewById(f.g.light_remind_swtich);
        this.gAO.setLineVisibility(true);
        this.gAO.setText(f.j.remind_light);
        this.gAP = (MsgSettingItemView) msgRemindActivity.findViewById(f.g.sign_remind_swtich);
        this.gAP.setText(f.j.sign_remind_outline);
        this.gAQ = (LinearLayout) msgRemindActivity.findViewById(f.g.sign_remind);
        this.gAR = (TextView) msgRemindActivity.findViewById(f.g.sign_remind_time);
        this.gAS = (MsgSettingItemView) msgRemindActivity.findViewById(f.g.no_disturb_swtich);
        this.gAS.setText(f.j.no_disturb_mode);
        this.gAS.setLineVisibility(false);
        this.gAT = (LinearLayout) msgRemindActivity.findViewById(f.g.no_disturb_mode_time_container);
        this.gAU = (TextView) msgRemindActivity.findViewById(f.g.no_disturb_mode_time_value);
        this.gAX = (LinearLayout) msgRemindActivity.findViewById(f.g.no_disturb_start_time);
        this.gAY = (TextView) msgRemindActivity.findViewById(f.g.no_disturb_start_time_value);
        this.gAZ = (LinearLayout) msgRemindActivity.findViewById(f.g.no_disturb_end_time);
        this.gBa = (TextView) msgRemindActivity.findViewById(f.g.no_disturb_end_time_value);
        this.gBd = (TbSettingTextTipView) msgRemindActivity.findViewById(f.g.msg_receive_item_view);
    }

    private void bqt() {
        bqu();
        bqv();
        bqw();
        bqx();
    }

    private void bqu() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.gAS.setVisibility(8);
            this.gAT.setVisibility(8);
            this.gAD.setVisibility(8);
            this.gAE.setVisibility(8);
            this.gAP.setVisibility(8);
            this.gAQ.setVisibility(8);
            this.gAM.setVisibility(8);
            this.gAN.setVisibility(8);
            this.gAO.setVisibility(8);
            this.gAL.setVisibility(8);
        }
    }

    private void bqv() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.gAL.setLineVisibility(true);
        } else {
            this.gAL.setLineVisibility(false);
        }
    }

    private void bqw() {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.gAJ.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.gAK.setVisibility(0);
        } else {
            this.gAK.setVisibility(8);
        }
    }

    private void bqx() {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.gAL.setVisibility(0);
        } else {
            this.gAL.setVisibility(8);
        }
    }

    public View bqy() {
        return this.aAW;
    }

    private void bqz() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.DS().DU()) {
            this.gAD.mC();
            this.gAE.setVisibility(0);
        } else {
            this.gAD.mD();
            this.gAE.setVisibility(8);
        }
        this.gAF.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DS().DZ());
        this.gAG.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DS().Ei());
        this.gAH.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DS().DX());
        this.gAI.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DS().DY());
        this.gAJ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DS().Ea());
        this.gAK.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DS().Eh());
    }

    private void bqA() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.DS().isSignAlertOn()) {
            this.gAP.mE();
            this.gAQ.setVisibility(0);
            this.gAP.setLineVisibility(true);
            bqE();
            return;
        }
        this.gAP.mF();
        this.gAP.setLineVisibility(false);
        this.gAQ.setVisibility(8);
    }

    private void bqB() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.DS().Eb()) {
            this.gAM.mC();
        } else {
            this.gAM.mD();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.DS().Ee()) {
            this.gAN.mC();
        } else {
            this.gAN.mD();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.DS().Ec()) {
            this.gAO.mC();
        } else {
            this.gAO.mD();
        }
    }

    private void bqC() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.DS().Ej()) {
            this.gAL.mC();
        } else {
            this.gAL.mD();
        }
    }

    private void bqD() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.DS().Ed()) {
            this.gAS.mC();
            this.gAT.setVisibility(0);
            bqF();
            return;
        }
        this.gAS.mD();
        this.gAT.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.aAW.setOnClickListener(msgRemindActivity);
        this.gAD.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gAF.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gAH.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gAG.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gAI.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gAJ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gAK.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gAL.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gAM.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gAN.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gAO.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gAP.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gAQ.setOnClickListener(msgRemindActivity);
        this.gAS.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gAT.setOnClickListener(msgRemindActivity);
        this.gAX.setOnClickListener(msgRemindActivity);
        this.gAZ.setOnClickListener(msgRemindActivity);
        this.gBd.setOnClickListener(msgRemindActivity);
    }

    public void lU(boolean z) {
        this.gAS.setLineVisibility(z);
        if (z) {
            this.gAT.setVisibility(0);
            bqF();
            am.i(this.gAT, f.C0146f.more_all);
            return;
        }
        this.gAT.setVisibility(8);
    }

    public void lV(boolean z) {
        if (z) {
            this.gAQ.setVisibility(0);
            this.gAP.setLineVisibility(true);
            am.i(this.gAQ, f.C0146f.more_all);
            return;
        }
        this.gAQ.setVisibility(8);
        this.gAP.setLineVisibility(false);
    }

    public void lW(boolean z) {
        if (z) {
            this.gAE.setVisibility(0);
        } else {
            this.gAE.setVisibility(8);
        }
    }

    public void bqE() {
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
            this.gAR.setText(this.gBc.getPageContext().getPageActivity().getString(f.j.sign_remind_time, new Object[]{str, str2}));
            this.gAQ.setVisibility(0);
            if (!this.gAP.iq()) {
                this.gAP.mC();
                return;
            }
            return;
        }
        this.gAR.setText(f.j.close);
        this.gAQ.setVisibility(8);
        if (this.gAP.iq()) {
            this.gAP.mD();
        }
    }

    public void bqF() {
        this.gAU.setText(com.baidu.tbadk.coreExtra.messageCenter.c.DS().Ef() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + com.baidu.tbadk.coreExtra.messageCenter.c.DS().Eg());
        this.gAY.setText(com.baidu.tbadk.coreExtra.messageCenter.c.DS().Ef());
        this.gBa.setText(com.baidu.tbadk.coreExtra.messageCenter.c.DS().Eg());
    }

    public BdSwitchView bqG() {
        return this.gAP.getSwitchView();
    }

    public BdSwitchView bqH() {
        return this.gAD.getSwitchView();
    }

    public View bqI() {
        return this.gAQ;
    }

    public BdSwitchView bqJ() {
        return this.gAS.getSwitchView();
    }

    public View bqK() {
        return this.gAT;
    }

    public LinearLayout bqL() {
        return this.gAX;
    }

    public LinearLayout bqM() {
        return this.gAZ;
    }

    public BdSwitchView bqN() {
        return this.gAM.getSwitchView();
    }

    public BdSwitchView bqO() {
        return this.gAN.getSwitchView();
    }

    public BdSwitchView bqP() {
        return this.gAO.getSwitchView();
    }

    public BdSwitchView bqQ() {
        return this.gAL.getSwitchView();
    }

    public BdSwitchView bqR() {
        return this.gAF.getSwitchView();
    }

    public BdSwitchView bqS() {
        return this.gAG.getSwitchView();
    }

    public BdSwitchView bqT() {
        return this.gAH.getSwitchView();
    }

    public BdSwitchView bqU() {
        return this.gAJ.getSwitchView();
    }

    public BdSwitchView bqV() {
        return this.gAK.getSwitchView();
    }

    public BdSwitchView bqW() {
        return this.gAI.getSwitchView();
    }

    public TbSettingTextTipView bqX() {
        return this.gBd;
    }

    public void bqY() {
        this.gAF.setOnSwitchStateChangeListener(null);
        this.gAF.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DS().DZ());
        this.gAF.setOnSwitchStateChangeListener(this.gBc);
    }

    public void bqZ() {
        this.gAG.setOnSwitchStateChangeListener(null);
        this.gAG.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DS().Ei());
        this.gAG.setOnSwitchStateChangeListener(this.gBc);
    }

    public void bra() {
        this.gAH.setOnSwitchStateChangeListener(null);
        this.gAH.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DS().DX());
        this.gAH.setOnSwitchStateChangeListener(this.gBc);
    }

    public void brb() {
        this.gAI.setOnSwitchStateChangeListener(null);
        this.gAI.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DS().DY());
        this.gAI.setOnSwitchStateChangeListener(this.gBc);
    }

    public void brc() {
        this.gAJ.setOnSwitchStateChangeListener(null);
        this.gAJ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DS().Ea());
        this.gAJ.setOnSwitchStateChangeListener(this.gBc);
    }

    public void brd() {
        this.gAK.setOnSwitchStateChangeListener(null);
        this.gAK.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DS().Eh());
        this.gAK.setOnSwitchStateChangeListener(this.gBc);
    }

    public void lX(boolean z) {
        if (this.gBb != z) {
            this.gBb = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.gBc.getPageContext().getString(f.j.msg_remind));
                this.gAV.setVisibility(0);
                this.gAW.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.gBc.getPageContext().getString(f.j.no_disturb_mode_time));
            this.gAW.setVisibility(0);
            this.gAV.setVisibility(8);
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
        this.gBc.getLayoutMode().setNightMode(i == 1);
        this.gBc.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gBc.getPageContext(), i);
        this.gAD.d(this.gBc.getPageContext(), i);
        this.gAF.d(this.gBc.getPageContext(), i);
        this.gAG.d(this.gBc.getPageContext(), i);
        this.gAH.d(this.gBc.getPageContext(), i);
        this.gAI.d(this.gBc.getPageContext(), i);
        this.gAJ.d(this.gBc.getPageContext(), i);
        this.gAK.d(this.gBc.getPageContext(), i);
        this.gAL.d(this.gBc.getPageContext(), i);
        this.gAM.d(this.gBc.getPageContext(), i);
        this.gAN.d(this.gBc.getPageContext(), i);
        this.gAO.d(this.gBc.getPageContext(), i);
        this.gAP.d(this.gBc.getPageContext(), i);
        this.gAS.d(this.gBc.getPageContext(), i);
        am.i(this.gAT, f.C0146f.more_all);
        am.i(this.gAX, f.C0146f.more_all);
        am.i(this.gAZ, f.C0146f.more_all);
        am.i(this.gAQ, f.C0146f.more_all);
        am.c((ImageView) this.gAT.findViewById(f.g.no_disturb_mode_time_arrow), f.C0146f.icon_arrow_gray_right_n);
        am.c((ImageView) this.gAQ.findViewById(f.g.sign_remind_arrow), f.C0146f.icon_arrow_gray_right_n);
        am.c((ImageView) this.gAX.findViewById(f.g.no_disturb_start_time_arrow), f.C0146f.icon_arrow_gray_right_n);
        am.c((ImageView) this.gAZ.findViewById(f.g.no_disturb_end_time_arrow), f.C0146f.icon_arrow_gray_right_n);
    }
}
