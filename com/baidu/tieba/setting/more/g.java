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
/* loaded from: classes20.dex */
public class g extends com.baidu.adp.base.c<MsgRemindActivity> {
    private LinearLayout hIS;
    private MsgSettingItemView lQL;
    private MsgSettingItemView lQM;
    private MsgSettingItemView lQN;
    private MsgSettingItemView lQW;
    private LinearLayout lQX;
    private MsgSettingItemView lQY;
    private MsgSettingItemView lQZ;
    private MsgSettingItemView lRA;
    private MsgSettingItemView lRa;
    private MsgSettingItemView lRb;
    private MsgSettingItemView lRc;
    private MsgSettingItemView lRd;
    private MsgSettingItemView lRe;
    private MsgSettingItemView lRf;
    private MsgSettingItemView lRg;
    private MsgSettingItemView lRh;
    private MsgSettingItemView lRi;
    private LinearLayout lRj;
    private TextView lRk;
    private MsgSettingItemView lRl;
    private LinearLayout lRm;
    private TextView lRn;
    private LinearLayout lRo;
    private LinearLayout lRp;
    private LinearLayout lRq;
    private TextView lRr;
    private LinearLayout lRs;
    private TextView lRt;
    public boolean lRu;
    private MsgRemindActivity lRv;
    private TbSettingTextTipView lRw;
    private View lRx;
    private BdSwitchView lRy;
    private View lRz;
    private View mBack;
    private NavigationBar mNavigationBar;

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.hIS = null;
        this.mNavigationBar = null;
        this.lRu = true;
        this.lRv = msgRemindActivity;
        msgRemindActivity.setContentView(R.layout.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        drx();
        drA();
        drz();
        dry();
        drB();
        d(msgRemindActivity);
        drs();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.hIS = (LinearLayout) msgRemindActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(R.string.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.lRo = (LinearLayout) msgRemindActivity.findViewById(R.id.front_container);
        this.lRp = (LinearLayout) msgRemindActivity.findViewById(R.id.back_container);
        this.lQW = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.receive_message_swtich);
        this.lQW.setText(R.string.receive_msg_text);
        this.lQW.setLineVisibility(false);
        this.lQX = (LinearLayout) msgRemindActivity.findViewById(R.id.receive_message_container);
        this.lQY = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.reply_check_box);
        this.lQY.setText(R.string.reply);
        this.lQZ = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.zan_check_box);
        this.lQZ.setVisibility(0);
        this.lQZ.setText(R.string.action_praise_default);
        this.lRa = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.at_me_check_box);
        this.lRa.setText(R.string.mention_atme);
        this.lRb = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.new_fans_swtich);
        this.lRb.setText(R.string.new_fans);
        this.lRc = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.chat_msg_swtich);
        this.lRc.setText(R.string.chat_msg_text);
        this.lRd = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.group_chat_swtich);
        this.lRd.setLineVisibility(false);
        this.lRd.setText(R.string.group_chat_text);
        this.lRe = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.screen_lock_swtich);
        this.lRe.setText(R.string.remind_screen_lock);
        this.lRe.setLineVisibility(false);
        this.lRf = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.tone_remind_swtich);
        this.lRf.setText(R.string.remind_tone);
        this.lRg = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.vibrate_remind_swtich);
        this.lRg.setText(R.string.remind_vibrate);
        this.lRh = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.light_remind_swtich);
        this.lRh.setLineVisibility(true);
        this.lRh.setText(R.string.remind_light);
        this.lRi = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.sign_remind_swtich);
        this.lRi.setText(R.string.sign_remind_outline);
        this.lRj = (LinearLayout) msgRemindActivity.findViewById(R.id.sign_remind);
        this.lRk = (TextView) msgRemindActivity.findViewById(R.id.sign_remind_time);
        this.lRl = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.no_disturb_swtich);
        this.lRl.setText(R.string.no_disturb_mode);
        this.lRl.setLineVisibility(false);
        this.lRm = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_container);
        this.lRn = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_value);
        this.lRq = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_start_time);
        this.lRr = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_start_time_value);
        this.lRs = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_end_time);
        this.lRt = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_end_time_value);
        this.lRw = (TbSettingTextTipView) msgRemindActivity.findViewById(R.id.msg_receive_item_view);
        this.lRx = msgRemindActivity.findViewById(R.id.layout_system_msg_permission);
        boolean areNotificationsEnabled = NotificationManagerCompat.from(msgRemindActivity).areNotificationsEnabled();
        this.lRx.setVisibility(areNotificationsEnabled ? 8 : 0);
        TiebaStatic.log(new aq("c13890").ai("obj_type", areNotificationsEnabled ? 1 : 2));
        this.lRy = (BdSwitchView) msgRemindActivity.findViewById(R.id.system_msg_permission_switch);
        this.lRz = msgRemindActivity.findViewById(R.id.system_msg_permission_switch_cover);
        this.lRz.setOnClickListener(msgRemindActivity);
        this.lQL = (MsgSettingItemView) this.lRv.findViewById(R.id.item_view_friend_msg);
        this.lQL.setText(R.string.friend_msg_switch);
        this.lQL.setOnSwitchStateChangeListener(this.lRv);
        this.lQM = (MsgSettingItemView) this.lRv.findViewById(R.id.item_view_stranger_msg);
        this.lQM.setText(R.string.stranger_msg_switch);
        this.lQM.setOnSwitchStateChangeListener(this.lRv);
        this.lQM.setLineVisibility(false);
        drl();
        this.lQN = (MsgSettingItemView) this.lRv.findViewById(R.id.item_view_forum_broadcast_msg);
        this.lQN.setText(R.string.receive_forum_broadcast_message);
        this.lQN.setOnSwitchStateChangeListener(this.lRv);
        this.lQN.setLineVisibility(false);
        drm();
        this.lRA = (MsgSettingItemView) this.lRv.findViewById(R.id.item_view_tb_selection_msg);
        this.lRA.setText(R.string.official_push_message_switch_text);
        this.lRA.setOnSwitchStateChangeListener(this.lRv);
        this.lRA.setLineVisibility(false);
        drr();
    }

    private void drl() {
        if (this.lQL == null || this.lQM == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.lQL.getSwitchView().turnOnNoCallback();
                this.lQL.setLineVisibility(true);
                this.lQM.getSwitchView().turnOffNoCallback();
                return;
            default:
                this.lQL.getSwitchView().turnOffNoCallback();
                this.lQL.setLineVisibility(false);
                this.lQM.setVisibility(8);
                this.lQM.getSwitchView().turnOffNoCallback();
                return;
        }
    }

    private void drm() {
        if (this.lQN != null) {
            this.lQN.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.boy().boS());
        }
    }

    private void drr() {
        if (this.lRA != null) {
            this.lRA.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.boy().boT());
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
                    if (com.baidu.tbadk.coreExtra.messageCenter.d.boy().boT() != z) {
                        g.this.lRA.setSwitchStateNoCallback(z);
                    }
                }
            }).dsu();
        }
    }

    private void drs() {
        drt();
        dru();
        drv();
        drw();
    }

    private void drt() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.lRl.setVisibility(8);
            this.lRm.setVisibility(8);
            this.lQW.setVisibility(8);
            this.lQX.setVisibility(8);
            this.lRi.setVisibility(8);
            this.lRj.setVisibility(8);
            this.lRf.setVisibility(8);
            this.lRg.setVisibility(8);
            this.lRh.setVisibility(8);
            this.lRe.setVisibility(8);
        }
    }

    private void dru() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.lRe.setLineVisibility(true);
        } else {
            this.lRe.setLineVisibility(false);
        }
    }

    private void drv() {
        this.lRc.setLineVisibility(TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class));
    }

    private void drw() {
        TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class);
    }

    public View OT() {
        return this.mBack;
    }

    private void drx() {
        this.lQY.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.boy().boF());
        this.lQZ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.boy().boP());
        this.lRa.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.boy().boD());
        this.lRb.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.boy().boE());
        this.lRc.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.boy().boG());
        this.lRd.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.boy().boO());
    }

    private void dry() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.boy().isSignAlertOn()) {
            this.lRi.turnOn();
            this.lRj.setVisibility(0);
            this.lRi.setLineVisibility(true);
            drC();
            return;
        }
        this.lRi.turnOff();
        this.lRi.setLineVisibility(false);
        this.lRj.setVisibility(8);
    }

    private void drz() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.boy().boH()) {
            this.lRf.turnOnNoCallback();
        } else {
            this.lRf.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.boy().boK()) {
            this.lRg.turnOnNoCallback();
        } else {
            this.lRg.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.boy().boI()) {
            this.lRh.turnOnNoCallback();
        } else {
            this.lRh.turnOffNoCallback();
        }
    }

    private void drA() {
    }

    private void drB() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.boy().boJ()) {
            this.lRl.turnOnNoCallback();
            this.lRm.setVisibility(0);
            drD();
            return;
        }
        this.lRl.turnOffNoCallback();
        this.lRm.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.mBack.setOnClickListener(msgRemindActivity);
        this.lQY.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lRa.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lQZ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lRb.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lRc.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lRd.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lRe.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lRf.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lRg.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lRh.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lRi.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lRj.setOnClickListener(msgRemindActivity);
        this.lRl.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lRm.setOnClickListener(msgRemindActivity);
        this.lRq.setOnClickListener(msgRemindActivity);
        this.lRs.setOnClickListener(msgRemindActivity);
        this.lRw.setOnClickListener(msgRemindActivity);
        this.mNavigationBar.getCenterText().setOnClickListener(msgRemindActivity);
    }

    public void vF(boolean z) {
        this.lRl.setLineVisibility(z);
        if (z) {
            this.lRm.setVisibility(0);
            drD();
            ap.setBackgroundResource(this.lRm, R.drawable.more_all);
            return;
        }
        this.lRm.setVisibility(8);
    }

    public void vG(boolean z) {
        if (z) {
            this.lRj.setVisibility(0);
            this.lRi.setLineVisibility(true);
            ap.setBackgroundResource(this.lRj, R.drawable.more_all);
            return;
        }
        this.lRj.setVisibility(8);
        this.lRi.setLineVisibility(false);
    }

    public void vH(boolean z) {
    }

    public void drC() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.boy().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.d.boy().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.d.boy().getSignAlertMins();
            this.lRk.setText(this.lRv.getString(R.string.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.lRj.setVisibility(0);
            if (!this.lRi.isOn()) {
                this.lRi.turnOnNoCallback();
                return;
            }
            return;
        }
        this.lRk.setText(R.string.close);
        this.lRj.setVisibility(8);
        if (this.lRi.isOn()) {
            this.lRi.turnOffNoCallback();
        }
    }

    public void drD() {
        String boL = com.baidu.tbadk.coreExtra.messageCenter.d.boy().boL();
        String boM = com.baidu.tbadk.coreExtra.messageCenter.d.boy().boM();
        this.lRn.setText(boL + Constants.ACCEPT_TIME_SEPARATOR_SERVER + boM);
        this.lRr.setText(boL);
        this.lRt.setText(boM);
    }

    public BdSwitchView drE() {
        return this.lRi.getSwitchView();
    }

    public BdSwitchView drF() {
        return this.lQW.getSwitchView();
    }

    public View drG() {
        return this.lRj;
    }

    public BdSwitchView drH() {
        return this.lRl.getSwitchView();
    }

    public View drI() {
        return this.lRm;
    }

    public LinearLayout drJ() {
        return this.lRq;
    }

    public LinearLayout drK() {
        return this.lRs;
    }

    public BdSwitchView drL() {
        return this.lRf.getSwitchView();
    }

    public BdSwitchView drM() {
        return this.lRg.getSwitchView();
    }

    public BdSwitchView drN() {
        return this.lRh.getSwitchView();
    }

    public BdSwitchView drO() {
        return this.lRe.getSwitchView();
    }

    public BdSwitchView drP() {
        return this.lQY.getSwitchView();
    }

    public BdSwitchView drQ() {
        return this.lQZ.getSwitchView();
    }

    public BdSwitchView drR() {
        return this.lRa.getSwitchView();
    }

    public BdSwitchView drS() {
        return this.lRc.getSwitchView();
    }

    public BdSwitchView drT() {
        return this.lRd.getSwitchView();
    }

    public BdSwitchView drU() {
        return this.lRb.getSwitchView();
    }

    public TbSettingTextTipView drV() {
        return this.lRw;
    }

    public TextView drW() {
        return this.mNavigationBar.getCenterText();
    }

    public void drX() {
        this.lQY.setOnSwitchStateChangeListener(null);
        this.lQY.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.boy().boF());
        this.lQY.setOnSwitchStateChangeListener(this.lRv);
    }

    public void drY() {
        this.lQZ.setOnSwitchStateChangeListener(null);
        this.lQZ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.boy().boP());
        this.lQZ.setOnSwitchStateChangeListener(this.lRv);
    }

    public void drZ() {
        this.lRa.setOnSwitchStateChangeListener(null);
        this.lRa.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.boy().boD());
        this.lRa.setOnSwitchStateChangeListener(this.lRv);
    }

    public void dsa() {
        this.lRb.setOnSwitchStateChangeListener(null);
        this.lRb.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.boy().boE());
        this.lRb.setOnSwitchStateChangeListener(this.lRv);
    }

    public void dsb() {
        this.lRc.setOnSwitchStateChangeListener(null);
        this.lRc.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.boy().boG());
        this.lRc.setOnSwitchStateChangeListener(this.lRv);
    }

    public void dsc() {
        this.lRd.setOnSwitchStateChangeListener(null);
        this.lRd.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.boy().boO());
        this.lRd.setOnSwitchStateChangeListener(this.lRv);
    }

    public void vI(boolean z) {
        if (this.lRu != z) {
            this.lRu = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.lRv.getString(R.string.msg_remind));
                this.lRo.setVisibility(0);
                this.lRp.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.lRv.getString(R.string.no_disturb_mode_time));
            this.lRp.setVisibility(0);
            this.lRo.setVisibility(8);
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
        this.lRv.getLayoutMode().setNightMode(i == 1);
        this.lRv.getLayoutMode().onModeChanged(this.hIS);
        this.mNavigationBar.onChangeSkinType(this.lRv.getPageContext(), i);
        this.lQW.onChangeSkinType(this.lRv.getPageContext(), i);
        this.lQY.onChangeSkinType(this.lRv.getPageContext(), i);
        this.lQZ.onChangeSkinType(this.lRv.getPageContext(), i);
        this.lRa.onChangeSkinType(this.lRv.getPageContext(), i);
        this.lRb.onChangeSkinType(this.lRv.getPageContext(), i);
        this.lRc.onChangeSkinType(this.lRv.getPageContext(), i);
        this.lRd.onChangeSkinType(this.lRv.getPageContext(), i);
        this.lRe.onChangeSkinType(this.lRv.getPageContext(), i);
        this.lRf.onChangeSkinType(this.lRv.getPageContext(), i);
        this.lRg.onChangeSkinType(this.lRv.getPageContext(), i);
        this.lRh.onChangeSkinType(this.lRv.getPageContext(), i);
        this.lRi.onChangeSkinType(this.lRv.getPageContext(), i);
        this.lRl.onChangeSkinType(this.lRv.getPageContext(), i);
        this.lQL.onChangeSkinType(this.lRv.getPageContext(), i);
        this.lQM.onChangeSkinType(this.lRv.getPageContext(), i);
        this.lQN.onChangeSkinType(this.lRv.getPageContext(), i);
        this.lRA.onChangeSkinType(this.lRv.getPageContext(), i);
        ap.setBackgroundResource(this.lRm, R.drawable.more_all);
        ap.setBackgroundResource(this.lRq, R.drawable.more_all);
        ap.setBackgroundResource(this.lRs, R.drawable.more_all);
        ap.setBackgroundResource(this.lRj, R.drawable.more_all);
        SvgManager.bjq().a((ImageView) this.lRm.findViewById(R.id.no_disturb_mode_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bjq().a((ImageView) this.lRj.findViewById(R.id.sign_remind_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bjq().a((ImageView) this.lRq.findViewById(R.id.no_disturb_start_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bjq().a((ImageView) this.lRs.findViewById(R.id.no_disturb_end_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
    }

    public BdSwitchView drn() {
        return this.lQL.getSwitchView();
    }

    public BdSwitchView dro() {
        return this.lQM.getSwitchView();
    }

    public BdSwitchView drp() {
        return this.lQN.getSwitchView();
    }

    public BdSwitchView dsd() {
        return this.lRA.getSwitchView();
    }

    public void vE(boolean z) {
        this.lQL.setLineVisibility(z);
    }

    public void vD(boolean z) {
        if (z) {
            this.lQM.setVisibility(0);
        } else {
            this.lQM.setVisibility(8);
        }
    }

    public void dse() {
        com.baidu.tbadk.coreExtra.messageCenter.f.boU().a(this.lRv.getActivity(), this.hIS);
    }

    public void onDestroy() {
    }

    public void onResume() {
        int i;
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.lRv).areNotificationsEnabled();
        if (areNotificationsEnabled) {
            this.lRy.turnOn();
            i = 1;
        } else {
            this.lRy.turnOff();
            i = 2;
        }
        this.lRx.setVisibility(areNotificationsEnabled ? 8 : 0);
        qt(areNotificationsEnabled);
        TiebaStatic.log(new aq("c13889").ai("obj_locate", i).ai("obj_source", 8));
    }

    private void qt(boolean z) {
        if (z) {
            this.lQY.getSwitchView().setEnabled(true);
            this.lQZ.getSwitchView().setEnabled(true);
            this.lRb.getSwitchView().setEnabled(true);
            this.lRa.getSwitchView().setEnabled(true);
            this.lQL.getSwitchView().setEnabled(true);
            this.lQM.getSwitchView().setEnabled(true);
            this.lQN.getSwitchView().setEnabled(true);
            this.lRA.getSwitchView().setEnabled(true);
            this.lRi.getSwitchView().setEnabled(true);
            this.lRl.getSwitchView().setEnabled(true);
            this.lQY.getSwitchView().setAlpha(1.0f);
            this.lQZ.getSwitchView().setAlpha(1.0f);
            this.lRb.getSwitchView().setAlpha(1.0f);
            this.lRa.getSwitchView().setAlpha(1.0f);
            this.lQL.getSwitchView().setAlpha(1.0f);
            this.lQM.getSwitchView().setAlpha(1.0f);
            this.lQN.getSwitchView().setAlpha(1.0f);
            this.lRA.getSwitchView().setAlpha(1.0f);
            this.lRi.getSwitchView().setAlpha(1.0f);
            this.lRl.getSwitchView().setAlpha(1.0f);
            return;
        }
        this.lQY.getSwitchView().setEnabled(false);
        this.lQZ.getSwitchView().setEnabled(false);
        this.lRb.getSwitchView().setEnabled(false);
        this.lRa.getSwitchView().setEnabled(false);
        this.lQL.getSwitchView().setEnabled(false);
        this.lQM.getSwitchView().setEnabled(false);
        this.lQN.getSwitchView().setEnabled(false);
        this.lRA.getSwitchView().setEnabled(false);
        this.lRi.getSwitchView().setEnabled(false);
        this.lRl.getSwitchView().setEnabled(false);
        this.lQY.getSwitchView().setAlpha(0.3f);
        this.lQZ.getSwitchView().setAlpha(0.3f);
        this.lRb.getSwitchView().setAlpha(0.3f);
        this.lRa.getSwitchView().setAlpha(0.3f);
        this.lQL.getSwitchView().setAlpha(0.3f);
        this.lQM.getSwitchView().setAlpha(0.3f);
        this.lQN.getSwitchView().setAlpha(0.3f);
        this.lRA.getSwitchView().setAlpha(0.3f);
        this.lRi.getSwitchView().setAlpha(0.3f);
        this.lRl.getSwitchView().setAlpha(0.3f);
    }
}
