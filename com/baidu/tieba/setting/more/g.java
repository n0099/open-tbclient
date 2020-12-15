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
    private LinearLayout iIW;
    private View mBack;
    private NavigationBar mNavigationBar;
    private MsgSettingItemView mWH;
    private MsgSettingItemView mWI;
    private MsgSettingItemView mWJ;
    private MsgSettingItemView mWT;
    private LinearLayout mWU;
    private MsgSettingItemView mWV;
    private MsgSettingItemView mWW;
    private MsgSettingItemView mWX;
    private MsgSettingItemView mWY;
    private MsgSettingItemView mWZ;
    private MsgSettingItemView mXa;
    private MsgSettingItemView mXb;
    private MsgSettingItemView mXc;
    private MsgSettingItemView mXd;
    private MsgSettingItemView mXe;
    private MsgSettingItemView mXf;
    private LinearLayout mXg;
    private TextView mXh;
    private MsgSettingItemView mXi;
    private LinearLayout mXj;
    private TextView mXk;
    private LinearLayout mXl;
    private LinearLayout mXm;
    private LinearLayout mXn;
    private TextView mXo;
    private LinearLayout mXp;
    private TextView mXq;
    public boolean mXr;
    private MsgRemindActivity mXs;
    private TbSettingTextTipView mXt;
    private View mXu;
    private BdSwitchView mXv;
    private View mXw;
    private MsgSettingItemView mXx;

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.iIW = null;
        this.mNavigationBar = null;
        this.mXr = true;
        this.mXs = msgRemindActivity;
        msgRemindActivity.setContentView(R.layout.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        dJz();
        dJC();
        dJB();
        dJA();
        dJD();
        d(msgRemindActivity);
        dJu();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.iIW = (LinearLayout) msgRemindActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(R.string.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mXl = (LinearLayout) msgRemindActivity.findViewById(R.id.front_container);
        this.mXm = (LinearLayout) msgRemindActivity.findViewById(R.id.back_container);
        this.mWT = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.receive_message_swtich);
        this.mWT.setText(R.string.receive_msg_text);
        this.mWT.setLineVisibility(false);
        this.mWU = (LinearLayout) msgRemindActivity.findViewById(R.id.receive_message_container);
        this.mWV = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.reply_check_box);
        this.mWV.setText(R.string.reply);
        this.mWW = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.zan_check_box);
        this.mWW.setVisibility(0);
        this.mWW.setText(R.string.action_praise_default);
        this.mWX = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.at_me_check_box);
        this.mWX.setText(R.string.mention_atme);
        this.mWY = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.new_fans_swtich);
        this.mWY.setText(R.string.new_fans);
        this.mWZ = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.chat_msg_swtich);
        this.mWZ.setText(R.string.chat_msg_text);
        this.mXa = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.group_chat_swtich);
        this.mXa.setLineVisibility(false);
        this.mXa.setText(R.string.group_chat_text);
        this.mXb = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.screen_lock_swtich);
        this.mXb.setText(R.string.remind_screen_lock);
        this.mXb.setLineVisibility(false);
        this.mXc = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.tone_remind_swtich);
        this.mXc.setText(R.string.remind_tone);
        this.mXd = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.vibrate_remind_swtich);
        this.mXd.setText(R.string.remind_vibrate);
        this.mXe = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.light_remind_swtich);
        this.mXe.setLineVisibility(true);
        this.mXe.setText(R.string.remind_light);
        this.mXf = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.sign_remind_swtich);
        this.mXf.setText(R.string.sign_remind_outline);
        this.mXg = (LinearLayout) msgRemindActivity.findViewById(R.id.sign_remind);
        this.mXh = (TextView) msgRemindActivity.findViewById(R.id.sign_remind_time);
        this.mXi = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.no_disturb_swtich);
        this.mXi.setText(R.string.no_disturb_mode);
        this.mXi.setLineVisibility(false);
        this.mXj = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_container);
        this.mXk = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_value);
        this.mXn = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_start_time);
        this.mXo = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_start_time_value);
        this.mXp = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_end_time);
        this.mXq = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_end_time_value);
        this.mXt = (TbSettingTextTipView) msgRemindActivity.findViewById(R.id.msg_receive_item_view);
        this.mXu = msgRemindActivity.findViewById(R.id.layout_system_msg_permission);
        boolean areNotificationsEnabled = NotificationManagerCompat.from(msgRemindActivity).areNotificationsEnabled();
        this.mXu.setVisibility(areNotificationsEnabled ? 8 : 0);
        TiebaStatic.log(new ar("c13890").al("obj_type", areNotificationsEnabled ? 1 : 2));
        this.mXv = (BdSwitchView) msgRemindActivity.findViewById(R.id.system_msg_permission_switch);
        this.mXw = msgRemindActivity.findViewById(R.id.system_msg_permission_switch_cover);
        this.mXw.setOnClickListener(msgRemindActivity);
        this.mWH = (MsgSettingItemView) this.mXs.findViewById(R.id.item_view_friend_msg);
        this.mWH.setText(R.string.friend_msg_switch);
        this.mWH.setOnSwitchStateChangeListener(this.mXs);
        this.mWI = (MsgSettingItemView) this.mXs.findViewById(R.id.item_view_stranger_msg);
        this.mWI.setText(R.string.stranger_msg_switch);
        this.mWI.setOnSwitchStateChangeListener(this.mXs);
        this.mWI.setLineVisibility(false);
        dJn();
        this.mWJ = (MsgSettingItemView) this.mXs.findViewById(R.id.item_view_forum_broadcast_msg);
        this.mWJ.setText(R.string.receive_forum_broadcast_message);
        this.mWJ.setOnSwitchStateChangeListener(this.mXs);
        this.mWJ.setLineVisibility(false);
        dJo();
        this.mXx = (MsgSettingItemView) this.mXs.findViewById(R.id.item_view_tb_selection_msg);
        this.mXx.setText(R.string.official_push_message_switch_text);
        this.mXx.setOnSwitchStateChangeListener(this.mXs);
        this.mXx.setLineVisibility(false);
        dJt();
    }

    private void dJn() {
        if (this.mWH == null || this.mWI == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.mWH.getSwitchView().turnOnNoCallback();
                this.mWH.setLineVisibility(true);
                this.mWI.getSwitchView().turnOffNoCallback();
                return;
            default:
                this.mWH.getSwitchView().turnOffNoCallback();
                this.mWH.setLineVisibility(false);
                this.mWI.setVisibility(8);
                this.mWI.getSwitchView().turnOffNoCallback();
                return;
        }
    }

    private void dJo() {
        if (this.mWJ != null) {
            this.mWJ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzF());
        }
    }

    private void dJt() {
        if (this.mXx != null) {
            this.mXx.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzG());
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
                        g.this.mXx.setSwitchStateNoCallback(z);
                    }
                }
            }).dKG();
        }
    }

    private void dJu() {
        dJv();
        dJw();
        dJx();
        dJy();
    }

    private void dJv() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.mXi.setVisibility(8);
            this.mXj.setVisibility(8);
            this.mWT.setVisibility(8);
            this.mWU.setVisibility(8);
            this.mXf.setVisibility(8);
            this.mXg.setVisibility(8);
            this.mXc.setVisibility(8);
            this.mXd.setVisibility(8);
            this.mXe.setVisibility(8);
            this.mXb.setVisibility(8);
        }
    }

    private void dJw() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.mXb.setLineVisibility(true);
        } else {
            this.mXb.setLineVisibility(false);
        }
    }

    private void dJx() {
        this.mWZ.setLineVisibility(TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class));
    }

    private void dJy() {
        TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class);
    }

    public View VV() {
        return this.mBack;
    }

    private void dJz() {
        this.mWV.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzs());
        this.mWW.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzC());
        this.mWX.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzq());
        this.mWY.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzr());
        this.mWZ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzt());
        this.mXa.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzB());
    }

    private void dJA() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bzl().isSignAlertOn()) {
            this.mXf.turnOn();
            this.mXg.setVisibility(0);
            this.mXf.setLineVisibility(true);
            dJE();
            return;
        }
        this.mXf.turnOff();
        this.mXf.setLineVisibility(false);
        this.mXg.setVisibility(8);
    }

    private void dJB() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzu()) {
            this.mXc.turnOnNoCallback();
        } else {
            this.mXc.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzx()) {
            this.mXd.turnOnNoCallback();
        } else {
            this.mXd.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzv()) {
            this.mXe.turnOnNoCallback();
        } else {
            this.mXe.turnOffNoCallback();
        }
    }

    private void dJC() {
    }

    private void dJD() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzw()) {
            this.mXi.turnOnNoCallback();
            this.mXj.setVisibility(0);
            dJF();
            return;
        }
        this.mXi.turnOffNoCallback();
        this.mXj.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.mBack.setOnClickListener(msgRemindActivity);
        this.mWV.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mWX.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mWW.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mWY.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mWZ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mXa.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mXb.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mXc.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mXd.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mXe.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mXf.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mXg.setOnClickListener(msgRemindActivity);
        this.mXi.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mXj.setOnClickListener(msgRemindActivity);
        this.mXn.setOnClickListener(msgRemindActivity);
        this.mXp.setOnClickListener(msgRemindActivity);
        this.mXt.setOnClickListener(msgRemindActivity);
        this.mNavigationBar.getCenterText().setOnClickListener(msgRemindActivity);
    }

    public void xB(boolean z) {
        this.mXi.setLineVisibility(z);
        if (z) {
            this.mXj.setVisibility(0);
            dJF();
            ap.setBackgroundResource(this.mXj, R.drawable.more_all);
            return;
        }
        this.mXj.setVisibility(8);
    }

    public void xC(boolean z) {
        if (z) {
            this.mXg.setVisibility(0);
            this.mXf.setLineVisibility(true);
            ap.setBackgroundResource(this.mXg, R.drawable.more_all);
            return;
        }
        this.mXg.setVisibility(8);
        this.mXf.setLineVisibility(false);
    }

    public void xD(boolean z) {
    }

    public void dJE() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bzl().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.d.bzl().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.d.bzl().getSignAlertMins();
            this.mXh.setText(this.mXs.getString(R.string.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.mXg.setVisibility(0);
            if (!this.mXf.isOn()) {
                this.mXf.turnOnNoCallback();
                return;
            }
            return;
        }
        this.mXh.setText(R.string.close);
        this.mXg.setVisibility(8);
        if (this.mXf.isOn()) {
            this.mXf.turnOffNoCallback();
        }
    }

    public void dJF() {
        String bzy = com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzy();
        String bzz = com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzz();
        this.mXk.setText(bzy + Constants.ACCEPT_TIME_SEPARATOR_SERVER + bzz);
        this.mXo.setText(bzy);
        this.mXq.setText(bzz);
    }

    public BdSwitchView dJG() {
        return this.mXf.getSwitchView();
    }

    public BdSwitchView dJH() {
        return this.mWT.getSwitchView();
    }

    public View dJI() {
        return this.mXg;
    }

    public BdSwitchView dJJ() {
        return this.mXi.getSwitchView();
    }

    public View dJK() {
        return this.mXj;
    }

    public LinearLayout dJL() {
        return this.mXn;
    }

    public LinearLayout dJM() {
        return this.mXp;
    }

    public BdSwitchView dJN() {
        return this.mXc.getSwitchView();
    }

    public BdSwitchView dJO() {
        return this.mXd.getSwitchView();
    }

    public BdSwitchView dJP() {
        return this.mXe.getSwitchView();
    }

    public BdSwitchView dJQ() {
        return this.mXb.getSwitchView();
    }

    public BdSwitchView dJR() {
        return this.mWV.getSwitchView();
    }

    public BdSwitchView dJS() {
        return this.mWW.getSwitchView();
    }

    public BdSwitchView dJT() {
        return this.mWX.getSwitchView();
    }

    public BdSwitchView dJU() {
        return this.mWZ.getSwitchView();
    }

    public BdSwitchView dJV() {
        return this.mXa.getSwitchView();
    }

    public BdSwitchView dJW() {
        return this.mWY.getSwitchView();
    }

    public TbSettingTextTipView dJX() {
        return this.mXt;
    }

    public TextView dJY() {
        return this.mNavigationBar.getCenterText();
    }

    public void dJZ() {
        this.mWV.setOnSwitchStateChangeListener(null);
        this.mWV.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzs());
        this.mWV.setOnSwitchStateChangeListener(this.mXs);
    }

    public void dKa() {
        this.mWW.setOnSwitchStateChangeListener(null);
        this.mWW.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzC());
        this.mWW.setOnSwitchStateChangeListener(this.mXs);
    }

    public void dKb() {
        this.mWX.setOnSwitchStateChangeListener(null);
        this.mWX.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzq());
        this.mWX.setOnSwitchStateChangeListener(this.mXs);
    }

    public void dKc() {
        this.mWY.setOnSwitchStateChangeListener(null);
        this.mWY.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzr());
        this.mWY.setOnSwitchStateChangeListener(this.mXs);
    }

    public void dKd() {
        this.mWZ.setOnSwitchStateChangeListener(null);
        this.mWZ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzt());
        this.mWZ.setOnSwitchStateChangeListener(this.mXs);
    }

    public void dKe() {
        this.mXa.setOnSwitchStateChangeListener(null);
        this.mXa.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzB());
        this.mXa.setOnSwitchStateChangeListener(this.mXs);
    }

    public void xE(boolean z) {
        if (this.mXr != z) {
            this.mXr = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.mXs.getString(R.string.msg_remind));
                this.mXl.setVisibility(0);
                this.mXm.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.mXs.getString(R.string.no_disturb_mode_time));
            this.mXm.setVisibility(0);
            this.mXl.setVisibility(8);
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
        this.mXs.getLayoutMode().setNightMode(i == 1);
        this.mXs.getLayoutMode().onModeChanged(this.iIW);
        this.mNavigationBar.onChangeSkinType(this.mXs.getPageContext(), i);
        this.mWT.onChangeSkinType(this.mXs.getPageContext(), i);
        this.mWV.onChangeSkinType(this.mXs.getPageContext(), i);
        this.mWW.onChangeSkinType(this.mXs.getPageContext(), i);
        this.mWX.onChangeSkinType(this.mXs.getPageContext(), i);
        this.mWY.onChangeSkinType(this.mXs.getPageContext(), i);
        this.mWZ.onChangeSkinType(this.mXs.getPageContext(), i);
        this.mXa.onChangeSkinType(this.mXs.getPageContext(), i);
        this.mXb.onChangeSkinType(this.mXs.getPageContext(), i);
        this.mXc.onChangeSkinType(this.mXs.getPageContext(), i);
        this.mXd.onChangeSkinType(this.mXs.getPageContext(), i);
        this.mXe.onChangeSkinType(this.mXs.getPageContext(), i);
        this.mXf.onChangeSkinType(this.mXs.getPageContext(), i);
        this.mXi.onChangeSkinType(this.mXs.getPageContext(), i);
        this.mWH.onChangeSkinType(this.mXs.getPageContext(), i);
        this.mWI.onChangeSkinType(this.mXs.getPageContext(), i);
        this.mWJ.onChangeSkinType(this.mXs.getPageContext(), i);
        this.mXx.onChangeSkinType(this.mXs.getPageContext(), i);
        ap.setBackgroundResource(this.mXj, R.drawable.more_all);
        ap.setBackgroundResource(this.mXn, R.drawable.more_all);
        ap.setBackgroundResource(this.mXp, R.drawable.more_all);
        ap.setBackgroundResource(this.mXg, R.drawable.more_all);
        SvgManager.btW().a((ImageView) this.mXj.findViewById(R.id.no_disturb_mode_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.btW().a((ImageView) this.mXg.findViewById(R.id.sign_remind_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.btW().a((ImageView) this.mXn.findViewById(R.id.no_disturb_start_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.btW().a((ImageView) this.mXp.findViewById(R.id.no_disturb_end_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
    }

    public BdSwitchView dJp() {
        return this.mWH.getSwitchView();
    }

    public BdSwitchView dJq() {
        return this.mWI.getSwitchView();
    }

    public BdSwitchView dJr() {
        return this.mWJ.getSwitchView();
    }

    public BdSwitchView dKf() {
        return this.mXx.getSwitchView();
    }

    public void xA(boolean z) {
        this.mWH.setLineVisibility(z);
    }

    public void xz(boolean z) {
        if (z) {
            this.mWI.setVisibility(0);
        } else {
            this.mWI.setVisibility(8);
        }
    }

    public void dKg() {
        com.baidu.tbadk.coreExtra.messageCenter.f.bzH().a(this.mXs.getActivity(), this.iIW);
    }

    public void onDestroy() {
    }

    public void onResume() {
        int i;
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.mXs).areNotificationsEnabled();
        if (areNotificationsEnabled) {
            this.mXv.turnOn();
            i = 1;
        } else {
            this.mXv.turnOff();
            i = 2;
        }
        this.mXu.setVisibility(areNotificationsEnabled ? 8 : 0);
        sn(areNotificationsEnabled);
        TiebaStatic.log(new ar("c13889").al("obj_locate", i).al("obj_source", 8));
    }

    private void sn(boolean z) {
        if (z) {
            this.mWV.getSwitchView().setEnabled(true);
            this.mWW.getSwitchView().setEnabled(true);
            this.mWY.getSwitchView().setEnabled(true);
            this.mWX.getSwitchView().setEnabled(true);
            this.mWH.getSwitchView().setEnabled(true);
            this.mWI.getSwitchView().setEnabled(true);
            this.mWJ.getSwitchView().setEnabled(true);
            this.mXx.getSwitchView().setEnabled(true);
            this.mXf.getSwitchView().setEnabled(true);
            this.mXi.getSwitchView().setEnabled(true);
            this.mWV.getSwitchView().setAlpha(1.0f);
            this.mWW.getSwitchView().setAlpha(1.0f);
            this.mWY.getSwitchView().setAlpha(1.0f);
            this.mWX.getSwitchView().setAlpha(1.0f);
            this.mWH.getSwitchView().setAlpha(1.0f);
            this.mWI.getSwitchView().setAlpha(1.0f);
            this.mWJ.getSwitchView().setAlpha(1.0f);
            this.mXx.getSwitchView().setAlpha(1.0f);
            this.mXf.getSwitchView().setAlpha(1.0f);
            this.mXi.getSwitchView().setAlpha(1.0f);
            return;
        }
        this.mWV.getSwitchView().setEnabled(false);
        this.mWW.getSwitchView().setEnabled(false);
        this.mWY.getSwitchView().setEnabled(false);
        this.mWX.getSwitchView().setEnabled(false);
        this.mWH.getSwitchView().setEnabled(false);
        this.mWI.getSwitchView().setEnabled(false);
        this.mWJ.getSwitchView().setEnabled(false);
        this.mXx.getSwitchView().setEnabled(false);
        this.mXf.getSwitchView().setEnabled(false);
        this.mXi.getSwitchView().setEnabled(false);
        this.mWV.getSwitchView().setAlpha(0.3f);
        this.mWW.getSwitchView().setAlpha(0.3f);
        this.mWY.getSwitchView().setAlpha(0.3f);
        this.mWX.getSwitchView().setAlpha(0.3f);
        this.mWH.getSwitchView().setAlpha(0.3f);
        this.mWI.getSwitchView().setAlpha(0.3f);
        this.mWJ.getSwitchView().setAlpha(0.3f);
        this.mXx.getSwitchView().setAlpha(0.3f);
        this.mXf.getSwitchView().setAlpha(0.3f);
        this.mXi.getSwitchView().setAlpha(0.3f);
    }
}
