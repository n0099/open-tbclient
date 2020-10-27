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
    private LinearLayout irq;
    private View mBack;
    private TextView mCA;
    private MsgSettingItemView mCB;
    private LinearLayout mCC;
    private TextView mCD;
    private LinearLayout mCE;
    private LinearLayout mCF;
    private LinearLayout mCG;
    private TextView mCH;
    private LinearLayout mCI;
    private TextView mCJ;
    public boolean mCK;
    private MsgRemindActivity mCL;
    private TbSettingTextTipView mCM;
    private View mCN;
    private BdSwitchView mCO;
    private View mCP;
    private MsgSettingItemView mCQ;
    private MsgSettingItemView mCa;
    private MsgSettingItemView mCb;
    private MsgSettingItemView mCc;
    private MsgSettingItemView mCl;
    private LinearLayout mCm;
    private MsgSettingItemView mCn;
    private MsgSettingItemView mCo;
    private MsgSettingItemView mCp;
    private MsgSettingItemView mCq;
    private MsgSettingItemView mCr;
    private MsgSettingItemView mCs;
    private MsgSettingItemView mCt;
    private MsgSettingItemView mCu;
    private MsgSettingItemView mCw;
    private MsgSettingItemView mCx;
    private MsgSettingItemView mCy;
    private LinearLayout mCz;
    private NavigationBar mNavigationBar;

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.irq = null;
        this.mNavigationBar = null;
        this.mCK = true;
        this.mCL = msgRemindActivity;
        msgRemindActivity.setContentView(R.layout.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        dCg();
        dCj();
        dCi();
        dCh();
        dCk();
        d(msgRemindActivity);
        dCb();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.irq = (LinearLayout) msgRemindActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(R.string.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mCE = (LinearLayout) msgRemindActivity.findViewById(R.id.front_container);
        this.mCF = (LinearLayout) msgRemindActivity.findViewById(R.id.back_container);
        this.mCl = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.receive_message_swtich);
        this.mCl.setText(R.string.receive_msg_text);
        this.mCl.setLineVisibility(false);
        this.mCm = (LinearLayout) msgRemindActivity.findViewById(R.id.receive_message_container);
        this.mCn = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.reply_check_box);
        this.mCn.setText(R.string.reply);
        this.mCo = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.zan_check_box);
        this.mCo.setVisibility(0);
        this.mCo.setText(R.string.action_praise_default);
        this.mCp = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.at_me_check_box);
        this.mCp.setText(R.string.mention_atme);
        this.mCq = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.new_fans_swtich);
        this.mCq.setText(R.string.new_fans);
        this.mCr = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.chat_msg_swtich);
        this.mCr.setText(R.string.chat_msg_text);
        this.mCs = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.group_chat_swtich);
        this.mCs.setLineVisibility(false);
        this.mCs.setText(R.string.group_chat_text);
        this.mCt = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.screen_lock_swtich);
        this.mCt.setText(R.string.remind_screen_lock);
        this.mCt.setLineVisibility(false);
        this.mCu = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.tone_remind_swtich);
        this.mCu.setText(R.string.remind_tone);
        this.mCw = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.vibrate_remind_swtich);
        this.mCw.setText(R.string.remind_vibrate);
        this.mCx = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.light_remind_swtich);
        this.mCx.setLineVisibility(true);
        this.mCx.setText(R.string.remind_light);
        this.mCy = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.sign_remind_swtich);
        this.mCy.setText(R.string.sign_remind_outline);
        this.mCz = (LinearLayout) msgRemindActivity.findViewById(R.id.sign_remind);
        this.mCA = (TextView) msgRemindActivity.findViewById(R.id.sign_remind_time);
        this.mCB = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.no_disturb_swtich);
        this.mCB.setText(R.string.no_disturb_mode);
        this.mCB.setLineVisibility(false);
        this.mCC = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_container);
        this.mCD = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_value);
        this.mCG = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_start_time);
        this.mCH = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_start_time_value);
        this.mCI = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_end_time);
        this.mCJ = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_end_time_value);
        this.mCM = (TbSettingTextTipView) msgRemindActivity.findViewById(R.id.msg_receive_item_view);
        this.mCN = msgRemindActivity.findViewById(R.id.layout_system_msg_permission);
        boolean areNotificationsEnabled = NotificationManagerCompat.from(msgRemindActivity).areNotificationsEnabled();
        this.mCN.setVisibility(areNotificationsEnabled ? 8 : 0);
        TiebaStatic.log(new aq("c13890").aj("obj_type", areNotificationsEnabled ? 1 : 2));
        this.mCO = (BdSwitchView) msgRemindActivity.findViewById(R.id.system_msg_permission_switch);
        this.mCP = msgRemindActivity.findViewById(R.id.system_msg_permission_switch_cover);
        this.mCP.setOnClickListener(msgRemindActivity);
        this.mCa = (MsgSettingItemView) this.mCL.findViewById(R.id.item_view_friend_msg);
        this.mCa.setText(R.string.friend_msg_switch);
        this.mCa.setOnSwitchStateChangeListener(this.mCL);
        this.mCb = (MsgSettingItemView) this.mCL.findViewById(R.id.item_view_stranger_msg);
        this.mCb.setText(R.string.stranger_msg_switch);
        this.mCb.setOnSwitchStateChangeListener(this.mCL);
        this.mCb.setLineVisibility(false);
        dBU();
        this.mCc = (MsgSettingItemView) this.mCL.findViewById(R.id.item_view_forum_broadcast_msg);
        this.mCc.setText(R.string.receive_forum_broadcast_message);
        this.mCc.setOnSwitchStateChangeListener(this.mCL);
        this.mCc.setLineVisibility(false);
        dBV();
        this.mCQ = (MsgSettingItemView) this.mCL.findViewById(R.id.item_view_tb_selection_msg);
        this.mCQ.setText(R.string.official_push_message_switch_text);
        this.mCQ.setOnSwitchStateChangeListener(this.mCL);
        this.mCQ.setLineVisibility(false);
        dCa();
    }

    private void dBU() {
        if (this.mCa == null || this.mCb == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.mCa.getSwitchView().turnOnNoCallback();
                this.mCa.setLineVisibility(true);
                this.mCb.getSwitchView().turnOffNoCallback();
                return;
            default:
                this.mCa.getSwitchView().turnOffNoCallback();
                this.mCa.setLineVisibility(false);
                this.mCb.setVisibility(8);
                this.mCb.getSwitchView().turnOffNoCallback();
                return;
        }
    }

    private void dBV() {
        if (this.mCc != null) {
            this.mCc.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.btV().bup());
        }
    }

    private void dCa() {
        if (this.mCQ != null) {
            this.mCQ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.btV().buq());
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
                    if (com.baidu.tbadk.coreExtra.messageCenter.d.btV().buq() != z) {
                        g.this.mCQ.setSwitchStateNoCallback(z);
                    }
                }
            }).dDd();
        }
    }

    private void dCb() {
        dCc();
        dCd();
        dCe();
        dCf();
    }

    private void dCc() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.mCB.setVisibility(8);
            this.mCC.setVisibility(8);
            this.mCl.setVisibility(8);
            this.mCm.setVisibility(8);
            this.mCy.setVisibility(8);
            this.mCz.setVisibility(8);
            this.mCu.setVisibility(8);
            this.mCw.setVisibility(8);
            this.mCx.setVisibility(8);
            this.mCt.setVisibility(8);
        }
    }

    private void dCd() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.mCt.setLineVisibility(true);
        } else {
            this.mCt.setLineVisibility(false);
        }
    }

    private void dCe() {
        this.mCr.setLineVisibility(TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class));
    }

    private void dCf() {
        TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class);
    }

    public View Rw() {
        return this.mBack;
    }

    private void dCg() {
        this.mCn.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.btV().buc());
        this.mCo.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.btV().bum());
        this.mCp.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.btV().bua());
        this.mCq.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.btV().bub());
        this.mCr.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.btV().bud());
        this.mCs.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.btV().bul());
    }

    private void dCh() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.btV().isSignAlertOn()) {
            this.mCy.turnOn();
            this.mCz.setVisibility(0);
            this.mCy.setLineVisibility(true);
            dCl();
            return;
        }
        this.mCy.turnOff();
        this.mCy.setLineVisibility(false);
        this.mCz.setVisibility(8);
    }

    private void dCi() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.btV().bue()) {
            this.mCu.turnOnNoCallback();
        } else {
            this.mCu.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.btV().buh()) {
            this.mCw.turnOnNoCallback();
        } else {
            this.mCw.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.btV().buf()) {
            this.mCx.turnOnNoCallback();
        } else {
            this.mCx.turnOffNoCallback();
        }
    }

    private void dCj() {
    }

    private void dCk() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.btV().bug()) {
            this.mCB.turnOnNoCallback();
            this.mCC.setVisibility(0);
            dCm();
            return;
        }
        this.mCB.turnOffNoCallback();
        this.mCC.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.mBack.setOnClickListener(msgRemindActivity);
        this.mCn.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mCp.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mCo.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mCq.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mCr.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mCs.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mCt.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mCu.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mCw.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mCx.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mCy.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mCz.setOnClickListener(msgRemindActivity);
        this.mCB.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mCC.setOnClickListener(msgRemindActivity);
        this.mCG.setOnClickListener(msgRemindActivity);
        this.mCI.setOnClickListener(msgRemindActivity);
        this.mCM.setOnClickListener(msgRemindActivity);
        this.mNavigationBar.getCenterText().setOnClickListener(msgRemindActivity);
    }

    public void wL(boolean z) {
        this.mCB.setLineVisibility(z);
        if (z) {
            this.mCC.setVisibility(0);
            dCm();
            ap.setBackgroundResource(this.mCC, R.drawable.more_all);
            return;
        }
        this.mCC.setVisibility(8);
    }

    public void wM(boolean z) {
        if (z) {
            this.mCz.setVisibility(0);
            this.mCy.setLineVisibility(true);
            ap.setBackgroundResource(this.mCz, R.drawable.more_all);
            return;
        }
        this.mCz.setVisibility(8);
        this.mCy.setLineVisibility(false);
    }

    public void wN(boolean z) {
    }

    public void dCl() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.btV().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.d.btV().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.d.btV().getSignAlertMins();
            this.mCA.setText(this.mCL.getString(R.string.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.mCz.setVisibility(0);
            if (!this.mCy.isOn()) {
                this.mCy.turnOnNoCallback();
                return;
            }
            return;
        }
        this.mCA.setText(R.string.close);
        this.mCz.setVisibility(8);
        if (this.mCy.isOn()) {
            this.mCy.turnOffNoCallback();
        }
    }

    public void dCm() {
        String bui = com.baidu.tbadk.coreExtra.messageCenter.d.btV().bui();
        String buj = com.baidu.tbadk.coreExtra.messageCenter.d.btV().buj();
        this.mCD.setText(bui + Constants.ACCEPT_TIME_SEPARATOR_SERVER + buj);
        this.mCH.setText(bui);
        this.mCJ.setText(buj);
    }

    public BdSwitchView dCn() {
        return this.mCy.getSwitchView();
    }

    public BdSwitchView dCo() {
        return this.mCl.getSwitchView();
    }

    public View dCp() {
        return this.mCz;
    }

    public BdSwitchView dCq() {
        return this.mCB.getSwitchView();
    }

    public View dCr() {
        return this.mCC;
    }

    public LinearLayout dCs() {
        return this.mCG;
    }

    public LinearLayout dCt() {
        return this.mCI;
    }

    public BdSwitchView dCu() {
        return this.mCu.getSwitchView();
    }

    public BdSwitchView dCv() {
        return this.mCw.getSwitchView();
    }

    public BdSwitchView dCw() {
        return this.mCx.getSwitchView();
    }

    public BdSwitchView dCx() {
        return this.mCt.getSwitchView();
    }

    public BdSwitchView dCy() {
        return this.mCn.getSwitchView();
    }

    public BdSwitchView dCz() {
        return this.mCo.getSwitchView();
    }

    public BdSwitchView dCA() {
        return this.mCp.getSwitchView();
    }

    public BdSwitchView dCB() {
        return this.mCr.getSwitchView();
    }

    public BdSwitchView dCC() {
        return this.mCs.getSwitchView();
    }

    public BdSwitchView dCD() {
        return this.mCq.getSwitchView();
    }

    public TbSettingTextTipView dCE() {
        return this.mCM;
    }

    public TextView dCF() {
        return this.mNavigationBar.getCenterText();
    }

    public void dCG() {
        this.mCn.setOnSwitchStateChangeListener(null);
        this.mCn.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.btV().buc());
        this.mCn.setOnSwitchStateChangeListener(this.mCL);
    }

    public void dCH() {
        this.mCo.setOnSwitchStateChangeListener(null);
        this.mCo.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.btV().bum());
        this.mCo.setOnSwitchStateChangeListener(this.mCL);
    }

    public void dCI() {
        this.mCp.setOnSwitchStateChangeListener(null);
        this.mCp.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.btV().bua());
        this.mCp.setOnSwitchStateChangeListener(this.mCL);
    }

    public void dCJ() {
        this.mCq.setOnSwitchStateChangeListener(null);
        this.mCq.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.btV().bub());
        this.mCq.setOnSwitchStateChangeListener(this.mCL);
    }

    public void dCK() {
        this.mCr.setOnSwitchStateChangeListener(null);
        this.mCr.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.btV().bud());
        this.mCr.setOnSwitchStateChangeListener(this.mCL);
    }

    public void dCL() {
        this.mCs.setOnSwitchStateChangeListener(null);
        this.mCs.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.btV().bul());
        this.mCs.setOnSwitchStateChangeListener(this.mCL);
    }

    public void wO(boolean z) {
        if (this.mCK != z) {
            this.mCK = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.mCL.getString(R.string.msg_remind));
                this.mCE.setVisibility(0);
                this.mCF.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.mCL.getString(R.string.no_disturb_mode_time));
            this.mCF.setVisibility(0);
            this.mCE.setVisibility(8);
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
        this.mCL.getLayoutMode().setNightMode(i == 1);
        this.mCL.getLayoutMode().onModeChanged(this.irq);
        this.mNavigationBar.onChangeSkinType(this.mCL.getPageContext(), i);
        this.mCl.onChangeSkinType(this.mCL.getPageContext(), i);
        this.mCn.onChangeSkinType(this.mCL.getPageContext(), i);
        this.mCo.onChangeSkinType(this.mCL.getPageContext(), i);
        this.mCp.onChangeSkinType(this.mCL.getPageContext(), i);
        this.mCq.onChangeSkinType(this.mCL.getPageContext(), i);
        this.mCr.onChangeSkinType(this.mCL.getPageContext(), i);
        this.mCs.onChangeSkinType(this.mCL.getPageContext(), i);
        this.mCt.onChangeSkinType(this.mCL.getPageContext(), i);
        this.mCu.onChangeSkinType(this.mCL.getPageContext(), i);
        this.mCw.onChangeSkinType(this.mCL.getPageContext(), i);
        this.mCx.onChangeSkinType(this.mCL.getPageContext(), i);
        this.mCy.onChangeSkinType(this.mCL.getPageContext(), i);
        this.mCB.onChangeSkinType(this.mCL.getPageContext(), i);
        this.mCa.onChangeSkinType(this.mCL.getPageContext(), i);
        this.mCb.onChangeSkinType(this.mCL.getPageContext(), i);
        this.mCc.onChangeSkinType(this.mCL.getPageContext(), i);
        this.mCQ.onChangeSkinType(this.mCL.getPageContext(), i);
        ap.setBackgroundResource(this.mCC, R.drawable.more_all);
        ap.setBackgroundResource(this.mCG, R.drawable.more_all);
        ap.setBackgroundResource(this.mCI, R.drawable.more_all);
        ap.setBackgroundResource(this.mCz, R.drawable.more_all);
        SvgManager.boN().a((ImageView) this.mCC.findViewById(R.id.no_disturb_mode_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.boN().a((ImageView) this.mCz.findViewById(R.id.sign_remind_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.boN().a((ImageView) this.mCG.findViewById(R.id.no_disturb_start_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.boN().a((ImageView) this.mCI.findViewById(R.id.no_disturb_end_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
    }

    public BdSwitchView dBW() {
        return this.mCa.getSwitchView();
    }

    public BdSwitchView dBX() {
        return this.mCb.getSwitchView();
    }

    public BdSwitchView dBY() {
        return this.mCc.getSwitchView();
    }

    public BdSwitchView dCM() {
        return this.mCQ.getSwitchView();
    }

    public void wK(boolean z) {
        this.mCa.setLineVisibility(z);
    }

    public void wJ(boolean z) {
        if (z) {
            this.mCb.setVisibility(0);
        } else {
            this.mCb.setVisibility(8);
        }
    }

    public void dCN() {
        com.baidu.tbadk.coreExtra.messageCenter.f.bur().a(this.mCL.getActivity(), this.irq);
    }

    public void onDestroy() {
    }

    public void onResume() {
        int i;
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.mCL).areNotificationsEnabled();
        if (areNotificationsEnabled) {
            this.mCO.turnOn();
            i = 1;
        } else {
            this.mCO.turnOff();
            i = 2;
        }
        this.mCN.setVisibility(areNotificationsEnabled ? 8 : 0);
        rz(areNotificationsEnabled);
        TiebaStatic.log(new aq("c13889").aj("obj_locate", i).aj("obj_source", 8));
    }

    private void rz(boolean z) {
        if (z) {
            this.mCn.getSwitchView().setEnabled(true);
            this.mCo.getSwitchView().setEnabled(true);
            this.mCq.getSwitchView().setEnabled(true);
            this.mCp.getSwitchView().setEnabled(true);
            this.mCa.getSwitchView().setEnabled(true);
            this.mCb.getSwitchView().setEnabled(true);
            this.mCc.getSwitchView().setEnabled(true);
            this.mCQ.getSwitchView().setEnabled(true);
            this.mCy.getSwitchView().setEnabled(true);
            this.mCB.getSwitchView().setEnabled(true);
            this.mCn.getSwitchView().setAlpha(1.0f);
            this.mCo.getSwitchView().setAlpha(1.0f);
            this.mCq.getSwitchView().setAlpha(1.0f);
            this.mCp.getSwitchView().setAlpha(1.0f);
            this.mCa.getSwitchView().setAlpha(1.0f);
            this.mCb.getSwitchView().setAlpha(1.0f);
            this.mCc.getSwitchView().setAlpha(1.0f);
            this.mCQ.getSwitchView().setAlpha(1.0f);
            this.mCy.getSwitchView().setAlpha(1.0f);
            this.mCB.getSwitchView().setAlpha(1.0f);
            return;
        }
        this.mCn.getSwitchView().setEnabled(false);
        this.mCo.getSwitchView().setEnabled(false);
        this.mCq.getSwitchView().setEnabled(false);
        this.mCp.getSwitchView().setEnabled(false);
        this.mCa.getSwitchView().setEnabled(false);
        this.mCb.getSwitchView().setEnabled(false);
        this.mCc.getSwitchView().setEnabled(false);
        this.mCQ.getSwitchView().setEnabled(false);
        this.mCy.getSwitchView().setEnabled(false);
        this.mCB.getSwitchView().setEnabled(false);
        this.mCn.getSwitchView().setAlpha(0.3f);
        this.mCo.getSwitchView().setAlpha(0.3f);
        this.mCq.getSwitchView().setAlpha(0.3f);
        this.mCp.getSwitchView().setAlpha(0.3f);
        this.mCa.getSwitchView().setAlpha(0.3f);
        this.mCb.getSwitchView().setAlpha(0.3f);
        this.mCc.getSwitchView().setAlpha(0.3f);
        this.mCQ.getSwitchView().setAlpha(0.3f);
        this.mCy.getSwitchView().setAlpha(0.3f);
        this.mCB.getSwitchView().setAlpha(0.3f);
    }
}
