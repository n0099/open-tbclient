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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
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
    private LinearLayout iWh;
    private View mBack;
    private NavigationBar mNavigationBar;
    private MsgSettingItemView nhA;
    private MsgSettingItemView nhB;
    private MsgSettingItemView nhC;
    private LinearLayout nhD;
    private TextView nhE;
    private MsgSettingItemView nhF;
    private LinearLayout nhG;
    private TextView nhH;
    private LinearLayout nhI;
    private LinearLayout nhJ;
    private LinearLayout nhK;
    private TextView nhL;
    private LinearLayout nhM;
    private TextView nhN;
    public boolean nhO;
    private MsgRemindActivity nhP;
    private TbSettingTextTipView nhQ;
    private View nhR;
    private BdSwitchView nhS;
    private View nhT;
    private MsgSettingItemView nhU;
    private MsgSettingItemView nhf;
    private MsgSettingItemView nhg;
    private MsgSettingItemView nhh;
    private MsgSettingItemView nhq;
    private LinearLayout nhr;
    private MsgSettingItemView nhs;
    private MsgSettingItemView nht;
    private MsgSettingItemView nhu;
    private MsgSettingItemView nhv;
    private MsgSettingItemView nhw;
    private MsgSettingItemView nhx;
    private MsgSettingItemView nhy;
    private MsgSettingItemView nhz;

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.iWh = null;
        this.mNavigationBar = null;
        this.nhO = true;
        this.nhP = msgRemindActivity;
        msgRemindActivity.setContentView(R.layout.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        dHI();
        dHL();
        dHK();
        dHJ();
        dHM();
        d(msgRemindActivity);
        dHD();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.iWh = (LinearLayout) msgRemindActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(R.string.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.nhI = (LinearLayout) msgRemindActivity.findViewById(R.id.front_container);
        this.nhJ = (LinearLayout) msgRemindActivity.findViewById(R.id.back_container);
        this.nhq = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.receive_message_swtich);
        this.nhq.setText(R.string.receive_msg_text);
        this.nhq.setLineVisibility(false);
        this.nhr = (LinearLayout) msgRemindActivity.findViewById(R.id.receive_message_container);
        this.nhs = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.reply_check_box);
        this.nhs.setText(R.string.reply);
        this.nht = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.zan_check_box);
        this.nht.setVisibility(0);
        this.nht.setText(R.string.action_praise_default);
        this.nhu = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.at_me_check_box);
        this.nhu.setText(R.string.mention_atme);
        this.nhv = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.new_fans_swtich);
        this.nhv.setText(R.string.new_fans);
        this.nhw = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.chat_msg_swtich);
        this.nhw.setText(R.string.chat_msg_text);
        this.nhx = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.group_chat_swtich);
        this.nhx.setLineVisibility(false);
        this.nhx.setText(R.string.group_chat_text);
        this.nhy = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.screen_lock_swtich);
        this.nhy.setText(R.string.remind_screen_lock);
        this.nhy.setLineVisibility(false);
        this.nhz = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.tone_remind_swtich);
        this.nhz.setText(R.string.remind_tone);
        this.nhA = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.vibrate_remind_swtich);
        this.nhA.setText(R.string.remind_vibrate);
        this.nhB = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.light_remind_swtich);
        this.nhB.setLineVisibility(true);
        this.nhB.setText(R.string.remind_light);
        this.nhC = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.sign_remind_swtich);
        this.nhC.setText(R.string.sign_remind_outline);
        this.nhD = (LinearLayout) msgRemindActivity.findViewById(R.id.sign_remind);
        this.nhE = (TextView) msgRemindActivity.findViewById(R.id.sign_remind_time);
        this.nhF = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.no_disturb_swtich);
        this.nhF.setText(R.string.no_disturb_mode);
        this.nhF.setLineVisibility(false);
        this.nhG = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_container);
        this.nhH = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_value);
        this.nhK = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_start_time);
        this.nhL = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_start_time_value);
        this.nhM = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_end_time);
        this.nhN = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_end_time_value);
        this.nhQ = (TbSettingTextTipView) msgRemindActivity.findViewById(R.id.msg_receive_item_view);
        this.nhR = msgRemindActivity.findViewById(R.id.layout_system_msg_permission);
        boolean areNotificationsEnabled = NotificationManagerCompat.from(msgRemindActivity).areNotificationsEnabled();
        this.nhR.setVisibility(areNotificationsEnabled ? 8 : 0);
        TiebaStatic.log(new ar("c13890").ap("obj_type", areNotificationsEnabled ? 1 : 2));
        this.nhS = (BdSwitchView) msgRemindActivity.findViewById(R.id.system_msg_permission_switch);
        this.nhT = msgRemindActivity.findViewById(R.id.system_msg_permission_switch_cover);
        this.nhT.setOnClickListener(msgRemindActivity);
        this.nhf = (MsgSettingItemView) this.nhP.findViewById(R.id.item_view_friend_msg);
        this.nhf.setText(R.string.friend_msg_switch);
        this.nhf.setOnSwitchStateChangeListener(this.nhP);
        this.nhg = (MsgSettingItemView) this.nhP.findViewById(R.id.item_view_stranger_msg);
        this.nhg.setText(R.string.stranger_msg_switch);
        this.nhg.setOnSwitchStateChangeListener(this.nhP);
        this.nhg.setLineVisibility(false);
        dHw();
        this.nhh = (MsgSettingItemView) this.nhP.findViewById(R.id.item_view_forum_broadcast_msg);
        this.nhh.setText(R.string.receive_forum_broadcast_message);
        this.nhh.setOnSwitchStateChangeListener(this.nhP);
        this.nhh.setLineVisibility(false);
        dHx();
        this.nhU = (MsgSettingItemView) this.nhP.findViewById(R.id.item_view_tb_selection_msg);
        this.nhU.setText(R.string.official_push_message_switch_text);
        this.nhU.setOnSwitchStateChangeListener(this.nhP);
        this.nhU.setLineVisibility(false);
        dHC();
    }

    private void dHw() {
        if (this.nhf == null || this.nhg == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.nhf.getSwitchView().turnOnNoCallback();
                this.nhf.setLineVisibility(true);
                this.nhg.getSwitchView().turnOffNoCallback();
                return;
            default:
                this.nhf.getSwitchView().turnOffNoCallback();
                this.nhf.setLineVisibility(false);
                this.nhg.setVisibility(8);
                this.nhg.getSwitchView().turnOffNoCallback();
                return;
        }
    }

    private void dHx() {
        if (this.nhh != null) {
            this.nhh.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bye().byy());
        }
    }

    private void dHC() {
        if (this.nhU != null) {
            this.nhU.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bye().byz());
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
                    if (com.baidu.tbadk.coreExtra.messageCenter.d.bye().byz() != z) {
                        g.this.nhU.setSwitchStateNoCallback(z);
                    }
                }
            }).dIP();
        }
    }

    private void dHD() {
        dHE();
        dHF();
        dHG();
        dHH();
    }

    private void dHE() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.nhF.setVisibility(8);
            this.nhG.setVisibility(8);
            this.nhq.setVisibility(8);
            this.nhr.setVisibility(8);
            this.nhC.setVisibility(8);
            this.nhD.setVisibility(8);
            this.nhz.setVisibility(8);
            this.nhA.setVisibility(8);
            this.nhB.setVisibility(8);
            this.nhy.setVisibility(8);
        }
    }

    private void dHF() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.nhy.setLineVisibility(true);
        } else {
            this.nhy.setLineVisibility(false);
        }
    }

    private void dHG() {
        this.nhw.setLineVisibility(TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class));
    }

    private void dHH() {
        TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class);
    }

    public View UM() {
        return this.mBack;
    }

    private void dHI() {
        this.nhs.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bye().byl());
        this.nht.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bye().byv());
        this.nhu.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bye().byj());
        this.nhv.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bye().byk());
        this.nhw.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bye().bym());
        this.nhx.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bye().byu());
    }

    private void dHJ() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bye().isSignAlertOn()) {
            this.nhC.turnOn();
            this.nhD.setVisibility(0);
            this.nhC.setLineVisibility(true);
            dHN();
            return;
        }
        this.nhC.turnOff();
        this.nhC.setLineVisibility(false);
        this.nhD.setVisibility(8);
    }

    private void dHK() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bye().byn()) {
            this.nhz.turnOnNoCallback();
        } else {
            this.nhz.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bye().byq()) {
            this.nhA.turnOnNoCallback();
        } else {
            this.nhA.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bye().byo()) {
            this.nhB.turnOnNoCallback();
        } else {
            this.nhB.turnOffNoCallback();
        }
    }

    private void dHL() {
    }

    private void dHM() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bye().byp()) {
            this.nhF.turnOnNoCallback();
            this.nhG.setVisibility(0);
            dHO();
            return;
        }
        this.nhF.turnOffNoCallback();
        this.nhG.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.mBack.setOnClickListener(msgRemindActivity);
        this.nhs.setOnSwitchStateChangeListener(msgRemindActivity);
        this.nhu.setOnSwitchStateChangeListener(msgRemindActivity);
        this.nht.setOnSwitchStateChangeListener(msgRemindActivity);
        this.nhv.setOnSwitchStateChangeListener(msgRemindActivity);
        this.nhw.setOnSwitchStateChangeListener(msgRemindActivity);
        this.nhx.setOnSwitchStateChangeListener(msgRemindActivity);
        this.nhy.setOnSwitchStateChangeListener(msgRemindActivity);
        this.nhz.setOnSwitchStateChangeListener(msgRemindActivity);
        this.nhA.setOnSwitchStateChangeListener(msgRemindActivity);
        this.nhB.setOnSwitchStateChangeListener(msgRemindActivity);
        this.nhC.setOnSwitchStateChangeListener(msgRemindActivity);
        this.nhD.setOnClickListener(msgRemindActivity);
        this.nhF.setOnSwitchStateChangeListener(msgRemindActivity);
        this.nhG.setOnClickListener(msgRemindActivity);
        this.nhK.setOnClickListener(msgRemindActivity);
        this.nhM.setOnClickListener(msgRemindActivity);
        this.nhQ.setOnClickListener(msgRemindActivity);
        this.mNavigationBar.getCenterText().setOnClickListener(msgRemindActivity);
    }

    public void xR(boolean z) {
        this.nhF.setLineVisibility(z);
        if (z) {
            this.nhG.setVisibility(0);
            dHO();
            ap.setBackgroundResource(this.nhG, R.drawable.more_all);
            return;
        }
        this.nhG.setVisibility(8);
    }

    public void xS(boolean z) {
        if (z) {
            this.nhD.setVisibility(0);
            this.nhC.setLineVisibility(true);
            ap.setBackgroundResource(this.nhD, R.drawable.more_all);
            return;
        }
        this.nhD.setVisibility(8);
        this.nhC.setLineVisibility(false);
    }

    public void xT(boolean z) {
    }

    public void dHN() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bye().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.d.bye().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.d.bye().getSignAlertMins();
            this.nhE.setText(this.nhP.getString(R.string.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.nhD.setVisibility(0);
            if (!this.nhC.isOn()) {
                this.nhC.turnOnNoCallback();
                return;
            }
            return;
        }
        this.nhE.setText(R.string.close);
        this.nhD.setVisibility(8);
        if (this.nhC.isOn()) {
            this.nhC.turnOffNoCallback();
        }
    }

    public void dHO() {
        String byr = com.baidu.tbadk.coreExtra.messageCenter.d.bye().byr();
        String bys = com.baidu.tbadk.coreExtra.messageCenter.d.bye().bys();
        this.nhH.setText(byr + Constants.ACCEPT_TIME_SEPARATOR_SERVER + bys);
        this.nhL.setText(byr);
        this.nhN.setText(bys);
    }

    public BdSwitchView dHP() {
        return this.nhC.getSwitchView();
    }

    public BdSwitchView dHQ() {
        return this.nhq.getSwitchView();
    }

    public View dHR() {
        return this.nhD;
    }

    public BdSwitchView dHS() {
        return this.nhF.getSwitchView();
    }

    public View dHT() {
        return this.nhG;
    }

    public LinearLayout dHU() {
        return this.nhK;
    }

    public LinearLayout dHV() {
        return this.nhM;
    }

    public BdSwitchView dHW() {
        return this.nhz.getSwitchView();
    }

    public BdSwitchView dHX() {
        return this.nhA.getSwitchView();
    }

    public BdSwitchView dHY() {
        return this.nhB.getSwitchView();
    }

    public BdSwitchView dHZ() {
        return this.nhy.getSwitchView();
    }

    public BdSwitchView dIa() {
        return this.nhs.getSwitchView();
    }

    public BdSwitchView dIb() {
        return this.nht.getSwitchView();
    }

    public BdSwitchView dIc() {
        return this.nhu.getSwitchView();
    }

    public BdSwitchView dId() {
        return this.nhw.getSwitchView();
    }

    public BdSwitchView dIe() {
        return this.nhx.getSwitchView();
    }

    public BdSwitchView dIf() {
        return this.nhv.getSwitchView();
    }

    public TbSettingTextTipView dIg() {
        return this.nhQ;
    }

    public TextView dIh() {
        return this.mNavigationBar.getCenterText();
    }

    public void dIi() {
        this.nhs.setOnSwitchStateChangeListener(null);
        this.nhs.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bye().byl());
        this.nhs.setOnSwitchStateChangeListener(this.nhP);
    }

    public void dIj() {
        this.nht.setOnSwitchStateChangeListener(null);
        this.nht.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bye().byv());
        this.nht.setOnSwitchStateChangeListener(this.nhP);
    }

    public void dIk() {
        this.nhu.setOnSwitchStateChangeListener(null);
        this.nhu.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bye().byj());
        this.nhu.setOnSwitchStateChangeListener(this.nhP);
    }

    public void dIl() {
        this.nhv.setOnSwitchStateChangeListener(null);
        this.nhv.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bye().byk());
        this.nhv.setOnSwitchStateChangeListener(this.nhP);
    }

    public void dIm() {
        this.nhw.setOnSwitchStateChangeListener(null);
        this.nhw.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bye().bym());
        this.nhw.setOnSwitchStateChangeListener(this.nhP);
    }

    public void dIn() {
        this.nhx.setOnSwitchStateChangeListener(null);
        this.nhx.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bye().byu());
        this.nhx.setOnSwitchStateChangeListener(this.nhP);
    }

    public void xU(boolean z) {
        if (this.nhO != z) {
            this.nhO = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.nhP.getString(R.string.msg_remind));
                this.nhI.setVisibility(0);
                this.nhJ.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.nhP.getString(R.string.no_disturb_mode_time));
            this.nhJ.setVisibility(0);
            this.nhI.setVisibility(8);
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
        this.nhP.getLayoutMode().setNightMode(i == 1);
        this.nhP.getLayoutMode().onModeChanged(this.iWh);
        this.mNavigationBar.onChangeSkinType(this.nhP.getPageContext(), i);
        this.nhq.onChangeSkinType(this.nhP.getPageContext(), i);
        this.nhs.onChangeSkinType(this.nhP.getPageContext(), i);
        this.nht.onChangeSkinType(this.nhP.getPageContext(), i);
        this.nhu.onChangeSkinType(this.nhP.getPageContext(), i);
        this.nhv.onChangeSkinType(this.nhP.getPageContext(), i);
        this.nhw.onChangeSkinType(this.nhP.getPageContext(), i);
        this.nhx.onChangeSkinType(this.nhP.getPageContext(), i);
        this.nhy.onChangeSkinType(this.nhP.getPageContext(), i);
        this.nhz.onChangeSkinType(this.nhP.getPageContext(), i);
        this.nhA.onChangeSkinType(this.nhP.getPageContext(), i);
        this.nhB.onChangeSkinType(this.nhP.getPageContext(), i);
        this.nhC.onChangeSkinType(this.nhP.getPageContext(), i);
        this.nhF.onChangeSkinType(this.nhP.getPageContext(), i);
        this.nhf.onChangeSkinType(this.nhP.getPageContext(), i);
        this.nhg.onChangeSkinType(this.nhP.getPageContext(), i);
        this.nhh.onChangeSkinType(this.nhP.getPageContext(), i);
        this.nhU.onChangeSkinType(this.nhP.getPageContext(), i);
        ap.setBackgroundResource(this.nhG, R.drawable.more_all);
        ap.setBackgroundResource(this.nhK, R.drawable.more_all);
        ap.setBackgroundResource(this.nhM, R.drawable.more_all);
        ap.setBackgroundResource(this.nhD, R.drawable.more_all);
        SvgManager.bsR().a((ImageView) this.nhG.findViewById(R.id.no_disturb_mode_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bsR().a((ImageView) this.nhD.findViewById(R.id.sign_remind_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bsR().a((ImageView) this.nhK.findViewById(R.id.no_disturb_start_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bsR().a((ImageView) this.nhM.findViewById(R.id.no_disturb_end_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
    }

    public BdSwitchView dHy() {
        return this.nhf.getSwitchView();
    }

    public BdSwitchView dHz() {
        return this.nhg.getSwitchView();
    }

    public BdSwitchView dHA() {
        return this.nhh.getSwitchView();
    }

    public BdSwitchView dIo() {
        return this.nhU.getSwitchView();
    }

    public void xQ(boolean z) {
        this.nhf.setLineVisibility(z);
    }

    public void xP(boolean z) {
        if (z) {
            this.nhg.setVisibility(0);
        } else {
            this.nhg.setVisibility(8);
        }
    }

    public void dIp() {
        com.baidu.tbadk.coreExtra.messageCenter.f.byA().a(this.nhP.getActivity(), this.iWh);
    }

    public void onDestroy() {
    }

    public void onResume() {
        int i;
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.nhP).areNotificationsEnabled();
        if (areNotificationsEnabled) {
            this.nhS.turnOn();
            i = 1;
        } else {
            this.nhS.turnOff();
            i = 2;
        }
        this.nhR.setVisibility(areNotificationsEnabled ? 8 : 0);
        xV(areNotificationsEnabled);
        TiebaStatic.log(new ar("c13889").ap("obj_locate", i).ap("obj_source", 8));
    }

    private void xV(boolean z) {
        if (z) {
            this.nhs.getSwitchView().setEnabled(true);
            this.nht.getSwitchView().setEnabled(true);
            this.nhv.getSwitchView().setEnabled(true);
            this.nhu.getSwitchView().setEnabled(true);
            this.nhf.getSwitchView().setEnabled(true);
            this.nhg.getSwitchView().setEnabled(true);
            this.nhh.getSwitchView().setEnabled(true);
            this.nhU.getSwitchView().setEnabled(true);
            this.nhC.getSwitchView().setEnabled(true);
            this.nhF.getSwitchView().setEnabled(true);
            this.nhs.getSwitchView().setAlpha(1.0f);
            this.nht.getSwitchView().setAlpha(1.0f);
            this.nhv.getSwitchView().setAlpha(1.0f);
            this.nhu.getSwitchView().setAlpha(1.0f);
            this.nhf.getSwitchView().setAlpha(1.0f);
            this.nhg.getSwitchView().setAlpha(1.0f);
            this.nhh.getSwitchView().setAlpha(1.0f);
            this.nhU.getSwitchView().setAlpha(1.0f);
            this.nhC.getSwitchView().setAlpha(1.0f);
            this.nhF.getSwitchView().setAlpha(1.0f);
            return;
        }
        this.nhs.getSwitchView().setEnabled(false);
        this.nht.getSwitchView().setEnabled(false);
        this.nhv.getSwitchView().setEnabled(false);
        this.nhu.getSwitchView().setEnabled(false);
        this.nhf.getSwitchView().setEnabled(false);
        this.nhg.getSwitchView().setEnabled(false);
        this.nhh.getSwitchView().setEnabled(false);
        this.nhU.getSwitchView().setEnabled(false);
        this.nhC.getSwitchView().setEnabled(false);
        this.nhF.getSwitchView().setEnabled(false);
        this.nhs.getSwitchView().setAlpha(0.3f);
        this.nht.getSwitchView().setAlpha(0.3f);
        this.nhv.getSwitchView().setAlpha(0.3f);
        this.nhu.getSwitchView().setAlpha(0.3f);
        this.nhf.getSwitchView().setAlpha(0.3f);
        this.nhg.getSwitchView().setAlpha(0.3f);
        this.nhh.getSwitchView().setAlpha(0.3f);
        this.nhU.getSwitchView().setAlpha(0.3f);
        this.nhC.getSwitchView().setAlpha(0.3f);
        this.nhF.getSwitchView().setAlpha(0.3f);
    }
}
