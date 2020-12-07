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
/* loaded from: classes26.dex */
public class g extends com.baidu.adp.base.c<MsgRemindActivity> {
    private LinearLayout iIU;
    private View mBack;
    private NavigationBar mNavigationBar;
    private MsgSettingItemView mWF;
    private MsgSettingItemView mWG;
    private MsgSettingItemView mWH;
    private MsgSettingItemView mWR;
    private LinearLayout mWS;
    private MsgSettingItemView mWT;
    private MsgSettingItemView mWU;
    private MsgSettingItemView mWV;
    private MsgSettingItemView mWW;
    private MsgSettingItemView mWX;
    private MsgSettingItemView mWY;
    private MsgSettingItemView mWZ;
    private MsgSettingItemView mXa;
    private MsgSettingItemView mXb;
    private MsgSettingItemView mXc;
    private MsgSettingItemView mXd;
    private LinearLayout mXe;
    private TextView mXf;
    private MsgSettingItemView mXg;
    private LinearLayout mXh;
    private TextView mXi;
    private LinearLayout mXj;
    private LinearLayout mXk;
    private LinearLayout mXl;
    private TextView mXm;
    private LinearLayout mXn;
    private TextView mXo;
    public boolean mXp;
    private MsgRemindActivity mXq;
    private TbSettingTextTipView mXr;
    private View mXs;
    private BdSwitchView mXt;
    private View mXu;
    private MsgSettingItemView mXv;

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.iIU = null;
        this.mNavigationBar = null;
        this.mXp = true;
        this.mXq = msgRemindActivity;
        msgRemindActivity.setContentView(R.layout.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        dJy();
        dJB();
        dJA();
        dJz();
        dJC();
        d(msgRemindActivity);
        dJt();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.iIU = (LinearLayout) msgRemindActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(R.string.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mXj = (LinearLayout) msgRemindActivity.findViewById(R.id.front_container);
        this.mXk = (LinearLayout) msgRemindActivity.findViewById(R.id.back_container);
        this.mWR = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.receive_message_swtich);
        this.mWR.setText(R.string.receive_msg_text);
        this.mWR.setLineVisibility(false);
        this.mWS = (LinearLayout) msgRemindActivity.findViewById(R.id.receive_message_container);
        this.mWT = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.reply_check_box);
        this.mWT.setText(R.string.reply);
        this.mWU = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.zan_check_box);
        this.mWU.setVisibility(0);
        this.mWU.setText(R.string.action_praise_default);
        this.mWV = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.at_me_check_box);
        this.mWV.setText(R.string.mention_atme);
        this.mWW = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.new_fans_swtich);
        this.mWW.setText(R.string.new_fans);
        this.mWX = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.chat_msg_swtich);
        this.mWX.setText(R.string.chat_msg_text);
        this.mWY = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.group_chat_swtich);
        this.mWY.setLineVisibility(false);
        this.mWY.setText(R.string.group_chat_text);
        this.mWZ = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.screen_lock_swtich);
        this.mWZ.setText(R.string.remind_screen_lock);
        this.mWZ.setLineVisibility(false);
        this.mXa = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.tone_remind_swtich);
        this.mXa.setText(R.string.remind_tone);
        this.mXb = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.vibrate_remind_swtich);
        this.mXb.setText(R.string.remind_vibrate);
        this.mXc = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.light_remind_swtich);
        this.mXc.setLineVisibility(true);
        this.mXc.setText(R.string.remind_light);
        this.mXd = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.sign_remind_swtich);
        this.mXd.setText(R.string.sign_remind_outline);
        this.mXe = (LinearLayout) msgRemindActivity.findViewById(R.id.sign_remind);
        this.mXf = (TextView) msgRemindActivity.findViewById(R.id.sign_remind_time);
        this.mXg = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.no_disturb_swtich);
        this.mXg.setText(R.string.no_disturb_mode);
        this.mXg.setLineVisibility(false);
        this.mXh = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_container);
        this.mXi = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_value);
        this.mXl = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_start_time);
        this.mXm = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_start_time_value);
        this.mXn = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_end_time);
        this.mXo = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_end_time_value);
        this.mXr = (TbSettingTextTipView) msgRemindActivity.findViewById(R.id.msg_receive_item_view);
        this.mXs = msgRemindActivity.findViewById(R.id.layout_system_msg_permission);
        boolean areNotificationsEnabled = NotificationManagerCompat.from(msgRemindActivity).areNotificationsEnabled();
        this.mXs.setVisibility(areNotificationsEnabled ? 8 : 0);
        TiebaStatic.log(new ar("c13890").al("obj_type", areNotificationsEnabled ? 1 : 2));
        this.mXt = (BdSwitchView) msgRemindActivity.findViewById(R.id.system_msg_permission_switch);
        this.mXu = msgRemindActivity.findViewById(R.id.system_msg_permission_switch_cover);
        this.mXu.setOnClickListener(msgRemindActivity);
        this.mWF = (MsgSettingItemView) this.mXq.findViewById(R.id.item_view_friend_msg);
        this.mWF.setText(R.string.friend_msg_switch);
        this.mWF.setOnSwitchStateChangeListener(this.mXq);
        this.mWG = (MsgSettingItemView) this.mXq.findViewById(R.id.item_view_stranger_msg);
        this.mWG.setText(R.string.stranger_msg_switch);
        this.mWG.setOnSwitchStateChangeListener(this.mXq);
        this.mWG.setLineVisibility(false);
        dJm();
        this.mWH = (MsgSettingItemView) this.mXq.findViewById(R.id.item_view_forum_broadcast_msg);
        this.mWH.setText(R.string.receive_forum_broadcast_message);
        this.mWH.setOnSwitchStateChangeListener(this.mXq);
        this.mWH.setLineVisibility(false);
        dJn();
        this.mXv = (MsgSettingItemView) this.mXq.findViewById(R.id.item_view_tb_selection_msg);
        this.mXv.setText(R.string.official_push_message_switch_text);
        this.mXv.setOnSwitchStateChangeListener(this.mXq);
        this.mXv.setLineVisibility(false);
        dJs();
    }

    private void dJm() {
        if (this.mWF == null || this.mWG == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.mWF.getSwitchView().turnOnNoCallback();
                this.mWF.setLineVisibility(true);
                this.mWG.getSwitchView().turnOffNoCallback();
                return;
            default:
                this.mWF.getSwitchView().turnOffNoCallback();
                this.mWF.setLineVisibility(false);
                this.mWG.setVisibility(8);
                this.mWG.getSwitchView().turnOffNoCallback();
                return;
        }
    }

    private void dJn() {
        if (this.mWH != null) {
            this.mWH.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzF());
        }
    }

    private void dJs() {
        if (this.mXv != null) {
            this.mXv.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzG());
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
                    if (com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzG() != z) {
                        g.this.mXv.setSwitchStateNoCallback(z);
                    }
                }
            }).dKF();
        }
    }

    private void dJt() {
        dJu();
        dJv();
        dJw();
        dJx();
    }

    private void dJu() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.mXg.setVisibility(8);
            this.mXh.setVisibility(8);
            this.mWR.setVisibility(8);
            this.mWS.setVisibility(8);
            this.mXd.setVisibility(8);
            this.mXe.setVisibility(8);
            this.mXa.setVisibility(8);
            this.mXb.setVisibility(8);
            this.mXc.setVisibility(8);
            this.mWZ.setVisibility(8);
        }
    }

    private void dJv() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.mWZ.setLineVisibility(true);
        } else {
            this.mWZ.setLineVisibility(false);
        }
    }

    private void dJw() {
        this.mWX.setLineVisibility(TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class));
    }

    private void dJx() {
        TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class);
    }

    public View VV() {
        return this.mBack;
    }

    private void dJy() {
        this.mWT.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzs());
        this.mWU.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzC());
        this.mWV.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzq());
        this.mWW.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzr());
        this.mWX.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzt());
        this.mWY.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzB());
    }

    private void dJz() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bzl().isSignAlertOn()) {
            this.mXd.turnOn();
            this.mXe.setVisibility(0);
            this.mXd.setLineVisibility(true);
            dJD();
            return;
        }
        this.mXd.turnOff();
        this.mXd.setLineVisibility(false);
        this.mXe.setVisibility(8);
    }

    private void dJA() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzu()) {
            this.mXa.turnOnNoCallback();
        } else {
            this.mXa.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzx()) {
            this.mXb.turnOnNoCallback();
        } else {
            this.mXb.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzv()) {
            this.mXc.turnOnNoCallback();
        } else {
            this.mXc.turnOffNoCallback();
        }
    }

    private void dJB() {
    }

    private void dJC() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzw()) {
            this.mXg.turnOnNoCallback();
            this.mXh.setVisibility(0);
            dJE();
            return;
        }
        this.mXg.turnOffNoCallback();
        this.mXh.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.mBack.setOnClickListener(msgRemindActivity);
        this.mWT.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mWV.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mWU.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mWW.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mWX.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mWY.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mWZ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mXa.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mXb.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mXc.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mXd.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mXe.setOnClickListener(msgRemindActivity);
        this.mXg.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mXh.setOnClickListener(msgRemindActivity);
        this.mXl.setOnClickListener(msgRemindActivity);
        this.mXn.setOnClickListener(msgRemindActivity);
        this.mXr.setOnClickListener(msgRemindActivity);
        this.mNavigationBar.getCenterText().setOnClickListener(msgRemindActivity);
    }

    public void xB(boolean z) {
        this.mXg.setLineVisibility(z);
        if (z) {
            this.mXh.setVisibility(0);
            dJE();
            ap.setBackgroundResource(this.mXh, R.drawable.more_all);
            return;
        }
        this.mXh.setVisibility(8);
    }

    public void xC(boolean z) {
        if (z) {
            this.mXe.setVisibility(0);
            this.mXd.setLineVisibility(true);
            ap.setBackgroundResource(this.mXe, R.drawable.more_all);
            return;
        }
        this.mXe.setVisibility(8);
        this.mXd.setLineVisibility(false);
    }

    public void xD(boolean z) {
    }

    public void dJD() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bzl().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.d.bzl().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.d.bzl().getSignAlertMins();
            this.mXf.setText(this.mXq.getString(R.string.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.mXe.setVisibility(0);
            if (!this.mXd.isOn()) {
                this.mXd.turnOnNoCallback();
                return;
            }
            return;
        }
        this.mXf.setText(R.string.close);
        this.mXe.setVisibility(8);
        if (this.mXd.isOn()) {
            this.mXd.turnOffNoCallback();
        }
    }

    public void dJE() {
        String bzy = com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzy();
        String bzz = com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzz();
        this.mXi.setText(bzy + Constants.ACCEPT_TIME_SEPARATOR_SERVER + bzz);
        this.mXm.setText(bzy);
        this.mXo.setText(bzz);
    }

    public BdSwitchView dJF() {
        return this.mXd.getSwitchView();
    }

    public BdSwitchView dJG() {
        return this.mWR.getSwitchView();
    }

    public View dJH() {
        return this.mXe;
    }

    public BdSwitchView dJI() {
        return this.mXg.getSwitchView();
    }

    public View dJJ() {
        return this.mXh;
    }

    public LinearLayout dJK() {
        return this.mXl;
    }

    public LinearLayout dJL() {
        return this.mXn;
    }

    public BdSwitchView dJM() {
        return this.mXa.getSwitchView();
    }

    public BdSwitchView dJN() {
        return this.mXb.getSwitchView();
    }

    public BdSwitchView dJO() {
        return this.mXc.getSwitchView();
    }

    public BdSwitchView dJP() {
        return this.mWZ.getSwitchView();
    }

    public BdSwitchView dJQ() {
        return this.mWT.getSwitchView();
    }

    public BdSwitchView dJR() {
        return this.mWU.getSwitchView();
    }

    public BdSwitchView dJS() {
        return this.mWV.getSwitchView();
    }

    public BdSwitchView dJT() {
        return this.mWX.getSwitchView();
    }

    public BdSwitchView dJU() {
        return this.mWY.getSwitchView();
    }

    public BdSwitchView dJV() {
        return this.mWW.getSwitchView();
    }

    public TbSettingTextTipView dJW() {
        return this.mXr;
    }

    public TextView dJX() {
        return this.mNavigationBar.getCenterText();
    }

    public void dJY() {
        this.mWT.setOnSwitchStateChangeListener(null);
        this.mWT.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzs());
        this.mWT.setOnSwitchStateChangeListener(this.mXq);
    }

    public void dJZ() {
        this.mWU.setOnSwitchStateChangeListener(null);
        this.mWU.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzC());
        this.mWU.setOnSwitchStateChangeListener(this.mXq);
    }

    public void dKa() {
        this.mWV.setOnSwitchStateChangeListener(null);
        this.mWV.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzq());
        this.mWV.setOnSwitchStateChangeListener(this.mXq);
    }

    public void dKb() {
        this.mWW.setOnSwitchStateChangeListener(null);
        this.mWW.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzr());
        this.mWW.setOnSwitchStateChangeListener(this.mXq);
    }

    public void dKc() {
        this.mWX.setOnSwitchStateChangeListener(null);
        this.mWX.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzt());
        this.mWX.setOnSwitchStateChangeListener(this.mXq);
    }

    public void dKd() {
        this.mWY.setOnSwitchStateChangeListener(null);
        this.mWY.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzB());
        this.mWY.setOnSwitchStateChangeListener(this.mXq);
    }

    public void xE(boolean z) {
        if (this.mXp != z) {
            this.mXp = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.mXq.getString(R.string.msg_remind));
                this.mXj.setVisibility(0);
                this.mXk.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.mXq.getString(R.string.no_disturb_mode_time));
            this.mXk.setVisibility(0);
            this.mXj.setVisibility(8);
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
        this.mXq.getLayoutMode().setNightMode(i == 1);
        this.mXq.getLayoutMode().onModeChanged(this.iIU);
        this.mNavigationBar.onChangeSkinType(this.mXq.getPageContext(), i);
        this.mWR.onChangeSkinType(this.mXq.getPageContext(), i);
        this.mWT.onChangeSkinType(this.mXq.getPageContext(), i);
        this.mWU.onChangeSkinType(this.mXq.getPageContext(), i);
        this.mWV.onChangeSkinType(this.mXq.getPageContext(), i);
        this.mWW.onChangeSkinType(this.mXq.getPageContext(), i);
        this.mWX.onChangeSkinType(this.mXq.getPageContext(), i);
        this.mWY.onChangeSkinType(this.mXq.getPageContext(), i);
        this.mWZ.onChangeSkinType(this.mXq.getPageContext(), i);
        this.mXa.onChangeSkinType(this.mXq.getPageContext(), i);
        this.mXb.onChangeSkinType(this.mXq.getPageContext(), i);
        this.mXc.onChangeSkinType(this.mXq.getPageContext(), i);
        this.mXd.onChangeSkinType(this.mXq.getPageContext(), i);
        this.mXg.onChangeSkinType(this.mXq.getPageContext(), i);
        this.mWF.onChangeSkinType(this.mXq.getPageContext(), i);
        this.mWG.onChangeSkinType(this.mXq.getPageContext(), i);
        this.mWH.onChangeSkinType(this.mXq.getPageContext(), i);
        this.mXv.onChangeSkinType(this.mXq.getPageContext(), i);
        ap.setBackgroundResource(this.mXh, R.drawable.more_all);
        ap.setBackgroundResource(this.mXl, R.drawable.more_all);
        ap.setBackgroundResource(this.mXn, R.drawable.more_all);
        ap.setBackgroundResource(this.mXe, R.drawable.more_all);
        SvgManager.btW().a((ImageView) this.mXh.findViewById(R.id.no_disturb_mode_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.btW().a((ImageView) this.mXe.findViewById(R.id.sign_remind_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.btW().a((ImageView) this.mXl.findViewById(R.id.no_disturb_start_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.btW().a((ImageView) this.mXn.findViewById(R.id.no_disturb_end_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
    }

    public BdSwitchView dJo() {
        return this.mWF.getSwitchView();
    }

    public BdSwitchView dJp() {
        return this.mWG.getSwitchView();
    }

    public BdSwitchView dJq() {
        return this.mWH.getSwitchView();
    }

    public BdSwitchView dKe() {
        return this.mXv.getSwitchView();
    }

    public void xA(boolean z) {
        this.mWF.setLineVisibility(z);
    }

    public void xz(boolean z) {
        if (z) {
            this.mWG.setVisibility(0);
        } else {
            this.mWG.setVisibility(8);
        }
    }

    public void dKf() {
        com.baidu.tbadk.coreExtra.messageCenter.f.bzH().a(this.mXq.getActivity(), this.iIU);
    }

    public void onDestroy() {
    }

    public void onResume() {
        int i;
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.mXq).areNotificationsEnabled();
        if (areNotificationsEnabled) {
            this.mXt.turnOn();
            i = 1;
        } else {
            this.mXt.turnOff();
            i = 2;
        }
        this.mXs.setVisibility(areNotificationsEnabled ? 8 : 0);
        sn(areNotificationsEnabled);
        TiebaStatic.log(new ar("c13889").al("obj_locate", i).al("obj_source", 8));
    }

    private void sn(boolean z) {
        if (z) {
            this.mWT.getSwitchView().setEnabled(true);
            this.mWU.getSwitchView().setEnabled(true);
            this.mWW.getSwitchView().setEnabled(true);
            this.mWV.getSwitchView().setEnabled(true);
            this.mWF.getSwitchView().setEnabled(true);
            this.mWG.getSwitchView().setEnabled(true);
            this.mWH.getSwitchView().setEnabled(true);
            this.mXv.getSwitchView().setEnabled(true);
            this.mXd.getSwitchView().setEnabled(true);
            this.mXg.getSwitchView().setEnabled(true);
            this.mWT.getSwitchView().setAlpha(1.0f);
            this.mWU.getSwitchView().setAlpha(1.0f);
            this.mWW.getSwitchView().setAlpha(1.0f);
            this.mWV.getSwitchView().setAlpha(1.0f);
            this.mWF.getSwitchView().setAlpha(1.0f);
            this.mWG.getSwitchView().setAlpha(1.0f);
            this.mWH.getSwitchView().setAlpha(1.0f);
            this.mXv.getSwitchView().setAlpha(1.0f);
            this.mXd.getSwitchView().setAlpha(1.0f);
            this.mXg.getSwitchView().setAlpha(1.0f);
            return;
        }
        this.mWT.getSwitchView().setEnabled(false);
        this.mWU.getSwitchView().setEnabled(false);
        this.mWW.getSwitchView().setEnabled(false);
        this.mWV.getSwitchView().setEnabled(false);
        this.mWF.getSwitchView().setEnabled(false);
        this.mWG.getSwitchView().setEnabled(false);
        this.mWH.getSwitchView().setEnabled(false);
        this.mXv.getSwitchView().setEnabled(false);
        this.mXd.getSwitchView().setEnabled(false);
        this.mXg.getSwitchView().setEnabled(false);
        this.mWT.getSwitchView().setAlpha(0.3f);
        this.mWU.getSwitchView().setAlpha(0.3f);
        this.mWW.getSwitchView().setAlpha(0.3f);
        this.mWV.getSwitchView().setAlpha(0.3f);
        this.mWF.getSwitchView().setAlpha(0.3f);
        this.mWG.getSwitchView().setAlpha(0.3f);
        this.mWH.getSwitchView().setAlpha(0.3f);
        this.mXv.getSwitchView().setAlpha(0.3f);
        this.mXd.getSwitchView().setAlpha(0.3f);
        this.mXg.getSwitchView().setAlpha(0.3f);
    }
}
