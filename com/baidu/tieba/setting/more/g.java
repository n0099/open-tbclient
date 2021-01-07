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
/* loaded from: classes8.dex */
public class g extends com.baidu.adp.base.d<MsgRemindActivity> {
    private LinearLayout iVh;
    private View mBack;
    private NavigationBar mNavigationBar;
    private LinearLayout ncA;
    private TextView ncB;
    private MsgSettingItemView ncC;
    private LinearLayout ncD;
    private TextView ncE;
    private LinearLayout ncF;
    private LinearLayout ncG;
    private LinearLayout ncH;
    private TextView ncI;
    private LinearLayout ncJ;
    private TextView ncK;
    public boolean ncL;
    private MsgRemindActivity ncM;
    private TbSettingTextTipView ncN;
    private View ncO;
    private BdSwitchView ncP;
    private View ncQ;
    private MsgSettingItemView ncR;
    private MsgSettingItemView ncc;
    private MsgSettingItemView ncd;
    private MsgSettingItemView nce;
    private MsgSettingItemView ncn;
    private LinearLayout nco;
    private MsgSettingItemView ncp;
    private MsgSettingItemView ncq;
    private MsgSettingItemView ncr;
    private MsgSettingItemView ncs;
    private MsgSettingItemView nct;
    private MsgSettingItemView ncu;
    private MsgSettingItemView ncv;
    private MsgSettingItemView ncw;
    private MsgSettingItemView ncx;
    private MsgSettingItemView ncy;
    private MsgSettingItemView ncz;

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.iVh = null;
        this.mNavigationBar = null;
        this.ncL = true;
        this.ncM = msgRemindActivity;
        msgRemindActivity.setContentView(R.layout.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        dJp();
        dJs();
        dJr();
        dJq();
        dJt();
        d(msgRemindActivity);
        dJk();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.iVh = (LinearLayout) msgRemindActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(R.string.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ncF = (LinearLayout) msgRemindActivity.findViewById(R.id.front_container);
        this.ncG = (LinearLayout) msgRemindActivity.findViewById(R.id.back_container);
        this.ncn = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.receive_message_swtich);
        this.ncn.setText(R.string.receive_msg_text);
        this.ncn.setLineVisibility(false);
        this.nco = (LinearLayout) msgRemindActivity.findViewById(R.id.receive_message_container);
        this.ncp = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.reply_check_box);
        this.ncp.setText(R.string.reply);
        this.ncq = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.zan_check_box);
        this.ncq.setVisibility(0);
        this.ncq.setText(R.string.action_praise_default);
        this.ncr = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.at_me_check_box);
        this.ncr.setText(R.string.mention_atme);
        this.ncs = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.new_fans_swtich);
        this.ncs.setText(R.string.new_fans);
        this.nct = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.chat_msg_swtich);
        this.nct.setText(R.string.chat_msg_text);
        this.ncu = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.group_chat_swtich);
        this.ncu.setLineVisibility(false);
        this.ncu.setText(R.string.group_chat_text);
        this.ncv = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.screen_lock_swtich);
        this.ncv.setText(R.string.remind_screen_lock);
        this.ncv.setLineVisibility(false);
        this.ncw = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.tone_remind_swtich);
        this.ncw.setText(R.string.remind_tone);
        this.ncx = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.vibrate_remind_swtich);
        this.ncx.setText(R.string.remind_vibrate);
        this.ncy = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.light_remind_swtich);
        this.ncy.setLineVisibility(true);
        this.ncy.setText(R.string.remind_light);
        this.ncz = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.sign_remind_swtich);
        this.ncz.setText(R.string.sign_remind_outline);
        this.ncA = (LinearLayout) msgRemindActivity.findViewById(R.id.sign_remind);
        this.ncB = (TextView) msgRemindActivity.findViewById(R.id.sign_remind_time);
        this.ncC = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.no_disturb_swtich);
        this.ncC.setText(R.string.no_disturb_mode);
        this.ncC.setLineVisibility(false);
        this.ncD = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_container);
        this.ncE = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_value);
        this.ncH = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_start_time);
        this.ncI = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_start_time_value);
        this.ncJ = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_end_time);
        this.ncK = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_end_time_value);
        this.ncN = (TbSettingTextTipView) msgRemindActivity.findViewById(R.id.msg_receive_item_view);
        this.ncO = msgRemindActivity.findViewById(R.id.layout_system_msg_permission);
        boolean areNotificationsEnabled = NotificationManagerCompat.from(msgRemindActivity).areNotificationsEnabled();
        this.ncO.setVisibility(areNotificationsEnabled ? 8 : 0);
        TiebaStatic.log(new aq("c13890").an("obj_type", areNotificationsEnabled ? 1 : 2));
        this.ncP = (BdSwitchView) msgRemindActivity.findViewById(R.id.system_msg_permission_switch);
        this.ncQ = msgRemindActivity.findViewById(R.id.system_msg_permission_switch_cover);
        this.ncQ.setOnClickListener(msgRemindActivity);
        this.ncc = (MsgSettingItemView) this.ncM.findViewById(R.id.item_view_friend_msg);
        this.ncc.setText(R.string.friend_msg_switch);
        this.ncc.setOnSwitchStateChangeListener(this.ncM);
        this.ncd = (MsgSettingItemView) this.ncM.findViewById(R.id.item_view_stranger_msg);
        this.ncd.setText(R.string.stranger_msg_switch);
        this.ncd.setOnSwitchStateChangeListener(this.ncM);
        this.ncd.setLineVisibility(false);
        dJd();
        this.nce = (MsgSettingItemView) this.ncM.findViewById(R.id.item_view_forum_broadcast_msg);
        this.nce.setText(R.string.receive_forum_broadcast_message);
        this.nce.setOnSwitchStateChangeListener(this.ncM);
        this.nce.setLineVisibility(false);
        dJe();
        this.ncR = (MsgSettingItemView) this.ncM.findViewById(R.id.item_view_tb_selection_msg);
        this.ncR.setText(R.string.official_push_message_switch_text);
        this.ncR.setOnSwitchStateChangeListener(this.ncM);
        this.ncR.setLineVisibility(false);
        dJj();
    }

    private void dJd() {
        if (this.ncc == null || this.ncd == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.ncc.getSwitchView().turnOnNoCallback();
                this.ncc.setLineVisibility(true);
                this.ncd.getSwitchView().turnOffNoCallback();
                return;
            default:
                this.ncc.getSwitchView().turnOffNoCallback();
                this.ncc.setLineVisibility(false);
                this.ncd.setVisibility(8);
                this.ncd.getSwitchView().turnOffNoCallback();
                return;
        }
    }

    private void dJe() {
        if (this.nce != null) {
            this.nce.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bBG().bCa());
        }
    }

    private void dJj() {
        if (this.ncR != null) {
            this.ncR.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bBG().bCb());
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
                    if (com.baidu.tbadk.coreExtra.messageCenter.d.bBG().bCb() != z) {
                        g.this.ncR.setSwitchStateNoCallback(z);
                    }
                }
            }).dKw();
        }
    }

    private void dJk() {
        dJl();
        dJm();
        dJn();
        dJo();
    }

    private void dJl() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.ncC.setVisibility(8);
            this.ncD.setVisibility(8);
            this.ncn.setVisibility(8);
            this.nco.setVisibility(8);
            this.ncz.setVisibility(8);
            this.ncA.setVisibility(8);
            this.ncw.setVisibility(8);
            this.ncx.setVisibility(8);
            this.ncy.setVisibility(8);
            this.ncv.setVisibility(8);
        }
    }

    private void dJm() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.ncv.setLineVisibility(true);
        } else {
            this.ncv.setLineVisibility(false);
        }
    }

    private void dJn() {
        this.nct.setLineVisibility(TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class));
    }

    private void dJo() {
        TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class);
    }

    public View WY() {
        return this.mBack;
    }

    private void dJp() {
        this.ncp.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bBG().bBN());
        this.ncq.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bBG().bBX());
        this.ncr.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bBG().bBL());
        this.ncs.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bBG().bBM());
        this.nct.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bBG().bBO());
        this.ncu.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bBG().bBW());
    }

    private void dJq() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bBG().isSignAlertOn()) {
            this.ncz.turnOn();
            this.ncA.setVisibility(0);
            this.ncz.setLineVisibility(true);
            dJu();
            return;
        }
        this.ncz.turnOff();
        this.ncz.setLineVisibility(false);
        this.ncA.setVisibility(8);
    }

    private void dJr() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bBG().bBP()) {
            this.ncw.turnOnNoCallback();
        } else {
            this.ncw.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bBG().bBS()) {
            this.ncx.turnOnNoCallback();
        } else {
            this.ncx.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bBG().bBQ()) {
            this.ncy.turnOnNoCallback();
        } else {
            this.ncy.turnOffNoCallback();
        }
    }

    private void dJs() {
    }

    private void dJt() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bBG().bBR()) {
            this.ncC.turnOnNoCallback();
            this.ncD.setVisibility(0);
            dJv();
            return;
        }
        this.ncC.turnOffNoCallback();
        this.ncD.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.mBack.setOnClickListener(msgRemindActivity);
        this.ncp.setOnSwitchStateChangeListener(msgRemindActivity);
        this.ncr.setOnSwitchStateChangeListener(msgRemindActivity);
        this.ncq.setOnSwitchStateChangeListener(msgRemindActivity);
        this.ncs.setOnSwitchStateChangeListener(msgRemindActivity);
        this.nct.setOnSwitchStateChangeListener(msgRemindActivity);
        this.ncu.setOnSwitchStateChangeListener(msgRemindActivity);
        this.ncv.setOnSwitchStateChangeListener(msgRemindActivity);
        this.ncw.setOnSwitchStateChangeListener(msgRemindActivity);
        this.ncx.setOnSwitchStateChangeListener(msgRemindActivity);
        this.ncy.setOnSwitchStateChangeListener(msgRemindActivity);
        this.ncz.setOnSwitchStateChangeListener(msgRemindActivity);
        this.ncA.setOnClickListener(msgRemindActivity);
        this.ncC.setOnSwitchStateChangeListener(msgRemindActivity);
        this.ncD.setOnClickListener(msgRemindActivity);
        this.ncH.setOnClickListener(msgRemindActivity);
        this.ncJ.setOnClickListener(msgRemindActivity);
        this.ncN.setOnClickListener(msgRemindActivity);
        this.mNavigationBar.getCenterText().setOnClickListener(msgRemindActivity);
    }

    public void xC(boolean z) {
        this.ncC.setLineVisibility(z);
        if (z) {
            this.ncD.setVisibility(0);
            dJv();
            ao.setBackgroundResource(this.ncD, R.drawable.more_all);
            return;
        }
        this.ncD.setVisibility(8);
    }

    public void xD(boolean z) {
        if (z) {
            this.ncA.setVisibility(0);
            this.ncz.setLineVisibility(true);
            ao.setBackgroundResource(this.ncA, R.drawable.more_all);
            return;
        }
        this.ncA.setVisibility(8);
        this.ncz.setLineVisibility(false);
    }

    public void xE(boolean z) {
    }

    public void dJu() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bBG().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.d.bBG().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.d.bBG().getSignAlertMins();
            this.ncB.setText(this.ncM.getString(R.string.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.ncA.setVisibility(0);
            if (!this.ncz.isOn()) {
                this.ncz.turnOnNoCallback();
                return;
            }
            return;
        }
        this.ncB.setText(R.string.close);
        this.ncA.setVisibility(8);
        if (this.ncz.isOn()) {
            this.ncz.turnOffNoCallback();
        }
    }

    public void dJv() {
        String bBT = com.baidu.tbadk.coreExtra.messageCenter.d.bBG().bBT();
        String bBU = com.baidu.tbadk.coreExtra.messageCenter.d.bBG().bBU();
        this.ncE.setText(bBT + Constants.ACCEPT_TIME_SEPARATOR_SERVER + bBU);
        this.ncI.setText(bBT);
        this.ncK.setText(bBU);
    }

    public BdSwitchView dJw() {
        return this.ncz.getSwitchView();
    }

    public BdSwitchView dJx() {
        return this.ncn.getSwitchView();
    }

    public View dJy() {
        return this.ncA;
    }

    public BdSwitchView dJz() {
        return this.ncC.getSwitchView();
    }

    public View dJA() {
        return this.ncD;
    }

    public LinearLayout dJB() {
        return this.ncH;
    }

    public LinearLayout dJC() {
        return this.ncJ;
    }

    public BdSwitchView dJD() {
        return this.ncw.getSwitchView();
    }

    public BdSwitchView dJE() {
        return this.ncx.getSwitchView();
    }

    public BdSwitchView dJF() {
        return this.ncy.getSwitchView();
    }

    public BdSwitchView dJG() {
        return this.ncv.getSwitchView();
    }

    public BdSwitchView dJH() {
        return this.ncp.getSwitchView();
    }

    public BdSwitchView dJI() {
        return this.ncq.getSwitchView();
    }

    public BdSwitchView dJJ() {
        return this.ncr.getSwitchView();
    }

    public BdSwitchView dJK() {
        return this.nct.getSwitchView();
    }

    public BdSwitchView dJL() {
        return this.ncu.getSwitchView();
    }

    public BdSwitchView dJM() {
        return this.ncs.getSwitchView();
    }

    public TbSettingTextTipView dJN() {
        return this.ncN;
    }

    public TextView dJO() {
        return this.mNavigationBar.getCenterText();
    }

    public void dJP() {
        this.ncp.setOnSwitchStateChangeListener(null);
        this.ncp.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bBG().bBN());
        this.ncp.setOnSwitchStateChangeListener(this.ncM);
    }

    public void dJQ() {
        this.ncq.setOnSwitchStateChangeListener(null);
        this.ncq.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bBG().bBX());
        this.ncq.setOnSwitchStateChangeListener(this.ncM);
    }

    public void dJR() {
        this.ncr.setOnSwitchStateChangeListener(null);
        this.ncr.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bBG().bBL());
        this.ncr.setOnSwitchStateChangeListener(this.ncM);
    }

    public void dJS() {
        this.ncs.setOnSwitchStateChangeListener(null);
        this.ncs.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bBG().bBM());
        this.ncs.setOnSwitchStateChangeListener(this.ncM);
    }

    public void dJT() {
        this.nct.setOnSwitchStateChangeListener(null);
        this.nct.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bBG().bBO());
        this.nct.setOnSwitchStateChangeListener(this.ncM);
    }

    public void dJU() {
        this.ncu.setOnSwitchStateChangeListener(null);
        this.ncu.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bBG().bBW());
        this.ncu.setOnSwitchStateChangeListener(this.ncM);
    }

    public void xF(boolean z) {
        if (this.ncL != z) {
            this.ncL = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.ncM.getString(R.string.msg_remind));
                this.ncF.setVisibility(0);
                this.ncG.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.ncM.getString(R.string.no_disturb_mode_time));
            this.ncG.setVisibility(0);
            this.ncF.setVisibility(8);
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
        this.ncM.getLayoutMode().setNightMode(i == 1);
        this.ncM.getLayoutMode().onModeChanged(this.iVh);
        this.mNavigationBar.onChangeSkinType(this.ncM.getPageContext(), i);
        this.ncn.onChangeSkinType(this.ncM.getPageContext(), i);
        this.ncp.onChangeSkinType(this.ncM.getPageContext(), i);
        this.ncq.onChangeSkinType(this.ncM.getPageContext(), i);
        this.ncr.onChangeSkinType(this.ncM.getPageContext(), i);
        this.ncs.onChangeSkinType(this.ncM.getPageContext(), i);
        this.nct.onChangeSkinType(this.ncM.getPageContext(), i);
        this.ncu.onChangeSkinType(this.ncM.getPageContext(), i);
        this.ncv.onChangeSkinType(this.ncM.getPageContext(), i);
        this.ncw.onChangeSkinType(this.ncM.getPageContext(), i);
        this.ncx.onChangeSkinType(this.ncM.getPageContext(), i);
        this.ncy.onChangeSkinType(this.ncM.getPageContext(), i);
        this.ncz.onChangeSkinType(this.ncM.getPageContext(), i);
        this.ncC.onChangeSkinType(this.ncM.getPageContext(), i);
        this.ncc.onChangeSkinType(this.ncM.getPageContext(), i);
        this.ncd.onChangeSkinType(this.ncM.getPageContext(), i);
        this.nce.onChangeSkinType(this.ncM.getPageContext(), i);
        this.ncR.onChangeSkinType(this.ncM.getPageContext(), i);
        ao.setBackgroundResource(this.ncD, R.drawable.more_all);
        ao.setBackgroundResource(this.ncH, R.drawable.more_all);
        ao.setBackgroundResource(this.ncJ, R.drawable.more_all);
        ao.setBackgroundResource(this.ncA, R.drawable.more_all);
        SvgManager.bwr().a((ImageView) this.ncD.findViewById(R.id.no_disturb_mode_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bwr().a((ImageView) this.ncA.findViewById(R.id.sign_remind_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bwr().a((ImageView) this.ncH.findViewById(R.id.no_disturb_start_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bwr().a((ImageView) this.ncJ.findViewById(R.id.no_disturb_end_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
    }

    public BdSwitchView dJf() {
        return this.ncc.getSwitchView();
    }

    public BdSwitchView dJg() {
        return this.ncd.getSwitchView();
    }

    public BdSwitchView dJh() {
        return this.nce.getSwitchView();
    }

    public BdSwitchView dJV() {
        return this.ncR.getSwitchView();
    }

    public void xB(boolean z) {
        this.ncc.setLineVisibility(z);
    }

    public void xA(boolean z) {
        if (z) {
            this.ncd.setVisibility(0);
        } else {
            this.ncd.setVisibility(8);
        }
    }

    public void dJW() {
        com.baidu.tbadk.coreExtra.messageCenter.f.bCc().a(this.ncM.getActivity(), this.iVh);
    }

    public void onDestroy() {
    }

    public void onResume() {
        int i;
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.ncM).areNotificationsEnabled();
        if (areNotificationsEnabled) {
            this.ncP.turnOn();
            i = 1;
        } else {
            this.ncP.turnOff();
            i = 2;
        }
        this.ncO.setVisibility(areNotificationsEnabled ? 8 : 0);
        xG(areNotificationsEnabled);
        TiebaStatic.log(new aq("c13889").an("obj_locate", i).an("obj_source", 8));
    }

    private void xG(boolean z) {
        if (z) {
            this.ncp.getSwitchView().setEnabled(true);
            this.ncq.getSwitchView().setEnabled(true);
            this.ncs.getSwitchView().setEnabled(true);
            this.ncr.getSwitchView().setEnabled(true);
            this.ncc.getSwitchView().setEnabled(true);
            this.ncd.getSwitchView().setEnabled(true);
            this.nce.getSwitchView().setEnabled(true);
            this.ncR.getSwitchView().setEnabled(true);
            this.ncz.getSwitchView().setEnabled(true);
            this.ncC.getSwitchView().setEnabled(true);
            this.ncp.getSwitchView().setAlpha(1.0f);
            this.ncq.getSwitchView().setAlpha(1.0f);
            this.ncs.getSwitchView().setAlpha(1.0f);
            this.ncr.getSwitchView().setAlpha(1.0f);
            this.ncc.getSwitchView().setAlpha(1.0f);
            this.ncd.getSwitchView().setAlpha(1.0f);
            this.nce.getSwitchView().setAlpha(1.0f);
            this.ncR.getSwitchView().setAlpha(1.0f);
            this.ncz.getSwitchView().setAlpha(1.0f);
            this.ncC.getSwitchView().setAlpha(1.0f);
            return;
        }
        this.ncp.getSwitchView().setEnabled(false);
        this.ncq.getSwitchView().setEnabled(false);
        this.ncs.getSwitchView().setEnabled(false);
        this.ncr.getSwitchView().setEnabled(false);
        this.ncc.getSwitchView().setEnabled(false);
        this.ncd.getSwitchView().setEnabled(false);
        this.nce.getSwitchView().setEnabled(false);
        this.ncR.getSwitchView().setEnabled(false);
        this.ncz.getSwitchView().setEnabled(false);
        this.ncC.getSwitchView().setEnabled(false);
        this.ncp.getSwitchView().setAlpha(0.3f);
        this.ncq.getSwitchView().setAlpha(0.3f);
        this.ncs.getSwitchView().setAlpha(0.3f);
        this.ncr.getSwitchView().setAlpha(0.3f);
        this.ncc.getSwitchView().setAlpha(0.3f);
        this.ncd.getSwitchView().setAlpha(0.3f);
        this.nce.getSwitchView().setAlpha(0.3f);
        this.ncR.getSwitchView().setAlpha(0.3f);
        this.ncz.getSwitchView().setAlpha(0.3f);
        this.ncC.getSwitchView().setAlpha(0.3f);
    }
}
