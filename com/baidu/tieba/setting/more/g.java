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
/* loaded from: classes25.dex */
public class g extends com.baidu.adp.base.c<MsgRemindActivity> {
    private LinearLayout iyc;
    private View mBack;
    private MsgSettingItemView mIF;
    private MsgSettingItemView mIG;
    private MsgSettingItemView mIH;
    private MsgSettingItemView mIQ;
    private LinearLayout mIR;
    private MsgSettingItemView mIS;
    private MsgSettingItemView mIT;
    private MsgSettingItemView mIU;
    private MsgSettingItemView mIV;
    private MsgSettingItemView mIW;
    private MsgSettingItemView mIX;
    private MsgSettingItemView mIY;
    private MsgSettingItemView mIZ;
    private MsgSettingItemView mJa;
    private MsgSettingItemView mJb;
    private MsgSettingItemView mJc;
    private LinearLayout mJd;
    private TextView mJe;
    private MsgSettingItemView mJf;
    private LinearLayout mJg;
    private TextView mJh;
    private LinearLayout mJi;
    private LinearLayout mJj;
    private LinearLayout mJk;
    private TextView mJl;
    private LinearLayout mJm;
    private TextView mJn;
    public boolean mJo;
    private MsgRemindActivity mJp;
    private TbSettingTextTipView mJq;
    private View mJr;
    private BdSwitchView mJs;
    private View mJt;
    private MsgSettingItemView mJu;
    private NavigationBar mNavigationBar;

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.iyc = null;
        this.mNavigationBar = null;
        this.mJo = true;
        this.mJp = msgRemindActivity;
        msgRemindActivity.setContentView(R.layout.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        dEn();
        dEq();
        dEp();
        dEo();
        dEr();
        d(msgRemindActivity);
        dEi();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.iyc = (LinearLayout) msgRemindActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(R.string.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mJi = (LinearLayout) msgRemindActivity.findViewById(R.id.front_container);
        this.mJj = (LinearLayout) msgRemindActivity.findViewById(R.id.back_container);
        this.mIQ = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.receive_message_swtich);
        this.mIQ.setText(R.string.receive_msg_text);
        this.mIQ.setLineVisibility(false);
        this.mIR = (LinearLayout) msgRemindActivity.findViewById(R.id.receive_message_container);
        this.mIS = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.reply_check_box);
        this.mIS.setText(R.string.reply);
        this.mIT = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.zan_check_box);
        this.mIT.setVisibility(0);
        this.mIT.setText(R.string.action_praise_default);
        this.mIU = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.at_me_check_box);
        this.mIU.setText(R.string.mention_atme);
        this.mIV = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.new_fans_swtich);
        this.mIV.setText(R.string.new_fans);
        this.mIW = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.chat_msg_swtich);
        this.mIW.setText(R.string.chat_msg_text);
        this.mIX = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.group_chat_swtich);
        this.mIX.setLineVisibility(false);
        this.mIX.setText(R.string.group_chat_text);
        this.mIY = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.screen_lock_swtich);
        this.mIY.setText(R.string.remind_screen_lock);
        this.mIY.setLineVisibility(false);
        this.mIZ = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.tone_remind_swtich);
        this.mIZ.setText(R.string.remind_tone);
        this.mJa = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.vibrate_remind_swtich);
        this.mJa.setText(R.string.remind_vibrate);
        this.mJb = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.light_remind_swtich);
        this.mJb.setLineVisibility(true);
        this.mJb.setText(R.string.remind_light);
        this.mJc = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.sign_remind_swtich);
        this.mJc.setText(R.string.sign_remind_outline);
        this.mJd = (LinearLayout) msgRemindActivity.findViewById(R.id.sign_remind);
        this.mJe = (TextView) msgRemindActivity.findViewById(R.id.sign_remind_time);
        this.mJf = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.no_disturb_swtich);
        this.mJf.setText(R.string.no_disturb_mode);
        this.mJf.setLineVisibility(false);
        this.mJg = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_container);
        this.mJh = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_value);
        this.mJk = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_start_time);
        this.mJl = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_start_time_value);
        this.mJm = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_end_time);
        this.mJn = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_end_time_value);
        this.mJq = (TbSettingTextTipView) msgRemindActivity.findViewById(R.id.msg_receive_item_view);
        this.mJr = msgRemindActivity.findViewById(R.id.layout_system_msg_permission);
        boolean areNotificationsEnabled = NotificationManagerCompat.from(msgRemindActivity).areNotificationsEnabled();
        this.mJr.setVisibility(areNotificationsEnabled ? 8 : 0);
        TiebaStatic.log(new ar("c13890").ak("obj_type", areNotificationsEnabled ? 1 : 2));
        this.mJs = (BdSwitchView) msgRemindActivity.findViewById(R.id.system_msg_permission_switch);
        this.mJt = msgRemindActivity.findViewById(R.id.system_msg_permission_switch_cover);
        this.mJt.setOnClickListener(msgRemindActivity);
        this.mIF = (MsgSettingItemView) this.mJp.findViewById(R.id.item_view_friend_msg);
        this.mIF.setText(R.string.friend_msg_switch);
        this.mIF.setOnSwitchStateChangeListener(this.mJp);
        this.mIG = (MsgSettingItemView) this.mJp.findViewById(R.id.item_view_stranger_msg);
        this.mIG.setText(R.string.stranger_msg_switch);
        this.mIG.setOnSwitchStateChangeListener(this.mJp);
        this.mIG.setLineVisibility(false);
        dEb();
        this.mIH = (MsgSettingItemView) this.mJp.findViewById(R.id.item_view_forum_broadcast_msg);
        this.mIH.setText(R.string.receive_forum_broadcast_message);
        this.mIH.setOnSwitchStateChangeListener(this.mJp);
        this.mIH.setLineVisibility(false);
        dEc();
        this.mJu = (MsgSettingItemView) this.mJp.findViewById(R.id.item_view_tb_selection_msg);
        this.mJu.setText(R.string.official_push_message_switch_text);
        this.mJu.setOnSwitchStateChangeListener(this.mJp);
        this.mJu.setLineVisibility(false);
        dEh();
    }

    private void dEb() {
        if (this.mIF == null || this.mIG == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.mIF.getSwitchView().turnOnNoCallback();
                this.mIF.setLineVisibility(true);
                this.mIG.getSwitchView().turnOffNoCallback();
                return;
            default:
                this.mIF.getSwitchView().turnOffNoCallback();
                this.mIF.setLineVisibility(false);
                this.mIG.setVisibility(8);
                this.mIG.getSwitchView().turnOffNoCallback();
                return;
        }
    }

    private void dEc() {
        if (this.mIH != null) {
            this.mIH.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bvL().bwf());
        }
    }

    private void dEh() {
        if (this.mJu != null) {
            this.mJu.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bvL().bwg());
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
                    if (com.baidu.tbadk.coreExtra.messageCenter.d.bvL().bwg() != z) {
                        g.this.mJu.setSwitchStateNoCallback(z);
                    }
                }
            }).dFt();
        }
    }

    private void dEi() {
        dEj();
        dEk();
        dEl();
        dEm();
    }

    private void dEj() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.mJf.setVisibility(8);
            this.mJg.setVisibility(8);
            this.mIQ.setVisibility(8);
            this.mIR.setVisibility(8);
            this.mJc.setVisibility(8);
            this.mJd.setVisibility(8);
            this.mIZ.setVisibility(8);
            this.mJa.setVisibility(8);
            this.mJb.setVisibility(8);
            this.mIY.setVisibility(8);
        }
    }

    private void dEk() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.mIY.setLineVisibility(true);
        } else {
            this.mIY.setLineVisibility(false);
        }
    }

    private void dEl() {
        this.mIW.setLineVisibility(TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class));
    }

    private void dEm() {
        TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class);
    }

    public View Tv() {
        return this.mBack;
    }

    private void dEn() {
        this.mIS.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bvL().bvS());
        this.mIT.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bvL().bwc());
        this.mIU.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bvL().bvQ());
        this.mIV.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bvL().bvR());
        this.mIW.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bvL().bvT());
        this.mIX.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bvL().bwb());
    }

    private void dEo() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bvL().isSignAlertOn()) {
            this.mJc.turnOn();
            this.mJd.setVisibility(0);
            this.mJc.setLineVisibility(true);
            dEs();
            return;
        }
        this.mJc.turnOff();
        this.mJc.setLineVisibility(false);
        this.mJd.setVisibility(8);
    }

    private void dEp() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bvL().bvU()) {
            this.mIZ.turnOnNoCallback();
        } else {
            this.mIZ.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bvL().bvX()) {
            this.mJa.turnOnNoCallback();
        } else {
            this.mJa.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bvL().bvV()) {
            this.mJb.turnOnNoCallback();
        } else {
            this.mJb.turnOffNoCallback();
        }
    }

    private void dEq() {
    }

    private void dEr() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bvL().bvW()) {
            this.mJf.turnOnNoCallback();
            this.mJg.setVisibility(0);
            dEt();
            return;
        }
        this.mJf.turnOffNoCallback();
        this.mJg.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.mBack.setOnClickListener(msgRemindActivity);
        this.mIS.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mIU.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mIT.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mIV.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mIW.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mIX.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mIY.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mIZ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mJa.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mJb.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mJc.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mJd.setOnClickListener(msgRemindActivity);
        this.mJf.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mJg.setOnClickListener(msgRemindActivity);
        this.mJk.setOnClickListener(msgRemindActivity);
        this.mJm.setOnClickListener(msgRemindActivity);
        this.mJq.setOnClickListener(msgRemindActivity);
        this.mNavigationBar.getCenterText().setOnClickListener(msgRemindActivity);
    }

    public void wX(boolean z) {
        this.mJf.setLineVisibility(z);
        if (z) {
            this.mJg.setVisibility(0);
            dEt();
            ap.setBackgroundResource(this.mJg, R.drawable.more_all);
            return;
        }
        this.mJg.setVisibility(8);
    }

    public void wY(boolean z) {
        if (z) {
            this.mJd.setVisibility(0);
            this.mJc.setLineVisibility(true);
            ap.setBackgroundResource(this.mJd, R.drawable.more_all);
            return;
        }
        this.mJd.setVisibility(8);
        this.mJc.setLineVisibility(false);
    }

    public void wZ(boolean z) {
    }

    public void dEs() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bvL().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.d.bvL().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.d.bvL().getSignAlertMins();
            this.mJe.setText(this.mJp.getString(R.string.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.mJd.setVisibility(0);
            if (!this.mJc.isOn()) {
                this.mJc.turnOnNoCallback();
                return;
            }
            return;
        }
        this.mJe.setText(R.string.close);
        this.mJd.setVisibility(8);
        if (this.mJc.isOn()) {
            this.mJc.turnOffNoCallback();
        }
    }

    public void dEt() {
        String bvY = com.baidu.tbadk.coreExtra.messageCenter.d.bvL().bvY();
        String bvZ = com.baidu.tbadk.coreExtra.messageCenter.d.bvL().bvZ();
        this.mJh.setText(bvY + Constants.ACCEPT_TIME_SEPARATOR_SERVER + bvZ);
        this.mJl.setText(bvY);
        this.mJn.setText(bvZ);
    }

    public BdSwitchView dEu() {
        return this.mJc.getSwitchView();
    }

    public BdSwitchView dEv() {
        return this.mIQ.getSwitchView();
    }

    public View dEw() {
        return this.mJd;
    }

    public BdSwitchView dEx() {
        return this.mJf.getSwitchView();
    }

    public View dEy() {
        return this.mJg;
    }

    public LinearLayout dEz() {
        return this.mJk;
    }

    public LinearLayout dEA() {
        return this.mJm;
    }

    public BdSwitchView dEB() {
        return this.mIZ.getSwitchView();
    }

    public BdSwitchView dEC() {
        return this.mJa.getSwitchView();
    }

    public BdSwitchView dED() {
        return this.mJb.getSwitchView();
    }

    public BdSwitchView dEE() {
        return this.mIY.getSwitchView();
    }

    public BdSwitchView dEF() {
        return this.mIS.getSwitchView();
    }

    public BdSwitchView dEG() {
        return this.mIT.getSwitchView();
    }

    public BdSwitchView dEH() {
        return this.mIU.getSwitchView();
    }

    public BdSwitchView dEI() {
        return this.mIW.getSwitchView();
    }

    public BdSwitchView dEJ() {
        return this.mIX.getSwitchView();
    }

    public BdSwitchView dEK() {
        return this.mIV.getSwitchView();
    }

    public TbSettingTextTipView dEL() {
        return this.mJq;
    }

    public TextView dEM() {
        return this.mNavigationBar.getCenterText();
    }

    public void dEN() {
        this.mIS.setOnSwitchStateChangeListener(null);
        this.mIS.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bvL().bvS());
        this.mIS.setOnSwitchStateChangeListener(this.mJp);
    }

    public void dEO() {
        this.mIT.setOnSwitchStateChangeListener(null);
        this.mIT.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bvL().bwc());
        this.mIT.setOnSwitchStateChangeListener(this.mJp);
    }

    public void dEP() {
        this.mIU.setOnSwitchStateChangeListener(null);
        this.mIU.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bvL().bvQ());
        this.mIU.setOnSwitchStateChangeListener(this.mJp);
    }

    public void dEQ() {
        this.mIV.setOnSwitchStateChangeListener(null);
        this.mIV.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bvL().bvR());
        this.mIV.setOnSwitchStateChangeListener(this.mJp);
    }

    public void dER() {
        this.mIW.setOnSwitchStateChangeListener(null);
        this.mIW.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bvL().bvT());
        this.mIW.setOnSwitchStateChangeListener(this.mJp);
    }

    public void dES() {
        this.mIX.setOnSwitchStateChangeListener(null);
        this.mIX.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bvL().bwb());
        this.mIX.setOnSwitchStateChangeListener(this.mJp);
    }

    public void xa(boolean z) {
        if (this.mJo != z) {
            this.mJo = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.mJp.getString(R.string.msg_remind));
                this.mJi.setVisibility(0);
                this.mJj.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.mJp.getString(R.string.no_disturb_mode_time));
            this.mJj.setVisibility(0);
            this.mJi.setVisibility(8);
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
        this.mJp.getLayoutMode().setNightMode(i == 1);
        this.mJp.getLayoutMode().onModeChanged(this.iyc);
        this.mNavigationBar.onChangeSkinType(this.mJp.getPageContext(), i);
        this.mIQ.onChangeSkinType(this.mJp.getPageContext(), i);
        this.mIS.onChangeSkinType(this.mJp.getPageContext(), i);
        this.mIT.onChangeSkinType(this.mJp.getPageContext(), i);
        this.mIU.onChangeSkinType(this.mJp.getPageContext(), i);
        this.mIV.onChangeSkinType(this.mJp.getPageContext(), i);
        this.mIW.onChangeSkinType(this.mJp.getPageContext(), i);
        this.mIX.onChangeSkinType(this.mJp.getPageContext(), i);
        this.mIY.onChangeSkinType(this.mJp.getPageContext(), i);
        this.mIZ.onChangeSkinType(this.mJp.getPageContext(), i);
        this.mJa.onChangeSkinType(this.mJp.getPageContext(), i);
        this.mJb.onChangeSkinType(this.mJp.getPageContext(), i);
        this.mJc.onChangeSkinType(this.mJp.getPageContext(), i);
        this.mJf.onChangeSkinType(this.mJp.getPageContext(), i);
        this.mIF.onChangeSkinType(this.mJp.getPageContext(), i);
        this.mIG.onChangeSkinType(this.mJp.getPageContext(), i);
        this.mIH.onChangeSkinType(this.mJp.getPageContext(), i);
        this.mJu.onChangeSkinType(this.mJp.getPageContext(), i);
        ap.setBackgroundResource(this.mJg, R.drawable.more_all);
        ap.setBackgroundResource(this.mJk, R.drawable.more_all);
        ap.setBackgroundResource(this.mJm, R.drawable.more_all);
        ap.setBackgroundResource(this.mJd, R.drawable.more_all);
        SvgManager.bqB().a((ImageView) this.mJg.findViewById(R.id.no_disturb_mode_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bqB().a((ImageView) this.mJd.findViewById(R.id.sign_remind_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bqB().a((ImageView) this.mJk.findViewById(R.id.no_disturb_start_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bqB().a((ImageView) this.mJm.findViewById(R.id.no_disturb_end_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
    }

    public BdSwitchView dEd() {
        return this.mIF.getSwitchView();
    }

    public BdSwitchView dEe() {
        return this.mIG.getSwitchView();
    }

    public BdSwitchView dEf() {
        return this.mIH.getSwitchView();
    }

    public BdSwitchView dET() {
        return this.mJu.getSwitchView();
    }

    public void wW(boolean z) {
        this.mIF.setLineVisibility(z);
    }

    public void wV(boolean z) {
        if (z) {
            this.mIG.setVisibility(0);
        } else {
            this.mIG.setVisibility(8);
        }
    }

    public void dEU() {
        com.baidu.tbadk.coreExtra.messageCenter.f.bwh().a(this.mJp.getActivity(), this.iyc);
    }

    public void onDestroy() {
    }

    public void onResume() {
        int i;
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.mJp).areNotificationsEnabled();
        if (areNotificationsEnabled) {
            this.mJs.turnOn();
            i = 1;
        } else {
            this.mJs.turnOff();
            i = 2;
        }
        this.mJr.setVisibility(areNotificationsEnabled ? 8 : 0);
        rL(areNotificationsEnabled);
        TiebaStatic.log(new ar("c13889").ak("obj_locate", i).ak("obj_source", 8));
    }

    private void rL(boolean z) {
        if (z) {
            this.mIS.getSwitchView().setEnabled(true);
            this.mIT.getSwitchView().setEnabled(true);
            this.mIV.getSwitchView().setEnabled(true);
            this.mIU.getSwitchView().setEnabled(true);
            this.mIF.getSwitchView().setEnabled(true);
            this.mIG.getSwitchView().setEnabled(true);
            this.mIH.getSwitchView().setEnabled(true);
            this.mJu.getSwitchView().setEnabled(true);
            this.mJc.getSwitchView().setEnabled(true);
            this.mJf.getSwitchView().setEnabled(true);
            this.mIS.getSwitchView().setAlpha(1.0f);
            this.mIT.getSwitchView().setAlpha(1.0f);
            this.mIV.getSwitchView().setAlpha(1.0f);
            this.mIU.getSwitchView().setAlpha(1.0f);
            this.mIF.getSwitchView().setAlpha(1.0f);
            this.mIG.getSwitchView().setAlpha(1.0f);
            this.mIH.getSwitchView().setAlpha(1.0f);
            this.mJu.getSwitchView().setAlpha(1.0f);
            this.mJc.getSwitchView().setAlpha(1.0f);
            this.mJf.getSwitchView().setAlpha(1.0f);
            return;
        }
        this.mIS.getSwitchView().setEnabled(false);
        this.mIT.getSwitchView().setEnabled(false);
        this.mIV.getSwitchView().setEnabled(false);
        this.mIU.getSwitchView().setEnabled(false);
        this.mIF.getSwitchView().setEnabled(false);
        this.mIG.getSwitchView().setEnabled(false);
        this.mIH.getSwitchView().setEnabled(false);
        this.mJu.getSwitchView().setEnabled(false);
        this.mJc.getSwitchView().setEnabled(false);
        this.mJf.getSwitchView().setEnabled(false);
        this.mIS.getSwitchView().setAlpha(0.3f);
        this.mIT.getSwitchView().setAlpha(0.3f);
        this.mIV.getSwitchView().setAlpha(0.3f);
        this.mIU.getSwitchView().setAlpha(0.3f);
        this.mIF.getSwitchView().setAlpha(0.3f);
        this.mIG.getSwitchView().setAlpha(0.3f);
        this.mIH.getSwitchView().setAlpha(0.3f);
        this.mJu.getSwitchView().setAlpha(0.3f);
        this.mJc.getSwitchView().setAlpha(0.3f);
        this.mJf.getSwitchView().setAlpha(0.3f);
    }
}
