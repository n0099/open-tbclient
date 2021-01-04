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
    private MsgSettingItemView ncA;
    private LinearLayout ncB;
    private TextView ncC;
    private MsgSettingItemView ncD;
    private LinearLayout ncE;
    private TextView ncF;
    private LinearLayout ncG;
    private LinearLayout ncH;
    private LinearLayout ncI;
    private TextView ncJ;
    private LinearLayout ncK;
    private TextView ncL;
    public boolean ncM;
    private MsgRemindActivity ncN;
    private TbSettingTextTipView ncO;
    private View ncP;
    private BdSwitchView ncQ;
    private View ncR;
    private MsgSettingItemView ncS;
    private MsgSettingItemView ncd;
    private MsgSettingItemView nce;
    private MsgSettingItemView ncf;
    private MsgSettingItemView nco;
    private LinearLayout ncp;
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
        this.ncM = true;
        this.ncN = msgRemindActivity;
        msgRemindActivity.setContentView(R.layout.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        dJo();
        dJr();
        dJq();
        dJp();
        dJs();
        d(msgRemindActivity);
        dJj();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.iVh = (LinearLayout) msgRemindActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(R.string.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ncG = (LinearLayout) msgRemindActivity.findViewById(R.id.front_container);
        this.ncH = (LinearLayout) msgRemindActivity.findViewById(R.id.back_container);
        this.nco = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.receive_message_swtich);
        this.nco.setText(R.string.receive_msg_text);
        this.nco.setLineVisibility(false);
        this.ncp = (LinearLayout) msgRemindActivity.findViewById(R.id.receive_message_container);
        this.ncq = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.reply_check_box);
        this.ncq.setText(R.string.reply);
        this.ncr = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.zan_check_box);
        this.ncr.setVisibility(0);
        this.ncr.setText(R.string.action_praise_default);
        this.ncs = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.at_me_check_box);
        this.ncs.setText(R.string.mention_atme);
        this.nct = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.new_fans_swtich);
        this.nct.setText(R.string.new_fans);
        this.ncu = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.chat_msg_swtich);
        this.ncu.setText(R.string.chat_msg_text);
        this.ncv = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.group_chat_swtich);
        this.ncv.setLineVisibility(false);
        this.ncv.setText(R.string.group_chat_text);
        this.ncw = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.screen_lock_swtich);
        this.ncw.setText(R.string.remind_screen_lock);
        this.ncw.setLineVisibility(false);
        this.ncx = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.tone_remind_swtich);
        this.ncx.setText(R.string.remind_tone);
        this.ncy = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.vibrate_remind_swtich);
        this.ncy.setText(R.string.remind_vibrate);
        this.ncz = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.light_remind_swtich);
        this.ncz.setLineVisibility(true);
        this.ncz.setText(R.string.remind_light);
        this.ncA = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.sign_remind_swtich);
        this.ncA.setText(R.string.sign_remind_outline);
        this.ncB = (LinearLayout) msgRemindActivity.findViewById(R.id.sign_remind);
        this.ncC = (TextView) msgRemindActivity.findViewById(R.id.sign_remind_time);
        this.ncD = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.no_disturb_swtich);
        this.ncD.setText(R.string.no_disturb_mode);
        this.ncD.setLineVisibility(false);
        this.ncE = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_container);
        this.ncF = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_value);
        this.ncI = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_start_time);
        this.ncJ = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_start_time_value);
        this.ncK = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_end_time);
        this.ncL = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_end_time_value);
        this.ncO = (TbSettingTextTipView) msgRemindActivity.findViewById(R.id.msg_receive_item_view);
        this.ncP = msgRemindActivity.findViewById(R.id.layout_system_msg_permission);
        boolean areNotificationsEnabled = NotificationManagerCompat.from(msgRemindActivity).areNotificationsEnabled();
        this.ncP.setVisibility(areNotificationsEnabled ? 8 : 0);
        TiebaStatic.log(new aq("c13890").an("obj_type", areNotificationsEnabled ? 1 : 2));
        this.ncQ = (BdSwitchView) msgRemindActivity.findViewById(R.id.system_msg_permission_switch);
        this.ncR = msgRemindActivity.findViewById(R.id.system_msg_permission_switch_cover);
        this.ncR.setOnClickListener(msgRemindActivity);
        this.ncd = (MsgSettingItemView) this.ncN.findViewById(R.id.item_view_friend_msg);
        this.ncd.setText(R.string.friend_msg_switch);
        this.ncd.setOnSwitchStateChangeListener(this.ncN);
        this.nce = (MsgSettingItemView) this.ncN.findViewById(R.id.item_view_stranger_msg);
        this.nce.setText(R.string.stranger_msg_switch);
        this.nce.setOnSwitchStateChangeListener(this.ncN);
        this.nce.setLineVisibility(false);
        dJc();
        this.ncf = (MsgSettingItemView) this.ncN.findViewById(R.id.item_view_forum_broadcast_msg);
        this.ncf.setText(R.string.receive_forum_broadcast_message);
        this.ncf.setOnSwitchStateChangeListener(this.ncN);
        this.ncf.setLineVisibility(false);
        dJd();
        this.ncS = (MsgSettingItemView) this.ncN.findViewById(R.id.item_view_tb_selection_msg);
        this.ncS.setText(R.string.official_push_message_switch_text);
        this.ncS.setOnSwitchStateChangeListener(this.ncN);
        this.ncS.setLineVisibility(false);
        dJi();
    }

    private void dJc() {
        if (this.ncd == null || this.nce == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.ncd.getSwitchView().turnOnNoCallback();
                this.ncd.setLineVisibility(true);
                this.nce.getSwitchView().turnOffNoCallback();
                return;
            default:
                this.ncd.getSwitchView().turnOffNoCallback();
                this.ncd.setLineVisibility(false);
                this.nce.setVisibility(8);
                this.nce.getSwitchView().turnOffNoCallback();
                return;
        }
    }

    private void dJd() {
        if (this.ncf != null) {
            this.ncf.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bBF().bBZ());
        }
    }

    private void dJi() {
        if (this.ncS != null) {
            this.ncS.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bBF().bCa());
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
                    if (com.baidu.tbadk.coreExtra.messageCenter.d.bBF().bCa() != z) {
                        g.this.ncS.setSwitchStateNoCallback(z);
                    }
                }
            }).dKv();
        }
    }

    private void dJj() {
        dJk();
        dJl();
        dJm();
        dJn();
    }

    private void dJk() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.ncD.setVisibility(8);
            this.ncE.setVisibility(8);
            this.nco.setVisibility(8);
            this.ncp.setVisibility(8);
            this.ncA.setVisibility(8);
            this.ncB.setVisibility(8);
            this.ncx.setVisibility(8);
            this.ncy.setVisibility(8);
            this.ncz.setVisibility(8);
            this.ncw.setVisibility(8);
        }
    }

    private void dJl() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.ncw.setLineVisibility(true);
        } else {
            this.ncw.setLineVisibility(false);
        }
    }

    private void dJm() {
        this.ncu.setLineVisibility(TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class));
    }

    private void dJn() {
        TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class);
    }

    public View WX() {
        return this.mBack;
    }

    private void dJo() {
        this.ncq.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bBF().bBM());
        this.ncr.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bBF().bBW());
        this.ncs.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bBF().bBK());
        this.nct.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bBF().bBL());
        this.ncu.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bBF().bBN());
        this.ncv.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bBF().bBV());
    }

    private void dJp() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bBF().isSignAlertOn()) {
            this.ncA.turnOn();
            this.ncB.setVisibility(0);
            this.ncA.setLineVisibility(true);
            dJt();
            return;
        }
        this.ncA.turnOff();
        this.ncA.setLineVisibility(false);
        this.ncB.setVisibility(8);
    }

    private void dJq() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bBF().bBO()) {
            this.ncx.turnOnNoCallback();
        } else {
            this.ncx.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bBF().bBR()) {
            this.ncy.turnOnNoCallback();
        } else {
            this.ncy.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bBF().bBP()) {
            this.ncz.turnOnNoCallback();
        } else {
            this.ncz.turnOffNoCallback();
        }
    }

    private void dJr() {
    }

    private void dJs() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bBF().bBQ()) {
            this.ncD.turnOnNoCallback();
            this.ncE.setVisibility(0);
            dJu();
            return;
        }
        this.ncD.turnOffNoCallback();
        this.ncE.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.mBack.setOnClickListener(msgRemindActivity);
        this.ncq.setOnSwitchStateChangeListener(msgRemindActivity);
        this.ncs.setOnSwitchStateChangeListener(msgRemindActivity);
        this.ncr.setOnSwitchStateChangeListener(msgRemindActivity);
        this.nct.setOnSwitchStateChangeListener(msgRemindActivity);
        this.ncu.setOnSwitchStateChangeListener(msgRemindActivity);
        this.ncv.setOnSwitchStateChangeListener(msgRemindActivity);
        this.ncw.setOnSwitchStateChangeListener(msgRemindActivity);
        this.ncx.setOnSwitchStateChangeListener(msgRemindActivity);
        this.ncy.setOnSwitchStateChangeListener(msgRemindActivity);
        this.ncz.setOnSwitchStateChangeListener(msgRemindActivity);
        this.ncA.setOnSwitchStateChangeListener(msgRemindActivity);
        this.ncB.setOnClickListener(msgRemindActivity);
        this.ncD.setOnSwitchStateChangeListener(msgRemindActivity);
        this.ncE.setOnClickListener(msgRemindActivity);
        this.ncI.setOnClickListener(msgRemindActivity);
        this.ncK.setOnClickListener(msgRemindActivity);
        this.ncO.setOnClickListener(msgRemindActivity);
        this.mNavigationBar.getCenterText().setOnClickListener(msgRemindActivity);
    }

    public void xC(boolean z) {
        this.ncD.setLineVisibility(z);
        if (z) {
            this.ncE.setVisibility(0);
            dJu();
            ao.setBackgroundResource(this.ncE, R.drawable.more_all);
            return;
        }
        this.ncE.setVisibility(8);
    }

    public void xD(boolean z) {
        if (z) {
            this.ncB.setVisibility(0);
            this.ncA.setLineVisibility(true);
            ao.setBackgroundResource(this.ncB, R.drawable.more_all);
            return;
        }
        this.ncB.setVisibility(8);
        this.ncA.setLineVisibility(false);
    }

    public void xE(boolean z) {
    }

    public void dJt() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bBF().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.d.bBF().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.d.bBF().getSignAlertMins();
            this.ncC.setText(this.ncN.getString(R.string.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.ncB.setVisibility(0);
            if (!this.ncA.isOn()) {
                this.ncA.turnOnNoCallback();
                return;
            }
            return;
        }
        this.ncC.setText(R.string.close);
        this.ncB.setVisibility(8);
        if (this.ncA.isOn()) {
            this.ncA.turnOffNoCallback();
        }
    }

    public void dJu() {
        String bBS = com.baidu.tbadk.coreExtra.messageCenter.d.bBF().bBS();
        String bBT = com.baidu.tbadk.coreExtra.messageCenter.d.bBF().bBT();
        this.ncF.setText(bBS + Constants.ACCEPT_TIME_SEPARATOR_SERVER + bBT);
        this.ncJ.setText(bBS);
        this.ncL.setText(bBT);
    }

    public BdSwitchView dJv() {
        return this.ncA.getSwitchView();
    }

    public BdSwitchView dJw() {
        return this.nco.getSwitchView();
    }

    public View dJx() {
        return this.ncB;
    }

    public BdSwitchView dJy() {
        return this.ncD.getSwitchView();
    }

    public View dJz() {
        return this.ncE;
    }

    public LinearLayout dJA() {
        return this.ncI;
    }

    public LinearLayout dJB() {
        return this.ncK;
    }

    public BdSwitchView dJC() {
        return this.ncx.getSwitchView();
    }

    public BdSwitchView dJD() {
        return this.ncy.getSwitchView();
    }

    public BdSwitchView dJE() {
        return this.ncz.getSwitchView();
    }

    public BdSwitchView dJF() {
        return this.ncw.getSwitchView();
    }

    public BdSwitchView dJG() {
        return this.ncq.getSwitchView();
    }

    public BdSwitchView dJH() {
        return this.ncr.getSwitchView();
    }

    public BdSwitchView dJI() {
        return this.ncs.getSwitchView();
    }

    public BdSwitchView dJJ() {
        return this.ncu.getSwitchView();
    }

    public BdSwitchView dJK() {
        return this.ncv.getSwitchView();
    }

    public BdSwitchView dJL() {
        return this.nct.getSwitchView();
    }

    public TbSettingTextTipView dJM() {
        return this.ncO;
    }

    public TextView dJN() {
        return this.mNavigationBar.getCenterText();
    }

    public void dJO() {
        this.ncq.setOnSwitchStateChangeListener(null);
        this.ncq.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bBF().bBM());
        this.ncq.setOnSwitchStateChangeListener(this.ncN);
    }

    public void dJP() {
        this.ncr.setOnSwitchStateChangeListener(null);
        this.ncr.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bBF().bBW());
        this.ncr.setOnSwitchStateChangeListener(this.ncN);
    }

    public void dJQ() {
        this.ncs.setOnSwitchStateChangeListener(null);
        this.ncs.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bBF().bBK());
        this.ncs.setOnSwitchStateChangeListener(this.ncN);
    }

    public void dJR() {
        this.nct.setOnSwitchStateChangeListener(null);
        this.nct.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bBF().bBL());
        this.nct.setOnSwitchStateChangeListener(this.ncN);
    }

    public void dJS() {
        this.ncu.setOnSwitchStateChangeListener(null);
        this.ncu.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bBF().bBN());
        this.ncu.setOnSwitchStateChangeListener(this.ncN);
    }

    public void dJT() {
        this.ncv.setOnSwitchStateChangeListener(null);
        this.ncv.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bBF().bBV());
        this.ncv.setOnSwitchStateChangeListener(this.ncN);
    }

    public void xF(boolean z) {
        if (this.ncM != z) {
            this.ncM = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.ncN.getString(R.string.msg_remind));
                this.ncG.setVisibility(0);
                this.ncH.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.ncN.getString(R.string.no_disturb_mode_time));
            this.ncH.setVisibility(0);
            this.ncG.setVisibility(8);
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
        this.ncN.getLayoutMode().setNightMode(i == 1);
        this.ncN.getLayoutMode().onModeChanged(this.iVh);
        this.mNavigationBar.onChangeSkinType(this.ncN.getPageContext(), i);
        this.nco.onChangeSkinType(this.ncN.getPageContext(), i);
        this.ncq.onChangeSkinType(this.ncN.getPageContext(), i);
        this.ncr.onChangeSkinType(this.ncN.getPageContext(), i);
        this.ncs.onChangeSkinType(this.ncN.getPageContext(), i);
        this.nct.onChangeSkinType(this.ncN.getPageContext(), i);
        this.ncu.onChangeSkinType(this.ncN.getPageContext(), i);
        this.ncv.onChangeSkinType(this.ncN.getPageContext(), i);
        this.ncw.onChangeSkinType(this.ncN.getPageContext(), i);
        this.ncx.onChangeSkinType(this.ncN.getPageContext(), i);
        this.ncy.onChangeSkinType(this.ncN.getPageContext(), i);
        this.ncz.onChangeSkinType(this.ncN.getPageContext(), i);
        this.ncA.onChangeSkinType(this.ncN.getPageContext(), i);
        this.ncD.onChangeSkinType(this.ncN.getPageContext(), i);
        this.ncd.onChangeSkinType(this.ncN.getPageContext(), i);
        this.nce.onChangeSkinType(this.ncN.getPageContext(), i);
        this.ncf.onChangeSkinType(this.ncN.getPageContext(), i);
        this.ncS.onChangeSkinType(this.ncN.getPageContext(), i);
        ao.setBackgroundResource(this.ncE, R.drawable.more_all);
        ao.setBackgroundResource(this.ncI, R.drawable.more_all);
        ao.setBackgroundResource(this.ncK, R.drawable.more_all);
        ao.setBackgroundResource(this.ncB, R.drawable.more_all);
        SvgManager.bwq().a((ImageView) this.ncE.findViewById(R.id.no_disturb_mode_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bwq().a((ImageView) this.ncB.findViewById(R.id.sign_remind_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bwq().a((ImageView) this.ncI.findViewById(R.id.no_disturb_start_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bwq().a((ImageView) this.ncK.findViewById(R.id.no_disturb_end_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
    }

    public BdSwitchView dJe() {
        return this.ncd.getSwitchView();
    }

    public BdSwitchView dJf() {
        return this.nce.getSwitchView();
    }

    public BdSwitchView dJg() {
        return this.ncf.getSwitchView();
    }

    public BdSwitchView dJU() {
        return this.ncS.getSwitchView();
    }

    public void xB(boolean z) {
        this.ncd.setLineVisibility(z);
    }

    public void xA(boolean z) {
        if (z) {
            this.nce.setVisibility(0);
        } else {
            this.nce.setVisibility(8);
        }
    }

    public void dJV() {
        com.baidu.tbadk.coreExtra.messageCenter.f.bCb().a(this.ncN.getActivity(), this.iVh);
    }

    public void onDestroy() {
    }

    public void onResume() {
        int i;
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.ncN).areNotificationsEnabled();
        if (areNotificationsEnabled) {
            this.ncQ.turnOn();
            i = 1;
        } else {
            this.ncQ.turnOff();
            i = 2;
        }
        this.ncP.setVisibility(areNotificationsEnabled ? 8 : 0);
        xG(areNotificationsEnabled);
        TiebaStatic.log(new aq("c13889").an("obj_locate", i).an("obj_source", 8));
    }

    private void xG(boolean z) {
        if (z) {
            this.ncq.getSwitchView().setEnabled(true);
            this.ncr.getSwitchView().setEnabled(true);
            this.nct.getSwitchView().setEnabled(true);
            this.ncs.getSwitchView().setEnabled(true);
            this.ncd.getSwitchView().setEnabled(true);
            this.nce.getSwitchView().setEnabled(true);
            this.ncf.getSwitchView().setEnabled(true);
            this.ncS.getSwitchView().setEnabled(true);
            this.ncA.getSwitchView().setEnabled(true);
            this.ncD.getSwitchView().setEnabled(true);
            this.ncq.getSwitchView().setAlpha(1.0f);
            this.ncr.getSwitchView().setAlpha(1.0f);
            this.nct.getSwitchView().setAlpha(1.0f);
            this.ncs.getSwitchView().setAlpha(1.0f);
            this.ncd.getSwitchView().setAlpha(1.0f);
            this.nce.getSwitchView().setAlpha(1.0f);
            this.ncf.getSwitchView().setAlpha(1.0f);
            this.ncS.getSwitchView().setAlpha(1.0f);
            this.ncA.getSwitchView().setAlpha(1.0f);
            this.ncD.getSwitchView().setAlpha(1.0f);
            return;
        }
        this.ncq.getSwitchView().setEnabled(false);
        this.ncr.getSwitchView().setEnabled(false);
        this.nct.getSwitchView().setEnabled(false);
        this.ncs.getSwitchView().setEnabled(false);
        this.ncd.getSwitchView().setEnabled(false);
        this.nce.getSwitchView().setEnabled(false);
        this.ncf.getSwitchView().setEnabled(false);
        this.ncS.getSwitchView().setEnabled(false);
        this.ncA.getSwitchView().setEnabled(false);
        this.ncD.getSwitchView().setEnabled(false);
        this.ncq.getSwitchView().setAlpha(0.3f);
        this.ncr.getSwitchView().setAlpha(0.3f);
        this.nct.getSwitchView().setAlpha(0.3f);
        this.ncs.getSwitchView().setAlpha(0.3f);
        this.ncd.getSwitchView().setAlpha(0.3f);
        this.nce.getSwitchView().setAlpha(0.3f);
        this.ncf.getSwitchView().setAlpha(0.3f);
        this.ncS.getSwitchView().setAlpha(0.3f);
        this.ncA.getSwitchView().setAlpha(0.3f);
        this.ncD.getSwitchView().setAlpha(0.3f);
    }
}
