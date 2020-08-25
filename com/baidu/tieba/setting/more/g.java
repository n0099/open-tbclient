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
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes20.dex */
public class g extends com.baidu.adp.base.c<MsgRemindActivity> {
    private LinearLayout hIM;
    private MsgSettingItemView lQA;
    private MsgSettingItemView lQJ;
    private LinearLayout lQK;
    private MsgSettingItemView lQL;
    private MsgSettingItemView lQM;
    private MsgSettingItemView lQN;
    private MsgSettingItemView lQO;
    private MsgSettingItemView lQP;
    private MsgSettingItemView lQQ;
    private MsgSettingItemView lQR;
    private MsgSettingItemView lQS;
    private MsgSettingItemView lQT;
    private MsgSettingItemView lQU;
    private MsgSettingItemView lQV;
    private LinearLayout lQW;
    private TextView lQX;
    private MsgSettingItemView lQY;
    private LinearLayout lQZ;
    private MsgSettingItemView lQy;
    private MsgSettingItemView lQz;
    private TextView lRa;
    private LinearLayout lRb;
    private LinearLayout lRc;
    private LinearLayout lRd;
    private TextView lRe;
    private LinearLayout lRf;
    private TextView lRg;
    public boolean lRh;
    private MsgRemindActivity lRi;
    private TbSettingTextTipView lRj;
    private View lRk;
    private BdSwitchView lRl;
    private View lRm;
    private View mBack;
    private NavigationBar mNavigationBar;

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.hIM = null;
        this.mNavigationBar = null;
        this.lRh = true;
        this.lRi = msgRemindActivity;
        msgRemindActivity.setContentView(R.layout.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        drt();
        drw();
        drv();
        dru();
        drx();
        d(msgRemindActivity);
        dro();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.hIM = (LinearLayout) msgRemindActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(R.string.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.lRb = (LinearLayout) msgRemindActivity.findViewById(R.id.front_container);
        this.lRc = (LinearLayout) msgRemindActivity.findViewById(R.id.back_container);
        this.lQJ = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.receive_message_swtich);
        this.lQJ.setText(R.string.receive_msg_text);
        this.lQJ.setLineVisibility(false);
        this.lQK = (LinearLayout) msgRemindActivity.findViewById(R.id.receive_message_container);
        this.lQL = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.reply_check_box);
        this.lQL.setText(R.string.reply);
        this.lQM = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.zan_check_box);
        this.lQM.setVisibility(0);
        this.lQM.setText(R.string.action_praise_default);
        this.lQN = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.at_me_check_box);
        this.lQN.setText(R.string.mention_atme);
        this.lQO = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.new_fans_swtich);
        this.lQO.setText(R.string.new_fans);
        this.lQP = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.chat_msg_swtich);
        this.lQP.setText(R.string.chat_msg_text);
        this.lQQ = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.group_chat_swtich);
        this.lQQ.setLineVisibility(false);
        this.lQQ.setText(R.string.group_chat_text);
        this.lQR = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.screen_lock_swtich);
        this.lQR.setText(R.string.remind_screen_lock);
        this.lQR.setLineVisibility(false);
        this.lQS = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.tone_remind_swtich);
        this.lQS.setText(R.string.remind_tone);
        this.lQT = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.vibrate_remind_swtich);
        this.lQT.setText(R.string.remind_vibrate);
        this.lQU = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.light_remind_swtich);
        this.lQU.setLineVisibility(true);
        this.lQU.setText(R.string.remind_light);
        this.lQV = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.sign_remind_swtich);
        this.lQV.setText(R.string.sign_remind_outline);
        this.lQW = (LinearLayout) msgRemindActivity.findViewById(R.id.sign_remind);
        this.lQX = (TextView) msgRemindActivity.findViewById(R.id.sign_remind_time);
        this.lQY = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.no_disturb_swtich);
        this.lQY.setText(R.string.no_disturb_mode);
        this.lQY.setLineVisibility(false);
        this.lQZ = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_container);
        this.lRa = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_value);
        this.lRd = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_start_time);
        this.lRe = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_start_time_value);
        this.lRf = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_end_time);
        this.lRg = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_end_time_value);
        this.lRj = (TbSettingTextTipView) msgRemindActivity.findViewById(R.id.msg_receive_item_view);
        this.lRk = msgRemindActivity.findViewById(R.id.layout_system_msg_permission);
        boolean areNotificationsEnabled = NotificationManagerCompat.from(msgRemindActivity).areNotificationsEnabled();
        this.lRk.setVisibility(areNotificationsEnabled ? 8 : 0);
        TiebaStatic.log(new aq("c13890").ai("obj_type", areNotificationsEnabled ? 1 : 2));
        this.lRl = (BdSwitchView) msgRemindActivity.findViewById(R.id.system_msg_permission_switch);
        this.lRm = msgRemindActivity.findViewById(R.id.system_msg_permission_switch_cover);
        this.lRm.setOnClickListener(msgRemindActivity);
        this.lQy = (MsgSettingItemView) this.lRi.findViewById(R.id.item_view_friend_msg);
        this.lQy.setText(R.string.friend_msg_switch);
        this.lQy.setOnSwitchStateChangeListener(this.lRi);
        this.lQz = (MsgSettingItemView) this.lRi.findViewById(R.id.item_view_stranger_msg);
        this.lQz.setText(R.string.stranger_msg_switch);
        this.lQz.setOnSwitchStateChangeListener(this.lRi);
        this.lQz.setLineVisibility(false);
        dri();
        this.lQA = (MsgSettingItemView) this.lRi.findViewById(R.id.item_view_forum_broadcast_msg);
        this.lQA.setText(R.string.receive_forum_broadcast_message);
        this.lQA.setOnSwitchStateChangeListener(this.lRi);
        this.lQA.setLineVisibility(false);
        drj();
    }

    private void dri() {
        if (this.lQy == null || this.lQz == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.lQy.getSwitchView().turnOnNoCallback();
                this.lQy.setLineVisibility(true);
                this.lQz.getSwitchView().turnOffNoCallback();
                return;
            default:
                this.lQy.getSwitchView().turnOffNoCallback();
                this.lQy.setLineVisibility(false);
                this.lQz.setVisibility(8);
                this.lQz.getSwitchView().turnOffNoCallback();
                return;
        }
    }

    private void drj() {
        if (this.lQA != null) {
            this.lQA.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.boy().boS());
        }
    }

    private void dro() {
        drp();
        drq();
        drr();
        drs();
    }

    private void drp() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.lQY.setVisibility(8);
            this.lQZ.setVisibility(8);
            this.lQJ.setVisibility(8);
            this.lQK.setVisibility(8);
            this.lQV.setVisibility(8);
            this.lQW.setVisibility(8);
            this.lQS.setVisibility(8);
            this.lQT.setVisibility(8);
            this.lQU.setVisibility(8);
            this.lQR.setVisibility(8);
        }
    }

    private void drq() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.lQR.setLineVisibility(true);
        } else {
            this.lQR.setLineVisibility(false);
        }
    }

    private void drr() {
        this.lQP.setLineVisibility(TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class));
    }

    private void drs() {
        TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class);
    }

    public View OT() {
        return this.mBack;
    }

    private void drt() {
        this.lQL.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.boy().boF());
        this.lQM.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.boy().boP());
        this.lQN.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.boy().boD());
        this.lQO.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.boy().boE());
        this.lQP.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.boy().boG());
        this.lQQ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.boy().boO());
    }

    private void dru() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.boy().isSignAlertOn()) {
            this.lQV.turnOn();
            this.lQW.setVisibility(0);
            this.lQV.setLineVisibility(true);
            dry();
            return;
        }
        this.lQV.turnOff();
        this.lQV.setLineVisibility(false);
        this.lQW.setVisibility(8);
    }

    private void drv() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.boy().boH()) {
            this.lQS.turnOnNoCallback();
        } else {
            this.lQS.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.boy().boK()) {
            this.lQT.turnOnNoCallback();
        } else {
            this.lQT.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.boy().boI()) {
            this.lQU.turnOnNoCallback();
        } else {
            this.lQU.turnOffNoCallback();
        }
    }

    private void drw() {
    }

    private void drx() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.boy().boJ()) {
            this.lQY.turnOnNoCallback();
            this.lQZ.setVisibility(0);
            drz();
            return;
        }
        this.lQY.turnOffNoCallback();
        this.lQZ.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.mBack.setOnClickListener(msgRemindActivity);
        this.lQL.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lQN.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lQM.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lQO.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lQP.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lQQ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lQR.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lQS.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lQT.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lQU.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lQV.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lQW.setOnClickListener(msgRemindActivity);
        this.lQY.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lQZ.setOnClickListener(msgRemindActivity);
        this.lRd.setOnClickListener(msgRemindActivity);
        this.lRf.setOnClickListener(msgRemindActivity);
        this.lRj.setOnClickListener(msgRemindActivity);
        this.mNavigationBar.getCenterText().setOnClickListener(msgRemindActivity);
    }

    public void vD(boolean z) {
        this.lQY.setLineVisibility(z);
        if (z) {
            this.lQZ.setVisibility(0);
            drz();
            ap.setBackgroundResource(this.lQZ, R.drawable.more_all);
            return;
        }
        this.lQZ.setVisibility(8);
    }

    public void vE(boolean z) {
        if (z) {
            this.lQW.setVisibility(0);
            this.lQV.setLineVisibility(true);
            ap.setBackgroundResource(this.lQW, R.drawable.more_all);
            return;
        }
        this.lQW.setVisibility(8);
        this.lQV.setLineVisibility(false);
    }

    public void vF(boolean z) {
    }

    public void dry() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.boy().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.d.boy().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.d.boy().getSignAlertMins();
            this.lQX.setText(this.lRi.getString(R.string.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.lQW.setVisibility(0);
            if (!this.lQV.isOn()) {
                this.lQV.turnOnNoCallback();
                return;
            }
            return;
        }
        this.lQX.setText(R.string.close);
        this.lQW.setVisibility(8);
        if (this.lQV.isOn()) {
            this.lQV.turnOffNoCallback();
        }
    }

    public void drz() {
        String boL = com.baidu.tbadk.coreExtra.messageCenter.d.boy().boL();
        String boM = com.baidu.tbadk.coreExtra.messageCenter.d.boy().boM();
        this.lRa.setText(boL + Constants.ACCEPT_TIME_SEPARATOR_SERVER + boM);
        this.lRe.setText(boL);
        this.lRg.setText(boM);
    }

    public BdSwitchView drA() {
        return this.lQV.getSwitchView();
    }

    public BdSwitchView drB() {
        return this.lQJ.getSwitchView();
    }

    public View drC() {
        return this.lQW;
    }

    public BdSwitchView drD() {
        return this.lQY.getSwitchView();
    }

    public View drE() {
        return this.lQZ;
    }

    public LinearLayout drF() {
        return this.lRd;
    }

    public LinearLayout drG() {
        return this.lRf;
    }

    public BdSwitchView drH() {
        return this.lQS.getSwitchView();
    }

    public BdSwitchView drI() {
        return this.lQT.getSwitchView();
    }

    public BdSwitchView drJ() {
        return this.lQU.getSwitchView();
    }

    public BdSwitchView drK() {
        return this.lQR.getSwitchView();
    }

    public BdSwitchView drL() {
        return this.lQL.getSwitchView();
    }

    public BdSwitchView drM() {
        return this.lQM.getSwitchView();
    }

    public BdSwitchView drN() {
        return this.lQN.getSwitchView();
    }

    public BdSwitchView drO() {
        return this.lQP.getSwitchView();
    }

    public BdSwitchView drP() {
        return this.lQQ.getSwitchView();
    }

    public BdSwitchView drQ() {
        return this.lQO.getSwitchView();
    }

    public TbSettingTextTipView drR() {
        return this.lRj;
    }

    public TextView drS() {
        return this.mNavigationBar.getCenterText();
    }

    public void drT() {
        this.lQL.setOnSwitchStateChangeListener(null);
        this.lQL.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.boy().boF());
        this.lQL.setOnSwitchStateChangeListener(this.lRi);
    }

    public void drU() {
        this.lQM.setOnSwitchStateChangeListener(null);
        this.lQM.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.boy().boP());
        this.lQM.setOnSwitchStateChangeListener(this.lRi);
    }

    public void drV() {
        this.lQN.setOnSwitchStateChangeListener(null);
        this.lQN.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.boy().boD());
        this.lQN.setOnSwitchStateChangeListener(this.lRi);
    }

    public void drW() {
        this.lQO.setOnSwitchStateChangeListener(null);
        this.lQO.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.boy().boE());
        this.lQO.setOnSwitchStateChangeListener(this.lRi);
    }

    public void drX() {
        this.lQP.setOnSwitchStateChangeListener(null);
        this.lQP.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.boy().boG());
        this.lQP.setOnSwitchStateChangeListener(this.lRi);
    }

    public void drY() {
        this.lQQ.setOnSwitchStateChangeListener(null);
        this.lQQ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.boy().boO());
        this.lQQ.setOnSwitchStateChangeListener(this.lRi);
    }

    public void vG(boolean z) {
        if (this.lRh != z) {
            this.lRh = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.lRi.getString(R.string.msg_remind));
                this.lRb.setVisibility(0);
                this.lRc.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.lRi.getString(R.string.no_disturb_mode_time));
            this.lRc.setVisibility(0);
            this.lRb.setVisibility(8);
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
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.lRi.getLayoutMode().setNightMode(i == 1);
        this.lRi.getLayoutMode().onModeChanged(this.hIM);
        this.mNavigationBar.onChangeSkinType(this.lRi.getPageContext(), i);
        this.lQJ.onChangeSkinType(this.lRi.getPageContext(), i);
        this.lQL.onChangeSkinType(this.lRi.getPageContext(), i);
        this.lQM.onChangeSkinType(this.lRi.getPageContext(), i);
        this.lQN.onChangeSkinType(this.lRi.getPageContext(), i);
        this.lQO.onChangeSkinType(this.lRi.getPageContext(), i);
        this.lQP.onChangeSkinType(this.lRi.getPageContext(), i);
        this.lQQ.onChangeSkinType(this.lRi.getPageContext(), i);
        this.lQR.onChangeSkinType(this.lRi.getPageContext(), i);
        this.lQS.onChangeSkinType(this.lRi.getPageContext(), i);
        this.lQT.onChangeSkinType(this.lRi.getPageContext(), i);
        this.lQU.onChangeSkinType(this.lRi.getPageContext(), i);
        this.lQV.onChangeSkinType(this.lRi.getPageContext(), i);
        this.lQY.onChangeSkinType(this.lRi.getPageContext(), i);
        this.lQy.onChangeSkinType(this.lRi.getPageContext(), i);
        this.lQz.onChangeSkinType(this.lRi.getPageContext(), i);
        this.lQA.onChangeSkinType(this.lRi.getPageContext(), i);
        ap.setBackgroundResource(this.lQZ, R.drawable.more_all);
        ap.setBackgroundResource(this.lRd, R.drawable.more_all);
        ap.setBackgroundResource(this.lRf, R.drawable.more_all);
        ap.setBackgroundResource(this.lQW, R.drawable.more_all);
        SvgManager.bjq().a((ImageView) this.lQZ.findViewById(R.id.no_disturb_mode_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bjq().a((ImageView) this.lQW.findViewById(R.id.sign_remind_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bjq().a((ImageView) this.lRd.findViewById(R.id.no_disturb_start_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bjq().a((ImageView) this.lRf.findViewById(R.id.no_disturb_end_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
    }

    public BdSwitchView drk() {
        return this.lQy.getSwitchView();
    }

    public BdSwitchView drl() {
        return this.lQz.getSwitchView();
    }

    public BdSwitchView drm() {
        return this.lQA.getSwitchView();
    }

    public void vC(boolean z) {
        this.lQy.setLineVisibility(z);
    }

    public void vB(boolean z) {
        if (z) {
            this.lQz.setVisibility(0);
        } else {
            this.lQz.setVisibility(8);
        }
    }

    public void drZ() {
        com.baidu.tbadk.coreExtra.messageCenter.f.boT().a(this.lRi.getActivity(), this.hIM);
    }

    public void onDestroy() {
    }

    public void onResume() {
        int i;
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.lRi).areNotificationsEnabled();
        if (areNotificationsEnabled) {
            this.lRl.turnOn();
            i = 1;
        } else {
            this.lRl.turnOff();
            i = 2;
        }
        this.lRk.setVisibility(areNotificationsEnabled ? 8 : 0);
        qr(areNotificationsEnabled);
        TiebaStatic.log(new aq("c13889").ai("obj_locate", i).ai("obj_source", 8));
    }

    private void qr(boolean z) {
        if (z) {
            this.lQL.getSwitchView().setEnabled(true);
            this.lQM.getSwitchView().setEnabled(true);
            this.lQO.getSwitchView().setEnabled(true);
            this.lQN.getSwitchView().setEnabled(true);
            this.lQy.getSwitchView().setEnabled(true);
            this.lQz.getSwitchView().setEnabled(true);
            this.lQA.getSwitchView().setEnabled(true);
            this.lQV.getSwitchView().setEnabled(true);
            this.lQY.getSwitchView().setEnabled(true);
            this.lQL.getSwitchView().setAlpha(1.0f);
            this.lQM.getSwitchView().setAlpha(1.0f);
            this.lQO.getSwitchView().setAlpha(1.0f);
            this.lQN.getSwitchView().setAlpha(1.0f);
            this.lQy.getSwitchView().setAlpha(1.0f);
            this.lQz.getSwitchView().setAlpha(1.0f);
            this.lQA.getSwitchView().setAlpha(1.0f);
            this.lQV.getSwitchView().setAlpha(1.0f);
            this.lQY.getSwitchView().setAlpha(1.0f);
            return;
        }
        this.lQL.getSwitchView().setEnabled(false);
        this.lQM.getSwitchView().setEnabled(false);
        this.lQO.getSwitchView().setEnabled(false);
        this.lQN.getSwitchView().setEnabled(false);
        this.lQy.getSwitchView().setEnabled(false);
        this.lQz.getSwitchView().setEnabled(false);
        this.lQA.getSwitchView().setEnabled(false);
        this.lQV.getSwitchView().setEnabled(false);
        this.lQY.getSwitchView().setEnabled(false);
        this.lQL.getSwitchView().setAlpha(0.3f);
        this.lQM.getSwitchView().setAlpha(0.3f);
        this.lQO.getSwitchView().setAlpha(0.3f);
        this.lQN.getSwitchView().setAlpha(0.3f);
        this.lQy.getSwitchView().setAlpha(0.3f);
        this.lQz.getSwitchView().setAlpha(0.3f);
        this.lQA.getSwitchView().setAlpha(0.3f);
        this.lQV.getSwitchView().setAlpha(0.3f);
        this.lQY.getSwitchView().setAlpha(0.3f);
    }
}
