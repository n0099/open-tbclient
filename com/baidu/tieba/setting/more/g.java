package com.baidu.tieba.setting.more;

import android.support.v4.app.NotificationManagerCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.ScreenLockActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.GetFriendAndStrangerSwitchModel;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushInfo;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes26.dex */
public class g extends com.baidu.adp.base.c<MsgRemindActivity> {
    private LinearLayout ixn;
    private View mBack;
    private MsgSettingItemView mIA;
    private MsgSettingItemView mIB;
    private MsgSettingItemView mIC;
    private LinearLayout mIE;
    private TextView mIF;
    private MsgSettingItemView mIG;
    private LinearLayout mIH;
    private TextView mII;
    private LinearLayout mIJ;
    private LinearLayout mIK;
    private LinearLayout mIL;
    private TextView mIM;
    private LinearLayout mIN;
    private TextView mIO;
    public boolean mIP;
    private MsgRemindActivity mIQ;
    private TbSettingTextTipView mIR;
    private View mIS;
    private BdSwitchView mIT;
    private View mIU;
    private MsgSettingItemView mIV;
    private MsgSettingItemView mIc;
    private MsgSettingItemView mIe;
    private MsgSettingItemView mIf;
    private MsgSettingItemView mIo;
    private LinearLayout mIq;
    private MsgSettingItemView mIr;
    private MsgSettingItemView mIt;
    private MsgSettingItemView mIu;
    private MsgSettingItemView mIv;
    private MsgSettingItemView mIw;
    private MsgSettingItemView mIx;
    private MsgSettingItemView mIy;
    private MsgSettingItemView mIz;
    private NavigationBar mNavigationBar;

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.ixn = null;
        this.mNavigationBar = null;
        this.mIP = true;
        this.mIQ = msgRemindActivity;
        msgRemindActivity.setContentView(R.layout.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        dEI();
        dEL();
        dEK();
        dEJ();
        dEM();
        d(msgRemindActivity);
        dED();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.ixn = (LinearLayout) msgRemindActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(R.string.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mIJ = (LinearLayout) msgRemindActivity.findViewById(R.id.front_container);
        this.mIK = (LinearLayout) msgRemindActivity.findViewById(R.id.back_container);
        this.mIo = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.receive_message_swtich);
        this.mIo.setText(R.string.receive_msg_text);
        this.mIo.setLineVisibility(false);
        this.mIq = (LinearLayout) msgRemindActivity.findViewById(R.id.receive_message_container);
        this.mIr = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.reply_check_box);
        this.mIr.setText(R.string.reply);
        this.mIt = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.zan_check_box);
        this.mIt.setVisibility(0);
        this.mIt.setText(R.string.action_praise_default);
        this.mIu = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.at_me_check_box);
        this.mIu.setText(R.string.mention_atme);
        this.mIv = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.new_fans_swtich);
        this.mIv.setText(R.string.new_fans);
        this.mIw = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.chat_msg_swtich);
        this.mIw.setText(R.string.chat_msg_text);
        this.mIx = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.group_chat_swtich);
        this.mIx.setLineVisibility(false);
        this.mIx.setText(R.string.group_chat_text);
        this.mIy = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.screen_lock_swtich);
        this.mIy.setText(R.string.remind_screen_lock);
        this.mIy.setLineVisibility(false);
        this.mIz = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.tone_remind_swtich);
        this.mIz.setText(R.string.remind_tone);
        this.mIA = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.vibrate_remind_swtich);
        this.mIA.setText(R.string.remind_vibrate);
        this.mIB = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.light_remind_swtich);
        this.mIB.setLineVisibility(true);
        this.mIB.setText(R.string.remind_light);
        this.mIC = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.sign_remind_swtich);
        this.mIC.setText(R.string.sign_remind_outline);
        this.mIE = (LinearLayout) msgRemindActivity.findViewById(R.id.sign_remind);
        this.mIF = (TextView) msgRemindActivity.findViewById(R.id.sign_remind_time);
        this.mIG = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.no_disturb_swtich);
        this.mIG.setText(R.string.no_disturb_mode);
        this.mIG.setLineVisibility(false);
        this.mIH = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_container);
        this.mII = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_value);
        this.mIL = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_start_time);
        this.mIM = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_start_time_value);
        this.mIN = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_end_time);
        this.mIO = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_end_time_value);
        this.mIR = (TbSettingTextTipView) msgRemindActivity.findViewById(R.id.msg_receive_item_view);
        this.mIS = msgRemindActivity.findViewById(R.id.layout_system_msg_permission);
        boolean areNotificationsEnabled = NotificationManagerCompat.from(msgRemindActivity).areNotificationsEnabled();
        this.mIS.setVisibility(areNotificationsEnabled ? 8 : 0);
        TiebaStatic.log(new aq("c13890").al("obj_type", areNotificationsEnabled ? 1 : 2));
        this.mIT = (BdSwitchView) msgRemindActivity.findViewById(R.id.system_msg_permission_switch);
        this.mIU = msgRemindActivity.findViewById(R.id.system_msg_permission_switch_cover);
        this.mIU.setOnClickListener(msgRemindActivity);
        this.mIc = (MsgSettingItemView) this.mIQ.findViewById(R.id.item_view_friend_msg);
        this.mIc.setText(R.string.friend_msg_switch);
        this.mIc.setOnSwitchStateChangeListener(this.mIQ);
        this.mIe = (MsgSettingItemView) this.mIQ.findViewById(R.id.item_view_stranger_msg);
        this.mIe.setText(R.string.stranger_msg_switch);
        this.mIe.setOnSwitchStateChangeListener(this.mIQ);
        this.mIe.setLineVisibility(false);
        dEw();
        this.mIf = (MsgSettingItemView) this.mIQ.findViewById(R.id.item_view_forum_broadcast_msg);
        this.mIf.setText(R.string.receive_forum_broadcast_message);
        this.mIf.setOnSwitchStateChangeListener(this.mIQ);
        this.mIf.setLineVisibility(false);
        dEx();
        this.mIV = (MsgSettingItemView) this.mIQ.findViewById(R.id.item_view_tb_selection_msg);
        this.mIV.setText(R.string.official_push_message_switch_text);
        this.mIV.setOnSwitchStateChangeListener(this.mIQ);
        this.mIV.setLineVisibility(false);
        dEC();
    }

    private void dEw() {
        if (this.mIc == null || this.mIe == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.mIc.getSwitchView().turnOnNoCallback();
                this.mIc.setLineVisibility(true);
                this.mIe.getSwitchView().turnOffNoCallback();
                return;
            default:
                this.mIc.getSwitchView().turnOffNoCallback();
                this.mIc.setLineVisibility(false);
                this.mIe.setVisibility(8);
                this.mIe.getSwitchView().turnOffNoCallback();
                return;
        }
    }

    private void dEx() {
        if (this.mIf != null) {
            this.mIf.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bwv().bwP());
        }
    }

    private void dEC() {
        if (this.mIV != null) {
            this.mIV.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bwv().bwQ());
            new OfficialAccountPushModel(new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.g.1
                @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
                public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
                    boolean z;
                    Iterator<OfficialAccountPushInfo> it = arrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        }
                        OfficialAccountPushInfo next = it.next();
                        if (next.uid == 1501754229) {
                            z = next.is_on == 1;
                        }
                    }
                    if (com.baidu.tbadk.coreExtra.messageCenter.d.bwv().bwQ() != z) {
                        g.this.mIV.setSwitchStateNoCallback(z);
                    }
                }
            }).dFF();
        }
    }

    private void dED() {
        dEE();
        dEF();
        dEG();
        dEH();
    }

    private void dEE() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.mIG.setVisibility(8);
            this.mIH.setVisibility(8);
            this.mIo.setVisibility(8);
            this.mIq.setVisibility(8);
            this.mIC.setVisibility(8);
            this.mIE.setVisibility(8);
            this.mIz.setVisibility(8);
            this.mIA.setVisibility(8);
            this.mIB.setVisibility(8);
            this.mIy.setVisibility(8);
        }
    }

    private void dEF() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.mIy.setLineVisibility(true);
        } else {
            this.mIy.setLineVisibility(false);
        }
    }

    private void dEG() {
        this.mIw.setLineVisibility(TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class));
    }

    private void dEH() {
        TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class);
    }

    public View Ue() {
        return this.mBack;
    }

    private void dEI() {
        this.mIr.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bwv().bwC());
        this.mIt.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bwv().bwM());
        this.mIu.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bwv().bwA());
        this.mIv.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bwv().bwB());
        this.mIw.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bwv().bwD());
        this.mIx.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bwv().bwL());
    }

    private void dEJ() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bwv().isSignAlertOn()) {
            this.mIC.turnOn();
            this.mIE.setVisibility(0);
            this.mIC.setLineVisibility(true);
            dEN();
            return;
        }
        this.mIC.turnOff();
        this.mIC.setLineVisibility(false);
        this.mIE.setVisibility(8);
    }

    private void dEK() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bwv().bwE()) {
            this.mIz.turnOnNoCallback();
        } else {
            this.mIz.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bwv().bwH()) {
            this.mIA.turnOnNoCallback();
        } else {
            this.mIA.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bwv().bwF()) {
            this.mIB.turnOnNoCallback();
        } else {
            this.mIB.turnOffNoCallback();
        }
    }

    private void dEL() {
    }

    private void dEM() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bwv().bwG()) {
            this.mIG.turnOnNoCallback();
            this.mIH.setVisibility(0);
            dEO();
            return;
        }
        this.mIG.turnOffNoCallback();
        this.mIH.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.mBack.setOnClickListener(msgRemindActivity);
        this.mIr.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mIu.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mIt.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mIv.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mIw.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mIx.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mIy.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mIz.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mIA.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mIB.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mIC.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mIE.setOnClickListener(msgRemindActivity);
        this.mIG.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mIH.setOnClickListener(msgRemindActivity);
        this.mIL.setOnClickListener(msgRemindActivity);
        this.mIN.setOnClickListener(msgRemindActivity);
        this.mIR.setOnClickListener(msgRemindActivity);
        this.mNavigationBar.getCenterText().setOnClickListener(msgRemindActivity);
    }

    public void wU(boolean z) {
        this.mIG.setLineVisibility(z);
        if (z) {
            this.mIH.setVisibility(0);
            dEO();
            ap.setBackgroundResource(this.mIH, R.drawable.more_all);
            return;
        }
        this.mIH.setVisibility(8);
    }

    public void wV(boolean z) {
        if (z) {
            this.mIE.setVisibility(0);
            this.mIC.setLineVisibility(true);
            ap.setBackgroundResource(this.mIE, R.drawable.more_all);
            return;
        }
        this.mIE.setVisibility(8);
        this.mIC.setLineVisibility(false);
    }

    public void wW(boolean z) {
    }

    public void dEN() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bwv().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.d.bwv().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.d.bwv().getSignAlertMins();
            this.mIF.setText(this.mIQ.getString(R.string.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.mIE.setVisibility(0);
            if (!this.mIC.isOn()) {
                this.mIC.turnOnNoCallback();
                return;
            }
            return;
        }
        this.mIF.setText(R.string.close);
        this.mIE.setVisibility(8);
        if (this.mIC.isOn()) {
            this.mIC.turnOffNoCallback();
        }
    }

    public void dEO() {
        String bwI = com.baidu.tbadk.coreExtra.messageCenter.d.bwv().bwI();
        String bwJ = com.baidu.tbadk.coreExtra.messageCenter.d.bwv().bwJ();
        this.mII.setText(bwI + Constants.ACCEPT_TIME_SEPARATOR_SERVER + bwJ);
        this.mIM.setText(bwI);
        this.mIO.setText(bwJ);
    }

    public BdSwitchView dEP() {
        return this.mIC.getSwitchView();
    }

    public BdSwitchView dEQ() {
        return this.mIo.getSwitchView();
    }

    public View dER() {
        return this.mIE;
    }

    public BdSwitchView dES() {
        return this.mIG.getSwitchView();
    }

    public View dET() {
        return this.mIH;
    }

    public LinearLayout dEU() {
        return this.mIL;
    }

    public LinearLayout dEV() {
        return this.mIN;
    }

    public BdSwitchView dEW() {
        return this.mIz.getSwitchView();
    }

    public BdSwitchView dEX() {
        return this.mIA.getSwitchView();
    }

    public BdSwitchView dEY() {
        return this.mIB.getSwitchView();
    }

    public BdSwitchView dEZ() {
        return this.mIy.getSwitchView();
    }

    public BdSwitchView dFa() {
        return this.mIr.getSwitchView();
    }

    public BdSwitchView dFb() {
        return this.mIt.getSwitchView();
    }

    public BdSwitchView dFc() {
        return this.mIu.getSwitchView();
    }

    public BdSwitchView dFd() {
        return this.mIw.getSwitchView();
    }

    public BdSwitchView dFe() {
        return this.mIx.getSwitchView();
    }

    public BdSwitchView dFf() {
        return this.mIv.getSwitchView();
    }

    public TbSettingTextTipView dFg() {
        return this.mIR;
    }

    public TextView dFh() {
        return this.mNavigationBar.getCenterText();
    }

    public void dFi() {
        this.mIr.setOnSwitchStateChangeListener(null);
        this.mIr.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bwv().bwC());
        this.mIr.setOnSwitchStateChangeListener(this.mIQ);
    }

    public void dFj() {
        this.mIt.setOnSwitchStateChangeListener(null);
        this.mIt.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bwv().bwM());
        this.mIt.setOnSwitchStateChangeListener(this.mIQ);
    }

    public void dFk() {
        this.mIu.setOnSwitchStateChangeListener(null);
        this.mIu.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bwv().bwA());
        this.mIu.setOnSwitchStateChangeListener(this.mIQ);
    }

    public void dFl() {
        this.mIv.setOnSwitchStateChangeListener(null);
        this.mIv.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bwv().bwB());
        this.mIv.setOnSwitchStateChangeListener(this.mIQ);
    }

    public void dFm() {
        this.mIw.setOnSwitchStateChangeListener(null);
        this.mIw.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bwv().bwD());
        this.mIw.setOnSwitchStateChangeListener(this.mIQ);
    }

    public void dFn() {
        this.mIx.setOnSwitchStateChangeListener(null);
        this.mIx.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bwv().bwL());
        this.mIx.setOnSwitchStateChangeListener(this.mIQ);
    }

    public void wX(boolean z) {
        if (this.mIP != z) {
            this.mIP = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.mIQ.getString(R.string.msg_remind));
                this.mIJ.setVisibility(0);
                this.mIK.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.mIQ.getString(R.string.no_disturb_mode_time));
            this.mIK.setVisibility(0);
            this.mIJ.setVisibility(8);
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
    /* JADX DEBUG: Multi-variable search result rejected for r1v37, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.mIQ.getLayoutMode().setNightMode(i == 1);
        this.mIQ.getLayoutMode().onModeChanged(this.ixn);
        this.mNavigationBar.onChangeSkinType(this.mIQ.getPageContext(), i);
        this.mIo.onChangeSkinType(this.mIQ.getPageContext(), i);
        this.mIr.onChangeSkinType(this.mIQ.getPageContext(), i);
        this.mIt.onChangeSkinType(this.mIQ.getPageContext(), i);
        this.mIu.onChangeSkinType(this.mIQ.getPageContext(), i);
        this.mIv.onChangeSkinType(this.mIQ.getPageContext(), i);
        this.mIw.onChangeSkinType(this.mIQ.getPageContext(), i);
        this.mIx.onChangeSkinType(this.mIQ.getPageContext(), i);
        this.mIy.onChangeSkinType(this.mIQ.getPageContext(), i);
        this.mIz.onChangeSkinType(this.mIQ.getPageContext(), i);
        this.mIA.onChangeSkinType(this.mIQ.getPageContext(), i);
        this.mIB.onChangeSkinType(this.mIQ.getPageContext(), i);
        this.mIC.onChangeSkinType(this.mIQ.getPageContext(), i);
        this.mIG.onChangeSkinType(this.mIQ.getPageContext(), i);
        this.mIc.onChangeSkinType(this.mIQ.getPageContext(), i);
        this.mIe.onChangeSkinType(this.mIQ.getPageContext(), i);
        this.mIf.onChangeSkinType(this.mIQ.getPageContext(), i);
        this.mIV.onChangeSkinType(this.mIQ.getPageContext(), i);
        ap.setBackgroundResource(this.mIH, R.drawable.more_all);
        ap.setBackgroundResource(this.mIL, R.drawable.more_all);
        ap.setBackgroundResource(this.mIN, R.drawable.more_all);
        ap.setBackgroundResource(this.mIE, R.drawable.more_all);
        SvgManager.brn().a((ImageView) this.mIH.findViewById(R.id.no_disturb_mode_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.brn().a((ImageView) this.mIE.findViewById(R.id.sign_remind_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.brn().a((ImageView) this.mIL.findViewById(R.id.no_disturb_start_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.brn().a((ImageView) this.mIN.findViewById(R.id.no_disturb_end_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
    }

    public BdSwitchView dEy() {
        return this.mIc.getSwitchView();
    }

    public BdSwitchView dEz() {
        return this.mIe.getSwitchView();
    }

    public BdSwitchView dEA() {
        return this.mIf.getSwitchView();
    }

    public BdSwitchView dFo() {
        return this.mIV.getSwitchView();
    }

    public void wT(boolean z) {
        this.mIc.setLineVisibility(z);
    }

    public void wS(boolean z) {
        if (z) {
            this.mIe.setVisibility(0);
        } else {
            this.mIe.setVisibility(8);
        }
    }

    public void dFp() {
        com.baidu.tbadk.coreExtra.messageCenter.f.bwR().a(this.mIQ.getActivity(), this.ixn);
    }

    public void onDestroy() {
    }

    public void onResume() {
        int i;
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.mIQ).areNotificationsEnabled();
        if (areNotificationsEnabled) {
            this.mIT.turnOn();
            i = 1;
        } else {
            this.mIT.turnOff();
            i = 2;
        }
        this.mIS.setVisibility(areNotificationsEnabled ? 8 : 0);
        rI(areNotificationsEnabled);
        TiebaStatic.log(new aq("c13889").al("obj_locate", i).al("obj_source", 8));
    }

    private void rI(boolean z) {
        if (z) {
            this.mIr.getSwitchView().setEnabled(true);
            this.mIt.getSwitchView().setEnabled(true);
            this.mIv.getSwitchView().setEnabled(true);
            this.mIu.getSwitchView().setEnabled(true);
            this.mIc.getSwitchView().setEnabled(true);
            this.mIe.getSwitchView().setEnabled(true);
            this.mIf.getSwitchView().setEnabled(true);
            this.mIV.getSwitchView().setEnabled(true);
            this.mIC.getSwitchView().setEnabled(true);
            this.mIG.getSwitchView().setEnabled(true);
            this.mIr.getSwitchView().setAlpha(1.0f);
            this.mIt.getSwitchView().setAlpha(1.0f);
            this.mIv.getSwitchView().setAlpha(1.0f);
            this.mIu.getSwitchView().setAlpha(1.0f);
            this.mIc.getSwitchView().setAlpha(1.0f);
            this.mIe.getSwitchView().setAlpha(1.0f);
            this.mIf.getSwitchView().setAlpha(1.0f);
            this.mIV.getSwitchView().setAlpha(1.0f);
            this.mIC.getSwitchView().setAlpha(1.0f);
            this.mIG.getSwitchView().setAlpha(1.0f);
            return;
        }
        this.mIr.getSwitchView().setEnabled(false);
        this.mIt.getSwitchView().setEnabled(false);
        this.mIv.getSwitchView().setEnabled(false);
        this.mIu.getSwitchView().setEnabled(false);
        this.mIc.getSwitchView().setEnabled(false);
        this.mIe.getSwitchView().setEnabled(false);
        this.mIf.getSwitchView().setEnabled(false);
        this.mIV.getSwitchView().setEnabled(false);
        this.mIC.getSwitchView().setEnabled(false);
        this.mIG.getSwitchView().setEnabled(false);
        this.mIr.getSwitchView().setAlpha(0.3f);
        this.mIt.getSwitchView().setAlpha(0.3f);
        this.mIv.getSwitchView().setAlpha(0.3f);
        this.mIu.getSwitchView().setAlpha(0.3f);
        this.mIc.getSwitchView().setAlpha(0.3f);
        this.mIe.getSwitchView().setAlpha(0.3f);
        this.mIf.getSwitchView().setAlpha(0.3f);
        this.mIV.getSwitchView().setAlpha(0.3f);
        this.mIC.getSwitchView().setAlpha(0.3f);
        this.mIG.getSwitchView().setAlpha(0.3f);
    }
}
