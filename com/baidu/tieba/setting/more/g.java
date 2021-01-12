package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationManagerCompat;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.ScreenLockActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
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
/* loaded from: classes7.dex */
public class g extends com.baidu.adp.base.d<MsgRemindActivity> {
    private LinearLayout iQA;
    private View mBack;
    private NavigationBar mNavigationBar;
    private MsgSettingItemView mXI;
    private LinearLayout mXJ;
    private MsgSettingItemView mXK;
    private MsgSettingItemView mXL;
    private MsgSettingItemView mXM;
    private MsgSettingItemView mXN;
    private MsgSettingItemView mXO;
    private MsgSettingItemView mXP;
    private MsgSettingItemView mXQ;
    private MsgSettingItemView mXR;
    private MsgSettingItemView mXS;
    private MsgSettingItemView mXT;
    private MsgSettingItemView mXU;
    private LinearLayout mXV;
    private TextView mXW;
    private MsgSettingItemView mXX;
    private LinearLayout mXY;
    private TextView mXZ;
    private MsgSettingItemView mXx;
    private MsgSettingItemView mXy;
    private MsgSettingItemView mXz;
    private LinearLayout mYa;
    private LinearLayout mYb;
    private LinearLayout mYc;
    private TextView mYd;
    private LinearLayout mYe;
    private TextView mYf;
    public boolean mYg;
    private MsgRemindActivity mYh;
    private TbSettingTextTipView mYi;
    private View mYj;
    private BdSwitchView mYk;
    private View mYl;
    private MsgSettingItemView mYm;

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.iQA = null;
        this.mNavigationBar = null;
        this.mYg = true;
        this.mYh = msgRemindActivity;
        msgRemindActivity.setContentView(R.layout.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        dFx();
        dFA();
        dFz();
        dFy();
        dFB();
        d(msgRemindActivity);
        dFs();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.iQA = (LinearLayout) msgRemindActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(R.string.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mYa = (LinearLayout) msgRemindActivity.findViewById(R.id.front_container);
        this.mYb = (LinearLayout) msgRemindActivity.findViewById(R.id.back_container);
        this.mXI = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.receive_message_swtich);
        this.mXI.setText(R.string.receive_msg_text);
        this.mXI.setLineVisibility(false);
        this.mXJ = (LinearLayout) msgRemindActivity.findViewById(R.id.receive_message_container);
        this.mXK = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.reply_check_box);
        this.mXK.setText(R.string.reply);
        this.mXL = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.zan_check_box);
        this.mXL.setVisibility(0);
        this.mXL.setText(R.string.action_praise_default);
        this.mXM = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.at_me_check_box);
        this.mXM.setText(R.string.mention_atme);
        this.mXN = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.new_fans_swtich);
        this.mXN.setText(R.string.new_fans);
        this.mXO = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.chat_msg_swtich);
        this.mXO.setText(R.string.chat_msg_text);
        this.mXP = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.group_chat_swtich);
        this.mXP.setLineVisibility(false);
        this.mXP.setText(R.string.group_chat_text);
        this.mXQ = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.screen_lock_swtich);
        this.mXQ.setText(R.string.remind_screen_lock);
        this.mXQ.setLineVisibility(false);
        this.mXR = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.tone_remind_swtich);
        this.mXR.setText(R.string.remind_tone);
        this.mXS = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.vibrate_remind_swtich);
        this.mXS.setText(R.string.remind_vibrate);
        this.mXT = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.light_remind_swtich);
        this.mXT.setLineVisibility(true);
        this.mXT.setText(R.string.remind_light);
        this.mXU = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.sign_remind_swtich);
        this.mXU.setText(R.string.sign_remind_outline);
        this.mXV = (LinearLayout) msgRemindActivity.findViewById(R.id.sign_remind);
        this.mXW = (TextView) msgRemindActivity.findViewById(R.id.sign_remind_time);
        this.mXX = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.no_disturb_swtich);
        this.mXX.setText(R.string.no_disturb_mode);
        this.mXX.setLineVisibility(false);
        this.mXY = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_container);
        this.mXZ = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_value);
        this.mYc = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_start_time);
        this.mYd = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_start_time_value);
        this.mYe = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_end_time);
        this.mYf = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_end_time_value);
        this.mYi = (TbSettingTextTipView) msgRemindActivity.findViewById(R.id.msg_receive_item_view);
        this.mYj = msgRemindActivity.findViewById(R.id.layout_system_msg_permission);
        boolean areNotificationsEnabled = NotificationManagerCompat.from(msgRemindActivity).areNotificationsEnabled();
        this.mYj.setVisibility(areNotificationsEnabled ? 8 : 0);
        TiebaStatic.log(new aq("c13890").an("obj_type", areNotificationsEnabled ? 1 : 2));
        this.mYk = (BdSwitchView) msgRemindActivity.findViewById(R.id.system_msg_permission_switch);
        this.mYl = msgRemindActivity.findViewById(R.id.system_msg_permission_switch_cover);
        this.mYl.setOnClickListener(msgRemindActivity);
        this.mXx = (MsgSettingItemView) this.mYh.findViewById(R.id.item_view_friend_msg);
        this.mXx.setText(R.string.friend_msg_switch);
        this.mXx.setOnSwitchStateChangeListener(this.mYh);
        this.mXy = (MsgSettingItemView) this.mYh.findViewById(R.id.item_view_stranger_msg);
        this.mXy.setText(R.string.stranger_msg_switch);
        this.mXy.setOnSwitchStateChangeListener(this.mYh);
        this.mXy.setLineVisibility(false);
        dFl();
        this.mXz = (MsgSettingItemView) this.mYh.findViewById(R.id.item_view_forum_broadcast_msg);
        this.mXz.setText(R.string.receive_forum_broadcast_message);
        this.mXz.setOnSwitchStateChangeListener(this.mYh);
        this.mXz.setLineVisibility(false);
        dFm();
        this.mYm = (MsgSettingItemView) this.mYh.findViewById(R.id.item_view_tb_selection_msg);
        this.mYm.setText(R.string.official_push_message_switch_text);
        this.mYm.setOnSwitchStateChangeListener(this.mYh);
        this.mYm.setLineVisibility(false);
        dFr();
    }

    private void dFl() {
        if (this.mXx == null || this.mXy == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.mXx.getSwitchView().turnOnNoCallback();
                this.mXx.setLineVisibility(true);
                this.mXy.getSwitchView().turnOffNoCallback();
                return;
            default:
                this.mXx.getSwitchView().turnOffNoCallback();
                this.mXx.setLineVisibility(false);
                this.mXy.setVisibility(8);
                this.mXy.getSwitchView().turnOffNoCallback();
                return;
        }
    }

    private void dFm() {
        if (this.mXz != null) {
            this.mXz.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bxM().byg());
        }
    }

    private void dFr() {
        if (this.mYm != null) {
            this.mYm.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bxM().byh());
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
                    if (com.baidu.tbadk.coreExtra.messageCenter.d.bxM().byh() != z) {
                        g.this.mYm.setSwitchStateNoCallback(z);
                    }
                }
            }).dGE();
        }
    }

    private void dFs() {
        dFt();
        dFu();
        dFv();
        dFw();
    }

    private void dFt() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.mXX.setVisibility(8);
            this.mXY.setVisibility(8);
            this.mXI.setVisibility(8);
            this.mXJ.setVisibility(8);
            this.mXU.setVisibility(8);
            this.mXV.setVisibility(8);
            this.mXR.setVisibility(8);
            this.mXS.setVisibility(8);
            this.mXT.setVisibility(8);
            this.mXQ.setVisibility(8);
        }
    }

    private void dFu() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.mXQ.setLineVisibility(true);
        } else {
            this.mXQ.setLineVisibility(false);
        }
    }

    private void dFv() {
        this.mXO.setLineVisibility(TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class));
    }

    private void dFw() {
        TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class);
    }

    public View Tf() {
        return this.mBack;
    }

    private void dFx() {
        this.mXK.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bxM().bxT());
        this.mXL.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bxM().byd());
        this.mXM.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bxM().bxR());
        this.mXN.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bxM().bxS());
        this.mXO.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bxM().bxU());
        this.mXP.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bxM().byc());
    }

    private void dFy() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bxM().isSignAlertOn()) {
            this.mXU.turnOn();
            this.mXV.setVisibility(0);
            this.mXU.setLineVisibility(true);
            dFC();
            return;
        }
        this.mXU.turnOff();
        this.mXU.setLineVisibility(false);
        this.mXV.setVisibility(8);
    }

    private void dFz() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bxM().bxV()) {
            this.mXR.turnOnNoCallback();
        } else {
            this.mXR.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bxM().bxY()) {
            this.mXS.turnOnNoCallback();
        } else {
            this.mXS.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bxM().bxW()) {
            this.mXT.turnOnNoCallback();
        } else {
            this.mXT.turnOffNoCallback();
        }
    }

    private void dFA() {
    }

    private void dFB() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bxM().bxX()) {
            this.mXX.turnOnNoCallback();
            this.mXY.setVisibility(0);
            dFD();
            return;
        }
        this.mXX.turnOffNoCallback();
        this.mXY.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.mBack.setOnClickListener(msgRemindActivity);
        this.mXK.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mXM.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mXL.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mXN.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mXO.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mXP.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mXQ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mXR.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mXS.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mXT.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mXU.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mXV.setOnClickListener(msgRemindActivity);
        this.mXX.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mXY.setOnClickListener(msgRemindActivity);
        this.mYc.setOnClickListener(msgRemindActivity);
        this.mYe.setOnClickListener(msgRemindActivity);
        this.mYi.setOnClickListener(msgRemindActivity);
        this.mNavigationBar.getCenterText().setOnClickListener(msgRemindActivity);
    }

    public void xy(boolean z) {
        this.mXX.setLineVisibility(z);
        if (z) {
            this.mXY.setVisibility(0);
            dFD();
            ao.setBackgroundResource(this.mXY, R.drawable.more_all);
            return;
        }
        this.mXY.setVisibility(8);
    }

    public void xz(boolean z) {
        if (z) {
            this.mXV.setVisibility(0);
            this.mXU.setLineVisibility(true);
            ao.setBackgroundResource(this.mXV, R.drawable.more_all);
            return;
        }
        this.mXV.setVisibility(8);
        this.mXU.setLineVisibility(false);
    }

    public void xA(boolean z) {
    }

    public void dFC() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bxM().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.d.bxM().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.d.bxM().getSignAlertMins();
            this.mXW.setText(this.mYh.getString(R.string.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.mXV.setVisibility(0);
            if (!this.mXU.isOn()) {
                this.mXU.turnOnNoCallback();
                return;
            }
            return;
        }
        this.mXW.setText(R.string.close);
        this.mXV.setVisibility(8);
        if (this.mXU.isOn()) {
            this.mXU.turnOffNoCallback();
        }
    }

    public void dFD() {
        String bxZ = com.baidu.tbadk.coreExtra.messageCenter.d.bxM().bxZ();
        String bya = com.baidu.tbadk.coreExtra.messageCenter.d.bxM().bya();
        this.mXZ.setText(bxZ + Constants.ACCEPT_TIME_SEPARATOR_SERVER + bya);
        this.mYd.setText(bxZ);
        this.mYf.setText(bya);
    }

    public BdSwitchView dFE() {
        return this.mXU.getSwitchView();
    }

    public BdSwitchView dFF() {
        return this.mXI.getSwitchView();
    }

    public View dFG() {
        return this.mXV;
    }

    public BdSwitchView dFH() {
        return this.mXX.getSwitchView();
    }

    public View dFI() {
        return this.mXY;
    }

    public LinearLayout dFJ() {
        return this.mYc;
    }

    public LinearLayout dFK() {
        return this.mYe;
    }

    public BdSwitchView dFL() {
        return this.mXR.getSwitchView();
    }

    public BdSwitchView dFM() {
        return this.mXS.getSwitchView();
    }

    public BdSwitchView dFN() {
        return this.mXT.getSwitchView();
    }

    public BdSwitchView dFO() {
        return this.mXQ.getSwitchView();
    }

    public BdSwitchView dFP() {
        return this.mXK.getSwitchView();
    }

    public BdSwitchView dFQ() {
        return this.mXL.getSwitchView();
    }

    public BdSwitchView dFR() {
        return this.mXM.getSwitchView();
    }

    public BdSwitchView dFS() {
        return this.mXO.getSwitchView();
    }

    public BdSwitchView dFT() {
        return this.mXP.getSwitchView();
    }

    public BdSwitchView dFU() {
        return this.mXN.getSwitchView();
    }

    public TbSettingTextTipView dFV() {
        return this.mYi;
    }

    public TextView dFW() {
        return this.mNavigationBar.getCenterText();
    }

    public void dFX() {
        this.mXK.setOnSwitchStateChangeListener(null);
        this.mXK.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bxM().bxT());
        this.mXK.setOnSwitchStateChangeListener(this.mYh);
    }

    public void dFY() {
        this.mXL.setOnSwitchStateChangeListener(null);
        this.mXL.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bxM().byd());
        this.mXL.setOnSwitchStateChangeListener(this.mYh);
    }

    public void dFZ() {
        this.mXM.setOnSwitchStateChangeListener(null);
        this.mXM.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bxM().bxR());
        this.mXM.setOnSwitchStateChangeListener(this.mYh);
    }

    public void dGa() {
        this.mXN.setOnSwitchStateChangeListener(null);
        this.mXN.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bxM().bxS());
        this.mXN.setOnSwitchStateChangeListener(this.mYh);
    }

    public void dGb() {
        this.mXO.setOnSwitchStateChangeListener(null);
        this.mXO.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bxM().bxU());
        this.mXO.setOnSwitchStateChangeListener(this.mYh);
    }

    public void dGc() {
        this.mXP.setOnSwitchStateChangeListener(null);
        this.mXP.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bxM().byc());
        this.mXP.setOnSwitchStateChangeListener(this.mYh);
    }

    public void xB(boolean z) {
        if (this.mYg != z) {
            this.mYg = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.mYh.getString(R.string.msg_remind));
                this.mYa.setVisibility(0);
                this.mYb.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.mYh.getString(R.string.no_disturb_mode_time));
            this.mYb.setVisibility(0);
            this.mYa.setVisibility(8);
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
        this.mYh.getLayoutMode().setNightMode(i == 1);
        this.mYh.getLayoutMode().onModeChanged(this.iQA);
        this.mNavigationBar.onChangeSkinType(this.mYh.getPageContext(), i);
        this.mXI.onChangeSkinType(this.mYh.getPageContext(), i);
        this.mXK.onChangeSkinType(this.mYh.getPageContext(), i);
        this.mXL.onChangeSkinType(this.mYh.getPageContext(), i);
        this.mXM.onChangeSkinType(this.mYh.getPageContext(), i);
        this.mXN.onChangeSkinType(this.mYh.getPageContext(), i);
        this.mXO.onChangeSkinType(this.mYh.getPageContext(), i);
        this.mXP.onChangeSkinType(this.mYh.getPageContext(), i);
        this.mXQ.onChangeSkinType(this.mYh.getPageContext(), i);
        this.mXR.onChangeSkinType(this.mYh.getPageContext(), i);
        this.mXS.onChangeSkinType(this.mYh.getPageContext(), i);
        this.mXT.onChangeSkinType(this.mYh.getPageContext(), i);
        this.mXU.onChangeSkinType(this.mYh.getPageContext(), i);
        this.mXX.onChangeSkinType(this.mYh.getPageContext(), i);
        this.mXx.onChangeSkinType(this.mYh.getPageContext(), i);
        this.mXy.onChangeSkinType(this.mYh.getPageContext(), i);
        this.mXz.onChangeSkinType(this.mYh.getPageContext(), i);
        this.mYm.onChangeSkinType(this.mYh.getPageContext(), i);
        ao.setBackgroundResource(this.mXY, R.drawable.more_all);
        ao.setBackgroundResource(this.mYc, R.drawable.more_all);
        ao.setBackgroundResource(this.mYe, R.drawable.more_all);
        ao.setBackgroundResource(this.mXV, R.drawable.more_all);
        SvgManager.bsx().a((ImageView) this.mXY.findViewById(R.id.no_disturb_mode_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bsx().a((ImageView) this.mXV.findViewById(R.id.sign_remind_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bsx().a((ImageView) this.mYc.findViewById(R.id.no_disturb_start_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bsx().a((ImageView) this.mYe.findViewById(R.id.no_disturb_end_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
    }

    public BdSwitchView dFn() {
        return this.mXx.getSwitchView();
    }

    public BdSwitchView dFo() {
        return this.mXy.getSwitchView();
    }

    public BdSwitchView dFp() {
        return this.mXz.getSwitchView();
    }

    public BdSwitchView dGd() {
        return this.mYm.getSwitchView();
    }

    public void xx(boolean z) {
        this.mXx.setLineVisibility(z);
    }

    public void xw(boolean z) {
        if (z) {
            this.mXy.setVisibility(0);
        } else {
            this.mXy.setVisibility(8);
        }
    }

    public void dGe() {
        com.baidu.tbadk.coreExtra.messageCenter.f.byi().a(this.mYh.getActivity(), this.iQA);
    }

    public void onDestroy() {
    }

    public void onResume() {
        int i;
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.mYh).areNotificationsEnabled();
        if (areNotificationsEnabled) {
            this.mYk.turnOn();
            i = 1;
        } else {
            this.mYk.turnOff();
            i = 2;
        }
        this.mYj.setVisibility(areNotificationsEnabled ? 8 : 0);
        xC(areNotificationsEnabled);
        TiebaStatic.log(new aq("c13889").an("obj_locate", i).an("obj_source", 8));
    }

    private void xC(boolean z) {
        if (z) {
            this.mXK.getSwitchView().setEnabled(true);
            this.mXL.getSwitchView().setEnabled(true);
            this.mXN.getSwitchView().setEnabled(true);
            this.mXM.getSwitchView().setEnabled(true);
            this.mXx.getSwitchView().setEnabled(true);
            this.mXy.getSwitchView().setEnabled(true);
            this.mXz.getSwitchView().setEnabled(true);
            this.mYm.getSwitchView().setEnabled(true);
            this.mXU.getSwitchView().setEnabled(true);
            this.mXX.getSwitchView().setEnabled(true);
            this.mXK.getSwitchView().setAlpha(1.0f);
            this.mXL.getSwitchView().setAlpha(1.0f);
            this.mXN.getSwitchView().setAlpha(1.0f);
            this.mXM.getSwitchView().setAlpha(1.0f);
            this.mXx.getSwitchView().setAlpha(1.0f);
            this.mXy.getSwitchView().setAlpha(1.0f);
            this.mXz.getSwitchView().setAlpha(1.0f);
            this.mYm.getSwitchView().setAlpha(1.0f);
            this.mXU.getSwitchView().setAlpha(1.0f);
            this.mXX.getSwitchView().setAlpha(1.0f);
            return;
        }
        this.mXK.getSwitchView().setEnabled(false);
        this.mXL.getSwitchView().setEnabled(false);
        this.mXN.getSwitchView().setEnabled(false);
        this.mXM.getSwitchView().setEnabled(false);
        this.mXx.getSwitchView().setEnabled(false);
        this.mXy.getSwitchView().setEnabled(false);
        this.mXz.getSwitchView().setEnabled(false);
        this.mYm.getSwitchView().setEnabled(false);
        this.mXU.getSwitchView().setEnabled(false);
        this.mXX.getSwitchView().setEnabled(false);
        this.mXK.getSwitchView().setAlpha(0.3f);
        this.mXL.getSwitchView().setAlpha(0.3f);
        this.mXN.getSwitchView().setAlpha(0.3f);
        this.mXM.getSwitchView().setAlpha(0.3f);
        this.mXx.getSwitchView().setAlpha(0.3f);
        this.mXy.getSwitchView().setAlpha(0.3f);
        this.mXz.getSwitchView().setAlpha(0.3f);
        this.mYm.getSwitchView().setAlpha(0.3f);
        this.mXU.getSwitchView().setAlpha(0.3f);
        this.mXX.getSwitchView().setAlpha(0.3f);
    }
}
