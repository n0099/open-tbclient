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
/* loaded from: classes25.dex */
public class g extends com.baidu.adp.base.c<MsgRemindActivity> {
    private LinearLayout hPT;
    private MsgSettingItemView lZS;
    private MsgSettingItemView lZT;
    private MsgSettingItemView lZU;
    private View mBack;
    private NavigationBar mNavigationBar;
    private LinearLayout maA;
    private TextView maB;
    private LinearLayout maC;
    private TextView maD;
    public boolean maE;
    private MsgRemindActivity maF;
    private TbSettingTextTipView maG;
    private View maH;
    private BdSwitchView maI;
    private View maJ;
    private MsgSettingItemView maK;
    private MsgSettingItemView mae;
    private LinearLayout maf;
    private MsgSettingItemView mag;
    private MsgSettingItemView mah;
    private MsgSettingItemView mai;
    private MsgSettingItemView maj;
    private MsgSettingItemView mak;
    private MsgSettingItemView mal;
    private MsgSettingItemView mam;
    private MsgSettingItemView man;
    private MsgSettingItemView mao;
    private MsgSettingItemView maq;
    private MsgSettingItemView mar;
    private LinearLayout mas;
    private TextView mat;
    private MsgSettingItemView mau;
    private LinearLayout mav;
    private TextView maw;
    private LinearLayout may;
    private LinearLayout maz;

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.hPT = null;
        this.mNavigationBar = null;
        this.maE = true;
        this.maF = msgRemindActivity;
        msgRemindActivity.setContentView(R.layout.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        dvn();
        dvq();
        dvp();
        dvo();
        dvr();
        d(msgRemindActivity);
        dvi();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.hPT = (LinearLayout) msgRemindActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(R.string.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.may = (LinearLayout) msgRemindActivity.findViewById(R.id.front_container);
        this.maz = (LinearLayout) msgRemindActivity.findViewById(R.id.back_container);
        this.mae = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.receive_message_swtich);
        this.mae.setText(R.string.receive_msg_text);
        this.mae.setLineVisibility(false);
        this.maf = (LinearLayout) msgRemindActivity.findViewById(R.id.receive_message_container);
        this.mag = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.reply_check_box);
        this.mag.setText(R.string.reply);
        this.mah = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.zan_check_box);
        this.mah.setVisibility(0);
        this.mah.setText(R.string.action_praise_default);
        this.mai = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.at_me_check_box);
        this.mai.setText(R.string.mention_atme);
        this.maj = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.new_fans_swtich);
        this.maj.setText(R.string.new_fans);
        this.mak = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.chat_msg_swtich);
        this.mak.setText(R.string.chat_msg_text);
        this.mal = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.group_chat_swtich);
        this.mal.setLineVisibility(false);
        this.mal.setText(R.string.group_chat_text);
        this.mam = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.screen_lock_swtich);
        this.mam.setText(R.string.remind_screen_lock);
        this.mam.setLineVisibility(false);
        this.man = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.tone_remind_swtich);
        this.man.setText(R.string.remind_tone);
        this.mao = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.vibrate_remind_swtich);
        this.mao.setText(R.string.remind_vibrate);
        this.maq = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.light_remind_swtich);
        this.maq.setLineVisibility(true);
        this.maq.setText(R.string.remind_light);
        this.mar = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.sign_remind_swtich);
        this.mar.setText(R.string.sign_remind_outline);
        this.mas = (LinearLayout) msgRemindActivity.findViewById(R.id.sign_remind);
        this.mat = (TextView) msgRemindActivity.findViewById(R.id.sign_remind_time);
        this.mau = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.no_disturb_swtich);
        this.mau.setText(R.string.no_disturb_mode);
        this.mau.setLineVisibility(false);
        this.mav = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_container);
        this.maw = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_value);
        this.maA = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_start_time);
        this.maB = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_start_time_value);
        this.maC = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_end_time);
        this.maD = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_end_time_value);
        this.maG = (TbSettingTextTipView) msgRemindActivity.findViewById(R.id.msg_receive_item_view);
        this.maH = msgRemindActivity.findViewById(R.id.layout_system_msg_permission);
        boolean areNotificationsEnabled = NotificationManagerCompat.from(msgRemindActivity).areNotificationsEnabled();
        this.maH.setVisibility(areNotificationsEnabled ? 8 : 0);
        TiebaStatic.log(new aq("c13890").ai("obj_type", areNotificationsEnabled ? 1 : 2));
        this.maI = (BdSwitchView) msgRemindActivity.findViewById(R.id.system_msg_permission_switch);
        this.maJ = msgRemindActivity.findViewById(R.id.system_msg_permission_switch_cover);
        this.maJ.setOnClickListener(msgRemindActivity);
        this.lZS = (MsgSettingItemView) this.maF.findViewById(R.id.item_view_friend_msg);
        this.lZS.setText(R.string.friend_msg_switch);
        this.lZS.setOnSwitchStateChangeListener(this.maF);
        this.lZT = (MsgSettingItemView) this.maF.findViewById(R.id.item_view_stranger_msg);
        this.lZT.setText(R.string.stranger_msg_switch);
        this.lZT.setOnSwitchStateChangeListener(this.maF);
        this.lZT.setLineVisibility(false);
        dvb();
        this.lZU = (MsgSettingItemView) this.maF.findViewById(R.id.item_view_forum_broadcast_msg);
        this.lZU.setText(R.string.receive_forum_broadcast_message);
        this.lZU.setOnSwitchStateChangeListener(this.maF);
        this.lZU.setLineVisibility(false);
        dvc();
        this.maK = (MsgSettingItemView) this.maF.findViewById(R.id.item_view_tb_selection_msg);
        this.maK.setText(R.string.official_push_message_switch_text);
        this.maK.setOnSwitchStateChangeListener(this.maF);
        this.maK.setLineVisibility(false);
        dvh();
    }

    private void dvb() {
        if (this.lZS == null || this.lZT == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.lZS.getSwitchView().turnOnNoCallback();
                this.lZS.setLineVisibility(true);
                this.lZT.getSwitchView().turnOffNoCallback();
                return;
            default:
                this.lZS.getSwitchView().turnOffNoCallback();
                this.lZS.setLineVisibility(false);
                this.lZT.setVisibility(8);
                this.lZT.getSwitchView().turnOffNoCallback();
                return;
        }
    }

    private void dvc() {
        if (this.lZU != null) {
            this.lZU.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bps().bpM());
        }
    }

    private void dvh() {
        if (this.maK != null) {
            this.maK.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bps().bpN());
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
                    if (com.baidu.tbadk.coreExtra.messageCenter.d.bps().bpN() != z) {
                        g.this.maK.setSwitchStateNoCallback(z);
                    }
                }
            }).dwk();
        }
    }

    private void dvi() {
        dvj();
        dvk();
        dvl();
        dvm();
    }

    private void dvj() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.mau.setVisibility(8);
            this.mav.setVisibility(8);
            this.mae.setVisibility(8);
            this.maf.setVisibility(8);
            this.mar.setVisibility(8);
            this.mas.setVisibility(8);
            this.man.setVisibility(8);
            this.mao.setVisibility(8);
            this.maq.setVisibility(8);
            this.mam.setVisibility(8);
        }
    }

    private void dvk() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.mam.setLineVisibility(true);
        } else {
            this.mam.setLineVisibility(false);
        }
    }

    private void dvl() {
        this.mak.setLineVisibility(TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class));
    }

    private void dvm() {
        TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class);
    }

    public View Pw() {
        return this.mBack;
    }

    private void dvn() {
        this.mag.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bps().bpz());
        this.mah.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bps().bpJ());
        this.mai.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bps().bpx());
        this.maj.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bps().bpy());
        this.mak.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bps().bpA());
        this.mal.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bps().bpI());
    }

    private void dvo() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bps().isSignAlertOn()) {
            this.mar.turnOn();
            this.mas.setVisibility(0);
            this.mar.setLineVisibility(true);
            dvs();
            return;
        }
        this.mar.turnOff();
        this.mar.setLineVisibility(false);
        this.mas.setVisibility(8);
    }

    private void dvp() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bps().bpB()) {
            this.man.turnOnNoCallback();
        } else {
            this.man.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bps().bpE()) {
            this.mao.turnOnNoCallback();
        } else {
            this.mao.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bps().bpC()) {
            this.maq.turnOnNoCallback();
        } else {
            this.maq.turnOffNoCallback();
        }
    }

    private void dvq() {
    }

    private void dvr() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bps().bpD()) {
            this.mau.turnOnNoCallback();
            this.mav.setVisibility(0);
            dvt();
            return;
        }
        this.mau.turnOffNoCallback();
        this.mav.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.mBack.setOnClickListener(msgRemindActivity);
        this.mag.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mai.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mah.setOnSwitchStateChangeListener(msgRemindActivity);
        this.maj.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mak.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mal.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mam.setOnSwitchStateChangeListener(msgRemindActivity);
        this.man.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mao.setOnSwitchStateChangeListener(msgRemindActivity);
        this.maq.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mar.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mas.setOnClickListener(msgRemindActivity);
        this.mau.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mav.setOnClickListener(msgRemindActivity);
        this.maA.setOnClickListener(msgRemindActivity);
        this.maC.setOnClickListener(msgRemindActivity);
        this.maG.setOnClickListener(msgRemindActivity);
        this.mNavigationBar.getCenterText().setOnClickListener(msgRemindActivity);
    }

    public void vN(boolean z) {
        this.mau.setLineVisibility(z);
        if (z) {
            this.mav.setVisibility(0);
            dvt();
            ap.setBackgroundResource(this.mav, R.drawable.more_all);
            return;
        }
        this.mav.setVisibility(8);
    }

    public void vO(boolean z) {
        if (z) {
            this.mas.setVisibility(0);
            this.mar.setLineVisibility(true);
            ap.setBackgroundResource(this.mas, R.drawable.more_all);
            return;
        }
        this.mas.setVisibility(8);
        this.mar.setLineVisibility(false);
    }

    public void vP(boolean z) {
    }

    public void dvs() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bps().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.d.bps().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.d.bps().getSignAlertMins();
            this.mat.setText(this.maF.getString(R.string.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.mas.setVisibility(0);
            if (!this.mar.isOn()) {
                this.mar.turnOnNoCallback();
                return;
            }
            return;
        }
        this.mat.setText(R.string.close);
        this.mas.setVisibility(8);
        if (this.mar.isOn()) {
            this.mar.turnOffNoCallback();
        }
    }

    public void dvt() {
        String bpF = com.baidu.tbadk.coreExtra.messageCenter.d.bps().bpF();
        String bpG = com.baidu.tbadk.coreExtra.messageCenter.d.bps().bpG();
        this.maw.setText(bpF + Constants.ACCEPT_TIME_SEPARATOR_SERVER + bpG);
        this.maB.setText(bpF);
        this.maD.setText(bpG);
    }

    public BdSwitchView dvu() {
        return this.mar.getSwitchView();
    }

    public BdSwitchView dvv() {
        return this.mae.getSwitchView();
    }

    public View dvw() {
        return this.mas;
    }

    public BdSwitchView dvx() {
        return this.mau.getSwitchView();
    }

    public View dvy() {
        return this.mav;
    }

    public LinearLayout dvz() {
        return this.maA;
    }

    public LinearLayout dvA() {
        return this.maC;
    }

    public BdSwitchView dvB() {
        return this.man.getSwitchView();
    }

    public BdSwitchView dvC() {
        return this.mao.getSwitchView();
    }

    public BdSwitchView dvD() {
        return this.maq.getSwitchView();
    }

    public BdSwitchView dvE() {
        return this.mam.getSwitchView();
    }

    public BdSwitchView dvF() {
        return this.mag.getSwitchView();
    }

    public BdSwitchView dvG() {
        return this.mah.getSwitchView();
    }

    public BdSwitchView dvH() {
        return this.mai.getSwitchView();
    }

    public BdSwitchView dvI() {
        return this.mak.getSwitchView();
    }

    public BdSwitchView dvJ() {
        return this.mal.getSwitchView();
    }

    public BdSwitchView dvK() {
        return this.maj.getSwitchView();
    }

    public TbSettingTextTipView dvL() {
        return this.maG;
    }

    public TextView dvM() {
        return this.mNavigationBar.getCenterText();
    }

    public void dvN() {
        this.mag.setOnSwitchStateChangeListener(null);
        this.mag.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bps().bpz());
        this.mag.setOnSwitchStateChangeListener(this.maF);
    }

    public void dvO() {
        this.mah.setOnSwitchStateChangeListener(null);
        this.mah.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bps().bpJ());
        this.mah.setOnSwitchStateChangeListener(this.maF);
    }

    public void dvP() {
        this.mai.setOnSwitchStateChangeListener(null);
        this.mai.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bps().bpx());
        this.mai.setOnSwitchStateChangeListener(this.maF);
    }

    public void dvQ() {
        this.maj.setOnSwitchStateChangeListener(null);
        this.maj.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bps().bpy());
        this.maj.setOnSwitchStateChangeListener(this.maF);
    }

    public void dvR() {
        this.mak.setOnSwitchStateChangeListener(null);
        this.mak.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bps().bpA());
        this.mak.setOnSwitchStateChangeListener(this.maF);
    }

    public void dvS() {
        this.mal.setOnSwitchStateChangeListener(null);
        this.mal.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bps().bpI());
        this.mal.setOnSwitchStateChangeListener(this.maF);
    }

    public void vQ(boolean z) {
        if (this.maE != z) {
            this.maE = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.maF.getString(R.string.msg_remind));
                this.may.setVisibility(0);
                this.maz.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.maF.getString(R.string.no_disturb_mode_time));
            this.maz.setVisibility(0);
            this.may.setVisibility(8);
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
        this.maF.getLayoutMode().setNightMode(i == 1);
        this.maF.getLayoutMode().onModeChanged(this.hPT);
        this.mNavigationBar.onChangeSkinType(this.maF.getPageContext(), i);
        this.mae.onChangeSkinType(this.maF.getPageContext(), i);
        this.mag.onChangeSkinType(this.maF.getPageContext(), i);
        this.mah.onChangeSkinType(this.maF.getPageContext(), i);
        this.mai.onChangeSkinType(this.maF.getPageContext(), i);
        this.maj.onChangeSkinType(this.maF.getPageContext(), i);
        this.mak.onChangeSkinType(this.maF.getPageContext(), i);
        this.mal.onChangeSkinType(this.maF.getPageContext(), i);
        this.mam.onChangeSkinType(this.maF.getPageContext(), i);
        this.man.onChangeSkinType(this.maF.getPageContext(), i);
        this.mao.onChangeSkinType(this.maF.getPageContext(), i);
        this.maq.onChangeSkinType(this.maF.getPageContext(), i);
        this.mar.onChangeSkinType(this.maF.getPageContext(), i);
        this.mau.onChangeSkinType(this.maF.getPageContext(), i);
        this.lZS.onChangeSkinType(this.maF.getPageContext(), i);
        this.lZT.onChangeSkinType(this.maF.getPageContext(), i);
        this.lZU.onChangeSkinType(this.maF.getPageContext(), i);
        this.maK.onChangeSkinType(this.maF.getPageContext(), i);
        ap.setBackgroundResource(this.mav, R.drawable.more_all);
        ap.setBackgroundResource(this.maA, R.drawable.more_all);
        ap.setBackgroundResource(this.maC, R.drawable.more_all);
        ap.setBackgroundResource(this.mas, R.drawable.more_all);
        SvgManager.bkl().a((ImageView) this.mav.findViewById(R.id.no_disturb_mode_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bkl().a((ImageView) this.mas.findViewById(R.id.sign_remind_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bkl().a((ImageView) this.maA.findViewById(R.id.no_disturb_start_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bkl().a((ImageView) this.maC.findViewById(R.id.no_disturb_end_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
    }

    public BdSwitchView dvd() {
        return this.lZS.getSwitchView();
    }

    public BdSwitchView dve() {
        return this.lZT.getSwitchView();
    }

    public BdSwitchView dvf() {
        return this.lZU.getSwitchView();
    }

    public BdSwitchView dvT() {
        return this.maK.getSwitchView();
    }

    public void vM(boolean z) {
        this.lZS.setLineVisibility(z);
    }

    public void vL(boolean z) {
        if (z) {
            this.lZT.setVisibility(0);
        } else {
            this.lZT.setVisibility(8);
        }
    }

    public void dvU() {
        com.baidu.tbadk.coreExtra.messageCenter.f.bpO().a(this.maF.getActivity(), this.hPT);
    }

    public void onDestroy() {
    }

    public void onResume() {
        int i;
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.maF).areNotificationsEnabled();
        if (areNotificationsEnabled) {
            this.maI.turnOn();
            i = 1;
        } else {
            this.maI.turnOff();
            i = 2;
        }
        this.maH.setVisibility(areNotificationsEnabled ? 8 : 0);
        qB(areNotificationsEnabled);
        TiebaStatic.log(new aq("c13889").ai("obj_locate", i).ai("obj_source", 8));
    }

    private void qB(boolean z) {
        if (z) {
            this.mag.getSwitchView().setEnabled(true);
            this.mah.getSwitchView().setEnabled(true);
            this.maj.getSwitchView().setEnabled(true);
            this.mai.getSwitchView().setEnabled(true);
            this.lZS.getSwitchView().setEnabled(true);
            this.lZT.getSwitchView().setEnabled(true);
            this.lZU.getSwitchView().setEnabled(true);
            this.maK.getSwitchView().setEnabled(true);
            this.mar.getSwitchView().setEnabled(true);
            this.mau.getSwitchView().setEnabled(true);
            this.mag.getSwitchView().setAlpha(1.0f);
            this.mah.getSwitchView().setAlpha(1.0f);
            this.maj.getSwitchView().setAlpha(1.0f);
            this.mai.getSwitchView().setAlpha(1.0f);
            this.lZS.getSwitchView().setAlpha(1.0f);
            this.lZT.getSwitchView().setAlpha(1.0f);
            this.lZU.getSwitchView().setAlpha(1.0f);
            this.maK.getSwitchView().setAlpha(1.0f);
            this.mar.getSwitchView().setAlpha(1.0f);
            this.mau.getSwitchView().setAlpha(1.0f);
            return;
        }
        this.mag.getSwitchView().setEnabled(false);
        this.mah.getSwitchView().setEnabled(false);
        this.maj.getSwitchView().setEnabled(false);
        this.mai.getSwitchView().setEnabled(false);
        this.lZS.getSwitchView().setEnabled(false);
        this.lZT.getSwitchView().setEnabled(false);
        this.lZU.getSwitchView().setEnabled(false);
        this.maK.getSwitchView().setEnabled(false);
        this.mar.getSwitchView().setEnabled(false);
        this.mau.getSwitchView().setEnabled(false);
        this.mag.getSwitchView().setAlpha(0.3f);
        this.mah.getSwitchView().setAlpha(0.3f);
        this.maj.getSwitchView().setAlpha(0.3f);
        this.mai.getSwitchView().setAlpha(0.3f);
        this.lZS.getSwitchView().setAlpha(0.3f);
        this.lZT.getSwitchView().setAlpha(0.3f);
        this.lZU.getSwitchView().setAlpha(0.3f);
        this.maK.getSwitchView().setAlpha(0.3f);
        this.mar.getSwitchView().setAlpha(0.3f);
        this.mau.getSwitchView().setAlpha(0.3f);
    }
}
